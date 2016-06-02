package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class EditsPanel extends JPanel {

	private static final Border BLUE_LINE = BorderFactory.createLineBorder(Color.BLUE, 3);

	public EditsPanel() {
		super();
		setupPanel();
	}
	
	private void setupPanel() {
		setPreferredSize(new Dimension(200, 600));
		setLayout(new BorderLayout());
		setBorder(BLUE_LINE);
	}
	
}
