/* SPDX-FileCopyrightText: 2025 (c) Joachim MARIE <moonstroke+github@live.fr> 
 * SPDX-License-Identifier: MIT */
package io.github.moonstroke.ceebeewrap;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * An abstract wrapper that keeps count of the number of times that it is invoked.
 */
abstract class CountingWrapper {

	private final AtomicInteger callCount = new AtomicInteger(0);


	/**
	 * Increase by one the retained number of times that the wrapper is invoked.
	 */
	protected void addCallCount() {
		callCount.getAndIncrement();
	}

	/**
	 * Retrieve the number of times that this function has been invoked.
	 *
	 * @return the number of times this function has been invoked
	 */
	public int getCallCount() {
		return callCount.get();
	}
}
