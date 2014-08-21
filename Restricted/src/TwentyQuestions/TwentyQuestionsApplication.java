package TwentyQuestions;

import javax.swing.JFrame;

//TwentyQuestionsApplication.java
//Restricted 
//Thao Bach

/*
 * JFrame that displays everything
 */

public class TwentyQuestionsApplication
{
	public static void main( String[] args )
	{
		// create a new JFrame to hold IceCreamPanel
		JFrame TQFrame = new JFrame("20 Questions Restricted");
		
		// set size
		TQFrame.setSize( 600, 610 );

		// add IceCreamPanel to JFrame
		TQFrame.add( new TwentyQuestionsView() );
		
		// exit normally on closing the window
		TQFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// show frame
		TQFrame.setVisible( true );
		
	}
	
}
