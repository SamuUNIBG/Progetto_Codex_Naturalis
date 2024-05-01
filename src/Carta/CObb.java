	package Carta;

import Tavolo.Giocatore;

/**
 * le carte obiettivo sono di vario tipo ed assegnano punti sotto specifiche
 * condizioni che vengono contati ed aggiunti al tabellone al termine della partita
 */
public abstract class CObb extends Carta{
	
	public CObb(int puntiAssegnati) {
		super(puntiAssegnati);
		// TODO Auto-generated constructor stub
	}
	
	public abstract int calcolaObb(Giocatore giocatore);

	@Override
	public Angolo[] getAngoli() {
		// TODO Auto-generated method stub
		return null;
	}
}
