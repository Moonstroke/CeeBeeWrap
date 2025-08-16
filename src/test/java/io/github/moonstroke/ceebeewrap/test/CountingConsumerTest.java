package io.github.moonstroke.ceebeewrap.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingConsumer;
import io.github.moonstroke.ceebeewrap.Wrapper;


class CountingConsumerTest {

	@Test
	void testCountingConsumerNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> Wrapper.counting((Consumer<?>) null));
	}

	@Test
	void testCountingConsumerInvokedNeverHasCallCount0() {
		CountingConsumer<Object> cc = Wrapper.counting((Consumer<Object>) Object::toString);
		assertEquals(0, cc.getCallCount());
	}

	@Test
	void testCountingConsumerInvokedOnceHasCallCount1() {
		CountingConsumer<Object> cc = Wrapper.counting((Consumer<Object>) Object::toString);
		cc.accept(new Object());
		assertEquals(1, cc.getCallCount());
	}

	@Test
	void testCountingConsumerInvokedTwiceHasCallCount2() {
		CountingConsumer<Object> cc = Wrapper.counting((Consumer<Object>) Object::toString);
		cc.accept(new Object());
		cc.accept(new Object());
		assertEquals(2, cc.getCallCount());
	}

	@Test
	void testCountingConsumerCallbackThrowsHasCallCount1() {
		CountingConsumer<Object> cbc = Wrapper.counting((Consumer<Object>) t -> {
			throw new RuntimeException("exception");
		});
		Object object = new Object();
		assertThrows(RuntimeException.class, () -> cbc.accept(object));
		assertEquals(1, cbc.getCallCount());
	}
}
