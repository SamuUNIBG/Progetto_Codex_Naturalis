package Carta;
import Enumerazione.Simbolo;
/**
 * sono quel tipo di CARTE OBIETTIVO che presentano le risorse (generalmente 3)
 * da avere nell area di gioco al momento della conta finale dei punti per 
 * ottenere i punti segnati sulla stessa (sono punti cumulabili, per ogni set di 
 * risorse ottieni quei punti)
 */

/**
 * @author Oscar Benigni
 *
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

}
