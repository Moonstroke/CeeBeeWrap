# CeeBeeWrap

𝐶🐝🌯

## Description

This project provides wrappers for the standard Java generic functional
interfaces, to be used in tests.

### What is a *wrapper*?

In the context of this project, a *wrapper* is any instance which comprises a
function object and provides additional behavior to it, while being itself an
instance of the same functional interface. This allows such instances to be
injected in an instruction where the wrapped object is passed to take advantage
of the added behavior.

### Wrapped functional interfaces

The project provides wrappers for the following functional interfaces:

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
