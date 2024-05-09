package Carta;

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
	
	public Carta(int puntiAssegnati, int idCarta) {
		this.puntiAssegnati = puntiAssegnati;
		this.idCarta = idCarta;
	}
	
	/**
	 * sara poi usato dalle sottoclassi per ottenere informazioni
	 * sui punti delle rispettive carte
	 * @return
	 */
	public int getPunti() {  
		return this.puntiAssegnati;
	}
	
	
	public int getIdCarta() {
		return idCarta;
	}

	public String toString() {
		return idCarta +
			":\n\t\t[Punteggio assegnato -> " + puntiAssegnati;
	}
	
}
