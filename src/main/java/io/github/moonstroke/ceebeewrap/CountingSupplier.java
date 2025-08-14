package io.github.moonstroke.ceebeewrap;

import java.util.function.Supplier;

/**
 * A nullary function wrapper that keeps count of the number of times it is invoked.
 *
 * @param <R> The type of value that the wrapped callback returns
 */
public class CountingSupplier<R> implements Supplier<R> {

	public CountingSupplier(Supplier<R> callback) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	@Override
	public R get() {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	public int getCallCount() {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}
}
