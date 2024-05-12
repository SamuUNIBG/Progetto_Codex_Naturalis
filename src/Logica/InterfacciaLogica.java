package Logica;

import Tavolo.Giocatore;
/**
 * contiene metodi per classe LogicaGiocoConsole
 */
public interface InterfacciaLogica {

	
	
	public abstract  void pescaCarta(Giocatore giocatoreAttuale);
	public abstract void Turni();
	public abstract void AddPuntiObb();
	public abstract void Vincitore();
}
