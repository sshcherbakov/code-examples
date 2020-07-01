package net.shcherbakovs.code.examples;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Simple Least Recently Used cache implementation
 * @param <K>
 * @param <V>
 */
public class LRUCache2<K, V> {

	class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
		public LRULinkedHashMap(int size) {
			super(size, 0.75f, true);
		}
		protected boolean removeEldestEntry(Map.Entry eldest) {
             return size() > size;
          }
	}

	private final LinkedHashMap<K, V> storage;
	private final int size;

	public LRUCache2(int size) {
		this.size = size;
		this.storage = new LRULinkedHashMap<>(size);
	}

	public void put(K key, V value) {
		storage.put(key, value);
	}

	public V get(K key) {
		return storage.get(key);
	}
}
