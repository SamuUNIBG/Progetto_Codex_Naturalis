package Carta;

import Enumerazione.*;
import Tavolo.Giocatore;
/**
 * le carte oro sono 40 totali di cui, una volta mescolato il mazzo,
 * le prime 2 vengono rivelate scoperte sul campo di gioco, al contempo
 * con le carte oro, e poi ogni giocatore ne pesca 1 dal mazzo cosi che 
 * la sua mano sia composta da 2 carte risorsa e 1 carta oro (tot 3 carte in mano).
 * . sul FRONTE presentano degli angoli (non necessariamente tutti e 4) che
 * possono avere delle risorse o oggetti (o esser vuoti) e possono dare dei punti 
 * che sono indicati in alto centralmente affiancati da un oggetto da avere o da 
 * uno schema (es una carta con l angolo coperto) che consente di ottenere quei 
 * punti o nulla (in tal caso i punti sono ottenibili al piazzamento)
 * i punti vengono calcolati
 * solo al piazzamento della carta (NON in momenti successivi anche se ottieni piu
 * oggetti) 
 * in basso centralmente presentano i requisiti ovvero delle risorse da aver 
 * visibili nella propria area di gioco per potera piazzare (sul fronte)
 * . sul RETRO presentano i 4 angoli vuoti e una risorsa al centro sempre visibile
 * per piazzarla sul retro non occorre soddisfare i requisiti
 */
public class COro extends CGiocabiliSpeciali implements InterfacciaCarteOro {
	
	private static int LASTID=40;
	private final Simbolo obbiettivo;
	private final int[] risNecessarie = new int[4]; /*sono i requisiti (quindi 
	le risorse da avere sul proprio campo) per poter piazzare la carta oro
	sul fronte*/

	public COro(int puntiAssegnati, Simbolo obbiettivo, Simbolo simbolo, Colore colore, Simbolo angolo0, Simbolo angolo1,
			Simbolo angolo2, Simbolo angolo3, int risnecessaria1, int risnecessaria2, int risnecessaria3, int risnecessaria4) {
		super(puntiAssegnati, simbolo, colore, true, angolo0, angolo1, angolo2, angolo3, COro.LASTID);
		this.obbiettivo=obbiettivo;
		COro.LASTID++;
		this.risNecessarie[0]=risnecessaria1;
		this.risNecessarie[1]=risnecessaria2;
		this.risNecessarie[2]=risnecessaria3;
		this.risNecessarie[3]=risnecessaria4;
	}
	
	public COro(Simbolo simbolo, Colore colore, int IdCarta) {
		super(0, simbolo, colore, false, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, Simbolo.VUOTO, IdCarta);
		this.obbiettivo=Simbolo.ASSENTE;
		this.risNecessarie[0]=0;
		this.risNecessarie[1]=0;
		this.risNecessarie[2]=0;
		this.risNecessarie[3]=0;
	}
	
	/**
	 * verfica che sia soddisfatto il requisito di piazzamento della carta
	 * quindi se sul rispettivo campo di gioco ci sono le risorse richieste
	 * @return true se e soddisfatto altrimenti torna false
	 */

	public boolean VerificaPrerequisito(int[] vettoreRisorse) { 
		
		for(int i=0; i<this.getRisNecessarie().length; i++) {
			/*confronto le celle dei 2 array delle stesse posizioni che indicano
			 * il numero di quella determintata risorsa che il giocatore 
			 * possiede e che la cOro richiede x esser giocata... 
			 * se il giocatore ne ha di meno vuol dire che non ne ha abbastanza
			 * x giocare quella carta*/
			if(vettoreRisorse[i]<this.getRisNecessarie()[i]) {
				return false; 
			}
		}
		return true;
	}
	public Simbolo getObiettivo() {
		return this.obbiettivo;
	}

	
	public void retro() {
		super.retro();
	}
	
	public int[] getRisNecessarie() {
		return this.risNecessarie;
	}
	
	@Override
	/** torna una stringa con tutte le informazioni della carta 
	 * utile per capire le carte della mano
	 * @return String
	 */
	public String toString() {
		return "Carata oro " + super.toString() +
				"\n\t\t Obbiettivo -> " + obbiettivo +
				"\n\t\t Simbolo -> " + this.getSimbolo() +
				"\n\t\t Colore -> " + this.getColore() +
				"\n\t\t Angoli:" +
				"\n\t\t\tAlto sx -> " + this.getAngoli()[0].getSimbolo() +
				"\n\t\t\tAlto dx -> " + this.getAngoli()[1].getSimbolo() +
				"\n\t\t\tBasso dx -> "+ this.getAngoli()[2].getSimbolo() +
				"\n\t\t\tBasso sx -> "+ this.getAngoli()[3].getSimbolo() +
				"\n\t\t Risorsa necessarie:" +
				"\n\t\t\tFoglie -> " + risNecessarie[0]+
				"\n\t\t\tLupo -> " + risNecessarie[1] +
				"\n\t\t\tFungo -> " + risNecessarie[2] +
				"\n\t\t\tFarfalla -> " + risNecessarie[3] + "]";
	}
	/** torna una stringa le informazioni della carta una volta
	 * che è stata piazzata sul campo, se e stata piazzata sul fronte 
	 * da le informazioni relative solo al fronte e analogalmente se
	 * piazzata sul retro
	 * @return String
	 */
	public String toStringBreve() {
		
		String str = "Carata oro " + this.getIdCarta() +
					 ":\n\t\t[Simbolo -> " + this.getSimbolo() +
					 "\n\t\t Colore -> " + this.getColore();
		if(this.getFronte()) {
			str += ":\n\t\t Angoli fronte:" +
					"\n\t\t\tAlto sx -> " + this.getAngoli()[0].toString() +
					"\n\t\t\tAlto dx -> " + this.getAngoli()[1].toString() +
					"\n\t\t\tBasso dx -> " + this.getAngoli()[2].toString() +
					"\n\t\t\tBasso sx -> " + this.getAngoli()[3].toString() + "]";
		}else {
			str += "\n\t\t Angoli retro:" +
					"\n\t\t\tAlto sx -> " + this.getAngoli()[0].getSimbolo() +
					"\n\t\t\tAlto dx -> " + this.getAngoli()[1].getSimbolo() +
					"\n\t\t\tBasso dx -> " + this.getAngoli()[2].getSimbolo() +
					"\n\t\t\tBasso sx -> " + this.getAngoli()[3].getSimbolo() + "]";
		}
		
		return str;
		
	}

	/**
	 * le carte oro possono dare dei punti al loro piazzamento se viene
	 * realizzato l obiettivo richeisto dalla carta in questione
	 * il quale puo essere una risorsa da avere o il coprire angoli
	 * con la carta
	 * @return i punti della carta * le volte di realizzazione del
	 * mini obiettivo della carta oro
	 */
	public int calcolaMiniObb(String posizione, Giocatore giocatore) { 
		if(this.obbiettivo==Simbolo.ASSENTE) {
			return this.getPunti();
		}
		
		if(this.obbiettivo==Simbolo.INCHIOSTRO) {
			return (giocatore.getOggPosseduti()[0]*this.getPunti())+1;
		}
		if(this.obbiettivo==Simbolo.PERGAMENA) {
			return (giocatore.getOggPosseduti()[1]*this.getPunti())+1;
		}
		if(this.obbiettivo==Simbolo.PIUMA) {
			return (giocatore.getOggPosseduti()[2]*this.getPunti())+1;
		}
		if(this.getObiettivo()==Simbolo.ANGOLO) {
			String[] splittedString = posizione.split(",");
			int posY = Integer.parseInt(splittedString[0]);
			int posX = Integer.parseInt(splittedString[1]);
			int angoliCoperti=0;
			Carta[][] campoAttuale = giocatore.getCampoG().getCampo();
			/*controllo se nelle celle adiacenti ci sono carte e i relativi angoli se verranno
			 * coperti*/
			if(campoAttuale[posY-1][posX-1]!=null && !(((CGiocabili)campoAttuale[posY-1][posX-1]).getAngoli()[2].getCoperto())){
				angoliCoperti++;
			}
			if(campoAttuale[posY+1][posX-1]!=null && !(((CGiocabili)campoAttuale[posY+1][posX-1]).getAngoli()[1].getCoperto())){
				angoliCoperti++;
			}
			if(campoAttuale[posY-1][posX+1]!=null && !(((CGiocabili)campoAttuale[posY-1][posX+1]).getAngoli()[3].getCoperto())){
				angoliCoperti++;
			}
			if(campoAttuale[posY+1][posX+1]!=null && !(((CGiocabili)campoAttuale[posY+1][posX+1]).getAngoli()[0].getCoperto())){
				angoliCoperti++;
			}
			return this.getPunti()*angoliCoperti;
		}	
		return 0;
	}
	
}
