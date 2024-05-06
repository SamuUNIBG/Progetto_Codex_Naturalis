package Logica;

import java.util.ArrayList;


import java.util.Scanner;

import Carta.CObb;
import Enumerazione.TipoCarta;
import Tavolo.CartaTavolo;
import Tavolo.Giocatore;
import Tavolo.Tracciato;

public class LogicaGioco {
	
	private CartaTavolo cartaTavolo;
	
	private Tracciato tracciato;
	private int numGiocatori;

	public LogicaGioco() {
		
		Scanner sc = new Scanner(System.in);
		
		//(char)233 é (char)224 à
		
		System.out.println("Nuova partita di Codex Naturalis avviata!");
		
		cartaTavolo = new CartaTavolo();
		tracciato = new Tracciato();
		numGiocatori = tracciato.getNumGiocatori();
		
		for(int i=0; i<numGiocatori; i++) {
			ArrayList<CObb> cObb = new ArrayList<CObb>();
			for(int j=0; j<2; j++) {
				tracciato.getGiocatore(i).pescaC(cartaTavolo.pesca(TipoCarta.CRis));
				cObb.add((CObb)cartaTavolo.pesca(TipoCarta.CObb));
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
	public LogicaGioco(ArrayList<String> username, ArrayList<String> userColor) {
		
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

	private void Turni() {
		
		Giocatore giocatoreAttuale;
		boolean punti20 = false;
		boolean ultimoGiro = false;
		
		for(int i=0; i<numGiocatori; i++) {
			
			giocatoreAttuale = tracciato.getGiocatore(i);				
			giocatoreAttuale.giocaCIniz();
			
		}
		
		do {
			
			if(punti20)
					ultimoGiro = true;
			
			for(int i=0; i<numGiocatori; i++) {
				
				giocatoreAttuale = tracciato.getGiocatore(i);				
				giocatoreAttuale.giocaC();
				
				if(!ultimoGiro)
					pescaCarta(giocatoreAttuale);
				
				if(giocatoreAttuale.getPunteggio() > 19 || (cartaTavolo.getMazzoOro().getCRimaste()==0 && cartaTavolo.getMazzoRis().getCRimaste()==0)) {
					punti20 = true;
				}
				
			}
			
		}while(!ultimoGiro);
		
		AddPuntiObb();
		
	}

	private void pescaCarta(Giocatore giocatoreAttuale) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Le carte risorsa scoperte in questo momento sul tavolo sono:\n");
		for(int i=0;i<cartaTavolo.getcRisScp().size();i++) {
			cartaTavolo.getcRisScp().get(i).toString();
		}
		System.out.println("Le carte oro scoperte in questo momento sul tavolo sono:\n");
		for(int i=0;i<cartaTavolo.getcOroScp().size();i++) {
			cartaTavolo.getcOroScp().get(i).toString();
		}
		System.out.println("Il colore della prima carta del mazzo delle carte risorsa Ã¨:\n ");
		System.out.println(cartaTavolo.getMazzoRis().getCMazzo().get(0).getColore()+"\n");
		System.out.println("Il colore della prima carta del mazzo delle carte oro Ã¨:\n ");
		System.out.println(cartaTavolo.getMazzoOro().getCMazzo().get(0).getColore()+"\n");
		System.out.println("Che cosa scegli?\n "+"1= pesca mazzo carte risorsa\n"+"2= pesca mazzo carte oro\n"+
		"3= pesca una carta risorsa scoperta\n"+"4=pesca una carta oro scoperta\n");
		int scelta=0;
		do {
			scelta=sc.nextInt();
			if(scelta<1 ) {
				System.out.println("Non puoi inserire un valore minore di 1,riprovare!");
			}else if(scelta>4) {
				System.out.println("Non puoi inserire un valore maggiore di 4, riprovare!");
			}
			
		}while(scelta<1 ||scelta>4);
		
		if(scelta ==1) {
			if(cartaTavolo.getMazzoRis().getCRimaste()==0) {
				System.out.println("Le carte risorsa sono finite, inserire un altro metodo di pesca\n");
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
				System.out.println("Le carte Oro sono finite, inserire un altro metodo di pesca\n");
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
				System.out.println("hai pescato la prima carta del mazzo carte risorse correttamente!");
				giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.CRis));
				break;
			case 2:
				System.out.println("hai pescato la prima carta del mazzo carte oro correttamente!");
				giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.COro));
				break;
				
			case 3:
				System.out.println("Quale carta risorsa scoperta vuoi pescare?\n"+
						"1= prima\n"+"2=seconda\n");
				int sceltaCartaRisSc=0;
				do {
					sceltaCartaRisSc=sc.nextInt();
					if(sceltaCartaRisSc<1) {
						System.out.println("Non puoi inserire un numero minore di 1, riprovare!");
					}else if(sceltaCartaRisSc>2) {
						System.out.println("Non puoi inserire un numero maggiore di 2, riprovare!");
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
					if(sceltaCartaoroSc<1) {
						System.out.println("Non puoi inserire un numero minore di 1, riprovare!");
					}else if(sceltaCartaoroSc>2) {
						System.out.println("Non puoi inserire un numero maggiore di 2, riprovare!");
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

	private void AddPuntiObb() {
		
		ArrayList<CObb> cObb = cartaTavolo.getcObbScp();
		
		for(int i=0; i<numGiocatori; i++) {			
			cObb.get(0).calcolaObb(tracciato.getGiocatore(i));
			cObb.get(1).calcolaObb(tracciato.getGiocatore(i));
			CObb cObbPers = tracciato.getGiocatore(i).getCObbPer();
			cObbPers.calcolaObb(tracciato.getGiocatore(i));
		}
		
		Vincitore();
		
	}
	
	private void Vincitore() {
		
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
