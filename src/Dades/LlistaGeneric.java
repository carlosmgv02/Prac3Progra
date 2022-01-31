package Dades;

import java.util.Arrays;
import java.io.Serializable;

import Exceptions.OutOfRangeException;
/**
 *LLista genèrica propia
 * @author grup 13
 *
 * @param <E> Classe genèrica
 */
public class LlistaGeneric<E > implements DefGeneric<E>, Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private E[] llista;
	private int nElems;

	public LlistaGeneric(int dim) {
		try {
		llista = (E[]) new Object[dim];
		}catch(ClassCastException e) {
			System.out.println(e.getMessage());
		}
		nElems = 0;
	}
	/**
	 * Afegeix un element a la llista
	 */
	public boolean afegir(E elem) throws OutOfRangeException {
		if (nElems < llista.length) {
			llista[nElems] = elem;
			nElems++;
			return true;
		}
		throw new OutOfRangeException();
	}
	
	/**
	 * Elimina un element de la llista
	 */
	public void eliminar(int i) {
		if (i < llista.length)
			for (int j = i; j < llista.length; j++) {
				if (j == llista.length - 1)
					llista[j] = null;
				else
					llista[j] = llista[j + 1];
			}
	}
	/**
	 * Comprova si la llista està plena
	 */
	public boolean completo() {
		if (nElems == llista.length) {
			return true;
		} else
			return false;
	}
	/**
	 * Consultar número d'elements de la llista
	 * @return
	 */
	public int nElems() {
		return nElems;
	}
	/**
	 * Consultar llargada de la llista
	 * @return
	 */
	public int length() {
		return llista.length;
	}
	/**
	 * Consultem un element de la llista
	 */
	public E consultatIessim(int i) {
		if (i < nElems)
			return llista[i];
		return null;
	}
	/**
	 * Posa un element a una posició de la llista
	 * @param i
	 * @param object
	 */
	public void setIessim(int i, E object) {
		if (i < llista.length && llista[i] == null)
			llista[i] = object;
	}
	/**
	 * Buida la llista
	 */
	public void resetI(int i) {
		if(i>0&&llista[i]!=null) {
			llista[i]=null;
		}
	}
	

	@Override
	public String toString() {
		boolean first=false;
		String devolver=new String();
		for(int i=0;i<llista.length;i++) {
			
			devolver=devolver+llista[i];
			if(i<llista.length-1&&first)
				//devolver=devolver+",";
			first=true;
		}
		devolver=devolver+"\n";
		
		//return "["+Arrays.toString(llista);
		return devolver;
	}

}
