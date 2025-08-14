package io.github.moonstroke.ceebeewrap.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingFunction;


class CountingFunctionTest {

	@Test
	void testCountingFunctionNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> new CountingFunction<>(null));
	}

	@Test
	void testCountingFunctionInvokedNeverHasCallCount0() {
		CountingFunction<Object, String> cf = new CountingFunction<>(Object::toString);
		assertEquals(0, cf.getCallCount());
	}

	@Test
	void testCountingFunctionInvokedOnceHasCallCount1() {
		CountingFunction<Object, String> cf = new CountingFunction<>(Object::toString);
		cf.apply(new Object());
		assertEquals(1, cf.getCallCount());
	}

	@Test
	void testCountingFunctionInvokedTwiceHasCallCount2() {
		CountingFunction<Object, String> cf = new CountingFunction<>(Object::toString);
		cf.apply(new Object());
		cf.apply(new Object());
		assertEquals(2, cf.getCallCount());
	}

	@Test
	void testCountingFunctionCallbackThrowsHasCallCount1() {
		CountingFunction<Object, Object> cbc = new CountingFunction<>(t -> {
			throw new RuntimeException("exception");
		});
		assertThrows(RuntimeException.class, () -> cbc.apply(new Object()));
		assertEquals(1, cbc.getCallCount());
	}
}
