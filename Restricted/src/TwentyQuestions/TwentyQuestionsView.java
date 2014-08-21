package TwentyQuestions;

// TwentyQuestionsView.java
// Restricted 
// Thao Bach

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.omg.CORBA.Current;

import DataStructures.BinaryTreeNode;

/**
 * Draws the game
 * Features the logic
 * @author thaobach
 */

public class TwentyQuestionsView extends JPanel
{
	// image is a component TwentyQuestionsController
	private Image image;
	private TwentyQuestionsController controller;
	private BinaryTreeNode<String> current;
	private BinaryTreeNode<String> previous;
	private JPanel menuPanel;
	private JPanel center;
	private JPanel south;
	private JButton start;
	private JButton restart;
	private JButton yes;
	private JButton no;
	private JTextField question;
	
	// Constructor
	/* Calls the 20Q image
	 * Sets the current node to root of tree
	 */
	public TwentyQuestionsView()
	{
		super(new BorderLayout());
		image = new Image ( "20Q.jpg" );
		controller = new TwentyQuestionsController();
		current = controller.tree.getRoot();
		initGUI();
		
	}
	
	/**
	 * Create GUI components
	 */
	public void initGUI()
	{
		// use a border layout
		setLayout( new BorderLayout() );
		
		// add instructions panel to NORTH
		add (createInstructions(), BorderLayout.NORTH);
		
		// add question/answer panel to CENTER
		add (createCenterPanel(), BorderLayout.CENTER);
		
		// add Yes/No or Restart buttons panel to SOUTH
		add (createSouthPanel(), BorderLayout.SOUTH);
		
	}
	
	
	/**
	 * Creates a panel in the center, consisting of a menu and a picture
	 * @return center panel
	 */
	public JPanel createCenterPanel()
	{
		// use a border layout
		center = new JPanel(new GridLayout(1, 2));
		
		// Add 20Q image to east
		center.add (image, BorderLayout.EAST);
		
		// Add menu to west
		center.add (createMenu(), BorderLayout.WEST);
		
		center.setOpaque(true);
		center.setBackground(new Color(210, 195, 221));
		
		return center;
	}
	
	/**
	 * Create menu list for user to choose from
	 * @return menu panel
	 */
	public JPanel createMenu()
	{
		menuPanel = new JPanel(new GridLayout(1, 2));
		
		JTextArea menu1 = new JTextArea("Wedding Cake\n\nMacaron Tower\n\nBuche de Noel\n\nLemon Meringue Pie\n\n"
										+ "Ice Cream\n\nSorbet\n\nReligieuse\n\nCronut" );
		JTextArea menu2 = new JTextArea("Clam Chowder\n\nGumbo\n\nHamburger\n\nCorn Dog\n\nPho\n\nSpring Rolls\n\n"
										+ "Pasta\n\nFoie Gras");
		menu1.setEditable(false);
		
		//allows words to go to next line
		menu1.setLineWrap(true);
		
		//prevents words from splitting
		menu1.setWrapStyleWord(true);
		
		// Insets constructor summary: (top, left, bottom, right)
		menu1.setMargin( new Insets( 30, 30, 30, 5 ) );
		
		menu2.setEditable(false);
		//allows words to go to next line
		menu2.setLineWrap(true);
		
		//prevents words from splitting
		menu2.setWrapStyleWord(true);
		
		// Insets constructor summary: (top, left, bottom, right)
		menu2.setMargin( new Insets( 30, 30, 30, 5 ) );
		
		menuPanel.add (menu1, BorderLayout.EAST);
		menuPanel.add (menu2, BorderLayout.WEST);

		menu1.setOpaque(true);
		menu1.setBackground(new Color(207, 219, 211));
		menu2.setOpaque(true);
		menu2.setBackground(new Color(234, 237, 210));
		
		return menuPanel;
	}
	
	/**
	 * Create instructions for game 
	 * @return instructions
	 */
	public JTextArea createInstructions()
	{
		JTextArea instructions = new JTextArea("Instructions:\n\nI will try to guess what you're craving from the food list below. "
												+ "Your job is to choose yes or no to the following questions ");
		// instructions not editable
		instructions.setEditable(false);
		
		//allows words to go to next line
		instructions.setLineWrap(true);
		
		//prevents words from splitting
		instructions.setWrapStyleWord(true);
		
		// change font
		instructions.setFont(new Font("SANS_SERIF", Font.PLAIN, 17));
		
		// change font color
		instructions.setForeground(Color.white);
		
		// Insets constructor summary: (top, left, bottom, right)
		instructions.setMargin( new Insets( 30, 30, 30, 30 ) );
				
		// Set background color
		instructions.setOpaque(true);
		instructions.setBackground(new Color(124, 177, 16));
		
		return instructions;
	}
	
	/**
	 * South panel w/ start button to start with
	 * Once pressed:
	 	1. yes/no buttons
	 	2. questions will appear
	 	3. "Start" button and picture in center panel disappear
	 */
	public JPanel createSouthPanel()
	{
		south = new JPanel (new GridLayout(1, 1));
		startGame();
		
		return south;
	}
	
	/**
	 * "Yes" button looks at left child
	 */
	public void yes()
	{
		yes = new JButton("Yes");
		
		// "yes" button's action listener
	    yes.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				current = current.getLeft();
				
				// if current is not a leaf
				if (current != null)
				{
					question.setText((String) current.getData());
					validate();
				}
				
				// Once you hit a leaf, set a final message
				else
				{
					question.setText("Yay! You win nothing because I will not feed you what you crave.");
					// add a restart button that restores the game
					restartGame();
					
				}
			}
		});
	    
	    // add Yes button to left
		south.add (yes, BorderLayout.WEST);
		validate();
		
	}
	
	/**
	 * "No" button looks at right child
	 */
	public void no()
	{
		no = new JButton("No");
		
		no.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				previous = current;
				current = current.getRight();
				
				// if current is not a leaf
				if (current != null)
				{
					question.setText(current.getData().toString());
					validate();
				}
				
				// Once you hit a leaf, set a final message
				else
				{
					question.setText("No, you are craving " + previous.getData().toString() + ". Restart if you disagree.");
					// add a restart button that restores the game
					restartGame();
					
				}	
			}
		});
		
		// add No button to right
		south.add (no, BorderLayout.EAST);
		validate();
	}
	
	/**
	 * Displays the restart button
	 */
	public void restartGame()
	{
		restart = new JButton("Restart");
		south.remove(yes);
		south.remove(no);
		validate();
		restart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				south.remove(restart);
				center.remove(question);
				center.add(image);
				center.add(menuPanel);
				repaint();
				validate();
				startGame();
			}
			
		});
		south.add(restart);
		validate();
	}
	
	/**
	 * Start the game by:
	 	1. Remove restart button
	 	2. Add start button
	 */
	public void startGame()
	{
		start = new JButton("Start");

		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				current = controller.tree.getRoot();
				// remove the start button
				south.remove(start);
				validate();
				
				// remove the picture + menu
				center.remove(image);
				center.remove(menuPanel);
				
				// add JTextArea to center panel and update text to whatever current's data is
				question = new JTextField();
				question.setEditable(false);
				question.setBackground(new Color(235, 203, 180));
				
				// Insets constructor summary: (top, left, bottom, right)
				question.setText(current.getData().toString());
				question.setHorizontalAlignment(JTextField.CENTER);
				validate();
				
				center.add(question);
				
				validate();
				
				// create JPanel with GridLayout -- 1 rows, 2 columns
				south.setLayout(new GridLayout(1, 2));
				validate();
				
				// create yes button
				yes();
				
				// create no button
				no();
				
			}
		});	
		south.add(start);
		validate();
	}
}




