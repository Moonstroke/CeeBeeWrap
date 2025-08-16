package io.github.moonstroke.ceebeewrap.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.BiFunction;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingBiFunction;
import io.github.moonstroke.ceebeewrap.Wrapper;


class CountingBiFunctionTest {

	@Test
	void testCountingBiFunctionNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> Wrapper.counting((BiFunction<?, ?, ?>) null));
	}

	@Test
	void testCountingBiFunctionInvokedNeverHasCallCount0() {
		CountingBiFunction<Object, Object, Boolean> cbf = Wrapper.counting(Object::equals);
		assertEquals(0, cbf.getCallCount());
	}

	@Test
	void testCountingBiFunctionInvokedOnceHasCallCount1() {
		CountingBiFunction<Object, Object, Boolean> cbf = Wrapper.counting(Object::equals);
		cbf.apply(new Object(), new Object());
		assertEquals(1, cbf.getCallCount());
	}

	@Test
	void testCountingBiFunctionInvokedTwiceHasCallCount2() {
		CountingBiFunction<Object, Object, Boolean> cbf = Wrapper.counting(Object::equals);
		cbf.apply(new Object(), new Object());
		cbf.apply(new Object(), new Object());
		assertEquals(2, cbf.getCallCount());
	}

	@Test
	void testCountingBiFunctionCallbackThrowsHasCallCount1() {
		CountingBiFunction<Object, Object,
		                   Object> cbc = Wrapper.counting((BiFunction<Object, Object, Object>) (t, u) -> {
			throw new RuntimeException("exception");
		});
		Object object1 = new Object();
		Object object2 = new Object();
		assertThrows(RuntimeException.class, () -> cbc.apply(object1, object2));
		assertEquals(1, cbc.getCallCount());
	}
}
