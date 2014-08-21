package io;
/**
 * CommutativeExpressionReader.java
 * CS 211 
 * Audrey St. John
 **/

// XML
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;  
import org.w3c.dom.*;

// io
import java.io.*;

// ds
import DataStructures.BinaryTree;
import DataStructures.BinaryTreeNode;
import DataStructures.BinaryTreeInterface;
import DataStructures.BinaryTreeNodeInterface;

//CommutativeExpressionReader.java
//Restricted
//Thao Bach

/**
 * CommutativeExpressionReader reads xml files of expressions with
 * binary, commutative operators.
 *
 * @author Audrey Lee
 */
public class CommutativeExpressionReader
{

   /**
    * Parses XML file.
    * @return expression BinTree corresponding to file.
    **/
   public static BinaryTree<String> readCommutativeExpr( String file )
   {
     return readCommutativeExpr( new File( file ) );
   }

   /**
    * Parses XML file
    * @return expression BinTree corresponding to file.
    **/
   public static BinaryTree<String> readCommutativeExpr( File file )
   {
      DocumentBuilderFactory factory =
         DocumentBuilderFactory.newInstance();
      
      try 
      {
         DocumentBuilder builder = factory.newDocumentBuilder();
         Document document = builder.parse( file );

         return parseExprTree( document );	    
      } 
      catch (SAXException sxe) 
      {
         // Error generated during parsing)
         Exception  x = sxe;
         if (sxe.getException() != null)
            x = sxe.getException();
         x.printStackTrace();         
      } 
      catch (ParserConfigurationException pce) 
      {
         // Parser with specified options can't be built
         pce.printStackTrace();
      }   
      catch (IOException ioe) 
      {
         // I/O error
         ioe.printStackTrace();
      }
      
      return null;
   }
   
   /**
    * Parses XML Document. 
    * @return parsed BinTree.
    **/
   private static BinaryTree<String> parseExprTree( Document document )
   {
     BinaryTree<String> tree = new BinaryTree<String>();

     // parse root
     Element root = 
       (Element)document.getDocumentElement();

     tree.setRoot( parseExprNode( root ) );

     return tree;
   }
   
  /**
   * Parses expr element.
   * @return BinTreeNode represented by element.
   **/
  private static BinaryTreeNode<String> parseExprNode( Element element )
  {
    // base case: answer
    if ( element.getAttribute( "type" ).equals( "answer" ) )
    {
      // must have exactly one non-text child
      // get children
      NodeList children = element.getChildNodes();     

      for ( int i = 0; i < children.getLength(); i++ )
      {
        // if not text node
        if ( children.item(i) instanceof Element )
        {
          Element answer = (Element)children.item(i);
      
          // get attribute by name
          return new BinaryTreeNode<String>( answer.getAttribute( "value" ) );    
        }
      }
      
      // error if gets to here
      return null;
    }
    // recursive case
    else
    {
      // get children
      NodeList children = element.getChildNodes();      

      // iterate through, looking for operator and two operands
      // NOTE: operand order does not matter because operators are
      // commutative
      String commutativeOp = "";
      BinaryTreeNode<String> operand1 = null;
      BinaryTreeNode<String> operand2 = null;
      Element currentElt;

      for ( int i = 0; i < children.getLength(); i++ )
      {
        // if not text node
        if ( children.item(i) instanceof Element )
        {
          currentElt = (Element)children.item(i);

          // test tag name 
          // if question
          if ( currentElt.getTagName().equals( "question" ) )
            commutativeOp = currentElt.getAttribute( "value" );
          // otherwise, should be expression
          else if ( currentElt.getTagName().equals( "expr" ) )
          {
            // store in operand1, if nothing there yet
            if ( operand1 == null )
              operand1 = parseExprNode( currentElt );
            // otherwise, put in operand2
            else
              operand2 = parseExprNode( currentElt );
          }
        }
      }

      // create node
      BinaryTreeNode<String> exprNode = new BinaryTreeNode<String>( commutativeOp );
      // set left and right children; arbitrary order
      exprNode.setLeft( operand1 );
      exprNode.setRight( operand2 );
      
      return exprNode;
    }
  }

}
