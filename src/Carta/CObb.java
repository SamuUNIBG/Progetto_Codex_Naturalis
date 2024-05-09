package Carta;

import Tavolo.Giocatore;

/**
 * le carte obiettivo sono di vario tipo ed assegnano punti sotto specifiche
 * condizioni che vengono contati ed aggiunti al tabellone al termine della partita
 */
public abstract class CObb extends Carta{
	
	public CObb(int puntiAssegnati, int idCarta) {
		super(puntiAssegnati, idCarta);
	}
	/**
	 * metodo per verificare se un obiettivo e stato raggiunto e quante volte 
	 * e stato raggiunto
	 * @param giocatore
	 * @return il numero di punti ottenuti grazie a quell'obiettivo
	 */
	public abstract int calcolaObb(Giocatore giocatore);
	
}
