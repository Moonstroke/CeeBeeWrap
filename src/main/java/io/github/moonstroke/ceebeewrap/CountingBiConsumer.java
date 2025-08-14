package io.github.moonstroke.ceebeewrap;

import java.util.function.BiConsumer;

/**
 * A binary procedure wrapper that keeps count of the number of times it is invoked.
 *
 * @param <T> The type of value that the wrapped callback accepts as first argument
 * @param <U> The type of value that the wrapped callback accepts as second argument
 */
public class CountingBiConsumer<T, U> implements BiConsumer<T, U> {

	/**
	 * Wrap the given binary procedure in an object that retains its invocation count.
	 *
	 * @param callback The procedure to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public CountingBiConsumer(BiConsumer<T, U> callback) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	/**
	 * Invoke the wrapped function and increment the call count by 1.
	 *
	 * @param t The first argument to pass to the wrapped procedure
	 * @param u The second argument to pass to the wrapped procedure
	 */
	@Override
	public void accept(T t, U u) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	/**
	 * Retrieve the number of times that this procedure has been invoked.
	 *
	 * @return the number of times this procedure has been invoked
	 */
	public int getCallCount() {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}
}
