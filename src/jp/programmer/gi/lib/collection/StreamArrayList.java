package jp.programmer.gi.lib.collection;

import java.util.*;

public final class StreamArrayList<E> {
	private final List<E> elements;

	private StreamArrayList(List<E> elements) {
		this.elements = elements;
	}
}
