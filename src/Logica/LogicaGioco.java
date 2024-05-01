package Logica;

import java.util.ArrayList;

import Tavolo.CartaTavolo;
import Tavolo.Tracciato;

public class LogicaGioco {
	
	private CartaTavolo cartaTavolo;
	private Tracciato tracciato;

	public LogicaGioco() {
		
		cartaTavolo = new CartaTavolo();
		tracciato = new Tracciato();
		
		Turni();
		
	}
	
	//needed only for graphics input
	public LogicaGioco(ArrayList<String> username, ArrayList<String> userColor) {
		
		cartaTavolo = new CartaTavolo();
		tracciato = new Tracciato(username, userColor);

		Turni();
		
	}

	private void Turni() {
		do {
			
			for(int i=0; i<5; i++) {
				
			}
			
		}while(true);
	}
	
}
