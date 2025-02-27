package Logica;

import java.util.ArrayList;
import java.util.Scanner;

import Carta.CIniz;
import Carta.CObb;
import Carta.COro;
import Carta.CRis;
import Eccezioni.IdCartaException;
import Eccezioni.PuntiAssegnatiException;
import Carta.CGiocabiliSpeciali;
import Enumerazione.Simbolo;
import Enumerazione.TipoCarta;

import Tavolo.CampoGioco;
import Tavolo.CartaTavolo;
import Tavolo.Giocatore;
import Tavolo.Tracciato;
/**
 * classe per giocare da linea di comando
 */
public class LogicaGiocoConsole implements InterfacciaLogica {
	private ArrayList<String> username;
	private ArrayList<String> colori;
	private String coloreScelto;
	private ArrayList<String> coloriDisp=new ArrayList<String>();
	private CartaTavolo cartaTavolo;
	private Tracciato tracciato;
	private int numGiocatori;

	public LogicaGiocoConsole() throws PuntiAssegnatiException, IdCartaException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nNuova partita di Codex Naturalis avviata!");
		
		cartaTavolo = new CartaTavolo();
		creazioneTracciato();
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
	
	private int quantiGiocatori() {
		int nGiocatori=0;
		Scanner sc=new Scanner(System.in);
		do {
			try {
				System.out.print("Inserire numero di giocatori [minimo: 2 massimo: 4]: ");
				 nGiocatori=Integer.parseInt(sc.nextLine());
				if(nGiocatori<=1 ||nGiocatori>=5) {
					System.out.println("ERRORE! Numero giocatori non valido, riprovare");
				}
			}catch(NumberFormatException ex){
				System.out.println("Non puoi inserire una stringa");
				
			}
			
		}while(nGiocatori<=1 || nGiocatori>=5);
		System.out.println("Giocherete in: " + nGiocatori);
		return nGiocatori;
	}
	
	public void creazioneTracciato() {
		//popolo l'array dei colori
		coloriDisp.add("Rosso");
		coloriDisp.add("Azzurro");
		coloriDisp.add("Giallo");
		coloriDisp.add("Verde");
		boolean cRosso=true;
		boolean cAzzurro=true;
		boolean cGiallo=true;
		boolean cVerde=true;
		
		System.out.println("\nCreazione giocatori");
		int giocatori=quantiGiocatori();
		username=new ArrayList<String>(giocatori);
		colori=new ArrayList<String>(giocatori);
		Scanner sc=new Scanner(System.in);
		System.out.println("\nATTENZIONE! Il primo giocatore creato sara' il primo ad iniziare");
		System.out.println("ATTENZIONE! Eventuali spazi nei soprannomi verranno rimossi");
		for(int i=0;i<giocatori;i++) {
				 
			System.out.println("\nCreazione giocatore " + (i+1));
			System.out.print("Inserire il soprannome: ");
			String soprannome=sc.nextLine();
				
			//tolgo spazi vuoti tra i nomi
			String s=new String(); //temporanea per salvare i nomi con spazi e cancellare spazi
			s=soprannome.replace(" ", "");
			System.out.println("\nPedine disponibili: ");
			if(i!=0) {
				for(int j=0;j<coloriDisp.size();j++) {		
					if(cRosso==false && coloriDisp.get(j).equals("Rosso")) {
						System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
					}else if(cAzzurro==false && coloriDisp.get(j).equals("Azzurro")) {
						System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
					}else if(cGiallo==false && coloriDisp.get(j).equals("Giallo")) {
						System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
					}else if(cVerde==false && coloriDisp.get(j).equals("Verde")) {
						System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
					}else {
						System.out.println(j+1+")"+coloriDisp.get(j));
					}	
				}	
			}else {
				for(int j=0;j<coloriDisp.size();j++) {
					System.out.println(j+1+")"+coloriDisp.get(j));
				}
			}
				
			int colore=0;
			do {
				try {
					System.out.print("Inserire il numero corrispondente alla pedina desiderata [da 1 a 4]: ");
					colore = Integer.parseInt(sc.nextLine());
				
					if(colore<1 || colore >4) {
						System.out.println("ERRORE! Numero inserito non valido, riprovare");
					}
					
				}catch(NumberFormatException ex) {
							
					System.out.println("Non puoi inserire una stringa");
				}
						
			}while(colore<1 || colore>4);
			
			if(colore==1) {
				coloreScelto="Rosso";
				cRosso=false;
			}else if(colore==2) {
				coloreScelto="Azzurro";
				cAzzurro=false;
			}else if(colore==3) {
				coloreScelto="Giallo";
				cGiallo=false;
			}else if(colore==4) {
				coloreScelto="Verde";
				cVerde=false;
			}
					
					
			switch(colore){
			case 1:
				System.out.println("Colore Rosso selezionato");
				if(i!=0) {//al primo giro non faccio il controllo, in quanto non ci sono nomi,colori
					//controllo nomi uguali
					for(String user: username) {
						do {
							if(user.trim().equals(s)) {
								System.out.println("ERRORE! Non puoi inserire nomi utenti uguali, riprovare!\n");
								System.out.print("Inserire il soprannome: ");
								String nomeModificato=sc.nextLine();
								s=nomeModificato.replace(" ", "");
										
							}
						}while(user.trim().equals(s));
					}
					//controllo colori uguali
					for(int k=0;k<colori.size();k++) {
						do {
							if(colori.get(k).equals(coloreScelto)) {
								System.out.println("Non puoi inserire colori uguali, riprovare!\n");
								System.out.println("Pedine disponibili:");
								if(i!=0) {
									for(int j=0;j<coloriDisp.size();j++) {
										
										if(cRosso==false && coloriDisp.get(j).equals("Rosso")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cAzzurro==false && coloriDisp.get(j).equals("Azzurro")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cGiallo==false && coloriDisp.get(j).equals("Giallo")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cVerde==false && coloriDisp.get(j).equals("Verde")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else {
											System.out.println(j+1+")"+coloriDisp.get(j));
										}
											
								}
											
								}else {
									for(int j=0;j<coloriDisp.size();j++) {
										System.out.println(j+1+")"+coloriDisp.get(j));
									}
								}
										
								do {
									try {
										System.out.print("Inserire il numero corrispondente alla pedina desiderata [da 1 a 4]: ");
										colore = Integer.parseInt(sc.nextLine());
										if(colore<1 || colore >4) {
											System.out.println("ERRORE! Numero inserito non valido, riprovare");
										}
										
									}catch(NumberFormatException ex) {
										
										System.out.println("Non puoi inserire una stringa");
									}
									
								}while(colore<1 || colore>4);
								
								if(colore==1) {
									System.out.println("Hai selezionato il colore Rosso");
									coloreScelto="Rosso";
									cRosso=false;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro");
									coloreScelto="Azzurro";
									cAzzurro=false;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo");
									coloreScelto="Giallo";
									cGiallo=false;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde");
									coloreScelto="Verde";
									cVerde=false;
								}
							}
						}while(coloriDisp.get(k).equals(coloreScelto));
							
					}
					
					username.add(s);
					colori.add(coloreScelto);
				
				}else {
					username.add(s);
					colori.add("Rosso");
				}
				break;
			case 2:
				System.out.println("Colore Azzurro selezionato");
				if(i!=0) {//al primo giro non faccio il controllo, in quanto non ci sono nomi,colori
					//controllo nomi uguali
					for(String user: username) {
						do {
							if(user.trim().equals(s)) {
								System.out.println("ERRORE! Non puoi inserire nomi utenti uguali, riprovare!\n");
								System.out.print("Inserire il soprannome: ");
								String nomeModificato=sc.nextLine();
								s=nomeModificato.replace(" ", "");
										
							}
						}while(user.trim().equals(s));
					}
					//controllo colori uguali
					for(int k=0;k<colori.size();k++) {
						do {
							if(colori.get(k).equals(coloreScelto)) {
								System.out.println("Non puoi inserire colori uguali, riprovare!\n");								
								System.out.println("Pedine disponibili:");
								if(i!=0) {
									for(int j=0;j<coloriDisp.size();j++) {
												
										if(cRosso==false && coloriDisp.get(j).equals("Rosso")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cAzzurro==false && coloriDisp.get(j).equals("Azzurro")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cGiallo==false && coloriDisp.get(j).equals("Giallo")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cVerde==false && coloriDisp.get(j).equals("Verde")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else {
											System.out.println(j+1+")"+coloriDisp.get(j));
										}
										
								}
								
								}else {
									for(int j=0;j<coloriDisp.size();j++) {
									System.out.println(j+1+")"+coloriDisp.get(j));
									}
								}
										
								do {
									try {
										
										System.out.print("Inserire il numero corrispondente alla pedina desiderata [da 1 a 4]: ");
										colore = Integer.parseInt(sc.nextLine());
										if(colore<1 || colore >4) {
											System.out.println("ERRORE! Numero inserito non valido, riprovare");
										}
										
									}catch(NumberFormatException ex) {
												
										System.out.println("Non puoi inserire una stringa");
									}
										
											
								}while(colore<1 || colore>4);
										
								if(colore==1) {
									System.out.println("Hai selezionato il colore Rosso");
									coloreScelto="Rosso";
									cRosso=false;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro");
									coloreScelto="Azzurro";
									cAzzurro=false;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo");
									coloreScelto="Giallo";
									cGiallo=false;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde");
									coloreScelto="Verde";
									cVerde=false;
								}
							}
						}while(colori.get(k).equals(coloreScelto));
						
					}
					username.add(s);
					colori.add(coloreScelto);
				}else {
					username.add(s);
					colori.add("Azzurro");
				}
				break;
			case 3:
				System.out.println("Colore Giallo selezionato");
				if(i!=0) {//al primo giro non faccio il controllo, in quanto non ci sono nomi,colori
					//controllo nomi uguali
					for(String user: username) {
						do {
							if(user.trim().equals(s)) {
								System.out.println("ERRORE! Non puoi inserire nomi utenti uguali, riprovare!\n");
								System.out.print("Inserire il soprannome: ");
								String nomeModificato=sc.nextLine();
								s=nomeModificato.replace(" ", "");
										
							}
						}while(user.trim().equals(s));
					}
					//controllo colori uguali
					for(int k=0;k<colori.size();k++) {
						do {
							if(colori.get(k).equals(coloreScelto)) {
								System.out.println("Non puoi inserire colori uguali, riprovare!\n");
								if(i!=0) {
									for(int j=0;j<coloriDisp.size();j++) {
										
										if(cRosso==false && coloriDisp.get(j).equals("Rosso")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cAzzurro==false && coloriDisp.get(j).equals("Azzurro")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cGiallo==false && coloriDisp.get(j).equals("Giallo")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cVerde==false && coloriDisp.get(j).equals("Verde")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else {
											System.out.println(j+1+")"+coloriDisp.get(j));
										}
											
									}
											
								}else {
									for(int j=0;j<coloriDisp.size();j++) {
										System.out.println(j+1+")"+coloriDisp.get(j));
									}
								}
										
								do {
									try{
										System.out.print("Inserire il numero corrispondente alla pedina desiderata [da 1 a 4]: ");
										colore = Integer.parseInt(sc.nextLine());
										if(colore<1 || colore >4) {
											System.out.println("ERRORE! Numero inserito non valido, riprovare");
										}
										
									}catch(NumberFormatException ex) {
										
										System.out.println("Non puoi inserire una stringa");
									}
									
								}while(colore<1 || colore>4);
								
								if(colore==1) {
									System.out.println("Hai selezionato il colore Rosso");
									coloreScelto="Rosso";
									cRosso=false;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro");
									coloreScelto="Azzurro";
									cAzzurro=false;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo");
									coloreScelto="Giallo";
									cGiallo=false;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde");
									coloreScelto="Verde";
									cVerde=false;
								}
							}
						}while(colori.get(k).equals(coloreScelto));
								
					}
					username.add(s);
					colori.add(coloreScelto);
				}else {
					username.add(s);
					colori.add("Giallo");
				}
				break;
			case 4:
				System.out.println("Colore Verde selezionato\n");
				if(i!=0) {//al primo giro non faccio il controllo, in quanto non ci sono nomi,colori
					//controllo nomi uguali
					for(String user: username) {
						do {
							if(user.trim().equals(s)) {
								System.out.println("ERRORE! Non puoi inserire nomi utenti uguali, riprovare!\n");
								System.out.print("Inserire il soprannome: ");
								String nomeModificato=sc.nextLine();
								s=nomeModificato.replace(" ", "");
										
							}
						}while(user.trim().equals(s));
					}
					//controllo colori uguali
					for(int k=0;k<colori.size();k++) {
						do {
							if(colori.get(k).equals(coloreScelto)) {
								System.out.println("Non puoi inserire colori uguali, riprovare!\n");
								System.out.println("Pedine disponibili:");
								if(i!=0) {
									for(int j=0;j<coloriDisp.size();j++) {
										
										if(cRosso==false && coloriDisp.get(j).equals("Rosso")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cAzzurro==false && coloriDisp.get(j).equals("Azzurro")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cGiallo==false && coloriDisp.get(j).equals("Giallo")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else if(cVerde==false && coloriDisp.get(j).equals("Verde")) {
											System.out.println(j+1+")"+coloriDisp.get(j)+"<--Gi" + (char)224 + " scelto");
										}else {
											System.out.println(j+1+")"+coloriDisp.get(j));
										}
												
								}
										
								}else {
									for(int j=0;j<coloriDisp.size();j++) {
										System.out.println(j+1+")"+coloriDisp.get(j));
									}
								}
								do {
									try{
										System.out.print("Inserire il numero corrispondente alla pedina desiderata [da 1 a 4]: ");
										colore = Integer.parseInt(sc.nextLine());
										if(colore<1 || colore >4) {
											System.out.println("ERRORE! Numero inserito non valido, riprovare");
										}
											
									}catch(NumberFormatException ex) {
											
										System.out.println("Non puoi inserire una stringa");
									}
											
								}while(colore<1 || colore>4);
							
								do {
									if(colore<1 || colore >4) {
										System.out.println("Numero inserito non valido. Si possono mettere numeri da 1 a 4!\n");
									}
								}while(colore<1 || colore>4);
								
								if(colore==1) {
									System.out.println("Hai selezionato il colore Rosso");
									coloreScelto="Rosso";
									cRosso=false;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro");
									coloreScelto="Azzurro";
									cAzzurro=false;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo");
									coloreScelto="Giallo";
									cGiallo=false;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde");
									coloreScelto="Verde";
									cVerde=false;
								}
							}
						}while(colori.get(k).equals(coloreScelto));
								
					}
					username.add(s);
					colori.add(coloreScelto);
				}else { 
					username.add(s);
					colori.add("Verde");
				}
				break;
			}	
					
		}
				
		tracciato = new Tracciato(username,colori);
	}
	
	@Override
	/**
	 * metodo per la gestione dei turni, regola anche la fine della partita
	 * nel caso un giocatore sia arrivato a 20 punti, che da avvio
	 * all ultimo giro
	 */
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
				
				if(cartaTavolo.getMazzoRis().getCMazzo().size()!=0 || cartaTavolo.getMazzoOro().getCMazzo().size()!=0 || cartaTavolo.getcRisScp().size()!=0 || cartaTavolo.getcOroScp().size()!=0) {
					if(!ultimoGiro)
						pescaCarta(giocatoreAttuale);
				}
				
				if(giocatoreAttuale.getPunteggio() > 19 || (cartaTavolo.getMazzoOro().getCRimaste()==0 && cartaTavolo.getMazzoRis().getCRimaste()==0)) {
					punti20 = true;
				}
				
			}
			
		}while(!ultimoGiro);
		
		AddPuntiObb();
		
	}
	/**
	 * gestice la giocata della carta iniziale di ciascun giocatore
	 * @param giocatoreAttuale
	 * @return true quando e stata giocata
	 */
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
		
		giocatoreAttuale.getCPiazzate().put(cInizAttuale.getIdCarta(), cInizAttuale.toStringBreve());
		giocatoreAttuale.piazzaC(giocatoreAttuale.getCPiazzate(), "40,40", cInizAttuale);
		
		if(retro==1) {
			//aggiunge al vettore delle risorse possedute le risorse centrali della carta
			for(Simbolo s: cInizAttuale.getRisorseCentrali()) {
				if(s==Simbolo.FOGLIA) {
					giocatoreAttuale.getRisPossedute()[0]+=1;
				}else if(s==Simbolo.LUPO) {
					giocatoreAttuale.getRisPossedute()[1]+=1;
				}else if(s==Simbolo.FUNGO) {
					giocatoreAttuale.getRisPossedute()[2]+=1;
				}else if(s==Simbolo.FARFALLA) {
					giocatoreAttuale.getRisPossedute()[3]+=1;
				}
			}
		}
		
		return true;
		
	}
	/**
	 * metodo richiamato all inizio del turno di ogni giocatore
	 * che mostra un menu con le azioni possibili per il giocatore,
	 * in base al numero che sceglie verranno richiamati i metodi utili
	 * per l azione desiderata
	 */
	private void opzioniTurno() {
		
		int opz=-1, continua=-1;
		
		
		Scanner sc = new Scanner(System.in);
		
		do {
			do {
				try {
					System.out.println("Azioni disponibili: ");
					System.out.println("1)Visualizzare le carte comuni");//tutte compres i mazzi e gli obb
					System.out.println("2)Visualizzare il campo degli avversari");//possibilita' di scegliere l'avversario
					System.out.println("3)Visualizzare il tracciato segnapunti");//verra' mostrato elenco giocatori con info su punteggio ris e ogg posseduti
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
					for(CRis c: cartaTavolo.getcRisScp()) {
						System.out.println("\t" + c.toString());
					}
					System.out.println("4)Le carte oro scoperte:");
					for(COro c: cartaTavolo.getcOroScp()) {
						System.out.println("\t" + c.toString());
					}
					System.out.println("5)Le carte obbiettivo:");
					for(CObb c: cartaTavolo.getcObbScp()) {
						System.out.println("\t" + c.toString());
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
	/**
	 * metodo che gestisce la giocata della carta del giocatore
	 * @param giocatoreAttuale
	 * @return true quando tutto e andato a buon fine e il giocatore
	 * ha piazzato la propria carta con successo
	 *
	 */
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
		for(int i=0; i<cManoAttuale.size(); i++) {
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
				
			}while(numCarta<1 || numCarta>cManoAttuale.size());
			
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
					if(posY<0 || posY>CampoGioco.DIMENSIONEY) {
						System.out.println("Numero non valido, riprovare!");
					}
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
			}while(posY<0 || posY>CampoGioco.DIMENSIONEY);
			do {
				try {
					System.out.print("Inserire le coordinate x di dove si vuole giocare la carta: ");
					posX =  Integer.parseInt(sc.nextLine());
					if(posX<0 || posX>CampoGioco.DIMENSIONEX) {
						System.out.println("ERRORE! Numero non valido, riprovare");
					}
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
			}while(posX<0 || posX>CampoGioco.DIMENSIONEX);
			posCarta = posY + "," + posX;
			
			for(String p: campoAttuale.getPosizioniDisponibili()) {
				if(posCarta.equals(p))
					posCartaOk = true;
			}
			if(!posCartaOk)
				System.out.println("ERRORE! Coordinata non valida, riprovare");
		}while(!posCartaOk);
		
		//se la carta e' stata giocata sul retro si crea una nuova carta
		if(retro==0) {
			if(carta instanceof CRis) {
				CRis cartaRetro;
				try {
					cartaRetro = new CRis(((CRis)carta).getSimbolo(), ((CRis)carta).getColore(), ((CRis)carta).getIdCarta());
					carta = cartaRetro;
				} catch (PuntiAssegnatiException | IdCartaException e) {
					e.printStackTrace();
				}
			}else if(carta instanceof COro) {
				COro cartaRetro;
				try {
					cartaRetro = new COro(((COro)carta).getSimbolo(), ((COro)carta).getColore(), ((COro)carta).getIdCarta());
					carta = cartaRetro;
				} catch (PuntiAssegnatiException | IdCartaException e) {
					e.printStackTrace();
				}
			}
		}else {
			int puntiCarta = carta.getPunti();
			if(carta instanceof COro)
				puntiCarta = ((COro)carta).calcolaMiniObb(posCarta, giocatoreAttuale);
				giocatoreAttuale.addPunteggio(puntiCarta);
		}
		
		giocatoreAttuale.getCPiazzate().put(carta.getIdCarta(), carta.toStringBreve());
		giocatoreAttuale.piazzaC(giocatoreAttuale.getCPiazzate(), posCarta, carta);
		
		
		return true;
	}
	/**
	 * metodo per gestire la pescata da parte del giocatore
	 * mostrando le carte scoperte pescabili e il colore della prima 
	 * carta di ogni mazzo
	 */

	public void pescaCarta(Giocatore giocatoreAttuale) {
		boolean finiteRis=false;
		boolean finiteOro=false;
		boolean finiteScpOro=false;
		boolean finiteScpRis=false;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Le carte a disposizione per la pesca:");
		System.out.println("Le prime carte dei mazzi:");
		if(cartaTavolo.getMazzoRis().getCMazzo().size()!=0) {
			System.out.println("\t1)Il colore della prima carta del mazzo delle carte risorsa " + (char)233 + ": " + cartaTavolo.getMazzoRis().getCMazzo().get(0).getColore() + "[Carte rimanenti: " + cartaTavolo.getMazzoRis().getCMazzo().size() + "]");
		}else {
			
			finiteRis=true;
			System.out.println("\tcarte mazzo risorse finite");
		}
		if(cartaTavolo.getMazzoOro().getCMazzo().size()!=0) {
			System.out.println("\t2)Il colore della prima carta del mazzo delle carte oro " + (char)233 + ": " + cartaTavolo.getMazzoOro().getCMazzo().get(0).getColore() + "[Carte rimanenti: " + cartaTavolo.getMazzoOro().getCMazzo().size() + "]");
		}else {
			finiteOro =true;
			System.out.println("\tcarte mazzo oro finite");
		}
		
		
		System.out.println("3)Le carte risorsa scoperte:");
		if(cartaTavolo.getcRisScp().size()!=0) {
			for(CRis c: cartaTavolo.getcRisScp()) {
				System.out.println("\t" + c.toString());
			}
		}else {
			finiteScpRis=true;
			System.out.println("\t carte risorsa scoperte finite.");
		}
		System.out.println("4)Le carte oro scoperte:");
		if(cartaTavolo.getcOroScp().size()!=0) {
			for(COro c: cartaTavolo.getcOroScp()) {
				System.out.println("\t" + c.toString());
			}
		}else {
			finiteScpOro=true;
			System.out.println("\t carte oro scoperte finite.");
		}
		
		
		int scelta=-1;
		if(finiteOro==true && finiteRis==true && finiteScpOro==true && finiteScpRis==true) {
			System.out.println("Non " + (char)233 + " piu' possibile eseguire nessuna azione di pesca");
			
		}else if(finiteOro==false && finiteRis==false && finiteScpOro==false && finiteScpRis==false) {
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
		}else if(finiteScpRis==true && finiteRis==true && finiteOro==false) {
			do {
				try {
					System.out.print("Inserire il numero relativo alla carta da pescare: ");
					scelta=Integer.parseInt(sc.nextLine());
					if(scelta<2 || scelta >4 || scelta==3) {
						System.out.println("ERRORE! Numero inserito non valido, riprovare");
					}
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
				
			}while(scelta<2 ||scelta>4 || scelta==3);
		}else if(finiteScpRis==true && finiteRis==true && finiteOro==true) {
			do {
				try {
					System.out.print("Inserire il numero relativo alla carta da pescare: ");
					scelta=Integer.parseInt(sc.nextLine());
					if(scelta!=4) {
						System.out.println("ERRORE! Numero inserito non valido, riprovare");
					}
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
				
			}while(scelta!=4);
		}else if(finiteOro==true && finiteRis==false) {
			do {
				try {
					System.out.print("Inserire il numero relativo alla carta da pescare: ");
					scelta=Integer.parseInt(sc.nextLine());
					if(scelta<1 ||scelta>4|| scelta==2) {
						System.out.println("ERRORE! Numero inserito non valido, riprovare");
					}
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
				
			}while(scelta<1 ||scelta>4|| scelta==2);
		}else if(finiteRis==true && finiteOro==false) {
			do {
				try {
					System.out.print("Inserire il numero relativo alla carta da pescare: ");
					scelta=Integer.parseInt(sc.nextLine());
					if(scelta<1 ||scelta>4|| scelta==1) {
						System.out.println("ERRORE! Numero inserito non valido, riprovare");
					}
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
				
			}while(scelta<1 ||scelta>4|| scelta==1);
		}else if(finiteRis==true && finiteOro==true) {
			do {
				try {
					System.out.print("Inserire il numero relativo alla carta da pescare: ");
					scelta=Integer.parseInt(sc.nextLine());
					if(scelta<1 ||scelta>4|| scelta==1 || scelta==2) {
						System.out.println("ERRORE! Numero inserito non valido, riprovare");
					}
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
				
			}while(scelta<1 ||scelta>4|| scelta==1 || scelta==2);
		}  
		if(finiteScpOro==true && finiteOro==true && finiteRis==false) {
			do {
				try {
					System.out.print("Inserire il numero relativo alla carta da pescare: ");
					scelta=Integer.parseInt(sc.nextLine());
					if(scelta<1||scelta==2 || scelta >3) {
						System.out.println("ERRORE! Numero inserito non valido, riprovare");
					}
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
				
			}while(scelta<1||scelta==2 || scelta >3);
		}
		if(finiteScpOro==true && finiteRis==true && finiteOro==true) {
			do {
				try {
					System.out.print("Inserire il numero relativo alla carta da pescare: ");
					scelta=Integer.parseInt(sc.nextLine());
					if(scelta!=3) {
						System.out.println("ERRORE! Numero inserito non valido, riprovare");
					}
					
				}catch(NumberFormatException ex) {
					
					System.out.println("Non puoi inserire una stringa");
					
				}
				
				
			}while(scelta!=3);
		}

		if(finiteRis==false) {
			if(scelta==1) {
				System.out.println("Hai pescato la prima carta del mazzo carte risorse correttamente!");
				giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.CRis));
				
			}
		}
		
		if(finiteOro==false) {
			if(scelta==2) {
				System.out.println("Hai pescato la prima carta del mazzo carte oro correttamente!");
				giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.COro));
			}
		}
		
			
		switch(scelta) {
			case 3:
				if(cartaTavolo.getcRisScp().size()==1) {
					System.out.println("Puoi pescare solo la prima carta.\n"+
							"1= conferma\n");
					int sceltaCartaRisSc=-1;
					do {
						try {
							sceltaCartaRisSc=Integer.parseInt(sc.nextLine());
							if(sceltaCartaRisSc!=1) {
								System.out.println("ERRORE! Numero inserito non valido, riprovare");
							}
							
						}catch(NumberFormatException ex) {
							
							System.out.println("Non puoi inserire una stringa");
							
						}
						
						
					}while(sceltaCartaRisSc!=1);
					if(sceltaCartaRisSc==1) {
						giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.CRis,sceltaCartaRisSc-1));
					}
					break;
				}else{
					System.out.println("Quale carta risorsa scoperta vuoi pescare?\n"+
							"1= prima\n"+"2=seconda\n");
				}
				
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
				if(cartaTavolo.getcOroScp().size()==1) {
					System.out.println("Puoi pescare solo la prima carta.\n"+
							"1= conferma\n");
					int sceltaCartaoroSc=-1;
					do {
						try {
							sceltaCartaoroSc=Integer.parseInt(sc.nextLine());
							if(sceltaCartaoroSc!=1) {
								System.out.println("ERRORE! Numero inserito non valido, riprovare");
							}
							
						}catch(NumberFormatException ex) {
							
							System.out.println("Non puoi inserire una stringa");
							
						}
						
						
					}while(sceltaCartaoroSc!=1);
					if(sceltaCartaoroSc==1) {
						giocatoreAttuale.pescaC(cartaTavolo.pesca(TipoCarta.COro,sceltaCartaoroSc-1));
					}
					break;
				}else {
					System.out.println("Quale carta oro scoperta vuoi pescare?\n"+
							"1= prima\n"+"2=seconda\n");
				}
				
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
	
	@Override
	/**
	 * metodo che verrà richiamato alla fine della partita per contare
	 * i punti realizzati dai giocatori attraverso gli obiettivi ed 
	 * aggiungendoli ai punti già ottenuti
	 */
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
	
	@Override
	/**
	 * metodo che controlla chi e il vincitore in base a chi ha 
	 * ottenuto il punteggio piu alto e lo comunica
	 */
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
		for(String g: giocatore) {
			System.out.println("Congratulazioni "+g+" hai vinto!\n");
		}
		
		
	}
	
}
