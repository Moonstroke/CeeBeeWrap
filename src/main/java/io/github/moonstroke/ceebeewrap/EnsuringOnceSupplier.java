package io.github.moonstroke.ceebeewrap;

import java.util.function.Supplier;

/**
 * A nullary function wrapper that raises an error when it is called more than once.
 *
 * @param <R> The type of value that the wrapped callback returns
 */
public class EnsuringOnceSupplier<R> extends EnsuringOnceWrapper implements Supplier<R> {

	/**
	 * Invoke the wrapped function or fail if it has already been called.
	 *
	 * @return the value returned by the wrapped function
	 *
	 * @throws AssertionError if the method has already been called
	 */
	@Override
	public R get() throws AssertionError {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}
}
