package Carta;

import Enumerazione.Colore;
import Enumerazione.Simbolo;
import Tavolo.Giocatore;

public abstract class Carta {
	
	

	private final int puntiAssegnati; //le carte hanno punti
	
	public Carta(int puntiAssegnati) {
		this.puntiAssegnati=puntiAssegnati;
	}
	
	/**
	 * sara poi usato dalle sottoclassi per ottenere informazioni
	 * sui punti delle rispettive carte
	 * @return
	 */
	public int getPunti() {  
		return this.puntiAssegnati;
	}
	
	public abstract Angolo[] getAngoli();
	public abstract int getIDCARTA();
	public abstract boolean VerificaPrerequistio();
	public abstract Simbolo getSimbolo();
	public abstract boolean isContataScala();
	public abstract Colore getColore();
	
	@Override
	public String toString() {
		return "punteggio carata= " + puntiAssegnati;
	}
}
