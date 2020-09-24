

public class Graph {

private Vertex vertexlist[];
private int adjMat[][];
private int nVerts;
private int numEdges;
private int MAX_VERTS;
private final int INFINITY = 1000000; // see page 684 on data structures & algorithms in java - openlibrary.org
private int nTree;
private DistPar sPath[];
private int currentVert;
private int startToCurrent;
public Graph(int max_verts)
{
	MAX_VERTS = max_verts;
	vertexlist = new Vertex[MAX_VERTS];
	adjMat = new int[MAX_VERTS][MAX_VERTS];
	nVerts = 0;
	for(int j=0; j<(MAX_VERTS); j++)
	{
		for(int k=0; k<(MAX_VERTS); k++)
		{
			adjMat[j][k] = 0;
		}
	}
}

// adds vertices to graph
public void addVertex(String name)
{
	vertexlist[nVerts++] = new Vertex(name);
}

public void displayVertex(int V)
{
	System.out.println(vertexlist[V].label);
}
public int getPos(String name)
{
	String test = name;
	for (int i = 0; i < vertexlist.length; i++)
	{
		if (vertexlist[i] != null)
		{
			if (test.equals(vertexlist[i].label.toString()))
			{
			return i;
			}
		}
	}
	return -1;
	
}
public int numVerts()
{
	return vertexlist.length;
}

public int numEdges()
{
	return numEdges;
}

//adds an edge between pre-existing vertices
public void addEdge(int start, int end, int weight)
{
	
	adjMat[start][end] = weight;
	adjMat[end][start] = weight;
	numEdges++;
}
public void addDirEdge(int start, int end, int weight)
{
	
	adjMat[start][end] = weight;
	numEdges++;
}
//removes edge between given vertices

public boolean removeEdge(int v, int w)
{
	try
	{
	if(adjMat[v][w] > 0)
	{
		adjMat[v][w] = 0;
		adjMat[w][v] = 0;
		numEdges--;
		return true;
	}
	return false;
	}
	catch (Exception e)
	{
		return false;
	}
}
// check if edge exists between two vertices
public boolean hasEdge(int v, int w)
{
	if(adjMat[v][w] > 0)
	{
		return true;
	}
	return false;
}

public void path(int startTree)
{
	startTree = 0;
	vertexlist[startTree].isInTree = true;
	nTree = 1;
	for (int i = 0; i<nVerts; i++)
	{
		
		int tempDist = adjMat [startTree][i];
		sPath[i] = new DistPar(startTree, tempDist);
	}
	
	while (nTree < nVerts)
	{
		int indexMin = getMin();
		int minDist = sPath[indexMin].distance;
		
		if (minDist == INFINITY)
		{
			System.out.print("There are unreachable vertices");
			break;
		}
		else
		{
			currentVert = indexMin;
			startToCurrent = sPath[indexMin].distance;
		}
		vertexlist[currentVert].isInTree = true;
		nTree++;
		adjust_sPath();
	}
}

private int getMin() {
	// TODO Auto-generated method stub
	int minDist = INFINITY;
	int indexMin = 0;
	for (int i = 0; i < nVerts; i++)
	{
		if(! vertexlist[i].isInTree && sPath[i].distance < minDist)
		{
			minDist = sPath[i].distance;
			indexMin = i;
		}
	}
	return indexMin;
}

public void adjust_sPath()
{
	int column = 1;
	while (column < nVerts)
	{
		if (vertexlist[column].isInTree)
		{
			column++;
			continue;
		}
		
		int currentToFringe = adjMat[currentVert][column];
		int startToFringe = startToCurrent + currentToFringe;
		int sPathDist = sPath[column].distance;
		if(startToFringe < sPathDist)
		{
			sPath[column].parentVert = currentVert;
			sPath[column].distance = startToFringe;
		}
		column++;
	}
			
}


public void displayPaths()
{
	for (int i = 0; i<nVerts; i++)
	{
		System.out.print(vertexlist[i].label + "= ");
		if(sPath[i].distance == INFINITY)
		{
			System.out.print("inf");
		}
		else
		{
			System.out.print(sPath[i].distance);
		String parent = vertexlist[sPath[i].parentVert].label;
		System.out.print("{" + parent + "}");
		
		}
		System.out.println(' ');
	}
}
}

