package jp.programmer.gi.lib.collection;

import jp.programmer.gi.lib.*;
import jp.programmer.gi.lib.range.*;
import jp.programmer.gi.lib.validate.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public final class StreamArrayList<E> implements IStreamList<E> {
	private static final StreamArrayList EMPTY = new StreamArrayList<>(Collections.emptyList());

	private final List<E> elements;

	private StreamArrayList(Collection<? extends E> elements) {
		this.elements = Validate.of(elements).ifNull("コレクションが指定されていません。").map(ArrayList<E>::new).get();
	}

	public static <E> StreamArrayList<E> of(Collection<? extends E> collection) {
		return new StreamArrayList<>(collection);
	}

	public static <E> StreamArrayList<E> empty() {
		return EMPTY;
	}

	@Override
	public List<E> toMutable() {
		return new ArrayList<>(this.elements);
	}

	@Override
	public Range range() {
		int last = this.isEmpty() ? 0 : this.size() - 1;
		return Range.zeroTo(last);
	}

	@Override
	public Optional<Integer> indexOf(E e) {
		List<E> result = this.toMutable();
		int index = result.indexOf(e);
		return index < 0 ? Optional.empty() : Optional.of(index);
	}

	@Override
	public IStreamList<E> add(E e) {
		List<E> result = this.toMutable();
		result.add(e);
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> addFirst(E e) {
		List<E> result = this.toMutable();
		result.add(0, e);
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> add(WithIndex<? extends E> withIndex) {
		List<E> result = this.toMutable();
		result.add(withIndex.index(), withIndex.value());
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> addAll(IStreamList<? extends E> list) {
		List<E> result = this.toMutable();
		result.addAll(list.toMutable());
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> remove(E e) {
		List<E> result = this.toMutable();
		result.remove(e);
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> remove(int index) {
		List<E> result = this.toMutable();
		result.remove(index);
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> removeFirst() {
		List<E> result = this.toMutable();
		if (this.nonEmpty()) result.remove(0);
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> removeLast() {
		List<E> result = this.toMutable();
		if (this.nonEmpty()) result.remove(this.range().end());
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> removeAll(IStreamList<? extends E> list) {
		List<E> result = this.toMutable();
		result.removeAll(list.toMutable());
		return new StreamArrayList<>(result);
	}

	@Override
	public Optional<E> get(int index) {
		boolean contains = this.range().contains(index);
		return contains ? Optional.of(this.elements.get(index)) : Optional.empty();
	}

	@Override
	public E getOrElse(WithIndex<? extends E> withIndex) {
		Optional<E> maybe = this.get(withIndex.index());
		return maybe.orElse(withIndex.value());
	}

	@Override
	public Optional<E> first() {
		return this.isEmpty() ? Optional.empty() : Optional.of(this.elements.get(0));
	}

	@Override
	public Optional<E> first(Predicate<? super E> predicate) {
		IStreamList<E> targets = this.filter(predicate);
		return targets.first();
	}

	@Override
	public Optional<E> last() {
		return this.isEmpty() ? Optional.empty() : Optional.of(this.elements.get(this.range().end()));
	}

	@Override
	public Optional<E> last(Predicate<? super E> predicate) {
		IStreamList<E> targets = this.filter(predicate);
		return targets.last();
	}

	@Override
	public IStreamList<E> applyIf(Predicate<? super E> predicate, Function<? super E, ? extends E> mapper) {
		return this.map(e -> predicate.test(e) ? mapper.apply(e) : e);
	}

	@Override
	public IStreamList<E> commit(E e) {
		Optional<Integer> maybeIndex = this.indexOf(e);
		Optional<WithIndex<E>> maybeWithIndex = maybeIndex.map(index -> WithIndex.of(e, index));
		return maybeWithIndex.map(this::set).orElse(this);
	}

	@Override
	public IStreamList<E> set(WithIndex<? extends E> withIndex) {
		List<E> result = this.toMutable();
		result.set(withIndex.index(), withIndex.value());
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> set(Predicate<? super E> predicate, E e) {
		return this.applyIf(predicate, value -> e);
	}

	@Override
	public IStreamList<E> subList(int from, int to) {
		List<E> result = new ArrayList<>(this.elements.subList(from, to));
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> skip(int count) {
		List<E> result = this.elements.stream().skip(count).collect(Collectors.toList());
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> limit(int count) {
		List<E> result = this.elements.stream().limit(count).collect(Collectors.toList());
		return new StreamArrayList<>(result);
	}

	@Override
	public IStreamList<E> filter(Predicate<? super E> predicate) {
		List<E> result = this.elements.stream().filter(predicate).collect(Collectors.toList());
		return new StreamArrayList<>(result);
	}

	@Override
	public <R> R reduce(R init, BiFunction<R, E, R> biFunction) {
		R result = init;
		for (E e : this.elements) { result = biFunction.apply(result, e); }
		return result;
	}

	@Override
	public <R> IStreamList<R> map(Function<? super E, ? extends R> mapper) {
		List<R> result = this.elements.stream().map(mapper).collect(Collectors.toList());
		return new StreamArrayList<>(result);
	}

	@Override
	public <R> IStreamList<R> flatMap(Function<? super E, ? extends IStreamList<? extends R>> mapper) {
		return this.reduce(IStreamList.empty(), (process, e) -> process.addAll(mapper.apply(e)));
	}

	@Override
	public int size() {
		return this.elements.size();
	}

	@Override
	public Iterator<E> iterator() {
		return this.elements.iterator();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		StreamArrayList<?> that = (StreamArrayList<?>) o;

		return elements.equals(that.elements);
	}

	@Override
	public int hashCode() {
		return elements.hashCode();
	}

	@Override
	public String toString() {
		return "StreamArrayList{" + "elements=" + elements + '}';
	}
}
