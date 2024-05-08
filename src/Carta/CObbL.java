package Carta;

import Enumerazione.Colore;

import Tavolo.CampoGioco;
import Tavolo.Giocatore;
/**
 * sono quel tipo di CARTE OBIETTIVO che presentano uno schema 
 * da avere nell area di gioco al momento della conta finale dei punti per 
 * ottenere i punti segnati sulla stessa 
 * lo SCHEMA e una sequenza di carte che piazzate formano una "L" orientata
 * in 4 direzioni possibili,
 * va rispettato sia lo schema sia il colore delle carte con cui realizzarlo
 * ( i punti vengono dati per ogni schema realizzato purché con carte diverse
 * quindi una stessa carta non può essere contata 2 volte per uno stesso obiettivo)
 */
public class CObbL extends CObb{
	private final Colore[] colori = new Colore[2]; /*contiene i colori delle carte con cui
	realizzare lo schema perche puo esser fatto da carte di diversi colori*/
	private final int direzione; /*contiene 4 numeri che rappresentano le
	4 direzioni possibili in cui la L puo essere orientata*/
	private static int lastId=90;
	
	public CObbL(int puntiAssegnati, Colore colore0, Colore colore1, int direzione) {
		super(puntiAssegnati, CObbL.lastId);
		this.colori[0]=colore0;
		this.colori[1]=colore1;
		this.direzione=direzione;
		CObbL.lastId++;
	}
	
	@Override
	public int calcolaObb(Giocatore giocatore) {
		// TODO Auto-generated method stub
		int volte = 0;  //per contare quante volte il giocatore fa l obiettivo
		Carta[][] campoAttuale = giocatore.getCampoG().getCampo();
		if (this.direzione==1) {
			for(int i=0; i<CampoGioco.getDimensioney()-3; i++) {
				for(int j=0; j<CampoGioco.getDimensionex()-1; j++) {
					
					if(campoAttuale[i][j]!=null && !(campoAttuale[i][j] instanceof CIniz)
							/*se !=null vuol dire che nella cella e in quelle che formano
						 	lo schema della L ci sono carte*/
							&& ((CGiocabiliSpeciali)campoAttuale[i][j]).getColore()==this.colori[1]
							/* verfico che il colore delle 3 carte prese in considerazione sia
							  uguale al colore richiesto dalla carta obiettivo*/
							&& !((CGiocabiliSpeciali)campoAttuale[i][j]).isContataL()){
						/* verifico che le 3 carte non siano gia state contate per l'obietttivo L */
						if(campoAttuale[i+1][j+1]!=null && !(campoAttuale[i+1][j+1] instanceof CIniz)
								&& ((CGiocabiliSpeciali)campoAttuale[i+1][j+1]).getColore()==this.colori[0]
								&& !((CGiocabiliSpeciali)campoAttuale[i+1][j+1]).isContataL()) {
							if(campoAttuale[i+3][j+1]!=null && !(campoAttuale[i+3][j+1] instanceof CIniz)
							&& ((CGiocabiliSpeciali)campoAttuale[i+3][j+1]).getColore()==this.colori[0]
							&& !((CGiocabiliSpeciali)campoAttuale[i+3][j+1]).isContataL()) {
								volte ++; 
								//numero di volte per cui si e realizzato l obiettivo
								((CGiocabiliSpeciali)campoAttuale[i][j]).setContataL(true);
								((CGiocabiliSpeciali)campoAttuale[i+1][j+1]).setContataL(true);
								((CGiocabiliSpeciali)campoAttuale[i+3][j+1]).setContataL(true);
								//setto a true il fatto che queste carte sono state gia contate per quell obiettivo
							}
						}
					}
				}
			}
		}
		if (this.direzione==2) {
			for(int i=0; i<CampoGioco.getDimensioney()-3; i++) {
				for(int j=1; j<CampoGioco.getDimensionex(); j++) {
					
					if(campoAttuale[i][j]!=null && !(campoAttuale[i][j] instanceof CIniz)
							/*se !=null vuol dire che nella cella e in quelle che formano
						 	lo schema della L ci sono carte*/
							&& ((CGiocabiliSpeciali)campoAttuale[i][j]).getColore()==this.colori[1]
							/* verfico che il colore delle 3 carte prese in considerazione sia
							  uguale al colore richiesto dalla carta obiettivo*/
							&& !((CGiocabiliSpeciali)campoAttuale[i][j]).isContataL()){
						/* verifico che le 3 carte non siano gia state contate per l'obietttivo L */
						if(campoAttuale[i+1][j-1]!=null && !(campoAttuale[i+1][j-1] instanceof CIniz)
								&& ((CGiocabiliSpeciali)campoAttuale[i+1][j-1]).getColore()==this.colori[0]
								&& !((CGiocabiliSpeciali)campoAttuale[i+1][j-1]).isContataL()) {
							if(campoAttuale[i+3][j-1]!=null && !(campoAttuale[i+3][j-1] instanceof CIniz)
							&& ((CGiocabiliSpeciali)campoAttuale[i+3][j-1]).getColore()==this.colori[0]
							&& !((CGiocabiliSpeciali)campoAttuale[i+3][j-1]).isContataL()) {
								volte ++; 
								//numero di volte per cui si e realizzato l obiettivo
								((CGiocabiliSpeciali)campoAttuale[i][j]).setContataL(true);
								((CGiocabiliSpeciali)campoAttuale[i+1][j-1]).setContataL(true);
								((CGiocabiliSpeciali)campoAttuale[i+3][j-1]).setContataL(true);
								//setto a true il fatto che queste carte sono state gia contate per quell obiettivo
							}
						}
					}
				}
			}
		}
		if (this.direzione==3) {
			for(int i=3; i<CampoGioco.getDimensioney(); i++) {
				for(int j=1; j<CampoGioco.getDimensionex(); j++) {
					
					if(campoAttuale[i][j]!=null && !(campoAttuale[i][j] instanceof CIniz)
							/*se !=null vuol dire che nella cella e in quelle che formano
						 	lo schema della L ci sono carte*/
							&& ((CGiocabiliSpeciali)campoAttuale[i][j]).getColore()==this.colori[1]
							/* verfico che il colore delle 3 carte prese in considerazione sia
							  uguale al colore richiesto dalla carta obiettivo*/
							&& !((CGiocabiliSpeciali)campoAttuale[i][j]).isContataL()){
						/* verifico che le 3 carte non siano gia state contate per l'obietttivo L */
						if(campoAttuale[i-1][j-1]!=null && !(campoAttuale[i-1][j-1] instanceof CIniz)
								&& ((CGiocabiliSpeciali)campoAttuale[i-1][j-1]).getColore()==this.colori[0]
								&& !((CGiocabiliSpeciali)campoAttuale[i-1][j-1]).isContataL()) {
							if(campoAttuale[i-3][j-1]!=null && !(campoAttuale[i-3][j-1] instanceof CIniz)
							&& ((CGiocabiliSpeciali)campoAttuale[i-3][j-1]).getColore()==this.colori[0]
							&& !((CGiocabiliSpeciali)campoAttuale[i-3][j-1]).isContataL()) {
								volte ++; 
								//numero di volte per cui si e realizzato l obiettivo
								((CGiocabiliSpeciali)campoAttuale[i][j]).setContataL(true);
								((CGiocabiliSpeciali)campoAttuale[i-1][j-1]).setContataL(true);
								((CGiocabiliSpeciali)campoAttuale[i-3][j-1]).setContataL(true);
								//setto a true il fatto che queste carte sono state gia contate per quell obiettivo
							}
						}
					}
				}
			}
		}
		if (this.direzione==4) {
			for(int i=3; i<CampoGioco.getDimensioney(); i++) {
				for(int j=0; j<CampoGioco.getDimensionex()-1; j++) {
					
					if(campoAttuale[i][j]!=null && !(campoAttuale[i][j] instanceof CIniz)
							/*se !=null vuol dire che nella cella e in quelle che formano
						 	lo schema della L ci sono carte*/
							&& ((CGiocabiliSpeciali)campoAttuale[i][j]).getColore()==this.colori[1]
							/* verfico che il colore delle 3 carte prese in considerazione sia
							  uguale al colore richiesto dalla carta obiettivo*/
							&& !((CGiocabiliSpeciali)campoAttuale[i][j]).isContataL()){
						/* verifico che le 3 carte non siano gia state contate per l'obietttivo L */
						if(campoAttuale[i-1][j+1]!=null && !(campoAttuale[i-1][j+1] instanceof CIniz)
								&& ((CGiocabiliSpeciali)campoAttuale[i-1][j+1]).getColore()==this.colori[0]
								&& !((CGiocabiliSpeciali)campoAttuale[i-1][j+1]).isContataL()) {
							if(campoAttuale[i-3][j+2]!=null && !(campoAttuale[i-3][j+2] instanceof CIniz)
							&& ((CGiocabiliSpeciali)campoAttuale[i-3][j+2]).getColore()==this.colori[0]
							&& !((CGiocabiliSpeciali)campoAttuale[i-3][j+2]).isContataL()) {
								volte ++; 
								//numero di volte per cui si e realizzato l obiettivo
								((CGiocabiliSpeciali)campoAttuale[i][j]).setContataL(true);
								((CGiocabiliSpeciali)campoAttuale[i-1][j+1]).setContataL(true);
								((CGiocabiliSpeciali)campoAttuale[i-3][j+2]).setContataL(true);
								//setto a true il fatto che queste carte sono state gia contate per quell obiettivo
							}
						}
					}
				}
			}
		}
		return (this.getPunti())*volte; //torno il punteggio della carta moltiplicato per le volte in cui si e realizzato  l obiettivo
	}
	public Colore[] getColori() {
		return colori;
	}
	public int getDirezione() {
		return direzione;
	}
	@Override
	public int getIdCarta() {
		return super.getIdCarta();
	}
	
	public String toString() {
		String str = "Carata obbiettivo L " + super.getIdCarta() +
				":\n\t\t[" + super.toString() +
				"\n\t\t Obbiettivo -> Disporre tre carte a forma di L" +
				"\n\t\t Colore carte adiacenti -> " + colori[0] +
				"\n\t\t Colore carta diagonale -> " + colori[1] +
				"\n\t\t Forma -> ";
		switch(direzione) {
			case 1:
				str += "_|^";
				break;
			case 2:
				str += "|_^";
				break;
			case 3:
				str += "|_";
				break;
			case 4:
				str += "_|";
				break;
		}
			
		return str +=  "]";
		
	}

	
	
}
