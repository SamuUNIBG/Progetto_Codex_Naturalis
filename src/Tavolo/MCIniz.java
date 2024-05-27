package Tavolo;

import java.util.ArrayList;
import java.util.Collections;

import Carta.CIniz;

import Enumerazione.Simbolo;

public class MCIniz extends Mazzo {

	private ArrayList<CIniz> cMazzo;
	
	/**
	 * Instantiate all the starter cards and shuffles them
	 */
	public MCIniz() {	//4 front corners, 3 resource, 4 back corners,
		cMazzo = new ArrayList<CIniz>(6);
		
		cMazzo.add(new CIniz(Simbolo.VUOTO, Simbolo.FOGLIA, Simbolo.VUOTO, Simbolo.FARFALLA, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.FUNGO, Simbolo.FOGLIA, Simbolo.LUPO, Simbolo.FARFALLA));
		cMazzo.add(new CIniz(Simbolo.LUPO, Simbolo.VUOTO, Simbolo.FUNGO, Simbolo.VUOTO, Simbolo.FUNGO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.LUPO, Simbolo.FARFALLA, Simbolo.FUNGO));
		cMazzo.add(new CIniz(Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.FOGLIA, Simbolo.FUNGO, Simbolo.ASSENTE, Simbolo.FARFALLA, Simbolo.LUPO, Simbolo.FOGLIA, Simbolo.FUNGO));
		cMazzo.add(new CIniz(Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.LUPO, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.FARFALLA, Simbolo.FUNGO, Simbolo.LUPO));
		cMazzo.add(new CIniz(Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.LUPO, Simbolo.FARFALLA, Simbolo.FOGLIA, Simbolo.FARFALLA, Simbolo.FUNGO, Simbolo.LUPO, Simbolo.FOGLIA));
		cMazzo.add(new CIniz(Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.LUPO, Simbolo.FUNGO, Simbolo.FUNGO, Simbolo.LUPO, Simbolo.FARFALLA, Simbolo.FOGLIA));
				
		Collections.shuffle(cMazzo);
	}
	
	/**
	 * gestisce la pescata dal mazzo delle carte iniziali
	 */
	@Override
	public CIniz pesca() {
		CIniz carta = cMazzo.get(0);
		cMazzo.remove(0);
		return carta;
	}
	
	/**
	 * mostra quante carte ci sono nel mazzo
	 */
	@Override
	public int getCRimaste() {
		return cMazzo.size();
	}
	
}
