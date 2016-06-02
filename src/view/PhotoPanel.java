package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class PhotoPanel extends JPanel {
	
	private static final Border BLACK_LINE = BorderFactory.createLineBorder(Color.BLACK, 3);
	
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
		setBorder(BLACK_LINE);
	}
	
	
	@Override
	public void paintComponent(final Graphics the_graphics) {
		super.paintComponent(the_graphics);
		if (is_image) {
			
			// Calculate the left point to center the image
			
			the_graphics.drawImage(my_image, 0, 0, my_image_w, my_image_h, null);
		}
	}
	
	public void setImage(BufferedImage the_image) {
		my_image = the_image;
		
		if (my_image.getHeight() > my_image.getWidth()) {
			my_image_h = (int) (((double) my_image.getHeight() / (double) my_image.getWidth()) * (this.getWidth()));
			my_image_w = this.getWidth();
		} else {
			my_image_w = (int) (((double) my_image.getHeight() / (double) my_image.getWidth()) * (this.getWidth()));
			my_image_h = this.getHeight();
		}
		
		System.out.println("height = " + my_image_h + " Width = " + my_image_w);
		System.out.println(((double)my_image.getHeight() / (double)my_image.getWidth()));
		
		is_image = true;
		repaint();
		
		
//		JLabel img = new JLabel();
//		img.setIcon(new ImageIcon(dimg));
//		add(img, BorderLayout.CENTER);
	}
	
	private void setSize() {
		
	}
	
}
