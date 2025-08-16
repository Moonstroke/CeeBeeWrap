/* SPDX-FileCopyrightText: 2025 (c) Joachim MARIE <moonstroke+github@live.fr> 
 * SPDX-License-Identifier: MIT */
package io.github.moonstroke.ceebeewrap;

import java.util.function.BiConsumer;

/**
 * A unary procedure wrapper that raises an error when it is called more than once.
 *
 * @param <T> The type of value that the wrapped callback accepts as first argument
 * @param <U> The type of value that the wrapped callback accepts as second argument
 */
public class EnsuringOnceBiConsumer<T, U> extends EnsuringOnceWrapper implements BiConsumer<T, U> {

	private final BiConsumer<T, U> callback;


	/**
	 * Wrap the given unary procedure in an object that fails if it is called more than once.
	 *
	 * @param callback The procedure to wrap, not {@code null}
	 */
	EnsuringOnceBiConsumer(BiConsumer<T, U> callback) {
		this.callback = callback;
	}

	/**
	 * Invoke the wrapped procedure or fail if it has already been called.
	 *
	 * @param t The first argument to pass to the wrapped function
	 * @param u The second argument to pass to the wrapped function
	 *
	 * @throws AssertionError if the method has already been called
	 */
	@Override
	public void accept(T t, U u) throws AssertionError {
		markCalled();
		callback.accept(t, u);
	}
}
