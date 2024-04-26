package Grafica;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
		gapPanel.setMinimumSize(new Dimension(50, 70));
		gapPanel.setOpaque(false);
		
		//needed to set a gap between titleLabel and buttonPanel
		JPanel gapPanel2 = new JPanel();
		gapPanel2.setMinimumSize(new Dimension(50, 100));
		gapPanel2.setOpaque(false);
				
		//description
		JLabel descriptionLabel1=new JLabel("Progetto svolto in collaborazione con:");
		descriptionLabel1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		descriptionLabel1.setForeground(Color.WHITE);
		
		JLabel authorsLabel1=new JLabel("Matteo Casiraghi");
		authorsLabel1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		authorsLabel1.setForeground(Color.WHITE);
		JLabel authorsLabel2=new JLabel("Samuele Vecchi");
		authorsLabel2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		authorsLabel2.setForeground(Color.WHITE);
		JLabel authorsLabel3=new JLabel("Samuel Gagliardi");
		authorsLabel3.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		authorsLabel3.setForeground(Color.WHITE);
		JLabel authorsLabel4=new JLabel("Oscar Beni");
		authorsLabel4.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 20));
		authorsLabel4.setForeground(Color.WHITE);
		
		JLabel descriptionLabel2=new JLabel("Bergamo 2024.");
		descriptionLabel2.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 15));
		descriptionLabel2.setForeground(Color.RED);
		descriptionLabel2.setMinimumSize(new Dimension(sfondo.getIconWidth()-50, 20));
		
		JTextArea j = new JTextArea();
		
		//panel with descriptionLabel1 and descriptionLabel2
		JPanel descriptionPanel1 = new JPanel();
		descriptionPanel1.setPreferredSize(new Dimension(400, 400));
		descriptionPanel1.setLayout(new GridBagLayout());
		descriptionPanel1.setOpaque(false);
		
		//add components to descriptionPanel1
		GridBagConstraints gbc = new GridBagConstraints();		
		gbc.gridx=0;
		gbc.gridy=0;
		descriptionPanel1.add(descriptionLabel1, gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		descriptionPanel1.add(authorsLabel1, gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		descriptionPanel1.add(authorsLabel2, gbc);
		gbc.gridx=0;
		gbc.gridy=3;
		descriptionPanel1.add(authorsLabel3, gbc);
		gbc.gridx=0;
		gbc.gridy=4;
		descriptionPanel1.add(authorsLabel4, gbc);
		
		//panel with descriptionLabel3
		JPanel descriptionPanel2 = new JPanel();
		descriptionPanel2.setPreferredSize(new Dimension(400, 400));
		descriptionPanel2.setLayout(new BorderLayout());
		descriptionPanel2.setOpaque(false);
		
		//add components to descriptionPanel2
		descriptionPanel2.add(descriptionLabel2, BorderLayout.EAST);
		
		//add components to rowPanel		
		gbc.gridx=0;
		gbc.gridy=0;
		rowPanel.add(titleLabel, gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		rowPanel.add(gapPanel, gbc);
		gbc.gridx=0;
		gbc.gridy=2;
		rowPanel.add(descriptionPanel1, gbc);
		gbc.gridx=0;
		gbc.gridy=3;
		rowPanel.add(descriptionPanel2, gbc);
		gbc.gridx=0;
		gbc.gridy=4;
		rowPanel.add(gapPanel2, gbc);
		gbc.gridx=0;
		gbc.gridy=5;
		rowPanel.add(homeButton, gbc);
		JLabel sfondoLabel = new JLabel();
		sfondoLabel.setIcon(sfondo);
		
		//contains sfondoLabel and rowPanel
		JPanel thanksPanel = new JPanel();
		thanksPanel.setBackground(Color.RED);
		thanksPanel.setPreferredSize(new Dimension(sfondo.getIconWidth(), sfondo.getIconHeight()));
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
