package TreeDemo;

public class Btree {
	private Node root;
	
	public Btree() {
		this.root=null;
	}
	
	class Node{
		int value;
		Node leftchild;
		Node rightchild;
	}
	
	public void insert(int key) {
		Node newnode=new Node();
		newnode.value=key;
		
		Node current=root;
		Node parent;
		if(root==null)
			root=newnode;
		else {
			while(true) {
				parent=current;
				if(key<current.value) {
					current=current.leftchild;
					if(current==null) {
						parent.leftchild=newnode;
						return;
					}
				}
				else {
					current=current.rightchild;
					if(current==null) {
						parent.rightchild=newnode;
						return;
					}
				}
			}
		}
	}
	
	public Node find(int key) {
		Node current=root;
		while(current.value!=key) {
			if(key<current.value)
				current=current.leftchild;
			else
				current=current.rightchild;
			if(current==null)
				return null;
		}
		return current;
	}
	
	public boolean delete(int key) {
		Node current=root;
		Node parent=root;
		boolean isLeftChild=true;
		
		while(current.value!=key) {
			parent=current;
			if(key<current.value) {
				current=current.leftchild;
				isLeftChild=true;
			}
			else {
				current=current.rightchild;
				isLeftChild=false;
			}
			if(current==null)
				return false;
		}
		
		//要删除的节点没有子节点
		if(current.leftchild==null && current.rightchild==null) {
			if(current==root)
				root=null;
			else if(isLeftChild)
				parent.leftchild=null;
			else
				parent.rightchild=null;
		}
		
		//要删除的节点只有一个子节点
		else if(current.leftchild!=null && current.rightchild==null) {
			if(current==root)
				root=current.leftchild;
			else if(isLeftChild)
				parent.leftchild=current.leftchild;
			else
				parent.rightchild=current.rightchild;
		}
		else if(current.rightchild!=null && current.leftchild==null) {
			if(current==root)
				root=current.rightchild;
			else if(isLeftChild)
				parent.leftchild=current.rightchild;
			else
				parent.rightchild=current.rightchild;
		}
		
		//要删除的节点有两个子节点，用中序后继节点代替删除节点，但后继节点不能有左子节点
		else {
			Node Successor=getSuccessor(current);
			
			if(current==root)
				root=Successor;
			else if(isLeftChild)
				parent.leftchild=Successor;
			else
				parent.rightchild=Successor;
			Successor.leftchild=current.leftchild;
		}
		return true;
	}
	
	//找到中序后继节点
	private Node getSuccessor(Node delnode) {
		Node SuccessorParent=delnode;
		Node Successor=delnode;
		Node current=delnode.rightchild;
		
		while(current!=null) {
			SuccessorParent=Successor;
			Successor=current;
			current=current.leftchild;
		}
		
		if(Successor!=delnode.rightchild) {
			SuccessorParent.leftchild=Successor.rightchild;
			Successor.rightchild=delnode.rightchild;
		}
		return Successor;
	}
	
	public void preOrder(Node current) {
		if(current!=null) {
			System.out.print(current.value+" ");
			preOrder(current.leftchild);
			preOrder(current.rightchild);
		}
	}
	
	public void inOrder(Node current) {
		if(current!=null) {
			inOrder(current.leftchild);
			System.out.print(current.value+" ");
			inOrder(current.rightchild);
		}
	}
	
	public void postOrder(Node current) {
		if(current!=null) {
			postOrder(current.leftchild);
			postOrder(current.rightchild);
			System.out.print(current.value+" ");
		}
	}
}
