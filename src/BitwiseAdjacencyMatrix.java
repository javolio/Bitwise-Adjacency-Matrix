//----------------------------------------------------------------
//Joseph Avolio
//11/08/2011
//COSC 310
//----------------------------------------------------------------
public class BitwiseAdjacencyMatrix implements NonWeightedGraph {
	// Do not modify from here...
	public final byte[] graph;
	private final int n;// The number of vertices this graph contains
	
	// atLeastN will round up to the next greatest power of 2
	public BitwiseAdjacencyMatrix(int atLeastN) {
		n=(--atLeastN>>>3)+1<<3;
		graph=new byte[n*n>>>3];
		// store a full row in a series of bytes then move on to the next row
	}
	
	// ...to here and do not add any other fields!!!
	
	// NOTES:
	// The vertices are named [0 to (n-1)]
	// Every other field you can think of can be calculated from n.
	
	@Override
	//Add an edge from A to B (Directional)
	public void addEdge(int vertexA,int vertexB) {
		int i=vertexA*(n>>>3)+(vertexB>>>3); //Calculate the index in graph
		graph[i]=(byte) (graph[i]|1<<7-(vertexB&7)); //Make the change
	}
	
	@Override
	//Remove an edge from A to B (Directional)
	public void removeEdge(int vertexA,int vertexB) {
		int i=vertexA*(n>>>3)+(vertexB>>>3); //Calculate the index in graph
		graph[i]=(byte) ~(~graph[i]|1<<7-(vertexB&7)); //Make the change
	}
	
	@Override
	//Test for an edge from A to B (Directional)
	public boolean hasEdge(int vertexA,int vertexB) {
		return (graph[vertexA*(n>>>3)+(vertexB>>>3)]&1<<7-(vertexB&7))!=0;
	}
	
	@Override
	//Return all vertices A has a direct edge to (empty array when none)
	public int[] getVerticesFrom(int vertexA) {
		int[] vertices=new int[n]; //Temporary storage
		int s=0;//Size
		for (int b=0;b<n;b++) { //Check all vertices
			if ((graph[vertexA*(n>>>3)+(b>>>3)]&1<<7-(b&7))!=0) { //If A->B exists
				vertices[s++]=b; //Increase the size, and add the vertex to the array
			}
		}
		int[] v2=new int[s]; //Compressed array
		for (int i=0;i<s;v2[i]=vertices[i++]); //Crop the excess space in vertices
		return v2;
	}
	
	@Override
	//Return all vertices that have a direct edge to A (empty array when none)
	public int[] getVerticesTo(int vertexA) {
		int[] vertices=new int[n]; //Temporary storage
		int s=0; //Size
		for (int b=0;b<n;b++) { //Check all vertices
			if ((graph[b*(n>>>3)+(vertexA>>>3)]&1<<7-(vertexA&7))!=0) { //If B->A exists
				vertices[s++]=b; //Increase the size, and add the vertex to the array
			}
		}
		int[] v2=new int[s]; //Compressed array
		for (int i=0;i<s;v2[i]=vertices[i++]); //Crop the excess space in vertices
		return v2;
	}
	
	//For reference:
	/*public boolean checkBit(byte b,byte bit) {
		return (b&(1<<(7-bit))!=0;
	}
	
	public byte setBit(byte b,byte bit,boolean on) {
		if (on) {
			if (!checkBit(b,bit)
				return (byte) (b|(1<<(7-bit)));
			else return b;
		} else {
			if (checkBit(b,bit)
				return (byte) (b^(1<<(7-bit)));
			else return b;
		}
	}*/
}
