package io.github.moonstroke.ceebeewrap;

import java.util.function.Consumer;

/**
 * A unary procedure wrapper that keeps count of the number of times it is invoked.
 *
 * @param <T> The type of value that the wrapped callback accepts
 */
public class CountingConsumer<T> implements Consumer<T> {

	/**
	 * Wrap the given unary procedure in an object that retains its invocation count.
	 *
	 * @param callback The procedure to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public CountingConsumer(Consumer<T> callback) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	/**
	 * Invoke the wrapped procedure and increment the call count by 1.
	 *
	 * @param t The argument to pass to the wrapped procedure
	 */
	@Override
	public void accept(T t) {
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
