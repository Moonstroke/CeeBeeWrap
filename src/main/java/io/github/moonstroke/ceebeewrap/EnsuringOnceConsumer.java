package io.github.moonstroke.ceebeewrap;

import java.util.function.Consumer;

/**
 * A unary procedure wrapper that raises an error when it is called more than once.
 *
 * @param <T> The type of value that the wrapped callback accepts
 */
public class EnsuringOnceConsumer<T> extends EnsuringOnceWrapper implements Consumer<T> {

	/**
	 * Invoke the wrapped procedure or fail if it has already been called.
	 *
	 * @param t The argument to pass to the wrapped function
	 *
	 * @throws AssertionError if the method has already been called
	 */
	@Override
	public void accept(T t) throws AssertionError {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}
}
