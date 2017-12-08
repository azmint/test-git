package jp.programmer.gi.lib.collection;

import jp.programmer.gi.lib.*;

import java.util.*;
import java.util.function.*;

public interface IStreamList<E> extends Iterable<E> {
	IStreamList<E> add(E e);

	IStreamList<E> addFirst(E e);

	IStreamList<E> add(WithIndex<? extends E> withIndex);

	IStreamList<E> remove(E e);

	IStreamList<E> remove(int index);

	Optional<E> get(int index);

	E getOrElse(WithIndex<? extends E> withIndex);

	Optional<E> first();

	Optional<E> first(Predicate<? super E> predicate);

	Optional<E> last();

	Optional<E> last(Predicate<? super E> predicate);

	IStreamList<E> set(E e);

	IStreamList<E> set(WithIndex<? extends E> withIndex);

	IStreamList<E> set(Predicate<? super E> predicate, E e);

	IStreamList<E> subList(int from, int to);

	IStreamList<E> skip(int count);

	IStreamList<E> limit(int count);

	IStreamList<E> filter(Predicate<? super E> predicate);

	int size();

	boolean isEmpty();

	boolean nonEmpty();

	@Override
	Iterator<E> iterator();

	@Override
	int hashCode();

	@Override
	boolean equals(Object obj);

	@Override
	String toString();
}
