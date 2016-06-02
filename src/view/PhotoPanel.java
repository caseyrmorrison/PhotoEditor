package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class PhotoPanel extends JPanel {
	
	private BufferedImage my_image = null;
	private int my_image_w;
	private int my_image_h;
	private boolean is_image = false;

	public PhotoPanel() {
		super();
		setupPanel();
	}
	
	private void setupPanel() {
		setLayout(new BorderLayout());
	}
	
	
	@Override
	public void paintComponent(final Graphics the_graphics) {
		super.paintComponent(the_graphics);
		if (is_image) {
			
			// Calculate the point to center the image
			int center_x = (this.getWidth() / 2) - (my_image_w / 2);
			int center_y = (this.getHeight() / 2) - (my_image_h / 2);
			
			// Calculate the width and height of the image based on the size of the panel
			if (my_image_h > my_image_w) {
				my_image_h = (int) (((double) my_image.getHeight() / (double) my_image.getWidth()) * (this.getWidth())) - 20;
				my_image_w = this.getWidth() - 20;
			} else {
				my_image_w = (int) (((double) my_image.getHeight() / (double) my_image.getWidth()) * (this.getWidth())) - 20;
				my_image_h = this.getHeight() - 20;
			}

			the_graphics.drawImage(my_image, center_x, center_y, my_image_w, my_image_h, null);
		}
	}
	
	public void setImage(BufferedImage the_image) {
		my_image = the_image;
		
		// Calculate the width and height of the image based on the size of the panel
		if (my_image.getHeight() > my_image.getWidth()) {
			my_image_h = (int) (((double) my_image.getHeight() / (double) my_image.getWidth()) * (this.getWidth())) - 20;
			my_image_w = this.getWidth() - 20;
		} else {
			my_image_w = (int) (((double) my_image.getHeight() / (double) my_image.getWidth()) * (this.getWidth())) - 20;
			my_image_h = this.getHeight() - 20;
		}
		
		// Mark that there is an image loaded
		is_image = true;
		repaint();		
	}

	
}
