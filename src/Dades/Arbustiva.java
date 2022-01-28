package Dades;
import java.io.Serializable;
public class Arbustiva extends Planta implements Serializable {
	private float abs;
	public Arbustiva( String nombreCient, int type, float absorcio) {
		super(nombreCient, type);
		abs=absorcio;
	}
	public float getAbsor(int age) {
		if(age>5&&age<500)
			return abs;
		else return 0;
	}
	

}
