package io.github.moonstroke.ceebeewrap;

import java.util.function.BiFunction;

/**
 * A binary function implementation that only throws an exception.
 *
 * @param <T> The (unused) first argument type of the function
 * @param <U> The (unused) second argument type of the function
 * @param <R> The (unused) return type of the function
 */
public class FailingBiFunction<T, U, R> implements BiFunction<T, U, R> {

	/**
	 * Throw an assertion error.
	 *
	 * @param t The unused first argument
	 * @param u The unused second argument
	 *
	 * @return never
	 *
	 * @throws AssertionError always
	 */
	@Override
	public R apply(T t, U u) throws AssertionError {
		throw new AssertionError("function was invoked");
	}
}
