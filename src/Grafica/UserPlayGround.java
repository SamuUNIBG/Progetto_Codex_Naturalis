package Grafica;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Carta.CGiocabiliSpeciali;

public class UserPlayGround extends JPanel implements MouseListener {
	
	private JLabel[] opacoLabelCPersonali;
	private PlayingField playingField;
	private int posSelectedC;
	private Icon imgSelectedC, imgEnteredC;
	private boolean mouseListenerEnable;
	private Game game;
	private boolean retro;
	private int id;
	public static int lastId=0;

	public UserPlayGround(Game game) {
		
		this.game=game;
		id = UserPlayGround.lastId;
		UserPlayGround.lastId++;
		
		mouseListenerEnable = true;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		this.setMinimumSize(new Dimension(screenSize.width-330, screenSize.height-345));
				
		//creo scrollPlayingField e playingField in base al numero di giocatori
				
		playingField = new PlayingField(this);
		playingField.setVisible(true);
		
		JScrollPane	scrollPlayingField = new JScrollPane(playingField);
		scrollPlayingField.getViewport().setMinimumSize(new Dimension(screenSize.width-330, screenSize.height-545));
		scrollPlayingField.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollPlayingField.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPlayingField.getHorizontalScrollBar().setMinimum(0);
		scrollPlayingField.getHorizontalScrollBar().setMaximum(10000);
		scrollPlayingField.getHorizontalScrollBar().setValue(((10000-163)/2-(screenSize.width-330-163)/2));
		scrollPlayingField.getVerticalScrollBar().setMinimum(0);
		scrollPlayingField.getVerticalScrollBar().setMaximum(5500);
		scrollPlayingField.getVerticalScrollBar().setValue((5500-113)/2-(screenSize.height-545-113)/2);
		
		
		FlowLayout CPlayout=new FlowLayout();
		CPlayout.setHgap(190);
		CPlayout.setVgap(16);
			    
		//Pannelli carte personali
		JPanel cartePersonaliPanel = new JPanel();
		cartePersonaliPanel.setMinimumSize(new Dimension(screenSize.width-313,145));
		cartePersonaliPanel.setLayout(CPlayout);
		cartePersonaliPanel.setOpaque(true);
		      	
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
	
	public void pescaCartaP(int pos, Icon url) {
		opacoLabelCPersonali[pos].setIcon(url);
		//opacoLabelCPersonali[this.posSelectedC].setDisabledIcon(imgEnteredC);
	}
	
	public void pescaCartaP(String url) {
		opacoLabelCPersonali[this.posSelectedC].setIcon(new ImageIcon(url));
		//opacoLabelCPersonali[this.posSelectedC].setDisabledIcon(imgEnteredC);
	}
	
	public void piazzaCartaIniz(Icon url) {
		playingField.posCIniz(url);
	}
	
	public void giocaC(int numCarta, String posCarta) {
		game.giocaC(id, numCarta, retro, posCarta);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(mouseListenerEnable) {
			for(int i=0; i<opacoLabelCPersonali.length-1; i++) {
				if(e.getSource()==opacoLabelCPersonali[i]) {
					posSelectedC = i;
					playingField.mouseListenerEnable((true));
					if(e.getButton() == MouseEvent.BUTTON1) {
						imgSelectedC = imgEnteredC;
						retro = false;
					}else if(e.getButton() == MouseEvent.BUTTON3) {
						imgSelectedC = opacoLabelCPersonali[i].getIcon();
						retro = true;
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
		for(int i=0; i<opacoLabelCPersonali.length-1; i++) {
			if(e.getSource()==opacoLabelCPersonali[i]) {
				imgEnteredC = opacoLabelCPersonali[i].getIcon();
				opacoLabelCPersonali[i].setIcon(Game.getImage(calcolaNewId(Integer.parseInt(((ImageIcon)imgEnteredC).getDescription()))));
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
		return 0;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		for(int i=0; i<opacoLabelCPersonali.length-1; i++) {
			if(e.getSource()==opacoLabelCPersonali[i]) {
				opacoLabelCPersonali[i].setIcon(imgEnteredC);
			}
		}
		
	}
	
	public PlayingField getPlayingField() {
		return playingField;
	}
	
	public Icon getImgSelectedC() {
		return imgSelectedC;
	}
	
	public void mouseListenerEnable(boolean enable) {
		mouseListenerEnable = enable;
	}
	
}
