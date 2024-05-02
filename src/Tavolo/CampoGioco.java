package Tavolo;

import java.util.ArrayList;

import Carta.Carta;
import Enumerazione.Simbolo;
import Carta.CRis;

public class CampoGioco {

	static final int dimensioneX = 81;
	static final int dimensioneY = 81;
	
	private Carta[][] campo;
	private int[][] campoPrint;	
	
	private ArrayList<String> posReturn;
	private ArrayList<String> posizioniDisponibili;
	
	public CampoGioco(){
		
		posReturn = new ArrayList<String>();
		posizioniDisponibili = new ArrayList<String>();
		
		campo = new Carta[dimensioneY][dimensioneX];
		
		for(int y=0; y<dimensioneY; y++) {
			for(int x=0; x<dimensioneX; x++) {
				campo[y][x]=null;
				campoPrint[y][x]=999;
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
			posizioniDisponibili.add((posY-1) + "," + (posX-1));
		}
		if(campo[posY+1][posX-1]==null && carta.getAngoli()[3].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY+1) + "," + (posX-1));
			posizioniDisponibili.add((posY-1) + "," + (posX-1));
		}
		if(campo[posY-1][posX+1]==null && carta.getAngoli()[1].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY-1) + "," + (posX+1));
			posizioniDisponibili.add((posY-1) + "," + (posX+1));
		}
		if(campo[posY+1][posX+1]==null && carta.getAngoli()[2].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY+1) + "," + (posX+1));
			posizioniDisponibili.add((posY+1) + "," + (posX+1));
		}
		
	}
	
	public ArrayList<String> getPosizioniDisponibili() {
		return posizioniDisponibili;
	}

	public void print(String posizione, Carta carta) {
		String[] splittedString = posizione.split(",");
		int posY = Integer.parseInt(splittedString[0]);
		int posX = Integer.parseInt(splittedString[1]);
		
		campoPrint[posY][posX]=carta.getIDCARTA();
		
	}
	
	public void print() {
		for(int y=0; y<dimensioneY; y++) {
			for(int x=0; x<dimensioneX; x++) {
					System.out.print(" " + campoPrint[y][x]);
				if(x<dimensioneX-1) {
					System.out.print(" |");
				}
			}
			if(y<dimensioneY-1) {
				for(int x=0; x<dimensioneX; x++) {
					System.out.println("----");
					if(x<dimensioneX-1) {
						System.out.print("--");
					}
				}
			}
		}
	}
	
}
