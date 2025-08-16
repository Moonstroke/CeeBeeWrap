package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingFunction;
import io.github.moonstroke.ceebeewrap.EnsuringOnceFunction;
import io.github.moonstroke.ceebeewrap.Wrapper;

class EnsuringOnceFunctionTest {

	@Test
	void testEnsuringOnceFunctionNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> Wrapper.ensuringOnce((Function<?, ?>) null));
	}

	@Test
	void testEnsuringOnceFunctionFirstCallSucceeds() {
		EnsuringOnceFunction<Object, String> eof = Wrapper.ensuringOnce(Object::toString);
		assertDoesNotThrow(() -> eof.apply(new Object()));
	}

	@Test
	void testEnsuringOnceFunctionSecondCallFails() {
		EnsuringOnceFunction<Object, String> eof = Wrapper.ensuringOnce(Object::toString);
		eof.apply(new Object());
		Object object = new Object();
		assertThrows(AssertionError.class, () -> eof.apply(object));
	}

	@Test
	void testEnsuringOnceFunctionFirstCallInvokesCallback() {
		CountingFunction<Object, String> cf = Wrapper.counting(Object::toString);
		EnsuringOnceFunction<Object, String> eof = Wrapper.ensuringOnce(cf);
		assertDoesNotThrow(() -> eof.apply(new Object()));
		assertEquals(1, cf.getCallCount());
	}

	@Test
	void testEnsuringOnceFunctionSecondCallDoesNotInvokeCallback() {
		CountingFunction<Object, String> cf = Wrapper.counting(Object::toString);
		EnsuringOnceFunction<Object, String> eof = Wrapper.ensuringOnce(cf);
		eof.apply(new Object());
		Object object = new Object();
		assertThrows(AssertionError.class, () -> eof.apply(object));
		assertEquals(1, cf.getCallCount());
	}
}
