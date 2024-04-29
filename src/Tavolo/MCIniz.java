package Tavolo;

import java.util.ArrayList;
import java.util.Collections;

import Carta.CIniz;

import Enumerazione.Simbolo;

/**
 * @author Samuele Vecchi
 *
 */
public class MCIniz extends Mazzo {

	private ArrayList<CIniz> cMazzo;
	//initial card instances
	private CIniz CIniz0, CIniz1, CIniz2, CIniz3, CIniz4, CIniz5;
	
	/**
	 * Instantiate all the starter cards and shuffles them
	 */
	public MCIniz() {	//4 front corners, 3 resource, 4 back corners,
		cMazzo = new ArrayList<CIniz>(6);
		
		cMazzo.add(CIniz0 = new CIniz(Simbolo.VUOTO, Simbolo.FOGLIA, Simbolo.VUOTO, Simbolo.FARFALLA, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.FUNGO, Simbolo.FOGLIA, Simbolo.LUPO, Simbolo.FARFALLA));
		cMazzo.add(CIniz1 = new CIniz(Simbolo.LUPO, Simbolo.VUOTO, Simbolo.FUNGO, Simbolo.VUOTO, Simbolo.FUNGO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.LUPO, Simbolo.FARFALLA, Simbolo.FUNGO));
		cMazzo.add(CIniz2 = new CIniz(Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.FOGLIA, Simbolo.FUNGO, Simbolo.ASSENTE, Simbolo.FARFALLA, Simbolo.LUPO, Simbolo.FOGLIA, Simbolo.FUNGO));
		cMazzo.add(CIniz3 = new CIniz(Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.LUPO, Simbolo.FARFALLA, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.FARFALLA, Simbolo.FUNGO, Simbolo.LUPO));
		cMazzo.add(CIniz4 = new CIniz(Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.LUPO, Simbolo.FARFALLA, Simbolo.FOGLIA, Simbolo.FARFALLA, Simbolo.FUNGO, Simbolo.LUPO, Simbolo.FOGLIA));
		cMazzo.add(CIniz5 = new CIniz(Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.FOGLIA, Simbolo.LUPO, Simbolo.FUNGO, Simbolo.FUNGO, Simbolo.LUPO, Simbolo.FARFALLA, Simbolo.FOGLIA));
		
		
		
		
		
		Collections.shuffle(cMazzo);
	}

	@Override
	public CIniz pesca() {
		CIniz carta = cMazzo.get(0);
		cMazzo.remove(0);
		return carta;
	} 

	@Override
	public int getCRimaste() {
		return cMazzo.size();
	}
	
}
