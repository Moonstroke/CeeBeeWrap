/* SPDX-FileCopyrightText: 2025 (c) Joachim MARIE <moonstroke+github@live.fr> 
 * SPDX-License-Identifier: MIT */
package io.github.moonstroke.ceebeewrap;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * An abstract wrapper that fails if it is invoked more than once.
 */
abstract class EnsuringOnceWrapper {

	private final AtomicBoolean called = new AtomicBoolean(false);


	/**
	 * Mark this wrapper as called.
	 *
	 * @throws AssertionError if this wrapper was already marked as called
	 */
	protected void markCalled() throws AssertionError {
		if (called.getAndSet(true)) {
			throw new AssertionError("Callback was already invoked");
		}
	}
}
