package StackDemo;
/*
 * 数组实现栈
 */
public class StackX {
	private char[] arr;
	private int size;
	private int top;
	
	public StackX(int size) {
		this.size=size;
		this.arr=new char[size];
		this.top=-1;
	}
	
	public void push(char c) {
		arr[++top]=c;
	}
	
	public char pop() {
		return arr[top--];
	}
	
	public char peek() {
		return arr[top];
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return (top==-1);
	}
	
	public boolean isFull() {
		return (top==(size-1));
	}
}
