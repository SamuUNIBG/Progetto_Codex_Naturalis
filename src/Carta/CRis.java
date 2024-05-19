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
	
	private static int LASTID=0; //id incrementali
	/**
	 * se piazzata sul fronte
	 * @param puntiAssegnati
	 * @param simbolo
	 * @param colore
	 * @param angolo0
	 * @param angolo1
	 * @param angolo2
	 * @param angolo3
	 */
	public CRis(int puntiAssegnati, Simbolo simbolo,Colore colore, Simbolo angolo0, Simbolo angolo1, Simbolo angolo2, Simbolo angolo3) {
		super(puntiAssegnati, simbolo, colore, true, angolo0, angolo1, angolo2, angolo3, CRis.LASTID);
		CRis.LASTID++;
	}
	/**
	 * se piazzata sul retro
	 * @param simbolo
	 * @param colore
	 * @param IdCarta
	 */
	public CRis(Simbolo simbolo, Colore colore, int IdCarta) {
		super(0, simbolo, colore, false, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, IdCarta);
	}

	@Override
	/** torna una stringa con tutte le informazioni della carta 
	 * utile per capire le carte della mano
	 * @return String
	 */
	public String toString() {
		return "Carata risorsa " + super.toString() +
				"\n\t\t Simbolo -> " + this.getSimbolo() +
				"\n\t\t Colore -> " + this.getColore() +
				"\n\t\t Angoli:" +
				"\n\t\t\tAlto sx -> " + this.getAngoli()[0].getSimbolo() +
				"\n\t\t\tAlto dx -> " + this.getAngoli()[1].getSimbolo() +
				"\n\t\t\tBasso dx -> " + this.getAngoli()[2].getSimbolo() +
				"\n\t\t\tBasso sx -> " + this.getAngoli()[3].getSimbolo() + "]";			
	}
	/** torna una stringa le informazioni della carta una volta
	 * che è stata piazzata sul campo, se e stata piazzata sul fronte 
	 * da le informazioni relative solo al fronte e analogalmente se
	 * piazzata sul retro
	 * @return String
	 */
	public String toStringBreve() {
		
		String str = "Carata risorsa " + this.getIdCarta() +
					 ":\n\t\t[Simbolo -> " + this.getSimbolo() +
					 "\n\t\t Colore -> " + this.getColore();
		if(this.getFronte()) {
			str += ":\n\t\t Angoli fronte:" +
					"\n\t\t\tAlto sx -> " + this.getAngoli()[0].toString() +
					"\n\t\t\tAlto dx -> " + this.getAngoli()[1].toString() +
					"\n\t\t\tBasso dx -> " + this.getAngoli()[2].toString() +
					"\n\t\t\tBasso sx -> " + this.getAngoli()[3].toString() + "]";
		}else {
			str += "\n\t\t Angoli retro:" +
					"\n\t\t\tAlto sx -> " + this.getAngoli()[0].getSimbolo() +
					"\n\t\t\tAlto dx -> " + this.getAngoli()[1].getSimbolo() +
					"\n\t\t\tBasso dx -> " + this.getAngoli()[2].getSimbolo() +
					"\n\t\t\tBasso sx -> " + this.getAngoli()[3].getSimbolo() + "]";
		}
		
		return str;
		
	}
}
