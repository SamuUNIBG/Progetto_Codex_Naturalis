package Carta;

import Enumerazione.Colore;

import Tavolo.Giocatore;
import Tavolo.CampoGioco;
/**
 * sono quel tipo di CARTE OBIETTIVO che presentano uno schema 
 * da avere nell area di gioco al momento della conta finale dei punti per 
 * ottenere i punti segnati sulla stessa 
 * lo SCHEMA può essere una diagonale crescente ( / ) o decrescente ( \ ) e
 * va rispettato sia lo schema sia il colore delle carte con cui realizzarlo
 * ( i punti vengono dati per ogni schema realizzato purché con carte diverse
 * quindi una stessa carta non può essere contata 2 volte per uno stesso obiettivo)
 */
public class CObbScala extends CObb{
	private final Colore colore;//contiene il colore delle carte con cui
	   //realizzare lo schema
	/**
	 * direzione conterrà true se la diagonale sarà crescente quindi da basso (sx)
	 * ad alto (dx) --> /
	 * altrimenti false se la diagonale sarà decrescente quindi da alto (sx)
	 * a basso (dx) --> \
	 */
	private final boolean direzione;
	private static int lastId=86;
	
	public CObbScala(int puntiAssegnati, Colore colore, boolean direzione) {
		super(puntiAssegnati, CObbScala.lastId);
		this.colore=colore;
		this.direzione=direzione;
		CObbScala.lastId++;
	}

	public Colore getColore() {
		return colore;
	}

	public boolean getDirezione() {
		return direzione;
	}

	@Override
	public int calcolaObb(Giocatore giocatore) {
		// TODO Auto-generated method stub
		int volte = 0;  //per contare quante volte il giocatore fa l obiettivo
		Carta[][] campoAttuale = giocatore.getCampoG().getCampo();
		if(this.direzione==true) {  //e una scala crescente
			for(int i=1; i<CampoGioco.getDimensionex()-1; i++) {
				for(int j=1; j<CampoGioco.getDimensioney()-1; j++) {
					
					if(campoAttuale[i][j]!=null && !(campoAttuale[i][j] instanceof CIniz)
							/*se !=null vuol dire che nella cella e in quelle adiacenti
							ci sono carte*/
							&& ((CGiocabiliSpeciali)campoAttuale[i][j]).getColore()==this.colore
							/* verfico che il colore delle 3 carte prese in considerazione sia
							  uguale al colore richiesto dalla carta obiettivo*/
							&& !((CGiocabiliSpeciali)campoAttuale[i][j]).isContataScala()){
							/* verifico che le 3 carte non siano gia state contate per l'obietttivo
							 * scala (le scale possibili sono 4 dei 4 colori diversi il che esclude
							 * che una stessa carta possa esser contata x due scale di diverso colore)*/
						if(campoAttuale[i-1][j+1]!=null && !(campoAttuale[i-1][j+1] instanceof CIniz)
								&& ((CGiocabiliSpeciali)campoAttuale[i-1][j+1]).getColore()==this.colore
								&& !((CGiocabiliSpeciali)campoAttuale[i-1][j+1]).isContataScala()) {
							if(campoAttuale[i+1][j-1]!=null && !(campoAttuale[i+1][j-1] instanceof CIniz)
							&& ((CGiocabiliSpeciali)campoAttuale[i+1][j-1]).getColore()==this.colore
							&& !((CGiocabiliSpeciali)campoAttuale[i+1][j-1]).isContataScala()) {
								volte ++; 
								//numero di volte per cui si e realizzato l' obiettivo
								((CGiocabiliSpeciali)campoAttuale[i][j]).setContataScala(true);
								((CGiocabiliSpeciali)campoAttuale[i-1][j+1]).setContataScala(true);
								((CGiocabiliSpeciali)campoAttuale[i+1][j-1]).setContataScala(true);
								//setto a true il fatto che queste carte sono state gia contate per quell obiettivo
							}
						}
					}
				}
			}
		}else {

			for(int i=1; i<CampoGioco.getDimensionex()-1; i++) {
				for(int j=1; j<CampoGioco.getDimensioney()-1; j++) {
					if(campoAttuale[i][j]!=null && !(campoAttuale[i][j] instanceof CIniz)
							/*se !=null vuol dire che nella cella e in quelle adiacenti
							ci sono carte*/
							&& ((CGiocabiliSpeciali)campoAttuale[i][j]).getColore()==this.colore
							/* verfico che il colore delle 3 carte prese in considerazione sia
							  uguale al colore richiesto dalla carta obiettivo*/
							&& !((CGiocabiliSpeciali)campoAttuale[i][j]).isContataScala()){
							/* verifico che le 3 carte non siano gia state contate per l'obietttivo
							 * scala (le scale possibili sono 4 dei 4 colori diversi il che esclude
							 * che una stessa carta possa esser contata x due scale di diverso colore)*/
						if(campoAttuale[i-1][j-1]!=null && !(campoAttuale[i-1][j-1] instanceof CIniz)
								&& ((CGiocabiliSpeciali)campoAttuale[i-1][j-1]).getColore()==this.colore
								&& !((CGiocabiliSpeciali)campoAttuale[i-1][j-1]).isContataScala()) {
							if(campoAttuale[i+1][j+1]!=null && !(campoAttuale[i+1][j+1] instanceof CIniz)
							&& ((CGiocabiliSpeciali)campoAttuale[i+1][j+1]).getColore()==this.colore
							&& !((CGiocabiliSpeciali)campoAttuale[i+1][j+1]).isContataScala()) {
								volte ++; 
								//numero di volte per cui si e realizzato l' obiettivo
								((CGiocabiliSpeciali)campoAttuale[i][j]).setContataScala(true);
								((CGiocabiliSpeciali)campoAttuale[i-1][j-1]).setContataScala(true);
								((CGiocabiliSpeciali)campoAttuale[i+1][j+1]).setContataScala(true);
								//setto a true il fatto che queste carte sono state gia contate per quell obiettivo
							}
						}
					}
				}
			}
		}
		
		return (this.getPunti())*volte;
		
	}

	public int getIdCarta() {
		return super.getIdCarta();
	}	
	
	public String toString() {
		String str = "Carata obbiettivo scala " + super.toString() +
				"\n\t\t Obbiettivo -> Disporre tre carte diagonalmente" +
				"\n\t\t Colore -> " + colore +
				"\n\t\t Forma -> ";
		if(direzione)
			str += "/";
		else
			str += "\\";
		
		return str +=  "]";
		
	}

	

}
