package io.github.moonstroke.ceebeewrap;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Wrapper {

	private Wrapper() {
		/* Static-only class */
	}

	public static <T, R> CountingFunction<T, R> counting(Function<T, R> callback) {
		return new CountingFunction<>(callback);
	}

	public static <T, U, R> CountingBiFunction<T, U, R> counting(BiFunction<T, U, R> callback) {
		return new CountingBiFunction<>(callback);
	}

	public static <T> CountingConsumer<T> counting(Consumer<T> callback) {
		return new CountingConsumer<>(callback);
	}

	public static <T, U> CountingBiConsumer<T, U> counting(BiConsumer<T, U> callback) {
		return new CountingBiConsumer<>(callback);
	}

	public static <R> CountingSupplier<R> counting(Supplier<R> callback) {
		return new CountingSupplier<>(callback);
	}
}
