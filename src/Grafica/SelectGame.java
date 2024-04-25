package Grafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class SelectGame extends JFrame implements ActionListener{
	
	JButton homeButton;
	ArrayList<JTextArea> nameTextArea;
	ArrayList<JLabel> infoTextArea;
	ArrayList<JComboBox<String>> colorComboBox;
	private String[] colori = {"Azzurro", "Giallo", "Rosso", "Verde"};
	//this window
	private JFrame frame = new JFrame();
	
	public SelectGame() {
		
		//create the frame's icon "logo"
		ImageIcon logo = new ImageIcon("images/codex_logo.png");
		ImageIcon sfondo = new ImageIcon("images/sfondi/sfondo_1.jpg");
		//sets title, dimension of the JFrame
		frame.setIconImage(logo.getImage());
		frame.setTitle("Codex Naturalis - Seleziona giocatori");
		frame.setMinimumSize(new Dimension(sfondo.getIconWidth()+16, sfondo.getIconHeight()+39));
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
		titleLabel.setOpaque(false);
		
		homeButton = new JButton("Home");
		homeButton.setFocusPainted(false);
		homeButton.addActionListener(this);
		
		//panel with info components
		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(500, 500));
		infoPanel.setLayout(new GridBagLayout());
		infoPanel.setOpaque(false);
				
		//components to add to the rulePane
		infoTextArea = new ArrayList<JLabel>();
		nameTextArea = new 	ArrayList<JTextArea>();
		colorComboBox = new ArrayList<JComboBox<String>>();
		//needed to set a gap between ifnoPanel and homeButton
		JPanel gapPanel = new JPanel();
		gapPanel.setPreferredSize(new Dimension(200, 200));
		gapPanel.setOpaque(false);
		//add components to infoPanel
		GridBagConstraints gbc = new GridBagConstraints();
		int f=0;
		int g=0;
		gbc.gridx=0;
		gbc.gridy=0;
		infoPanel.add(titleLabel,gbc);
		for(int i=0; i<4; i++) {
			JLabel user=new JLabel("Username");
			JTextArea spazio=new JTextArea("-----");
			JLabel colore=new JLabel("Colore");
			user.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
			user.setForeground(Color.BLACK);
			spazio.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
			spazio.setForeground(Color.BLACK);
			spazio.setOpaque(false);
			colore.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
			colore.setForeground(Color.BLACK);
			infoTextArea.add(user);
			nameTextArea.add(spazio);
			infoTextArea.add(colore);
			colorComboBox.add(new JComboBox<String>(colori));
			gbc.gridx=0;
			gbc.gridy=g+2;
			infoPanel.add(infoTextArea.get(f), gbc);
			gbc.gridx=1;
			gbc.gridy=g+2;
			infoPanel.add(nameTextArea.get(i), gbc);
			gbc.gridx=0;
			gbc.gridy=g+3;
			infoPanel.add(infoTextArea.get(f+1), gbc);
			gbc.gridx=1;
			gbc.gridy=g+3;
			infoPanel.add(colorComboBox.get(i), gbc);
			gbc.gridx=0;
			gbc.gridy=g+4;
			infoPanel.add(gapPanel,gbc);
			gbc.gridx=1;
			gbc.gridy=g+5;
			infoPanel.add(homeButton,gbc);
			f+=2;
			g+=2;
		}
		
		JLabel sfondoLabel = new JLabel();
		sfondoLabel.setIcon(sfondo);
		
		
		//panel with titleLabel and selectGamePanel
		JPanel selectGamePanel = new JPanel();
		selectGamePanel.setLayout(new GridBagLayout());
		
		
		//add components to rowPanel
		//GridBagConstraints gbc = new GridBagConstraints();		
		gbc.gridx=0;
		gbc.gridy=0;
		selectGamePanel.add(infoPanel, gbc); 
		selectGamePanel.add(sfondoLabel, gbc);
		
		
		
		//add homePanel to window
		frame.add(selectGamePanel);
		//set window's dimension based on components
		frame.pack();
		//makes frame visible
		frame.setVisible(true);		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==homeButton) {
			frame.dispose();
			Home home = new Home();
		}
	}
	
}

