package jp.programmer.gi.lib.support;

public final class IntSupport {
	public static boolean isPlus(int value) {
		return value > 0;
	}

	public static boolean isMinus(int value) {
		return value < 0;
	}

	public static boolean notPlus(int value) {
		return value <= 0;
	}

	public static boolean notMinus(int value) {
		return value >= 0;
	}
}
