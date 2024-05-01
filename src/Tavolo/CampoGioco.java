package Tavolo;

import java.util.ArrayList;

import Carta.Carta;
import Enumerazione.Simbolo;

public class CampoGioco {

	static final int dimensioneX = 81;
	static final int dimensioneY = 81;
	
	private Carta[][] campo;
	
	ArrayList<String> posReturn;
	
	public CampoGioco(){
		
		posReturn = new ArrayList<String>();
		
		campo = new Carta[dimensioneY][dimensioneX];
		
		for(int y=0; y<dimensioneY; y++) {
			for(int x=0; x<dimensioneY; x++) {
				campo[y][x]=null;
			}
		}
		
	}
	
	public void aggiungiC(String posizione, Carta carta) {
		
		String[] splittedString = posizione.split(",");
		int posY = Integer.parseInt(splittedString[0]);
		int posX = Integer.parseInt(splittedString[1]);
		
		campo[posY][posX]=carta;
		copriAngoli(posizione);
		controllaNuovePosizioni(posizione, carta);
				
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
		posReturn.clear();
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
		
	}
	
}
