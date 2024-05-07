package Logica;

import java.util.Scanner;

import Grafica.Home;

public class CodexNaturalis {

	public static void main(String[] args) {
		
		int scelta=0;
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Desideri continuare con l'interfaccia testuale? [0(si) - 1(no)]: ");
			scelta=sc.nextInt();
		}while(scelta!=0 && scelta!=1);
		
		if(scelta == 0) {
			new LogicaGioco();
		}else {
			new Home();
		}
		
	}

}
