package Dades;

import java.util.Arrays;

public class Absorció {
	private String []rangsEdats=new String[3];
	private int [][]edades=new int[3][2];
	
	private float[] absorció=new float[3];
	public Absorció(String uno,float un,String dos,float doss,String tres,float tre) {
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
	@Override
	public String toString() {
		String retorna=new String();
		for(int i=0;i<rangsEdats.length;i++) {
			retorna=retorna + "#Edats: "+rangsEdats[i]+" @Abs: "+absorció[i]+" / ";
		}
		//return "Absorció [rangsEdats=" + Arrays.toString(rangsEdats) + ", absorció=" + Arrays.toString(absorció) + "]";
		return retorna;
	}
	
	
			
}
