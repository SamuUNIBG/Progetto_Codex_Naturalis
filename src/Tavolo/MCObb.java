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
	private CObbScala cObb01, cObb02, cObb03, cObb04;
	private CObbL cObb11, cObb12, cObb13, cObb14;
	private CObbRis cObb21, cObb22, cObb23, cObb24;
	private CObbOgg cObb31, cObb32, cObb33, cObb34;
	
	/**
	 * Instantiate all the objective cards and shuffles them
	 */
	public MCObb() {
		cMazzo=new ArrayList<CObb>(16);
		//scale
		cMazzo.add(cObb01 = new CObbScala(2, Colore.ROSSO, true));
		cMazzo.add(cObb02 = new CObbScala(2, Colore.VERDE, false));
		cMazzo.add(cObb03 = new CObbScala(2, Colore.AZZURRO, true));
		cMazzo.add(cObb04= new CObbScala(2, Colore.VIOLA, false));
		//l
		cMazzo.add(cObb11 = new CObbL(3, Colore.ROSSO, Colore.VERDE, 3));	//the first color indicates the color of the two cards one under the other
																			//the green card is bottom right
		cMazzo.add(cObb12 = new CObbL(3, Colore.VERDE, Colore.VIOLA, 4));	//the purple card is bottom left
		cMazzo.add(cObb13 = new CObbL(3, Colore.AZZURRO, Colore.ROSSO, 2));	//the red card is upper right
		cMazzo.add(cObb14 = new CObbL(3, Colore.VIOLA, Colore.AZZURRO, 1));	//the sky blue card is upper left
		
		//three resources 
		cMazzo.add(cObb21 = new CObbRis(2, Simbolo.FUNGO));
		cMazzo.add(cObb22 = new CObbRis(2, Simbolo.FOGLIA));
		cMazzo.add(cObb23 = new CObbRis(2, Simbolo.LUPO));
		cMazzo.add(cObb24 = new CObbRis(2, Simbolo.FARFALLA));
		//two o three objects
		cMazzo.add(cObb31 = new CObbOgg(3, Simbolo.PIUMA, Simbolo.INCHIOSTRO, Simbolo.PERGAMENA));
		cMazzo.add(cObb32 = new CObbOgg(2, Simbolo.PERGAMENA, Simbolo.ASSENTE, Simbolo.ASSENTE));
		cMazzo.add(cObb33 = new CObbOgg(2, Simbolo.INCHIOSTRO, Simbolo.ASSENTE, Simbolo.ASSENTE));
		cMazzo.add(cObb34 = new CObbOgg(2, Simbolo.PIUMA, Simbolo.ASSENTE, Simbolo.ASSENTE));
		
	
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
