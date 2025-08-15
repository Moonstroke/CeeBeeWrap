package io.github.moonstroke.ceebeewrap;

import java.util.function.Supplier;

/**
 * A nullary function wrapper that raises an error when it is called more than once.
 *
 * @param <R> The type of value that the wrapped callback returns
 */
public class EnsuringOnceSupplier<R> extends EnsuringOnceWrapper implements Supplier<R> {

	private final Supplier<R> callback;


	/**
	 * Wrap the given nullary function in an object that fails if it is called more than once.
	 *
	 * @param callback The function to wrap, not {@code null}
	 */
	EnsuringOnceSupplier(Supplier<R> callback) {
		this.callback = callback;
	}

	/**
	 * Invoke the wrapped function or fail if it has already been called.
	 *
	 * @return the value returned by the wrapped function
	 *
	 * @throws AssertionError if the method has already been called
	 */
	@Override
	public R get() throws AssertionError {
		markCalled();
		return callback.get();
	}
}
