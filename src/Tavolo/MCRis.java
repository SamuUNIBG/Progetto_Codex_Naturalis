package Tavolo;

import java.util.ArrayList;
import java.util.Collections;

import Carta.CRis;

import Enumerazione.Colore;
import Enumerazione.Simbolo;

/**
 * @author Samuele Vecchi
 *
 */
public class MCRis extends Mazzo {
	
	private ArrayList<CRis> cMazzo;
	//resource card instances
	private CRis CRis0, CRis1, CRis2, CRis3, CRis4, CRis5, CRis6, CRis7, CRis8, CRis9;
	private CRis CRis10, CRis11, CRis12, CRis13, CRis14, CRis15, CRis16, CRis17, CRis18, CRis19;
	private CRis CRis20, CRis21, CRis22, CRis23, CRis24, CRis25, CRis26, CRis27, CRis28, CRis29;
	private CRis CRis30, CRis31, CRis32, CRis33, CRis34, CRis35, CRis36, CRis37, CRis38, CRis39;
	
	/**
	 * Instantiate all the resource cards and shuffles them
	 */
	public MCRis() {
		cMazzo=new ArrayList<CRis>(40);
		//red
		cMazzo.add(CRis0 = new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.FUNGO, Simbolo.FUNGO, Simbolo.VUOTO));
		cMazzo.add(CRis1 = new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.PERGAMENA));
		cMazzo.add(CRis2 = new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.INCHIOSTRO, Simbolo.FUNGO, Simbolo.LUPO, Simbolo.ASSENTE));
		cMazzo.add(CRis3 = new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FUNGO));
		cMazzo.add(CRis4 = new CRis(1, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO));
		cMazzo.add(CRis5 = new CRis(1, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.FUNGO, Simbolo.ASSENTE, Simbolo.VUOTO));
		cMazzo.add(CRis6 = new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.FUNGO, Simbolo.FUNGO, Simbolo.VUOTO, Simbolo.ASSENTE));
		cMazzo.add(CRis7 = new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.PIUMA, Simbolo.FUNGO, Simbolo.FOGLIA));
		cMazzo.add(CRis8 = new CRis(0, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FUNGO, Simbolo.FUNGO));
		cMazzo.add(CRis9 = new CRis(1, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.FUNGO));
		//sky blue
		cMazzo.add(CRis10 = new CRis(1, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.LUPO));
		cMazzo.add(CRis11 = new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.FOGLIA, Simbolo.LUPO, Simbolo.PERGAMENA, Simbolo.ASSENTE));
		cMazzo.add(CRis12 = new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.LUPO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.LUPO));
		cMazzo.add(CRis13 = new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.FARFALLA, Simbolo.LUPO, Simbolo.INCHIOSTRO));
		cMazzo.add(CRis14 = new CRis(1, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.LUPO, Simbolo.ASSENTE, Simbolo.VUOTO));
		cMazzo.add(CRis15 = new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.LUPO, Simbolo.LUPO, Simbolo.ASSENTE));
		cMazzo.add(CRis16 = new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.PIUMA, Simbolo.ASSENTE, Simbolo.FUNGO, Simbolo.LUPO));
		cMazzo.add(CRis17 = new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.LUPO, Simbolo.LUPO, Simbolo.ASSENTE, Simbolo.VUOTO));
		cMazzo.add(CRis18 = new CRis(0, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.LUPO, Simbolo.LUPO));
		cMazzo.add(CRis19 = new CRis(1, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.LUPO, Simbolo.VUOTO));
		//green
		cMazzo.add(CRis20 = new CRis(1, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FOGLIA));
		cMazzo.add(CRis21 = new CRis(1, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.VUOTO, Simbolo.VUOTO));
		cMazzo.add(CRis22 = new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.FOGLIA, Simbolo.FOGLIA, Simbolo.VUOTO, Simbolo.ASSENTE));
		cMazzo.add(CRis23 = new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.FOGLIA));
		cMazzo.add(CRis24 = new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.FARFALLA, Simbolo.FOGLIA, Simbolo.PIUMA));
		cMazzo.add(CRis25 = new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.FOGLIA, Simbolo.VUOTO));
		cMazzo.add(CRis26 = new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.PERGAMENA, Simbolo.ASSENTE, Simbolo.LUPO, Simbolo.FOGLIA));
		cMazzo.add(CRis27 = new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.FOGLIA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.FOGLIA));
		cMazzo.add(CRis28 = new CRis(1, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.FOGLIA, Simbolo.ASSENTE));
		cMazzo.add(CRis29 = new CRis(0, Simbolo.FOGLIA, Colore.VERDE, Simbolo.FUNGO, Simbolo.FOGLIA, Simbolo.INCHIOSTRO, Simbolo.ASSENTE));
		//purple
		cMazzo.add(CRis30 = new CRis(1, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.FARFALLA, Simbolo.ASSENTE));
		cMazzo.add(CRis31 = new CRis(1, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.FARFALLA, Simbolo.VUOTO, Simbolo.VUOTO));
		cMazzo.add(CRis32 = new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.FARFALLA));
		cMazzo.add(CRis33 = new CRis(1, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO));
		cMazzo.add(CRis34 = new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.VUOTO));
		cMazzo.add(CRis35 = new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.FARFALLA, Simbolo.FARFALLA));
		cMazzo.add(CRis36 = new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.PERGAMENA, Simbolo.FARFALLA, Simbolo.FUNGO, Simbolo.ASSENTE));
		cMazzo.add(CRis37 = new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.FARFALLA, Simbolo.FARFALLA, Simbolo.ASSENTE));
		cMazzo.add(CRis38 = new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.FARFALLA, Simbolo.FOGLIA, Simbolo.ASSENTE, Simbolo.INCHIOSTRO));
		cMazzo.add(CRis39 = new CRis(0, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.PIUMA, Simbolo.FARFALLA, Simbolo.LUPO));
		
		Collections.shuffle(cMazzo);
	}
	
	@Override
	public CRis pesca() {
		CRis carta = cMazzo.get(0);
		cMazzo.remove(0);
		return carta;
	} 

	@Override
	public int getCRimaste() {
		return cMazzo.size();
	}
	
}
