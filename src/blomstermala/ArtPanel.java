package blomstermala;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class ArtPanel extends JPanel{
	
	private JScrollPane paneCenter = new JScrollPane();
	private JScrollPane paneSouth = new JScrollPane();
	
	private JLabel lblHead = new JLabel();
	private JLabel lblText = new JLabel();
	
	private Article art;
	
	public ArtPanel(Article article) {
		this.art = article;
		setLayout(new BorderLayout());
		paneCenter.setAutoscrolls(true);
		paneSouth.setAutoscrolls(true);
		lblHead.setText(art.getRubrik());
		try {
			lblText.setText(setContent());
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		add(lblHead, BorderLayout.NORTH);
		paneCenter.add(lblText);
		add(paneCenter, BorderLayout.CENTER);
		showComments();
			
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
	
	public void showComments() {
		
	}
	

}
