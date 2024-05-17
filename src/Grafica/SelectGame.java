package Grafica;

import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.*;

import Logica.LogicaGiocoConsole;

public class SelectGame extends JFrame implements ActionListener,MouseListener{
	
	private JButton homeButton, gameButton;
	private ArrayList<JTextField> nameTextArea;
	private ArrayList<String> username;
	private ArrayList<String> userColor;
	private ArrayList<JComboBox<String>> colorComboBox;
	private JTextField insertName;
	private String giocatori;
	private JComboBox<String> colors;
	private HashSet<String> lol = new HashSet<String>();
	
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
		int num=0;
		//asks how many players will play
		do {
			
			try {
				giocatori=JOptionPane.showInputDialog("In quanti giocatori volete giocare?");
				if(Integer.parseInt(giocatori)>4 ||Integer.parseInt(giocatori)<2) {
					JOptionPane.showMessageDialog(null,"I giocatori devono essere minimo 2, massimo 4","Attenzione!",JOptionPane.ERROR_MESSAGE);
				}
				num=Integer.parseInt(giocatori);
				
			}catch(NumberFormatException e){
				
				System.out.println("Si prega di inserire un numero intero");
			}
			
		}while(num>4 ||num<2);
		
		
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
		
		for(int i=0; i<Integer.parseInt(giocatori); i++) {
			colors= new JComboBox<String>(colori);
			JLabel user = new JLabel("Username");
			insertName = new JTextField();
			insertName.setPreferredSize(new Dimension(150,40));
			insertName.addMouseListener(this);
			JLabel colore = new JLabel("Colore");
			colorComboBox.add(colors);		
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
			if(Integer.parseInt(giocatori)<=i) {
				user.setEnabled(false);
				colorComboBox.get(i).setEnabled(false);
				insertName.setEnabled(false);
				colore.setEnabled(false);
				
			}
			
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
	
	boolean MessaggioMostrato = true;
	boolean arrayVuoto = true;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean uguale=false;
		boolean seleziona=false;
		int utenteNonInserito=0;
		int utentiUguali=0;
		 if(e.getSource()==homeButton) {
			frame.dispose();
			new Home();
		}
		if(e.getSource()==gameButton) { 
			username.clear();
			userColor.clear();
			for(int i=0; i<Integer.parseInt(giocatori);i++) {
				String s=new String(); //temporanea per salvare i nomi con spazi e cancellare spazi
				for(int j=0; j<nameTextArea.size(); j++) {
					s =nameTextArea.get(i).getText().replace(" ", "");
					//System.out.println(s);
				}
				username.add(s);
				userColor.add(colori[colorComboBox.get(i).getSelectedIndex()]);
			}
			
			for(int i=0;i<nameTextArea.size();i++){
				if(nameTextArea.get(i).getText().trim().isEmpty()) {
					utenteNonInserito=1;
				}
			}
			
			for(int i=0;i<Integer.parseInt(giocatori)-1;i++) {
				for(int j=i+1;j<Integer.parseInt(giocatori);j++) {
					if(username.get(i).equals(username.get(j))) {
						utentiUguali=1;
					}
					
				}
			}
			
			//control about different colors and names
			for(int i=0; i<Integer.parseInt(giocatori)-1;i++) {
				for(int y=i+1; y<Integer.parseInt(giocatori);y++) {
					if ((userColor.get(i).equals(userColor.get(y)))){
						uguale=true;
					}
				}
				if ((userColor.get(i).equals("Seleziona un colore"))){
					seleziona=true; //controllo che l utente abbia scelto un colore
				}
			}
			if ((userColor.get(Integer.parseInt(giocatori)-1).equals("Seleziona un colore"))){
				seleziona=true; //controllo che l utente abbia scelto un colore
			}
			
			if(seleziona==true) { //se rimangono le voci "Seleziona un colore"
				JOptionPane.showMessageDialog(null, "non sono stati"
						+ "selezionati tutti i colori" ,
					"ERRORE", JOptionPane.ERROR_MESSAGE);
			}else if(uguale==true) {  
					JOptionPane.showMessageDialog(null, "i colori dei giocatori"
						+ "devono essere e diversi tra loro" ,
						"ERRORE", JOptionPane.ERROR_MESSAGE);
			}else if(utenteNonInserito!=1 && utentiUguali!=1) {
					frame.dispose();
					JOptionPane.showMessageDialog(null, "sposta il cursore del mouse sulla carta "
							+ "x vederne il retro; \ntasto sinistro x giocarla di fronte; \n"
							+ "tasto destro x giocarla di retro",
							"INFO UTILI X GIOCARE LE CARTE",JOptionPane.INFORMATION_MESSAGE);
					new Game(username, userColor);
			}else if(utenteNonInserito==1) {
					JOptionPane.showMessageDialog(null, "Bisonga per forza inserire un nome utente!","ATTENZIONE!",JOptionPane.WARNING_MESSAGE);
			}else if(utentiUguali==1) {
					JOptionPane.showMessageDialog(null, "Gli username non possono essere uguali, rinserirli!" ,
							"ATTENZIONE", JOptionPane.WARNING_MESSAGE);
			}
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(MessaggioMostrato) {
			MessaggioMostrato=false;
			JOptionPane.showMessageDialog(null, "Il primo giocatore creato,sarà il primo ad iniziare","ATTENZIONE!",JOptionPane.INFORMATION_MESSAGE);
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
		
		
	}
	
	
}

