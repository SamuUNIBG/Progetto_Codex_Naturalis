package Logica;

import java.util.ArrayList;
import java.util.Scanner;

import Carta.CIniz;
import Carta.CObb;
import Carta.COro;
import Carta.CRis;
import Carta.CGiocabiliSpeciali;

import Enumerazione.Simbolo;
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
		
		//(char)233 e' (char)224 a'
		
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
			System.out.println(Character.toUpperCase((char)233) + " il turno di: " + tracciato.getGiocatore(i).getSoprannome() + ", colore -> " + tracciato.getGiocatore(i).getColore() + ", punti -> " + tracciato.getGiocatore(i).getPunteggio());
			System.out.println("Carte obbiettivo da scegliere:");
			System.out.println("0)" + cObb.get(0).toString());
			System.out.println("1)" + cObb.get(1).toString());
			
			int scelta=-1;
			do {
				
				try {
					System.out.print("Inserire scelta: ");
					scelta = Integer.parseInt(sc.nextLine());
					if(scelta<0||scelta>1) {
						System.out.println("ERRORE! Sono solo consetiti 1 e 0 come scelta, riprovare");
					}
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
			}while(scelta<0||scelta>1);
			
						
			tracciato.getGiocatore(i).pescaC(cObb.get(scelta));
			tracciato.getGiocatore(i).pescaC(cartaTavolo.pesca(TipoCarta.COro));
			tracciato.getGiocatore(i).pescaC(cartaTavolo.pesca(TipoCarta.CIniz));
		}
		
		Turni();
		
	}

	public void Turni() {
		
		Giocatore giocatoreAttuale;
		boolean punti20 = false;
		boolean ultimoGiro = false;
		int nGiro = 0;
		
		for(int i=0; i<numGiocatori; i++) {
			
			giocatoreAttuale = tracciato.getGiocatore(i);	
			System.out.println(Character.toUpperCase((char)233) + " il turno di: " + giocatoreAttuale.getSoprannome() + ", colore -> " + giocatoreAttuale.getColore() + ", punti -> " + giocatoreAttuale.getPunteggio());
			giocaCIniz(giocatoreAttuale);
			
		}
		
		do {
			
			nGiro++;
			
			if(punti20) {
					ultimoGiro = true;
					System.out.println("Giro numero: " + nGiro);
					System.out.println("ATTENZIONE! Ultimo giro");
			}else
				System.out.println("Giro numero: " + nGiro);
			
			
			
			for(int i=0; i<numGiocatori; i++) {
				giocatoreAttuale = tracciato.getGiocatore(i);
				System.out.println(Character.toUpperCase((char)233) + " il turno di: " + giocatoreAttuale.getSoprannome() + ", colore -> " + giocatoreAttuale.getColore() + ", punti -> " + giocatoreAttuale.getPunteggio());
				opzioniTurno();
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
	
	private boolean giocaCIniz(Giocatore giocatoreAttuale) {
		
		int retro=-1;
		CIniz cInizAttuale=giocatoreAttuale.getCInizPer();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("La carta iniziale in tuo possesso");
		System.out.println(cInizAttuale.toString());
		
		do {
			try {
				System.out.print("Vuoi giocare la carta sul retro? [0(si) - 1(no)]: ");
				retro = Integer.parseInt(sc.nextLine());
				
			}catch(NumberFormatException ex) {
				
				System.out.println("Non puoi inserire una stringa");
				
			}
			
		}while(retro!=0 && retro!=1);
		
		//se la carta e' stata giocata sul retro si setta l'attributo fronte=false
		if(retro==0) {
			cInizAttuale.retro();
		}
		
		giocatoreAttuale.getCPiazzate().add(cInizAttuale.toStringBreve());
		giocatoreAttuale.piazzaC("40,40", cInizAttuale);
		
		if(retro==1) {
			//aggiunge al vettore delle risorse possedute le risorse centrali della carta
			for(int i=0; i<cInizAttuale.getRisorseCentrali().size(); i++) {
				if(cInizAttuale.getRisorseCentrali().get(i)==Simbolo.FOGLIA) {
					giocatoreAttuale.getRisPossedute()[0]+=1;
				}else if(cInizAttuale.getRisorseCentrali().get(i)==Simbolo.LUPO) {
					giocatoreAttuale.getRisPossedute()[1]+=1;
				}else if(cInizAttuale.getRisorseCentrali().get(i)==Simbolo.FUNGO) {
					giocatoreAttuale.getRisPossedute()[2]+=1;
				}else if(cInizAttuale.getRisorseCentrali().get(i)==Simbolo.FARFALLA) {
					giocatoreAttuale.getRisPossedute()[3]+=1;
				}
			}
		}
		
		return true;
		
	}
	
	private void opzioniTurno() {
		
		int opz=-1, continua=-1;
		
		
		Scanner sc = new Scanner(System.in);
		
		do {
			do {
				try {
					System.out.println("Azioni disponibili: ");
					System.out.println("1)Visualizzare le carte comuni");//tutte compres i mazzi e gli obb
					System.out.println("2)Visualizzare il campo degli avversari");//possibilit� di scegliere l'avversario
					System.out.println("3)Visualizzare il tracciato segnapunti");//verr� mostrato elenco giocatori con info su punteggio ris e ogg posseduti
					System.out.println("4)Giocare una carta");
					System.out.println("Inserire il numero corrispondente all'azione da compiere: ");
					opz = Integer.parseInt(sc.nextLine());
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
			}while(opz<1 || opz>4);
			
			switch(opz) {
				case 1:
					//mostro mazzi, carte scoperte e carte obbiettivo
					System.out.println("Le carte presenti sul tavolo:");
					System.out.println("1)Le prime carte dei mazzi:");
					System.out.println("\tIl colore della prima carta del mazzo delle carte risorsa " + (char)233 + ": " + cartaTavolo.getMazzoRis().getCMazzo().get(0).getColore() + "[Carte rimanenti: " + cartaTavolo.getMazzoRis().getCMazzo().size() + "]");
					System.out.println("\tIl colore della prima carta del mazzo delle carte oro " + (char)233 + ": " + cartaTavolo.getMazzoOro().getCMazzo().get(0).getColore() + "[Carte rimanenti: " + cartaTavolo.getMazzoOro().getCMazzo().size() + "]");
					System.out.println("3)Le carte risorsa scoperte:");
					for(int i=0;i<cartaTavolo.getcRisScp().size();i++) {
						System.out.println("\t" + cartaTavolo.getcRisScp().get(i).toString());
						
					}
					System.out.println("4)Le carte oro scoperte:");
					for(int i=0;i<cartaTavolo.getcOroScp().size();i++) {
						System.out.println("\t" + cartaTavolo.getcOroScp().get(i).toString());
					}
					System.out.println("5)Le carte obbiettivo:");
					for(int i=0;i<cartaTavolo.getcObbScp().size();i++) {
						System.out.println("\t" + cartaTavolo.getcObbScp().get(i).toString());
					}
					break;
				case 2:
					int opzC=-1;
					System.out.println("Campi da gioco osservabili:");
					for(int i=0; i<numGiocatori; i++) {
						System.out.println((i+1) + ")Campo di " + tracciato.getGiocatore(i).getSoprannome());
					}
					do {
						try {
							System.out.println("Inserire il numero corrispondente al campo da visualizzare: ");
							opzC = Integer.parseInt(sc.nextLine());
							if(opzC<1 || opzC>numGiocatori)
								System.out.println("ERRORE! Numero inserito non valido, riprovare");
							
						}catch(NumberFormatException ex) {
							
							System.out.println("Non puoi inserire una stringa");
							
						}
						
					}while(opzC<1 || opzC>numGiocatori);
					tracciato.getGiocatore(opzC-1).getCampoG().print(tracciato.getGiocatore(opzC-1));
					break;
				case 3:
					//mostra nome, colore, punti, ris possedute e ogg posseduti
					for(int i=0; i<numGiocatori; i++) {
						System.out.println((i+1) + ")" + tracciato.getGiocatore(i).toString());
					}
					break;
				case 4:
					return;
			}
			
			do {
				try {
					System.out.println("Desideri esegiore altre azioni? [0(si) - 1(no)]: ");
					continua =  Integer.parseInt(sc.nextLine());
					if(continua!=0 && continua!=1) {
						System.out.println("ERRORE! I numeri consentiti sono 1 e 0, riprovare!");
					}
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
			}while(continua!=0 && continua!=1);
			if(continua==1)
				System.out.println("ATTENZIONE! " + (char)233 + " obbligatorio eseguire l'azione gioca carta");
		}while(continua==0);
		
		return;
	}
	
	private boolean giocaC(Giocatore giocatoreAttuale) {
		
		Scanner sc = new Scanner(System.in);
		int numCarta=-1, posY=-1, posX=-1, retro = -1;
		String posCarta;
		boolean posCartaOk=false, preRequisito=false;
		CGiocabiliSpeciali carta;
		CampoGioco campoAttuale=giocatoreAttuale.getCampoG();
		ArrayList<CGiocabiliSpeciali> cManoAttuale=giocatoreAttuale.getCMano();
		
		//viene mostrato a schermo il campo di gioco del giocatore e le sue carte
		System.out.println("Il tuo campo di gioco:");
		campoAttuale.print(giocatoreAttuale);
		
		System.out.println("\nLe carte in tuo possesso:");
		System.out.println("0)" + giocatoreAttuale.getCObbPer().toString());
		for(int i=0; i<3; i++) {
			System.out.println((i+1) + ") " + cManoAttuale.get(i).toString());
		}
		
		do {
			//il giocatore sceglie quale carta giocare e su che faccia
			do {
				try {
					System.out.print("Inserire il numero relativo alla carta da giocare: ");
					numCarta = Integer.parseInt(sc.nextLine());
					if(numCarta<1 || numCarta>3) {
						System.out.println("ATTENZIONE! Si possono inserire solo i numeri delle carte sopraelencate, rirpovare!");
					}
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
			}while(numCarta<1 || numCarta>3);
			
			do {
				try {
					System.out.print("Vuoi giocare la carta sul retro? [0(si) - 1(no)]: ");
					retro = Integer.parseInt(sc.nextLine());
					if(retro<0 || retro>1) {
						System.out.println("ATTENZIONE! Si possono inserire solo i numeri 0 e 1, riprovare!");
					}
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
			}while(retro<0 || retro>1);
			
			numCarta--;
			
			carta = cManoAttuale.get(numCarta);
			
			//controllo giocabilit e' carta oro
			if(carta instanceof COro && retro==1) {
				if(((COro)carta).VerificaPrerequisito(giocatoreAttuale.getRisPossedute()))
					preRequisito = true;
				else
					System.out.println("ERRORE! Risorse insufficienti, riprovare");
			}else
				preRequisito = true;					
		}while(!preRequisito);
		
		cManoAttuale.remove(numCarta);
		
		//il giocatore sceglie dove giocare la carta
		System.out.println("Posizioni (y,x) dove e' possibile posizionare la carta:");
			System.out.println(campoAttuale.getPosizioniDisponibili());
		
		do {
			do {
				try {
					System.out.print("Inserire le coordinate y di dove si vuole giocare la carta: ");
					posY =  Integer.parseInt(sc.nextLine());
					if(posY<0 || posY>CampoGioco.dimensioneY) {
						System.out.println("Numero non valido, riprovare!");
					}
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
			}while(posY<0 || posY>CampoGioco.dimensioneY);
			do {
				try {
					System.out.print("Inserire le coordinate x di dove si vuole giocare la carta: ");
					posX =  Integer.parseInt(sc.nextLine());
					if(posX<0 || posX>CampoGioco.dimensioneX) {
						System.out.println("ERRORE! Numero non valido, riprovare");
					}
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
			}while(posX<0 || posX>CampoGioco.dimensioneX);
			posCarta = posY + "," + posX;
			for(int i=0; i<campoAttuale.getPosizioniDisponibili().size(); i++) {
				if(posCarta.equals(campoAttuale.getPosizioniDisponibili().get(i)))
					posCartaOk = true;
			}
			if(!posCartaOk)
				System.out.println("ERRORE! Coordinata non valida, riprovare");
		}while(!posCartaOk);
		
		//se la carta e' stata giocata sul retro si crea una nuova carta
		if(retro==0) {
			if(carta instanceof CRis) {
				CRis cartaRetro= new CRis(((CRis)carta).getSimbolo(), ((CRis)carta).getColore(), ((CRis)carta).getIdCarta());
				cManoAttuale.set(numCarta, cartaRetro);
			}else if(carta instanceof COro) {
				COro cartaRetro= new COro(((CRis)carta).getSimbolo(), ((CRis)carta).getColore(), ((CRis)carta).getIdCarta());
				cManoAttuale.set(numCarta, cartaRetro);
			}
		}else {
			int puntiCarta = carta.getPunti();
			if(carta instanceof COro)
				puntiCarta = ((COro)carta).calcolaMiniObb(posCarta, giocatoreAttuale);
				giocatoreAttuale.addPunteggio(puntiCarta);
		}
		
		giocatoreAttuale.getCPiazzate().add(carta.toStringBreve());
		giocatoreAttuale.piazzaC(posCarta, carta);
		
		return true;
	}

	public void pescaCarta(Giocatore giocatoreAttuale) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Le carte a disposizione per la pesca:");
		System.out.println("Le prime carte dei mazzi:");
		System.out.println("\t1)Il colore della prima carta del mazzo delle carte risorsa " + (char)233 + ": " + cartaTavolo.getMazzoRis().getCMazzo().get(0).getColore() + "[Carte rimanenti: " + cartaTavolo.getMazzoRis().getCMazzo().size() + "]");
		System.out.println("\t2)Il colore della prima carta del mazzo delle carte oro " + (char)233 + ": " + cartaTavolo.getMazzoOro().getCMazzo().get(0).getColore() + "[Carte rimanenti: " + cartaTavolo.getMazzoOro().getCMazzo().size() + "]");
		System.out.println("3)Le carte risorsa scoperte:");
		for(int i=0;i<cartaTavolo.getcRisScp().size();i++) {
			System.out.println("\t" + cartaTavolo.getcRisScp().get(i).toString());
			
		}
		System.out.println("4)Le carte oro scoperte:");
		for(int i=0;i<cartaTavolo.getcOroScp().size();i++) {
			System.out.println("\t" + cartaTavolo.getcOroScp().get(i).toString());
		}
		
		int scelta=-1;
		do {
			try {
				System.out.print("Inserire il numero relativo alla carta da pescare: ");
				scelta=Integer.parseInt(sc.nextLine());
				if(scelta<1 || scelta >4) {
					System.out.println("ERRORE! Numero inserito non valido, riprovare");
				}
				
			}catch(NumberFormatException ex) {
				
				System.out.println("Non puoi inserire una stringa");
				
			}
			
			
		}while(scelta<1 ||scelta>4);
		
		if(scelta ==1) {
			if(cartaTavolo.getMazzoRis().getCRimaste()==0) {
				System.out.println("ERRORE! Le carte risorsa sono finite, inserire un altro metodo di pesca");
				do {
					try {
						System.out.println("Che cosa scegli?\n "+"2= pesca mazzo carte oro\n"+
								"3= pesca una carta risorsa scoperta\n"+"4=pesca una carta oro scoperta\n");
						scelta=Integer.parseInt(sc.nextLine());
						if(scelta<2) {
							System.out.println("Non puoi inserire un valore minore di 2,riprovare!");
						}else if(scelta>4) {
							System.out.println("Non puoi inserire un valore maggiore di 4,riprovare!");
						}
						
					}catch(NumberFormatException ex) {
						
						System.out.println("Non puoi inserire una stringa");
						
					}
					
				}while(scelta<2 || scelta>4);
				
			}
		}
		if(scelta==2) {
			if(cartaTavolo.getMazzoOro().getCRimaste()==0) {
				System.out.println("ERRORE! Le carte Oro sono finite, inserire un altro metodo di pescan");
				do {
					try {
						System.out.println("Che cosa scegli?\n "+"1= pesca mazzo carte risorsa\n"+
								"3= pesca una carta risorsa scoperta\n"+"4=pesca una carta oro scoperta\n");
						scelta=Integer.parseInt(sc.nextLine());
						if(scelta<1) {
							System.out.println("Non puoi inserire un valore minore di 1,riprovare!");
						}else if(scelta>4) {
							System.out.println("Non puoi inserire un valore maggiore di 4,riprovare!");
						}else if(scelta==2) {
							System.out.println("Non puoi inserire un valore uguale a 2,riprovare!");
						}
						
					}catch(NumberFormatException ex) {
						
						System.out.println("Non puoi inserire una stringa");
						
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
				int sceltaCartaRisSc=-1;
				do {
					try {
						sceltaCartaRisSc=Integer.parseInt(sc.nextLine());
						if(sceltaCartaRisSc<1 || sceltaCartaRisSc >2) {
							System.out.println("ERRORE! Numero inserito non valido, riprovare");
						}
						
					}catch(NumberFormatException ex) {
						
						System.out.println("Non puoi inserire una stringa");
						
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
				int sceltaCartaoroSc=-1;
				do {
					try {
						sceltaCartaoroSc=Integer.parseInt(sc.nextLine());
						if(sceltaCartaoroSc<1 || sceltaCartaoroSc >2) {
							System.out.println("ERRORE! Numero inserito non valido, riprovare");
						}
						
					}catch(NumberFormatException ex) {
						
						System.out.println("Non puoi inserire una stringa");
						
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
