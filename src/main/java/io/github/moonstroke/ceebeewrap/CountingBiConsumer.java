package io.github.moonstroke.ceebeewrap;

import java.util.function.BiConsumer;

/**
 * A binary procedure wrapper that keeps count of the number of times it is invoked.
 *
 * @param <T> The type of value that the wrapped callback accepts as first argument
 * @param <U> The type of value that the wrapped callback accepts as second argument
 */
public class CountingBiConsumer<T, U> implements BiConsumer<T, U> {

	public CountingBiConsumer(BiConsumer<T, U> callback) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	@Override
	public void accept(T t, U u) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	public int getCallCount() {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}
}
