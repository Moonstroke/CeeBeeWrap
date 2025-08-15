package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.FailingBiFunction;

class FailingBiFunctionTest {

	@Test
	void testFailingBiFunctionApplyNonNullNonNullFails() {
		FailingBiFunction<Object, Object, Object> fbf = new FailingBiFunction<>();
		assertThrows(AssertionError.class, () -> fbf.apply(new Object(), new Object()));
	}

	@Test
	void testFailingBiFunctionApplyNonNullNullFails() {
		FailingBiFunction<Object, Object, Object> fbf = new FailingBiFunction<>();
		assertThrows(AssertionError.class, () -> fbf.apply(new Object(), null));
	}

	@Test
	void testFailingBiFunctionApplyNullNonNullFails() {
		FailingBiFunction<Object, Object, Object> fbf = new FailingBiFunction<>();
		assertThrows(AssertionError.class, () -> fbf.apply(null, new Object()));
	}

	@Test
	void testFailingBiFunctionApplyNullNullFails() {
		FailingBiFunction<Object, Object, Object> fbf = new FailingBiFunction<>();
		assertThrows(AssertionError.class, () -> fbf.apply(null, null));
	}
}
