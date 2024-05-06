package Carta;
import Enumerazione.Colore;
import Enumerazione.Simbolo;
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
	public CObbL(int puntiAssegnati, Colore colore0,
			Colore colore1, int direzione) {
		super(puntiAssegnati);
		this.colori[0]=colore0;
		this.colori[1]=colore1;
		this.direzione=direzione;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int calcolaObb(Giocatore giocatore) {
		// TODO Auto-generated method stub
		int volte = 0;  //per contare quante volte il giocatore fa l obiettivo
		if (this.direzione==1) {
			for(int i=0; i<CampoGioco.getDimensionex()-1; i++) {
				for(int j=0; j<CampoGioco.getDimensioney()-2; j++) {
					
					
						if(giocatore.getCampoG().getCampo()[i][j]!=null
						&& giocatore.getCampoG().getCampo()[i+1][j+1]!=null
						&& giocatore.getCampoG().getCampo()[i+1][j+2]!=null
						/*se !=null vuol dire che nella cella e in quelle che formano
						 lo schema della L ci sono carte*/
						&& (giocatore.getCampoG().getCampo()[i][j].getAngoli()[2].getCoperto()==true
						|| giocatore.getCampoG().getCampo()[i+1][j+1].getAngoli()[0].getCoperto()==true)  
						//verifico la corretta copertura degli angoli
						&& giocatore.getCampoG().getCampo()[i][j].getColore()==this.getColori()[1]
						&& giocatore.getCampoG().getCampo()[i+1][j+1].getColore()==this.getColori()[0]
						&& giocatore.getCampoG().getCampo()[i+1][j+2].getColore()==this.getColori()[0]
						/* verfico che il colore delle 3 carte prese in considerazione sia
						  uguale ai colori richiesti dalla carta obiettivo*/
						&& !giocatore.getCampoG().getCampo()[i][j].isContataL()
						&& !giocatore.getCampoG().getCampo()[i+1][j+1].isContataL()
						&& !giocatore.getCampoG().getCampo()[i+1][j+2].isContataL()){
						/* verifico che le 3 carte non siano gia state contate per l'obietttivo
						 * L */
						   volte ++; 
						   //numero di volte per cui si e realizzato l obiettivo
						   giocatore.getCampoG().getCampo()[i][j].setContataL(true);
						   giocatore.getCampoG().getCampo()[i+1][j+1].setContataL(true);
						   giocatore.getCampoG().getCampo()[i+1][j+2].setContataL(true);
						   //setto a true il fatto che queste carte sono state gia contate per quell obiettivo
						}
				}
			}
		}
		if (this.direzione==2) {
			for(int i=1; i<CampoGioco.getDimensionex(); i++) {
				for(int j=0; j<CampoGioco.getDimensioney()-2; j++) {
					
					
						if(giocatore.getCampoG().getCampo()[i][j]!=null
						&& giocatore.getCampoG().getCampo()[i-1][j+1]!=null
						&& giocatore.getCampoG().getCampo()[i-1][j+2]!=null
						/*se !=null vuol dire che nella cella e in quelle che formano
						 lo schema della L ci sono carte*/
						&& (giocatore.getCampoG().getCampo()[i][j].getAngoli()[3].getCoperto()==true
						|| giocatore.getCampoG().getCampo()[i-1][j+1].getAngoli()[1].getCoperto()==true)  
						//verifico la corretta copertura degli angoli
						&& giocatore.getCampoG().getCampo()[i][j].getColore()==this.getColori()[1]
						&& giocatore.getCampoG().getCampo()[i-1][j+1].getColore()==this.getColori()[0]
						&& giocatore.getCampoG().getCampo()[i-1][j+2].getColore()==this.getColori()[0]
						/* verfico che il colore delle 3 carte prese in considerazione sia
						  uguale ai colori richiesti dalla carta obiettivo*/
						&& !giocatore.getCampoG().getCampo()[i][j].isContataL()
						&& !giocatore.getCampoG().getCampo()[i-1][j+1].isContataL()
						&& !giocatore.getCampoG().getCampo()[i-1][j+2].isContataL()){
						/* verifico che le 3 carte non siano gia state contate per l'obietttivo
						 * L */
						   volte ++; 
						   //numero di volte per cui si e realizzato l obiettivo
						   giocatore.getCampoG().getCampo()[i][j].setContataL(true);
						   giocatore.getCampoG().getCampo()[i-1][j+1].setContataL(true);
						   giocatore.getCampoG().getCampo()[i-1][j+2].setContataL(true);
						   //setto a true il fatto che queste carte sono state gia contate per quell obiettivo
						}
				}
			}
		}
		if (this.direzione==3) {
			for(int i=0; i<CampoGioco.getDimensionex()-1; i++) {
				for(int j=0; j<CampoGioco.getDimensioney()-2; j++) {
					
					
						if(giocatore.getCampoG().getCampo()[i][j]!=null
						&& giocatore.getCampoG().getCampo()[i][j+1]!=null
						&& giocatore.getCampoG().getCampo()[i+1][j+2]!=null
						/*se !=null vuol dire che nella cella e in quelle che formano
						 lo schema della L ci sono carte*/
						&& (giocatore.getCampoG().getCampo()[i][j+1].getAngoli()[2].getCoperto()==true
						|| giocatore.getCampoG().getCampo()[i+1][j+2].getAngoli()[0].getCoperto()==true)  
						//verifico la corretta copertura degli angoli
						&& giocatore.getCampoG().getCampo()[i][j].getColore()==this.getColori()[0]
						&& giocatore.getCampoG().getCampo()[i][j+1].getColore()==this.getColori()[0]
						&& giocatore.getCampoG().getCampo()[i+1][j+2].getColore()==this.getColori()[1]
						/* verfico che il colore delle 3 carte prese in considerazione sia
						  uguale ai colori richiesti dalla carta obiettivo*/
						&& !giocatore.getCampoG().getCampo()[i][j].isContataL()
						&& !giocatore.getCampoG().getCampo()[i][j+1].isContataL()
						&& !giocatore.getCampoG().getCampo()[i+1][j+2].isContataL()){
						/* verifico che le 3 carte non siano gia state contate per l'obietttivo
						 * L */
						   volte ++; 
						   //numero di volte per cui si e realizzato l obiettivo
						   giocatore.getCampoG().getCampo()[i][j].setContataL(true);
						   giocatore.getCampoG().getCampo()[i][j+1].setContataL(true);
						   giocatore.getCampoG().getCampo()[i+1][j+2].setContataL(true);
						   //setto a true il fatto che queste carte sono state gia contate per quell obiettivo
						}
				}
			}
		}
		if (this.direzione==4) {
			for(int i=1; i<CampoGioco.getDimensionex(); i++) {
				for(int j=0; j<CampoGioco.getDimensioney()-2; j++) {
					
					
						if(giocatore.getCampoG().getCampo()[i][j]!=null
						&& giocatore.getCampoG().getCampo()[i][j+1]!=null
						&& giocatore.getCampoG().getCampo()[i-1][j+2]!=null
						/*se !=null vuol dire che nella cella e in quelle che formano
						 lo schema della L ci sono carte*/
						&& (giocatore.getCampoG().getCampo()[i][j+1].getAngoli()[3].getCoperto()==true
						|| giocatore.getCampoG().getCampo()[i-1][j+2].getAngoli()[1].getCoperto()==true)  
						//verifico la corretta copertura degli angoli
						&& giocatore.getCampoG().getCampo()[i][j].getColore()==this.getColori()[0]
						&& giocatore.getCampoG().getCampo()[i][j+1].getColore()==this.getColori()[0]
						&& giocatore.getCampoG().getCampo()[i-1][j+2].getColore()==this.getColori()[1]
						/* verfico che il colore delle 3 carte prese in considerazione sia
						  uguale ai colori richiesti dalla carta obiettivo*/
						&& !giocatore.getCampoG().getCampo()[i][j].isContataL()
						&& !giocatore.getCampoG().getCampo()[i][j+1].isContataL()
						&& !giocatore.getCampoG().getCampo()[i-1][j+2].isContataL()){
						/* verifico che le 3 carte non siano gia state contate per l'obietttivo
						 * L */
						   volte ++; 
						   //numero di volte per cui si e realizzato l obiettivo
						   giocatore.getCampoG().getCampo()[i][j].setContataL(true);
						   giocatore.getCampoG().getCampo()[i][j+1].setContataL(true);
						   giocatore.getCampoG().getCampo()[i-1][j+2].setContataL(true);
						   //setto a true il fatto che queste carte sono state gia contate per quell obiettivo
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
	public int getIDCARTA() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean VerificaPrerequistio() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Simbolo getSimbolo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Colore getColore() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString() {
		String str = "Carata obbiettivo L " /*+ IDCARTA*/ +
				":\n\t\t[" + super.toString() +
				"\n\t\t Obbiettivo -> Formare una L con tre carte" +
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
