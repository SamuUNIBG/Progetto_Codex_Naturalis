package Logica;

import java.util.ArrayList;



import java.util.Scanner;

import Carta.CObb;
import Enumerazione.TipoCarta;
import Tavolo.CartaTavolo;
import Tavolo.Giocatore;
import Tavolo.Tracciato;

public class LogicaGiocoGrafica implements InterfacciaLogica {

	private CartaTavolo cartaTavolo;
	
	private Tracciato tracciato;
	private int numGiocatori;
	
	public LogicaGiocoGrafica(ArrayList<String> username, ArrayList<String> userColor) {
			
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
			tracciato.getGiocatore(i).pescaC(cartaTavolo.pesca(TipoCarta.CIniz));
		}
		
		Turni();
			
	}
	
	@Override
	public void pescaCarta(Giocatore giocatoreAttuale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Turni() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AddPuntiObb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Vincitore() {
		// TODO Auto-generated method stub
		
	}

}
