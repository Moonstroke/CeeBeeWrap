package io.github.moonstroke.ceebeewrap;

/**
 * An abstract wrapper that keeps count of the number of times that it is invoked.
 */
abstract class CountingWrapper {

	private int callCount = 0;


	/**
	 * Increase by one the retained number of times that the wrapper is invoked.
	 */
	protected void addCallCount() {
		++callCount;
	}

	/**
	 * Retrieve the number of times that this function has been invoked.
	 *
	 * @return the number of times this function has been invoked
	 */
	public int getCallCount() {
		return callCount;
	}
}
