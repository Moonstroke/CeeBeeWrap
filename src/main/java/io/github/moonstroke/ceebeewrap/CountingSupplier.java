package io.github.moonstroke.ceebeewrap;

import java.util.function.Supplier;

/**
 * A nullary function wrapper that keeps count of the number of times it is invoked.
 *
 * @param <R> The type of value that the wrapped callback returns
 */
public class CountingSupplier<R> implements Supplier<R> {

	/**
	 * Wrap the given nullary function in an object that retains its invocation count.
	 *
	 * @param callback The function to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public CountingSupplier(Supplier<R> callback) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	/**
	 * Invoke the wrapped function and increment the call count by 1.
	 *
	 * @return the value returned by the wrapped function
	 */
	@Override
	public R get() {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	/**
	 * Retrieve the number of times that this function has been invoked.
	 *
	 * @return the number of times this function has been invoked
	 */
	public int getCallCount() {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}
}
