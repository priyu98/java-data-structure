package StackDemo;
/*
 * 若两个栈大小相同, 队列容量为2n
 * 若m>n, 队列容量为2n+1
 */
public class QueueBy2Stack {
	private StackX s1;
	private StackX s2;
	
	public void insert(char ch) {
		if(!s1.isFull())
			s1.push(ch);
		else {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			s1.push(ch);
		}
	}
	
	public char remove() {
		if(!s2.isFull()) {
			return s2.pop();
		}
		else {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			return s2.pop();
		}
	}
	
	public char peek() {
		if(!s2.isFull()) {
			return s2.peek();
		}
		else {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			return s2.peek();
		}
	}
	
	public int size() {
		return s1.size()+s2.size();
	}
	
	public boolean isEmpty() {
		return (s1.isEmpty()&&s2.isEmpty());
	}
	
	public boolean isFull() {
		return (s1.isFull()&&s2.isFull());
	}
}
