package jp.programmer.gi.lib.validate;

import java.util.*;
import java.util.function.*;

public final class Validate<T> {
	private final T value;

	private Validate(T value) {
		this.value = value;
	}

	public static <T> Validate<T> of(T value) {
		return new Validate<>(value);
	}

	public Validate<T> ifNull(String message) {
		return this.ifSo(Objects::isNull, message);
	}

	public Validate<T> ifSo(Predicate<? super T> predicate, String message) {
		if (predicate.test(this.value)) throw new ValidateException(message);
		return this;
	}

	public <R> Validate<R> map(Function<? super T, ? extends R> mapper) {
		R result = mapper.apply(this.value);
		return of(result);
	}

	public ValidateInt mapToInt(Function<? super T, ? extends Integer> mapper) {
		Integer result = mapper.apply(this.value);
		return ValidateInt.of(result);
	}

	public T get() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Validate<?> validate = (Validate<?>) o;

		return value != null ? value.equals(validate.value) : validate.value == null;
	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Validate{" + "value=" + value + '}';
	}
}
