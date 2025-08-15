package io.github.moonstroke.ceebeewrap;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Static class providing factory method to obtain wrapper instances.
 */
public class Wrapper {

	private Wrapper() {
		/* Static-only class */
	}

	/**
	 * Wrap a unary function in an instance that keeps count of the number of times it is invoked.
	 *
	 * @param <T>      The function's argument type
	 * @param <R>      The function's return type
	 * @param callback The function to wrap
	 *
	 * @return A unary function wrapper that delegates to the given callback
	 */
	public static <T, R> CountingFunction<T, R> counting(Function<T, R> callback) {
		return new CountingFunction<>(callback);
	}

	/**
	 * Wrap a binary function in an instance that keeps count of the number of times it is invoked.
	 *
	 * @param <T>      The function's first argument type
	 * @param <U>      The function's second argument type
	 * @param <R>      The function's return type
	 * @param callback The function to wrap
	 *
	 * @return A binary function wrapper that delegates to the given callback
	 */
	public static <T, U, R> CountingBiFunction<T, U, R> counting(BiFunction<T, U, R> callback) {
		return new CountingBiFunction<>(callback);
	}

	/**
	 * Wrap a unary procedure in an instance that keeps count of the number of times it is invoked.
	 *
	 * @param <T>      The procedure's argument type
	 * @param callback The procedure to wrap
	 *
	 * @return A unary procedure wrapper that delegates to the given callback
	 */
	public static <T> CountingConsumer<T> counting(Consumer<T> callback) {
		return new CountingConsumer<>(callback);
	}

	/**
	 * Wrap a unary procedure in an instance that keeps count of the number of times it is invoked.
	 *
	 * @param <T>      The procedure's first argument type
	 * @param <U>      The procedure's second argument type
	 * @param callback The procedure to wrap
	 *
	 * @return A unary procedure wrapper that delegates to the given callback
	 */
	public static <T, U> CountingBiConsumer<T, U> counting(BiConsumer<T, U> callback) {
		return new CountingBiConsumer<>(callback);
	}

	/**
	 * Wrap a nullary function in an instance that keeps count of the number of times it is invoked.
	 *
	 * @param <R>      The function's return type
	 * @param callback The function to wrap
	 *
	 * @return A nullary function wrapper that delegates to the given callback
	 */
	public static <R> CountingSupplier<R> counting(Supplier<R> callback) {
		return new CountingSupplier<>(callback);
	}

	/**
	 * Wrap the given unary function in an object that fails if it is called more than once.
	 *
	 * @param <T>      The function's argument type
	 * @param <R>      The function's return type
	 * @param callback The function to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public static <T, R> EnsuringOnceFunction<T, R> ensuringOnce(Function<T, R> callback) {
		return new EnsuringOnceFunction<>(Objects.requireNonNull(callback));
	}

	/**
	 * Wrap the given binary function in an object that fails if it is called more than once.
	 *
	 * @param <T>      The function's first argument type
	 * @param <U>      The function's second argument type
	 * @param <R>      The function's return type
	 * @param callback The function to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public static <T, U, R> EnsuringOnceBiFunction<T, U, R> ensuringOnce(BiFunction<T, U, R> callback) {
		return new EnsuringOnceBiFunction<>(Objects.requireNonNull(callback));
	}

	/**
	 * Wrap the given unary procedure in an object that fails if it is called more than once.
	 *
	 * @param <T>      The procedure's argument type
	 * @param callback The procedure to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public static <T> EnsuringOnceConsumer<T> ensuringOnce(Consumer<T> callback) {
		return new EnsuringOnceConsumer<>(Objects.requireNonNull(callback));
	}

	/**
	 * Wrap the given binary procedure in an object that fails if it is called more than once.
	 *
	 * @param <T>      The procedure's first argument type
	 * @param <U>      The procedure's second argument type
	 * @param callback The procedure to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public static <T, U> EnsuringOnceBiConsumer<T, U> ensuringOnce(BiConsumer<T, U> callback) {
		return new EnsuringOnceBiConsumer<>(Objects.requireNonNull(callback));
	}

	/**
	 * Wrap the given nullary function in an object that fails if it is called more than once.
	 *
	 * @param <R>      The function's return type
	 * @param callback The function to wrap
	 *
	 * @throws NullPointerException if callback is {@code null}
	 */
	public static <R> EnsuringOnceSupplier<R> ensuringOnce(Supplier<R> callback) {
		return new EnsuringOnceSupplier<>(Objects.requireNonNull(callback));
	}
}
