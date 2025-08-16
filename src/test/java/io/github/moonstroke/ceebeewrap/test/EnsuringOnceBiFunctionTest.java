/* SPDX-FileCopyrightText: 2025 (c) Joachim MARIE <moonstroke+github@live.fr> 
 * SPDX-License-Identifier: MIT */
package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.BiFunction;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingBiFunction;
import io.github.moonstroke.ceebeewrap.EnsuringOnceBiFunction;
import io.github.moonstroke.ceebeewrap.Wrapper;

class EnsuringOnceBiFunctionTest {

	@Test
	void testEnsuringOnceFunctionNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> Wrapper.ensuringOnce((BiFunction<?, ?, ?>) null));
	}

	@Test
	void testEnsuringOnceFunctionFirstCallSucceeds() {
		EnsuringOnceBiFunction<Object, Object, Boolean> eobf = Wrapper.ensuringOnce(Object::equals);
		assertDoesNotThrow(() -> eobf.apply(new Object(), new Object()));
	}

	@Test
	void testEnsuringOnceFunctionSecondCallFails() {
		EnsuringOnceBiFunction<Object, Object, Boolean> eobf = Wrapper.ensuringOnce(Object::equals);
		eobf.apply(new Object(), new Object());
		Object object1 = new Object();
		Object object2 = new Object();
		assertThrows(AssertionError.class, () -> eobf.apply(object1, object2));
	}

	@Test
	void testEnsuringOnceFunctionFirstCallInvokesCallback() {
		CountingBiFunction<Object, Object, Boolean> cbf = Wrapper.counting(Object::equals);
		EnsuringOnceBiFunction<Object, Object, Boolean> eobf = Wrapper.ensuringOnce(cbf);
		assertDoesNotThrow(() -> eobf.apply(new Object(), new Object()));
		assertEquals(1, cbf.getCallCount());
	}

	@Test
	void testEnsuringOnceFunctionSecondCallDoesNotInvokeCallback() {
		CountingBiFunction<Object, Object, Boolean> cbf = Wrapper.counting(Object::equals);
		EnsuringOnceBiFunction<Object, Object, Boolean> eobf = Wrapper.ensuringOnce(cbf);
		eobf.apply(new Object(), new Object());
		Object object1 = new Object();
		Object object2 = new Object();
		assertThrows(AssertionError.class, () -> eobf.apply(object1, object2));
		assertEquals(1, cbf.getCallCount());
	}
}
