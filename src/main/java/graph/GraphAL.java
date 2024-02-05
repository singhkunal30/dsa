package graph;

import java.util.ArrayList;

public class GraphAL {
	ArrayList<GraphNodeAL> nodeList = new ArrayList<GraphNodeAL>();
	
	public GraphAL(ArrayList<GraphNodeAL> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void addUndirectedEdge(int i, int j) {
		GraphNodeAL first = nodeList.get(i);
		GraphNodeAL second = nodeList.get(j);
		first.neighbours.add(second);
		second.neighbours.add(first);
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(int i=0; i<nodeList.size(); i++) {
			s.append(nodeList.get(i).name+": ");
			for(int j=0; j<nodeList.get(i).neighbours.size(); j++) {
				if(j == nodeList.get(i).neighbours.size()-1 ) {
					s.append(nodeList.get(i).neighbours.get(j).name);
				}
				else {
					s.append(nodeList.get(i).neighbours.get(j).name+ " -> ");
				}
			}
			s.append("\n");
		}
		return s.toString();
	}
}
