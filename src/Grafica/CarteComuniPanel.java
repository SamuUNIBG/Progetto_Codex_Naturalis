package Grafica;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * classe che contiene i mazzi delle carte oro e risorse
 * e mostra le carte selezionate da un giocatore
 */
public class CarteComuniPanel extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = -4362744526790874463L;
	private JPanel[] sottoPanel;
	private JLabel[] opacoLabelCComuni;
	protected static boolean MOUSELISTENERENABLE;
	private int posSelectedC;
	private Icon imgSelectedC;
	private Icon imgMazzoRis;
	private Icon imgMazzoOro;
	private Game game;
	
	public CarteComuniPanel(Game game) {
		
		MOUSELISTENERENABLE = false;
		this.game = game;
		this.addMouseListener(this);
		
		this.setPreferredSize(new Dimension(200, 200));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(new GridLayout(2,1));
		this.setOpaque(false);
		
		FlowLayout layout=new FlowLayout();
    	layout.setHgap(190);
      	layout.setVgap(16);
		
      	sottoPanel = new JPanel[2];
      	
		//sotto pannello contenente le carte
      	for(int i=0; i<sottoPanel.length; i++) {
      		sottoPanel[i] = new JPanel();
      		sottoPanel[i].setPreferredSize(new Dimension(200, 200));
      		sottoPanel[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
      		sottoPanel[i].setLayout(layout);
	      	sottoPanel[i].setOpaque(false);
      	}
      	
      	opacoLabelCComuni = new JLabel[8];
		for(int i=0; i<opacoLabelCComuni.length; i++) {
			opacoLabelCComuni[i] = new JLabel();
			opacoLabelCComuni[i].setBackground(new Color(170, 170, 170, 80));
			opacoLabelCComuni[i].setOpaque(true);
			opacoLabelCComuni[i].setPreferredSize(new Dimension(163, 113));
			opacoLabelCComuni[i].setVisible(true);
			if(i!=3 || i!=7)
				opacoLabelCComuni[i].addMouseListener(this);
		}
		
		for(int i=0; i<4; i++) {
			//sotto pannello contenente le carte
	      	sottoPanel[0].add(opacoLabelCComuni[i]);
	      	sottoPanel[1].add(opacoLabelCComuni[i+4]);
		}
		
		this.add(sottoPanel[0]);
    	this.add(sottoPanel[1]);
		
      	
	}

	public void piazzaCarta(int pos, Icon url) {
		if(pos==0) {
			imgMazzoRis = url;
			url = Game.getImage(this.calcolaNewId(Integer.parseInt(((ImageIcon)url).getDescription())));
		}else if(pos==4){
			imgMazzoOro = url;
			url = Game.getImage(this.calcolaNewId(Integer.parseInt(((ImageIcon)url).getDescription())));
		}
		
		opacoLabelCComuni[pos].setIcon(url);
		
	}
	
	public void piazzaCarta(int pos) {
		if(pos==0) {
			imgMazzoRis = null;
			
			opacoLabelCComuni[pos] = new JLabel();
			opacoLabelCComuni[pos].setBackground(new Color(170, 170, 170, 80));
			opacoLabelCComuni[pos].setOpaque(true);
			opacoLabelCComuni[pos].setPreferredSize(new Dimension(163, 113));
			opacoLabelCComuni[pos].setVisible(true);
			
			sottoPanel[0].removeAll();
			for(int i=0; i<4; i++) {
				sottoPanel[0].add(opacoLabelCComuni[i]);
				
			}			
			
		}else if(pos==4){
			imgMazzoOro = null;
			
			opacoLabelCComuni[pos] = new JLabel();
			opacoLabelCComuni[pos].setBackground(new Color(170, 170, 170, 80));
			opacoLabelCComuni[pos].setOpaque(true);
			opacoLabelCComuni[pos].setPreferredSize(new Dimension(163, 113));
			opacoLabelCComuni[pos].setVisible(true);
			
			sottoPanel[1].removeAll();
			for(int i=4; i<8; i++) {
				sottoPanel[1].add(opacoLabelCComuni[i]);
				
			}
			
		}
		
	}
	
	private int calcolaNewId(int id) {
		switch(id){
			case 0,1,2,3,4,5,6,7,8,9:
				return 102;
			case 10,11,12,13,14,15,16,17,18,19:
				return 104;
			case 20,21,22,23,24,25,26,27,28,29:
				return 106;
			case 30,31,32,33,34,35,36,37,38,39:
				return 108;
			case 40,41,42,43,44,45,46,47,48,49:
				return 103;
			case 50,51,52,53,54,55,56,57,58,59:
				return 105;
			case 60,61,62,63,64,65,66,67,68,69:
				return 107;
			case 70,71,72,73,74,75,76,77,78,79:
				return 109;
		
		}
		return 999;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(CarteComuniPanel.MOUSELISTENERENABLE) {
			for(int i=0; i<opacoLabelCComuni.length-1; i++) {
				if(e.getSource()==opacoLabelCComuni[i]) {
					CarteComuniPanel.MOUSELISTENERENABLE = false;
					posSelectedC = i;
					if(posSelectedC == 0) {
						imgSelectedC = imgMazzoRis;
					}else if(posSelectedC == 4) {
						imgSelectedC = imgMazzoOro;
					}else {
						imgSelectedC = opacoLabelCComuni[i].getIcon();
					}
					
					if(i==1 || i==2)
						opacoLabelCComuni[i].setIcon(imgMazzoRis);
					if(i==5 || i==6)
						opacoLabelCComuni[i].setIcon(imgMazzoOro);
					if(opacoLabelCComuni[i].getIcon()==null)
						opacoLabelCComuni[i].removeMouseListener(this);
					if(i==1 || i==5)
						this.moveLabel();
					game.assegnaCarta(imgSelectedC);
					game.pescaCarta(posSelectedC);
					
					Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getClassLoader().getResource("x.png")).getImage(), new Point(0,0), "Custum cursor");
					setCursor(cursor);
					
					break;
				}
			}
		}
		
	}
	/**
	 * metodo per la gestione delle carte selezionate
	 * e mette le label grige dove non sono state posizionate le carte
	 * per mostrare dove e possibile posizionare le prossime carte
	 */
	private void moveLabel() {
		if(posSelectedC!=0 && posSelectedC!=4) {
			if(posSelectedC==1) {
				JLabel temp = opacoLabelCComuni[2];
				opacoLabelCComuni[2] = opacoLabelCComuni[1];
				opacoLabelCComuni[1] = temp;
			}else if(posSelectedC==5) {
					JLabel temp = opacoLabelCComuni[6];
					opacoLabelCComuni[6] = opacoLabelCComuni[5];
					opacoLabelCComuni[5] = temp;
			}
			sottoPanel[0].removeAll();
			for(int i=0; i<4; i++) {
				sottoPanel[0].add(opacoLabelCComuni[i]);
				
			}
			sottoPanel[1].removeAll();
			for(int i=4; i<8; i++) {
				sottoPanel[1].add(opacoLabelCComuni[i]);
				
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
		if(CarteComuniPanel.MOUSELISTENERENABLE) {
			setCursor(Cursor.getDefaultCursor());
		}else {
			if(e.getSource()==this) {
				Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getClassLoader().getResource("x.png")).getImage(), new Point(0,0), "Custum cursor");
				setCursor(cursor);
			}
			for(int i=0; i<opacoLabelCComuni.length; i++) {
				if(e.getSource()==opacoLabelCComuni[i]) {
					Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getClassLoader().getResource("x.png")).getImage(), new Point(0,0), "Custum cursor");
					setCursor(cursor);
				}
			}
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setCursor(Cursor.getDefaultCursor());
		
	}
	
}
