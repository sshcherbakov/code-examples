package net.shcherbakovs.code.examples;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.*;

public class Questions {

	/**
	 * @param sample - string
	 * @return - true if the string contains all unique characters
	 */
	public static boolean allUniqueChars(String sample) {
		int[] counts = new int[128];
		for(char c : sample.toCharArray()) {
			counts[c]++;
			if(counts[c] > 1) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param sample1 - first string
	 * @param sample2 - second string
	 * @return - true if strings are permutations of each other
	 */
	public static boolean onePermutationOfAnother(String sample1, String sample2) {
		if(sample1.length() != sample2.length()) {
			return false;
		}
		int[] counts1 = new int[128];
		for(char c : sample1.toCharArray()) {
			counts1[c]++;
		}
		for(char c : sample2.toCharArray()) {
			counts1[c]--;
			if(counts1[c] < 0) {
				return false;
			}
		}
		return true;
	}

	@Data
	@AllArgsConstructor
	@EqualsAndHashCode
	static class Point {
		private float x;
		private float y;
	}

	/**
	 * Returns point of intersection of two lines defined by two points each
	 * @param p1 - first point on the first line
	 * @param p2 - second point on the first line
	 * @param q1 - first point on the second line
	 * @param q2 - second point on the second line
	 * @return
	 */
	public static Point intersection(Point p1, Point p2, Point q1, Point q2) {
		if(p1.x == p2.x || q1.x == q2.x) {
			return null;
		}
		float k1 = (p2.y - p1.y) / (p2.x - p1.x);
		float b1 = p1.y - k1 * p1.x;
		float k2 = (q2.y - q1.y) / (q2.x - q1.x);
		float b2 = q1.y - k2 * q1.x;

		if( k1 == k2 ) {
			return null;
		}

		float x = (b2 - b1) / (k1 - k2);
		float y = k1 * x + b1;

		return new Point(x, y);
	}

}
