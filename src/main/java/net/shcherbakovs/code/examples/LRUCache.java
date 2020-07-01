package net.shcherbakovs.code.examples;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Simple Least Recently Used cache implementation
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> {

	class Mark implements Comparable<Mark> {
		private final Long timestamp;
		private final K key;

		public Mark(K key) {
			if(key == null) {
				throw new IllegalArgumentException();
			}
			this.key = key;
			this.timestamp = System.nanoTime();
		}

		@Override
		public int compareTo(Mark m) {
			return this.timestamp.compareTo(m.timestamp);
		}

		@Override
		public boolean equals(Object m) {
			if(!(m instanceof LRUCache.Mark)) {
				return false;
			}
			return this.key.equals(((LRUCache.Mark) m).key);
		}
	}

	private final PriorityQueue<Mark> timestamps;
	private final HashMap<K, V> storage;
	private final int size;

	public LRUCache(int size) {
		this.size = size;
		this.storage = new HashMap<>(size);
		this.timestamps = new PriorityQueue<>();
	}

	public void put(K key, V value) {
		updateTimestamp(key);
		storage.put(key, value);
		refresh();
	}

	public V get(K key) {
		updateTimestamp(key);
		V res = storage.get(key);
		refresh();
		return res;
	}

	private void updateTimestamp(K key) {
		final Mark e = new Mark(key);
		timestamps.remove(e);
		timestamps.offer(e);
	}

	private void refresh() {
		while(timestamps.size() > size) {
			Mark m = timestamps.poll();
			storage.remove(m.key);
		}
	}
}
