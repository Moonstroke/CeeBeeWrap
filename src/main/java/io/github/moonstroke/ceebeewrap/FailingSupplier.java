/* SPDX-FileCopyrightText: 2025 (c) Joachim MARIE <moonstroke+github@live.fr> 
 * SPDX-License-Identifier: MIT */
package io.github.moonstroke.ceebeewrap;

import java.util.function.Supplier;

/**
 * A nullary function implementation that always throws an exception.
 *
 * @param <R> The (unused) return type of the supplier
 */
public class FailingSupplier<R> implements Supplier<R> {

	/**
	 * Throw an assertion error.
	 *
	 * @return never
	 *
	 * @throws AssertionError always
	 */
	@Override
	public R get() throws AssertionError {
		throw new AssertionError("consumer was invoked");
	}
}
