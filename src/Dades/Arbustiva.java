package Dades;
import java.io.Serializable;
/**
 * Classe filla de planta
 * @author grup 13
 *
 */
public class Arbustiva extends Planta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float abs;
	public Arbustiva( String nombreCient, int type, float absorcio) {
		super(nombreCient, type);
		abs=absorcio;
	}
	/**
	 * Constructor
	 * @param nom nombre de la planta
	 */
	public Arbustiva(String nom) {
		super(nom,2);
	}
	/**
	 * Devuelve la absorción del arbusto
	 */
	public float getAbsor(int age) {
		if(age>5&&age<500)
			return abs;
		else return 0;
	}
	

}
