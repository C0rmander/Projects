/*
	 * public int my_count_at_level
	 *    This operation receives as an input the 
	 *    level of the tree we are looking for, and
	 *    returns the amount of nodes placed on that level.
 	   
 	   
 	   public boolean my_is_balanced
 	      A binary tree is balanced when the length 
 	   	  of its two subtrees (left subtree and right subtree) do not differ in more than 1 unit, and the proper left subtree 
 	   	  and right subtree are balanced trees as well). This operation returns if the tree is balanced or not. 
       
       
       public int my_count_smaller_nodes
          This operation receives as an input a key, and returns the amount of
          nodes in the tree with smaller key values.  
       
       
       public int my_find_node_at_level
          This operation receives as 
          an input a key, and returns the level were the node is located.
	 */


class Node {
    int Data;
    Node left;
    Node right;
 
    public Node(int data) {
        this.Data = data;
        right = null;
        left = null;
    }
}
public class createTree {
	
	
	Node root;
	
	private Node insert(Node root, int key)
	{
		if (root == null)
		{
			return new Node(key);
		}
		if (key < root.Data)
		{
			root.left = insert(root.left, key);
		}
		else
		{
			root.right = insert(root.right, key);;
		}
		return root;
	}
	
	public void rootInsert (int data)
	{
		root = insert(root, data);
	}
	
	
	private int my_find_node_at_level(Node node, int level, int data)
	{
		if (node == null) {
			return level;
		}
		else if (node.Data == data)
		{
		return level;	
		}
		else if (data < node.Data)
		{
		level = my_find_node_at_level(node.left, level+1, data);
		}
	    else
	    {
	    level = my_find_node_at_level(node.right, level+=1, data);
	    }
		return level;
		
	}
	public void FindNodeAtLevel (int data)
	{
		int level = 0;
		System.out.print("the node with data "+data+" is at level "+my_find_node_at_level(root, level, data));
		System.out.print("\n");
	}
	
	private int my_count_at_level(Node node, int level)
	{
		
		if (node != null) {
			if (level > 1)
			{
	       int nodeLevel = my_count_at_level(node.left, level-1) + my_count_at_level(node.right, level-1);
	       return nodeLevel;
			}
	    }
		return level;
		
	}
	public void CountAtLevel (int level)
	{
		System.out.print("the amount of nodes at level "+level+" are "+my_count_at_level(root, level));
		System.out.print("\n");
	}
	
	public int my_count_smaller_nodes(Node node, int count, int data)
	{
		if (node == null) {
			return 0;
		}
		my_count_smaller_nodes(node.left, count, data); 
		my_count_smaller_nodes(node.right, count, data);
		if (node.Data < data)
		{
			return 1 + my_count_smaller_nodes(node.left, count, data) +
			my_count_smaller_nodes(node.right, count, data); 
		}
		else
		{
			count = my_count_smaller_nodes(node.left, count, data); 
			
		}
		return count;
	}
	public void CountSmaller (int data)
	{
		int count = 0;
		System.out.print("the amount of nodes in the BST smaller than "+data+" are "+my_count_smaller_nodes(root, count, data));
		System.out.print("\n");
	}
	
	public boolean my_is_balanced(Node node)
	{
		int Lheight;
		int Rheight;
		if (node == null)
		{
			return true;
		}
		Lheight = Height(node.left);
		Rheight = Height(node.right);
		int diff = Lheight-Rheight;
		if (Math.abs(diff)<=1)
		{
		if (my_is_balanced(node.left) && my_is_balanced(node.right))
		{
			return true;
		}
		}
			return false;
		
		
	}
	public int Height(Node node)
	{
		if (node == null)
		{
		return 0;
		}
		else
		{
			return 1 + Math.max(Height(node.left), Height(node.right));
		}
		
	}
	
	public void isbalanced()
	{
		if (my_is_balanced(root) == true)
		{
		System.out.print("the tree is balanced ");
		System.out.print("\n");
		}
		else
		{
			System.out.print("the tree is not balanced ");
		}
	}
}
