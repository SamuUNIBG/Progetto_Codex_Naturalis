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

public class CRis extends Carta{
	private final int IDCARTA; //identificativo univoco di ogni carta risors
	// va da 0 a 39 tot 40 carte risorsa
	private static int lastId=0; //id incrementali
	private final Angolo[] angoli = new Angolo[4];
	private final Simbolo simbolo;
	private final Colore colore;
	private boolean fronte;

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
	public boolean VerificaPrerequistio() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
