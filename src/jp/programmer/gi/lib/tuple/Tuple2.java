package jp.programmer.gi.lib.tuple;

public final class Tuple2<A, B> implements ITuple2<A, B> {
	private final A _1;
	private final B _2;

	private Tuple2(A _1, B _2) {
		this._1 = _1;
		this._2 = _2;
	}

	public static <A, B> Tuple2<A, B> of(A _1, B _2) {
		return new Tuple2<>(_1, _2);
	}

	@Override
	public A _1() {
		return _1;
	}

	@Override
	public B _2() {
		return _2;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Tuple2<?, ?> tuple2 = (Tuple2<?, ?>) o;

		if (_1 != null
				? !_1.equals(tuple2._1)
				: tuple2._1 != null) return false;
		return _2 != null
				? _2.equals(tuple2._2)
				: tuple2._2 == null;
	}

	@Override
	public int hashCode() {
		int result = _1 != null
				? _1.hashCode()
				: 0;
		result = 31 * result + (_2 != null
				? _2.hashCode()
				: 0);
		return result;
	}

	@Override
	public String toString() {
		return "Tuple2{" + "_1=" + _1 + ", _2=" + _2 + '}';
	}
}
