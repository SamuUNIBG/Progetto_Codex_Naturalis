package Carta;

import Tavolo.Giocatore;

public interface InterfacciaCarte2 {
	public abstract boolean VerificaPrerequistio(int[] vettoreRisorse);
	public abstract int calcolaMiniObb(String posizione, Giocatore giocatore);
}
