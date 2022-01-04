package Dades;

public class Rodals {
	String terreny;
	float superficie;
	public Rodals (String terreny,float superficie) {
		this.terreny=terreny;
		this.superficie=superficie;
	}
	public String getTerreny() {
		return terreny;
	}
	public void setTerreny(String terreny) {
		this.terreny = terreny;
	}
	public float getSuperficie() {
		return superficie;
	}
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}
	@Override
	public String toString() {
		return "terreny=" + terreny + ", superficie=" + superficie + "]\n";
	}
	

}
