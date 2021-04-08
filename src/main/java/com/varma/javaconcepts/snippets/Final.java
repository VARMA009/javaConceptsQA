package com.varma.javaconcepts.snippets;

public class Final {

	int a = 30;
	final int e = 90;
	static int d;
	// Condition based assignment of value to final variable,tricky part here is you
	// should use only static value in the condition
	static final int c = d > 40 ? 1 : 2;

	// since the static parts get loaded first before the object initialization, we
	// will get compile time error below
	// static final int f = e > 40 ? 1 : 2;

	public static void main(String[] args) {
		// The statement below denotes the blank assignment to final variable
		final int assign;
		Final b = new Final();
		process(b);
		System.out.println(b.a);
		process(b);
		assign = b.a;
		System.out.println(assign);
		// The below statement throws compile time error because,we can set value to
		// final variable twice
		// assign=b.a
	}

	public static void process(Final a) {
		a.a = a.a + 5;
	}
}
