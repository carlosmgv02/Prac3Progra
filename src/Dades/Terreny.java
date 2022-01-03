package Dades;

public class Terreny {
	private String nomTerreny ;
	private int []unitats;	
	private String []nomPlanta;
	private int nElems;
	public Terreny (String nomTerreny, int unitats, String nomPlanta){
		this.nomTerreny=nomTerreny;
		this.nomPlanta=new String[5];
		this.nomPlanta[0]=nomPlanta;
		this.unitats=new int[5];
		this.unitats[0]=unitats;
		nElems=1;
	}
	
	public String getiNom(int i) {
		if(i<nomPlanta.length)
			return nomPlanta[i];
		else return null;
	}
	public void setiNom(String nom, int i) {
		if(i<nomPlanta.length&&!nom.isEmpty())
			this.nomPlanta[i] = nom;
	}
	
	
	
}
