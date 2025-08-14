package io.github.moonstroke.ceebeewrap.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.BiConsumer;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingBiConsumer;
import io.github.moonstroke.ceebeewrap.Wrapper;


class CountingBiConsumerTest {

	@Test
	void testCountingBiConsumerNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> Wrapper.counting((BiConsumer<?, ?>) null));
	}

	@Test
	void testCountingBiConsumerInvokedNeverHasCallCount0() {
		CountingBiConsumer<Object, Object> cbc = Wrapper.counting((BiConsumer<Object, Object>) Object::equals);
		assertEquals(0, cbc.getCallCount());
	}

	@Test
	void testCountingBiConsumerInvokedOnceHasCallCount1() {
		CountingBiConsumer<Object, Object> cbc = Wrapper.counting((BiConsumer<Object, Object>) Object::equals);
		cbc.accept(new Object(), new Object());
		assertEquals(1, cbc.getCallCount());
	}

	@Test
	void testCountingBiConsumerInvokedTwiceHasCallCount2() {
		CountingBiConsumer<Object, Object> cbc = Wrapper.counting((BiConsumer<Object, Object>) Object::equals);
		cbc.accept(new Object(), new Object());
		cbc.accept(new Object(), new Object());
		assertEquals(2, cbc.getCallCount());
	}

	@Test
	void testCountingBiConsumerCallbackThrowsHasCallCount1() {
		CountingBiConsumer<Object, Object> cbc = Wrapper.counting((BiConsumer<Object, Object>) (t, u) -> {
			throw new RuntimeException("exception");
		});
		assertThrows(RuntimeException.class, () -> cbc.accept(new Object(), new Object()));
		assertEquals(1, cbc.getCallCount());
	}
}
