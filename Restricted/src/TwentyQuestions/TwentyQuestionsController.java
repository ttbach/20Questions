package TwentyQuestions;

import io.CommutativeExpressionReader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import DataStructures.BinaryTree;
import DataStructures.BinaryTreeNode;
import DataStructures.LinkedList;

//TwentyQuestionsController.java
//Restricted 
//Thao Bach

/**
 * Builds the tree
 * @author thaobach
 *
 */

public class TwentyQuestionsController extends JComponent
{
	// Instance Properties
	protected BinaryTreeNode<String>[] nodes;
	protected static BinaryTree<String> tree;
	
	// Constructor
	/**
	 * Initializes nodes, tree, and linked list
	 */
	public TwentyQuestionsController()
	{
		// Initialize nodes and tree
		nodes = (BinaryTreeNode<String>[])new BinaryTreeNode[31];
		tree = new BinaryTree<String>();
		buildTree();
	}
	
	
	/**
	* Draws the binary tree
	* Returns a BinaryTree 
	*/
	public BinaryTree<String> buildTree()
	{
		tree = CommutativeExpressionReader.readCommutativeExpr("food.xml");
		return tree;
	}
	
}
