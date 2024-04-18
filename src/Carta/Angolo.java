package Carta;
import java.util.*;
import Enumerazione.*;
public class Angolo {
	
	private final Simbolo simbolo; //cosa c e nell'angolo (null se angolo vuoto)
	private boolean coperto; //lo stato dell'angolo
	
	public Angolo(Simbolo simbolo) {
		this.simbolo = simbolo;
		this.coperto=false;
	}

	public Simbolo getSimbolo() {
		return simbolo;
	}
	
	public boolean getCoperto() {
		return coperto;
	}
	
	public void setCoperto() {
		this.coperto=true;
	}
}
