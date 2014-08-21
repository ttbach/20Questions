package DataStructures;
// LinkedList.java
// Assignment 7 Part 1
// Thao Bach

public class LinkedList<T>
{
	// Instances
	private LinkedListNode<T> head = null;
	private int size;
	
	// Constructor 
	public LinkedList()
	{
		size = 0;
	}
	
	
	/**
	 * Get data stored in head node of list.
	 **/
	public T getFirst()
	{
		if (head == null) 
		{
			return null;
		}
		else
		{
			return head.getData();
		}
	}
	
	
	/**
	 * Get the head node of the list.
	 **/
	public LinkedListNode<T> getFirstNode()
	{
		if (head == null)
			return null;
		else
			return head;
	}
	
	/**
	 * Get data stored in tail node of list.
	 **/
	public T getLast()
	{
		if (head == null)
			return null;
		else
			return getLastNode().getData();
	}
	
	
	/**
	 * Get the tail node of the list.
	 **/
	public LinkedListNode<T> getLastNode()
	{
		if (head == null)
			return null;
		
		LinkedListNode<T> currentNode = head;
		while (currentNode.getNext() != null)
			currentNode = currentNode.getNext();
		return currentNode;
	}
	
	
	/**
	 * Insert a new node with data at the head of the list.
	 **/
	public void insertFirst( T data )
	{
		LinkedListNode<T> newNode = new LinkedListNode<T>(data, head);
		head = newNode;
		size++;
	} 
	
	
	/**
	 * Insert a new node with data after currentNode
	 **/
	public void insertAfter( LinkedListNode<T> currentNode, T data )
	{ 
		
		LinkedListNode<T> newNode = new LinkedListNode<T> (data, currentNode.getNext());
		currentNode.setNext(newNode); 
		size++;
	}
	
	
	/**
	 * Insert a new node with data at the tail of the list.
	 **/
	public void insertLast( T data )
	{
		if (head == null)
		{
			head = new LinkedListNode<T>(data, null);
			size++;
		}
		else
		{
			insertAfter(getLastNode(), data);
			size++;
		}
	}
	
	/**
	 * Remove head node
	 **/
	public void deleteFirst()
	{
		head = head.getNext();
		size--;
	}
	
	
	/**
	 * Remove tail node
	 **/
	public void deleteLast()
	{
		if (getSize() == 0)
			return;
		
		LinkedListNode<T> currentNode = head;
		while (currentNode.getNext() != null && currentNode.getNext().getNext() != null)
			currentNode = currentNode.getNext();
		deleteNext(currentNode);
		
	}
	
	
	/**
	 * Remove node following currentNode
	 * If no node exists (i.e., currentNode is the tail), do nothing
	 **/
	public void deleteNext( LinkedListNode<T> currentNode )
	{
		if (currentNode.getNext() != null)
			currentNode.setNext(currentNode.getNext().getNext());
		
		size--;
	}
	
	
	/**
	 * Compute the getSize of this list.
	 **/
	public int getSize()
	{
		return size;
	}	
	
	
	/**
	 * Check if list is empty.
	 * @return true if list contains no items.
	 **/
	public boolean isEmpty()
	{
		//System.out.println("size is " + getSize());
		if (getSize() == 0)
			return true;
		return false;
	}	
	
	/**
	 * Return a String representation of the list.
	 **/
	public String toString()
	{
		String list = "";
		LinkedListNode<T> currentNode = head;
		if (head == null)
			return "";
		while (currentNode.getNext() != null)
		{
			list += currentNode.getData() + " ";
			currentNode = currentNode.getNext();
		}
		list += currentNode.getData() ;
		return list;
	}
}
