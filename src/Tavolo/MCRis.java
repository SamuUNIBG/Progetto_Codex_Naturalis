package Tavolo;

import java.util.ArrayList;
import java.util.Collections;

import Carta.CRis;
import Enumerazione.Colore;
import Enumerazione.Simbolo;

public class MCRis extends Mazzo {
	
	private ArrayList<CRis> cMazzo;
	
	/**
	 * Instantiate all the resource cards and shuffles them
	 */
	public MCRis() {
		cMazzo=new ArrayList<CRis>(40);
		//sky blue
		cMazzo.add(new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.LUPO, Simbolo.LUPO, Simbolo.ASSENTE, Simbolo.VUOTO));
		cMazzo.add(new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.LUPO, Simbolo.LUPO));
		cMazzo.add(new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.LUPO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.LUPO));
		cMazzo.add(new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.LUPO, Simbolo.LUPO, Simbolo.ASSENTE));
		cMazzo.add(new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.FARFALLA, Simbolo.LUPO, Simbolo.INCHIOSTRO));
		cMazzo.add(new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.FOGLIA, Simbolo.LUPO, Simbolo.PERGAMENA, Simbolo.ASSENTE));
		cMazzo.add(new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.PIUMA, Simbolo.ASSENTE, Simbolo.FUNGO, Simbolo.LUPO));
		cMazzo.add(new CRis(1, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.LUPO));
		cMazzo.add(new CRis(1, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.LUPO, Simbolo.VUOTO));
		cMazzo.add(new CRis(1, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.LUPO, Simbolo.ASSENTE, Simbolo.VUOTO));
		//green
		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.FOGLIA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FOGLIA));

//		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.FOGLIA, Simbolo.FOGLIA, Simbolo.VUOTO, Simbolo.ASSENTE));
//		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.FOGLIA));
//		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.FOGLIA, Simbolo.VUOTO));
//		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.FARFALLA, Simbolo.FOGLIA, Simbolo.PIUMA));
//		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.FUNGO, Simbolo.FOGLIA, Simbolo.INCHIOSTRO, Simbolo.ASSENTE));
//		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.PERGAMENA, Simbolo.ASSENTE, Simbolo.LUPO, Simbolo.FOGLIA));
//		cMazzo.add(new CRis(1, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FOGLIA));
//		cMazzo.add(new CRis(1, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.FOGLIA, Simbolo.ASSENTE));
//		cMazzo.add(new CRis(1, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.VUOTO, Simbolo.VUOTO));
//		//purple
//		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.VUOTO));
//		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.FARFALLA, Simbolo.FARFALLA));
//		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.FARFALLA));
//		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.FARFALLA, Simbolo.FARFALLA, Simbolo.ASSENTE));
//		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.PIUMA, Simbolo.FARFALLA, Simbolo.LUPO));
//		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.PERGAMENA, Simbolo.FARFALLA, Simbolo.FUNGO, Simbolo.ASSENTE));
//		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.FOGLIA, Simbolo.ASSENTE, Simbolo.INCHIOSTRO));
//		cMazzo.add(new CRis(1, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO));
//		cMazzo.add(new CRis(1, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.FARFALLA, Simbolo.ASSENTE));
//		cMazzo.add(new CRis(1, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.FARFALLA, Simbolo.VUOTO, Simbolo.VUOTO));
//		//red
//		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FUNGO));
//		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.FUNGO, Simbolo.VUOTO, Simbolo.ASSENTE));
//		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FUNGO, Simbolo.FUNGO));
//		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.FUNGO, Simbolo.FUNGO, Simbolo.VUOTO));
//		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.PIUMA, Simbolo.FUNGO, Simbolo.FOGLIA));
//		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.INCHIOSTRO, Simbolo.FUNGO, Simbolo.LUPO, Simbolo.ASSENTE));
//		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.FARFALLA, Simbolo.VUOTO, Simbolo.PERGAMENA));
//		cMazzo.add(new CRis(1, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.FUNGO, Simbolo.ASSENTE, Simbolo.VUOTO));
//		cMazzo.add(new CRis(1, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO));
//		cMazzo.add(new CRis(1, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.FUNGO));

		/*cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.FOGLIA, Simbolo.FOGLIA, Simbolo.VUOTO, Simbolo.ASSENTE));
		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.FOGLIA));
		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.FOGLIA, Simbolo.VUOTO));
		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.FARFALLA, Simbolo.FOGLIA, Simbolo.PIUMA));
		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.FUNGO, Simbolo.FOGLIA, Simbolo.INCHIOSTRO, Simbolo.ASSENTE));
		cMazzo.add(new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.PERGAMENA, Simbolo.ASSENTE, Simbolo.LUPO, Simbolo.FOGLIA));
		cMazzo.add(new CRis(1, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FOGLIA));
		cMazzo.add(new CRis(1, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.FOGLIA, Simbolo.ASSENTE));
		cMazzo.add(new CRis(1, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.VUOTO, Simbolo.VUOTO));
		//purple
		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.VUOTO));
		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.FARFALLA, Simbolo.FARFALLA));
		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.FARFALLA));
		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.FARFALLA, Simbolo.FARFALLA, Simbolo.ASSENTE));
		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.PIUMA, Simbolo.FARFALLA, Simbolo.LUPO));
		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.PERGAMENA, Simbolo.FARFALLA, Simbolo.FUNGO, Simbolo.ASSENTE));
		cMazzo.add(new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.FOGLIA, Simbolo.ASSENTE, Simbolo.INCHIOSTRO));
		cMazzo.add(new CRis(1, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO));
		cMazzo.add(new CRis(1, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.FARFALLA, Simbolo.ASSENTE));
		cMazzo.add(new CRis(1, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.FARFALLA, Simbolo.VUOTO, Simbolo.VUOTO));
		//red
		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FUNGO));
		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.FUNGO, Simbolo.VUOTO, Simbolo.ASSENTE));
		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FUNGO, Simbolo.FUNGO));
		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.FUNGO, Simbolo.FUNGO, Simbolo.VUOTO));
		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.PIUMA, Simbolo.FUNGO, Simbolo.FOGLIA));
		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.INCHIOSTRO, Simbolo.FUNGO, Simbolo.LUPO, Simbolo.ASSENTE));
		cMazzo.add(new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.FARFALLA, Simbolo.VUOTO, Simbolo.PERGAMENA));
		cMazzo.add(new CRis(1, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.FUNGO, Simbolo.ASSENTE, Simbolo.VUOTO));
		cMazzo.add(new CRis(1, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO));
		cMazzo.add(new CRis(1, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.FUNGO));*/

		
		Collections.shuffle(cMazzo);
	}
	
	@Override
	public CRis pesca() {
		if(this.getCRimaste()!=0) {
		CRis carta = cMazzo.get(0);
		cMazzo.remove(0);
		return carta;
		}else
			return null;
	} 

	@Override
	public int getCRimaste() {
		return cMazzo.size();
	}
	
	public ArrayList<CRis> getCMazzo() {
		return cMazzo;
	}
	
}
