package Carta;

import Enumerazione.*;

public class Angolo {
	
	private final Simbolo simbolo; //cosa c e nell'angolo (null se angolo vuoto)
	private boolean coperto; //lo stato dell'angolo
	
	/**
	 * @param simbolo
	 */
	public Angolo(Simbolo simbolo) { //simbolo può anche essere assente
		this.simbolo = simbolo;
		this.coperto=false;
	}
	/**
	 * l'angolo ha o meno un simbolo 
	 * @return l'attributo simbolo dell angolo
	 */
	public Simbolo getSimbolo() {
		return simbolo;
	}
	/**
	 * 
	 * @return l'attributo coperto dell angolo
	 */
	public boolean getCoperto() {
		return coperto;
	}
	
	public void setCoperto() {
		this.coperto=true;
	}
	/**
	 * ottenere informazioni scritte riguardo l'angolo
	 * se ha un simbolo o risorsa e se e coperto o meno
	 */
	public String toString() {
		String str = "" + simbolo;
		
		if(coperto)
			str += ", COPERTO";
		else
			str += ", ESPOSTO";
		
		return str;
	}
	
}
