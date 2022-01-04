package Dades;

import java.util.Arrays;

import Exceptions.OutOfRangeException;

public class LlistaGeneric<E> implements DefGeneric<E> {
	private E[] llista;
	private int nElems;

	public LlistaGeneric(int dim) {
		llista = (E[]) new Object[dim];
		nElems = 0;

	}

	public boolean afegir(E elem) throws OutOfRangeException {
		if (nElems < llista.length) {
			llista[nElems] = elem;
			nElems++;
			return true;
		}
		throw new OutOfRangeException();
	}

	public void eliminar(int i) {
		if (i < llista.length)
			for (int j = i; j < llista.length; j++) {
				if (j == llista.length - 1)
					llista[j] = null;
				else
					llista[j] = llista[j + 1];
			}
	}

	

	public void modificaRodal(Rodals rodal) {

	}

	public void modificarAnyActual(int any) {

	}

	public boolean completo() {
		if (nElems == llista.length) {
			return true;
		} else
			return false;
	}

	public int nElems() {
		return nElems;
	}

	public int length() {
		return llista.length;
	}

	public E consultatIessim(int i) {
		if (i < nElems)
			return llista[i];
		return null;
	}

	public void setIessim(int i, E object) {
		if (i < llista.length && llista[i] == null)
			llista[i] = object;

	}

	@Override
	public String toString() {
		boolean first=false;
		String devolver=new String();
		for(int i=0;i<llista.length;i++) {
			
			devolver=devolver+llista[i];
			if(i<llista.length-1&&first)
				devolver=devolver+",";
			first=true;
		}
		devolver=devolver+"\n";
		//return "["+Arrays.toString(llista);
		return devolver;
	}

}
