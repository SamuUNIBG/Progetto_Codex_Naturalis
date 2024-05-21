package Grafica;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;

import javax.swing.*;
/**
 * il campo di gioco comune il quale comprende i campi di gioco
 * di ogni giocatore
 */
public class PlayingField extends JLayeredPane implements MouseListener {
	
	private int z;
	private boolean mouseListenerEnable;
	
	private ArrayList<JLabel> placedCardLabel;	
	private HashMap<Integer, String> coordinate = new HashMap<Integer, String>();
	private HashMap<String, Integer> coordinate2 = new HashMap<String, Integer>();
	private ArrayList<ImageIcon> iconPlacedCard;
	private UserPlayGround userPlayGroundMother;
	
	public PlayingField(UserPlayGround userPlayGroundMother){
		
		this.setLayout(null);
		this.addMouseListener(this);
		
		z = 0;
		mouseListenerEnable = false;
		this.userPlayGroundMother = userPlayGroundMother;
		
		iconPlacedCard = new ArrayList<ImageIcon>();
		
		placedCardLabel = new ArrayList<JLabel>();
		placedCardLabel.add(new JLabel());
		coordinate.put(0, "40,40");
		coordinate2.put("40,40", 0);
		
		placedCardLabel.get(0).setBackground(new Color(170, 170, 170, 80));
		placedCardLabel.get(0).setOpaque(true);
		placedCardLabel.get(0).setBounds(4918, 2693, 163, 113);
		
		//add homePanel to window
		this.add(placedCardLabel.get(0), Integer.valueOf(0));
		
		this.setOpaque(true);
		this.setPreferredSize(new Dimension(10000, 5500));
			
		//makes frame visible
		this.setVisible(true);
		
	}
	
	/*il metodo che si occupera di aggiungere la carta nella matrice richiamera
	questo metodo passandogli un vettore
	di stringhe contenente nella prima cella le coordinate ("x,y") dell'ultima
	carta aggiunta e le coordinate delle altre celle occupabili*/
	//adds opaque JLabels, where cards can be placed, to the playing field
	public void addLabel(ArrayList<String> pos) {
		//needed to set third dimension of JLayeredPane
		z++;
		
		//get index into matrix of last card added
		String[] splittedString = pos.get(0).split(",");
		int oldY = Integer.parseInt(splittedString[0]);
		int oldX = Integer.parseInt(splittedString[1]);
		
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
				newLabel.setBackground(new Color(170, 170, 170, 80));
				newLabel.setBounds(x-120,y-64,163,113);
			}else if(newX<oldX && newY>oldY) {
				newLabel.setBackground(new Color(170, 170, 170, 80));
				newLabel.setBounds(x-120,y+64,163,113);
			}else if(newX>oldX && newY<oldY) {
				newLabel.setBackground(new Color(170, 170, 170, 80));
				newLabel.setBounds(x+120,y-64,163,113);
			}else if(newX>oldX && newY>oldY) {
				newLabel.setBackground(new Color(170, 170, 170, 80));
				newLabel.setBounds(x+120,y+64,163,113);
			}
			
			//add new JLabel to JLabel ArrayList
			placedCardLabel.add(newLabel);
			//add new JLabel to the panel
			this.add(newLabel, Integer.valueOf(z));
			//add new JLabel with matrix coordinates to HashMap
			coordinate.put(placedCardLabel.size()-1, pos.get(i));
			coordinate2.put(pos.get(i), placedCardLabel.size()-1);
		}
		
		
	}
	/**
	 * una volta che la carta e stata posizionata non verra piu
	 * mostrato il riquadro grigio in quanto non piu posizionabili
	 * altre carte
	 * @param pos
	 */
	public void removeLabel(ArrayList<String> pos) {
		
		for(int i=0; i<pos.size(); i++) {
			if(coordinate2.get(pos.get(i))!=null) {
				placedCardLabel.get(coordinate2.get(pos.get(i))).removeMouseListener(this);
				placedCardLabel.get(coordinate2.get(pos.get(i))).setOpaque(false);
			}
		}
		
	}
	/**
	 * per piazzare la carta iniziale
	 * @param la carta tramite icona
	 */
	public void posCIniz(Icon url) {
		iconPlacedCard.add((ImageIcon) url);
		placedCardLabel.get(0).setIcon(iconPlacedCard.get(iconPlacedCard.size()-1));
	}
	
	public void mouseListenerEnable(boolean enable) {
		mouseListenerEnable = enable;
	}
	
	public boolean isMouseListenerEnable() {
		return mouseListenerEnable;
	}

	@Override
	/**
	 * gestione del click del mouse 
	 * per il piazzamento della carta
	 */
	public void mouseClicked(MouseEvent e) {
		if(mouseListenerEnable) {
			for(int i=1; i<placedCardLabel.size(); i++) {
				
				if(e.getSource()==placedCardLabel.get(i)) {
					placedCardLabel.get(i).setIcon(userPlayGroundMother.getImgSelectedC());
					placedCardLabel.get(i).removeMouseListener(this);
					this.mouseListenerEnable(false);
					userPlayGroundMother.mouseListenerEnable(false);
					userPlayGroundMother.moveLabel();
					userPlayGroundMother.giocaC(userPlayGroundMother.getIdSelectedC(), coordinate.get(i));
					CarteComuniPanel.MOUSELISTENERENABLE = true;
				}
				
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
		if(!mouseListenerEnable) {
			if(e.getSource()==this) {
				Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("X.png")).getImage(), new Point(0,0), "Custum cursor");
				setCursor(cursor);
			}
		}else {
			setCursor(Cursor.getDefaultCursor()); 
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
