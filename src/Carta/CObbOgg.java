package Carta;
import java.util.*;
import Enumerazione.Simbolo;
import Tavolo.Giocatore;
/**
 * sono quel tipo di CARTE OBIETTIVO che presentano set di oggetti diversi
 * o coppie di oggetti identici,
 * da avere nell area di gioco al momento della conta finale dei punti per 
 * ottenere i punti segnati sulla stessa (sono punti cumulabili, per ogni set
 * o coppie di oggetti ottieni quei punti)
 */
public class CObbOgg extends CObb{
	private final ArrayList<Simbolo> oggetti = null;
	public CObbOgg(int puntiAssegnati, Simbolo oggetto1,
			Simbolo oggetto2, Simbolo oggetto3) {
		super(puntiAssegnati);
		this.oggetti.add(oggetto1);
		if (oggetto2!=Simbolo.ASSENTE) {
			this.oggetti.add(oggetto2);
		}
		if (oggetto3!=Simbolo.ASSENTE) {
			this.oggetti.add(oggetto3);
		}
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Simbolo> getOggetti() {
		return oggetti;
	}
	@Override
	public int calcolaObb(Giocatore giocatore) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getIDCARTA() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean VerificaPrerequistio() {
		// TODO Auto-generated method stub
		return false;
	}
}
