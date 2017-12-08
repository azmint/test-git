package jp.programmer.gi.lib.validate;

import java.util.*;
import java.util.function.*;

public final class Validates<T> {
	private final T value;

	private Validates(T value) {
		this.value = value;
	}

	public static <T> Validates<T> of(T value) {
		return new Validates<>(value);
	}

	public Validates<T> ifNull(String message) {
		return this.ifSo(Objects::isNull, message);
	}

	public Validates<T> ifSo(Predicate<? super T> predicate, String message) {
		if (predicate.test(this.value)) throw new ValidateException(message);
		return this;
	}

	public <R> R map(Function<? super T, ? extends R> mapper) {
		return mapper.apply(this.value);
	}

	public T get() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Validates<?> validates = (Validates<?>) o;

		return value != null
				? value.equals(validates.value)
				: validates.value == null;
	}

	@Override
	public int hashCode() {
		return value != null
				? value.hashCode()
				: 0;
	}

	@Override
	public String toString() {
		return "Validates{" + "value=" + value + '}';
	}
}
