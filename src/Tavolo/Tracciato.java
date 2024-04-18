package Tavolo;


import java.util.*;
import java.util.Scanner;

import Enumerazione.Colore;

public class Tracciato {
	private ArrayList<Giocatore> tabellone;
	private Colore coloreScelto;
	private int quantiGiocatori() {
		int nGiocatori=0;
		do {
			Scanner sc=new Scanner(System.in);
			System.out.println("In quanti volete giocare?\n"
					+"massimo: 4\n"+"minimo:2");
			 nGiocatori=sc.nextInt();
			if(nGiocatori<=1 ||nGiocatori>=5) {
				System.out.println("Numero giocatori non valido,riprovare");
			}
		}while(nGiocatori<=1 || nGiocatori>=5);
		System.out.println("Giocherete in: "+nGiocatori);
		return nGiocatori;
	}
		
	
	public Tracciato() {
	
		 int giocatori=quantiGiocatori();
		tabellone =new ArrayList<Giocatore>(giocatori);
		Scanner sc=new Scanner(System.in);
		System.out.println("ATTENZIONE!\n"+"il primo giocatore creato sarà il primo ad iniziare");
		for(int i=0;i<giocatori;i++) {
			
			System.out.println("Creazione giocatore "+(i+=1)+"\n");
			System.out.println("scrivi il tuo soprannome: \n");
			
			String soprannome=sc.nextLine();
			boolean primo=false;
			if(i==0) {
				primo=true;
			}
			
			System.out.println("scegli il tuo colore:\n"
					+ "1-Rosso\n"+ " 2-Azzurro\n"+ " 3-Giallo\n"+" 4-Verde\n");
			int colore=sc.nextInt();
			do {
				if(colore<1 || colore >4) {
					System.out.println("Numero inserito non valido. Si possono mettere numeri da 1 a 4!");
				}
			}while(colore<1 || colore>6);
			
			switch(colore){
			case 1:
				System.out.println("Colore Rosso selezionato");
				tabellone.add(new Giocatore(soprannome,coloreScelto.ROSSO,primo));
				break;
			case 2:
				System.out.println("Colore Azzurro selezionato");
				tabellone.add(new Giocatore(soprannome,coloreScelto.AZZURRO,primo));
				break;
			case 3:
				System.out.println("Colore Giallo selezionato");
				
				tabellone.add(new Giocatore(soprannome,coloreScelto.GIALLO,primo));
				break;
			case 4:
				System.out.println("Colore Verde selezionato");
				tabellone.add(new Giocatore(soprannome,coloreScelto.VERDE,primo));
				break;
			}
			
			
			
		}
		
	}
	
	public void rivelaPunteggio() {
	
		for(int i=0;i<tabellone.size();i++) {
			System.out.println(tabellone.get(i).getSoprannome()+":"+tabellone.get(i).getPunteggio()+"\n");
			
		}
	
		
	}
	
}
