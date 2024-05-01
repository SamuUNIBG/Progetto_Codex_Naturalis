package Tavolo;

import java.util.ArrayList;

import Carta.CObb;
import Carta.Carta;
import Enumerazione.Colore;

public class Giocatore {
	
private final String soprannome;
private final Colore colore;
private int punteggio;
private final boolean primo;
private ArrayList<Carta> cMano;
private CObb CObbPer;
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
	
	CObbPer = null;
	
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
public String getSoprannome() {
	return soprannome;
}
public boolean giocaC() {
	
	return true;
}
/*public Carta pescaC() {
	 
	Carta c=new Carta();
	 return c;
}
*/


}
