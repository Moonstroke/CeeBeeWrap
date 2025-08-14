package io.github.moonstroke.ceebeewrap;

import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * A binary procedure wrapper that keeps count of the number of times it is invoked.
 *
 * @param <T> The type of value that the wrapped callback accepts as first argument
 * @param <U> The type of value that the wrapped callback accepts as second argument
 */
public class CountingBiConsumer<T, U> extends CountingWrapper implements BiConsumer<T, U> {

	private final BiConsumer<T, U> callback;


	/**
	 * Wrap the given binary procedure in an object that retains its invocation count.
	 *
	 * @param callback The procedure to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public CountingBiConsumer(BiConsumer<T, U> callback) {
		this.callback = Objects.requireNonNull(callback);
	}

	/**
	 * Invoke the wrapped function and increment the call count by 1.
	 *
	 * @param t The first argument to pass to the wrapped procedure
	 * @param u The second argument to pass to the wrapped procedure
	 */
	@Override
	public void accept(T t, U u) {
		try {
			callback.accept(t, u);
		} finally {
			addCallCount();
		}
	}
}
