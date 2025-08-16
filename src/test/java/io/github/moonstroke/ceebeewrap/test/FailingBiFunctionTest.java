package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.FailingBiFunction;

class FailingBiFunctionTest {

	@Test
	void testFailingBiFunctionApplyNonNullNonNullFails() {
		FailingBiFunction<Object, Object, Object> fbf = new FailingBiFunction<>();
		Object object1 = new Object();
		Object object2 = new Object();
		assertThrows(AssertionError.class, () -> fbf.apply(object1, object2));
	}

	@Test
	void testFailingBiFunctionApplyNonNullNullFails() {
		FailingBiFunction<Object, Object, Object> fbf = new FailingBiFunction<>();
		Object object = new Object();
		assertThrows(AssertionError.class, () -> fbf.apply(object, null));
	}

	@Test
	void testFailingBiFunctionApplyNullNonNullFails() {
		FailingBiFunction<Object, Object, Object> fbf = new FailingBiFunction<>();
		Object object = new Object();
		assertThrows(AssertionError.class, () -> fbf.apply(null, object));
	}

	@Test
	void testFailingBiFunctionApplyNullNullFails() {
		FailingBiFunction<Object, Object, Object> fbf = new FailingBiFunction<>();
		assertThrows(AssertionError.class, () -> fbf.apply(null, null));
	}
}
