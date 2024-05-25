package Carta;

import Tavolo.Giocatore;

public interface InterfacciaCarteOro {
	/**
	 * utile per capire se la carta oro puo esser piazzata o meno
	 * @param vettoreRisorse
	 * @return true se soddisfatto il requistio altrimenti false
	 */
	public abstract boolean VerificaPrerequisito(int[] vettoreRisorse);

	public abstract int calcolaMiniObb(String posizione, Giocatore giocatore);
}
