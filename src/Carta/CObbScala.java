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
	
	public CObbScala(int puntiAssegnati, Colore colore, 
			boolean direzione) {
		super(puntiAssegnati);
		this.colore=colore;
		this.direzione=direzione;
		// TODO Auto-generated constructor stub
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
		if(this.direzione==true) {  //e una scala crescente
			for(int i=0; i<CampoGioco.getDimensionex()-1; i++) {
				for(int j=0; j<CampoGioco.getDimensioney()-1; j++) {
					if(giocatore.getCampoG().getCampo()[i][j]!=null) {
						if(giocatore.getCampoG().getCampo()[i][j].
								equals(giocatore.getCampoG().getCampo()[i-1][j+1])
		&& giocatore.getCampoG().getCampo()[i][j].getAngoli()[3].getCoperto()==true 
		&& giocatore.getCampoG().getCampo()[i][j].getAngoli()[1].getCoperto()==true 
		&& giocatore.getCampoG().getCampo()[i][j].equals(giocatore.getCampoG().getCampo()[i+1][j-1])
		
								){
							
						}
					}
				}
			}
		}
		else {
			
		}
		
		return 0;
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
}
