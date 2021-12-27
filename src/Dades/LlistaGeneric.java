package Dades;

public class LlistaGeneric<E> implements DefGeneric <E> {
	private E[] llista;
	private E[][]llista2d;
	private int nElems;
	private int i=0;
	private int j=0;
	
	public LlistaGeneric(int dim) {
		llista =(E[])new Object[dim];
		nElems=0;
		llista2d=(E[][])new Object[dim][dim];
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
		}
	}
	
	public int nElems() {
		return nElems;
	}
	
	public E consultatIessim(int i) {
		if(i<nElems)
			return llista[i];
		return null;
	}
	


}
