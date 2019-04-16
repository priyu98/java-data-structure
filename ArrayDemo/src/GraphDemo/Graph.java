package GraphDemo;

import java.util.*;

public class Graph {
	private final int MAX_VERTEX=20;
	private Vertex verList[];
	private int vnum;
	private int graphMatrix[][];
	
	public Graph() {
		this.verList=new Vertex[MAX_VERTEX];
		this.graphMatrix=new int[MAX_VERTEX][MAX_VERTEX];
		this.vnum=0;
		for(int i=0;i<MAX_VERTEX;i++) {
			for(int j=0;j<MAX_VERTEX;j++) {
				graphMatrix[i][j]=0;
			}
		}
	}
	
	public void insertVertex(char c) {
		Vertex newver=new Vertex(c);
		verList[vnum]=newver;
		vnum++;
	}
	
	public void insertEdge(int start, int end) {
		graphMatrix[start][end]=1;
		graphMatrix[end][start]=1;
	}
	
	public void showVertex(int v) {
		System.out.print(verList[v].values);
	}
	
	public int getUnvisitedAdjVertex(int v) {
		for(int i=0;i<vnum;i++) {
			if(graphMatrix[v][i]==1 && verList[i].ifVisit==false)
				return i;
		}
		return -1;
	}
	
	public void DFS() {
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(0);
		verList[0].ifVisit=true;
		showVertex(0);
		
		while(!stack.isEmpty()) {
			int temp=getUnvisitedAdjVertex(stack.peek());
			if(temp==-1)
				stack.pop();
			else {
				verList[temp].ifVisit=true;
				showVertex(temp);
				stack.push(temp);
			}
		}
		
		for(int i=0;i<vnum;i++) {
			verList[i].ifVisit=false;
		}
	}
	
	public void BFS() {
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(0);
		verList[0].ifVisit=true;
		showVertex(0);
		
		while(!queue.isEmpty()) {
			int temp1=queue.remove();
			int temp2;
			while((temp2=getUnvisitedAdjVertex(temp1))!=-1) {
				verList[temp2].ifVisit=true;
				showVertex(temp2);
				queue.add(temp2);
			}
		}
		
		for(int i=0;i<vnum;i++) {
			verList[i].ifVisit=false;
		}
	}
	
	public static void main(String[] args) {
		Graph graph=new Graph();
		graph.insertVertex('A');
		graph.insertVertex('B');
		graph.insertVertex('C');
		graph.insertVertex('D');
		graph.insertVertex('E');
		graph.insertVertex('F');
		graph.insertVertex('G');
		graph.insertVertex('H');
		graph.insertVertex('I');
		graph.insertEdge(0, 1);
		graph.insertEdge(0, 2);
		graph.insertEdge(0, 3);
		graph.insertEdge(0, 4);
		graph.insertEdge(1, 5);
		graph.insertEdge(3, 6);
		graph.insertEdge(5, 7);
		graph.insertEdge(6, 8);
		graph.DFS();
		System.out.println();
		graph.BFS();
	}
	
}
