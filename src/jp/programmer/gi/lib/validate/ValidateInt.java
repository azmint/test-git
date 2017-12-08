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

	}

	public ValidateInt ifSo(Predicate<Integer> predicate, String message) {
		if (predicate.test(this.value)) throw new ValidateException(message);
		return this;
	}

	public <R> R map(Function<Integer, ? extends R> mapper) {
		return mapper.apply(this.value);
	}

	public int get() {
		return this.value;
	}
}
