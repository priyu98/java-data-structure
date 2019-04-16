package StackDemo;

public class StackTest {
	/*
	 * 字符串反转
	 */
	public static void ReverseStr(String str) {
		char[] arr=str.toCharArray();
		int len=str.length();
		StackX stack=new StackX(len);
		for(int i=0;i<len;i++) {
			stack.push(arr[i]);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}
	
	/*
	 * 分隔符匹配
	 * 判断一个含有{的表达式一定有一个}, ()[]同理
	 */
	public static void BracketCheck(String str) {
		char[] arr=str.toCharArray();
		int len=str.length();
		StackX stack=new StackX(len);
		for(int i=0;i<len;i++) {
			char ch=arr[i];
			switch(ch) {
				case '{':
				case '(':
				case '[':
					stack.push(ch);
					break;
				case '}':
				case ')':
				case ']':
					if(!stack.isEmpty()) {
						char chx=stack.pop();
						if((ch=='{' && chx!='}') || (ch=='(' && chx!=')') || (ch=='[' && chx!=']')) {
							System.out.println("Error: " + ch +" at " +i);
						}
					}
					else {
						System.out.println("Error: " + ch +" at " +i);
					}
					break;
			}
		}
		if(!stack.isEmpty()) {
			System.out.println("缺少右括号");
		}
	}
	
	/*
	 * 后缀表达式
	 */
	public static void Positfix(String str) {
		String pos="";
		char[] arr=str.toCharArray();
		int len=str.length();
		StackX stack=new StackX(len);
		for(int i=0;i<len;i++) {
			char ch=arr[i];
			switch(ch) {
				case '(':
					stack.push(ch);
					break;
				case '+':
				case '-':
					while(!stack.isEmpty()) {
						char temp=stack.pop();
						if(temp=='(') {
							stack.push(temp);
							break;
						}
						pos+=temp;
					}
					stack.push(ch);
					break;
				case '/':
				case '*':
					while(!stack.isEmpty()) {
						char temp=stack.pop();
						if(temp=='(' || temp=='+' || temp=='-') {
							stack.push(temp);
							break;
						}
						pos+=temp;
					}
					stack.push(ch);
					break;
				case ')':
					while(!stack.isEmpty()) {
						char temp=stack.pop();
						if(temp==')')
							break;
						pos+=temp;
					}
					break;
				default:
					pos+=ch;
					break;
			}
		}
		while(!stack.isEmpty()) {
			pos+=stack.pop();
		}
		System.out.println(pos);
	}
	
	public static void main(String[] args) {
		ReverseStr("hello world");
		BracketCheck("a(b)");
		Positfix("a+b*c");
	}
}
