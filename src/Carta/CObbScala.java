package Carta;
import Enumerazione.Colore;
/**
 * sono quel tipo di CARTE OBIETTIVO che presentano uno schema 
 * da avere nell area di gioco al momento della conta finale dei punti per 
 * ottenere i punti segnati sulla stessa 
 * lo SCHEMA pu� essere una diagonale crescente ( / ) o decrescente ( \ ) e
 * va rispettato sia lo schema sia il colore delle carte con cui realizzarlo
 * ( i punti vengono dati per ogni schema realizzato purch� con carte diverse
 * quindi una stessa carta non pu� essere contata 2 volte per uno stesso obiettivo)
 */

/**
 * @author Oscar Benigni
 *
 */
public class CObbScala extends CObb{
	
	private final Colore colore;//contiene il colore delle carte con cui
	   //realizzare lo schema
	/**
	 * direzione conterr� true se la diagonale sar� crescente quindi da basso (sx)
	 * ad alto (dx) --> /
	 * altrimenti false se la diagonale sar� decrescente quindi da alto (sx)
	 * a basso (dx) --> \
	 */
	private final boolean direzione;
	
	public CObbScala(int puntiAssegnati, Colore colore, 
			boolean direzione) {
		super(puntiAssegnati);
		this.colore=colore;
		this.direzione=direzione;
		// TODO Auto-generated constructor stub
	}

	public Colore getColore() {
		return colore;
	}

	public boolean getDirezione() {
		return direzione;
	}
	

}
