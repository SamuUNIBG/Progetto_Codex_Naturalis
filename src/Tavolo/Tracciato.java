package Tavolo;

import java.util.*;

import Enumerazione.Colore;

public class Tracciato {
	private ArrayList<Giocatore> tabellone;
	private Colore coloreScelto;
	private String s;
	private ArrayList<String> coloriDisp=new ArrayList<String>();
	
	/**
	 * metodo che chiede di inserire il numero di giocatori e 
	 * e ne gestisce eventuali errori
	 * @return il numero di giocatori
	 */
	
	//needed only for graphics input
	public Tracciato(ArrayList<String> username, ArrayList<String> userColor) {
		boolean primo = true;
		tabellone = new ArrayList<Giocatore>(username.size());
		for(int i=0; i<username.size(); i++) {
			switch(userColor.get(i)){
				case "Rosso":
					tabellone.add(new Giocatore(username.get(i),Colore.ROSSO,primo));
					break;
				case "Azzurro":
					tabellone.add(new Giocatore(username.get(i),Colore.AZZURRO,primo));
					break;
				case "Giallo":
					tabellone.add(new Giocatore(username.get(i),Colore.GIALLO,primo));
					break;
				case "Verde":
					tabellone.add(new Giocatore(username.get(i),Colore.VERDE,primo));
					break;
			}
			primo=false;
		}
		
	}


	public void rivelaPunteggio() {
	
		for(int i=0;i<tabellone.size();i++) {
			System.out.println(tabellone.get(i).getSoprannome()+":"+tabellone.get(i).getPunteggio()+"\n");
			
		}
		
	}
	/**
	 * 
	 * @return il numero di giocatori
	 */
	public int getNumGiocatori() {
		
		return tabellone.size();
		
	}
	/**
	 * 
	 * @param la posizione del giocatore nel tracciato
	 * @return il giocatore in quella posizione
	 */
	
	public Giocatore getGiocatore(int i) {
		
		return tabellone.get(i);
		
	}
	
}
