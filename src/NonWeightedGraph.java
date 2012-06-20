//This class represents a directional graph.
public interface NonWeightedGraph {// DO NOT MODIFY!!!

	// Add an edge from A to B (Directional)
	public void addEdge(int vertexA,int vertexB);
	
	// Remove an edge from A to B (Directional)
	public void removeEdge(int vertexA,int vertexB);
	
	// Test for an edge from A to B (Directional)
	public boolean hasEdge(int vertexA,int vertexB);
	
	// Return all vertices A has a direct edge to (empty array when none)
	public int[] getVerticesFrom(int vertexA);
	
	// Return all vertices that have a direct edge to A (empty array when none)
	public int[] getVerticesTo(int vertexA);
}
