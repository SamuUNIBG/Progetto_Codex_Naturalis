package Carta;

import java.util.*;

import Eccezioni.IdCartaException;
import Eccezioni.PuntiAssegnatiException;
import Enumerazione.Simbolo;
import Tavolo.Giocatore;
/**
 * sono quel tipo di CARTE OBIETTIVO che presentano set di oggetti diversi
 * o coppie di oggetti identici,
 * da avere nell area di gioco al momento della conta finale dei punti per 
 * ottenere i punti segnati sulla stessa (sono punti cumulabili, per ogni set
 * o coppie di oggetti ottieni quei punti)
 */
public class CObbOgg extends CObb{
	private final ArrayList<Simbolo> oggetti;
	private static int LASTID=98;
	
	/**
	 * @param puntiAssegnati
	 * @param oggetto1
	 * @param oggetto2
	 * @param oggetto3
	 * @throws IdCartaException quando id < 0
	 * @throws PuntiAssegnatiException qaundo !(0 <= PuntiAssegnati <= 3) 
	 */
	public CObbOgg(int puntiAssegnati, Simbolo oggetto1, Simbolo oggetto2, Simbolo oggetto3) throws PuntiAssegnatiException, IdCartaException {
		super(puntiAssegnati, CObbOgg.LASTID);
		oggetti = new ArrayList<Simbolo>();
		this.oggetti.add(oggetto1);
		if (oggetto2!=Simbolo.ASSENTE) {
			this.oggetti.add(oggetto2);
		}
		if (oggetto3!=Simbolo.ASSENTE) {
			this.oggetti.add(oggetto3);
		}
		CObbOgg.LASTID++;
	}
	/**
	 * ottenere gli oggetti da avere x realizzare l obiettivo
	 * @return il set di oggetti richiesti dalla carta
	 */
	public ArrayList<Simbolo> getOggetti() {
		return oggetti;
	}
	@Override
	/**
	 * calcola l obiettivo in base agli oggetti visibili che il giocatore
	 * possiede sul proprio campo di gioco confrontandoli con quelli
	 * richeisti dalla carta
	 * @return i punti della carta
	 */
	public void calcolaObb(Giocatore giocatore) {
		
		if(this.oggetti.size()==1){ 
			/*vuol dire che l obiettivo richiede una coppia di oggetti identici*/
			switch(this.oggetti.get(0)) { //l ogg in pos 0 e lo stesso di pos 1
				case INCHIOSTRO:
					giocatore.addPunteggio((this.getPunti())*(giocatore.getOggPosseduti()[0]/2));
					break;
				case PERGAMENA:
					giocatore.addPunteggio((this.getPunti())*(giocatore.getOggPosseduti()[1]/2));
					break;
				case PIUMA:
					giocatore.addPunteggio((this.getPunti())*(giocatore.getOggPosseduti()[2]/2));
					break;
				default:
					break;
			}
		}
		if (this.oggetti.size()==3) {
			/*vuol dire che l obiettivo richiede un set	di tre oggetti tutti diversi*/
			if(giocatore.getOggPosseduti()[0]==giocatore.getOggPosseduti()[1]
				&& giocatore.getOggPosseduti()[0]==giocatore.getOggPosseduti()[2]){
				giocatore.addPunteggio((this.getPunti())*(giocatore.getOggPosseduti()[0]));
				/* il giocatore possiede lo stesso numero dei 3 oggetti
				 * quindi otterra i punti della carta per il numero di oggetti*/
			}
			else {
				/* il giocatore non possiede lo stesso numero dei 3 oggetti
				 * quindi otterra i punti della carta per il numero di oggetti
				 * minore quindi quelli che possiede meno che se sono 0 allora
				 * come e giusto non ottera alcun punto*/
				int min=giocatore.getOggPosseduti()[0];
				for(int oggPosseduti: giocatore.getOggPosseduti()) {
					if(oggPosseduti<min) {
						min=oggPosseduti;
					}
				}
				/*alla fine min conterra l oggetto che il giocatore 
				 * possiede in minor numero rispetto agli altri oggetti*/
				giocatore.addPunteggio((this.getPunti())*min);
			}
		}
	}
	
	@Override
	public String toString() {
		String str = "Carta obbiettivo oggetti " + super.toString();
		
		switch(oggetti.size()) {
			case 1:
				str += "\n\t\t Obbiettivo -> Formare coppie di -> " + oggetti.get(0);
				break;
			case 3:
				str += "\n\t\t Obbiettivo -> Formare tris di -> " + oggetti.get(0) +
				"\n\t\t\t\t\t\t  " + oggetti.get(1) +
				"\n\t\t\t\t\t\t  " + oggetti.get(2);
				break;
		}
			
		return str +=  "]";
		
	}
	
	
}
