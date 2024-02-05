package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	int [][] adjacencyMatrix;
	
	public Graph(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		adjacencyMatrix = new int [nodeList.size()][nodeList.size()];
	}
	
	public void addUndirectedEdge(int i, int j) {
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("   ");
		for(int i=0; i<nodeList.size(); i++) {
			s.append(nodeList.get(i).name+" ");
		}
		s.append("\n");
		for(int i=0; i<nodeList.size(); i++) {
			s.append(nodeList.get(i).name+": ");
			for(int j : adjacencyMatrix[i]) {
				s.append((j) + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	public ArrayList<GraphNode> getNeighbours(GraphNode node){
		ArrayList<GraphNode> neighbours = new ArrayList<>();
		int nodeIndex = node.index;
		for(int i=0; i<adjacencyMatrix.length; i++) {
			if(adjacencyMatrix[nodeIndex][i] == 1) {
				neighbours.add(nodeList.get(i));
			}
		}
		return neighbours;
	}
	
	void BfsVisit(GraphNode node) {
		LinkedList<GraphNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode currentNode = queue.remove(0);
			currentNode.isVisited = true;
			System.out.println(currentNode.name+" ");
			ArrayList<GraphNode> neighbours = getNeighbours(currentNode);
			for(GraphNode neighbour: neighbours) {
				if(!neighbour.isVisited) {
					queue.add(currentNode);
				}
			}
		}
	}
	
	public void bfs() {
		for(GraphNode node: nodeList) {
			if(!node.isVisited) {
				BfsVisit(node);
			}
		}
	}
}
