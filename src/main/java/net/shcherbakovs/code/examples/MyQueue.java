package net.shcherbakovs.code.examples;

import java.util.Stack;

public class MyQueue<T> {

	private final Stack<T> newestStack = new Stack<>();
	private final Stack<T> oldestStack = new Stack<>();

	public void add(T e) {
		newestStack.push(e);
	}

	public T poll() {
		if(oldestStack.empty()) {
			while(!newestStack.empty()) {
				oldestStack.push(newestStack.pop());
			}
		}
		return oldestStack.pop();
	}

}
