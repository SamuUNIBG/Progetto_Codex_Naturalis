package Carta;

import Eccezioni.IdCartaException;
import Eccezioni.PuntiAssegnatiException;
import Enumerazione.Simbolo;

import Tavolo.Giocatore;
/**
 * sono quel tipo di CARTE OBIETTIVO che presentano le risorse (generalmente 3)
 * da avere nell area di gioco al momento della conta finale dei punti per 
 * ottenere i punti segnati sulla stessa (sono punti cumulabili, per ogni set di 
 * risorse ottieni quei punti)
 */
public class CObbRis extends CObb{
	
	private final Simbolo simbolo;
	private static int LASTID=94;
	
	/**
	 * @param puntiAssegnati
	 * @param simbolo
	 * @throws IdCartaException quando id < 0
	 * @throws PuntiAssegnatiException qaundo !(0 <= PuntiAssegnati <= 3)
	 */
	public CObbRis(int puntiAssegnati, Simbolo simbolo) throws PuntiAssegnatiException, IdCartaException {
		super(puntiAssegnati, CObbRis.LASTID);
		this.simbolo=simbolo;
		CObbRis.LASTID++;
	}
	
	public Simbolo getSimbolo() {
		return simbolo;
	}
	
	@Override
	/**
	 * tutte le carte richiedono un set di 3 risorse identiche per dare 
	 * i punti quindi vedo quante di quelle ne possiede il giocatore e 
	 * faccio diviso 3
	 * @return i punti della carta moltiplicato per il numero di set delle
	 * 3 risorse che il giocatore possiede
	 */
	public void calcolaObb(Giocatore giocatore) {
		/*torna un int quindi fa in automatico l approssimazione*/
		switch (this.simbolo) {
			case FOGLIA:
				giocatore.addPunteggio((this.getPunti())*(giocatore.getRisPossedute()[0]/3));
				break;
			case LUPO:
				giocatore.addPunteggio((this.getPunti())*(giocatore.getRisPossedute()[1]/3));
				break;
			case FUNGO:
				giocatore.addPunteggio((this.getPunti())*(giocatore.getRisPossedute()[2]/3));
				break;
			case FARFALLA:
				giocatore.addPunteggio((this.getPunti())*(giocatore.getRisPossedute()[3]/3));
				break;
			default:
				break;
		}
	}
	
	@Override
	public String toString() {
		return "Carta obbiettivo risorsa " + super.toString() +
				"\n\t\t Obbiettivo -> Formare tris di -> " + simbolo +  "]";
		
	}
	
	
}
