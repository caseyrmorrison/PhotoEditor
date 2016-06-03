package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	
	// File Menu Buttons
	private final JMenuItem my_import_button = new JMenuItem("Import", 'I');
	private final JMenuItem my_save_button = new JMenuItem("Save", 'S');
	private final JMenuItem my_export_button = new JMenuItem("Export", 'E');
	private final JMenuItem my_exit_button = new JMenuItem("Exit", 'X');
	
	// Edit Menu Buttons
	private final JMenuItem my_undo_button = new JMenuItem("Undo", 'U');
	private final JMenuItem my_redo_button = new JMenuItem("Redo", 'R');
	
	// View Menu Buttons
	private final JMenuItem my_before_after_button = new JMenuItem("Before/After", 'B');
	private final JMenuItem my_background_button = new JMenuItem("Background", 'G');
	private final JMenuItem my_onebyone_button = new JMenuItem("1:1", 'O');
	private final JMenuItem my_full_button = new JMenuItem("Full", 'F');
	private final JMenuItem my_fit_button = new JMenuItem("Fit", 'T');
	
	// Photo Menu Buttons
	private final JMenuItem my_crop_button = new JMenuItem("Crop", 'C');
	private final JMenuItem my_red_eye_button = new JMenuItem("Red Eye", 'E');
	private final JMenuItem my_spot_remove_button = new JMenuItem("Spot Remove", 'S');
	private final JMenuItem my_white_balance_button = new JMenuItem("White Balance", 'W');
	private final JMenuItem my_rotate_left_button = new JMenuItem("Rotate Left", 'L');
	private final JMenuItem my_rotate_right_button = new JMenuItem("Rotate Right", 'R');
	private final JMenuItem my_flip_horiz_button = new JMenuItem("Flip Horizontal", 'H');
	private final JMenuItem my_flip_vert_button = new JMenuItem("Flip Vertical", 'V');
	private final JMenuItem my_close_photo_button = new JMenuItem("Close Photo", 'P');
	
	// Window Menu Buttons
	private final JMenuItem my_minimize_button = new JMenuItem("Minimize", 'M');
	private final JMenuItem my_full_screen_button = new JMenuItem("Full Screen", 'F');
	private final JMenuItem my_zoom_button = new JMenuItem("Zoom", 'Z');
	
	// Help Menu Buttons
	private final JMenuItem my_info_button = new JMenuItem("Info", 'I');
	
	// The frame of the program
	private final JFrame my_frame;
	
	private BufferedImage my_image;
	
	private final PhotoPanel my_photo_panel;

	public MenuBar(final JFrame the_frame, final PhotoPanel the_photo_panel) {
		super();
		my_photo_panel = the_photo_panel;
		my_frame = the_frame;
		createFileMenu();
		createEditMenu();
		createViewMenu();
		createPhotoMenu();
		createWindowMenu();
		createHelpMenu();
	}
	
	private void createFileMenu() {
		JMenu fileMenu = new JMenu("File");
		
		// Add the buttons to this menu
		fileMenu.add(my_import_button);
		fileMenu.add(my_save_button);
		fileMenu.add(my_export_button);
		
		// Setup the Exit button
		my_exit_button.addActionListener(new ActionListener() {
		      public void actionPerformed(final ActionEvent the_event) {
		        my_frame.dispose();
		      }
	    });
		fileMenu.add(my_exit_button);
		
		// Add listeners to the import button.
		setImport();
		
		this.add(fileMenu);
	}
	
	private void createEditMenu() {
		JMenu editMenu = new JMenu("Edit");
		
		// Add the buttons to this menu
		editMenu.add(my_undo_button);
		editMenu.add(my_redo_button);
		
		this.add(editMenu);
	}
	
	private void createViewMenu() {
		JMenu viewMenu = new JMenu("View");
		
		// Add the buttons to this menu
		viewMenu.add(my_before_after_button);
		viewMenu.add(my_background_button);
		
		// Create the size sub menu
		JMenu size = new JMenu("Size");
		size.add(my_onebyone_button);
		size.add(my_full_button);
		size.add(my_fit_button);
		viewMenu.add(size);
		
		this.add(viewMenu);
	}
	
	private void createPhotoMenu() {
		JMenu photo_menu = new JMenu("Photo");
		
		// Add the buttons to this menu
		photo_menu.add(my_crop_button);
		photo_menu.add(my_red_eye_button);
		photo_menu.add(my_spot_remove_button);
		photo_menu.add(my_white_balance_button);
		photo_menu.add(my_rotate_left_button);
		photo_menu.add(my_rotate_right_button);
		photo_menu.add(my_flip_vert_button);
		photo_menu.add(my_flip_horiz_button);
		photo_menu.add(my_close_photo_button);
		
		this.add(photo_menu);
	}
	
	private void createWindowMenu() {
		JMenu windowMenu = new JMenu("Window");
		
		// Add the buttons to this menu
		windowMenu.add(my_minimize_button);
		windowMenu.add(my_full_screen_button);
		windowMenu.add(my_zoom_button);
		
		this.add(windowMenu);
	}
	
	private void createHelpMenu() {
		JMenu helpMenu = new JMenu("Help");
		
		// Add the buttons to this menu
		helpMenu.add(my_info_button);
		
		this.add(helpMenu);
	}
	
	//////////////////////////////////////////////
	// File menu button creators
	
	private void setImport() {
		final JFileChooser chooser = new JFileChooser();
		// Set to the current working directory
//		chooser.setCurrentDirectory(new File("."));
		
		my_import_button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent the_event) {
				final int returnVal = chooser.showOpenDialog(MenuBar.this);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					try {
						my_image = ImageIO.read(file);
						
						my_photo_panel.setImage(my_image);
						my_photo_panel.repaint();
					} catch (IOException e) {
						System.out.println("Invalid Input");
					}
					
					
				} else {
					System.out.println("canceled");
				}
			}
		});
	}
	
	
}
