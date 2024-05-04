package Carta;
import Enumerazione.Colore;
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
	public CObbRis(int puntiAssegnati, Simbolo simbolo) {
		super(puntiAssegnati);
		this.simbolo=simbolo;
		// TODO Auto-generated constructor stub
	}
	public Simbolo getSimbolo() {
		return simbolo;
	}
	@Override
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
	public Colore getColore() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isContataScala() {
		// TODO Auto-generated method stub
		return false;
	}
}
