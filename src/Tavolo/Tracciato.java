package Tavolo;

import java.util.*;

import Enumerazione.Colore;

public class Tracciato {
	private ArrayList<Giocatore> tabellone;
	private Colore coloreScelto;
	private String s;
	/**
	 * metodo che chiede di inserire il numero di giocatori e 
	 * e ne gestisce eventuali errori
	 * @return il numero di giocatori
	 */
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
	
	public Tracciato() {
	
		System.out.println("\nCreazione giocatori");
		
		int giocatori=quantiGiocatori();
		tabellone = new ArrayList<Giocatore>(giocatori);
		tabellone.clear();
		Scanner sc=new Scanner(System.in);
		System.out.println("\nATTENZIONE! Il primo giocatore creato sara' il primo ad iniziare");
		System.out.println("ATTENZIONE! Eventuali spazi nei soprannomi verranno rimossi");
		boolean primo=true, errore=false;
		for(int i=0;i<giocatori;i++) {
			
			System.out.println("\nCreazione giocatore " + (i+1));
			System.out.print("Inserire il soprannome: ");
			String soprannome=sc.nextLine();
				
			//tolgo spazi vuoti tra i nomi
			String s=new String(); //temporanea per salvare i nomi con spazi e cancellare spazi
			s=soprannome.replace(" ", "");
				
			System.out.println("\nPedine disponibili:\n1)Rosso\n"+ "2)Azzurro\n"+ "3)Giallo\n"+"4)Verde\n");
			
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
				coloreScelto=Colore.ROSSO;
			}else if(colore==2) {
				coloreScelto=Colore.AZZURRO;
			}else if(colore==3) {
				coloreScelto=Colore.GIALLO;
			}else if(colore==4) {
				coloreScelto=Colore.VERDE;
			}
			
			
			switch(colore){
			case 1:
				System.out.println("Colore Rosso selezionato");
				if(i!=0) {//al primo giro non faccio il controllo, in quanto non ci sono nomi,colori
					//controllo nomi uguali
					for(int j=0;j<tabellone.size();j++) {
						do {
							if(tabellone.get(j).getSoprannome().trim().equals(s)) {
								System.out.println("ERRORE! Non puoi inserire nomi utenti uguali, riprovare!\n");
								System.out.print("Inserire il soprannome: ");
								String nomeModificato=sc.nextLine();
								s=nomeModificato.replace(" ", "");
								
							}
						}while(tabellone.get(j).getSoprannome().trim().equals(s));
					}
					//controllo colori uguali
					for(int k=0;k<tabellone.size();k++) {
						do {
							if(tabellone.get(k).getColore().equals(coloreScelto)) {
								System.out.println("Non puoi inserire colori uguali, riprovare!\n");
								System.out.println("Pedine disponibili:\n1)Rosso\n2)Azzurro\n3)Giallo\n4)Verde\n");
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
									coloreScelto=Colore.ROSSO;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro");
									coloreScelto=Colore.AZZURRO;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo");
									coloreScelto=Colore.GIALLO;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde");
									coloreScelto=Colore.VERDE;
								}
							}
						}while(tabellone.get(k).getColore().equals(coloreScelto));
						
					}
					
					tabellone.add(new Giocatore(s,coloreScelto,primo));
				}else
					tabellone.add(new Giocatore(s,Colore.ROSSO,primo));
				break;
			case 2:
				System.out.println("Colore Azzurro selezionato");
				if(i!=0) {//al primo giro non faccio il controllo, in quanto non ci sono nomi,colori
					//controllo nomi uguali
					for(int j=0;j<tabellone.size();j++) {
						do {
							if(tabellone.get(j).getSoprannome().trim().equals(s)) {
								System.out.println("Non puoi inserire nomi utenti uguali, riprovare!\n");

								System.out.print("Inserire il soprannome: ");
								String nomeModificato=sc.nextLine();
								s=nomeModificato.replace(" ", "");
								
							}
						}while(tabellone.get(j).getSoprannome().trim().equals(s));
					}
					//controllo colori uguali
					for(int k=0;k<tabellone.size();k++) {
						do {
							if(tabellone.get(k).getColore().equals(coloreScelto)) {
								System.out.println("Non puoi inserire colori uguali, riprovare!\n");
								System.out.println("Pedine disponibili:\n1-Rosso\n"+ " 2-Azzurro\n"+ " 3-Giallo\n"+" 4-Verde\n");
								
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
									coloreScelto=Colore.ROSSO;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro");
									coloreScelto=Colore.AZZURRO;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo");
									coloreScelto=Colore.GIALLO;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde");
									coloreScelto=Colore.VERDE;
								}
							}
						}while(tabellone.get(k).getColore().equals(coloreScelto));
						
					}
					
					tabellone.add(new Giocatore(s,coloreScelto,primo));
				}else
				tabellone.add(new Giocatore(s,Colore.AZZURRO,primo));
				break;
			case 3:
				System.out.println("Colore Giallo selezionato");
				if(i!=0) {//al primo giro non faccio il controllo, in quanto non ci sono nomi,colori
					//controllo nomi uguali
					for(int j=0;j<tabellone.size();j++) {
						do {
							if(tabellone.get(j).getSoprannome().trim().equals(s)) {
								System.out.println("Non puoi inserire nomi utenti uguali, riprovare!");

								System.out.print("Inserire il soprannome: ");
								String nomeModificato=sc.nextLine();
								s=nomeModificato.replace(" ", "");
								
							}
						}while(tabellone.get(j).getSoprannome().trim().equals(s));
					}
					//controllo colori uguali
					for(int k=0;k<tabellone.size();k++) {
						do {
							if(tabellone.get(k).getColore().equals(coloreScelto)) {
								System.out.println("Non puoi inserire colori uguali, riprovare!");
								System.out.println("scegli un colore diverso:\n"
										+ "1-Rosso\n"+ " 2-Azzurro\n"+ " 3-Giallo\n"+" 4-Verde");
								
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
									coloreScelto=Colore.ROSSO;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro");
									coloreScelto=Colore.AZZURRO;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo");
									coloreScelto=Colore.GIALLO;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde");
									coloreScelto=Colore.VERDE;
								}
							}
						}while(tabellone.get(k).getColore().equals(coloreScelto));
						
					}
					
					tabellone.add(new Giocatore(s,coloreScelto,primo));
				}else
				tabellone.add(new Giocatore(s,Colore.GIALLO,primo));
				break;
			case 4:
				System.out.println("Colore Verde selezionato\n");
				if(i!=0) {//al primo giro non faccio il controllo, in quanto non ci sono nomi,colori
					//controllo nomi uguali
					for(int j=0;j<tabellone.size();j++) {
						do {
							if(tabellone.get(j).getSoprannome().trim().equals(s)) {
								System.out.println("Non puoi inserire nomi utenti uguali, riprovare!\n");

								System.out.print("Inserire il soprannome: ");
								String nomeModificato=sc.nextLine();
								s=nomeModificato.replace(" ", "");
								
							}
						}while(tabellone.get(j).getSoprannome().trim().equals(s));
					}
					//controllo colori uguali
					for(int k=0;k<tabellone.size();k++) {
						do {
							if(tabellone.get(k).getColore().equals(coloreScelto)) {
								System.out.println("Non puoi inserire colori uguali, riprovare!\n");
								System.out.println("scegli un colore diverso:\n1-Rosso\n2-Azzurro\n3-Giallo\n4-Verde\n");
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
									coloreScelto=Colore.ROSSO;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro");
									coloreScelto=Colore.AZZURRO;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo");
									coloreScelto=Colore.GIALLO;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde");
									coloreScelto=Colore.VERDE;
								}
							}
						}while(tabellone.get(k).getColore().equals(coloreScelto));
						
					}
					
					tabellone.add(new Giocatore(s,coloreScelto,primo));
				}else { 
				
				tabellone.add(new Giocatore(s,Colore.VERDE,primo));
				break;}
			}
			
			primo = false;			
			
		}
		
	}
	
	//needed only for graphics input
	public Tracciato(ArrayList<String> username, ArrayList<String> userColor) {
		boolean primo = true;
		tabellone = new ArrayList<Giocatore>(username.size());
		for(int i=0; i<username.size(); i++) {
			switch(userColor.get(i)){
				case "Rosso":
					tabellone.add(new Giocatore(username.get(i),Colore.ROSSO,primo));
					break;
				case "Azzurro":
					tabellone.add(new Giocatore(username.get(i),Colore.AZZURRO,primo));
					break;
				case "Giallo":
					tabellone.add(new Giocatore(username.get(i),Colore.GIALLO,primo));
					break;
				case "Verde":
					tabellone.add(new Giocatore(username.get(i),Colore.VERDE,primo));
					break;
			}
			primo=false;
		}
		
	}


	public void rivelaPunteggio() {
	
		for(int i=0;i<tabellone.size();i++) {
			System.out.println(tabellone.get(i).getSoprannome()+":"+tabellone.get(i).getPunteggio()+"\n");
			
		}
		
	}
	/**
	 * 
	 * @return il numero di giocatori
	 */
	public int getNumGiocatori() {
		
		return tabellone.size();
		
	}
	/**
	 * 
	 * @param la posizione del giocatore nel tracciato
	 * @return il giocatore in quella posizione
	 */
	
	public Giocatore getGiocatore(int i) {
		
		return tabellone.get(i);
		
	}
	
}
