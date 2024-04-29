package Tavolo;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import Carta.CRis;
import Carta.COro;
import Carta.Carta;
import Enumerazione.Simbolo;
import Grafica.PlayingField;

public class CampoGioco {

	static final int dimensioneX = 81;
	static final int dimensioneY = 81;
	
	private Carta[][] campo;
	private JScrollPane scrollPlayingField;
	
	private PlayingField playingField;
	
	public CampoGioco(){
		
		campo = new Carta[dimensioneY][dimensioneX];
		
		for(int y=0; y<dimensioneY; y++) {
			for(int x=0; x<dimensioneY; x++) {
				campo[y][x]=null;
			}
		}
		
		playingField = new PlayingField();
		JScrollPane scrollPlayingField = new JScrollPane(playingField);
		scrollPlayingField.getViewport().setPreferredSize(new Dimension(1600, 700));
		playingField.setVisible(true);
		scrollPlayingField.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollPlayingField.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//this.getContentPane().add(scrollPlayingField);
		//this.setVisible(true);
		
		scrollPlayingField.getHorizontalScrollBar().setValue(((12500-204)/2)-(700));
		scrollPlayingField.getVerticalScrollBar().setValue((5000-142)/2-(250));
	}
	
	public void aggiungiC(String posizione, Carta carta) {
		
		String[] splittedString = posizione.split(",");
		int posY = Integer.parseInt(splittedString[0]);
		int posX = Integer.parseInt(splittedString[1]);
		
		if(carta instanceof CRis || carta instanceof COro) {
			campo[posY][posX]=carta;
			
			copriAngoli(posizione);
			controllaNuovePosizioni(posizione, carta);
		}else {
			
			JOptionPane.showMessageDialog(null, "Errore nella selezione della carta", "ERRORE", JOptionPane.ERROR_MESSAGE);
			
		}
				
	}
	
	public void copriAngoli(String posizione) {
		
		String[] splittedString = posizione.split(",");
		int posY = Integer.parseInt(splittedString[0]);
		int posX = Integer.parseInt(splittedString[1]);
		
		if(campo[posY-1][posX-1]!=null) {
			campo[posY-1][posX-1].getAngoli()[2].setCoperto();
		}
		if(campo[posY+1][posX-1]!=null) {
			campo[posY+1][posX-1].getAngoli()[1].setCoperto();
		}
		if(campo[posY-1][posX+1]!=null) {
			campo[posY-1][posX+1].getAngoli()[3].setCoperto();
		}
		if(campo[posY+1][posX+1]!=null) {
			campo[posY+1][posX+1].getAngoli()[0].setCoperto();
		}
		
	}
	
	private void controllaNuovePosizioni(String posizione, Carta carta) {
		
		ArrayList<String> posReturn = new ArrayList<String>();
		posReturn.add(posizione);
		
		String[] splittedString = posizione.split(",");
		int posY = Integer.parseInt(splittedString[0]);
		int posX = Integer.parseInt(splittedString[1]);
		
		if(campo[posY-1][posX-1]==null && carta.getAngoli()[0].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY-1) + "," + (posX-1));
		}
		if(campo[posY+1][posX-1]==null && carta.getAngoli()[3].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY+1) + "," + (posX-1));
		}
		if(campo[posY-1][posX+1]==null && carta.getAngoli()[1].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY-1) + "," + (posX+1));
		}
		if(campo[posY+1][posX+1]==null && carta.getAngoli()[2].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY+1) + "," + (posX+1));
		}
		
		playingField.addLabel(posReturn);
		
	}
	
}
