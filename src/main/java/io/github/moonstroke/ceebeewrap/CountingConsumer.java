package io.github.moonstroke.ceebeewrap;

import java.util.function.Consumer;

/**
 * A unary procedure wrapper that keeps count of the number of times it is invoked.
 *
 * @param <T> The type of value that the wrapped callback accepts
 */
public class CountingConsumer<T> implements Consumer<T> {

	public CountingConsumer(Consumer<T> callback) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	@Override
	public void accept(T t) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	public int getCallCount() {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}
}
