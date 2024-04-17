package Tavolo;

import java.util.ArrayList;

import Carta.Carta;
import Enumerazione.Colore;
import Enumerazione.Simbolo;

public class Giocatore {
	
private String soprannome;
private final Colore colore;
private int Punteggio;
private final boolean primo;
private ArrayList<Carta> cMano;
private CObb CObbPer;
private CampoGioco campo;
private Simbolo risPossedute[];
private Simbolo oggPosseduti[];

public Giocatore(String soprannome,Colore colore,boolean primo) {
	this.soprannome=soprannome;
	this.colore=colore;
	this.primo=primo;
}

public Colore getColore() {
	return colore;
}

public int getPunteggio() {
	return Punteggio;
}
public String getSoprannome() {
	return soprannome;
}
public boolean giocaC() {
	
	return true;
}
public Carta pescaC() {
	 
	Carta c=new Carta();
	 return c;
}



}
