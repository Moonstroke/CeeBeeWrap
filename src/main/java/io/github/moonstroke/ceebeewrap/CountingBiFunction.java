package io.github.moonstroke.ceebeewrap;

import java.util.function.BiFunction;

/**
 * A binary function wrapper that keeps count of the number of times it is invoked.
 *
 * @param <T> The type of value that the wrapped callback accepts as first argument
 * @param <U> The type of value that the wrapped callback accepts as second argument
 * @param <R> The type of value that the wrapped callback returns
 */
public class CountingBiFunction<T, U, R> implements BiFunction<T, U, R> {

	public CountingBiFunction(BiFunction<T, U, R> callback) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	@Override
	public R apply(T t, U u) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	public int getCallCount() {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}
}
