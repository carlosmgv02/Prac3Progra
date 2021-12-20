package Dades;

public class Planta {
	private String nomCient = new String();
	private String type = new String();
	private double absorcion;
	
	public Planta(String name, String type, double absorcion) {
		this.nomCient = name;
		this.type = type;
		this.absorcion = absorcion;
	}
	
	public String getNomCient() {
		return nomCient;
	}
	public void setNomCient(String nomCient) {
		this.nomCient = nomCient;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAbsorcion() {
		return absorcion;
	}
	public void setAbsorcion(double value) {
		this.absorcion=value;
	}
	@Override
	public String toString() {
		return "Planta [nomCient=" + nomCient + ", type=" + type + ", absorcion=" + absorcion + "]";
	}
	
}
