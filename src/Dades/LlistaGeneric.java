package Dades;

public class LlistaGeneric<E> implements DefGeneric <E> {
	private E[] llista;
	private int nElems;
	
	public LlistaGeneric(int dim) {
		llista =(E[])new Object[dim];
		nElems=0;
	}
	
	public boolean  afegir(E elem) {
		if(nElems<llista.length) {
			llista[nElems]=elem;
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
	


}
