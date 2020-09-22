
public class Graph {
private final int MAX_VERTS = 20;
private Vertex vertexlist[];
private int adjMat[][];
private int nVerts;

public Graph()
{
	vertexlist = new Vertex[MAX_VERTS];
	adjMat = new int[MAX_VERTS][MAX_VERTS];
	nVerts = 0;
	for(int j=0; j<MAX_VERTS; j++)
	{
		for(int k=0; k<MAX_VERTS; k++)
		{
			adjMat[j][k] = 0;	
		}
	}
		
}

// adds vertices to graph
public void addVertex(char lab)
{
	vertexlist[nVerts++] = new Vertex(lab);
}

//adds an edge between pre-existing vertices
public void addEdge(int start, int end, int weight)
{
	
	adjMat[start][end] = weight;
	adjMat[end][start] = weight;
}

//removes edge between given vertices

public boolean removeEdge(int v, int w)
{
	if(adjMat[v][w] > 0)
	{
		adjMat[v][w] = 0;
		return true;
	}
	return false;
}
public char displayVertex(int v)
{
	return vertexlist[v].label;
}


//gets the neighbours of a vertex
public String getNeighbour(int v)
{
	String neighbours = "";
	for (int j = 0; j<nVerts; j++)
	{
	if (adjMat[v][j] >0)
	{
		if(v!=j)
		{
		neighbours += vertexlist[j].label + ",";
		}
	}
	else
	{
		return null;
	}
	}
	return neighbours.substring(0, neighbours.length()-1);
}

// get the degree of a vertex
public Integer getDegrees(int v)
{
	int degrees = 0;
	for (int j = 0; j<nVerts; j++)
	{
	if (adjMat[v][j] >0 && vertexlist[j].wasVisited == false)
	{
		if(v !=j)
		{
		degrees+=1;
		}
	}
	else
	{
		return null;
	}
	}
	return degrees;
}
// gets the weight of an edge between two vertices 
public Integer getWeight(int v, int w)
{
	int degrees = 0;
	 if(adjMat[v][w] > 0)
		 {
		return adjMat[v][w];
	}
	return null;
}
// check if edge exists betwen to vertices
public boolean hasEdge(int v, int w)
{
	if(adjMat[v][w] > 0)
	{
		return true;
	}
	return false;
}

}
