package Logica;

import java.util.ArrayList;

import Carta.CObb;
import Enumerazione.TipoCarta;
import Tavolo.CartaTavolo;
import Tavolo.Giocatore;
import Tavolo.Tracciato;

public class LogicaGioco {
	
	private CartaTavolo cartaTavolo;
	private Tracciato tracciato;
	private int numGiocatori;

	public LogicaGioco() {
		
		cartaTavolo = new CartaTavolo();
		tracciato = new Tracciato();
		numGiocatori = tracciato.getNumGiocatori();
		
		Turni();
		
	}
	
	//needed only for graphics input
	public LogicaGioco(ArrayList<String> username, ArrayList<String> userColor) {
		
		cartaTavolo = new CartaTavolo();
		tracciato = new Tracciato(username, userColor);
		numGiocatori = tracciato.getNumGiocatori();
		
		for(int i=0; i<numGiocatori; i++) {
			ArrayList<CObb> cObb = new ArrayList<CObb>();
			for(int j=0; j<2; j++) {
				tracciato.getGiocatore(i).pescaC(cartaTavolo.pesca(TipoCarta.CRis));
				cObb.add((CObb)cartaTavolo.pesca(TipoCarta.CObb));
				cObb.add((CObb)cartaTavolo.pesca(TipoCarta.CObb));
			}
			//Bisogna far scegliere all'utente quale carta obbiettivo tenere
			tracciato.getGiocatore(i).pescaC(cObb.get(0));
			tracciato.getGiocatore(i).pescaC(cartaTavolo.pesca(TipoCarta.COro));
		}
		
		Turni();
		
	}

	private void Turni() {
		
		Giocatore giocatoreAttuale;
		boolean punti20 = false;
		boolean ultimoGiro = false;
		
		do {
			
			if(punti20)
					ultimoGiro = true;
			
			for(int i=0; i<numGiocatori; i++) {
				
				giocatoreAttuale = tracciato.getGiocatore(i);
				
				giocatoreAttuale.giocaC();
				
				pescaCarta(giocatoreAttuale);
				
				if(giocatoreAttuale.getPunteggio() > 19) {
					punti20 = true;
				}
				
			}
			
		}while(!ultimoGiro);
		
		AddPuntiObb();
		
	}

	private void pescaCarta(Giocatore giocatoreAttuale) {
		//Bisogna far scegliere all'utente quale carta pescare
		cartaTavolo.pesca(null);
		giocatoreAttuale.pescaC(null);
		
	}

	private void AddPuntiObb() {
		
		ArrayList<CObb> cObb = cartaTavolo.getcObbScp();
		
		for(int i=0; i<numGiocatori; i++) {
			tracciato.getGiocatore(i).addPunteggio(cObb.get(0).calcolaObb());
			tracciato.getGiocatore(i).addPunteggio(cObb.get(1).calcolaObb());
			CObb cObbPers = tracciato.getGiocatore(i).getCObbPer();
			tracciato.getGiocatore(i).addPunteggio(cObbPers.calcolaObb());
		}
		
		Vincitore();
		
	}
	
	private void Vincitore() {
		
		int maxPunti=tracciato.getGiocatore(0).getPunteggio();
		ArrayList<String> giocatore = new ArrayList<String>();
		giocatore.add(tracciato.getGiocatore(0).getSoprannome());
		
		for(int i=1; i<numGiocatori; i++) {
			int punti = tracciato.getGiocatore(i).getPunteggio();
			if(punti > maxPunti) {
				giocatore.clear();
				giocatore.add(tracciato.getGiocatore(i).getSoprannome());
				maxPunti = punti;
			}else if(punti == maxPunti) {
				giocatore.add(tracciato.getGiocatore(i).getSoprannome());
			}
		}
		
	}
	
}
