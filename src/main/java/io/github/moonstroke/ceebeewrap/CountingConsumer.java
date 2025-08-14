package io.github.moonstroke.ceebeewrap;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * A unary procedure wrapper that keeps count of the number of times it is invoked.
 *
 * @param <T> The type of value that the wrapped callback accepts
 */
public class CountingConsumer<T> extends CountingWrapper implements Consumer<T> {

	private final Consumer<T> callback;


	/**
	 * Wrap the given unary procedure in an object that retains its invocation count.
	 *
	 * @param callback The procedure to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public CountingConsumer(Consumer<T> callback) {
		this.callback = Objects.requireNonNull(callback);
	}

	/**
	 * Invoke the wrapped procedure and increment the call count by 1.
	 *
	 * @param t The argument to pass to the wrapped procedure
	 */
	@Override
	public void accept(T t) {
		callback.accept(t);
		addCallCount();
	}
}
