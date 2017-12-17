package jp.programmer.gi.lib.validate;

import java.util.function.*;

public final class ValidateInt {
	private final int value;

	private ValidateInt(int value) {
		this.value = value;
	}

	public static ValidateInt of(int value) {
		return new ValidateInt(value);
	}

	public ValidateInt ifMinus(String message) {
		return this.ifSo(value -> value < 0, message);
	}

	public ValidateInt ifNotPlus(String message) {
		return this.ifSo(value -> value <= 0, message);
	}

	public ValidateInt ifPlus(String message) {
		return this.ifSo(value -> value > 0, message);
	}

	public ValidateInt ifSo(Predicate<Integer> predicate, String message) {
		if (predicate.test(this.value)) throw new ValidateException(message);
		return this;
	}

	public <R> Validate<R> map(Function<? super Integer, ? extends R> mapper) {
		R result = mapper.apply(this.value);
		return Validate.of(result);
	}

	public ValidateInt mapToInt(Function<? super Integer, ? extends Integer> mapper) {
		Integer result = mapper.apply(this.value);
		return of(result);
	}

	public int get() {
		return this.value;
	}
}
