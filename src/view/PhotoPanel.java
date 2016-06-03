package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PhotoPanel extends JPanel {
	
	private BufferedImage my_image = null;
	private int my_image_w;
	private int my_image_h;
	private int my_original_w;
	private int my_original_h;
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
			calcSize();
			calcPercentage();

			the_graphics.drawImage(my_image, center_x, center_y, my_image_w, my_image_h, null);
		}
	}
	
	// Set the image to the JPanel and get the height and width.
	public void setImage(BufferedImage the_image) {
		my_image = the_image;
		my_original_h = my_image.getHeight();
		my_original_w = my_image.getWidth();
		calcSize();
		calcPercentage();
		// Mark that there is an image loaded
		is_image = true;
		repaint();		
	}
	
	// Calculate the size the image will be to fill the available space on the panel without scewing the image.
	private void calcSize() {
		// Calculate the width and height of the image based on the size of the panel
		my_image_h = (int) (((double) my_image.getHeight() / (double) my_image.getWidth()) * (this.getWidth())) - 20;
		my_image_w = this.getWidth() - 20;
		
		if (my_image_h > this.getHeight()) {
			my_image_h = this.getHeight() - 20;
			my_image_w = (int) (((double) my_image.getWidth() / (double) my_image.getHeight()) * (this.getHeight())) - 20;
		}
		System.out.println("H = " + my_image_h + " W = " + my_image_w);
	}
	
	// Calculate the percentage of the original image size
	private void calcPercentage() {
		int perc_w = (int) (((double) my_image_w / (double) my_original_w) * 100.0);
		int perc_h = (int) (((double) my_image_h / (double) my_original_h) * 100.0);
		
		System.out.println("Width percent: " + perc_w + " Height percent: " + perc_h);
		
	}
	
	
//	Previous calculations for future reference:
//		if (this.getHeight() > this.getWidth()) {
//			my_image_h = (int) (((double) my_image.getHeight() / (double) my_image.getWidth()) * (this.getWidth())) - 20;
//			my_image_w = this.getWidth() - 20;
//		} else {
//			my_image_w = (int) (((double) my_image.getHeight() / (double) my_image.getWidth()) * (this.getWidth())) - 20;
//			my_image_h = this.getHeight() - 20;
//		}

	
}
