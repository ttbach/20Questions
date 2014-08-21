package DataStructures;
// BinaryTreeNode.java
// Assignment 7 Part 1
// Thao Bach

public class BinaryTreeNode<T> implements BinaryTreeNodeInterface<T>
{
	
/*--------- Instance Properties ---------*/
	
	protected T data;
	protected BinaryTreeNode<T> left;
	protected BinaryTreeNode<T> right;
	
	/**
	 * Constructor 
	 */
	public BinaryTreeNode (T data)
	{
		this.data = data;
		left = null;
		right = null;
	}
	
	
	
	/**
	 * Get the data stored at this node.
	 **/
	public T getData()
	{
		return data;
	}
	

	public BinaryTreeNode<T> getLeft()
	{
		return left;
	}
	
	
	public BinaryTreeNode<T> getRight()
	{
		return right;
	}
	
	/**
	 * Checks if node is leaf
	 */
	public boolean isLeaf()
	{
		if (getLeft() == null && getRight() == null)
			return true;
		return false;
	}
	
	/**
	 * Set the data stored at this node.
	 * 
	 * @param data: the new data to be stored
	 **/
	public void setData( T data )
	{
		this.data = data;
	}
	
	public void setLeft( BinaryTreeNode<T> node)
	{
		left = node;;
	}
	
	public void setRight ( BinaryTreeNode<T> node)
	{
		right = node;
	}
	
	/**
	 * Returns a String representation of this node.
	 **/
	public String toString()
	{
		return data.toString();
	}


}
