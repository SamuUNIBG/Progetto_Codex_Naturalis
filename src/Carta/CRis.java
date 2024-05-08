package Carta;

import Enumerazione.*;
/**
 * le carte risorsa sono 40 totali di cui, una volta mescolato il mazzo,
 * le prime 2 vengono rivelate scoperte sul campo di gioco, al contempo
 * con le carte oro, e poi ogni giocatore ne pesca 2 dal mazzo che 
 * comporranno poi la sua mano.
 * sul fronte presentano degli angoli (non necessariamente tutti e 4) che
 * possono avere delle risorse o oggetti e possono dare dei punti al 
 * loro piazzamento
 * sul retro hanno una risorsa permanente al centro della carta e i 4 angoli visibili
 */

public class CRis extends CGiocabiliSpeciali {
	
	private static int lastId=0; //id incrementali

	public CRis(int puntiAssegnati, Simbolo simbolo,Colore colore, Simbolo angolo0, Simbolo angolo1, Simbolo angolo2, Simbolo angolo3) {
		super(puntiAssegnati, simbolo, colore, true, angolo0, angolo1, angolo2, angolo3, CRis.lastId);
		CRis.lastId++;
	}
	
	public CRis(Simbolo simbolo, Colore colore, int IdCarta) {
		super(0, simbolo, colore, false, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, IdCarta);
	}
	
	//@Override
	/*public int getIdCarta() {
		return super.getIdCarta();
	}

	public Angolo[] getAngoli() {
		return super.getAngoli();
	}

	public Simbolo getSimbolo() {
		return super.getSimbolo();
	}

	public Colore getColore() {
		return super.getColore();
	}
	
	public void retro() {
		super.retro();
	}
	public boolean getFronte() {
		return super.getFronte();
	}*/

	@Override
	public String toString() {
		return "Carata risorsa " + super.getIdCarta() +
				":\n\t\t[" + super.toString() +
				"\n\t\t Simbolo -> " + super.getSimbolo() +
				"\n\t\t Colore -> " + super.getColore() +
				"\n\t\t Angoli:" +
				"\n\t\t\tAlto sx -> " + super.getAngoli()[0].getSimbolo() +
				"\n\t\t\tAltro dx -> " + super.getAngoli()[1].getSimbolo() +
				"\n\t\t\tBasso dx -> " +super.getAngoli()[2].getSimbolo() +
				"\n\t\t\tBasso sx -> " +super.getAngoli()[3].getSimbolo() + "]";
				
	}
	/*@Override
	public boolean isContataScala() {
		return super.isContataScala();
	}
	@Override
	public void setContataScala(boolean contataScala) {
		super.setContataScala(contataScala);
	}
	@Override
	public boolean isContataL() {
		return super.isContataL();
	}
	@Override
	public void setContataL(boolean contataL) {
		super.setContataL(contataL);
	}*/

	
	
}
