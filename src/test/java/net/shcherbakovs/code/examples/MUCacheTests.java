package net.shcherbakovs.code.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MUCacheTests {

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
}
