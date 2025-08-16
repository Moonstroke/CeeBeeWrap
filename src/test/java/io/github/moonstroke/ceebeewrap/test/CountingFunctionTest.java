package io.github.moonstroke.ceebeewrap.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingFunction;
import io.github.moonstroke.ceebeewrap.Wrapper;


class CountingFunctionTest {

	@Test
	void testCountingFunctionNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> Wrapper.counting((Function<?, ?>) null));
	}

	@Test
	void testCountingFunctionInvokedNeverHasCallCount0() {
		CountingFunction<Object, String> cf = Wrapper.counting(Object::toString);
		assertEquals(0, cf.getCallCount());
	}

	@Test
	void testCountingFunctionInvokedOnceHasCallCount1() {
		CountingFunction<Object, String> cf = Wrapper.counting(Object::toString);
		cf.apply(new Object());
		assertEquals(1, cf.getCallCount());
	}

	@Test
	void testCountingFunctionInvokedTwiceHasCallCount2() {
		CountingFunction<Object, String> cf = Wrapper.counting(Object::toString);
		cf.apply(new Object());
		cf.apply(new Object());
		assertEquals(2, cf.getCallCount());
	}

	@Test
	void testCountingFunctionCallbackThrowsHasCallCount1() {
		CountingFunction<Object, Object> cbc = Wrapper.counting((Function<Object, Object>) t -> {
			throw new RuntimeException("exception");
		});
		Object object = new Object();
		assertThrows(RuntimeException.class, () -> cbc.apply(object));
		assertEquals(1, cbc.getCallCount());
	}
}
