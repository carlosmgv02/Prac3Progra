package Dades;
import java.io.Serializable;
/**
 * Clase arbres
 * @author Grup 13
 *
 */
public class Arboria extends Planta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Absorciones
	 */
	private float absorcio[]=new float[3];
	/**
	 * Rangos de edades
	 */
	private String[]rangsEdats=new String[3];
	private int [][]edades=new int[3][2];
	//public Arboria( String nombreCient,int type,float abs ) {
	/**
	 * Constructor principal
	 * @param nombreCient	nombre de la planta
	 * @param type 1 si arboria, 2 si arbustiva
	 * @param uno primer rango de edades
	 * @param un absorción del primer rango de edades
	 * @param dos segundo rango de edades
	 * @param doss absorción del segundo rango de edades
	 * @param tres tercer rango de edades
	 * @param tre absorción del tercer rango de edades
	 */
	public Arboria(String nombreCient,int type,String uno,float un,
			String dos,float doss,String tres,float tre) {
		super(nombreCient, type);
		edades[0]=separar(uno);
		edades[1]=separar(dos);
		if(tres!=null)edades[2]=separar(tres);
		rangsEdats[0]=uno;
		rangsEdats[1]=dos;
		rangsEdats[2]=tres;
		absorcio[0]=un;
		absorcio[1]=doss;
		absorcio[2]=tre;

	}
	/**
	 * constructor solo con el nombre
	 * @param nom Nombre de la planta
	 */
	public Arboria(String nom) {
		super(nom,1);
	}
	/**
	 * Constructor vacío
	 */
	public Arboria() {
		
	}
	/**
	 * Metodo que separa los rangos de edades
	 * @param texto String leida que contiene las edades de los árboles
	 * @return
	 */
	public int[]separar(String texto){
		int []tabla=new int[2];
		String []split;
		if(texto.contains("->")) {
			tabla[0]=Integer.parseInt(texto.replace("->", ""));
		}
		else {
			split=texto.split("-");
			tabla[0]=Integer.parseInt(split[0]);	
			tabla[1]=Integer.parseInt(split[1]);

		}
		return tabla;		
	}
	/**
	 * Realiza el cálculo de la absorción dependiendo del rango de edades.
	 */
	public float getAbsor(int age) {
		boolean found=false;
		int j=0;
		if(age<edades[0][0])return 0;
		if(edades[1][1]!=0){
			for( j=0;j<absorcio.length&&!found;j++) {
				if(j==2) {
					if(age>=edades[j][0])
						return absorcio[2];
				}
				if(age>=edades[j][0]&&age<edades[j][1])
					return absorcio[j];}}
		else {
			if(age>=edades[0][0]&&age<edades[0][1])
				return absorcio[0];
			else return absorcio[1];
		}

		return absorcio[j];

	}
	/**
	 * Detecta si se encuentra en un rango de edades válido
	 * @param age edad a comprobar si se encuentra en rango
	 * @return true si está dentro del rango, false en caso contrario
	 */
	public boolean isInRange(int age) {
		if(edades[1][1]==0) {
			if(age>=edades[0][0]&&age<edades[1][0])
				return true;
		}
		else {
			if(age>=edades[0][0]&&age<=edades[2][0])
				return true;
		}
		return false;
	}
	/*@Override
	public String toString() {
		String retorna=new String();
		for(int i=0;i<rangsEdats.length;i++) {
			retorna=retorna + "#Edats: "+rangsEdats[i]+" @Abs: "+absorció[i]+" / ";
		}
		//return "Absorció [rangsEdats=" + Arrays.toString(rangsEdats) + ", absorció=" + Arrays.toString(absorció) + "]";
		return retorna;
	}*/

}
