package DataStructures;
// BinaryTreeNodeInterface.java
// Assignment 7 Part 1
// Thao Bach

/**
 * This is the interface for BinaryTreeNode
 * @author thaobach
 *
 */
public interface BinaryTreeNodeInterface<T> 
{
	public T getData();
	
	public BinaryTreeNode<T> getLeft();

	public BinaryTreeNode<T> getRight();
	
	public void setData( T data );
	
	public void setLeft( BinaryTreeNode<T> node);
	
	public void setRight ( BinaryTreeNode<T> node);
	
	public String toString();

}
