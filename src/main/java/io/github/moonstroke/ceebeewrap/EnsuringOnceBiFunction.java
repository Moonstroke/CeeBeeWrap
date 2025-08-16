/* SPDX-FileCopyrightText: 2025 (c) Joachim MARIE <moonstroke+github@live.fr> 
 * SPDX-License-Identifier: MIT */
package io.github.moonstroke.ceebeewrap;

import java.util.function.BiFunction;

/**
 * A unary function wrapper that raises an error when it is called more than once.
 *
 * @param <T> The type of value that the wrapped callback accepts as first argument
 * @param <U> The type of value that the wrapped callback accepts as second argument
 * @param <R> The type of value that the wrapped callback returns
 */
public class EnsuringOnceBiFunction<T, U, R> extends EnsuringOnceWrapper implements BiFunction<T, U, R> {

	private final BiFunction<T, U, R> callback;


	/**
	 * Wrap the given unary function in an object that fails if it is called more than once.
	 *
	 * @param callback The function to wrap, not {@code null}
	 */
	EnsuringOnceBiFunction(BiFunction<T, U, R> callback) {
		this.callback = callback;
	}

	/**
	 * Invoke the wrapped function or fail if it has already been called.
	 *
	 * @param t The first argument to pass to the wrapped function
	 * @param u The second argument to pass to the wrapped function
	 *
	 * @return the value returned by the wrapped function
	 *
	 * @throws AssertionError if the method has already been called
	 */
	@Override
	public R apply(T t, U u) throws AssertionError {
		markCalled();
		return callback.apply(t, u);
	}
}
