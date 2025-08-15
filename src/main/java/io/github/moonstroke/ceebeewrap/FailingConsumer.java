package io.github.moonstroke.ceebeewrap;

import java.util.function.Consumer;

/**
 * A unary procedure implementation that always throws an exception.
 *
 * @param <T> The (unused) argument type of the consumer
 */
public class FailingConsumer<T> implements Consumer<T> {

	/**
	 * Throw an assertion error.
	 *
	 * @param t The unused argument
	 *
	 * @throws AssertionError always
	 */
	@Override
	public void accept(T t) throws AssertionError {
		throw new AssertionError("consumer was invoked");
	}
}
