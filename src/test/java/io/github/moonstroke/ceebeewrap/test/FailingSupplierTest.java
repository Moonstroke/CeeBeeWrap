package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.FailingSupplier;

class FailingSupplierTest {

	@Test
	void testFailingSupplierGetFails() {
		assertThrows(AssertionError.class, new FailingSupplier<>()::get);
	}
}
