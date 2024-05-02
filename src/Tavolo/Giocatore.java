package Tavolo;

import java.util.ArrayList;
import java.util.Scanner;

import Carta.Angolo;
import Carta.CIniz;
import Carta.CObb;
import Carta.COro;
import Carta.CRis;
import Carta.Carta;
import Enumerazione.Colore;
import Enumerazione.Simbolo;

public class Giocatore {
	
	private final String soprannome;
	private final Colore colore;
	private int punteggio;
	private final boolean primo;
	private ArrayList<Carta> cMano;
	private CObb cObbPer;
	private CIniz cInizPer;
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
		cInizPer = null;
		
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
	
	public boolean giocaCIniz() {
		
		int retro;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("La carta iniziale in tuo possesso");
		System.out.println(cInizPer.toString());
		
		do {
			System.out.print("Vuoi giocare la carta sul retro? [0(si) - 1(no)]: ");
			retro = sc.nextInt();
		}while(retro!=0 && retro!=1);
		
		sc.close();
		
		//se la carta è stata giocata sul retro si setta l'attributo fronte=false
		if(retro==0) {
			cInizPer.retro();
		}
		
		PiazzaC("40,40", cInizPer);
		
		return true;
		
	}
	
	public boolean giocaC() {
		
		Scanner sc = new Scanner(System.in);
		int numCarta, posY, posX, retro;
		String posCarta;
		boolean posCartaOk=false, preRequisito=false;
		Carta carta;
		
		//stampare legenda
		
		//viene mostrato a schermo il campo di gioco del giocatore e le sue carte
		System.out.println("Il tuo campo di gioco:");
		campo.print();
		System.out.println("Le carte in tuo possesso:");
		System.out.println("0) " + cObbPer.toString());
		for(int i=0; i<3; i++) {
			System.out.println((i+1) + ") " + cMano.get(i).toString());
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
			
			carta = cMano.get(numCarta);
			
			//controllo giocabilità carta oro
			if(carta instanceof COro && retro==1)
				if(carta.VerificaPrerequistio())
					preRequisito = true;
		}while(!preRequisito);
		
		//il giocatore sceglie dove giocare la carta
		System.out.println("Posizioni (y,x) dove e' possibile posizionare la carta:");
		for(int i=0; i<campo.getPosizioniDisponibili().size(); i++) {
			System.out.println(campo.getPosizioniDisponibili());
		}
		
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
			for(int i=0; i<campo.getPosizioniDisponibili().size(); i++) {
				if(posCarta.equals(campo.getPosizioniDisponibili().get(i)))
					posCartaOk = true;
			}
		}while(!posCartaOk);
		
		sc.close();
		
		//se la carta è stata giocata sul retro si crea una nuova carta
		if(retro==0) {
			if(carta instanceof CRis) {
				CRis cartaRetro= new CRis(carta.getSimbolo(), carta.getColore(), carta.getIDCARTA());
				cMano.set(numCarta, cartaRetro);
			}else if(carta instanceof COro) {
				COro cartaRetro= new COro(carta.getSimbolo(), carta.getColore(), carta.getIDCARTA());
				cMano.set(numCarta, cartaRetro);
			}
		}
		
		PiazzaC(posCarta, carta);
		
		return true;
	}
	
	private void PiazzaC(String posCarta, Carta carta) {
		
		campo.aggiungiC(posCarta, carta);
		campo.print(posCarta, carta);
		
		//Incrementa array risorse/oggetti posseduti
		Angolo[] angoli = carta.getAngoli();
		for(int i=0; i<angoli.length; i++) {
			if(angoli[i].getSimbolo()==Simbolo.FOGLIA) {
				risPossedute[0]+=1;
			}else if(angoli[i].getSimbolo()==Simbolo.LUPO) {
				risPossedute[1]+=1;
			}else if(angoli[i].getSimbolo()==Simbolo.FUNGO) {
				risPossedute[2]+=1;
			}else if(angoli[i].getSimbolo()==Simbolo.FARFALLA) {
				risPossedute[3]+=1;
			}
			if(angoli[i].getSimbolo()==Simbolo.INCHIOSTRO) {
				oggPosseduti[0]+=1;
			}else if(angoli[i].getSimbolo()==Simbolo.PERGAMENA) {
				oggPosseduti[1]+=1;
			}else if(angoli[i].getSimbolo()==Simbolo.PIUMA) {
				oggPosseduti[2]+=1;
			}
		}
		
		Simbolo[] simboli = campo.copriAngoli(posCarta);
		//Decrementa array risorse/oggetti posseduti
		for(int i=0; i<simboli.length; i++) {
			if(simboli[i]==Simbolo.FOGLIA) {
				risPossedute[0]-=1;
			}else if(simboli[i]==Simbolo.LUPO) {
				risPossedute[1]-=1;
			}else if(simboli[i]==Simbolo.FUNGO) {
				risPossedute[2]-=1;
			}else if(simboli[i]==Simbolo.FARFALLA) {
				risPossedute[3]-=1;
			}
			if(simboli[i]==Simbolo.INCHIOSTRO) {
				oggPosseduti[0]-=1;
			}else if(simboli[i]==Simbolo.PERGAMENA) {
				oggPosseduti[1]-=1;
			}else if(simboli[i]==Simbolo.PIUMA) {
				oggPosseduti[2]-=1;
			}
		}
		
	}
	
	public CObb getCObbPer() {
		return cObbPer;
	}
	
	public CIniz getCInizPer() {
		return cInizPer;
	}
	
	public void pescaC(Carta carta) {
		 
		if(carta instanceof CRis || carta instanceof COro) {
			cMano.add(carta);
		}else if(carta instanceof CObb){
			cObbPer = (CObb)carta;
		}else if(carta instanceof CIniz){
			cInizPer = (CIniz)carta;
		}
		
	}

}
