/* SPDX-FileCopyrightText: 2025 (c) Joachim MARIE <moonstroke+github@live.fr> 
 * SPDX-License-Identifier: MIT */
package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingSupplier;
import io.github.moonstroke.ceebeewrap.EnsuringOnceSupplier;
import io.github.moonstroke.ceebeewrap.Wrapper;

class EnsuringOnceSupplierTest {

	@Test
	void testEnsuringOnceSupplierNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> Wrapper.ensuringOnce((Supplier<?>) null));
	}

	@Test
	void testEnsuringOnceSupplierFirstCallSucceeds() {
		EnsuringOnceSupplier<String> eof = Wrapper.ensuringOnce(new Object()::toString);
		assertDoesNotThrow(eof::get);
	}

	@Test
	void testEnsuringOnceSupplierSecondCallFails() {
		EnsuringOnceSupplier<String> eof = Wrapper.ensuringOnce(new Object()::toString);
		eof.get();
		assertThrows(AssertionError.class, eof::get);
	}

	@Test
	void testEnsuringOnceSupplierFirstCallInvokesCallback() {
		CountingSupplier<String> cf = Wrapper.counting(new Object()::toString);
		EnsuringOnceSupplier<String> eof = Wrapper.ensuringOnce(cf);
		assertDoesNotThrow(eof::get);
		assertEquals(1, cf.getCallCount());
	}

	@Test
	void testEnsuringOnceSupplierSecondCallDoesNotInvokeCallback() {
		CountingSupplier<String> cf = Wrapper.counting(new Object()::toString);
		EnsuringOnceSupplier<String> eof = Wrapper.ensuringOnce(cf);
		eof.get();
		assertThrows(AssertionError.class, eof::get);
		assertEquals(1, cf.getCallCount());
	}
}
