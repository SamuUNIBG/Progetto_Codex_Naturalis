package Carta;

import java.util.*;
import Enumerazione.*;

/**
 * le carte iniziali sono 6 ne vengono date 1 per ogni gocatore
 * che decide come giocarla, sul fronte o sul retro.
 * sul fronte presentano i 4 angoli che possono avere delle risorse
 * o essere vuoti, mentre sul retro presentano (al centro) fino a 4 risorse
 * che son sempre disponibili (visibili che non possono esser coperte
 * da altre carte)
 */
public class CIniz extends CGiocabili {
	
	private final Angolo[] angoliR = new Angolo[4];  // gli angoli del retro delle singole carte
	private static int lastId=80;
	private final ArrayList<Simbolo> risorseCentrali; /*le carte iniziali hanno
												fino a 4 risorse centrali*/
	public CIniz( Simbolo angolo0,Simbolo angolo1, Simbolo angolo2, Simbolo angolo3,Simbolo riscentrale1, Simbolo riscentrale2,
			Simbolo riscentrale3, Simbolo angolo4,Simbolo angolo5, Simbolo angolo6, Simbolo angolo7 ) {
		super(0, CIniz.lastId, angolo0, angolo1, angolo2, angolo3, true); //le carte iniziali non danno punti
		risorseCentrali = new ArrayList<Simbolo>();
		this.risorseCentrali.add(riscentrale1);
		if (riscentrale2!=Simbolo.ASSENTE) {
			this.risorseCentrali.add(riscentrale2);
		}
		if (riscentrale3!=Simbolo.ASSENTE) {
			this.risorseCentrali.add(riscentrale3);
		}
		CIniz.lastId++;
		this.angoliR[0]=new Angolo(angolo4);
		this.angoliR[1]=new Angolo(angolo5);
		this.angoliR[2]=new Angolo(angolo6);
		this.angoliR[3]=new Angolo(angolo7);
	}

	/*public void retro() {
		super.retro();
	}*/
	/** se la carta iniziale e giocata sul fronte torna gli angoli sul fronte
	 *  viceversa quelli sul retro 
	 * @return Angolo[]
	 */
	public Angolo[] getAngoli() {
		if(this.getFronte())
			return super.getAngoli();
		else
			return this.angoliR;
	}

	/*public boolean getFronte() {
		return super.getFronte();
	}*/
	/** ottenere le risorse centrali della carta iniziale
	 * @return ArrayList<Simbolo>
	 */
	public ArrayList<Simbolo> getRisorseCentrali() {
		return this.risorseCentrali;
	}
	
	/*@Override
	public int getIdCarta() {
		return super.getIdCarta();
	}*/
	/** torna una stringa con tutte le informazioni della carta 
	 * utile per capire le carte della mano
	 * @return String
	 */
	public String toString() {
		
		String str = "Carata iniziale " + super.toString() +
				"\n\t\t Angoli fronte:" +
				"\n\t\t\tAlto sx -> " + this.getAngoli()[0].getSimbolo() +
				"\n\t\t\tAltro dx -> " + this.getAngoli()[1].getSimbolo() +
				"\n\t\t\tBasso dx -> " + this.getAngoli()[2].getSimbolo() +
				"\n\t\t\tBasso sx -> " + this.getAngoli()[3].getSimbolo() +
				"\n\t\t Risorse centrali:" +
				"\n\t\t\t1) -> " + risorseCentrali.get(0);
		switch(risorseCentrali.size()) {
			case 2:
				str += "\n\t\t\t2) -> " + risorseCentrali.get(1);
				break;
			case 3:
				str += "\n\t\t\t2) -> " + risorseCentrali.get(1);
				str += "\n\t\t\t3) -> " + risorseCentrali.get(2);
				break;
		}
				
		str += "\n\t\t Angoli retro:" +
		"\n\t\t\tAlto sx -> " + angoliR[0].getSimbolo() +
		"\n\t\t\tAltro dx -> " + angoliR[1].getSimbolo() +
		"\n\t\t\tBasso dx -> " +angoliR[2].getSimbolo() +
		"\n\t\t\tBasso sx -> " +angoliR[3].getSimbolo() + "]";
		
		return str;
		
	}
	/** torna una stringa le informazioni della carta una volta
	 * che è stata piazzata sul campo, se e stata piazzata sul fronte 
	 * da le informazioni relative solo al fronte e analogalmente se
	 * piazzata sul retro
	 * @return String
	 */
	public String toStringBreve() {
		
		String str = "Carata iniziale " + this.getIdCarta();
		
		if(this.getFronte()) {
			str += ":\n\t\t[Angoli fronte:" +
					"\n\t\t\tAlto sx -> " + this.getAngoli()[0].toString() +
					"\n\t\t\tAltro dx -> " + this.getAngoli()[1].toString() +
					"\n\t\t\tBasso dx -> " + this.getAngoli()[2].toString() +
					"\n\t\t\tBasso sx -> " + this.getAngoli()[3].toString() +
					"\n\t\t Risorse centrali:" +
					"\n\t\t\t1) -> " + risorseCentrali.get(0);
			switch(risorseCentrali.size()) {
				case 2:
					str += "\n\t\t\t2) -> " + risorseCentrali.get(1);
					break;
				case 3:
					str += "\n\t\t\t2) -> " + risorseCentrali.get(1);
					str += "\n\t\t\t3) -> " + risorseCentrali.get(2);
					break;
			}
			str +=  "]";
		}else {
			str += "\n\t\t[Angoli retro:" +
					"\n\t\t\tAlto sx -> " + angoliR[0].getSimbolo() +
					"\n\t\t\tAltro dx -> " + angoliR[1].getSimbolo() +
					"\n\t\t\tBasso dx -> " + angoliR[2].getSimbolo() +
					"\n\t\t\tBasso sx -> " + angoliR[3].getSimbolo() + "]";
		}
		
		return str;
		
	}
	
}
