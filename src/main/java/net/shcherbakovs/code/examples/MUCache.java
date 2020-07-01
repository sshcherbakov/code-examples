package net.shcherbakovs.code.examples;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Most Used cache implementation
 * @param <K>
 * @param <V>
 */
public class MUCache<K, V> {

	class Mark implements Comparable<Mark> {
		private final Long count;
		private final K key;

		public Mark(K key) {
			if(key == null) {
				throw new IllegalArgumentException();
			}
			this.key = key;
			this.count = 1L;
		}

		@Override
		public int compareTo(Mark m) {
			return this.count.compareTo(m.count);
		}

		@Override
		public boolean equals(Object m) {
			if(!(m instanceof MUCache.Mark)) {
				return false;
			}
			return this.key.equals(((MUCache.Mark) m).key);
		}
	}

	private final PriorityQueue<Mark> pq;
	private final HashMap<K, V> storage;
	private final HashMap<K, Long> counts;
	private final int size;

	public MUCache(int size) {
		this.size = size;
		this.storage = new HashMap<>(size);
		this.pq = new PriorityQueue<>();
		this.counts = new HashMap<>(size);
	}

	public void put(K key, V value) {
		updateCount(key);
		storage.put(key, value);
		refresh();
	}

	public V get(K key) {
		updateCount(key);
		V res = storage.get(key);
		refresh();
		return res;
	}

	private void updateCount(K key) {
		Long c = counts.get(key);
		if(c == null) {
			c = 0L;
		}
		counts.put(key, c++);
		final Mark e = new Mark(key);
		pq.remove(e);
		pq.offer(e);
	}

	private void refresh() {
		while(pq.size() > size) {
			Mark m = pq.poll();
			storage.remove(m.key);
			counts.remove(m.key);
		}
	}
}
