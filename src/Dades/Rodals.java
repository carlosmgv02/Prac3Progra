package Dades;
import java.io.Serializable;
public class Rodals implements Serializable {
	Terreny terreny;
	float superficie;
	public Rodals (Terreny terreny,float superficie) {
		this.terreny=terreny;
		this.superficie=superficie;
		terreny.setSup(superficie);
	}
	public Terreny getTerreny() {
		return terreny;
	}
	public void setTerreny(Terreny terreny) {
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
		return "[ " + terreny + "\n";
	}
	

}
