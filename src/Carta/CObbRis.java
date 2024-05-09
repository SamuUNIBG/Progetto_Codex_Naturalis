package Carta;

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
	private static int lastId=94;
	
	public CObbRis(int puntiAssegnati, Simbolo simbolo) {
		super(puntiAssegnati, CObbRis.lastId);
		this.simbolo=simbolo;
		CObbRis.lastId++;
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
	public int calcolaObb(Giocatore giocatore) {
		// TODO Auto-generated method stub
		/*torna un int quindi fa in automatico l approssimazione*/
		switch (this.simbolo) {
			case FOGLIA:
				return (this.getPunti())*(giocatore.getRisPossedute()[0]/3);
			case LUPO:
				return (this.getPunti())*(giocatore.getRisPossedute()[1]/3);
			case FUNGO:
				return (this.getPunti())*(giocatore.getRisPossedute()[2]/3);	
			case FARFALLA:
				return (this.getPunti())*(giocatore.getRisPossedute()[3]/3);	
			default:
				return 0;
		}
	}
	
	public int getIdCarta() {
		return super.getIdCarta();
	}


	
	
	public String toString() {
		return "Carata obbiettivo risorsa " + super.toString() +
				"\n\t\t Obbiettivo -> Formare tris di -> " + simbolo +  "]";
		
	}
	
	
}
