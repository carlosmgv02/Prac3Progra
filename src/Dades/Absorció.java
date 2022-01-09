package Dades;

import java.util.Arrays;

public class Absorció {
	private String []rangsEdats=new String[3];
	private float[] absorció=new float[3];
	public Absorció(String uno,float un,String dos,float doss,String tres,float tre) {
		rangsEdats[0]=uno;
		rangsEdats[1]=dos;
		rangsEdats[2]=tres;
		absorció[0]=un;
		absorció[1]=doss;
		absorció[2]=tre;
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
