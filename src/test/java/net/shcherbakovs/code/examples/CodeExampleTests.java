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

	}

}
