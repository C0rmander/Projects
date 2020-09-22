//Cormac Conway R00167642
//References:
//Introduction to Algorithms, 3rd Edition by thomas H. Cormen
//Data abstraction and problem solving with java, walls and mirrors by Janet prichard & Frand M. Carrano
//https://www.baeldung.com/
//https://www.geeksforgeeks.org/

public class BinarySearchTree {
	
	
	public static void main(String[] args) {
		createTree bst = new createTree();
		bst.rootInsert(6);
		bst.rootInsert(4);
		bst.rootInsert(8);
		bst.rootInsert(3);
		bst.rootInsert(5);
		bst.rootInsert(7);
		bst.rootInsert(9);
		bst.FindNodeAtLevel(9);
		bst.CountAtLevel(3);
		bst.CountSmaller(3);
		bst.isbalanced();
		
//				6
//			   / \
//            /   \
//           /     \
//			4	    8
//		   / \     / \
//        3   5   7   9  
		
		
		
		
		
		
		
		
	}
}
