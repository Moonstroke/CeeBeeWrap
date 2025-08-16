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

[1]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/AssertionError.html "Link to class AssertionError"
