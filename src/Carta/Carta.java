package Carta;

import Eccezioni.PuntiAssegnatiException;
import Eccezioni.IdCartaException;

public abstract class Carta{
	
	private final int puntiAssegnati; //le carte hanno punti
	private final int idCarta; //identificativo univoco di ogni carta risors
	// va da 0 a 39 tot 40 carte risorsa
	// va da 40 a 79 tot 40 carte risorsa
	// va da 80 a 85 tot 6 carte iniziali
	// va da 86 a 89 tot 4 carte obbietttivo scala
	// va da 90 a 93 tot 4 carte obbietttivo L
	// va da 94 a 97 tot 4 carte obbietttivo risorsa
	// va da 98 a 101 tot 4 carte obbietttivo oggetto
	
	/**
	 * @param puntiAssegnati
	 * @param idCarta
	 * @throws IdCartaException quando id < 0
	 * @throws PuntiAssegnatiException qaundo !(0 <= PuntiAssegnati <= 3)
	 */
	public Carta(int puntiAssegnati, int idCarta) throws PuntiAssegnatiException, IdCartaException {
		if(puntiAssegnati<0)
			throw new PuntiAssegnatiException("< 0");
		else if(puntiAssegnati>5)
			throw new PuntiAssegnatiException("> 5");
		else
			this.puntiAssegnati = puntiAssegnati;
		if(idCarta<0)
			throw new IdCartaException();
		else
			this.idCarta = idCarta;
		
	}
	
	/**
	 * sara poi usato dalle sottoclassi per ottenere informazioni
	 * sui punti delle rispettive carte
	 * @return int punti Assegnati
	 */
	public int getPunti() {  
		return this.puntiAssegnati;
	}
	
	/** ottenere l'id della carta
	 * @return int IdCarta
	 */
	public int getIdCarta() {
		return idCarta;
	}
	/** torna una stringa con tutte le informazioni della carta 
	 * @return String
	 */
	public String toString() {
		return idCarta +
			":\n\t\t[Punteggio assegnato -> " + puntiAssegnati;
	}
	
}
