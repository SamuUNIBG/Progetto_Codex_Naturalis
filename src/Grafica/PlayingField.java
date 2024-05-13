package Grafica;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;

import javax.swing.*;

public class PlayingField extends JLayeredPane implements MouseListener {
	int z=0;
	
	ArrayList<JLabel> placedCardLabel;	
	HashMap<Integer, String> coordinate = new HashMap<Integer, String>();
	HashMap<String, Integer> coordinate2 = new HashMap<String, Integer>();
	ArrayList<ImageIcon> iconPlacedCard;
	
	public PlayingField(){
		
		this.setLayout(null);
		
		iconPlacedCard = new ArrayList<ImageIcon>();
		
		placedCardLabel = new ArrayList<JLabel>();
		placedCardLabel.add(new JLabel());
		coordinate.put(0, "40,40");
		coordinate2.put("40,40", 0);
		
		placedCardLabel.get(0).setBackground(new Color(170, 170, 170, 80));
		placedCardLabel.get(0).setOpaque(true);
		placedCardLabel.get(0).setBounds(4918, 2693, 163, 113);
		placedCardLabel.get(0).addMouseListener(this);
		
		//add homePanel to window
		this.add(placedCardLabel.get(0), Integer.valueOf(0));
		
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(10000, 5500));
			
		//makes frame visible
		this.setVisible(true);
		
	}
	
	//il metodo che si occuperà di aggiungere la carta nella matrice richiamerà questo metodo passandogli un vettore
	//di stringhe contenente nella prima cella le coordinate ("x,y") dell'ultima carta aggiunta e le coordinate delle altre celle occupabili
	//adds opaque JLabels, where cards can be placed, to the playing field
	public void addLabel(ArrayList<String> pos) {
		//needed to set third dimension of JLayeredPane
		z++;
		
		//get index into matrix of last card added
		String[] splittedString = pos.get(0).split(",");
		int oldX = Integer.parseInt(splittedString[0]);
		int oldY = Integer.parseInt(splittedString[1]);
		
		//get index into ArrayList of last card added 
		int indexLastCard = coordinate2.get(pos.get(0));
		//get graphic coordinates of the last card added
		int x = (int)placedCardLabel.get(indexLastCard).getLocation().getX();
		int y = (int)placedCardLabel.get(indexLastCard).getLocation().getY();
		
		for(int i=1; i<pos.size(); i++) {
			JLabel newLabel = new JLabel();
			newLabel.setBackground(new Color(170, 170, 170, 80));
			newLabel.setOpaque(true);
			newLabel.addMouseListener(this);
			
			//get index into matrix of the new location where you can place cards
			splittedString = pos.get(i).split(",");
			int newY = Integer.parseInt(splittedString[0]);
			int newX = Integer.parseInt(splittedString[1]);
			
			//set location and size of new JLabel
			if(newX<oldX && newY<oldY) {
				newLabel.setBackground(Color.RED);
				//newLabel.setIcon(icon);
				newLabel.setBounds(x-120,y-64,163,113);
			}else if(newX<oldX && newY>oldY) {
				newLabel.setBackground(Color.GREEN);
				//newLabel.setIcon(icon);
				newLabel.setBounds(x-120,y+64,163,113);
			}else if(newX>oldX && newY<oldY) {
				newLabel.setBackground(Color.BLUE);
				//newLabel.setIcon(icon);
				newLabel.setBounds(x+120,y-64,163,113);
			}else if(newX>oldX && newY>oldY) {
				newLabel.setBackground(Color.YELLOW);
				//newLabel.setIcon(icon);
				newLabel.setBounds(x+120,y+64,163,113);
			}
			
			//add new JLabel to JLabel ArrayList
			placedCardLabel.add(newLabel);
			//add new JLabel to the panel
			this.add(newLabel, Integer.valueOf(z));
			//add new JLabel with matrix coordinates to HashMap
			coordinate.put(placedCardLabel.size()-1, pos.get(i));
			coordinate2.put(pos.get(i), placedCardLabel.size()-1);
			System.out.println(coordinate);
			System.out.println(coordinate2);
		}
		
		
	}
	
	public void posCIniz(String url) {
		iconPlacedCard.add(new ImageIcon(url));
		placedCardLabel.get(0).setIcon(iconPlacedCard.get(iconPlacedCard.size()-1));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i=0; i<placedCardLabel.size(); i++) {
			
			if(e.getSource()==placedCardLabel.get(i)) {
				placedCardLabel.get(i).setIcon(new ImageIcon());
				placedCardLabel.get(i).removeMouseListener(this);
				
			}
			
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
		// TODO Auto-generated method stub
		
	}
	
}
