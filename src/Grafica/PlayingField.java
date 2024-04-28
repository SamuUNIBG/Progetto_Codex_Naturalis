package Grafica;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class PlayingField extends JLayeredPane {
	int z=0;
	
	ArrayList<JLabel> placedCardLabel;	
	HashMap<Integer, String> coordinate = new HashMap<Integer, String>();
	HashMap<String, Integer> coordinate2 = new HashMap<String, Integer>();
	ImageIcon icon = new ImageIcon("blue_gold_card_front_1.jpg");
	
	public PlayingField(){
		
		this.setLayout(null);
		
		placedCardLabel = new ArrayList<JLabel>();
		placedCardLabel.add(new JLabel());
		coordinate.put(0, "41,41");
		coordinate2.put("41,41", 0);
		
		placedCardLabel.get(0).setBackground(new Color(170, 170, 170, 80));
		placedCardLabel.get(0).setIcon(icon);
		placedCardLabel.get(0).setOpaque(true);
		placedCardLabel.get(0).setBounds(200, 200, 204, 142);
		this.setAutoscrolls(true);
		
		ImageIcon icon = new ImageIcon("blue_gold_card_front_1.jpg");
		
		System.out.println(icon.getIconWidth() + " " + icon.getIconHeight());
		//add homePanel to window
		this.add(placedCardLabel.get(0), Integer.valueOf(0));
		
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(12500, 5000));
			
		//makes frame visible
		this.setVisible(true);
		
	}
	
	//il metodo che si occuperà di aggiungere la carta nella matrice richiamerà questo metodo passandogli un vettore
	//di stringhe contenente nella prima cella le coordinate ("x,y") dell'ultima carta aggiunta e le coordinate delle altre celle occupabili
	//il metodo poi si occuperà di visualizzare a schermo i nuovi jlabel opachi dove potranno essere piazzate le carte
	public void addLabel(String[] pos) {
		//needed to set third dimension of JLayeredPane
		z++;
		
		//get index into matrix of last card added
		String[] splittedString = pos[0].split(",");
		int oldX = Integer.parseInt(splittedString[0]);
		int oldY = Integer.parseInt(splittedString[1]);
		
		//get index into ArrayList of last card added 
		int indexLastCard = coordinate2.get(pos[0]);
		//get graphic coordinates of the last card added
		int x = (int)placedCardLabel.get(indexLastCard).getLocation().getX();
		int y = (int)placedCardLabel.get(indexLastCard).getLocation().getY();
		
		for(int i=1; i<pos.length; i++) {
			JLabel newLabel = new JLabel();
			newLabel.setBackground(new Color(170, 170, 170, 80));
			newLabel.setOpaque(true);
			
			//get index into matrix of the new location where you can place cards
			splittedString = pos[i].split(",");
			int newX = Integer.parseInt(splittedString[0]);
			int newY = Integer.parseInt(splittedString[1]);
			
			//set location and size of new JLabel
			if(newX<oldX && newY<oldY) {
				newLabel.setBackground(Color.RED);
				newLabel.setIcon(icon);
				newLabel.setBounds(x-150,y-80,204,142);
			}else if(newX<oldX && newY>oldY) {
				newLabel.setBackground(Color.GREEN);
				newLabel.setIcon(icon);
				newLabel.setBounds(x-150,y+80,204,142);
			}else if(newX>oldX && newY<oldY) {
				newLabel.setBackground(Color.BLUE);
				newLabel.setIcon(icon);
				newLabel.setBounds(x+150,y-80,204,142);
			}else if(newX>oldX && newY>oldY) {
				newLabel.setBackground(Color.YELLOW);
				newLabel.setIcon(icon);
				newLabel.setBounds(x+150,y+80,204,142);
			}
			
			//add new JLabel to JLabel ArrayList
			placedCardLabel.add(newLabel);
			//add new JLabel to the panel
			this.add(newLabel, Integer.valueOf(z));
			//add new JLabel with matrix coordinates to HashMap
			coordinate.put(placedCardLabel.size()-1, pos[i]);
			coordinate2.put(pos[i], placedCardLabel.size()-1);
			System.out.println(coordinate);
			System.out.println(coordinate2);
		}
		
		
	}
	
}
