package Tavolo;

import java.util.*;

import Enumerazione.Colore;

public class Tracciato {
	private ArrayList<Giocatore> tabellone;
	
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
		Scanner sc=new Scanner(System.in);
		System.out.println("ATTENZIONE!\n"+"il primo giocatore creato sarà il primo ad iniziare");
		boolean primo=true;
		for(int i=0;i<giocatori;i++) {
			
			System.out.println("Creazione giocatore "+(i+1)+"\n");
			System.out.println("scrivi il tuo soprannome: \n");
			
			String soprannome=sc.nextLine();
			
			System.out.println("scegli il tuo colore:\n"
					+ "1-Rosso\n"+ " 2-Azzurro\n"+ " 3-Giallo\n"+" 4-Verde\n");
			int colore=sc.nextInt();
			do {
				if(colore<1 || colore >4) {
					System.out.println("Numero inserito non valido. Si possono mettere numeri da 1 a 4!");
				}
			}while(colore<1 || colore>4);
			
			switch(colore){
			case 1:
				System.out.println("Colore Rosso selezionato");
				tabellone.add(new Giocatore(soprannome,Colore.ROSSO,primo));
				break;
			case 2:
				System.out.println("Colore Azzurro selezionato");
				tabellone.add(new Giocatore(soprannome,Colore.AZZURRO,primo));
				break;
			case 3:
				System.out.println("Colore Giallo selezionato");
				
				tabellone.add(new Giocatore(soprannome,Colore.GIALLO,primo));
				break;
			case 4:
				System.out.println("Colore Verde selezionato");
				tabellone.add(new Giocatore(soprannome,Colore.VERDE,primo));
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
