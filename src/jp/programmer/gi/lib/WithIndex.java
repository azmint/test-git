package jp.programmer.gi.lib;

public final class WithIndex<T> {
	private final T value;
	private final int index;

	private WithIndex(T value, int index) {
		this.value = value;
		this.index = index;
	}

	public static <T> WithIndex of(T value, int index) {
		return new WithIndex<>(value, index);
	}

	public T value() {
		return value;
	}

	public int index() {
		return index;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		WithIndex<?> withIndex = (WithIndex<?>) o;

		if (index != withIndex.index) return false;
		return value != null
				? value.equals(withIndex.value)
				: withIndex.value == null;
	}

	@Override
	public int hashCode() {
		int result = value != null
				? value.hashCode()
				: 0;
		result = 31 * result + index;
		return result;
	}

	@Override
	public String toString() {
		return "WithIndex{" + "value=" + value + ", index=" + index + '}';
	}
}
