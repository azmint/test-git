package jp.programmer.gi.lib.tuple;

public interface ITuple2<A, B> {
	A _1();

	B _2();

	@Override
	int hashCode();

	@Override
	boolean equals(Object obj);

	@Override
	String toString();
}
