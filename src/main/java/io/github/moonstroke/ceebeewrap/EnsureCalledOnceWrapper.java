package io.github.moonstroke.ceebeewrap;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * An abstract wrapper that fails if it is invoked more than once.
 */
abstract class EnsureCalledOnceWrapper {

	private final AtomicBoolean called = new AtomicBoolean(false);


	/**
	 * Mark this wrapper as called.
	 *
	 * @throws AssertionError if this wrapper was already marked as called
	 */
	protected void markCalled() throws AssertionError {
		if (called.getAndSet(true)) {
			throw new AssertionError("Function was already called");
		}
	}
}
