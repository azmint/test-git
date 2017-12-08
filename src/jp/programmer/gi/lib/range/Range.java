package jp.programmer.gi.lib.range;

import jp.programmer.gi.lib.collection.*;

import java.util.*;

public final class Range implements Iterable<Integer> {
	private final int start;
	private final int end;
	private final IStreamList<Integer> list;

	private Range(int start, int end) {
		this.start = start;
		this.end = end;
		List<Integer> indexs = new ArrayList<>();
		for (int i = start; i < end; i++) indexs.add(i);
	}

	public static Range of(int start, int end) {
		return new Range(start, end);
	}

	public static Range zeroTo(int end) {
		return new Range(0, end);
	}

	@Override
	public Iterator<Integer> iterator() {
		return this.list.iterator();
	}
}
