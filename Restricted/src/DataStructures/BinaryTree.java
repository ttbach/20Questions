package DataStructures;
// BinaryTree.java
// Assignment 7 Part 1
// Thao Bach

/**
 * @author thaobach
 * Binary Tree Implementation
 * @param <T>
 */
public class BinaryTree<T> implements BinaryTreeInterface<T>
{
	// Instances
	protected BinaryTreeNode<T> root;
	protected LinkedList<T> linkedList;
		
	// Constructor 
	public BinaryTree()
	{
		root = null;
		linkedList = new LinkedList<T>();
	}

	/**
	 * Check if tree is empty
	 */
	public boolean isEmpty()
	{
		if (root == null)
		{
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Get data stored in head node of list.
	 **/
	public T getRootData()
	{
		if (root == null) 
		{
			return null;
		}
		else
		{
			return root.getData();
		}
	}
		
	/**
	 * Get the root
	 */
	public BinaryTreeNode<T> getRoot()
	{
		return root;
	}
	
	/**
	 * Set the rot
	 */
	public void setRoot (BinaryTreeNode node)
	{
		root = node;
	}

	/**
	 * In order traversal 
	 * - Recurse left
	 * - Data
	 * - Recurse right
	 **/
	public LinkedList<T> inOrder (BinaryTreeNode<T> current, LinkedList<T> ll)
	{
		// Base case
		// Return nothing
		if (current == null)
		{
			return ll;
		}
		// left, data, right
		else
		{
			inOrder(current.getLeft(), ll);
			ll.insertLast(current.getData());
			inOrder(current.getRight(), ll);
			return ll;
		}
		
	}
	
	/**
	 * Pre-order traversal 
	 * - Data
	 * - Recurse left
	 * - Recurse right
	 **/
	public LinkedList<T> preOrder (BinaryTreeNode<T> current, LinkedList<T> ll)
	{
		// Base case
		// Return nothing
		if (current == null)
		{
			return ll;
		}
		// data, left, right
		else
		{
			ll.insertLast(current.getData());
			preOrder(current.getLeft(), ll);
			preOrder(current.getRight(), ll);
			return ll;
		}
	}
	
	/**
	 * Post-order traversal
	 * - Recurse left
	 * - Recurse right
	 * - Data
	 **/
	public LinkedList<T> postOrder (BinaryTreeNode<T> current, LinkedList<T> ll)
	{
		// Base case
		// Return nothing
		if (current == null)
		{
			return ll;
		}
		// data, left, right
		else
		{
			postOrder(current.getLeft(), ll);
			postOrder(current.getRight(), ll);
			ll.insertLast(current.getData());
			return ll;
		}
	}
	
}
