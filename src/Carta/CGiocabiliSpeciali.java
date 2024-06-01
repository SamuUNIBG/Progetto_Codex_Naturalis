package Carta;

import Eccezioni.IdCartaException;
import Eccezioni.PuntiAssegnatiException;
import Enumerazione.Colore;
import Enumerazione.Simbolo;
//classe astratta i cui metodi saranno implentati dalle carte risorsa oro e obiettivo
public abstract class CGiocabiliSpeciali extends CGiocabili {

	private final Simbolo simbolo;
	private final Colore colore;
	private boolean contataScala; //x capire se la carta e stata contata x obiettivo scala
	private boolean contataL; //x capire se la carta e stata contata x obiettivo L
	
	/**
	 * @param puntiAssegnati
	 * @param simbolo
	 * @param colore
	 * @param fronte
	 * @param angolo0 alto sx
	 * @param angolo1 alto dx
	 * @param angolo2 basso dx
	 * @param angolo3 basso sx
	 * @param idCarta
	 * @throws IdCartaException quando id < 0
	 * @throws PuntiAssegnatiException qaundo !(0 <= PuntiAssegnati <= 3) 
	 */
	public CGiocabiliSpeciali(int puntiAssegnati, Simbolo simbolo, Colore colore, boolean fronte,
			Simbolo angolo0, Simbolo angolo1, Simbolo angolo2, Simbolo angolo3, int idCarta) throws PuntiAssegnatiException, IdCartaException {
		super(puntiAssegnati, idCarta, angolo0, angolo1, angolo2, angolo3, fronte);
		this.simbolo = simbolo;
		this.colore = colore;
		this.contataScala=false;
		this.contataL=false;
		
	}
	/** per ottenere il simbolo della carta
	 * @return Simbolo simbolo
	 */
	public Simbolo getSimbolo() {
		return simbolo;
	}
	/** per ottenere il colore della carta
	 * @return Colore colore
	 */
	public Colore getColore() {
		return colore;
	}
	/** per capire se la carta e stata contata per l'obiettivo scala
	 * @return boolean contaScala
	 */
	public boolean isContataScala() {
		return contataScala;
	}
	/** setta true se la carta e stata contata per l'obiettivo scala
	 *
	 */
	public void setContataScala() {
		this.contataScala=true;
	}
	/** per capire se la carta e stata contata per l'obiettivo L
	 * @return boolean contaL
	 */
	public boolean isContataL() {
		return contataL;
		
	}
	/** setta true se la carta e stata contata per l'obiettivo L
	 *
	 */
	public void setContataL() {
		this.contataL=true;
	}
	
}
