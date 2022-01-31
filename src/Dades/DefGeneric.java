
package Dades;

import Exceptions.OutOfRangeException;
/**
 * Interface per definir les operacions que farem servir a la llista genèrica
 * @author grup 13
 *
 * @param <E> asbtracta per a poder passar qualsevol tipus per paràmetre
 */
public interface DefGeneric <E>  {
	/**
	 * Añade un elemento a la lista
	 * @param elem elemento a añadir
	 * @return true si la operación se ha realizado correctamente
	 * @throws OutOfRangeException
	 */
	public boolean afegir (E elem) throws OutOfRangeException;
	/**
	 * Getter
	 * @return número de elementos que contiene la lista
	 */
	public int nElems();
	/**
	 * Devuelve el elemento i de la lista
	 * @param i índice i para devolver el elemento
	 * @return elemento de la posición i
	 */
	public E consultatIessim(int i);
	/**
	 * Elimina el elemento dado un índice
	 * @param i índice para eliminar elemento de dicha posición
	 */
	public void eliminar (int i);
	/**
	 * Booleano
	 * @return true si lista completa, false en caso contrario
	 */
	public boolean completo();
	
	
}
