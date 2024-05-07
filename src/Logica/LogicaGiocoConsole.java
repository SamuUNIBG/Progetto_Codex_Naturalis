package Logica;

import java.util.ArrayList;



import java.util.Scanner;

import Carta.CIniz;
import Carta.CObb;
import Carta.COro;
import Carta.CRis;
import Carta.Carta;
import Enumerazione.TipoCarta;
import Tavolo.CampoGioco;
import Tavolo.CartaTavolo;
import Tavolo.Giocatore;
import Tavolo.Tracciato;

public class LogicaGiocoConsole implements InterfacciaLogica {
	
	private CartaTavolo cartaTavolo;
	
	private Tracciato tracciato;
	private int numGiocatori;

	public LogicaGiocoConsole() {
		
		Scanner sc = new Scanner(System.in);
		
		//(char)233 � (char)224 �
		
		System.out.println("\nNuova partita di Codex Naturalis avviata!");
		
		cartaTavolo = new CartaTavolo();
		tracciato = new Tracciato();
		numGiocatori = tracciato.getNumGiocatori();
		
		for(int i=0; i<numGiocatori; i++) {
			ArrayList<CObb> cObb = new ArrayList<CObb>();
			for(int j=0; j<2; j++) {
				tracciato.getGiocatore(i).pescaC(cartaTavolo.pesca(TipoCarta.CRis));
				cObb.add((CObb)cartaTavolo.pesca(TipoCarta.CObb));
			}
			System.out.println("Carte obbiettivo da scegliere:");
			System.out.println("0)" + cObb.get(0).toString());
			System.out.println("1)" + cObb.get(1).toString());
			System.out.print("Inserire scelta: ");
			
			int scelta = sc.nextInt();
						
			tracciato.getGiocatore(i).pescaC(cObb.get(scelta));
			tracciato.getGiocatore(i).pescaC(cartaTavolo.pesca(TipoCarta.COro));
			tracciato.getGiocatore(i).pescaC(cartaTavolo.pesca(TipoCarta.CIniz));
		}
		
		Turni();
		
	}
	
	//needed only for graphics input
	public LogicaGiocoConsole(ArrayList<String> username, ArrayList<String> userColor) {
		
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

	public void Turni() {
		
		Giocatore giocatoreAttuale;
		boolean punti20 = false;
		boolean ultimoGiro = false;
		
		for(int i=0; i<numGiocatori; i++) {
			
			giocatoreAttuale = tracciato.getGiocatore(i);				
			giocaCIniz(giocatoreAttuale);
			
		}
		
		do {
			
			if(punti20)
					ultimoGiro = true;
			
			for(int i=0; i<numGiocatori; i++) {
				
				giocatoreAttuale = tracciato.getGiocatore(i);
				giocaC(giocatoreAttuale);
					
				if(!ultimoGiro)
					pescaCarta(giocatoreAttuale);
				
				if(giocatoreAttuale.getPunteggio() > 19 || (cartaTavolo.getMazzoOro().getCRimaste()==0 && cartaTavolo.getMazzoRis().getCRimaste()==0)) {
					punti20 = true;
				}
				
			}
			
		}while(!ultimoGiro);
		
		AddPuntiObb();
		
	}
	
	public boolean giocaCIniz(Giocatore giocatoreAttuale) {
		
		int retro;
		CIniz cInizAttuale=giocatoreAttuale.getCInizPer();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("La carta iniziale in tuo possesso");
		System.out.println(cInizAttuale.toString());
		
		do {
			System.out.print("Vuoi giocare la carta sul retro? [0(si) - 1(no)]: ");
			retro = sc.nextInt();
		}while(retro!=0 && retro!=1);
		
		//sc.close();
		
		//se la carta e' stata giocata sul retro si setta l'attributo fronte=false
		if(retro==0) {
			cInizAttuale.retro();
		}
		
		giocatoreAttuale.piazzaC("40,40", cInizAttuale);
		
		return true;
		
	}
	
	public boolean giocaC(Giocatore giocatoreAttuale) {
		
		Scanner sc = new Scanner(System.in);
		int numCarta, posY, posX, retro = 0;
		String posCarta;
		boolean posCartaOk=false, preRequisito=false;
		Carta carta;
		CampoGioco campoAttuale=giocatoreAttuale.getCampoG();
		ArrayList<Carta> cManoAttuale=giocatoreAttuale.getCMano();
		
		//viene mostrato a schermo il campo di gioco del giocatore e le sue carte
		System.out.println("Il tuo campo di gioco:");
		campoAttuale.print();
		//stampa legenda
		System.out.println("Legenda:");
		for(int i=0; i<giocatoreAttuale.getCPiazzate().size(); i++) {
			System.out.println(giocatoreAttuale.getCPiazzate().get(i));
		}
		System.out.println("\nLe carte in tuo possesso:");
		System.out.println("0)" + giocatoreAttuale.getCObbPer().toString());
		for(int i=0; i<3; i++) {
			System.out.println((i+1) + ") " + cManoAttuale.get(i).toString());
		}
		
		do {
			//il giocatore sceglie quale carta giocare e su che faccia
			do {
				System.out.print("Inserire il numero relativo alla carta da giocare: ");
				numCarta = sc.nextInt();
			}while(numCarta<1 || numCarta>3);
			
			do {
				System.out.print("Vuoi giocare la carta sul retro? [0(si) - 1(no)]: ");
				retro = sc.nextInt();
			}while(retro!=0 && retro!=1);
			
			numCarta--;
			
			carta = cManoAttuale.get(numCarta);
			
			//controllo giocabilit e' carta oro
			if(carta instanceof COro && retro==1) {
				if(((COro)carta).VerificaPrerequistio(giocatoreAttuale.getRisPossedute()))
					preRequisito = true;
			}else
				preRequisito = true;					
		}while(!preRequisito);
		
		//il giocatore sceglie dove giocare la carta
		System.out.println("Posizioni (y,x) dove e' possibile posizionare la carta:");
			System.out.println(campoAttuale.getPosizioniDisponibili());
		
		do {
			do {
				System.out.print("Inserire le coordinate y di dove si vuole giocare la carta: ");
				posY = sc.nextInt();
			}while(posY<0 || posY>CampoGioco.dimensioneY);
			do {
				System.out.print("Inserire le coordinate x di dove si vuole giocare la carta: ");
				posX = sc.nextInt();
			}while(posX<0 || posX>CampoGioco.dimensioneX);
			posCarta = posY + "," + posX;
			for(int i=0; i<campoAttuale.getPosizioniDisponibili().size(); i++) {
				if(posCarta.equals(campoAttuale.getPosizioniDisponibili().get(i)))
					posCartaOk = true;
			}
		}while(!posCartaOk);
		
		//se la carta e' stata giocata sul retro si crea una nuova carta
		if(retro==0) {
			if(carta instanceof CRis) {
				CRis cartaRetro= new CRis(carta.getSimbolo(), carta.getColore(), carta.getIDCARTA());
				cManoAttuale.set(numCarta, cartaRetro);
			}else if(carta instanceof COro) {
				COro cartaRetro= new COro(carta.getSimbolo(), carta.getColore(), carta.getIDCARTA());
				cManoAttuale.set(numCarta, cartaRetro);
			}
		}else {
			int puntiCarta = carta.getPunti();
			if(carta instanceof COro)
				puntiCarta = ((COro)carta).calcolaMiniObb(posCarta, giocatoreAttuale);
			giocatoreAttuale.addPunteggio(puntiCarta);
		}
		
		giocatoreAttuale.piazzaC(posCarta, carta);
		
		return true;
	}

	public void pescaCarta(Giocatore giocatoreAttuale) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Le carte a disposizione per la pesca:");
		System.out.println("Le prime carte dei mazzi:");
		System.out.println("\t1)Il colore della prima carta del mazzo delle carte risorsa" + (char)233 + ": " + cartaTavolo.getMazzoRis().getCMazzo().get(0).getColore());
		System.out.println("\t2)Il colore della prima carta del mazzo delle carte oro" + (char)233 + ": " + cartaTavolo.getMazzoOro().getCMazzo().get(0).getColore());
		System.out.println("3)Le carte risorsa scoperte:");
		for(int i=0;i<cartaTavolo.getcRisScp().size();i++) {
			System.out.println("\t" + cartaTavolo.getcRisScp().get(i).toString());
			
		}
		System.out.println("4)Le carte oro scoperte:");
		for(int i=0;i<cartaTavolo.getcOroScp().size();i++) {
			System.out.println("\t" + cartaTavolo.getcOroScp().get(i).toString());
		}
		
		int scelta=0;
		do {
			System.out.print("Inserire il numero relativo alla carta da pescare: ");
			scelta=sc.nextInt();
			if(scelta<1 || scelta >4) {
				System.out.println("ERRORE! Numero inserito non valido, riprovare");
			}
			
		}while(scelta<1 ||scelta>4);
		
		if(scelta ==1) {
			if(cartaTavolo.getMazzoRis().getCRimaste()==0) {
				System.out.println("ERRORE! Le carte risorsa sono finite, inserire un altro metodo di pesca");
				do {
					
					System.out.println("Che cosa scegli?\n "+"2= pesca mazzo carte oro\n"+
							"3= pesca una carta risorsa scoperta\n"+"4=pesca una carta oro scoperta\n");
					scelta=sc.nextInt();
					if(scelta<2) {
						System.out.println("Non puoi inserire un valore minore di 2,riprovare!");
					}else if(scelta>4) {
						System.out.println("Non puoi inserire un valore maggiore di 4,riprovare!");
					}
				}while(scelta<2 || scelta>4);
				
			}
		}
		if(scelta==2) {
			if(cartaTavolo.getMazzoOro().getCRimaste()==0) {
				System.out.println("ERRORE! Le carte Oro sono finite, inserire un altro metodo di pescan");
				do {
					
					System.out.println("Che cosa scegli?\n "+"1= pesca mazzo carte risorsa\n"+
							"3= pesca una carta risorsa scoperta\n"+"4=pesca una carta oro scoperta\n");
					scelta=sc.nextInt();
					if(scelta<1) {
						System.out.println("Non puoi inserire un valore minore di 1,riprovare!");
					}else if(scelta>4) {
						System.out.println("Non puoi inserire un valore maggiore di 4,riprovare!");
					}else if(scelta==2) {
						System.out.println("Non puoi inserire un valore uguale a 2,riprovare!");
					}
				}while(scelta<1|| scelta>4|| scelta==2);
			}
		}
			
			switch(scelta) {
			case 1:
				System.out.println("Hai pescato la prima carta del mazzo carte risorse correttamente!");
				giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.CRis));
				break;
			case 2:
				System.out.println("Hai pescato la prima carta del mazzo carte oro correttamente!");
				giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.COro));
				break;
				
			case 3:
				System.out.println("Quale carta risorsa scoperta vuoi pescare?\n"+
						"1= prima\n"+"2=seconda\n");
				int sceltaCartaRisSc=0;
				do {
					sceltaCartaRisSc=sc.nextInt();
					if(sceltaCartaRisSc<1 || sceltaCartaRisSc >2) {
						System.out.println("ERRORE! Numero inserito non valido, riprovare");
					}
					
				}while(sceltaCartaRisSc<1 ||sceltaCartaRisSc>2);
				if(sceltaCartaRisSc==1) {
					giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.CRis,sceltaCartaRisSc-1));
				}else {
					giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.CRis,sceltaCartaRisSc-1));
				}
				break;
			case 4:
				System.out.println("Quale carta oro scoperta vuoi pescare?\n"+
						"1= prima\n"+"2=seconda\n");
				int sceltaCartaoroSc=0;
				do {
					sceltaCartaoroSc=sc.nextInt();
					if(sceltaCartaoroSc<1 || sceltaCartaoroSc >2) {
						System.out.println("ERRORE! Numero inserito non valido, riprovare");
					}
					
				}while(sceltaCartaoroSc<1 ||sceltaCartaoroSc>2);
				if(sceltaCartaoroSc==1) {
					giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.COro,sceltaCartaoroSc-1));
				}else {
					giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.COro,sceltaCartaoroSc-1));
				}
				break;
		
		
			
		}
	}

	public void AddPuntiObb() {
		
		ArrayList<CObb> cObb = cartaTavolo.getcObbScp();
		
		for(int i=0; i<numGiocatori; i++) {			
			cObb.get(0).calcolaObb(tracciato.getGiocatore(i));
			cObb.get(1).calcolaObb(tracciato.getGiocatore(i));
			CObb cObbPers = tracciato.getGiocatore(i).getCObbPer();
			cObbPers.calcolaObb(tracciato.getGiocatore(i));
		}
		
		Vincitore();
		
	}
	
	public void Vincitore() {
		
		int maxPunti=tracciato.getGiocatore(0).getPunteggio();
		ArrayList<String> giocatore = new ArrayList<String>();
		giocatore.add(tracciato.getGiocatore(0).getSoprannome());
		
		for(int i=1; i<numGiocatori; i++) {
			int punti = tracciato.getGiocatore(i).getPunteggio();
			if(punti > maxPunti) {
				giocatore.clear();
				giocatore.add(tracciato.getGiocatore(i).getSoprannome());
				maxPunti = punti;
			}else if(punti == maxPunti) {
				giocatore.add(tracciato.getGiocatore(i).getSoprannome());
			}
		}
		if(giocatore.size()==1) {
			System.out.println("Ha vinto solo un giocatore:\n");
		}else {
			System.out.println("Hanno vinto "+giocatore.size()+" giocatori:\n");
		}
		for(int i=0;i<giocatore.size();i++) {
				System.out.println("Congratulazioni "+giocatore.get(i)+" hai vinto!\n");
			}
		
		
	}
	
}
