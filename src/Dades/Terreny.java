package Dades;

import Exceptions.OutOfRangeException;

public class Terreny<E>  {
	private String nomTerreny ;
	private LlistaGeneric<Integer>unitats;
		
	private LlistaGeneric<E>nomPlanta;
	private LlistaGeneric<Arboria>arbol;
	private int nElems;
	public Terreny (String nomTerreny,  E nomPlanta,int unitats) throws OutOfRangeException{
		this.nomTerreny=nomTerreny;
		/*this.nomPlanta=new String[5];
		/this.nomPlanta[0]=nomPlanta;*/
		this.unitats=new LlistaGeneric<Integer>(10);
		this.nomPlanta=new LlistaGeneric<E>(10);
		this.nomPlanta.afegir(nomPlanta);
		this.unitats.afegir(unitats);
		nElems=1;
		

	}
	 
	public void afegirPlanta(E nom,int unitats) throws OutOfRangeException {
		this.nomPlanta.afegir(nom);
		this.unitats.afegir(unitats);
		nElems++;
	}
	public String getUnitats(){
		String text=new String();
		for(int i=0;unitats.consultatIessim(i)!=null;i++) {
			text=text+"La planta "+nomPlanta.consultatIessim(i)+" té "+unitats.consultatIessim(i)+" unitats\n";
		}
		return text;
	}
	public int getNelems() {
		return nElems;
	}
	public String getiNom(int i) {
		String text=null;
			
			if(nomPlanta.consultatIessim(i).getClass().getSimpleName().equalsIgnoreCase("Arboria")) {
				Arboria arb=(Arboria)nomPlanta.consultatIessim(i);
				text=arb.getNomCient();
			}
			else if(nomPlanta.consultatIessim(i).getClass().getSimpleName().equalsIgnoreCase("Arbustiva")){
				Arbustiva arbus=(Arbustiva)nomPlanta.consultatIessim(i);
				text=arbus.getNomCient();
			}
		return text;
			
		
	}
	public void setiNom(String nom, int i) {
		if(i<nomPlanta.length()&&!nom.isEmpty()) {
			if(nomPlanta.consultatIessim(i).getClass().getSimpleName().equalsIgnoreCase("Arboria")) {
				Arboria arb=(Arboria)nomPlanta.consultatIessim(i);
				arb.setNomCient(nom);
			}
			else if(nomPlanta.consultatIessim(i).getClass().getSimpleName().equalsIgnoreCase("Arbustiva")) {
				Arbustiva arbus=(Arbustiva)nomPlanta.consultatIessim(i);
				arbus.setNomCient(nom);
			}
		}			
			
	}
	public Planta getPlanta(int i) {
		return (Planta)nomPlanta.consultatIessim(i);
	}

	public String getNomTerreny() {
		return nomTerreny;
	}

	@Override
	public String toString() {
		String devolver =new String();
		for(int i=0;i<unitats.length();i++) {
			devolver=devolver+"\t\tNom planta = "+nomPlanta.consultatIessim(i)+", unitats = "+unitats.consultatIessim(i)+"\n";
		}
		//return "Terreny =" + nomTerreny + "\n\tunitats=" + unitats + "\tnomPlanta=" + nomPlanta ;
		return "Terreny = " + nomTerreny +"\n"+ devolver +"\n";
	}
	
	
	
	
}
