package Eccezioni;

public class IdCartaException extends Exception {

	private static final long serialVersionUID = -5118407097241826541L;
	
	public IdCartaException() {
		System.out.println("Impossibile creare una carta con id negativo");
	}

}
