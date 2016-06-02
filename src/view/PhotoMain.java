/**
 * Casey Morrison May 31, 2016
 */
package view;

import java.awt.EventQueue;

/**
 * Runs the Photo Editor by instantiating and starting the PhotoGUI. 
 * 
 * @author Casey Morrison
 * @version Spring 2016
 */
public class PhotoMain {
	
	/**
	 * Private constructor, to prevent instantiation of this class.
	 */
	private PhotoMain() {
		throw new IllegalStateException();
	}

	/**
	 * This main method, invokes the Photo Editor GUI.
	 * 
	 * @param args ignored command line arguments.
	 */
	public static void main(final String[] args) {
		
		// Configure the Swing components from the event dispatch thread
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				final PhotoGUI gui = new PhotoGUI();
				gui.start();
			}
		});	
	}

}
