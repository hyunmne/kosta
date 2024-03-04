package test;

import java.util.Stack;

public class StackTest1 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		Stack<Person> pstack = new Stack<>();
		pstack.push(new Person("hong", 20));
		pstack.push(new Person("song", 10));
		while(!pstack.isEmpty()) {
			System.out.println(pstack.pop().info());
		}
	}
}
