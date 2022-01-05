package Dades;

import Exceptions.OutOfRangeException;

public class Terreny  {
	private String nomTerreny ;
	private LlistaGeneric<Integer>unitats;
		
	private LlistaGeneric<String>nomPlanta;
	
	private int nElems;
	public Terreny (String nomTerreny,  String nomPlanta,int unitats) throws OutOfRangeException{
		this.nomTerreny=nomTerreny;
		/*this.nomPlanta=new String[5];
		/this.nomPlanta[0]=nomPlanta;*/
		this.unitats=new LlistaGeneric<Integer>(10);
		this.nomPlanta=new LlistaGeneric<String>(10);
		this.nomPlanta.afegir(nomPlanta);
		this.unitats.afegir(unitats);
		nElems=1;
	}
	 
	public void afegirPlanta(String nom,int unitats) throws OutOfRangeException {
		this.nomPlanta.afegir(nom);
		this.unitats.afegir(unitats);
	}
	public String getUnitats(){
		String text=new String();
		for(int i=0;unitats.consultatIessim(i)!=null;i++) {
			text=text+"La planta "+nomPlanta.consultatIessim(i)+" té "+unitats.consultatIessim(i)+" unitats\n";
		}
		return text;
	}
	public String getiNom(int i) {
		if(i<nomPlanta.length())
			return nomPlanta.consultatIessim(i);
		else return null;
	}
	public void setiNom(String nom, int i) {
		if(i<nomPlanta.length()&&!nom.isEmpty())
			this.nomPlanta.setIessim(i, nom); 
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
