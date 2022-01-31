package Dades;
import java.io.Serializable;
/**
 * Classe planta, té fills
 * @author grup 13
 *
 */
public abstract class Planta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomCient;
	private int type;
	//Planta tiene que ser la clase padre y tiene que ser abtracta
	/**
	 * Constructor vacío de la clase planta
	 */
	public Planta() {
		nomCient=null;
		type=0;
		
	}
	/**
	 * Constructor principal de la clase planta
	 * @param name nombre de la planta
	 * @param type 1 si arboria, 2 si arbustiva
	 */
	public Planta(String name, int type) {
		this.nomCient = name;
		nomCient=name;
		this.type=type;
		
	}
	/**
	 * Getter
	 * @return nomCient
	 */
	public String getNomCient() {
		return nomCient;
	}
	/**
	 * Setter
	 * @param nomCient nombre de la planta
	 */
	public void setNomCient(String nomCient) {
		this.nomCient = nomCient;
	}
	/**
	 * Getter
	 * @return type
	 */
	public int getType() {
		return type;
	}
	/**
	 * Getter absorción
	 * @param i año actual
	 * @return absorción dada una año
	 */
	 public abstract float getAbsor(int i);
		
	/**
	 * Setter
	 * @param type 1 si arboria, 2 si arbustiva
	 */
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Planta [nomCient=" + nomCient + ", type=" + type  + "]";
	}
	
	
}
