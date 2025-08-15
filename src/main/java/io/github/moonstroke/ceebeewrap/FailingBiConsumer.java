package io.github.moonstroke.ceebeewrap;

import java.util.function.BiConsumer;

/**
 * A binary procedure implementation that always throws an exception.
 *
 * @param <T> The (unused) first argument type of the consumer
 * @param <U> The (unused) second argument type of the consumer
 */
public class FailingBiConsumer<T, U> implements BiConsumer<T, U> {

	/**
	 * Throw an assertion error.
	 *
	 * @param t The unused first argument
	 * @param u The unused second argument
	 *
	 * @throws AssertionError always
	 */
	@Override
	public void accept(T t, U u) throws AssertionError {
		throw new AssertionError("consumer was invoked");
	}
}
