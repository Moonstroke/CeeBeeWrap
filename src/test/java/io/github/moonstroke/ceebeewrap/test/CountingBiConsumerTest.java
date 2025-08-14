package io.github.moonstroke.ceebeewrap.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingBiConsumer;


class CountingBiConsumerTest {

	@Test
	void testCountingBiConsumerNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> new CountingBiConsumer<>(null));
	}

	@Test
	void testCountingBiConsumerInvokedNeverHasCallCount0() {
		CountingBiConsumer<Object, Object> cbc = new CountingBiConsumer<>(Object::equals);
		assertEquals(0, cbc.getCallCount());
	}

	@Test
	void testCountingBiConsumerInvokedOnceHasCallCount1() {
		CountingBiConsumer<Object, Object> cbc = new CountingBiConsumer<>(Object::equals);
		cbc.accept(new Object(), new Object());
		assertEquals(1, cbc.getCallCount());
	}

	@Test
	void testCountingBiConsumerInvokedTwiceHasCallCount2() {
		CountingBiConsumer<Object, Object> cbc = new CountingBiConsumer<>(Object::equals);
		cbc.accept(new Object(), new Object());
		cbc.accept(new Object(), new Object());
		assertEquals(2, cbc.getCallCount());
	}
}
