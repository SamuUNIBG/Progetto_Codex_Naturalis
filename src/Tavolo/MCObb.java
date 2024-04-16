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

/**
 * @author Samuele Vecchi
 *
 */
public class MCObb extends Mazzo {
	
	private ArrayList<CObb> cMazzo;
	//objective card instances
	private CObbScala cObb0, cObb1, cObb2, cObb3;
	private CObbRis cObb4, cObb5, cObb6, cObb7;
	private CObbOgg cObb8, cObb9, cObb10, cObb11;
	private CObbL cObb12, cObb13, cObb14, cObb15;
	
	/**
	 * Instantiate all the objective cards and shuffles them
	 */
	public MCObb() {
		cMazzo=new ArrayList<CObb>(16);
		//scale
		cMazzo.add(cObb0 = new CObbScala(2, Colore.ROSSO, true));
		cMazzo.add(cObb1 = new CObbScala(2, Colore.VERDE, false));
		cMazzo.add(cObb2 = new CObbScala(2, Colore.AZZURRO, true));
		cMazzo.add(cObb3 = new CObbScala(2, Colore.VIOLA, false));
		//three resources 
		cMazzo.add(cObb4 = new CObbRis(2, Simbolo.FUNGO));
		cMazzo.add(cObb5 = new CObbRis(2, Simbolo.FOGLIA));
		cMazzo.add(cObb6 = new CObbRis(2, Simbolo.LUPO));
		cMazzo.add(cObb7 = new CObbRis(2, Simbolo.FARFALLA));
		//two o three objects
		cMazzo.add(cObb8 = new CObbOgg(2, Simbolo.INCHIOSTRO, Simbolo.ASSENTE, Simbolo.ASSENTE));
		cMazzo.add(cObb9 = new CObbOgg(3, Simbolo.PIUMA, Simbolo.INCHIOSTRO, Simbolo.PERGAMENA));
		cMazzo.add(cObb10 = new CObbOgg(2, Simbolo.PERGAMENA, Simbolo.ASSENTE, Simbolo.ASSENTE));
		cMazzo.add(cObb11 = new CObbOgg(2, Simbolo.PIUMA, Simbolo.ASSENTE, Simbolo.ASSENTE));
		//l
		cMazzo.add(cObb12 = new CObbL(3, Colore.ROSSO, Colore.VERDE, 3));	//the first color indicates the color of the two cards one under the other
																			//the green card is bottom right
		cMazzo.add(cObb13 = new CObbL(3, Colore.VERDE, Colore.VIOLA, 4));	//the purple card is bottom left
		cMazzo.add(cObb14 = new CObbL(3, Colore.VIOLA, Colore.AZZURRO, 1));	//the sky blue card is upper left
		cMazzo.add(cObb15 = new CObbL(3, Colore.AZZURRO, Colore.ROSSO, 2));	//the red card is upper right
	
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
