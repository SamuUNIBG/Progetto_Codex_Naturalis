package Tavolo;

import Carta.CRis;
import Carta.Carta;

/**
 * @author Samuele Vecchi
 *
 */
public abstract class Mazzo {
	
	/**
	 * @return the top card of the deck
	 */
	public abstract Carta pesca();
	
	/**
	 * @return the number of cards remaining in the deck
	 */
	public abstract int getCRimaste();
	
}
