package Dades;

import Exceptions.OutOfRangeException;
import java.io.Serializable;
public interface DefGeneric <E>  {
	public boolean afegir (E elem) throws OutOfRangeException;
	//public int nElems();
	public E consultatIessim(int i);
	public void eliminar (int any);
	public boolean completo();
	
	
}
