package jp.programmer.gi.lib.collection;

import jp.programmer.gi.lib.*;
import jp.programmer.gi.lib.range.*;

import java.util.*;
import java.util.function.*;

public interface IStreamList<E> extends Iterable<E> {
	static <E> IStreamList<E> empty() {
		return StreamArrayList.empty();
	}

	List<E> toMutable();

	Range range();

	Optional<Integer> indexOf(E e);

	IStreamList<E> add(E e);

	IStreamList<E> addFirst(E e);

	IStreamList<E> add(WithIndex<? extends E> withIndex);

	IStreamList<E> addAll(IStreamList<? extends E> list);

	IStreamList<E> remove(E e);

	IStreamList<E> remove(int index);

	IStreamList<E> removeFirst();

	IStreamList<E> removeLast();

	IStreamList<E> removeAll(IStreamList<? extends E> list);

	Optional<E> get(int index);

	E getOrElse(WithIndex<? extends E> withIndex);

	Optional<E> first();

	Optional<E> first(Predicate<? super E> predicate);

	Optional<E> last();

	Optional<E> last(Predicate<? super E> predicate);

	IStreamList<E> applyIf(Predicate<? super E> predicate, Function<? super E, ? extends E> mapper);

	IStreamList<E> commit(E e);

	IStreamList<E> set(WithIndex<? extends E> withIndex);

	IStreamList<E> set(Predicate<? super E> predicate, E e);

	IStreamList<E> subList(int from, int to);

	IStreamList<E> skip(int count);

	IStreamList<E> limit(int count);

	IStreamList<E> filter(Predicate<? super E> predicate);

	<R> R reduce(R init, BiFunction<R, E, R> biFunction);

	<R> IStreamList<R> map(Function<? super E, ? extends R> mapper);

	<R> IStreamList<R> flatMap(Function<? super E, ? extends IStreamList<? extends R>> mapper);

	int size();

	default boolean isEmpty() {
		return !this.nonEmpty();
	}

	default boolean nonEmpty() {
		return this.size() > 0;
	}

	@Override
	Iterator<E> iterator();

	@Override
	int hashCode();

	@Override
	boolean equals(Object obj);

	@Override
	String toString();
}
