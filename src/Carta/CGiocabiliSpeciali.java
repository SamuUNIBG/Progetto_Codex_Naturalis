package Carta;

import Enumerazione.Colore;
import Enumerazione.Simbolo;
//classe astratta i cui metodi saranno implentati dalle carte risorsa oro e obiettivo
public abstract class CGiocabiliSpeciali extends CGiocabili {

	private final Simbolo simbolo;
	private final Colore colore;
	private boolean contataScala; //x capire se la carta e stata contata x obiettivo scala
	private boolean contataL; //x capire se la carta e stata contata x obiettivo L
	
	public CGiocabiliSpeciali(int puntiAssegnati, Simbolo simbolo, Colore colore, boolean fronte,
			Simbolo angolo0, Simbolo angolo1, Simbolo angolo2, Simbolo angolo3, int idCarta) {
		super(puntiAssegnati, idCarta, angolo0, angolo1, angolo2, angolo3, fronte);
		this.simbolo = simbolo;
		this.colore = colore;
		
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
	public void retro() {
		super.retro();
	}
	/** per capire se la carta e fronte o retro
	 * @return boolean fronte
	 */
	public boolean getFronte() {
		return super.getFronte();
	}
	/** per ottenere i 4 angoli della carta
	 * @return Angolo[] angoli
	 */
	public Angolo[] getAngoli() {
		return super.getAngoli();
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
	public void setContataScala(boolean contataScala) {
		contataL=true;
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
	public void setContataL(boolean contataL) {
		contataScala=true;
	}
	/** per ottenere l'id della carta
	 * @return int IdCarta
	 */
	public int getIdCarta() {
		return super.getIdCarta();
	}
	
	public abstract String toStringBreve();
	
}
