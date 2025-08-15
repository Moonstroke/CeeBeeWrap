package io.github.moonstroke.ceebeewrap;

import java.util.function.Function;

/**
 * A unary function wrapper that raises an error when it is called more than once.
 *
 * @param <T> The type of value that the wrapped callback accepts
 * @param <R> The type of value that the wrapped callback returns
 */
public class EnsuringOnceFunction<T, R> extends EnsuringOnceWrapper implements Function<T, R> {

	/**
	 * Invoke the wrapped function or fail if it has already been called.
	 *
	 * @param t The argument to pass to the wrapped function
	 *
	 * @return the value returned by the wrapped function
	 *
	 * @throws AssertionError if the method has already been called
	 */
	@Override
	public R apply(T t) throws AssertionError {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}
}
