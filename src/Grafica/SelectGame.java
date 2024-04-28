package Grafica;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.*;

public class SelectGame extends JFrame implements ActionListener,MouseListener{
	
	JButton homeButton, gameButton;
	ArrayList<JTextField> nameTextArea;
	ArrayList<String> username;
	ArrayList<String> userColor;
	ArrayList<JComboBox<String>> colorComboBox;
	JTextField insertName;
	
	HashSet<String> lol = new HashSet<String>();
	
	private String[] colori = {"Seleziona un colore", "Azzurro", "Giallo", "Rosso", "Verde"};
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
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setOpaque(false);
		
		//buttons to add to the infoPanel
		homeButton = new JButton("Home");
		homeButton.setFocusPainted(false);
		homeButton.addActionListener(this);
		gameButton = new JButton("Start game");
		gameButton.setFocusPainted(false);
		gameButton.addActionListener(this);
		
		//panel with info components
		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(500, 500));
		infoPanel.setLayout(new GridBagLayout());
		infoPanel.setOpaque(false);
				
		//components to add to the infoPanel
		//infoTextArea = new ArrayList<JLabel>();
		nameTextArea = new 	ArrayList<JTextField>();
		colorComboBox = new ArrayList<JComboBox<String>>();
		//needed to set a gap between ifnoPanel and homeButton
		JPanel gapPanel = new JPanel();
		gapPanel.setPreferredSize(new Dimension(200, 200));
		gapPanel.setOpaque(false);
		
		username = new ArrayList<String>();
		userColor = new ArrayList<String>();
		
		//add components to infoPanel
		GridBagConstraints gbc = new GridBagConstraints();
		int y=0;
		gbc.gridx=0;
		gbc.gridy=0;
		infoPanel.add(titleLabel,gbc);
		for(int i=0; i<4; i++) {
			JLabel user = new JLabel("Username");
			insertName = new JTextField();
			insertName.setPreferredSize(new Dimension(150,40));
			insertName.addMouseListener(this);
			JLabel colore = new JLabel("Colore");
			colorComboBox.add(new JComboBox<String>(colori));		
			
			user.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
			user.setForeground(Color.WHITE);
			insertName.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
			insertName.setForeground(Color.WHITE);
			insertName.setOpaque(false);
			colore.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
			colore.setForeground(Color.WHITE);
			
			nameTextArea.add(insertName);
			
			gbc.gridx=0;
			gbc.gridy=y+1;
			infoPanel.add(user, gbc);
			gbc.gridx=1;
			gbc.gridy=y+1;
			infoPanel.add(nameTextArea.get(i), gbc);
			
			gbc.gridx=0;
			gbc.gridy=y+2;
			infoPanel.add(colore, gbc);
			gbc.gridx=1;
			gbc.gridy=y+2;
			infoPanel.add(colorComboBox.get(i), gbc);
		
			gbc.gridx=0;
			gbc.gridy=y+3;
			infoPanel.add(gapPanel, gbc);
			
			y+=2;
		}
		gbc.gridx=0;
		gbc.gridy=y+1;
		infoPanel.add(homeButton, gbc);
		gbc.gridx=1;
		gbc.gridy=y+1;
		infoPanel.add(gameButton, gbc);
		
		JLabel sfondoLabel = new JLabel();
		sfondoLabel.setIcon(sfondo);
		
		//panel with titleLabel and selectGamePanel
		JPanel selectGamePanel = new JPanel();
		selectGamePanel.setLayout(new GridBagLayout());
		
		//add components to rowPanel
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
	
	boolean firstTime = true;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==homeButton) {
			frame.dispose();
			new Home();
		}
		if(e.getSource()==gameButton) { 
			if(firstTime)
			for(int i=0; i<4;i++) {
					username.add(nameTextArea.get(i).getText());
					userColor.add(colori[colorComboBox.get(i).getSelectedIndex()]);
					firstTime=false;
			}
			if(!firstTime)
			for(int i=0; i<4;i++) {
				username.set(i, nameTextArea.get(i).getText());
				userColor.set(i, colori[colorComboBox.get(i).getSelectedIndex()]);
			}
		
			if (colorComboBox.get(0).getSelectedItem().equals(colorComboBox.get(1).getSelectedItem()) ||
					colorComboBox.get(2).getSelectedItem().equals(colorComboBox.get(0).getSelectedItem()) ||
					colorComboBox.get(2).getSelectedItem().equals(colorComboBox.get(1).getSelectedItem()) ||
					colorComboBox.get(3).getSelectedItem().equals(colorComboBox.get(0).getSelectedItem()) ||
					colorComboBox.get(3).getSelectedItem().equals(colorComboBox.get(1).getSelectedItem()) ||
					colorComboBox.get(3).getSelectedItem().equals(colorComboBox.get(2).getSelectedItem()) ) {
				JOptionPane.showMessageDialog(null, "il colore iserito e gia stato scelto,"
						+ "seleziona un nuovo colore",
						"ERRORE", JOptionPane.ERROR_MESSAGE);
			}
			
			else {
				frame.dispose();
				new Game(username, userColor);
			}
			System.out.println(username);
			System.out.println(userColor);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if( firstTime==true) {
			firstTime=false;
			if(insertName.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Il primo giocatore creato,sarà il primo ad iniziare","ATTENZIONE!",JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

