package TreeDemo;

import java.util.*;

public class TierOrderTree {
	class Node{
		char value;
		Node leftchild;
		Node rightchild;
	}
	
	private Node root;
	
	public TierOrderTree(){
		this.root=null;
	}
	
	public void insert(Node current,int nodeid,char[] arr) {
		int len=arr.length;
		if(nodeid>=len)
			return;
		if(current==root) {
			root=new Node();
			root.value=arr[0];
			current=root;
		}
		else
			current.value=arr[nodeid];
		if((nodeid+1)*2<=len) {
			if(arr[(nodeid+1)*2-1]!='#') {
				Node newnode=new Node();
				newnode.value=arr[(nodeid+1)*2-1];
				current.leftchild=newnode;
				insert(current.leftchild,(nodeid+1)*2-1,arr);
			}
			if((nodeid+1)*2+1<=len) {
				if(arr[(nodeid+1)*2]!='#') {
					Node newnode=new Node();
					newnode.value=arr[(nodeid+1)*2];
					current.rightchild=newnode;
					insert(current.rightchild,(nodeid+1)*2,arr);
				}
			}
		}
	}
	
	public void tierOrder(Node current) {
		List<ArrayList<Character>> list=new ArrayList<ArrayList<Character>>();
		Queue<Node> queue=new LinkedList<Node>();
		ArrayList<Character> row=new ArrayList<Character>();
		queue.add(current);
		Node last=current;
		Node nlast=null;
		
		while(!queue.isEmpty()) {
			current=queue.remove();
			row.add(current.value);
			if(current.leftchild!=null) {
				queue.add(current.leftchild);
				nlast=current.leftchild;
			}
			if(current.rightchild!=null) {
				queue.add(current.rightchild);
				nlast=current.rightchild;
			}
			if(last==current) {
				last=nlast;
				list.add(row);
				row=new ArrayList<Character>();
			}
		}
		
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).size();j++) {
				System.out.print(list.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		String str="123##45#######6";
		TierOrderTree tree=new TierOrderTree();
		char[] arr=str.toCharArray();
		tree.insert(tree.root, 0, arr);
		tree.tierOrder(tree.root);
	}
}
