package Tavolo;

import java.util.ArrayList;

import Carta.CObb;
import Carta.COro;
import Carta.CRis;
import Carta.Carta;
import Enumerazione.Colore;
import Enumerazione.TipoCarta;

public class Giocatore {
	
	private final String soprannome;
	private final Colore colore;
	private int punteggio;
	private final boolean primo;
	private ArrayList<Carta> cMano;
	private CObb cObbPer;
	private CampoGioco campo;
	private int[] risPossedute;
	private int[] oggPosseduti;
	
	public Giocatore(String soprannome,Colore colore,boolean primo) {
		this.soprannome=soprannome;
		this.colore=colore;
		this.primo=primo;
		punteggio=0;
		campo = new CampoGioco();
		
		cMano = new ArrayList<Carta>();
		
		cObbPer = null;
		
		risPossedute = new int[4];
		oggPosseduti = new int[3];
		
		for(int i=0; i<4; i++) {
			risPossedute[i]=0;
			if(i<3) {
				oggPosseduti[i]=0;
				cMano.add(null);
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
		return soprannome;
	}
	public boolean giocaC() {
		
		return true;
	}
	public CObb getCObbPer() {
		return cObbPer;
	}
	public void pescaC(Carta carta) {
		 
		if(carta instanceof CRis || carta instanceof COro) {
			cMano.add(carta);
		}else if(carta instanceof CObb){
			cObbPer = (CObb)carta;
		}
		
	}

}
