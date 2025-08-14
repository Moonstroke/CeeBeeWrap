package io.github.moonstroke.ceebeewrap;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * A nullary function wrapper that keeps count of the number of times it is invoked.
 *
 * @param <R> The type of value that the wrapped callback returns
 */
public class CountingSupplier<R> extends CountingWrapper implements Supplier<R> {

	private final Supplier<R> callback;


	/**
	 * Wrap the given nullary function in an object that retains its invocation count.
	 *
	 * @param callback The function to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public CountingSupplier(Supplier<R> callback) {
		this.callback = Objects.requireNonNull(callback);
	}

	/**
	 * Invoke the wrapped function and increment the call count by 1.
	 *
	 * @return the value returned by the wrapped function
	 */
	@Override
	public R get() {
		try {
			return callback.get();
		} finally {
			addCallCount();
		}
	}
}
