package Tavolo;

import java.util.ArrayList;
import java.util.Scanner;

import Carta.CObb;
import Carta.COro;
import Carta.CRis;
import Carta.Carta;
import Enumerazione.Colore;
import Enumerazione.TipoCarta;

public class Giocatore {
	
	private final String soprannome;
	private final Colore colore;
	private int punteggio;
	private final boolean primo;
	private ArrayList<Carta> cMano;
	private CObb cObbPer;
	private CampoGioco campo;
	private int[] risPossedute;
	private int[] oggPosseduti;
	
	public Giocatore(String soprannome,Colore colore,boolean primo) {
		this.soprannome=soprannome;
		this.colore=colore;
		this.primo=primo;
		punteggio=0;
		campo = new CampoGioco();
		
		cMano = new ArrayList<Carta>();
		
		cObbPer = null;
		
		risPossedute = new int[4];
		oggPosseduti = new int[3];
		
		for(int i=0; i<4; i++) {
			risPossedute[i]=0;
			if(i<3) {
				oggPosseduti[i]=0;
				cMano.add(null);
			}
			
		}
		
	}
	
	public Colore getColore() {
		return colore;
	}
	
	public int getPunteggio() {
		return punteggio;
	}
	public void addPunteggio(int punti) {
		punteggio+=punti;
	}
	public String getSoprannome() {
		return soprannome;
	}
	public boolean giocaC() {
		
		Scanner sc = new Scanner(System.in);
		int numCarta, posY, posX;
		String posCarta;
		boolean posCartaOk=false;
		
		//stampare legenda
		
		System.out.println("Il tuo campo di gioco:");
		campo.print();
		
		System.out.println("Le carte in tuo possesso:");
		for(int i=0; i<3; i++) {
			System.out.println((i+1) + ") " + cMano.get(i).toString());
		}
		
		do {
			System.out.print("Inserire il numero relativo alla carta da giocare: ");
			numCarta = sc.nextInt();
		}while(numCarta<1 || numCarta>3);
		
		//inserire controllo giocabilità carta se oro
		
		System.out.println("Posizioni (y,x) dove e' possibile posizionare la carta");
		for(int i=0; i<campo.getPosizioniDisponibili().size(); i++) {
			System.out.println(campo.getPosizioniDisponibili());
		}
		
		do {
			do {
				System.out.println("Inserire le coordinate y di dove si vuole giocare la carta");
				posY = sc.nextInt();
			}while(posY<0 || posY>CampoGioco.dimensioneY);
			do {
				System.out.println("Inserire le coordinate x di dove si vuole giocare la carta");
				posX = sc.nextInt();
			}while(posX<0 || posX>CampoGioco.dimensioneX);
			posCarta = posY + "," + posX;
			for(int i=0; i<campo.getPosizioniDisponibili().size(); i++) {
				if(posCarta.equals(campo.getPosizioniDisponibili().get(i)))
					posCartaOk = true;
			}
		}while(!posCartaOk);
		
		campo.aggiungiC(posCarta, cMano.get(numCarta));
		campo.print(posCarta, cMano.get(numCarta));
		
		//fare in modo di modificare array risorse possedute
		//cMano.get(numCarta).get
		
		return true;
	}
	public CObb getCObbPer() {
		return cObbPer;
	}
	public void pescaC(Carta carta) {
		 
		if(carta instanceof CRis || carta instanceof COro) {
			cMano.add(carta);
		}else if(carta instanceof CObb){
			cObbPer = (CObb)carta;
		}
		
	}

}
