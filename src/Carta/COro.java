package Carta;
import java.util.*;
import Enumerazione.*;
import Tavolo.CampoGioco;
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
public class COro extends Carta{
	private final int IDCARTA; //identificativo univoco di ogni carta risors
	// va da 40 a 79 tot 40 carte risorsa
	private static int lastId=40;
	private final Angolo[] angoli = new Angolo[4];
	private final Simbolo simbolo;
	private final Colore colore;
	private final Simbolo obbiettivo;
	private boolean fronte;
	private final int[] risNecessarie = new int[4]; /*sono i requisiti (quindi 
	le risorse da avere sul proprio campo) per poter piazzare la carta oro
	sul fronte*/
	private boolean contataScala; //x capire se la carta e stata contata x obiettivo scala
	private boolean contataL; //x capire se la carta e stata contata x obiettivo L

	public COro(int puntiAssegnati,  Simbolo obbiettivo,
			Simbolo simbolo, Colore colore, Simbolo angolo0, Simbolo angolo1,
			Simbolo angolo2, Simbolo angolo3, int risnecessaria1,
			int risnecessaria2, int risnecessaria3, 
			int risnecessaria4) {
		super(puntiAssegnati);
		this.obbiettivo=obbiettivo;
		this.angoli[0]=new Angolo(angolo0);
		this.angoli[1]=new Angolo(angolo1);
		this.angoli[2]=new Angolo(angolo2);
		this.angoli[3]=new Angolo(angolo3);
		this.IDCARTA=COro.lastId;
		COro.lastId++;
		this.simbolo=simbolo;
		this.colore=colore;
		this.fronte=true;
		this.risNecessarie[0]=risnecessaria1;
		this.risNecessarie[1]=risnecessaria2;
		this.risNecessarie[2]=risnecessaria3;
		this.risNecessarie[3]=risnecessaria4;
		// TODO Auto-generated constructor stub
	}
	
	public COro(Simbolo simbolo, Colore colore, int IDCARTA) {
		super(0);
		this.angoli[0]=new Angolo(Simbolo.VUOTO);
		this.angoli[1]=new Angolo(Simbolo.VUOTO);
		this.angoli[2]=new Angolo(Simbolo.VUOTO);
		this.angoli[3]=new Angolo(Simbolo.VUOTO);
		this.colore=colore;
		this.IDCARTA=IDCARTA;
		this.simbolo=simbolo;
		this.fronte=false;
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
<<<<<<< HEAD
	public boolean VerificaPrerequisito(Giocatore giocatore) { 
		
		for(int i=0; i<this.getRisNecessarie().length; i++) {
			/*confronto le celle dei 2 array delle stesse posizioni che indicano
			 * il numero di quella determintata risorsa che il giocatore 
			 * possiede e che la cOro richiede x esser giocata... 
			 * se il giocatore ne ha di meno vuol dire che non ne ha abbastanza
			 * x giocare quella carta*/
			if(giocatore.getRisPossedute()[i]<this.getRisNecessarie()[i]) {
				return false; 
			}
		}
		return true;
=======
	public boolean VerificaPrerequistio(int[] vettoreRisorse) { 
		int ok=0;
		for(int i=0; i<risNecessarie.length; i++) {
			if(risNecessarie[i]<=vettoreRisorse[i])
				ok++;
		}
		if(ok==4)
			return true;
		else
			return false;
>>>>>>> 223e696b9f49afa1eff4145cf86c40ef9c51b850
	}
	public Simbolo getObiettivo() {
		return this.obbiettivo;
	}
	public Angolo[] getAngoli() {
		return this.angoli;
	}
	public Simbolo getSimbolo() {
		return this.simbolo;
	}
	public Colore getColore() {
		return this.colore;
	}
	public int[] getRisNecessarie() {
		return this.risNecessarie;
	}
	public void retro() {
		this.fronte=false;
	}
	public boolean getFronte() {
		return this.fronte;
	}
	@Override
	public int getIDCARTA() {
		return this.IDCARTA;
	}

	@Override
	public String toString() {
		return "Carata oro " + IDCARTA +
				":\n\t\t[" + super.toString() +
				"\n\t\t Obbiettivo -> " + obbiettivo +
				"\n\t\t Simbolo -> " + simbolo +
				"\n\t\t Colore -> " + colore +
				"\n\t\t Angoli:" +
				"\n\t\t\tAlto sx -> " + angoli[0].getSimbolo() +
				"\n\t\t\tAltro dx -> " + angoli[1].getSimbolo() +
				"\n\t\t\tBasso dx -> "+angoli[2].getSimbolo() +
				"\n\t\t\tBasso sx -> "+angoli[3].getSimbolo() +
				"\n\t\t Risorsa necessarie:" +
				"\n\t\t\tFoglie -> " + risNecessarie[0]+
				"\n\t\t\tLupo -> " + risNecessarie[1] +
				"\n\t\t\tFungo -> " + risNecessarie[2] +
				"\n\t\t\tFarfalla -> " + risNecessarie[3] + "]";
		
		/*if(risNecessarie[0]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+ "risorsa lupo necessaria= " + risNecessarie[1]+"\n" 
					+"risora fungo necessaria= "+risNecessarie[2]+"\n"+"risorsa farfalla necessaria= "+risNecessarie[3]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[1]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+ "risorsa foglie necessaria= " + risNecessarie[0]+"\n" 
					+"risora fungo necessaria= "+risNecessarie[2]+"\n"+"risorsa farfalla necessaria= "+risNecessarie[3]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[2]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+ "risorsa foglie necessaria= " + risNecessarie[0]+"\n" 
					+"risora lupo necessaria= "+risNecessarie[1]+"\n"+"risorsa farfalla necessaria= "+risNecessarie[3]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[3]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+ "risorsa foglie necessaria= " + risNecessarie[0]+"\n" 
					+"risora lupo necessaria= "+risNecessarie[1]+"\n"+"risorsa fungo necessaria= "+risNecessarie[2]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[0]==0 && risNecessarie[1]==0 && risNecessarie[2]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+ "risorsa farfalla necessaria= "+risNecessarie[3]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[0]==0 && risNecessarie[1]==0 && risNecessarie[3]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+"risorsa fungo necessaria= "+ risNecessarie[2]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[2]==0 && risNecessarie[1]==0 && risNecessarie[3]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+ "risorsa foglie necessaria= " + risNecessarie[0]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[2]==0 && risNecessarie[0]==0 && risNecessarie[3]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n" +"risora lupo necessaria= "+risNecessarie[1]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[0]==0 && risNecessarie[1]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+"risora fungo necessaria= "+risNecessarie[2]+"\n"+"risorsa farfalla necessaria= "+risNecessarie[3]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[0]==0 && risNecessarie[2]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+"risora lupo necessaria= "+risNecessarie[1]+"\n"+"risorsa farfalla necessaria= "+risNecessarie[3]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[0]==0 && risNecessarie[3]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+"risora fungo necessaria= "+risNecessarie[2]+"\n"+"risorsa lupo necessaria= "+risNecessarie[1]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[1]==0 && risNecessarie[2]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+"risora foglie necessaria= "+risNecessarie[0]+"\n"+"risorsa farfalla necessaria= "+risNecessarie[3]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[1]==0 && risNecessarie[3]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+"risora foglie necessaria= "+risNecessarie[0]+"\n"+"risorsa fungo necessaria= "+risNecessarie[2]+"\n"+super.toString()+ "]";
		}else if(risNecessarie[2]==0 && risNecessarie[3]==0) {
			return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
					"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
					+"\n"+ "obbiettivo= " + obbiettivo +"\n"+"risora foglie necessaria= "+risNecessarie[0]+"\n"+"risorsa lupo necessaria= "+risNecessarie[1]+"\n"+super.toString()+ "]";
		}
		
		return "Carta oro: [angolo alto sinistro= " + angoli[0]+"\n"+"angolo alto destro= "+angoli[1]+"\n"+"angolo basso destro= "+angoli[2]+
				"\n"+"angolo basso sinistro= "+angoli[3]+"\n" + "simbolo= " + simbolo +"\n"+ "colore= " + colore
				+"\n"+ "obbiettivo= " + obbiettivo +"\n"+ "risorse foglia necessarie= " + risNecessarie[0]+"\n"+"rsorse lupo necessarie= "+risNecessarie[1]+"\n" 
				+"risorse fungo necessarie= "+risNecessarie[2]+"\n"+"risorse farfalla necessarie= "+risNecessarie[3]+"\n"+super.toString()+ "]";
	*/
	}

	public boolean isContataScala() {
		return this.contataScala;
	}

	public void setContataScala(boolean contataScala) {
		this.contataScala = contataScala;
	}

	public boolean isContataL() {
		return this.contataL;
	}

	public void setContataL(boolean contataL) {
		this.contataL = contataL;
	}

	public int calcolaMiniObb(String posizione, Giocatore giocatore) { 
		// TODO Auto-generated method stub
		if(this.getObiettivo()==Simbolo.FOGLIA) {
			return giocatore.getOggPosseduti()[0]*this.getPunti();
		}
		if(this.getObiettivo()==Simbolo.LUPO) {
			return giocatore.getOggPosseduti()[1]*this.getPunti();
		}
		if(this.getObiettivo()==Simbolo.FUNGO) {
			return giocatore.getOggPosseduti()[2]*this.getPunti();
		}
		if(this.getObiettivo()==Simbolo.FARFALLA) {
			return giocatore.getOggPosseduti()[3]*this.getPunti();
		}
		if(this.getObiettivo()==Simbolo.ANGOLO) {
			String[] splittedString = posizione.split(",");
			int posY = Integer.parseInt(splittedString[0]);
			int posX = Integer.parseInt(splittedString[1]);
			int angoliCoperti=0;
			/*controllo se nelle celle adiacenti ci sono carte e i relativi angoli se verranno
			 * coperti*/
			if(giocatore.getCampoG().getCampo()[posY-1][posX-1]!=null 
					&& giocatore.getCampoG().getCampo()[posY-1][posX-1].getAngoli()[2].getCoperto()){
				angoliCoperti++;
			}
			if(giocatore.getCampoG().getCampo()[posY+1][posX-1]!=null 
					&& giocatore.getCampoG().getCampo()[posY+1][posX-1].getAngoli()[1].getCoperto()){
				angoliCoperti++;
			}
			if(giocatore.getCampoG().getCampo()[posY-1][posX+1]!=null 
					&& giocatore.getCampoG().getCampo()[posY-1][posX+1].getAngoli()[3].getCoperto()){
				angoliCoperti++;
			}
			if(giocatore.getCampoG().getCampo()[posY+1][posX+1]!=null 
					&& giocatore.getCampoG().getCampo()[posY+1][posX+1].getAngoli()[0].getCoperto()){
				angoliCoperti++;
			}
			return this.getPunti()*angoliCoperti;
		}	
		return 0;
	}
}
