package Carta;

import Enumerazione.Colore;
import Enumerazione.Simbolo;
import Tavolo.Giocatore;

public abstract class Carta {
	
	

	private final int puntiAssegnati; //le carte hanno punti
	
	public Carta(int puntiAssegnati) {
		this.puntiAssegnati=puntiAssegnati;
	}
	
	/**
	 * sara poi usato dalle sottoclassi per ottenere informazioni
	 * sui punti delle rispettive carte
	 * @return
	 */
	public int getPunti() {  
		return this.puntiAssegnati;
	}
	
	public abstract Angolo[] getAngoli();
	public abstract int getIDCARTA();
<<<<<<< HEAD
	
=======
	public abstract boolean VerificaPrerequistio(int[] vettoreRisorse);
>>>>>>> 223e696b9f49afa1eff4145cf86c40ef9c51b850
	public abstract Simbolo getSimbolo();
	
	public abstract Colore getColore();
	public boolean VerificaPrerequisito(Giocatore giocatore) {
		return false;
	}
	@Override
	public String toString() {
		return "Punteggio carta -> " + puntiAssegnati;
	}

	public void setContataScala(boolean contataScala) {
		// TODO Auto-generated method stub
		
	}
	public boolean isContataScala() {
		return false;
	}
	public void setContataL(boolean contataScala) {
		// TODO Auto-generated method stub
		
	}
	public boolean isContataL() {
		return false;
	}

	public abstract boolean getFronte();
}
