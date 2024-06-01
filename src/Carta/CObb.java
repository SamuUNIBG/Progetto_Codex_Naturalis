package Carta;

import Eccezioni.IdCartaException;
import Eccezioni.PuntiAssegnatiException;
import Tavolo.Giocatore;

/**
 * le carte obiettivo sono di vario tipo ed assegnano punti sotto specifiche
 * condizioni che vengono contati ed aggiunti al tabellone al termine della partita
 */
public abstract class CObb extends Carta{
	
	/**
	 * @param puntiAssegnati
	 * @param idCarta
	 * @throws IdCartaException quando id < 0
	 * @throws PuntiAssegnatiException qaundo !(0 <= PuntiAssegnati <= 3) 
	 */
	public CObb(int puntiAssegnati, int idCarta) throws PuntiAssegnatiException, IdCartaException {
		super(puntiAssegnati, idCarta);
	}
	/**
	 * metodo per verificare se un obiettivo e stato raggiunto e quante volte 
	 * e stato raggiunto
	 * @param giocatore
	 * @return il numero di punti ottenuti grazie a quell'obiettivo
	 */
	public abstract void calcolaObb(Giocatore giocatore);
	
}
