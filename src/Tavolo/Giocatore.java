package Tavolo;

import java.util.ArrayList;
import java.util.HashMap;

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
	private HashMap<Integer, String> cPiazzate;
	
	public Giocatore(String soprannome,Colore colore,boolean primo) {
		this.soprannome=soprannome;
		this.colore=colore;
		this.primo=primo;
		punteggio=0;
		campo = new CampoGioco();
		
		cMano = new ArrayList<CGiocabiliSpeciali>();
		cPiazzate =  new HashMap<Integer, String>();
		cPiazzate.put(0, "000 -> cella vuota");

		
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
	public HashMap<Integer, String> getCPiazzate() {
		return cPiazzate;
	}
	
	public void piazzaC(HashMap<Integer, String> cPiazzate, String posCarta, CGiocabili carta) {
		
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
		
		if(carta instanceof CGiocabiliSpeciali && !(((CGiocabiliSpeciali)carta).getFronte())) {
			Simbolo simbolo = ((CGiocabiliSpeciali)carta).getSimbolo();
			if(simbolo==Simbolo.FOGLIA) {
				risPossedute[0]+=1;
			}else if(simbolo==Simbolo.LUPO) {
				risPossedute[1]+=1;
			}else if(simbolo==Simbolo.FUNGO) {
				risPossedute[2]+=1;
			}else if(simbolo==Simbolo.FARFALLA) {
				risPossedute[3]+=1;
			}
		}
		
		Simbolo[] simboli = campo.copriAngoli(cPiazzate, posCarta);
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
	
	public String toString() {
		return "Soprannome: " + soprannome + ", colore: " + colore + ", punti: " + punteggio +
				", risorse possedute: [" + risPossedute[0] + ", " + risPossedute[1] + ", " + risPossedute[2] + ", " + risPossedute[3] +
				"], oggetti posseduti: [" + + oggPosseduti[0] + ", " + oggPosseduti[1] + ", " + oggPosseduti[2] + "]";
	}

}
