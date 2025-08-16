/* SPDX-FileCopyrightText: 2025 (c) Joachim MARIE <moonstroke+github@live.fr> 
 * SPDX-License-Identifier: MIT */
package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.FailingBiConsumer;

class FailingBiConsumerTest {

	@Test
	void testFailingBiConsumerAcceptNonNullNonNullFails() {
		FailingBiConsumer<Object, Object> fbc = new FailingBiConsumer<>();
		Object object1 = new Object();
		Object object2 = new Object();
		assertThrows(AssertionError.class, () -> fbc.accept(object1, object2));
	}

	@Test
	void testFailingBiConsumerAcceptNonNullNullFails() {
		FailingBiConsumer<Object, Object> fbc = new FailingBiConsumer<>();
		Object object = new Object();
		assertThrows(AssertionError.class, () -> fbc.accept(object, null));
	}

	@Test
	void testFailingBiConsumerAcceptNullNonNullFails() {
		FailingBiConsumer<Object, Object> fbc = new FailingBiConsumer<>();
		Object object = new Object();
		assertThrows(AssertionError.class, () -> fbc.accept(null, object));
	}

	@Test
	void testFailingBiConsumerAcceptNullNullFails() {
		FailingBiConsumer<Object, Object> fbc = new FailingBiConsumer<>();
		assertThrows(AssertionError.class, () -> fbc.accept(null, null));
	}
}
