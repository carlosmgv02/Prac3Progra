package Dades;
import java.io.Serializable;
public class Arboria extends Planta implements Serializable{
	private float absorció[]=new float[3];
	private String[]rangsEdats=new String[3];
	private int [][]edades=new int[3][2];
	//public Arboria( String nombreCient,int type,float abs ) {

	public Arboria(String nombreCient,int type,String uno,float un,
			String dos,float doss,String tres,float tre) {
		super(nombreCient, type);
		edades[0]=separar(uno);
		edades[1]=separar(dos);
		if(tres!=null)edades[2]=separar(tres);
		rangsEdats[0]=uno;
		rangsEdats[1]=dos;
		rangsEdats[2]=tres;
		absorció[0]=un;
		absorció[1]=doss;
		absorció[2]=tre;

	}
	public Arboria() {
		//constructor vacio, probablemente lo eliminamos porque no hace falta
	}


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
	public float getAbsor(int age) {
		boolean found=false;
		int j=0,i=0;
		if(age<edades[0][0])return 0;
		if(edades[1][1]!=0){
			for( j=0;j<absorció.length&&!found;j++) {
				if(j==2) {
					if(age>=edades[j][0])
						return absorció[2];
				}
				if(age>=edades[j][0]&&age<edades[j][1])
					return absorció[j];}}
		else {
			if(age>=edades[0][0]&&age<edades[0][1])
				return absorció[0];
			else return absorció[1];
		}

		return absorció[j];

	}
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
