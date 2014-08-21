package DataStructures;
// LinkedinListNode.java
// Assignment 7 Part 1
// Thao Bach

/**
 * Creates linked list nodes
 */

public class LinkedListNode<T> 
{
	/*--------- Instance Properties ---------*/
	
	private T data;
	private LinkedListNode<T> next;
	
	/**
	 * Constructor 
	 */
	public LinkedListNode (T data, LinkedListNode<T> next)
	{
		this.data = data;
		this.next = next;
	}
	
	
	
	/**
	 * Get the data stored at this node.
	 **/
	public T getData()
	{
		return data;
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
	
	
	/**
	 * Get (pointer to) next node.
	 **/
	public LinkedListNode<T> getNext()
	{
		return next;
	}
	
	/**
	 * Set the next pointer to passed node.
	 **/
	public void setNext( LinkedListNode<T> node )
	{
		next = node;
	}
	
	/**
	 * Returns a String representation of this node.
	 **/
	public String toString()
	{
		return data.toString();
	}

}
