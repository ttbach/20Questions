package DataStructures;
// BinaryTreeInterface.java
// Assignment 7 Part 1
// Thao Bach

/**
 * This is the interface for binary tree
 */

public interface BinaryTreeInterface<T> 
{
	public T getRootData();
	public BinaryTreeNode<T> getRoot();
	public LinkedList<T> inOrder (BinaryTreeNode<T> current, LinkedList<T> ll);
	public LinkedList<T> preOrder (BinaryTreeNode<T> current, LinkedList<T> ll);
	public LinkedList<T> postOrder (BinaryTreeNode<T> current, LinkedList<T> ll);
}
