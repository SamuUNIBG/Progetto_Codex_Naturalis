package Carta;
import java.util.*;
import Enumerazione.*;

/**
 * @author Oscar Benigni
 *
 */
public abstract class Carta {
	
	private final int puntiAssegnati; //le carte hanno punti
	
	public Carta(int puntiAssegnati) {
		this.puntiAssegnati=puntiAssegnati;
	}
	
	/**
	 * sara poi usato dalle sottoclassi per ottenere informazioni
	 * sui punti delle rispettive carte
	 * @return
	 */
	public int getPunti() {  
		return this.puntiAssegnati;
	}
}
