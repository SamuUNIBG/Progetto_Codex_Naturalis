package Grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ScoreTrack extends JLayeredPane{
	
	HashMap<Integer, String> pawnPositionMap;
	ArrayList<JLabel> pedine;
	JLabel tracciato;
	
	public ScoreTrack(ArrayList<String> userColor) {
		
		pawnPositionMap = new HashMap<Integer, String>();
		this.createHashMap();
		
		tracciato=new JLabel();
		tracciato.setIcon(new ImageIcon("images/score/score_track.jpg"));
		tracciato.setBounds(0,0,313,608);
		
		
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
        	pedine.get(i).setBounds(64, 536, 45, 45);
        }		
		
		
		
		this.setPreferredSize(new Dimension(313, 608));	//dimensione coerente con la dimensione dell'immagine score_track.jpg
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(null);
		this.setOpaque(false);
		this.add(tracciato, Integer.valueOf(0));
		//aggiungo pedine a tracciatoPanel
		for(int i=0; i<userColor.size(); i++) {
			this.add(pedine.get(i), Integer.valueOf(1));
		}
		
	}
	
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
	
	public void movePawn(int pedina, int punteggio) {
		String[] posizione = pawnPositionMap.get(punteggio).split("-");
		System.out.println(posizione[0]);
		System.out.println(posizione[1]);
		int posX = Integer.parseInt(posizione[0]);
		int posY = Integer.parseInt(posizione[1]);
 		
		pedine.get(pedina).setLocation(posX,posY);
	}

}
