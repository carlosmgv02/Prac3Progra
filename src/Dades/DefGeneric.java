package Dades;

public interface DefGeneric <E> {
	public boolean afegir (E elem);
	public int nElems();
	public E consultatIessim(int i);
	
	// Apartat 9 -> Esborrar les dades d'una plantació
	public int eliminar (int any) {
		int elementos = nElems;
		
		for (int i=0;i<nElems;i++)
			for(int j=0;j<llista[i].getNelems();i++)
				if(llista[i].getPlantacions().getanyPlantacio().anyIgual(any))
					llista[i]=null;
				else
					llista[i]=llista[i+1];
	}
	//Apartat 10 -> Modificar l'any de plantació d'una plantació
	public int modificaAny (int any) {
		int elementos = nElems;
		
		for(int i=0;i<nElems;i++)
			for(int j=0;llista[i].getNelems();j++)
				
	}
	
	public boolean anyIgual(int any) {
		boolean esIgual;
		if(anyPlantacio==any)
			esIgual=true;
			else
			esIgual=false;
	}
}
