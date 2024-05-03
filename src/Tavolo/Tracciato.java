package Tavolo;

import java.util.*;

import Enumerazione.Colore;

public class Tracciato {
	private ArrayList<Giocatore> tabellone;
	private Colore coloreScelto;
	
	private int quantiGiocatori() {
		int nGiocatori=0;
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("In quanti volete giocare?\n"
					+"massimo: 4\n"+"minimo:2");
			 nGiocatori=sc.nextInt();
			if(nGiocatori<=1 ||nGiocatori>=5) {
				System.out.println("Numero giocatori non valido,riprovare");
			}
		}while(nGiocatori<=1 || nGiocatori>=5);
		System.out.println("Giocherete in: "+nGiocatori);
		sc.close();
		return nGiocatori;
	}
	
	public Tracciato() {
	
		int giocatori=quantiGiocatori();
		tabellone =new ArrayList<Giocatore>(giocatori);
		tabellone.clear();
		Scanner sc=new Scanner(System.in);
		System.out.println("ATTENZIONE!\n"+"il primo giocatore creato sar� il primo ad iniziare");
		boolean primo=true;
		for(int i=0;i<giocatori;i++) {
			
			System.out.println("Creazione giocatore "+(i+1)+"\n");
			System.out.println("scrivi il tuo soprannome: \n");
			System.out.println("Attenzione. Eventuali spazi verranno rimossi!\n");
			
			String soprannome=sc.nextLine();
			
			//tolgo spazi vuoti tra i nomi
			String s=new String(); //temporanea per salvare i nomi con spazi e cancellare spazi
			s=soprannome.replace(" ", "");
				
			
			System.out.println("scegli il tuo colore:\n"
					+ "1-Rosso\n"+ " 2-Azzurro\n"+ " 3-Giallo\n"+" 4-Verde\n");
			int colore=sc.nextInt();
			
			do {
				if(colore<1 || colore >4) {
					System.out.println("Numero inserito non valido. Si possono mettere numeri da 1 a 4!");
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
				System.out.println("Colore Rosso selezionato\n");
				if(i!=0) {//al primo giro non faccio il controllo, in quanto non ci sono nomi,colori
					//controllo nomi uguali
					for(int j=0;j<tabellone.size();j++) {
						do {
							if(tabellone.get(j).getSoprannome().trim().equals(s)) {
								System.out.println("Non puoi inserire nomi utenti uguali, riprovare!\n");
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
								System.out.println("scegli un colore diverso:\n"
										+ "1-Rosso\n"+ " 2-Azzurro\n"+ " 3-Giallo\n"+" 4-Verde\n");
								colore=sc.nextInt();
								
								do {
									if(colore<1 || colore >4) {
										System.out.println("Numero inserito non valido. Si possono mettere numeri da 1 a 4!\n");
									}
								}while(colore<1 || colore>4);
								
								if(colore==1) {
									System.out.println("Hai selezionato il colore Rosso\n");
									coloreScelto=Colore.ROSSO;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro\n");
									coloreScelto=Colore.AZZURRO;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo\n");
									coloreScelto=Colore.GIALLO;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde\n");
									coloreScelto=Colore.VERDE;
								}
							}
						}while(tabellone.get(k).getColore().equals(coloreScelto));
						
					}
					
					tabellone.add(new Giocatore(s,coloreScelto,primo));
				}
				tabellone.add(new Giocatore(s,Colore.ROSSO,primo));
				break;
			case 2:
				System.out.println("Colore Azzurro selezionato\n");
				if(i!=0) {//al primo giro non faccio il controllo, in quanto non ci sono nomi,colori
					//controllo nomi uguali
					for(int j=0;j<tabellone.size();j++) {
						do {
							if(tabellone.get(j).getSoprannome().trim().equals(s)) {
								System.out.println("Non puoi inserire nomi utenti uguali, riprovare!\n");
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
								System.out.println("scegli un colore diverso:\n"
										+ "1-Rosso\n"+ " 2-Azzurro\n"+ " 3-Giallo\n"+" 4-Verde\n");
								colore=sc.nextInt();
								
								do {
									if(colore<1 || colore >4) {
										System.out.println("Numero inserito non valido. Si possono mettere numeri da 1 a 4!\n");
									}
								}while(colore<1 || colore>4);
								
								if(colore==1) {
									System.out.println("Hai selezionato il colore Rosso\n");
									coloreScelto=Colore.ROSSO;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro\n");
									coloreScelto=Colore.AZZURRO;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo\n");
									coloreScelto=Colore.GIALLO;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde\n");
									coloreScelto=Colore.VERDE;
								}
							}
						}while(tabellone.get(k).getColore().equals(coloreScelto));
						
					}
					
					tabellone.add(new Giocatore(s,coloreScelto,primo));
				}
				tabellone.add(new Giocatore(s,Colore.AZZURRO,primo));
				break;
			case 3:
				System.out.println("Colore Giallo selezionato\n");
				if(i!=0) {//al primo giro non faccio il controllo, in quanto non ci sono nomi,colori
					//controllo nomi uguali
					for(int j=0;j<tabellone.size();j++) {
						do {
							if(tabellone.get(j).getSoprannome().trim().equals(s)) {
								System.out.println("Non puoi inserire nomi utenti uguali, riprovare!\n");
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
								System.out.println("scegli un colore diverso:\n"
										+ "1-Rosso\n"+ " 2-Azzurro\n"+ " 3-Giallo\n"+" 4-Verde\n");
								colore=sc.nextInt();
								
								do {
									if(colore<1 || colore >4) {
										System.out.println("Numero inserito non valido. Si possono mettere numeri da 1 a 4!\n");
									}
								}while(colore<1 || colore>4);
								
								if(colore==1) {
									System.out.println("Hai selezionato il colore Rosso\n");
									coloreScelto=Colore.ROSSO;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro\n");
									coloreScelto=Colore.AZZURRO;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo\n");
									coloreScelto=Colore.GIALLO;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde\n");
									coloreScelto=Colore.VERDE;
								}
							}
						}while(tabellone.get(k).getColore().equals(coloreScelto));
						
					}
					
					tabellone.add(new Giocatore(s,coloreScelto,primo));
				}
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
								System.out.println("scegli un colore diverso:\n"
										+ "1-Rosso\n"+ " 2-Azzurro\n"+ " 3-Giallo\n"+" 4-Verde\n");
								colore=sc.nextInt();
								
								do {
									if(colore<1 || colore >4) {
										System.out.println("Numero inserito non valido. Si possono mettere numeri da 1 a 4!\n");
									}
								}while(colore<1 || colore>4);
								
								if(colore==1) {
									System.out.println("Hai selezionato il colore Rosso\n");
									coloreScelto=Colore.ROSSO;
								}else if(colore==2) {
									System.out.println("Hai selezionato il colore Azzurro\n");
									coloreScelto=Colore.AZZURRO;
								}else if(colore==3) {
									System.out.println("Hai selezionato il colore Giallo\n");
									coloreScelto=Colore.GIALLO;
								}else if(colore==4) {
									System.out.println("Hai selezionato il colore Verde\n");
									coloreScelto=Colore.VERDE;
								}
							}
						}while(tabellone.get(k).getColore().equals(coloreScelto));
						
					}
					
					tabellone.add(new Giocatore(s,coloreScelto,primo));
				}
				
				tabellone.add(new Giocatore(s,Colore.VERDE,primo));
				break;
			}
			
			primo = false;			
			
		}
		
		sc.close();
		
	}
	
	//needed only for graphics input
	public Tracciato(ArrayList<String> username, ArrayList<String> userColor) {
		boolean primo = true;
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
	
	public int getNumGiocatori() {
		
		return tabellone.size();
		
	}
	
	public Giocatore getGiocatore(int i) {
		
		return tabellone.get(i);
		
	}
	
}
