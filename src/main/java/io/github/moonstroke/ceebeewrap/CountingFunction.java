package io.github.moonstroke.ceebeewrap;

import java.util.function.Function;

/**
 * A unary function wrapper that keeps count of the number of times it is invoked.
 *
 * @param <T> The type of value that the wrapped callback accepts
 * @param <R> The type of value that the wrapped callback returns
 */
public class CountingFunction<T, R> implements Function<T, R> {

	public CountingFunction(Function<T, R> callback) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	@Override
	public R apply(T t) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	public int getCallCount() {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}
}
