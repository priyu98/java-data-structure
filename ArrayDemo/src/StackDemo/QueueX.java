package StackDemo;

public class QueueX {
	private char[] arr;
	private int size;
	private int front;
	private int rear;
	
	public QueueX(int size) {
		this.arr=new char[size];
		this.size=size;
		this.front=0;
		this.rear=0;
	}
	
	public void insert(char ch) {
		arr[rear]=ch;
		rear=(rear+1)%size;
	}
	
	public char remove() {
		char temp=arr[front];
		front=(front+1)%size;
		return temp;
	}
	
	public char peek() {
		return arr[front];
	}
	
	public boolean isEmpty() {
		return (front==rear);
	}
	
	public boolean isFull() {
		return ((rear+1)%size==front);
	}
}
