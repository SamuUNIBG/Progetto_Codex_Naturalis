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
	
	
	/**
	 * @param soprannome
	 * @param colore
	 * @param primo
	 */
	public Giocatore(String soprannome,Colore colore,boolean primo) {
		this.soprannome=soprannome;
		this.colore=colore;
		this.primo=primo;
		punteggio=0;
		campo = new CampoGioco();
		
		cMano = new ArrayList<CGiocabiliSpeciali>();
		cPiazzate =  new HashMap<Integer, String>();
		cPiazzate.put(0, "777 -> cella vuota");

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
	
	/**
	 * 
	 * @return il colore della pedina del giocatore
	 */
	public Colore getColore() {
		return colore;
	}
	
	/**
	 * 
	 * @return punteggio del giocatore
	 */
	public int getPunteggio() {
		return punteggio;
	}
	
	/**
	 * per aggiungere di volta in volta i punti ottenuti dal giocatore
	 * @param punti ottenuti
	 */
	public void addPunteggio(int punti) {
		punteggio+=punti;
	}
	
	/**
	 * inserire il soprannome del giocatore
	 * @return il soprannome
	 */
	public String getSoprannome() {
		return this.soprannome;
	}
	
	/**
	 * @return the cPiazzate
	 */
	public HashMap<Integer, String> getCPiazzate() {
		return cPiazzate;
	}
	
	/**
	 * metodo per il piazzamento della carta che controlla
	 * anche se la carta da dei punti al giocatore al piazzamento
	 * @param coordinate in cui posizionare la carta
	 * @param carta
	 */
	public void piazzaC(HashMap<Integer, String> cPiazzate, String posCarta, CGiocabili carta) {
		
		campo.aggiungiC(posCarta, carta);
		campo.print(posCarta, carta);
		
		//Incrementa array risorse/oggetti posseduti
		Angolo[] angoli = carta.getAngoli();
		
		for(Angolo a: angoli) {
			if(a.getSimbolo()==Simbolo.FOGLIA) {
				risPossedute[0]+=1;
			}else if(a.getSimbolo()==Simbolo.LUPO) {
				risPossedute[1]+=1;
			}else if(a.getSimbolo()==Simbolo.FUNGO) {
				risPossedute[2]+=1;
			}else if(a.getSimbolo()==Simbolo.FARFALLA) {
				risPossedute[3]+=1;
			}
			if(a.getSimbolo()==Simbolo.INCHIOSTRO) {
				oggPosseduti[0]+=1;
			}else if(a.getSimbolo()==Simbolo.PERGAMENA) {
				oggPosseduti[1]+=1;
			}else if(a.getSimbolo()==Simbolo.PIUMA) {
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
		for(Simbolo s: simboli) {
			if(s==Simbolo.FOGLIA) {
				risPossedute[0]-=1;
			}else if(s==Simbolo.LUPO) {
				risPossedute[1]-=1;
			}else if(s==Simbolo.FUNGO) {
				risPossedute[2]-=1;
			}else if(s==Simbolo.FARFALLA) {
				risPossedute[3]-=1;
			}
			if(s==Simbolo.INCHIOSTRO) {
				oggPosseduti[0]-=1;
			}else if(s==Simbolo.PERGAMENA) {
				oggPosseduti[1]-=1;
			}else if(s==Simbolo.PIUMA) {
				oggPosseduti[2]-=1;
			}
		}
		
	}
	
	/**
	 * 
	 * @return l obbiettivo personale che solo il giocatore conosce
	 */
	public CObb getCObbPer() {
		return cObbPer;
	}
	
	/**
	 * 
	 * @return l array con le risorse possedute dal giocatore
	 */
	public int[] getRisPossedute() {
		return this.risPossedute;
	}
	
	/**
	 * 
	 * @return l array con gli oggetti posseduti dal giocatore
	 */
	public int[] getOggPosseduti() {
		return this.oggPosseduti;
	}
	
	/**
	 * 
	 * @return il campo del giocatore
	 */
	public CampoGioco getCampoG() {
		return this.campo;
	}
	
	/**
	 * 
	 * @return la carta iniziale del giocatore
	 */
	public CIniz getCInizPer() {
		return cInizPer;
	}
	
	/**
	 * gestisce la pescata della carta aggiungendola a quelle in mano
	 * quindi possedute dal giocatore
	 * @param carta pescata
	 */
	public void pescaC(Carta carta) {
		 
		if(carta instanceof CGiocabiliSpeciali) {
			cMano.add((CGiocabiliSpeciali)carta);
		}else if(carta instanceof CObb){
			cObbPer = (CObb)carta;
		}else if(carta instanceof CIniz){
			cInizPer = (CIniz)carta;
		}
		
	}
	
	/**
	 * mostra le carte del giocatore
	 * @return l ArrayList con le carte della mano del giocatore
	 */
	public ArrayList<CGiocabiliSpeciali> getCMano() {
		return cMano;
	}
	
	/**
	 * mostra le informazioni del giocatore, nome, colore, risorse possedute,
	 * oggetti posseduti
	 */
	public String toString() {
		return "Soprannome: " + soprannome + ", colore: " + colore + ", punti: " + punteggio +
				", risorse possedute:\n"
				+ "FOGLIA->" + risPossedute[0] + "\n"
						+ "LUPO->" + risPossedute[1] + "\n"
						+ "FUNGO->" + risPossedute[2] + "\n"
						+ "FARFALLA " + risPossedute[3] +"\n"
				+ "oggetti posseduti:\n"
				+ "INCHIOSTRO->" + oggPosseduti[0] + "\n"
						+ "PERGAMENA-> " + oggPosseduti[1] + "\n"
						+ "PIUMA-> " + oggPosseduti[2] ;
	}

}
