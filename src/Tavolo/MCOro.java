package Tavolo;

import java.util.ArrayList;
import java.util.Collections;

import Carta.COro;
import Enumerazione.Colore;
import Enumerazione.Simbolo;

/**
 * @author Samuele Vecchi
 *
 */
public class MCOro extends Mazzo {
	
	private ArrayList<COro> cMazzo;
	//gold card instances
	private COro cOro0, cOro1, cOro2, cOro3, cOro4, cOro5, cOro6, cOro7, cOro8, cOro9;
	private COro cOro10, cOro11, cOro12, cOro13, cOro14, cOro15, cOro16, cOro17, cOro18, cOro19;
	private COro cOro20, cOro21, cOro22, cOro23, cOro24, cOro25, cOro26, cOro27, cOro28, cOro29;
	private COro cOro30, cOro31, cOro32, cOro33, cOro34, cOro35, cOro36, cOro37, cOro38, cOro39;
	
	/**
	 * Instantiate all the gold cards and shuffles them
	 */
	public MCOro() {
		cMazzo=new ArrayList<COro>(40);
		//red
		cMazzo.add(cOro0 = new COro(1, Simbolo.PIUMA, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PIUMA, Simbolo.VUOTO, 0, 1, 2, 0));	//2 FUNGO, 1 LUPO
		cMazzo.add(cOro1 = new COro(1, Simbolo.INCHIOSTRO, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.INCHIOSTRO, Simbolo.VUOTO, Simbolo.ASSENTE, 1, 0, 2, 0));	//2 FUNGO, 1 FOLGIA
		cMazzo.add(cOro2 = new COro(1, Simbolo.PERGAMENA, Simbolo.FUNGO, Colore.ROSSO, Simbolo.PERGAMENA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 0, 0, 2, 1));	//2 FUNGO, 1 FARFALLA
		cMazzo.add(cOro3 = new COro(2, Simbolo.ANGOLO, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, 0, 1, 3, 0));	//3 FUNGO, 1 LUPO
		cMazzo.add(cOro4 = new COro(2, Simbolo.ANGOLO, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 1, 0, 3, 0));	//3 FUNGHI, 1 FOLGIA
		cMazzo.add(cOro5 = new COro(2, Simbolo.ANGOLO, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, 0, 0, 3, 1));	//3 FUNGO, 1 FARFALLA
		cMazzo.add(cOro6 = new COro(3, Simbolo.ASSENTE, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.INCHIOSTRO, 0, 0, 3, 0));	//3 FUNGO
		cMazzo.add(cOro7 = new COro(3, Simbolo.ASSENTE, Simbolo.FUNGO, Colore.ROSSO, Simbolo.PIUMA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, 0, 0, 3, 0));	//3 FUNGO
		cMazzo.add(cOro8 = new COro(3, Simbolo.ASSENTE, Simbolo.FUNGO, Colore.ROSSO, Simbolo.ASSENTE, Simbolo.PERGAMENA, Simbolo.VUOTO, Simbolo.ASSENTE, 0, 0, 3, 0));	//3 FUNGO
		cMazzo.add(cOro9 = new COro(5, Simbolo.ASSENTE, Simbolo.FUNGO, Colore.ROSSO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.VUOTO, 0, 0, 5, 0));	//5 FUNGO
		//sky blue
		cMazzo.add(cOro10 = new COro(1, Simbolo.INCHIOSTRO, Simbolo.LUPO, Colore.AZZURRO, Simbolo.INCHIOSTRO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 0, 2, 0, 1));	//2 LUPO, 1 FARFALLA
		cMazzo.add(cOro11 = new COro(1, Simbolo.PERGAMENA, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PERGAMENA, Simbolo.VUOTO, 1, 2, 0, 0));	//2 LUPO, 1 FOGlIA
		cMazzo.add(cOro12 = new COro(1, Simbolo.PIUMA, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PIUMA, 0, 2, 1, 0));	//2 LUPO, 1 FUNGO
		cMazzo.add(cOro13 = new COro(2, Simbolo.ANGOLO, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, 0, 3, 0, 1)); 	//3 LUPO, 1 FARFALLA
		cMazzo.add(cOro14 = new COro(2, Simbolo.ANGOLO, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, 0, 3, 1, 0));	//3 LUPO, 1 FUNGO
		cMazzo.add(cOro15 = new COro(2, Simbolo.ANGOLO, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, 1, 3, 0, 0));	//3 LUPO, 1 FOGLIA
		cMazzo.add(cOro16 = new COro(3, Simbolo.ASSENTE, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.PERGAMENA, 0, 3, 0, 0));	//3 LUPO
		cMazzo.add(cOro17 = new COro(3, Simbolo.ASSENTE, Simbolo.LUPO, Colore.AZZURRO, Simbolo.VUOTO, Simbolo.INCHIOSTRO, Simbolo.ASSENTE, Simbolo.ASSENTE, 0, 3, 0, 0));	//3 LUPO
		cMazzo.add(cOro18 = new COro(3, Simbolo.ASSENTE, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PIUMA, Simbolo.ASSENTE, 0, 3, 0, 0));	//3 LUPO
		cMazzo.add(cOro19 = new COro(5, Simbolo.ASSENTE, Simbolo.LUPO, Colore.AZZURRO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, 0, 5, 0, 0));	//5 LUPO
		//green
		cMazzo.add(cOro20 = new COro(1, Simbolo.PIUMA, Simbolo.FOGLIA, Colore.VERDE, Simbolo.PIUMA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 2, 0, 0, 1));	//2 FOGLIA, 1 FARFALLA
		cMazzo.add(cOro21 = new COro(1, Simbolo.PERGAMENA, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.PERGAMENA, Simbolo.VUOTO, Simbolo.ASSENTE, 2, 0, 1, 0));	//2 FOLGIA, 1 FUNGO
		cMazzo.add(cOro22 = new COro(1, Simbolo.INCHIOSTRO, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.INCHIOSTRO, 2, 1, 0, 0));	//2 FOGLIA, 1 LUPO
		cMazzo.add(cOro23 = new COro(2, Simbolo.ANGOLO, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, 3, 0, 0, 1));	//3 FOGLIA, 1 FARFALLA
		cMazzo.add(cOro24 = new COro(2, Simbolo.ANGOLO, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 3, 1, 0, 0));	//3 FOGLIE, 1 LUPO
		cMazzo.add(cOro25 = new COro(2, Simbolo.ANGOLO, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, 3, 0, 1, 0));	//3 FOGLIA, 1 FUNGO
		cMazzo.add(cOro26 = new COro(3, Simbolo.ASSENTE, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.PIUMA, 3, 0, 0, 0));	//3 FOGLIA
		cMazzo.add(cOro27 = new COro(3, Simbolo.ASSENTE, Simbolo.FOGLIA, Colore.VERDE, Simbolo.PERGAMENA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, 3, 0, 0, 0));	//3 FOGLIA
		cMazzo.add(cOro28 = new COro(3, Simbolo.ASSENTE, Simbolo.FOGLIA, Colore.VERDE, Simbolo.ASSENTE, Simbolo.INCHIOSTRO, Simbolo.VUOTO, Simbolo.ASSENTE, 3, 0, 0, 0));	//3 FOGLIE
		cMazzo.add(cOro29 = new COro(5, Simbolo.ASSENTE, Simbolo.FOGLIA, Colore.VERDE, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, 5, 0, 0, 0));	//5 fOGLIA
		//purple
		cMazzo.add(cOro30 = new COro(1, Simbolo.PIUMA, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.PIUMA, Simbolo.VUOTO, Simbolo.ASSENTE, 1, 0, 0, 2));	//2 FARFALLA, 1 FOLGIA
		cMazzo.add(cOro31 = new COro(1, Simbolo.PERGAMENA, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PERGAMENA, 0, 1, 0, 2));	//2 FARFALLE, 1 LUPO
		cMazzo.add(cOro32 = new COro(1, Simbolo.INCHIOSTRO, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.INCHIOSTRO, Simbolo.VUOTO, 0, 0, 1, 2));	//2 FARFALLA, 1 FUNGO
		cMazzo.add(cOro33 = new COro(2, Simbolo.ANGOLO, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, 0, 1, 0, 3));	//3 FARFALLA, 1 LUPO
		cMazzo.add(cOro34 = new COro(2, Simbolo.ANGOLO, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, 1, 0, 0, 3));	//3 FARFALLA, 1 FOGLIA
		cMazzo.add(cOro35 = new COro(2, Simbolo.ANGOLO, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.VUOTO, 0, 0, 1, 3));	//3 FARFALLA, 1 FUNGO
		cMazzo.add(cOro36 = new COro(3, Simbolo.ASSENTE, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.INCHIOSTRO, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.VUOTO, 0, 0, 0, 3));	//3 FARFALLA
		cMazzo.add(cOro37 = new COro(3, Simbolo.ASSENTE, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.PERGAMENA, Simbolo.ASSENTE, Simbolo.ASSENTE, 0, 0, 0, 3));	//3 FARFALLA
		cMazzo.add(cOro38 = new COro(3, Simbolo.ASSENTE, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.ASSENTE, Simbolo.ASSENTE, Simbolo.VUOTO, Simbolo.PIUMA, 0, 0, 0, 3));	//3 FARFALLA
		cMazzo.add(cOro39 = new COro(5, Simbolo.ASSENTE, Simbolo.FARFALLA, Colore.VIOLA, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.ASSENTE, Simbolo.ASSENTE, 0, 0, 0, 5));	//5 FARFALLA
				
		Collections.shuffle(cMazzo);
	}
	
	@Override
	public COro pesca() {
		COro carta = cMazzo.get(0);
		cMazzo.remove(0);
		return carta;
	} 

	@Override
	public int getCRimaste() {
		return cMazzo.size();
	}
	
}
