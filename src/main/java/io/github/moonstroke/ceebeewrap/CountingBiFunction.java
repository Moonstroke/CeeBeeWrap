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

	/**
	 * Wrap the given binary function in an object that retains its invocation count.
	 *
	 * @param callback The function to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public CountingBiFunction(BiFunction<T, U, R> callback) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	/**
	 * Invoke the wrapped function and increment the call count by 1.
	 *
	 * @param t The first argument to pass to the wrapped function
	 * @param u The second argument to pass to the wrapped function
	 *
	 * @return the value returned by the wrapped function
	 */
	@Override
	public R apply(T t, U u) {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}

	/**
	 * Retrieve the number of times that this function has been invoked.
	 *
	 * @return the number of times this function has been invoked
	 */
	public int getCallCount() {
		throw new UnsupportedOperationException("Not implemented"); // TODO
	}
}
