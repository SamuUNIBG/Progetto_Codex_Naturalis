package Tavolo;

import java.util.ArrayList;

import Carta.CIniz;
import Carta.CObb;
import Carta.COro;
import Carta.CRis;
import Carta.Carta;

import Enumerazione.TipoCarta;

/**
 * @author Samuele Vecchi
 *
 */
public class CartaTavolo {

	private ArrayList<CRis> cRisScp;
	private ArrayList<CObb> cObbScp;
	private ArrayList<COro> cOroScp;
	private MCIniz mIniz;
	private MCRis mRis;
	private MCOro mOro;
	private MCObb mObb;
	
	/**
	 * Are instantiated:
	 * <br>-starter cards' deck
	 * <br>-resource cards' deck
	 * <br>-gold cards' deck
	 * <br>-objective cards' deck
	 * <br>-2 resource cards
	 * <br>-2 gold cards
	 * <br>-2 objective cards
	 */
	public CartaTavolo() {
		mIniz = new MCIniz();
		mOro = new MCOro();
		mRis = new MCRis();
		mObb = new MCObb();
		cRisScp = new ArrayList<CRis>(2);
		cRisScp.add(mRis.pesca());
		cRisScp.add(mRis.pesca());
		cOroScp = new ArrayList<COro>(2);
		cOroScp.add(mOro.pesca());
		cOroScp.add(mOro.pesca());
		cObbScp = new ArrayList<CObb>(2);
		cObbScp.add(mObb.pesca());
		cObbScp.add(mObb.pesca());
	}

	/**
	 * @return the cRisScp
	 */
	public ArrayList<CRis> getcRisScp() {
		return cRisScp;
	}

	/**
	 * Add a card to the face-up resource cards' deck
	 * @param carta the card to add
	 */	
	public void addcRisScp(CRis carta) {
		cRisScp.add(carta);
	}

	/**
	 * @return the cObbScp
	 */
	public ArrayList<CObb> getcObbScp() {
		return cObbScp;
	}

	/**
	 * @return the cOroScp
	 */
	public ArrayList<COro> getcOroScp() {
		return cOroScp;
	}

	/**
	 * Add a card to the face-up gold cards' deck
	 * @param carta the card to add
	 */
	public void addcOroScp(COro carta) {
		cOroScp.add(carta);
	}
	
	/**
	 * @return the mazzoIniz
	 */
	public MCIniz getMazzoIniz() {
		return mIniz;
	}

	/**
	 * @return the mazzoOro
	 */
	public MCOro getMazzoOro() {
		return mOro;
	}

	/**
	 * @return the mazzoRis
	 */
	public MCRis getMazzoRis() {
		return mRis;
	}

	/**
	 * @return the mazzoObb
	 */
	public MCObb getMazzoObb() {
		return mObb;
	}
	
	/**
	 * Takes one of the face-up cards and places another
	 * @param tipo the type of card
	 * @param pos the position, within the ArrayList, of the card to be drawn
	 */
	public Carta pesca(TipoCarta tipo, int pos) {
		if(tipo==TipoCarta.COro) {
			COro carta = cOroScp.get(pos);
			cOroScp.remove(pos);
			cOroScp.add(mOro.pesca());
			return carta;
		}else if(tipo==TipoCarta.CRis){
			CRis carta = cRisScp.get(pos);
			cRisScp.remove(pos);
			cRisScp.add(mRis.pesca());
			return carta;
		}
		
		return null;
	}
	
	/**
	 * Takes the first card of deck
	 * @param tipo the type of card
	 */
	public Carta pesca(TipoCarta tipo) {
		if(tipo==TipoCarta.COro) {
			COro carta = mOro.pesca();
			return carta;
		}else if(tipo==TipoCarta.CRis){
			CRis carta = mRis.pesca();
			return carta;
		}else if(tipo==TipoCarta.CObb){
			CObb carta = mObb.pesca();
			return carta;
		}else if(tipo==TipoCarta.CIniz){
			CIniz carta = mIniz.pesca();
			return carta;
		}
		
		return null;
	}
	
}
