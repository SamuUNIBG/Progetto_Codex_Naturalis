package Carta;
import Enumerazione.Colore;
import Enumerazione.Simbolo;
import Tavolo.Giocatore;
/**
 * sono quel tipo di CARTE OBIETTIVO che presentano uno schema 
 * da avere nell area di gioco al momento della conta finale dei punti per 
 * ottenere i punti segnati sulla stessa 
 * lo SCHEMA e una sequenza di carte che piazzate formano una "L" orientata
 * in 4 direzioni possibili,
 * va rispettato sia lo schema sia il colore delle carte con cui realizzarlo
 * ( i punti vengono dati per ogni schema realizzato purché con carte diverse
 * quindi una stessa carta non può essere contata 2 volte per uno stesso obiettivo)
 */
public class CObbL extends CObb{
	private final Colore[] colori = new Colore[2]; /*contiene i colori delle carte con cui
	realizzare lo schema perche puo esser fatto da carte di diversi colori*/
	private final int direzione; /*contiene 4 numeri che rappresentano le
	4 direzioni possibili in cui la L puo essere orientata*/
	public CObbL(int puntiAssegnati, Colore colore0,
			Colore colore1, int direzione) {
		super(puntiAssegnati);
		this.colori[0]=colore0;
		this.colori[1]=colore1;
		this.direzione=direzione;
		// TODO Auto-generated constructor stub
	}
	public Colore[] getColori() {
		return colori;
	}
	public int getDirezione() {
		return direzione;
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
}
