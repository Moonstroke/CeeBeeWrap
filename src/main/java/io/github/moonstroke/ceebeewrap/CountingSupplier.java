package io.github.moonstroke.ceebeewrap;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * A nullary function wrapper that keeps count of the number of times it is invoked.
 *
 * @param <R> The type of value that the wrapped callback returns
 */
public class CountingSupplier<R> implements Supplier<R> {

	private final Supplier<R> callback;
	private int callCount;


	/**
	 * Wrap the given nullary function in an object that retains its invocation count.
	 *
	 * @param callback The function to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public CountingSupplier(Supplier<R> callback) {
		this.callback = Objects.requireNonNull(callback);
		callCount = 0;
	}

	/**
	 * Invoke the wrapped function and increment the call count by 1.
	 *
	 * @return the value returned by the wrapped function
	 */
	@Override
	public R get() {
		R r = callback.get();
		++callCount;
		return r;
	}

	/**
	 * Retrieve the number of times that this function has been invoked.
	 *
	 * @return the number of times this function has been invoked
	 */
	public int getCallCount() {
		return callCount;
	}
}
