package jp.programmer.gi.lib.validate;public final class Validates<T> {	public static <T> Validate<T> of(T value) {		return Validate.of(value);	}	public static ValidateInt of(int value) {		return ValidateInt.of(value);	}}