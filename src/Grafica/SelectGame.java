package Grafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class SelectGame extends JFrame implements ActionListener{
	
	ArrayList<JTextArea> nameTextArea;
	ArrayList<JTextArea> infoTextArea;
	ArrayList<JComboBox<String>> colorComboBox;
	private String[] colori = {"Azzurro", "Giallo", "Rosso", "Verde"};
	//this window
	private JFrame frame = new JFrame();
	
	public SelectGame() {
		
		//create the frame's icon "logo"
		ImageIcon logo = new ImageIcon("images/codex_logo.png");
		
		//sets title, dimension of the JFrame
		frame.setIconImage(logo.getImage());
		frame.setTitle("Codex Naturalis - Home");
		//frame.setMinimumSize(new Dimension(sfondo.getIconWidth()+16, sfondo.getIconHeight()+39));
		//sets the window not resizable by the users
		frame.setResizable(false);
		//gets the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//sets the window position to the center of the screen
		frame.setLocation((screenSize.width/2)-(frame.getWidth()/2), (screenSize.height/2)-(frame.getHeight()/2));
		//exit out of application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//"select game" title label
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Seleziona giocatori");
		titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		titleLabel.setForeground(Color.BLACK);
		
		//panel with info components
		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(500, 500));
		infoPanel.setLayout(new GridBagLayout());
				
		//components to add to the rulePane
		infoTextArea = new ArrayList<JTextArea>();
		nameTextArea = new 	ArrayList<JTextArea>();
		colorComboBox = new ArrayList<JComboBox<String>>();
		//add components to infoPanel
		GridBagConstraints gbc = new GridBagConstraints();
		int f=0;
		int g=0;
		for(int i=0; i<4; i++) {
			infoTextArea.add(new JTextArea("Username"));
			nameTextArea.add(new JTextArea("-----"));
			infoTextArea.add(new JTextArea("Colore"));
			colorComboBox.add(new JComboBox<String>(colori));
			gbc.gridx=0;
			gbc.gridy=g;
			infoPanel.add(infoTextArea.get(f), gbc);
			gbc.gridx=1;
			gbc.gridy=g;
			infoPanel.add(nameTextArea.get(i), gbc);
			gbc.gridx=0;
			gbc.gridy=g+1;
			infoPanel.add(infoTextArea.get(f+1), gbc);
			gbc.gridx=1;
			gbc.gridy=g+1;
			infoPanel.add(colorComboBox.get(i), gbc);
			f+=2;
			g+=2;
		}
		infoPanel.setVisible(true);		
		
		//panel with titleLabel and selectGamePanel
		JPanel selectGamePanel = new JPanel();
		selectGamePanel.setPreferredSize(new Dimension(500, 500));
		selectGamePanel.setLayout(new GridBagLayout());
		selectGamePanel.setVisible(true);
		
		
		//add components to rowPanel
		//GridBagConstraints gbc = new GridBagConstraints();		
		gbc.gridx=0;
		gbc.gridy=0;
		selectGamePanel.add(titleLabel, gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		selectGamePanel.add(infoPanel, gbc);
		
		
		//add homePanel to window
		frame.add(selectGamePanel);
		//set window's dimension based on components
		frame.pack();
		//makes frame visible
		frame.setVisible(true);		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
