package Dades;

import java.util.Arrays;

public class Plantacions {
	private int any;
	private Rodals[]rodal;
	private String nomPlantacio;
	private int nElems;

	public Plantacions(String nom,int any,Rodals rodals) {
		this.any=any;
		this.nomPlantacio=nom;
		this.rodal=new Rodals[10];
		this.rodal[0]=rodals;
		nElems=1;
	}
	public String getNomPlantacio() {
		return nomPlantacio;
	}
	
	
	public int getAnyPlantacio() {
		return any;
	}
	
	public void setAnyPlantacio(int anyPlantacio) {
		this.any = anyPlantacio;
	}
	
	public Rodals getTipusRodal(int i) {
		return rodal[i];
	}
	public void setTipusRodal(Rodals tipusRodal) {
		
		this.rodal[nElems] = tipusRodal;
		nElems++;
	}
	
	public String getTipusTerreny(int i) {
		return rodal[i].getTerreny();
	}
	
	public void setTipusTerreny(String tipusTerreny,int i) {
		this.rodal[i].setTerreny(tipusTerreny);
	}
	
	public float getSuperficie(int i) {
		return rodal[i].getSuperficie();
	}
	
	public void setSuperficie(int i,float superficie) {
		this.rodal[i].setSuperficie(superficie);
	}
	@Override
	public String toString() {
		String devolver=new String();
		for(int i=0;i<rodal.length&&rodal[i]!=null;i++) {
			if(i!=0)
				devolver=devolver +"\t\t"+nomPlantacio+ ", "+any+", "+rodal[i]+"\n";
			else
				devolver=devolver +nomPlantacio+ ", "+any+", "+rodal[i]+"\n";
		}
		devolver="Plantacions[ "+",  "+ devolver;
		//return "Plantacions ["+nomPlantacio+ ", any=" + any + ", rodal=" + Arrays.toString(rodal)  + "]";
		return devolver;
	}

	
	
	
}
