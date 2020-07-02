package net.shcherbakovs.code.examples;

import org.junit.Test;

import static net.shcherbakovs.code.examples.Questions.*;
import static org.junit.Assert.*;

public class QuestionsTests {

	@Test
	public void testStringHasAlUniqueCharacters() {
		assertFalse(allUniqueChars("Quick brown fox jumped over a lazy dog"));
		assertTrue(allUniqueChars("abcdef"));
		assertTrue(allUniqueChars("1"));
		assertTrue(allUniqueChars(""));
		assertFalse(allUniqueChars("    "));
	}

	@Test
	public void testOnePermutationOfAnother() {
		assertTrue(onePermutationOfAnother("abcdef", "fedcba"));
		assertFalse(onePermutationOfAnother("abcdef", "fedcaa"));
		assertTrue(onePermutationOfAnother("a", "a"));
		assertTrue(onePermutationOfAnother("Hello, World!", "!Hello, World"));
		assertFalse(onePermutationOfAnother("Hello, World!", "!Hello, World!"));
		assertFalse(onePermutationOfAnother("aa", "ab"));
	}

	@Test
	public void testIntersection() {
		assertEquals(new Point(1f, 1f), intersection(
			new Point(0f, 0f), new Point(1f, 1f),
			new Point(2f, 0f), new Point(0f, 2f)));

		assertNull(intersection(
			new Point(0f, 0f), new Point(1f, 1f),
			new Point(1f, 0f), new Point(2f, 1f)));
	}

}