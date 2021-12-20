package Dades;

public class Terreny {
	private String nom ;
	private int utsPlantadesXHora;
	
	public Terreny (String nom, int utsPlantadesXHora){
		this.nom= nom;
		this.utsPlantadesXHora= utsPlantadesXHora;
	}
	public Terreny() {
		nom = new String();
		utsPlantadesXHora=0;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getUtsPlantadesXHora() {
		return utsPlantadesXHora;
	}
	public void setUtsPlantadesXHora(int utsPlantadesXHora) {
		this.utsPlantadesXHora = utsPlantadesXHora;
	}
	
	@Override
	public String toString() {
		return "Terreny [nom=" + nom + ", utsPlantadesXHora=" + utsPlantadesXHora + "]";
	}
	
}
