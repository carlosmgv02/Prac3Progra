package Exceptions;
/**
 * classe per a la nostra excepció propia
 * @author grup 13
 *
 */
public class OutOfRangeException extends Exception {
	/**
	 * Excepció per controlar la mida de la llista
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor de la excepción
	 */
	public OutOfRangeException(){
		super ("El numero introduit no cap al vector creat");
	}
	
}
