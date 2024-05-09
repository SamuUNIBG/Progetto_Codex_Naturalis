package Carta;

import Enumerazione.Simbolo;
// classe astratta i cui metodi saranno implementati dalle Carte iniziali 
public abstract class CGiocabili extends Carta {
	
	private boolean fronte;
	private final Angolo[] angoli = new Angolo[4];
	
	public CGiocabili(int puntiAssegnati, int idcarta, Simbolo angolo0, Simbolo angolo1, Simbolo angolo2, Simbolo angolo3, boolean fronte) {
		
		super(puntiAssegnati, idcarta);
		this.angoli[0] = new Angolo(angolo0);
		this.angoli[1] = new Angolo(angolo1);
		this.angoli[2] = new Angolo(angolo2);
		this.angoli[3] = new Angolo(angolo3);
		this.fronte = fronte;
		
	}
	/** setta a false l'attributo fronte della carta
	 * 
	 */
	public void retro() {
		this.fronte=false;
	}
	/** capire se una carte e di fronte (true) o di retro (false)
	 * @return boolean fronte
	 */
	public boolean getFronte() {
		return this.fronte;
	}
	/** torna l array di angoli della carta
	 * @return Angolo[] angoli
	 */

	public Angolo[] getAngoli() {
		return angoli;
	}
	
}
