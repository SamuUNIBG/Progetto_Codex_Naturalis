package Grafica;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class Home extends JFrame implements ActionListener{
	
	//declaration of buttons to add to the window
	JButton nuovoGioco, regole, impostazioni,  ringraziamenti;
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
		buttonPanel.setPreferredSize(new Dimension(150, 180));
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setOpaque(false);
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
		//set button font
		nuovoGioco.setFont(new Font("Serif",Font.BOLD| Font.ITALIC,20));
		regole.setFont(new Font("Serif",Font.BOLD| Font.ITALIC,20));
		impostazioni.setFont(new Font("Serif",Font.BOLD| Font.ITALIC,20));
		ringraziamenti.setFont(new Font("Serif",Font.BOLD| Font.ITALIC,18));
		//modify button cursor
		nuovoGioco.setCursor(new Cursor(Cursor.HAND_CURSOR));
		regole.setCursor(new Cursor(Cursor.HAND_CURSOR));
		impostazioni.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ringraziamenti.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//set button's dimension
		nuovoGioco.setPreferredSize(new Dimension(150, 35));
		regole.setPreferredSize(new Dimension(150, 35));
		impostazioni.setPreferredSize(new Dimension(150, 35));
		ringraziamenti.setPreferredSize(new Dimension(150, 35));
		
		
		//needed to set a gap between button
		JPanel gapPanel1 = new JPanel();
		gapPanel1.setMinimumSize(new Dimension(5, 5));
		gapPanel1.setOpaque(false);
		JPanel gapPanel2 = new JPanel();
		gapPanel2.setMaximumSize(new Dimension(5, 5));
		gapPanel2.setOpaque(false);
		JPanel gapPanel3 = new JPanel();
		gapPanel3.setMaximumSize(new Dimension(5, 5));
		gapPanel3.setOpaque(false);

		//adds buttons to the window
		GridBagConstraints gbc = new GridBagConstraints();		
		gbc.gridx=0;
		gbc.gridy=0;
		buttonPanel.add(nuovoGioco, gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		buttonPanel.add(gapPanel1, gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		buttonPanel.add(regole, gbc);
		gbc.gridx=0;
		gbc.gridy=3;
		buttonPanel.add(gapPanel2, gbc);
		gbc.gridx=0;
		gbc.gridy=4;
		buttonPanel.add(impostazioni, gbc);
		gbc.gridx=0;
		gbc.gridy=5;
		buttonPanel.add(gapPanel3, gbc);
		gbc.gridx=0;
		gbc.gridy=6;
		buttonPanel.add(ringraziamenti, gbc);
		buttonPanel.setVisible(true);
		
		//contains titleLabel and buttonPanel 
		JPanel rowPanel = new JPanel();
		rowPanel.setLayout(new GridBagLayout());
		rowPanel.setOpaque(false);
		
		//needed to set a gap between titleLabel and buttonPanel
		JPanel gapPanel4 = new JPanel();
		gapPanel4.setPreferredSize(new Dimension(50, 50));
		gapPanel4.setOpaque(false);
		
		
		//add components to rowPanel	
		gbc.gridx=0;
		gbc.gridy=0;
		rowPanel.add(titleLabel, gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		rowPanel.add(gapPanel4, gbc);
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
			new SelectGame();
		}else if(e.getSource()==regole) {
			frame.dispose();
			new Rules();
		}else if(e.getSource()==impostazioni) {
			frame.dispose();
			Settings settingsFrame = new Settings();
		}else if(e.getSource()==ringraziamenti) {
			frame.dispose();
			new Thanks();
		}
		
	}

}
