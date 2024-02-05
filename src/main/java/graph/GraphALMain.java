package graph;

import java.util.ArrayList;

public class GraphALMain {
	
	public static void main(String[] args) {
		ArrayList<GraphNodeAL> nodeList = new ArrayList<>();
		nodeList.add(new GraphNodeAL("A", 0));
		nodeList.add(new GraphNodeAL("B", 1));
		nodeList.add(new GraphNodeAL("C", 2));
		nodeList.add(new GraphNodeAL("D", 3));
		nodeList.add(new GraphNodeAL("E", 4));
		
		GraphAL g = new GraphAL(nodeList);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(0, 2);
		g.addUndirectedEdge(0, 3);
		g.addUndirectedEdge(1, 4);
		g.addUndirectedEdge(2, 3);
		g.addUndirectedEdge(3, 4);
		
		System.out.println(g.toString());
	}
}
