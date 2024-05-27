package Logica;

import java.util.Scanner;

import Grafica.Home;
/**
 * la prima classe ad essere eseguita, consente di scegliere
 * se giocare da console (linea di comando), richiamando LogicaGiocoConsole
 * oppure da Grafica richiamando Home
 */
public class CodexNaturalis {

	public static void main(String[] args) {
		
		int scelta=-1;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
			try {
				System.out.print("Desideri continuare con l'interfaccia testuale? [0(si) - 1(no)]: ");
				scelta=Integer.parseInt(sc.nextLine());
				if(scelta<0 || scelta>1) {
					System.out.println("Errore! Numero inserito non valido, riprovare");
				}
				
			}catch(NumberFormatException ex){
				System.out.println("Non puoi inserire una stringa");
				
			}
			
		}while(scelta<0 || scelta>1);
		
		if(scelta == 0) {
			new LogicaGiocoConsole();
		}else {
			new Home();
		}
	}
	

}
