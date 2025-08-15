package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.FailingBiConsumer;

class FailingBiConsumerTest {

	@Test
	void testFailingBiConsumerAcceptNonNullNonNullFails() {
		FailingBiConsumer<Object, Object> fbc = new FailingBiConsumer<>();
		assertThrows(AssertionError.class, () -> fbc.accept(new Object(), new Object()));
	}

	@Test
	void testFailingBiConsumerAcceptNonNullNullFails() {
		FailingBiConsumer<Object, Object> fbc = new FailingBiConsumer<>();
		assertThrows(AssertionError.class, () -> fbc.accept(new Object(), null));
	}

	@Test
	void testFailingBiConsumerAcceptNullNonNullFails() {
		FailingBiConsumer<Object, Object> fbc = new FailingBiConsumer<>();
		assertThrows(AssertionError.class, () -> fbc.accept(null, new Object()));
	}

	@Test
	void testFailingBiConsumerAcceptNullNullFails() {
		FailingBiConsumer<Object, Object> fbc = new FailingBiConsumer<>();
		assertThrows(AssertionError.class, () -> fbc.accept(null, null));
	}
}
