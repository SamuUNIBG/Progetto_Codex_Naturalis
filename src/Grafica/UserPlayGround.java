package Grafica;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/**
 * campo di gioco di ogni giocatore
 */
public class UserPlayGround extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = -1497922931213082742L;
	private JLabel[] opacoLabelCPersonali;
	private PlayingField playingField;
	private int posSelectedC;
	private Icon imgSelectedC, imgEnteredC;
	private boolean mouseListenerEnable;
	private Game game;
	private boolean fronte;
	private JPanel cartePersonaliPanel;
	private int idSelectedC;
	private Icon[] imgFronte;
	private JScrollPane scrollPlayingField;
	
	public UserPlayGround(Game game) {
		
		this.game=game;
		imgFronte = new Icon[4];
		
		this.mouseListenerEnable = false;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		this.setMinimumSize(new Dimension(screenSize.width-330, screenSize.height-345));
				
		//creo scrollPlayingField e playingField in base al numero di giocatori
				
		playingField = new PlayingField(this);
		playingField.setVisible(true);
		
		scrollPlayingField = new JScrollPane(playingField);
		scrollPlayingField.getViewport().setMinimumSize(new Dimension(screenSize.width-330, screenSize.height-545));
		scrollPlayingField.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollPlayingField.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPlayingField.getHorizontalScrollBar().setMinimum(0);
		scrollPlayingField.getHorizontalScrollBar().setMaximum(10000);
		scrollPlayingField.getHorizontalScrollBar().setValue(((10000-163)/2-(screenSize.width-330-163)/2));
		scrollPlayingField.getVerticalScrollBar().setMinimum(0);
		scrollPlayingField.getVerticalScrollBar().setMaximum(5500);
		scrollPlayingField.getVerticalScrollBar().setValue((5500-113)/2-(screenSize.height-545-113)/2);
		scrollPlayingField.addMouseListener(this);
		
		
		FlowLayout CPlayout=new FlowLayout();
		CPlayout.setHgap(150);
		CPlayout.setVgap(16);
		
		//Pannelli carte personali
		cartePersonaliPanel = new JPanel();
		cartePersonaliPanel.setMinimumSize(new Dimension(screenSize.width-313,145));
		cartePersonaliPanel.setLayout(CPlayout);
		cartePersonaliPanel.setOpaque(true);
		cartePersonaliPanel.addMouseListener(this);
		      	
		opacoLabelCPersonali = new JLabel[4];
		for(int i=0; i<opacoLabelCPersonali.length; i++) {
			opacoLabelCPersonali[i] = new JLabel();
			opacoLabelCPersonali[i].setBackground(new Color(170, 170, 170, 80));
			opacoLabelCPersonali[i].setOpaque(true);
			opacoLabelCPersonali[i].setPreferredSize(new Dimension(163, 113));
			opacoLabelCPersonali[i].setVisible(true);
			if(i<opacoLabelCPersonali.length-1)
				opacoLabelCPersonali[i].addMouseListener(this);
		}
			    
		for(int i=0; i<4; i++) {
			cartePersonaliPanel.add(opacoLabelCPersonali[i]);			
		}		
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		this.add(scrollPlayingField,gbc);
		gbc.gridx=0;
		gbc.gridy=1;
		this.add(cartePersonaliPanel,gbc);	
	}
	
	/**
	 * gestione delle Label che conterranno le carte che 
	 * vengono giocate e quindi piazzate
	 */
	public void moveLabel() {
		opacoLabelCPersonali[posSelectedC] = new JLabel();
		opacoLabelCPersonali[posSelectedC].setBackground(new Color(170, 170, 170, 80));
		opacoLabelCPersonali[posSelectedC].setOpaque(true);
		opacoLabelCPersonali[posSelectedC].setPreferredSize(new Dimension(163, 113));
		opacoLabelCPersonali[posSelectedC].setVisible(true);
		opacoLabelCPersonali[posSelectedC].addMouseListener(this);
		for(int i=posSelectedC; i<2; i++) {
			Icon tempI = imgFronte[i+1];
			imgFronte[i+1] = imgFronte[i];
			imgFronte[i] = tempI;
			JLabel tempL = opacoLabelCPersonali[i+1];
			opacoLabelCPersonali[i+1] = opacoLabelCPersonali[i];
			opacoLabelCPersonali[i] = tempL; 
		}
		cartePersonaliPanel.removeAll();
		for(int i=0; i<4; i++) {
			cartePersonaliPanel.add(opacoLabelCPersonali[i]);
		}
	}
	
	/**
	 * gestione del pescaggio della PRIMA carta
	 * @param pos
	 * @param icona della carta
	 */
	public void pescaCartaP(int pos, Icon url) {
		opacoLabelCPersonali[pos].setIcon(url);
		imgFronte[pos] = url;
	}
	
	/**
	 * gestione del pescaggio delle carte
	 * @param icona della carta
	 */
	public void pescaCartaP(Icon url) {
		opacoLabelCPersonali[2].setIcon(url);
		imgFronte[2] = url;
	}
	
	/**
	 * gestione del piazzamento della carta iniziale
	 * @param icona della carta
	 */
	public void piazzaCartaIniz(Icon url) {
		playingField.posCIniz(url);
	}
	
	/**
	 * gestione della giocata della carta 
	 * @param idCarta
	 * @param posizione della Carta
	 */
	public void giocaC(int idCarta, String posCarta) {
		game.giocaC(idCarta, fronte, posCarta);
	}
	
	public boolean carteDisponibili() {
		return game.carteDisponibili();
	}
	
	public void pescaCarta(int posSelectedC) {
		game.pescaCarta(posSelectedC);
	}
	
	public void mouseReset() {
		setCursor(Cursor.getDefaultCursor());
	}
	
	@Override
	/**
	 * quando viene cliccato il mouse per il posizionamento della carta, 
	 * viene controllato che tipo di carta e, ed in caso fosse
	 * una carta oro, viene richiamato il metodo che verifica se 
	 * si puo giocare o meno
	 */
	public void mouseClicked(MouseEvent e) {
		if(mouseListenerEnable) {
			for(int i=0; i<opacoLabelCPersonali.length-1; i++) {
				if(e.getSource()==opacoLabelCPersonali[i]) {
					posSelectedC = i;
					idSelectedC = Integer.parseInt(((ImageIcon)imgEnteredC).getDescription());
					playingField.mouseListenerEnable(true);
					if(e.getButton() == MouseEvent.BUTTON1) {
						if(Integer.parseInt(((ImageIcon)imgEnteredC).getDescription())>39 && Integer.parseInt(((ImageIcon)imgEnteredC).getDescription())<80) {
							if(game.COroGiocabile(Integer.parseInt(((ImageIcon)imgEnteredC).getDescription()))) {
								imgSelectedC = imgEnteredC;
								fronte = true;
								Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("spunta.png")).getImage(), new Point(0,0), "Custum cursor");
								setCursor(cursor);
								try {
									Thread.sleep(450);
									mouseReset();
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}else {
								playingField.mouseListenerEnable(false);
								Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("x.png")).getImage(), new Point(0,0), "Custum cursor");
								setCursor(cursor);
								try {
									Thread.sleep(450);
									mouseReset();
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}else {
							imgSelectedC = imgEnteredC;
							fronte = true;
							Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("spunta.png")).getImage(), new Point(0,0), "Custum cursor");
							setCursor(cursor);
							try {
								Thread.sleep(450);
								mouseReset();
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
						}
					}else if(e.getButton() == MouseEvent.BUTTON3) {
						Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("spunta.png")).getImage(), new Point(0,0), "Custum cursor");
						setCursor(cursor);
						try {
							Thread.sleep(450);
							mouseReset();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						imgSelectedC = Game.getImage(calcolaNewId(Integer.parseInt(((ImageIcon)imgEnteredC).getDescription())));//opacoLabelCPersonali[i].getIcon();
						fronte = false;
					}
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
		if(mouseListenerEnable) {
			for(int i=0; i<opacoLabelCPersonali.length-1; i++) {
				if(e.getSource()==opacoLabelCPersonali[i]) {
					imgEnteredC = opacoLabelCPersonali[i].getIcon();
					opacoLabelCPersonali[i].setIcon(Game.getImage(calcolaNewId(Integer.parseInt(((ImageIcon)imgEnteredC).getDescription()))));
				}
			}
			if(e.getSource()==opacoLabelCPersonali[3]) {
				Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("X.png")).getImage(), new Point(0,0), "Custum cursor");
				setCursor(cursor);
			}
		}else {
			if(e.getSource()==cartePersonaliPanel || (e.getSource()==scrollPlayingField && !(playingField.isMouseListenerEnable()))) {
				Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("X.png")).getImage(), new Point(0,0), "Custum cursor");
				setCursor(cursor);
			}
			for(int i=0; i<opacoLabelCPersonali.length; i++) {
				if(e.getSource()==opacoLabelCPersonali[i]) {
					Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(getClass().getResource("X.png")).getImage(), new Point(0,0), "Custum cursor");
					setCursor(cursor);
				}
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
			case 86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101:
				return 116;
		
		}
		return 999;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(mouseListenerEnable) {
			
			for(int i=0; i<opacoLabelCPersonali.length-1; i++) {
				
				if(e.getSource()==opacoLabelCPersonali[i]) {
					opacoLabelCPersonali[i].setIcon(imgEnteredC);
				}
			}
			if(e.getSource()==opacoLabelCPersonali[3]) {
				setCursor(Cursor.getDefaultCursor());
			}
			
		}else
			setCursor(Cursor.getDefaultCursor());
		
	}
	
	public PlayingField getPlayingField() {
		return playingField;
	}
	
	public int getIdSelectedC() {
		return idSelectedC;
	}
	
	public Icon getImgSelectedC() {
		return imgSelectedC;
	}
	
	public void mouseListenerEnable(boolean enable) {
		mouseListenerEnable = enable;
	}

	public void carteVisibili(boolean fronteVisibile) {
		if(fronteVisibile) {
			this.mouseListenerEnable = true;
			for(int i=0; i<4; i++)
				if(this.imgFronte[i]!=null)
					opacoLabelCPersonali[i].setIcon(imgFronte[i]);
		}else{
			this.mouseListenerEnable = false;
			for(int i=0; i<4; i++)
				if(this.imgFronte[i]!=null)
					opacoLabelCPersonali[i].setIcon(Game.getImage(calcolaNewId(Integer.parseInt(((ImageIcon)imgFronte[i]).getDescription()))));
		}
		
	}
	
}
