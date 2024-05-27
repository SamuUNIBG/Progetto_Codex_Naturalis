package Grafica;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * gestione del progresso della pedina del giocatore
 * ogni qualvolta vi e una modifica di punteggio
 */
public class ScoreTrack extends JLayeredPane implements ActionListener{
	
	private static final long serialVersionUID = -6000799073604943579L;
	private HashMap<Integer, String> pawnPositionMap;
	private ArrayList<JLabel> pedine;
	private JLabel tracciato;
	private JButton rules, comandi, home;
	private Game game;
	
	public ScoreTrack(ArrayList<String> userColor, Game game) {
		
		pawnPositionMap = new HashMap<Integer, String>();
		this.createHashMap();
		
		this.game = game;
		
		JLabel sfondo = new JLabel();
		sfondo.setBounds(0,0,313,715);
		sfondo.setBackground(new Color(0xf0eccd));
		sfondo.setOpaque(true);
		
		tracciato=new JLabel();
		tracciato.setIcon(new ImageIcon("images/score/score_track.jpg"));
		tracciato.setBounds(0,50,313,608);
		
		
		//label pedine giocatori
		pedine = new ArrayList<JLabel>();
        for(int i=0; i<userColor.size(); i++) {
        	pedine.add(new JLabel());
        	switch(userColor.get(i)) {
	        	case "Azzurro":
	        		pedine.get(i).setIcon(new ImageIcon("images/score/blue_pawn.png"));
	        		break;
	        	case "Giallo":
	        		pedine.get(i).setIcon(new ImageIcon("images/score/yellow_pawn.png"));
	        		break;
	        	case "Rosso":
	        		pedine.get(i).setIcon(new ImageIcon("images/score/red_pawn.png"));
	        		break;
	        	case "Verde":
	        		pedine.get(i).setIcon(new ImageIcon("images/score/green_pawn.png"));
	        		break;
        	}
        	pedine.get(i).setBounds(0, 0, 45, 45);
        	this.movePawn(i, 0);
        }
        
        //panel with button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setVisible(true);
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBounds(0, 608+50, 313,50);
        
        //buttons to add to the window
        rules = new JButton("Rules");
        comandi = new JButton("Comandi");
        home = new JButton("Home");
        //focus state shouldn't be painted
        rules.setFocusPainted(false);
        comandi.setFocusPainted(false);
        home.setFocusPainted(false);
      	//add ActionListener to buttons
        rules.addActionListener(this);
      	comandi.addActionListener(this);
      	home.addActionListener(this);
      	//set button font
      	rules.setFont(new Font("Serif",Font.BOLD | Font.ITALIC,15));
      	comandi.setFont(new Font("Serif",Font.BOLD | Font.ITALIC,15));
      	home.setFont(new Font("Serif",Font.BOLD | Font.ITALIC,15));
      	//modify button cursor
      	rules.setCursor(new Cursor(Cursor.HAND_CURSOR));
      	comandi.setCursor(new Cursor(Cursor.HAND_CURSOR));
      	home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        buttonPanel.add(rules);
        buttonPanel.add(comandi);
        buttonPanel.add(home);
		
		this.setPreferredSize(new Dimension(313, 608));	//dimensione coerente con la dimensione dell'immagine score_track.jpg
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(null);
		this.setOpaque(false);
		this.add(sfondo, Integer.valueOf(0));
		this.add(tracciato, Integer.valueOf(1));
		//aggiungo pedine a tracciatoPanel
		for(int i=0; i<userColor.size(); i++) {
			this.add(pedine.get(i), Integer.valueOf(2));
		}
		this.add(buttonPanel, Integer.valueOf(1));
		
	}
	/**
	 * fa in modo che le pedine dei giocatori vengono 
	 * messe sul tracciato
	 */
	private void createHashMap() {
		
		//add all pawn position to HashMap
		try {
			Scanner sc = new Scanner(new FileInputStream(new File("file/pawn_position.csv")));
	        
	        while (sc.hasNextLine()) {
	            String frase = sc.nextLine();
	            
	            String[] splittedString = frase.split(",");
	    		int id = Integer.parseInt(splittedString[0]);
	    		String position = (splittedString[1]);
	    		
	    		pawnPositionMap.put(id, position);
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
				
	}
	/**
	 * sposta la pedina sulla casella del tracciato
	 * relativa al punteggio in tempo reale del giocatore
	 * @param pedina
	 * @param punteggio attuale
	 */
	public void movePawn(int pedina, int punteggio) {
		if(punteggio > 29)
			punteggio = 29;
		String[] posizione = pawnPositionMap.get(punteggio).split("-");
		int posX = Integer.parseInt(posizione[0]);
		int posY = Integer.parseInt(posizione[1]);
	 	
		pedine.get(pedina).setLocation(posX,posY);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rules) {
			new Rules(false);		
		}else if(e.getSource()==comandi) {
			JOptionPane.showMessageDialog(null, "sposta il cursore del mouse sulla carta "
					+ "x vederne il retro; \ntasto sinistro x giocarla di fronte; \n"
					+ "tasto destro x giocarla di retro",
					"INFO UTILI X GIOCARE LE CARTE",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource()==home) {
			game.chiudi();
		}
		
	}

}
