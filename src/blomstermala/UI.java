package blomstermala;

import java.awt.Dimension;

import javax.swing.*;

public class UI extends JPanel {
	
	public static void main(String [] args) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(new UI());
	}

}
