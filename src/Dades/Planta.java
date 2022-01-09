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
	public Planta() {
		nomCient=null;
		type=0;
		abs=null;
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
	public float getAbs(int age) {
		if(type==2&&age>=5)
			return (float)abs;
		else if(type==1) {
			Absorció absor=(Absorció)abs;
			return absor.absorc(age);}
		return 0;
			
		
	}
	

	@Override
	public String toString() {
		return "Planta [nomCient=" + nomCient + ", type=" + type + ",  " + abs + "]";
	}
	
	
}
