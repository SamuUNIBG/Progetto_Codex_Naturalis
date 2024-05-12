package Tavolo;

import Carta.CRis;
import Carta.Carta;

/**
 * @author Samuele Vecchi
 *
 */
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
