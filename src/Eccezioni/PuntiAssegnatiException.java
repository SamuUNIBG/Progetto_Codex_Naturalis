package Eccezioni;

public class PuntiAssegnatiException extends Exception {

	private static final long serialVersionUID = 7681586576537881577L;

	public PuntiAssegnatiException(String str) {
		System.out.println("Impossibili creare una carta con punteggio " + str);
	}

}
