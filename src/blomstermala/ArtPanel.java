package blomstermala;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class ArtPanel extends JPanel implements ActionListener {
	
	private JScrollPane paneSouth = new JScrollPane();
	
	private JPanel panelSouth = new JPanel();
	
	private JLabel lblHead = new JLabel();
	
	private JTextArea areaText = new JTextArea();
	
	private JPanel panel = new JPanel();
	
	private static JFrame mainFrame = new JFrame();
	
	private JButton btnAdd = new JButton("Kommentera");
	
	private Article art;
	
	private Controller cont;
	
	public ArtPanel(Article article, Controller inCont) {
		this.cont = inCont;
		this.art = article;
		setLayout(new BorderLayout());
		btnAdd.setSize(new Dimension(150, 30));
		panel.setLayout(new BorderLayout());
		panelSouth.setLayout(new GridLayout(10,1));
		paneSouth.setAutoscrolls(true);
		lblHead.setText(art.getRubrik());
		lblHead.setFont(getFont().deriveFont(18.0f));
		areaText.setLineWrap(true);
		areaText.setWrapStyleWord(true);
		try {
			areaText.setText(setContent());
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		add(lblHead, BorderLayout.NORTH);
		add(areaText, BorderLayout.CENTER);
		setOpaque(false);
		setVisible(true);
		
		panelSouth.setOpaque(false);
		panelSouth.add(btnAdd);
		btnAdd.addActionListener(this);
		showComments();
//		paneCenter.add(panel);
//		showComments();
		//HEJ
			
	}
	
	public String setContent() throws FileNotFoundException, IOException {
		String e;
		File file = new File(art.getInnehåll());
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while(line != null){
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			e = sb.toString();
			System.out.println(e);
		}
		return e;
	}
	
	public void createCommentPanel() {
		int result = 0;
		String name, comment;
		JTextField nameField = new JTextField(8);
		JTextArea area = new JTextArea();

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(nameField);
		panel.add(area);

		result = JOptionPane.showConfirmDialog(null, panel, "Kommentera",
				JOptionPane.OK_CANCEL_OPTION);
		if (result == JOptionPane.OK_OPTION) {
			name = nameField.getText();
			comment = area.getText();
			cont.setComment(name, comment);
			cont.article();
			
		}
	}
	
	public void showComments() {
		Kommentar[] kom = art.getKommentar();
		System.out.println(kom[0].getInnehall());
		System.out.println(kom.length);
		for (int i=1; i < kom.length; i++) {
			panelSouth.add(new JLabel("" + kom[i].getInnehall() + "\nAv " + kom[i].getNamn() + "\n"));
			panelSouth.add(new JLabel());
//			add(panelSouth, BorderLayout.SOUTH);
		}
		add(panelSouth, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			createCommentPanel();
		}
		
	}
}
