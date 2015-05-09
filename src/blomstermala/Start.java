package blomstermala;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Start {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(new UI());
	}

}
