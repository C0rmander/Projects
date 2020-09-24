import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GraphMain extends HttpServlet {
	Graph graph = new Graph(20);
	@Override
	// handles all POST  requests such as when a node is created on the client side
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("node");
		if (name != null)
		{
		System.out.println(name);
		graph.addVertex(name);
		System.out.print(graph.numVerts());
		}
		String edge1 = request.getParameter("edge1");
		String edge2 = request.getParameter("edge2");
		String weight = request.getParameter("weight");
		if (weight == null)
		{
			weight = "0";
		}
		if (edge1 != null && edge2 != null && weight!=null)
		{
		System.out.println("edge1: " + edge1);
		System.out.println("edge2: " + edge2);
		System.out.println(weight);
		int Weight = Integer.parseInt(weight);
		Weight+=2;
		System.out.println(Weight);
		System.out.println(graph.getPos(edge1));
			if (graph.getPos(edge1) != -1 && graph.getPos(edge2) != -2)
			{
				graph.addEdge(graph.getPos(edge1), graph.getPos(edge2), Weight);
			}
			else
			{
				System.out.print("no can do!");
			}
		}
		String getNode = request.getParameter("getNode");
		if (getNode != null)
		{
			int node = Integer.parseInt(getNode);
			graph.displayVertex(node);
		}
		
		String hasEdge1 = request.getParameter("hasEdge1");
		String hasEdge2 = request.getParameter("hasEdge2");
		if (hasEdge1 != null && hasEdge2 != null)
		{
		System.out.println(hasEdge1);
		System.out.println(hasEdge2);
		if (graph.getPos(hasEdge1) == -1 || graph.getPos(hasEdge2) == -1)
		{
			System.out.println("false");
		}
		else
		{
		System.out.println(graph.getPos(hasEdge1));
		System.out.println(graph.getPos(hasEdge2));
		System.out.print(graph.hasEdge(graph.getPos(hasEdge1), graph.getPos(hasEdge2)));
		}
		}
		
		String removeEdge1 = request.getParameter("removeEdge1");
		String removeEdge2 = request.getParameter("removeEdge2");
		if (removeEdge1 != null && removeEdge2 != null)
		{
		graph.removeEdge(graph.getPos(removeEdge1), graph.getPos(removeEdge2));
		}
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String message = "Happy Coding!";
		request.setAttribute("message", message);
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);
	}
}
