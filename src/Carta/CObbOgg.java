package Carta;
import java.util.*;

import Enumerazione.Colore;
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
	public CObbOgg(int puntiAssegnati, Simbolo oggetto1,
			Simbolo oggetto2, Simbolo oggetto3) {
		super(puntiAssegnati);
		oggetti = new ArrayList<Simbolo>();
		this.oggetti.add(oggetto1);
		if (oggetto2!=Simbolo.ASSENTE) {
			this.oggetti.add(oggetto2);
		}
		if (oggetto3!=Simbolo.ASSENTE) {
			this.oggetti.add(oggetto3);
		}
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Simbolo> getOggetti() {
		return oggetti;
	}
	@Override
	public int calcolaObb(Giocatore giocatore) {
		// TODO Auto-generated method stub
		if(this.oggetti.size()==2){ 
			/*vuol dire che l obiettivo richiede una
			coppia di oggetti identici*/
			switch(this.oggetti.get(0)) { //l ogg in pos 0 e lo stesso di pos 1
			case INCHIOSTRO:
				return (this.getPunti())*(giocatore.getOggPosseduti()[0]/2);
			case PERGAMENA:
				return (this.getPunti())*(giocatore.getOggPosseduti()[1]/2);
			case PIUMA:
				return (this.getPunti())*(giocatore.getOggPosseduti()[2]/2);
			}
		}
		if (this.oggetti.size()==3) {
			/*vuol dire che l obiettivo richiede un set
			di tre oggetti tutti diversi*/
			if(giocatore.getOggPosseduti()[0]==giocatore.getOggPosseduti()[1]
				&& giocatore.getOggPosseduti()[0]==giocatore.getOggPosseduti()[2]
				&& giocatore.getOggPosseduti()[1]==giocatore.getOggPosseduti()[2]){
				return (this.getPunti())*(giocatore.getOggPosseduti()[0]);
				/* il giocatore possiede lo stesso numero dei 3 oggetti
				 * quindi otterra i punti della carta per il numero di oggetti*/
			}
			else {
				/* il giocatore non possiede lo stesso numero dei 3 oggetti
				 * quindi otterra i punti della carta per il numero di oggetti
				 * minore quindi quelli che possiede meno che se sono 0 allora
				 * come e giusto non ottera alcun punto*/
				int min=giocatore.getOggPosseduti()[0];
				for(int i=1; i<3; i++) {
					if(giocatore.getOggPosseduti()[i]<min) {
						min=giocatore.getOggPosseduti()[i];
					}
				}
				/*alla fine min conterra l oggetto che il giocatore 
				 * possiede in minor numero rispetto agli altri oggetti*/
				return (this.getPunti())*min;
			}
		}
		return 0;
	}
	@Override
	public int getIDCARTA() {
		// TODO Auto-generated method stub
		return 0;
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
	
	public String toString() {
		String str = "Carata obbiettivo oggetti " /*+ IDCARTA*/ +
				":\n\t\t[" + super.toString();
		switch(oggetti.size()) {
			case 1:
				str += "\n\t\t Obbiettivo -> Formare coppie di -> " + oggetti.get(0);
				break;
			case 3:
				str += "\n\t\t Obbiettivo -> Formare tris di -> " + oggetti.get(0) +
				"\n\t\t\t\t\t\t" + oggetti.get(1) +
				"\n\t\t\t\t\t\t" + oggetti.get(2);
				break;
		}
			
		return str +=  "]";
		
	}
	@Override
	public boolean getFronte() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
