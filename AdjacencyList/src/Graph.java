import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

public class Graph {
 private int numVertices;
 private int numEdges;
 //contains a collection of vertices, TreeMap acts as red black tree
 private Vector<TreeMap<Integer,Integer>> adjList;
 
 public Graph(int n)
 {
	 numVertices = n;
	 numEdges = 0;
	 adjList = new Vector<TreeMap<Integer,Integer>>();
	 for (int i=0; i<numVertices; i++)
	 {
		 adjList.add(new TreeMap<Integer,Integer>());
	 }
 }
 
 //gets the number of vertices in the graph
 public int getNumVertices()
 {
	 
	 return numVertices;
 }
 
 // gets the number of edges in the graph
 public int getNumEdges()
 {
	 
	 return numEdges;
 }
 
 // gets the weight of a given edge
 public Integer getEdgeWeight(Integer v,Integer w)
 {
	 try{
	 return adjList.get(v).get(w);
	 }
	 catch(NullPointerException e ){
		 return null;
	 }
 }
 
 //adds edge between pre-existing vertices
 public void addEdge(Integer v, Integer w, int wgt)
 {
	 adjList.get(v).put(w, wgt);
	 adjList.get(w).put(v, wgt);
	 numEdges++;
 }
 
 //removes edge between vertices in graph
 public boolean removeEdge(int v, int w)
 {
	 if (hasEdge(v,w)==true)
	 {
	 adjList.get(v).remove(w);
	 adjList.get(w).remove(v);
	 numEdges--;
	 return true;
	 }
	 else
	 {
		 return false;
	 }
 }
 //checks if edge exists between two vertices in a graph
 public boolean hasEdge(Integer v, Integer w)
 {
	 try{
	 if (adjList.get(v).get(w)>0);
	 {
	 return true;
	 }
	 }
	 catch(NullPointerException e ){
		 return false;
	 }
	
 }
 
 //returns neighbours of given vertex
 Set<Integer> getNeighbours(Integer v)
 {
	return adjList.get(v).keySet();
 }
 
 //returns degrees of a given vertex
public Integer getDegrees(Integer v)
 {
	if (adjList.get(v).values().size()>0)
	{
	return adjList.get(v).values().size();
	}
	else
	{
		return null;
	}
 }
 
}
