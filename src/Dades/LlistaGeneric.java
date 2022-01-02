package Dades;

import java.util.Arrays;

public class LlistaGeneric<E> implements DefGeneric <E> {
	private E[] llista;
	private E[][]llista2d;
	private int nElems;
	private int i=1;
	private int j=1;
	
	public LlistaGeneric(int dim) {
		llista =(E[])new Object[dim];
		nElems=0;
		llista2d=(E[][])new Object[dim][dim];
		llista2d[0][1]=(E)"Nom científic";
		llista2d[0][2]=(E)"Num plantes";
		
	}
	
	public boolean  afegir(E elem) {
		if(nElems<llista.length) {
			llista[nElems]=elem;
			nElems++;
			return true;
		}
		return false;
	}
	
	public boolean afegir2d(E elem, E cantid) {
		if(nElems<llista2d.length) {
			llista2d[i][j]=elem;
			llista2d[i++][j+1]=cantid;
			nElems++;
			return true;
		}
		return false;
	}
	
	public int nElems() {
		return nElems;
	}
	
	public E consultatIessim(int i) {
		if(i<nElems)
			return llista[i];
		return null;
	}

	@Override
	public String toString() {
		
		String devolver=new String();
		for(i=0;i<nElems;i++)
			devolver=devolver + "[ "+llista2d[i][j]+", "+llista2d[i][j+1]+"]\n";
		return devolver;
	}
	
	


}