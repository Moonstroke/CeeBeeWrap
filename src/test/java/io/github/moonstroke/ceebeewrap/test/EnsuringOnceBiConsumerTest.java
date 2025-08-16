/* SPDX-FileCopyrightText: 2025 (c) Joachim MARIE <moonstroke+github@live.fr> 
 * SPDX-License-Identifier: MIT */
package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.BiConsumer;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingBiConsumer;
import io.github.moonstroke.ceebeewrap.EnsuringOnceBiConsumer;
import io.github.moonstroke.ceebeewrap.Wrapper;

class EnsuringOnceBiConsumerTest {

	@Test
	void testEnsuringOnceConsumerNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> Wrapper.ensuringOnce((BiConsumer<?, ?>) null));
	}

	@Test
	void testEnsuringOnceConsumerFirstCallSucceeds() {
		EnsuringOnceBiConsumer<Object, Object> eobf = Wrapper.ensuringOnce((BiConsumer<Object, Object>) Object::equals);
		assertDoesNotThrow(() -> eobf.accept(new Object(), new Object()));
	}

	@Test
	void testEnsuringOnceConsumerSecondCallFails() {
		EnsuringOnceBiConsumer<Object, Object> eobf = Wrapper.ensuringOnce((BiConsumer<Object, Object>) Object::equals);
		eobf.accept(new Object(), new Object());
		Object object1 = new Object();
		Object object2 = new Object();
		assertThrows(AssertionError.class, () -> eobf.accept(object1, object2));
	}

	@Test
	void testEnsuringOnceConsumerFirstCallInvokesCallback() {
		CountingBiConsumer<Object, Object> cbf = Wrapper.counting((BiConsumer<Object, Object>) Object::equals);
		EnsuringOnceBiConsumer<Object, Object> eobf = Wrapper.ensuringOnce(cbf);
		assertDoesNotThrow(() -> eobf.accept(new Object(), new Object()));
		assertEquals(1, cbf.getCallCount());
	}

	@Test
	void testEnsuringOnceConsumerSecondCallDoesNotInvokeCallback() {
		CountingBiConsumer<Object, Object> cbf = Wrapper.counting((BiConsumer<Object, Object>) Object::equals);
		EnsuringOnceBiConsumer<Object, Object> eobf = Wrapper.ensuringOnce(cbf);
		eobf.accept(new Object(), new Object());
		Object object1 = new Object();
		Object object2 = new Object();
		assertThrows(AssertionError.class, () -> eobf.accept(object1, object2));
		assertEquals(1, cbf.getCallCount());
	}
}
