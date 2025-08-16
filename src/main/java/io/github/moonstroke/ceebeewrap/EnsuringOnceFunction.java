/* SPDX-FileCopyrightText: 2025 (c) Joachim MARIE <moonstroke+github@live.fr> 
 * SPDX-License-Identifier: MIT */
package io.github.moonstroke.ceebeewrap;

import java.util.function.Function;

/**
 * A unary function wrapper that raises an error when it is called more than once.
 *
 * @param <T> The type of value that the wrapped callback accepts
 * @param <R> The type of value that the wrapped callback returns
 */
public class EnsuringOnceFunction<T, R> extends EnsuringOnceWrapper implements Function<T, R> {

	private final Function<T, R> callback;


	/**
	 * Wrap the given unary function in an object that fails if it is called more than once.
	 *
	 * @param callback The function to wrap, not {@code null}
	 */
	EnsuringOnceFunction(Function<T, R> callback) {
		this.callback = callback;
	}

	/**
	 * Invoke the wrapped function or fail if it has already been called.
	 *
	 * @param t The argument to pass to the wrapped function
	 *
	 * @return the value returned by the wrapped function
	 *
	 * @throws AssertionError if the method has already been called
	 */
	@Override
	public R apply(T t) throws AssertionError {
		markCalled();
		return callback.apply(t);
	}
}
