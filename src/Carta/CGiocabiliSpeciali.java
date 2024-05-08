package Carta;

import Enumerazione.Colore;
import Enumerazione.Simbolo;

public abstract class CGiocabiliSpeciali extends CGiocabili {

	private final Simbolo simbolo;
	private final Colore colore;
	private boolean contataScala; //x capire se la carta e stata contata x obiettivo scala
	private boolean contataL; //x capire se la carta e stata contata x obiettivo L
	
	public CGiocabiliSpeciali(int puntiAssegnati, Simbolo simbolo, Colore colore, boolean fronte,
			Simbolo angolo0, Simbolo angolo1, Simbolo angolo2, Simbolo angolo3, int idCarta) {
		super(puntiAssegnati, idCarta, angolo0, angolo1, angolo2, angolo3, fronte);
		this.simbolo = simbolo;
		this.colore = colore;
		
	}
	public Simbolo getSimbolo() {
		return simbolo;
	}
	public Colore getColore() {
		return colore;
	}
	public void retro() {
		super.retro();
	}
	public boolean getFronte() {
		return super.getFronte();
	}
	public Angolo[] getAngoli() {
		return super.getAngoli();
	}
	public boolean isContataScala() {
		return contataScala;
	}
	public void setContataScala(boolean contataScala) {
		contataL=true;
	}
	public boolean isContataL() {
		return contataL;
	}
	public void setContataL(boolean contataL) {
		contataScala=true;
	}
	public int getIdCarta() {
		return super.getIdCarta();
	}
	
}
