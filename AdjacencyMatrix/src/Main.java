//Cormac Conway R00167642
//references:
//Introduction to Algorithms, 3rd Edition by thomas H. Cormen
//Data structures & algorithms in Java 2nd ed. by Robert Lafore


public class Main {
public static void main(String args[])
{
	Graph graph = new Graph();
	graph.addVertex('g');
	graph.addVertex('f');
	graph.addVertex('l');
	graph.addVertex('m');
	graph.addEdge(0, 2, 5);
	graph.addEdge(0, 1, 7);
	graph.addEdge(1, 3, 9);
	if(graph.getNeighbour(0) != null)
	{
	System.out.print("the neighbours of " + graph.displayVertex(0) +" are: " + graph.getNeighbour(0));
	}
	else
	{
		System.out.print("Vertex has no neighbours");
	}
	if (graph.getDegrees(0) != null)
	{
	System.out.print("\nthe degree of " + graph.displayVertex(0) +" is: " + graph.getDegrees(0));
	}
	else
	{
		System.out.print("\nno edges connected to vertex, degree equal to zero");
	}
	
	if (graph.getWeight(0,2) != null)
	{
		System.out.print("\nthe weight of the given edge is: " + graph.getWeight(0,1));
	}
	else
	{
		System.out.print("\nno edge can be found between given vertices!");
	}
	if (graph.hasEdge(0, 2))
	{
	System.out.print("\nvertices have edge");
	}
	else
	{
	System.out.print("\nvertices do not have an edge");
	}
	
	if (graph.removeEdge(0, 2) == true)
	{
		System.out.print("\nEdge removed");
	}
	else
	{
		System.out.print("\nCould not remove edge");
	}
}
}

