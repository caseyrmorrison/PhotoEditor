/**
 * Casey Morrison May 31, 2016
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 *  The GUI that displays the entire editor.
 *
 * @author Casey Morrison
 * @version May 31, 2016
 */
@SuppressWarnings("serial")
public class PhotoGUI extends JFrame {

	/**
	 * Initialize the frame with a name.
	 */
	public PhotoGUI() {
		super("Photo Editor");
	}
	
	/**
	 * Sets up and displays the GUI for this application.
	 */
	public void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setupSizeLocation();
		setLocationRelativeTo(null);
		
		setupEditPanel();
		setupPhotoPanel();
		
		setVisible(true);
	}
	
	
	private void setupEditPanel() {
		EditsPanel edits = new EditsPanel();
		add(edits, BorderLayout.EAST);
	}
	
	private void setupPhotoPanel() {
		PhotoPanel photo = new PhotoPanel();
		add(photo);
		setJMenuBar(new MenuBar(photo));
	}
	
	
	/**
	 * Calculates the size of the application based on the user's screen.
	 * Centers the application on the screen.
	 */
	private void setupSizeLocation() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		
//		setSize(screenWidth - 100, screenHeight - 100); 
		setSize(screenWidth / 2, screenHeight / 2); 
	}
	
}
