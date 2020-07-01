package net.shcherbakovs.code.examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Simple Least Recently Used cache implementation
 * @param <K>
 * @param <V>
 */
public class LRUCache<K, V> {

	private final LinkedList<K> timestamps;
	private final HashMap<K, V> storage;
	private final int size;

	public LRUCache(int size) {
		this.size = size;
		this.storage = new HashMap<>(size);
		this.timestamps = new LinkedList<>();
	}

	public void put(K key, V value) {
		storage.put(key, value);
		updateTimestamp(key);
		refresh();
	}

	public V get(K key) {
		V res = storage.get(key);
		if(res != null) {
			updateTimestamp(key);
		}
		refresh();
		return res;
	}

	private void updateTimestamp(K key) {
		Iterator<K> it = timestamps.iterator();
		while(it.hasNext()) {
			K k = it.next();
			if(key.equals(k)) {
				it.remove();
				break;
			}
		}
		timestamps.addFirst(key);
	}

	private void refresh() {
		while(timestamps.size() > size) {
			K key = timestamps.pollLast();
			storage.remove(key);
		}
	}
}
