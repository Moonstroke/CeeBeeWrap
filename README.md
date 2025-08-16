# CeeBeeWrap

𝐶🐝🌯

## Description

CeeBeeWrap provides wrappers for the standard Java generic functional
interfaces, to be used in tests.

### What is a *wrapper*?

In the context of this project, a *wrapper* is any instance which comprises a
function object (referred to as the callback) and provides additional behavior
to it, while being itself an instance of the same functional interface. This
allows such instances to be injected in an instruction where the wrapped object
is passed to take advantage of the added behavior.

### Wrapped functional interfaces

Wrappers are provided for the following functional interfaces:

* `java.util.function.Function`
* `java.util.function.Consumer`
* `java.util.function.Supplier`
* `java.util.function.BiFunction`
* `java.util.function.BiSupplier`

All other functional interfaces can be expressed in terms of these five ones:
for example, (given a generic type parameter `X`) a `Predicate<X>` is
equivalent enough to a `Function<X, Boolean>`. The underlying implementation may
not be exactly identical, and performance may be lower, but as the wrappers are
intended for use in tests, the restriction is acceptable.

Still, if the need arises, wrappers for other functional interfaces may be added.

### Behavior of the wrappers

There are three types of wrappers, distinguished by their behavior.

There are wrappers that **count the number of times they are invoked**. This
count can later be retrieved with a method of the class.

There are wrappers that **fail when they are called more than once**. They fail
by throwing an [assertion error][1].

Wrappers of the last type **fail immediately when invoked**, and are not exactly
wrappers as since they never invoke a callback there is nothing to wrap. Rather,
these are functional placeholders. They fail in the same manner as the previous
wrapper type (by throwing an [assertion error][1]).

There is a public wrapper (or placeholder) class for each of the functional
interfaces listed above.

All these classes are implemented in a thread-safe manner, and can be used to
wrap function objects shared by multiple threads.

## Usage

### As a Maven dependency

This project is deployed in the Maven central repository, and simply needs to be
listed as a test dependency in a user project's POM:

    <dependencies>
    	(...)
    	<dependency>
    		<groupId>io.github.moonstroke</groupId>
    		<artifactId>ceebeewrap</artifactId>
    		<version>0.1</version>
    		<scope>test</scope>
    	</dependency>
    </dependencies>

### Example

Let's say that your application initializes lazily a `Properties` field in the
`ConfManager` class using a user-provided `Supplier<Properties>`, and you want
to test that the initialization method is only performed once. Heres is one way
to write such a test using a CeeBeeWrap wrapper:


    @Test
    void testPropertiesOnlyEverInitializedOnce() {
    	Supplier<Properties> propsSupplier = this::getTestProperties;
    	ConfManager confMgr = new ConfManager();
    	confMgr.setPropertiesSource(Wrapper.ensuringOnce(propsSupplier));
    	
    	// First call lazily initializes by calling the wrapped supplier
    	confMgr.getProperties();
    	// Second call won't re-initialize properties
    	assertDoesNotThrow(confMgr::getProperties);
    	
    	// or, since the wrapper throws an exception of type suitable for test failures:
    	confMgr.getProperties();
    }

[1]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/AssertionError.html "Link to class AssertionError"
