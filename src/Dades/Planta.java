package Dades;

public class Planta {
	private String nomCient;
	private int type;
	
	public Planta(String name, int type) {
		this.nomCient = name;
		nomCient=name;
		this.type=type;
	}
	
	public String getNomCient() {
		return nomCient;
	}
	public void setNomCient(String nomCient) {
		this.nomCient = nomCient;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Planta [nomCient=" + nomCient + ", type=" + type +  "]";
	}
	
}
