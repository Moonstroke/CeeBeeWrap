package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingConsumer;
import io.github.moonstroke.ceebeewrap.EnsuringOnceConsumer;
import io.github.moonstroke.ceebeewrap.Wrapper;

class EnsuringOnceConsumerTest {

	@Test
	void testEnsuringOnceConsumerNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> Wrapper.ensuringOnce((Consumer<?>) null));
	}

	@Test
	void testEnsuringOnceConsumerFirstCallSucceeds() {
		EnsuringOnceConsumer<Object> eof = Wrapper.ensuringOnce((Consumer<Object>) Object::toString);
		assertDoesNotThrow(() -> eof.accept(new Object()));
	}

	@Test
	void testEnsuringOnceConsumerSecondCallFails() {
		EnsuringOnceConsumer<Object> eof = Wrapper.ensuringOnce((Consumer<Object>) Object::toString);
		eof.accept(new Object());
		Object object = new Object();
		assertThrows(AssertionError.class, () -> eof.accept(object));
	}

	@Test
	void testEnsuringOnceConsumerFirstCallInvokesCallback() {
		CountingConsumer<Object> cf = Wrapper.counting((Consumer<Object>) Object::toString);
		EnsuringOnceConsumer<Object> eof = Wrapper.ensuringOnce(cf);
		assertDoesNotThrow(() -> eof.accept(new Object()));
		assertEquals(1, cf.getCallCount());
	}

	@Test
	void testEnsuringOnceConsumerSecondCallDoesNotInvokeCallback() {
		CountingConsumer<Object> cf = Wrapper.counting((Consumer<Object>) Object::toString);
		EnsuringOnceConsumer<Object> eof = Wrapper.ensuringOnce(cf);
		eof.accept(new Object());
		Object object = new Object();
		assertThrows(AssertionError.class, () -> eof.accept(object));
		assertEquals(1, cf.getCallCount());
	}
}
