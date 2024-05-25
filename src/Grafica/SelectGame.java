package Grafica;

import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.*;
/**
 * classe per la gestione della scelta dei nomi e dei colori
 * dei giocatori in base a quanti giocatori giocano
 */
public class SelectGame extends JFrame implements ActionListener, WindowListener{
	
	private JButton homeButton, gameButton;
	private ArrayList<JTextField> nameTextArea;
	private ArrayList<String> username;
	private ArrayList<String> userColor;
	private ArrayList<JComboBox<String>> colorComboBox;
	private JTextField insertName;
	private String giocatori;
	private JComboBox<String> colors;
	
	private String[] colori = {"Seleziona un colore", "Azzurro", "Giallo", "Rosso", "Verde"};
	
	public SelectGame() {
		
		//create the frame's icon "logo"
		ImageIcon logo = new ImageIcon("images/codex_logo.png");
		ImageIcon sfondo = new ImageIcon("images/sfondi/sfondo_1.jpg");
		//sets title, dimension of the JFrame
		this.setIconImage(logo.getImage());
		this.setTitle("Codex Naturalis - Seleziona giocatori");
		this.setMinimumSize(new Dimension(sfondo.getIconWidth()+16, sfondo.getIconHeight()+39));
		//sets the window not resizable by the users
		this.setResizable(false);
		//gets the size of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//sets the window position to the center of the screen
		this.setLocation((screenSize.width/2)-(this.getWidth()/2), (screenSize.height/2)-(this.getHeight()/2));
		//exit out of application
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(this);
		
		int num=0;
		//asks how many players will play
		do {
			
			try {
				giocatori=JOptionPane.showInputDialog("In quanti giocatori volete giocare?");
				if(Integer.parseInt(giocatori)>4 || Integer.parseInt(giocatori)<2) {
					JOptionPane.showMessageDialog(null,"I giocatori devono essere minimo 2, massimo 4","Attenzione!",JOptionPane.ERROR_MESSAGE);
				}
				num=Integer.parseInt(giocatori);
				
			}catch(NumberFormatException e){}
			
		}while(num>4 || num<2);
		
		
		//"select game" title label
		JLabel titleLabel = new JLabel();
		titleLabel.setText("Seleziona giocatori");
		titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setOpaque(false);
		
		//buttons to add to the infoPanel
		homeButton = new JButton("Home");
		gameButton = new JButton("Start game");
		
		homeButton.setFocusPainted(false);
		gameButton.setFocusPainted(false);
		
		homeButton.addActionListener(this);
		gameButton.addActionListener(this);
		
		homeButton.setFont(new Font("Serif",Font.BOLD| Font.ITALIC,15));
		gameButton.setFont(new Font("Serif",Font.BOLD| Font.ITALIC,15));
		
		homeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		gameButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//panel with info components
		JPanel infoPanel = new JPanel();
		infoPanel.setPreferredSize(new Dimension(500, 500));
		infoPanel.setLayout(new GridBagLayout());
		infoPanel.setOpaque(false);
				
		//components to add to the infoPanel
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
		this.add(selectGamePanel);
		//set window's dimension based on components
		this.pack();
		//makes frame visible
		this.setVisible(true);		
		
	}

	boolean arrayVuoto = true;
	
	@Override
	/**
	 * finita la personalizzazione dei giocatori
	 * si puo scegliere se tornare alla Home oppure se 
	 * avviare la partita
	 */
	public void actionPerformed(ActionEvent e) {
		boolean uguale=false;
		boolean seleziona=false;
		int utenteNonInserito=0;
		int utentiUguali=0;
		if(e.getSource()==homeButton) {
			this.dispose();
			new Home();
		}
		if(e.getSource()==gameButton) { 
			username.clear();
			userColor.clear();
			for(int i=0; i<Integer.parseInt(giocatori);i++) {
				String s=new String(); //temporanea per salvare i nomi con spazi e cancellare spazi
				for(int j=0; j<nameTextArea.size(); j++) {
					s =nameTextArea.get(i).getText().replace(" ", "");
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
					this.dispose();
					new Game(username, userColor);
			}else if(utenteNonInserito==1) {
					JOptionPane.showMessageDialog(null, "Bisonga per forza inserire un nome utente!","ATTENZIONE!",JOptionPane.WARNING_MESSAGE);
			}else if(utentiUguali==1) {
					JOptionPane.showMessageDialog(null, "Gli username non possono essere uguali, rinserirli!" ,
							"ATTENZIONE", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	/**
	 * mostra avviso sul primo giocatore
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		JOptionPane.showMessageDialog(null, "Il primo giocatore creato, sara'  il primo ad iniziare","ATTENZIONE!",JOptionPane.INFORMATION_MESSAGE);		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

