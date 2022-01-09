package Dades;

public class Planta<E> {
	private String nomCient;
	private int type;
	private E abs;
	
	public Planta(String name, int type,E absorcio) {
		this.nomCient = name;
		nomCient=name;
		this.type=type;
		abs=absorcio;
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
	public E getAbsorció() {
		return abs;
	}

	@Override
	public String toString() {
		return "Planta [nomCient=" + nomCient + ", type=" + type + ",  " + abs + "]\n";
	}
	
	
}
