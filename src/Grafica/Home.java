package Grafica;

import javax.swing.*;

import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener{
	
	//declaration of buttons to add to the window
	JButton nuovoGioco, regole, impostazioni,  ringraziamenti;
	private Graphics gr;
	//this window
	private JFrame frame = new JFrame();
	
	public Home() {
		
		//create the image background "sfondo" and the frame's icon "logo"
		ImageIcon sfondo = new ImageIcon("images/rule_book/Rulebook_1.jpg");
		ImageIcon logo = new ImageIcon("images/codex_logo.png");
		
		//sets title, dimension of the JFrame
		frame.setIconImage(logo.getImage());
		frame.setTitle("Codex Naturalis - Home");
		frame.setMinimumSize(new Dimension(sfondo.getIconWidth()+16, sfondo.getIconHeight()+39));
		//sets the window not resizable by the users
		frame.setResizable(false);
		//gets the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//sets the window position to the center of the screen
		frame.setLocation((screenSize.width/2)-(frame.getWidth()/2), (screenSize.height/2)-(frame.getHeight()/2));
		//exit out of application
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//game title label
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Codex Naturalis");
		titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 60));
		titleLabel.setForeground(Color.BLACK);
		
		//panel with button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(150, 150));
		buttonPanel.setLayout(new GridLayout(4,1));
		//buttons to add to the window
		nuovoGioco = new JButton("NuovoGioco");
		regole = new JButton("Regole");
		impostazioni = new JButton("Impostazioni");
		ringraziamenti = new JButton("Ringraziamenti");
		//focus state shouldn't be painted
		nuovoGioco.setFocusPainted(false);
		regole.setFocusPainted(false);
		impostazioni.setFocusPainted(false);
		ringraziamenti.setFocusPainted(false);
		//add ActionListener to buttons
		nuovoGioco.addActionListener(this);
		regole.addActionListener(this);
		impostazioni.addActionListener(this);
		ringraziamenti.addActionListener(this);
		//Font bottoni
		nuovoGioco.setFont(new Font("Serif",Font.BOLD| Font.ITALIC,20));
		regole.setFont(new Font("Serif",Font.BOLD| Font.ITALIC,20));
		impostazioni.setFont(new Font("Serif",Font.BOLD| Font.ITALIC,20));
		ringraziamenti.setFont(new Font("Serif",Font.BOLD| Font.ITALIC,18));
		//aggiunta cursore su pulsanti
		nuovoGioco.setCursor(new Cursor(Cursor.HAND_CURSOR));
		regole.setCursor(new Cursor(Cursor.HAND_CURSOR));
		impostazioni.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ringraziamenti.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//adds buttons to the window
		buttonPanel.add(nuovoGioco);
		buttonPanel.add(regole);
		buttonPanel.add(impostazioni);
		buttonPanel.add(ringraziamenti);
		buttonPanel.setVisible(true);
		
		//contains titleLabel and buttonPanel 
		JPanel rowPanel = new JPanel();
		rowPanel.setLayout(new GridBagLayout());
		rowPanel.setOpaque(false);
		
		//needed to set a gap between titleLabel and buttonPanel
		JPanel gapPanel = new JPanel();
		gapPanel.setPreferredSize(new Dimension(50, 50));
		gapPanel.setOpaque(false);
		
		
		//add components to rowPanel
		GridBagConstraints gbc = new GridBagConstraints();		
		gbc.gridx=0;
		gbc.gridy=0;
		rowPanel.add(titleLabel, gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		rowPanel.add(gapPanel, gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		rowPanel.add(buttonPanel, gbc);
		
		JLabel sfondoLabel = new JLabel();
		sfondoLabel.setIcon(sfondo);
		
		//contains sfondoLabel and rowPanel
		JPanel homePanel = new JPanel();
		homePanel.setLayout(new GridBagLayout());
		//add components to homePanel
		gbc.gridx=0;
		gbc.gridy=0;
		homePanel.add(rowPanel, gbc);
		homePanel.add(sfondoLabel, gbc);
		
		//add homePanel to window
		frame.add(homePanel);	
		//makes frame visible
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==nuovoGioco) {
			frame.dispose();
			SelectGame SelectGameFrame = new SelectGame();
		}else if(e.getSource()==regole) {
			frame.dispose();
			Rules rulesFrame = new Rules();
		}else if(e.getSource()==impostazioni) {
			frame.dispose();
			Settings settingsFrame = new Settings();
		}else if(e.getSource()==ringraziamenti) {
			frame.dispose();
			Thanks thanksFrame = new Thanks();
		}
		
	}

}
