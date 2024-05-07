package Logica;

import Tavolo.Giocatore;

public interface InterfacciaLogica {

	
	
	public abstract  void pescaCarta(Giocatore giocatoreAttuale);
	public abstract void Turni();
	public abstract void AddPuntiObb();
	public abstract void Vincitore();
}
