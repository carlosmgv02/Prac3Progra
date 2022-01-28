package Dades;
import java.io.Serializable;
public abstract class Planta implements Serializable {
	private String nomCient;
	private int type;
	//Planta tiene que ser la clase padre y tiene que ser abtracta
	 
	public Planta() {
		nomCient=null;
		type=0;
		
	}
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
	
	 public abstract float getAbsor(int i);
		
	
	public void setType(int type) {
		this.type = type;
	}
	
	/*
	public float getAbs(int age) {
		if(type==2&&age>=5)
			return (float)abs;
		else if(type==1) {
			Absorció absor=(Absorció)abs;
			return absor.absorc(age);}
		return 0;		
	}
	*/
	@Override
	public String toString() {
		return "Planta [nomCient=" + nomCient + ", type=" + type  + "]";
	}
	
	
}
