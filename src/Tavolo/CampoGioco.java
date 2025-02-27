package Tavolo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import Carta.Carta;
import Enumerazione.Simbolo;
import Carta.CGiocabili;

public class CampoGioco {

	public static final int DIMENSIONEX = 81;
	public static final int DIMENSIONEY = 81;
	
	private CGiocabili[][] campo;
	private int[][] campoPrint;	
	
	private ArrayList<String> posizioniReturn;
	private Set<String> posizioniDisponibili;
	private Set<String> posNonPiuDisponibili;
	
	public CampoGioco(){
		
		posizioniReturn = new ArrayList<String>();
		posizioniDisponibili = new HashSet<String>();
		posNonPiuDisponibili = new HashSet<String>();
		
		campo = new CGiocabili[DIMENSIONEY][DIMENSIONEX];
		campoPrint = new int[DIMENSIONEY][DIMENSIONEX];
		
		for(int y=0; y<DIMENSIONEY; y++) {
			for(int x=0; x<DIMENSIONEX; x++) {
				campo[y][x]=null;
				campoPrint[y][x]=777;
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
	
	public Simbolo[] copriAngoli(HashMap<Integer, String> cPiazzate, String posizione) {
		
		Simbolo[] simboli = new Simbolo[4];
		
		for(int i=0; i<simboli.length; i++) {
			simboli[i]=null;
		}
		
		String[] splittedString = posizione.split(",");
		int posY = Integer.parseInt(splittedString[0]);
		int posX = Integer.parseInt(splittedString[1]);
		
		if(campo[posY-1][posX-1]!=null) {
			CGiocabili c = (CGiocabili)campo[posY-1][posX-1];
			c.getAngoli()[2].setCoperto();
			simboli[0]=c.getAngoli()[2].getSimbolo();
			cPiazzate.remove(c.getIdCarta());
			cPiazzate.put(c.getIdCarta(), c.toStringBreve());
			
		}
		if(campo[posY+1][posX-1]!=null) {
			CGiocabili c = campo[posY+1][posX-1];
			c.getAngoli()[1].setCoperto();
			simboli[1]=c.getAngoli()[1].getSimbolo();
			cPiazzate.remove(c.getIdCarta());
			cPiazzate.put(c.getIdCarta(), c.toStringBreve());
		}
		if(campo[posY-1][posX+1]!=null) {
			CGiocabili c = campo[posY-1][posX+1];
			c.getAngoli()[3].setCoperto();
			simboli[2]=c.getAngoli()[3].getSimbolo();
			cPiazzate.remove(c.getIdCarta());
			cPiazzate.put(c.getIdCarta(), c.toStringBreve());
		}
		if(campo[posY+1][posX+1]!=null) {
			CGiocabili c = campo[posY+1][posX+1];
			c.getAngoli()[0].setCoperto();
			simboli[3]=c.getAngoli()[0].getSimbolo();
			cPiazzate.remove(c.getIdCarta());
			cPiazzate.put(c.getIdCarta(), c.toStringBreve());
		}
		
		return simboli;
		
	}

	/**
	 * per mostrare le posizioni possibile nelle quali poter
	 * posizionare la carta e mostrarle al giocatore
	 * @param posizione che contiene le coordinate x e y
	 * @param carta gia posizionata
	 */
	private void controllaNuovePosizioni(String posizione, CGiocabili carta) {
		posizioniReturn.clear();
		posizioniDisponibili.remove(posizione);
		posizioniReturn.add(posizione);
		
		Set<String> posDis = new HashSet<String>();
		Set<String> posReturn = new HashSet<String>();
		
		String[] splittedString = posizione.split(",");
		int posY = Integer.parseInt(splittedString[0]);
		int posX = Integer.parseInt(splittedString[1]);
		
		if(campo[posY-1][posX-1]==null && carta.getAngoli()[0].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY-1) + "," + (posX-1));
			posDis.add((posY-1) + "," + (posX-1));
		}else {
			if(campo[posY-1][posX-1]==null && carta.getAngoli()[0].getSimbolo()==Simbolo.ASSENTE) {
				posNonPiuDisponibili.add((posY-1) + "," + (posX-1));
			}
		}
			
		if(campo[posY+1][posX-1]==null && carta.getAngoli()[3].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY+1) + "," + (posX-1));
			posDis.add((posY+1) + "," + (posX-1));
		}
		else {
			if(campo[posY+1][posX-1]==null && carta.getAngoli()[3].getSimbolo()==Simbolo.ASSENTE) {
				posNonPiuDisponibili.add((posY+1) + "," + (posX-1));
			}
		}
			
		if(campo[posY-1][posX+1]==null && carta.getAngoli()[1].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY-1) + "," + (posX+1));
			posDis.add((posY-1) + "," + (posX+1));
		}else {
			if(campo[posY-1][posX+1]==null && carta.getAngoli()[1].getSimbolo()==Simbolo.ASSENTE) {
				posNonPiuDisponibili.add((posY-1) + "," + (posX+1));
			}
		}
			
		if(campo[posY+1][posX+1]==null && carta.getAngoli()[2].getSimbolo()!=Simbolo.ASSENTE) {
			posReturn.add((posY+1) + "," + (posX+1));
			posDis.add((posY+1) + "," + (posX+1));
		}else {
			if(campo[posY+1][posX+1]==null && carta.getAngoli()[2].getSimbolo()==Simbolo.ASSENTE) {
				posNonPiuDisponibili.add((posY+1) + "," + (posX+1));
			}
		}
		
		for(String s: posReturn) {
			if(!posNonPiuDisponibili.contains(s))
				posizioniReturn.add(s);
		}
		
		for(String s: posDis) {
			if(!posNonPiuDisponibili.contains(s))
				posizioniDisponibili.add(s);
		}
		
	}
	
	/**
	 * 
	 * @return l ArrayList con le posizioni libere
	 */
	public Set<String> getPosizioniDisponibili() {
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
		for(int x=1; x<DIMENSIONEX; x++) {
			System.out.printf(" " + "%3d" + " ", x);
			if(x<DIMENSIONEX-1) {
				System.out.print("|");
			}
		}
		System.out.println("");
		for(int x=0; x<DIMENSIONEX; x++) {
			System.out.print("----");
			if(x<DIMENSIONEX-1) {
				System.out.print("--");
			}
		}
		System.out.println("-------");
		for(int y=0; y<DIMENSIONEY; y++) {
			System.out.printf(" " + "%3d" + " |", y);
			for(int x=0; x<DIMENSIONEX; x++) {
					System.out.printf(" " + "%3d" + " ", campoPrint[y][x]);
				if(x<DIMENSIONEX-1) {
					System.out.print("|");
				}
			}
			System.out.println("");
			if(y<DIMENSIONEY-1) {
				for(int x=0; x<DIMENSIONEX; x++) {
					System.out.print("----");
					if(x<DIMENSIONEX-1) {
						System.out.print("--");
					}
				}
				System.out.print("-------");
			}
			System.out.println("");
		}
		//stampa legenda		
		System.out.println("Legenda:");
		for (Integer i : giocatoreAttuale.getCPiazzate().keySet()) {
			  System.out.println(giocatoreAttuale.getCPiazzate().get(i));
		}
		
	}
	/**
	 * 
	 * @return DIMENSIONEX del campo di gioco
	 */
	public static int getDIMENSIONEX() {
		return DIMENSIONEX;
	}
	/**
	 * 
	 * @return DIMENSIONEY dle campo di gioco
	 */

	public static int getDIMENSIONEY() {
		return DIMENSIONEY;
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
	
	public ArrayList<String> getPosReturn(){
		return posizioniReturn;
	}
	
	public Set<String> getPosNonPiuDisponibili(){
		return posNonPiuDisponibili;
	}
	
}
