package Grafica;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Thanks extends JFrame implements ActionListener{
	JButton homeButton;
	//this window
	private JFrame frame = new JFrame();
	
	
	
	public Thanks(){
		//create the image background "sfondo" and the frame's icon "logo"
				ImageIcon sfondo = new ImageIcon("images/sfondi/sfondo_2.jpg");
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
				titleLabel.setText("Ringraziamenti");
				titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 60));
				titleLabel.setForeground(Color.WHITE);
				
				//buttons to add to the rowPane
				homeButton = new JButton("Home");
				//focus state shouldn't be painted
				homeButton.setFocusPainted(false);
				//add ActionListener to buttons
				homeButton.addActionListener(this);
				//contains titleLabel and buttonPanel 
				JPanel rowPanel = new JPanel();
				rowPanel.setLayout(new GridBagLayout());
				rowPanel.setOpaque(false);
				
				//needed to set a gap between titleLabel and buttonPanel
				JPanel gapPanel = new JPanel();
				gapPanel.setPreferredSize(new Dimension(50, 50));
				gapPanel.setOpaque(false);
				
				//needed to set a gap between titleLabel and buttonPanel
				JPanel gapPanel2 = new JPanel();
				gapPanel2.setPreferredSize(new Dimension(200, 200));
				gapPanel2.setOpaque(false);
				
				//descrizione
				JLabel descrizione=new JLabel("Progetto svolto in collaborazione con:");
				descrizione.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
				descrizione.setForeground(Color.WHITE);
				JLabel descrizione2=new JLabel("Matteo Casiraghi, Samuele, Samuele e Oscar.");
				descrizione2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
				descrizione2.setForeground(Color.WHITE);
				JLabel descrizione3=new JLabel("Bergamo 2024.");
				descrizione3.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
				descrizione3.setForeground(Color.RED);
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
				rowPanel.add(descrizione, gbc);
				gbc.gridx=0;
				gbc.gridy=3;
				rowPanel.add(descrizione2, gbc);
				gbc.gridx=1;
				gbc.gridy=4;
				rowPanel.add(descrizione3, gbc);
				gbc.gridx=0;
				gbc.gridy=5;
				rowPanel.add(gapPanel2, gbc);
				gbc.gridx=0;
				gbc.gridy=6;
				rowPanel.add(homeButton, gbc);
				JLabel sfondoLabel = new JLabel();
				sfondoLabel.setIcon(sfondo);
				
				//contains sfondoLabel and rowPanel
				JPanel thanksPanel = new JPanel();
				thanksPanel.setLayout(new GridBagLayout());
				//add components to homePanel
				gbc.gridx=0;
				gbc.gridy=0;
				thanksPanel.add(rowPanel, gbc);
				thanksPanel.add(sfondoLabel, gbc);
				
				//add homePanel to window
				frame.add(thanksPanel);	
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
