package io.github.moonstroke.ceebeewrap;

import java.util.function.Function;

/**
 * A unary function wrapper that keeps count of the number of times it is invoked.
 *
 * @param <T> The type of value that the wrapped callback accepts
 * @param <R> The type of value that the wrapped callback returns
 */
public class CountingFunction<T, R> extends CountingWrapper implements Function<T, R> {

	private final Function<T, R> callback;


	/**
	 * Wrap the given unary function in an object that retains its invocation count.
	 *
	 * @param callback The function to wrap, not {@code null}
	 */
	CountingFunction(Function<T, R> callback) {
		this.callback = callback;
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
		try {
			return callback.apply(t);
		} finally {
			addCallCount();
		}
	}
}
