package net.shcherbakovs.code.examples;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyQueueTests {

	@Test
	public void testMyQueue() {
		MyQueue<Integer> mq = new MyQueue<>();

		mq.add(1);
		mq.add(2);
		mq.add(3);
		mq.add(4);

		assertEquals(1, mq.poll().intValue());
		assertEquals(2, mq.poll().intValue());
		assertEquals(3, mq.poll().intValue());
		assertEquals(4, mq.poll().intValue());
	}

}
