//Cormac Conway R00167642
//references:
//Data abstraction and problem solving with java, walls and mirrors by Janet prichard & Frand M. Carrano
//Introduction to Algorithms, 3rd Edition by thomas H. Cormen

public class Main {
	public static void main(String[] args) {
		Graph graph = new Graph(7);
		graph.addEdge(3, 2, 2);
		graph.addEdge(1, 5, 5);
		graph.addEdge(1, 6, 1);
		graph.addEdge(6, 5, 2);
		graph.addEdge(5, 2, 2);
		graph.addEdge(2, 4, 2);
		graph.addEdge(3, 1, 2);
		if (!graph.getNeighbours(5).isEmpty())
		{
		System.out.print("the neighbours of the node are: " + graph.getNeighbours(5));
		}
		else
		{
			System.out.print("\nno neighbours exist");
		}
		if(graph.getDegrees(5)!= null)
		{
		System.out.print("\nthe degree of the given node is: " + graph.getDegrees(5));
		}
		else
		{
		System.out.print("\nno edges connected to vertex, degree equal to zero");
		}
		if (graph.hasEdge(6, 1) == true)
		{
			System.out.print("\nEdge exists");
		}
		else
		{
			System.out.print("\nEdge does not exist");
		}
		
		if (graph.removeEdge(6, 1) == true)
		{
			System.out.print("\nEdge removed");
		}
		else
		{
			System.out.print("\nNo edge to be found");
		}
		
		if (graph.getEdgeWeight(6, 5) != null)
		{
		System.out.print("\nthe weight of the given edge is: " + graph.getEdgeWeight(6, 5));
		}
		else
		{
			System.out.print("\nno edge to be found");
		}
		
	}
}
