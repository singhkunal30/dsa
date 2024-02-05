package graph;

import java.util.ArrayList;

public class GraphNodeAL {
	
	public String name;
	public int index;
	public boolean isVisited = false;	
	
	public ArrayList<GraphNodeAL> neighbours = new ArrayList<>();
	
	public GraphNodeAL(String name, int index) {
		this.name = name;
		this.index = index;
	}

}
