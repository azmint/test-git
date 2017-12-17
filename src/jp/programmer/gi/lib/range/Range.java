package jp.programmer.gi.lib.range;

import jp.programmer.gi.lib.collection.*;
import jp.programmer.gi.lib.validate.*;

import java.util.*;

public final class Range implements Iterable<Integer> {
	private final int start;
	private final int end;
	private final IStreamList<Integer> list;

	private Range(int start, int end) {
		Validates.of(end).ifSo(value -> value < start, "endがstart未満です。");
		this.start = start;
		this.end = end;
		List<Integer> indexes = new ArrayList<>();
		for (int i = start; i < end; i++) indexes.add(i);
		this.list = StreamArrayList.of(indexes);
	}

	public static Range of(int start, int end) {
		return new Range(start, end);
	}

	public static Range zeroTo(int end) {
		return new Range(0, end);
	}

	public boolean contains(int value) {
		return this.start <= value && value <= this.end;
	}

	public boolean notContains(int value) {
		return !this.contains(value);
	}

	public int start() {
		return start;
	}

	public int end() {
		return end;
	}

	@Override
	public Iterator<Integer> iterator() {
		return this.list.iterator();
	}
}
