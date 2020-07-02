package net.shcherbakovs.code.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LRUCacheTests {

	@Test
	public void testLRU() {
		LRUCache<String, String> lruCache = new LRUCache<>(2);
		lruCache.put("key1", "value1");
		lruCache.put("key2", "value2");
		lruCache.put("key3", "value3");
		lruCache.put("key1", "value11");

		assertEquals("value11", lruCache.get("key1"));
		assertEquals("value3", lruCache.get("key3"));
		assertNull(lruCache.get("key2"));

		lruCache = new LRUCache<>(1);
		lruCache.put("key1", "value1");
		lruCache.put("key2", "value2");
		lruCache.put("key3", "value3");
		lruCache.put("key1", "value11");

		assertEquals("value11", lruCache.get("key1"));
		assertNull(lruCache.get("key3"));
		assertNull(lruCache.get("key2"));

		lruCache = new LRUCache<>(4);
		lruCache.put("key1", "value1");
		lruCache.put("key2", "value2");
		lruCache.put("key3", "value3");
		lruCache.put("key1", "value11");

		assertEquals("value11", lruCache.get("key1"));
		assertEquals("value3", lruCache.get("key3"));
		assertEquals("value2", lruCache.get("key2"));

		LRUCache<Integer, Integer> lru = new LRUCache<>(2);
		lru.put(1, 1);
		lru.put(2, 2);
		assertEquals(1, lru.get(1).intValue());
		lru.put(3, 3);
		assertNull(lru.get(2));
		lru.put(4, 4);
		assertNull(lru.get(1));
		assertEquals(3, lru.get(3).intValue());
		assertEquals(4, lru.get(4).intValue());
	}

}
