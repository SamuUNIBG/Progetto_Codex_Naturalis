package Carta;
import java.util.*;
import Enumerazione.*;
import Tavolo.Giocatore;
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

public class CRis extends Carta implements InterfacciaCarte1,InterfacciaCarte3{
	

	private final int IDCARTA; //identificativo univoco di ogni carta risors
	// va da 0 a 39 tot 40 carte risorsa
	private static int lastId=0; //id incrementali
	private final Angolo[] angoli = new Angolo[4];
	private final Simbolo simbolo;
	private final Colore colore;
	private boolean fronte;
	private boolean contataScala; //x capire se la carta e stata contata x obiettivo scala
	private boolean contataL; //x capire se la carta e stata contata x obiettivo L

	public CRis(int puntiAssegnati, Simbolo simbolo,Colore colore,
			Simbolo angolo0, Simbolo angolo1,
			Simbolo angolo2, Simbolo angolo3) {
		super(puntiAssegnati);
		this.angoli[0]=new Angolo(angolo0);
		this.angoli[1]=new Angolo(angolo1);
		this.angoli[2]=new Angolo(angolo2);
		this.angoli[3]=new Angolo(angolo3);
		this.colore=colore;
		this.IDCARTA=CRis.lastId;
		CRis.lastId++;
		this.simbolo=simbolo;
		this.fronte=true;
	}
	
	public CRis(Simbolo simbolo, Colore colore, int IDCARTA) {
		super(0);
		this.angoli[0]=new Angolo(Simbolo.VUOTO);
		this.angoli[1]=new Angolo(Simbolo.VUOTO);
		this.angoli[2]=new Angolo(Simbolo.VUOTO);
		this.angoli[3]=new Angolo(Simbolo.VUOTO);
		this.colore=colore;
		this.IDCARTA=IDCARTA;
		this.simbolo=simbolo;
		this.fronte=false;
	}
	
	@Override
	public int getIDCARTA() {
		return this.IDCARTA;
	}

	public Angolo[] getAngoli() {
		return this.angoli;
	}

	public Simbolo getSimbolo() {
		return this.simbolo;
	}

	public Colore getColore() {
		return this.colore;
	}
	
	public void retro() {
		this.fronte=false;
	}
	public boolean getFronte() {
		return this.fronte;
	}

	@Override
	public String toString() {
		return "Carata risorsa " + IDCARTA +
				":\n\t\t[" + super.toString() +
				"\n\t\t Simbolo -> " + simbolo +
				"\n\t\t Colore -> " + colore +
				"\n\t\t Angoli:" +
				"\n\t\t\tAlto sx -> " + angoli[0].getSimbolo() +
				"\n\t\t\tAltro dx -> " + angoli[1].getSimbolo() +
				"\n\t\t\tBasso dx -> " +angoli[2].getSimbolo() +
				"\n\t\t\tBasso sx -> " +angoli[3].getSimbolo() + "]";
				
	}
	@Override
	public boolean isContataScala() {
		return this.contataScala;
	}
	@Override
	public void setContataScala(boolean contataScala) {
		// TODO Auto-generated method stub
		this.contataScala = contataScala;
	}

	public boolean isContataL() {
		return this.contataL;
	}

	public void setContataL(boolean contataL) {
		this.contataL = contataL;
	}

	
	
}
