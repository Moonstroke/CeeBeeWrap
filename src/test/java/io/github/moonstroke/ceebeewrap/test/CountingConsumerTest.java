package io.github.moonstroke.ceebeewrap.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingConsumer;


class CountingConsumerTest {

	@Test
	void testCountingConsumerNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> new CountingConsumer<>(null));
	}

	@Test
	void testCountingConsumerInvokedNeverHasCallCount0() {
		CountingConsumer<Object> cc = new CountingConsumer<>(Object::toString);
		assertEquals(0, cc.getCallCount());
	}

	@Test
	void testCountingConsumerInvokedOnceHasCallCount1() {
		CountingConsumer<Object> cc = new CountingConsumer<>(Object::toString);
		cc.accept(new Object());
		assertEquals(1, cc.getCallCount());
	}

	@Test
	void testCountingConsumerInvokedTwiceHasCallCount2() {
		CountingConsumer<Object> cc = new CountingConsumer<>(Object::toString);
		cc.accept(new Object());
		cc.accept(new Object());
		assertEquals(2, cc.getCallCount());
	}

	@Test
	void testCountingConsumerCallbackThrowsHasCallCount1() {
		CountingConsumer<Object> cbc = new CountingConsumer<>(t -> {
			throw new RuntimeException("exception");
		});
		assertThrows(RuntimeException.class, () -> cbc.accept(new Object()));
		assertEquals(1, cbc.getCallCount());
	}
}
