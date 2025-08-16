/* SPDX-FileCopyrightText: 2025 (c) Joachim MARIE <moonstroke+github@live.fr> 
 * SPDX-License-Identifier: MIT */
package io.github.moonstroke.ceebeewrap;

import java.util.function.BiFunction;

/**
 * A binary function wrapper that keeps count of the number of times it is invoked.
 *
 * @param <T> The type of value that the wrapped callback accepts as first argument
 * @param <U> The type of value that the wrapped callback accepts as second argument
 * @param <R> The type of value that the wrapped callback returns
 */
public class CountingBiFunction<T, U, R> extends CountingWrapper implements BiFunction<T, U, R> {

	private final BiFunction<T, U, R> callback;


	/**
	 * Wrap the given binary function in an object that retains its invocation count.
	 *
	 * @param callback The function to wrap, not {@code null}
	 */
	CountingBiFunction(BiFunction<T, U, R> callback) {
		this.callback = callback;
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
		try {
			return callback.apply(t, u);
		} finally {
			addCallCount();
		}
	}
}
