package io.github.moonstroke.ceebeewrap.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.CountingSupplier;


class CountingSupplierTest {

	@Test
	void testCountingSupplierNullCallbackFails() {
		assertThrows(NullPointerException.class, () -> new CountingSupplier<>(null));
	}

	@Test
	void testCountingSupplierInvokedNeverHasCallCount0() {
		CountingSupplier<Object> cs = new CountingSupplier<>(Object::new);
		assertEquals(0, cs.getCallCount());
	}

	@Test
	void testCountingSupplierInvokedOnceHasCallCount1() {
		CountingSupplier<Object> cs = new CountingSupplier<>(Object::new);
		cs.get();
		assertEquals(1, cs.getCallCount());
	}

	@Test
	void testCountingSupplierInvokedTwiceHasCallCount2() {
		CountingSupplier<Object> cs = new CountingSupplier<>(Object::new);
		cs.get();
		cs.get();
		assertEquals(2, cs.getCallCount());
	}

	@Test
	void testCountingSupplierCallbackThrowsHasCallCount1() {
		CountingSupplier<Object> cbc = new CountingSupplier<>(() -> {
			throw new RuntimeException("exception");
		});
		assertThrows(RuntimeException.class, cbc::get);
		assertEquals(1, cbc.getCallCount());
	}
}
