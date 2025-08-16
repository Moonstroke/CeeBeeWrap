package io.github.moonstroke.ceebeewrap.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.github.moonstroke.ceebeewrap.FailingFunction;

class FailingFunctionTest {

	@Test
	void testFailingFunctionAcceptNonNullFails() {
		FailingFunction<Object, Object> ff = new FailingFunction<>();
		Object object = new Object();
		assertThrows(AssertionError.class, () -> ff.apply(object));
	}

	@Test
	void testFailingFunctionAcceptNullFails() {
		FailingFunction<Object, Object> ff = new FailingFunction<>();
		assertThrows(AssertionError.class, () -> ff.apply(null));
	}
}
