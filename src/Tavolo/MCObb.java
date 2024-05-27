package Tavolo;

import java.util.ArrayList;
import java.util.Collections;

import Carta.CObb;
import Carta.CObbL;
import Carta.CObbOgg;
import Carta.CObbRis;
import Carta.CObbScala;

import Enumerazione.Colore;
import Enumerazione.Simbolo;

public class MCObb extends Mazzo {
	
	private ArrayList<CObb> cMazzo;
	
	/**
	 * Instantiate all the objective cards and shuffles them
	 */
	public MCObb() {
		cMazzo=new ArrayList<CObb>(16);
		//scale
		cMazzo.add(new CObbScala(2, Colore.ROSSO, true));
		cMazzo.add(new CObbScala(2, Colore.VERDE, false));
		cMazzo.add(new CObbScala(2, Colore.AZZURRO, true));
		cMazzo.add(new CObbScala(2, Colore.VIOLA, false));
		//l															//the first color indicates the color of the two cards one under the other
		cMazzo.add(new CObbL(3, Colore.ROSSO, Colore.VERDE, 3));	//the green card is bottom right
		cMazzo.add(new CObbL(3, Colore.VERDE, Colore.VIOLA, 4));	//the purple card is bottom left
		cMazzo.add(new CObbL(3, Colore.AZZURRO, Colore.ROSSO, 2));	//the red card is upper right
		cMazzo.add(new CObbL(3, Colore.VIOLA, Colore.AZZURRO, 1));	//the sky blue card is upper left
		//three resources 
		cMazzo.add(new CObbRis(2, Simbolo.FUNGO));
		cMazzo.add(new CObbRis(2, Simbolo.FOGLIA));
		cMazzo.add(new CObbRis(2, Simbolo.LUPO));
		cMazzo.add(new CObbRis(2, Simbolo.FARFALLA));
		//two o three objects
		cMazzo.add(new CObbOgg(3, Simbolo.PIUMA, Simbolo.INCHIOSTRO, Simbolo.PERGAMENA));
		cMazzo.add(new CObbOgg(2, Simbolo.PERGAMENA, Simbolo.ASSENTE, Simbolo.ASSENTE));
		cMazzo.add(new CObbOgg(2, Simbolo.INCHIOSTRO, Simbolo.ASSENTE, Simbolo.ASSENTE));
		cMazzo.add(new CObbOgg(2, Simbolo.PIUMA, Simbolo.ASSENTE, Simbolo.ASSENTE));
		
	
		Collections.shuffle(cMazzo);
	}
	
	@Override
	public CObb pesca() {
		CObb carta = cMazzo.get(0);
		cMazzo.remove(0);
		return carta;
	} 

	@Override
	public int getCRimaste() {
		return cMazzo.size();
	}

}
