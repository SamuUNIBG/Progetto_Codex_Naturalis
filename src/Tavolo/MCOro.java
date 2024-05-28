package Tavolo;

import java.util.ArrayList;
import java.util.Collections;

import Carta.COro;
import Enumerazione.Colore;
import Enumerazione.Simbolo;

public class MCOro extends Mazzo {
	
	private ArrayList<COro> cMazzo;
	
	/**
	 * Instantiate all the gold cards and shuffles them
	 */
	public MCOro() {
		cMazzo=new ArrayList<COro>(40);
		//sky blue
		cMazzo.add(new COro(1, Simbolo.INCHIOSTRO, Simbolo.LUPO, Colore.AZZURRO, Simbolo.INCHIOSTRO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 0, 2, 0, 1));	//2 LUPO, 1 FARFALLA
		cMazzo.add(new COro(1, Simbolo.PERGAMENA, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PERGAMENA, Simbolo.VUOTO, 1, 2, 0, 0));	//2 LUPO, 1 FOGlIA
		cMazzo.add(new COro(1, Simbolo.PIUMA, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PIUMA, 0, 2, 1, 0));	//2 LUPO, 1 FUNGO
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, 0, 3, 0, 1)); 	//3 LUPO, 1 FARFALLA
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, 0, 3, 1, 0));	//3 LUPO, 1 FUNGO
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, 1, 3, 0, 0));	//3 LUPO, 1 FOGLIA
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.PERGAMENA, 0, 3, 0, 0));	//3 LUPO
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.INCHIOSTRO, Simbolo.ASSENTE, Simbolo.ASSENTE, 0, 3, 0, 0));	//3 LUPO
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PIUMA, Simbolo.ASSENTE, 0, 3, 0, 0));	//3 LUPO
		cMazzo.add(new COro(5, Simbolo.ASSENTE, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, 0, 5, 0, 0));	//5 LUPO
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.INCHIOSTRO, Simbolo.ASSENTE, Simbolo.ASSENTE, 0, 3, 0, 0));	//3 LUPO		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PIUMA, Simbolo.ASSENTE, 0, 3, 0, 0));	//3 LUPO
		cMazzo.add(new COro(5, Simbolo.ASSENTE, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, 0, 5, 0, 0));	//5 LUPO
		//green
		cMazzo.add(new COro(1, Simbolo.PIUMA, Simbolo.FOGLIA, Colore.VERDE, Simbolo.PIUMA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 2, 0, 0, 1));	//2 FOGLIA, 1 FARFALLA
		cMazzo.add(new COro(1, Simbolo.PERGAMENA, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.PERGAMENA, Simbolo.VUOTO, Simbolo.ASSENTE, 2, 0, 1, 0));	//2 FOLGIA, 1 FUNGO
		cMazzo.add(new COro(1, Simbolo.INCHIOSTRO, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.INCHIOSTRO, 2, 1, 0, 0));	//2 FOGLIA, 1 LUPO
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, 3, 0, 0, 1));	//3 FOGLIA, 1 FARFALLA
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 3, 1, 0, 0));	//3 FOGLIE, 1 LUPO
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, 3, 0, 1, 0));	//3 FOGLIA, 1 FUNGO
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.PIUMA, 3, 0, 0, 0));	//3 FOGLIA
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.FOGLIA, Colore.VERDE, Simbolo.PERGAMENA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, 3, 0, 0, 0));	//3 FOGLIA
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.INCHIOSTRO, Simbolo.VUOTO, Simbolo.ASSENTE, 3, 0, 0, 0));	//3 FOGLIE
		cMazzo.add(new COro(5, Simbolo.ASSENTE, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, 5, 0, 0, 0));	//5 fOGLIA
		//purple
		cMazzo.add(new COro(1, Simbolo.PIUMA, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.PIUMA, Simbolo.VUOTO, Simbolo.ASSENTE, 1, 0, 0, 2));	//2 FARFALLA, 1 FOLGIA
		cMazzo.add(new COro(1, Simbolo.PERGAMENA, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PERGAMENA, 0, 1, 0, 2));	//2 FARFALLE, 1 LUPO
		cMazzo.add(new COro(1, Simbolo.INCHIOSTRO, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.INCHIOSTRO, Simbolo.VUOTO, 0, 0, 1, 2));	//2 FARFALLA, 1 FUNGO
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, 0, 1, 0, 3));	//3 FARFALLA, 1 LUPO
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 1, 0, 0, 3));	//3 FARFALLA, 1 FOGLIA
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, 0, 0, 1, 3));	//3 FARFALLA, 1 FUNGO
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.INCHIOSTRO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.VUOTO, 0, 0, 0, 3));	//3 FARFALLA/		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.PERGAMENA, Simbolo.ASSENTE, Simbolo.ASSENTE, 0, 0, 0, 3));	//3 FARFALLA
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PIUMA, 0, 0, 0, 3));	//3 FARFALLA
		cMazzo.add(new COro(5, Simbolo.ASSENTE, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, 0, 0, 0, 5));	//5 FARFALLA
		//red
		cMazzo.add(new COro(1, Simbolo.PIUMA, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PIUMA, Simbolo.VUOTO, 0, 1, 2, 0));	//2 FUNGO, 1 LUPO
		cMazzo.add(new COro(1, Simbolo.INCHIOSTRO, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.INCHIOSTRO, Simbolo.VUOTO, Simbolo.ASSENTE, 1, 0, 2, 0));	//2 FUNGO, 1 FOLGIA
		cMazzo.add(new COro(1, Simbolo.PERGAMENA, Simbolo.FUNGO, Colore.ROSSO, Simbolo.PERGAMENA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 0, 0, 2, 1));	//2 FUNGO, 1 FARFALLA
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, 0, 1, 3, 0));	//3 FUNGO, 1 LUPO
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 1, 0, 3, 0));	//3 FUNGHI, 1 FOLGIA
		cMazzo.add(new COro(2, Simbolo.ANGOLO, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, 0, 0, 3, 1));	//3 FUNGO, 1 FARFALLA
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.INCHIOSTRO, 0, 0, 3, 0));	//3 FUNGO
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.FUNGO, Colore.ROSSO, Simbolo.PIUMA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, 0, 0, 3, 0));	//3 FUNGO
		cMazzo.add(new COro(3, Simbolo.ASSENTE, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.PERGAMENA, Simbolo.VUOTO, Simbolo.ASSENTE, 0, 0, 3, 0));	//3 FUNGO
		cMazzo.add(new COro(5, Simbolo.ASSENTE, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.VUOTO, 0, 0, 5, 0));	//5 FUNGO*/
		
		Collections.shuffle(cMazzo);
	}
	
	@Override
	public COro pesca() {
		if(this.getCRimaste()!=0) {
			COro carta = cMazzo.get(0);
			cMazzo.remove(0);
			return carta;
		}else
			return null;
	} 

	@Override
	public int getCRimaste() {
		return cMazzo.size();
	}
	
	public ArrayList<COro> getCMazzo() {
		return cMazzo;
	}
}
