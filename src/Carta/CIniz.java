package Carta;
import java.util.*;
import Enumerazione.*;
import Tavolo.Giocatore;  
/**
 * le carte iniziali sono 6 ne vengono date 1 per ogni gocatore
 * che decide come giocarla, sul fronte o sul retro.
 * sul fronte presentano i 4 angoli che possono avere delle risorse
 * o essere vuoti, mentre sul retro presentano (al centro) fino a 4 risorse
 * che son sempre disponibili (visibili che non possono esser coperte
 * da altre carte)
 */
public class CIniz extends Carta {
	
	private final Angolo[] angoli = new Angolo[4];  // gli angoli del fronte delle singole carte
	private final Angolo[] angoliR = new Angolo[4];  // gli angoli del retro delle singole carte
	private final int IDCARTA; //identificativo univoco di ogni carta risors
	// va da 80 a 85 tot 6 carte iniziali
	private static int lastId=80;
	private boolean fronte; //true se il fronte visibile della carta e visibile
	private final ArrayList<Simbolo> risorseCentrali; /*le carte iniziali hanno
												fino a 4 risorse centrali*/
	public CIniz( Simbolo angolo0,Simbolo angolo1,
			Simbolo angolo2, Simbolo angolo3,Simbolo riscentrale1,
			Simbolo riscentrale2, Simbolo riscentrale3, Simbolo angolo4,Simbolo angolo5,
			Simbolo angolo6, Simbolo angolo7 ) {
		super(0); //le carte iniziali non danno punti 
		// TODO Auto-generated constructor stub
		this.angoli[0]=new Angolo(angolo0);
		this.angoli[1]=new Angolo(angolo1);
		this.angoli[2]=new Angolo(angolo2);
		this.angoli[3]=new Angolo(angolo3);
		this.fronte=true;
		risorseCentrali = new ArrayList<Simbolo>();
		this.risorseCentrali.add(riscentrale1);
		if (riscentrale2!=Simbolo.ASSENTE) {
			this.risorseCentrali.add(riscentrale2);
		}
		if (riscentrale3!=Simbolo.ASSENTE) {
			this.risorseCentrali.add(riscentrale3);
		}
		this.IDCARTA=CIniz.lastId;
		CIniz.lastId++;
		this.angoliR[0]=new Angolo(angolo4);
		this.angoliR[1]=new Angolo(angolo5);
		this.angoliR[2]=new Angolo(angolo6);
		this.angoliR[3]=new Angolo(angolo7);
	}

	public void retro() {
		fronte=false;
	}
	public Angolo[] getAngoli() {
		if(fronte)
			return this.angoli;
		else
			return this.angoliR;
	}

	public boolean getFronte() {
		return this.fronte;
	}

	public ArrayList<Simbolo> getRisorseCentrali() {
		return this.risorseCentrali;
	}
	
	@Override
	public int getIDCARTA() {
		return IDCARTA;
	}

	@Override
	public Simbolo getSimbolo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Colore getColore() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isContataScala() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VerificaPrerequistio(int[] vettoreRisorse) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String toString() {
		
		String str = "Carata iniziale " + IDCARTA +
				":\n\t\t[" + super.toString() +
				"\n\t\t Angoli fronte:" +
				"\n\t\t\tAlto sx -> " + angoli[0].getSimbolo() +
				"\n\t\t\tAltro dx -> " + angoli[1].getSimbolo() +
				"\n\t\t\tBasso dx -> " +angoli[2].getSimbolo() +
				"\n\t\t\tBasso sx -> " +angoli[3].getSimbolo() +
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
	
}
