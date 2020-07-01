package net.shcherbakovs.code.examples;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodeExampleTests {

	@Test
	public void testMU() {
		MUCache<String, String> MUCache = new MUCache<>(2);
		MUCache.put("key1", "value1");
		MUCache.get("key1");
		MUCache.put("key2", "value2");
		MUCache.put("key3", "value3");
		MUCache.get("key3");
		MUCache.put("key1", "value11");

		assertEquals("value3", MUCache.get("key3"));
		assertEquals("value11", MUCache.get("key1"));
		assertNull(MUCache.get("key2"));

	}

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

	@Test
	public void testLRU2() {
		LRUCache2<String, String> lruCache = new LRUCache2<>(2);
		lruCache.put("key1", "value1");
		lruCache.put("key2", "value2");
		lruCache.put("key3", "value3");
		lruCache.put("key1", "value11");

		assertEquals("value11", lruCache.get("key1"));
		assertEquals("value3", lruCache.get("key3"));
		assertNull(lruCache.get("key2"));

		lruCache = new LRUCache2<>(1);
		lruCache.put("key1", "value1");
		lruCache.put("key2", "value2");
		lruCache.put("key3", "value3");
		lruCache.put("key1", "value11");

		assertEquals("value11", lruCache.get("key1"));
		assertNull(lruCache.get("key3"));
		assertNull(lruCache.get("key2"));

		lruCache = new LRUCache2<>(4);
		lruCache.put("key1", "value1");
		lruCache.put("key2", "value2");
		lruCache.put("key3", "value3");
		lruCache.put("key1", "value11");

		assertEquals("value11", lruCache.get("key1"));
		assertEquals("value3", lruCache.get("key3"));
		assertEquals("value2", lruCache.get("key2"));

		LRUCache2<Integer, Integer> lru = new LRUCache2<>(2);
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
