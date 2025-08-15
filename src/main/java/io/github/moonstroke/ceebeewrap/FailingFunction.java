package io.github.moonstroke.ceebeewrap;

import java.util.function.Function;

/**
 * A unary function implementation that only throws an exception.
 *
 * @param <T> The (unused) argument type of the function
 * @param <R> The (unused) return type of the function
 */
public class FailingFunction<T, R> implements Function<T, R> {

	/**
	 * Throw an assertion error.
	 *
	 * @param t The unused argument
	 *
	 * @return never
	 *
	 * @throws AssertionError always
	 */
	@Override
	public R apply(T t) throws AssertionError {
		throw new AssertionError("function was invoked");
	}
}
