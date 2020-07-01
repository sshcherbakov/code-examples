package net.shcherbakovs.code.examples;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodeExampleTests {

	@Test
	public void testMRU() {
		MRUCache<String, String> mruCache = new MRUCache<>(2);
		mruCache.put("key1", "value1");
		mruCache.get("key1");
		mruCache.put("key2", "value2");
		mruCache.put("key3", "value3");
		mruCache.get("key3");
		mruCache.put("key1", "value11");

		assertEquals("value3", mruCache.get("key3"));
		assertEquals("value11", mruCache.get("key1"));
		assertNull(mruCache.get("key2"));

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
