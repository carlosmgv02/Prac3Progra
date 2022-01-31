package Dades;
import java.io.Serializable;
/**
 * Classe per a guardar cada rodal que té una plantació
 * @author grup 13
 *
 */
public class Rodals implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Terreny terreny;
	float superficie;
	public Rodals (Terreny terreny,float superficie) {
		this.terreny=terreny;
		this.superficie=superficie;
		terreny.setSup(superficie);
	}
	/**
	 * Getter
	 * @return terreno actual
	 */
	public Terreny getTerreny() {
		return terreny;
	}
	/**
	 * Setter
	 * @param terreny nuevo terreno a establecer
	 */
	public void setTerreny(Terreny terreny) {
		this.terreny = terreny;
	}
	/**
	 * Getter
	 * @return superfície del rodal
	 */
	public float getSuperficie() {
		return superficie;
	}
	/**
	 * Setter
	 * @param superficie nueva superfície a establecer
	 */
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}
	@Override
	public String toString() {
		return "[ " + terreny + "\n";
	}
	

}
