package io.github.moonstroke.ceebeewrap;

import java.util.Objects;
import java.util.function.Function;

/**
 * A unary function wrapper that keeps count of the number of times it is invoked.
 *
 * @param <T> The type of value that the wrapped callback accepts
 * @param <R> The type of value that the wrapped callback returns
 */
public class CountingFunction<T, R> implements Function<T, R> {

	private final Function<T, R> callback;
	private int callCount;


	/**
	 * Wrap the given unary function in an object that retains its invocation count.
	 *
	 * @param callback The function to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public CountingFunction(Function<T, R> callback) {
		this.callback = Objects.requireNonNull(callback);
		callCount = 0;
	}

	/**
	 * Invoke the wrapped function and increment the call count by 1.
	 *
	 * @param t The argument to pass to the wrapped function
	 *
	 * @return the value returned by the wrapped function
	 */
	@Override
	public R apply(T t) {
		R r = callback.apply(t);
		++callCount;
		return r;
	}

	/**
	 * Retrieve the number of times that this function has been invoked.
	 *
	 * @return the number of times this function has been invoked
	 */
	public int getCallCount() {
		return callCount;
	}
}
