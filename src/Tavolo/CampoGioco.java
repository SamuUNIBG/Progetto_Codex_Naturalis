package Tavolo;

import java.util.ArrayList;

import Carta.Carta;
import Enumerazione.Simbolo;
import Carta.CGiocabili;

public class CampoGioco {

	public static final int dimensioneX = 81;
	public static final int dimensioneY = 81;
	
	private CGiocabili[][] campo;
	private int[][] campoPrint;	
	
	private ArrayList<String> posReturn;
	private ArrayList<String> posizioniDisponibili;
	
	public CampoGioco(){
		
		posReturn = new ArrayList<String>();
		posizioniDisponibili = new ArrayList<String>();
		
		campo = new CGiocabili[dimensioneY][dimensioneX];
		campoPrint = new int[dimensioneY][dimensioneX];
		
		for(int y=0; y<dimensioneY; y++) {
			for(int x=0; x<dimensioneX; x++) {
				campo[y][x]=null;
				campoPrint[y][x]=999;
			}
		}
		
	}
	/**
	 * metodo che posiziona la carta scelta sul campo di gioco
	 * in base alle coordinate scelte e verificando che sia effettivamente
	 * una posizione disponibile
	 * @param le coordinate delle carta 
	 * @param la carta da posizionare 
	 */
	public void aggiungiC(String posizione, CGiocabili carta) {
		
		String[] splittedString = posizione.split(",");
		int posY = Integer.parseInt(splittedString[0]);
		int posX = Integer.parseInt(splittedString[1]);
		
		campo[posY][posX]=carta;
		controllaNuovePosizioni(posizione, carta);
				
	}
	
	public Simbolo[] copriAngoli(String posizione) {
		
		Simbolo[] simboli = new Simbolo[4];
		
		for(int i=0; i<simboli.length; i++) {
			simboli[i]=null;
		}
		
		String[] splittedString = posizione.split(",");
		int posY = Integer.parseInt(splittedString[0]);
		int posX = Integer.parseInt(splittedString[1]);
		
		if(campo[posY-1][posX-1]!=null) {
			((CGiocabili)campo[posY-1][posX-1]).getAngoli()[2].setCoperto();
			simboli[0]=((CGiocabili)campo[posY-1][posX-1]).getAngoli()[2].getSimbolo();
		}
		if(campo[posY+1][posX-1]!=null) {
			((CGiocabili)campo[posY+1][posX-1]).getAngoli()[1].setCoperto();
			simboli[1]=((CGiocabili)campo[posY+1][posX-1]).getAngoli()[1].getSimbolo();
		}
		if(campo[posY-1][posX+1]!=null) {
			((CGiocabili)campo[posY-1][posX+1]).getAngoli()[3].setCoperto();
			simboli[2]=((CGiocabili)campo[posY-1][posX+1]).getAngoli()[3].getSimbolo();
		}
		if(campo[posY+1][posX+1]!=null) {
			((CGiocabili)campo[posY+1][posX+1]).getAngoli()[0].setCoperto();
			simboli[3]=((CGiocabili)campo[posY+1][posX+1]).getAngoli()[0].getSimbolo();
		}
		
		return simboli;
		
	}
	/**
	 * per mostrare le posizioni possibile nelle quali poter
	 * posizionare la carta e mostrarle al giocatore
	 * @param posizione che contiene le coordinate x e y
	 * @param carta gia posizionata
	 */
	private void controllaNuovePosizioni(String posizione, Carta carta) {
		
		posReturn.clear();
		posReturn.add(posizione);
		
		String[] splittedString = posizione.split(",");
		int posY = Integer.parseInt(splittedString[0]);
		int posX = Integer.parseInt(splittedString[1]);
		
		if(campo[posY-1][posX-1]==null && ((CGiocabili)carta).getAngoli()[0].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY-1) + "," + (posX-1));
			posizioniDisponibili.add((posY-1) + "," + (posX-1));
		}
		if(campo[posY+1][posX-1]==null && ((CGiocabili)carta).getAngoli()[3].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY+1) + "," + (posX-1));
			posizioniDisponibili.add((posY+1) + "," + (posX-1));
		}
		if(campo[posY-1][posX+1]==null && ((CGiocabili)carta).getAngoli()[1].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY-1) + "," + (posX+1));
			posizioniDisponibili.add((posY-1) + "," + (posX+1));
		}
		if(campo[posY+1][posX+1]==null && ((CGiocabili)carta).getAngoli()[2].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY+1) + "," + (posX+1));
			posizioniDisponibili.add((posY+1) + "," + (posX+1));
		}
		
	}
	/**
	 * 
	 * @return l ArrayList con le posizioni libere
	 */
	public ArrayList<String> getPosizioniDisponibili() {
		return posizioniDisponibili;
	}

	public void print(String posizione, Carta carta) {
		String[] splittedString = posizione.split(",");
		int posY = Integer.parseInt(splittedString[0]);
		int posX = Integer.parseInt(splittedString[1]);
		
		campoPrint[posY][posX]=carta.getIdCarta();
		
	}
	/**
	 * consente di stampare la matrice ovvero le celle del campo
	 * di gioco del giocatore, mostrando l id delle carte piazzate
	 * specificate da una piccola legenda
	 * @param giocatoreAttuale
	 */
	public void print(Giocatore giocatoreAttuale) {
		System.out.printf(" " + "%9d" + " |", 0);
		for(int x=1; x<dimensioneX; x++) {
			System.out.printf(" " + "%3d" + " ", x);
			if(x<dimensioneX-1) {
				System.out.print("|");
			}
		}
		System.out.println("");
		for(int x=0; x<dimensioneX; x++) {
			System.out.print("----");
			if(x<dimensioneX-1) {
				System.out.print("--");
			}
		}
		System.out.println("-------");
		for(int y=0; y<dimensioneY; y++) {
			System.out.printf(" " + "%3d" + " |", y);
			for(int x=0; x<dimensioneX; x++) {
					System.out.printf(" " + "%3d" + " ", campoPrint[y][x]);
				if(x<dimensioneX-1) {
					System.out.print("|");
				}
			}
			System.out.println("");
			if(y<dimensioneY-1) {
				for(int x=0; x<dimensioneX; x++) {
					System.out.print("----");
					if(x<dimensioneX-1) {
						System.out.print("--");
					}
				}
				System.out.print("-------");
			}
			System.out.println("");
		}
		//stampa legenda		
		System.out.println("Legenda:");
		for(String s : giocatoreAttuale.getCPiazzate()) {
			System.out.println(s);
		}
		
	}
	/**
	 * 
	 * @return dimensioneX del campo di gioco
	 */
	public static int getDimensionex() {
		return dimensioneX;
	}
	/**
	 * 
	 * @return dimensioneY dle campo di gioco
	 */

	public static int getDimensioney() {
		return dimensioneY;
	}
	/**
	 * 
	 * @return la matrice che rappresenta il campo di gioco
	 */
	public Carta[][] getCampo() {
		return this.campo;
	}
	/**
	 * per aggiornare il campo di gioco con le carte giocate 
	 * @param campo di gioco
	 */
	public void setCampo(CGiocabili[][] campo) {
		this.campo = campo;
	}
	
}
