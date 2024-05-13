package Grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UserPlayGround extends JPanel{
	
	JLabel[] opacoLabelCPersonali;
	PlayingField playingField;

	public UserPlayGround() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		this.add(new JPanel());
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		this.setMinimumSize(new Dimension(screenSize.width-330, screenSize.height-345));
				
		//creo scrollPlayingField e playingField in base al numero di giocatori
				
		playingField = new PlayingField();
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
	
	public void pescaCartaP(int pos, String carta) {
		opacoLabelCPersonali[pos].setIcon(new ImageIcon(carta));
	}
	
	public void piazzaCartaIniz(String carta) {
		playingField.posCIniz(carta);
	}
	
}
