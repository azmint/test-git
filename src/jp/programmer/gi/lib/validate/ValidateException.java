package jp.programmer.gi.lib.validate;

public final class ValidateException extends RuntimeException {
	private static final String DEFAULT_MESSAGE = "不正な値です。";

	public ValidateException(String message) {
		super(message);
	}

	public ValidateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateException(Throwable cause) {
		super(DEFAULT_MESSAGE, cause);
	}
}
