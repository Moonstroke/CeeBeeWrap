package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.FailingConsumer;

class FailingConsumerTest {

	@Test
	void testFailingConsumerAcceptNonNullFails() {
		FailingConsumer<Object> fc = new FailingConsumer<>();
		Object object = new Object();
		assertThrows(AssertionError.class, () -> fc.accept(object));
	}

	@Test
	void testFailingConsumerAcceptNullFails() {
		FailingConsumer<Object> fc = new FailingConsumer<>();
		assertThrows(AssertionError.class, () -> fc.accept(null));
	}
}
