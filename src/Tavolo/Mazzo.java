package Tavolo;

import Carta.Carta;

public abstract class Mazzo {
	
	/**
	 * @return la prima carta del mazzo
	 */
	public abstract Carta pesca();
	
	/**
	 * mostra quante carte ci sono nel mazzo
	 * @return il numero delle carte rimanenti
	 */
	public abstract int getCRimaste();
	
}
