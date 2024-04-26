package Grafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Rules extends JFrame implements ActionListener{

		//declaration of buttons to add to the window
		JButton homeButton, precedente, successivo;
		//declaration of label that contains rule-book image
		JLabel ruleLabel;
		//declaration of rule-book image array
		ImageIcon[] ruleBook = {new ImageIcon("images/rule_book/Rulebook_1.jpg"),new ImageIcon("images/rule_book/Rulebook_2.jpg"),new ImageIcon("images/rule_book/Rulebook_3.jpg"),
								new ImageIcon("images/rule_book/Rulebook_4.jpg"),new ImageIcon("images/rule_book/Rulebook_5.jpg"),new ImageIcon("images/rule_book/Rulebook_6.jpg"),
								new ImageIcon("images/rule_book/Rulebook_7.jpg"),new ImageIcon("images/rule_book/Rulebook_8.jpg"),new ImageIcon("images/rule_book/Rulebook_9.jpg"),
								new ImageIcon("images/rule_book/Rulebook_10.jpg"),new ImageIcon("images/rule_book/Rulebook_11.jpg"),new ImageIcon("images/rule_book/Rulebook_12.jpg")};
		//indicates image to print
		int rulePage = 0;
		//this window
		private JFrame frame = new JFrame();
		
		public Rules() {
			
			//create the frame's icon "logo"
			ImageIcon logo = new ImageIcon("images/codex_logo.png");
			
			//sets title, dimension of the JFrame
			frame.setIconImage(logo.getImage());
			frame.setTitle("Codex Naturalis - Regole");
			frame.setSize(new Dimension(1000,1000));
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
			titleLabel.setText("Regole");
			titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
			titleLabel.setForeground(Color.BLACK);
			
			//panel with button
			JPanel rulePanel = new JPanel();
			rulePanel.setPreferredSize(new Dimension(1000, 1000));
			rulePanel.setLayout(new FlowLayout());
			
			//buttons to add to the rulePane
			precedente = new JButton("<");
			successivo = new JButton(">");
			//buttons to add to the rowPane
			homeButton = new JButton("Home");
			//focus state shouldn't be painted
			precedente.setFocusPainted(false);
			successivo.setFocusPainted(false);
			homeButton.setFocusPainted(false);
			//add ActionListener to buttons
			precedente.addActionListener(this);
			successivo.addActionListener(this);
			homeButton.addActionListener(this);
			//label to add to the window
			ruleLabel = new JLabel();
			ruleLabel.setIcon(ruleBook[0]);
			//adds buttons to the window
			rulePanel.add(precedente);
			rulePanel.add(ruleLabel);
			rulePanel.add(successivo);
			rulePanel.setVisible(true);
			
			//contains titleLabel, buttonPanel and homeButton
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
			rowPanel.add(rulePanel, gbc);
			gbc.gridx=0;
			gbc.gridy=3;
			rowPanel.add(homeButton, gbc);
			
			JLabel sfondoLabel = new JLabel();
			sfondoLabel.setBackground(Color.GREEN);
			sfondoLabel.setOpaque(true);
			
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
			if(e.getSource()==precedente) {
				if(rulePage>0)
					rulePage--;
				if(rulePage>=0)
					ruleLabel.setIcon(ruleBook[rulePage]);
			}else if(e.getSource()==successivo) {
				if(rulePage<11)
					rulePage++;
				if(rulePage<=11)
					ruleLabel.setIcon(ruleBook[rulePage]);
			}else if(e.getSource()==homeButton) {
				frame.dispose();
				new Home();
			}
			
		}
	
}
