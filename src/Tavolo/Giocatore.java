package Tavolo;

import java.util.ArrayList;

import Carta.Angolo;
import Carta.CGiocabili;
import Carta.CGiocabiliSpeciali;
import Carta.CIniz;
import Carta.CObb;
import Carta.Carta;
import Enumerazione.Colore;
import Enumerazione.Simbolo;

public class Giocatore {
	
	private final String soprannome;
	private final Colore colore;
	private int punteggio;
	private final boolean primo;
	private ArrayList<CGiocabiliSpeciali> cMano;
	private CObb cObbPer;
	private CIniz cInizPer;
	private CampoGioco campo;
	private int[] risPossedute;
	private int[] oggPosseduti;
	private ArrayList<String> cPiazzate;
	
	public Giocatore(String soprannome,Colore colore,boolean primo) {
		this.soprannome=soprannome;
		this.colore=colore;
		this.primo=primo;
		punteggio=0;
		campo = new CampoGioco();
		
		cMano = new ArrayList<CGiocabiliSpeciali>();
		cPiazzate =  new ArrayList<String>();
		cPiazzate.add("999 -> cella vuota");

		
		cObbPer = null;
		cInizPer = null;
		
		risPossedute = new int[4];
		oggPosseduti = new int[3];
		
		for(int i=0; i<4; i++) {
			risPossedute[i]=0;
			if(i<3) {
				oggPosseduti[i]=0;
			}
			
		}
		
	}
	
	public Colore getColore() {
		return colore;
	}
	
	public int getPunteggio() {
		return punteggio;
	}
	public void addPunteggio(int punti) {
		punteggio+=punti;
	}
	public String getSoprannome() {
		return this.soprannome;
	}
	
	/**
	 * @return the cPiazzate
	 */
	public ArrayList<String> getCPiazzate() {
		return cPiazzate;
	}
	
	public void piazzaC(String posCarta, CGiocabili carta) {
		
		campo.aggiungiC(posCarta, carta);
		campo.print(posCarta, carta);
		
		//Incrementa array risorse/oggetti posseduti
		Angolo[] angoli = carta.getAngoli();
		for(int i=0; i<angoli.length; i++) {
			if(angoli[i].getSimbolo()==Simbolo.FOGLIA) {
				risPossedute[0]+=1;
			}else if(angoli[i].getSimbolo()==Simbolo.LUPO) {
				risPossedute[1]+=1;
			}else if(angoli[i].getSimbolo()==Simbolo.FUNGO) {
				risPossedute[2]+=1;
			}else if(angoli[i].getSimbolo()==Simbolo.FARFALLA) {
				risPossedute[3]+=1;
			}
			if(angoli[i].getSimbolo()==Simbolo.INCHIOSTRO) {
				oggPosseduti[0]+=1;
			}else if(angoli[i].getSimbolo()==Simbolo.PERGAMENA) {
				oggPosseduti[1]+=1;
			}else if(angoli[i].getSimbolo()==Simbolo.PIUMA) {
				oggPosseduti[2]+=1;
			}
		}
		
		Simbolo[] simboli = campo.copriAngoli(posCarta);
		//Decrementa array risorse/oggetti posseduti
		for(int i=0; i<simboli.length; i++) {
			if(simboli[i]==Simbolo.FOGLIA) {
				risPossedute[0]-=1;
			}else if(simboli[i]==Simbolo.LUPO) {
				risPossedute[1]-=1;
			}else if(simboli[i]==Simbolo.FUNGO) {
				risPossedute[2]-=1;
			}else if(simboli[i]==Simbolo.FARFALLA) {
				risPossedute[3]-=1;
			}
			if(simboli[i]==Simbolo.INCHIOSTRO) {
				oggPosseduti[0]-=1;
			}else if(simboli[i]==Simbolo.PERGAMENA) {
				oggPosseduti[1]-=1;
			}else if(simboli[i]==Simbolo.PIUMA) {
				oggPosseduti[2]-=1;
			}
		}
		
	}
	
	public CObb getCObbPer() {
		return cObbPer;
	}
	public int[] getRisPossedute() {
		return this.risPossedute;
	}
	public int[] getOggPosseduti() {
		return this.oggPosseduti;
	}
	public CampoGioco getCampoG() {
		return this.campo;
	}
	
	public CIniz getCInizPer() {
		return cInizPer;
	}
	public void pescaC(Carta carta) {
		 
		if(carta instanceof CGiocabiliSpeciali) {
			cMano.add((CGiocabiliSpeciali)carta);
		}else if(carta instanceof CObb){
			cObbPer = (CObb)carta;
		}else if(carta instanceof CIniz){
			cInizPer = (CIniz)carta;
		}
		
	}

	public ArrayList<CGiocabiliSpeciali> getCMano() {
		return cMano;
	}

}
