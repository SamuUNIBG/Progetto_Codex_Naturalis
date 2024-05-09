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
		return "Carata risorsa " + super.toString() +
				"\n\t\t Simbolo -> " + this.getSimbolo() +
				"\n\t\t Colore -> " + this.getColore() +
				"\n\t\t Angoli:" +
				"\n\t\t\tAlto sx -> " + this.getAngoli()[0].getSimbolo() +
				"\n\t\t\tAltro dx -> " + this.getAngoli()[1].getSimbolo() +
				"\n\t\t\tBasso dx -> " + this.getAngoli()[2].getSimbolo() +
				"\n\t\t\tBasso sx -> " + this.getAngoli()[3].getSimbolo() + "]";			
	}
	
	public String toStringBreve() {
		
		String str = "Carata risorsa " + this.getIdCarta() +
					 ":\n\t\t[Simbolo -> " + this.getSimbolo() +
					 "\n\t\t Colore -> " + this.getColore();
		if(this.getFronte()) {
			str += ":\n\t\t Angoli fronte:" +
					"\n\t\t\tAlto sx -> " + this.getAngoli()[0].toString() +
					"\n\t\t\tAltro dx -> " + this.getAngoli()[1].toString() +
					"\n\t\t\tBasso dx -> " + this.getAngoli()[2].toString() +
					"\n\t\t\tBasso sx -> " + this.getAngoli()[3].toString() + "]";
		}else {
			str += "\n\t\t Angoli retro:" +
					"\n\t\t\tAlto sx -> " + this.getAngoli()[0].getSimbolo() +
					"\n\t\t\tAltro dx -> " + this.getAngoli()[1].getSimbolo() +
					"\n\t\t\tBasso dx -> " + this.getAngoli()[2].getSimbolo() +
					"\n\t\t\tBasso sx -> " + this.getAngoli()[3].getSimbolo() + "]";
		}
		
		return str;
		
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
