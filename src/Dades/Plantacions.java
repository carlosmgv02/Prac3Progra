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
	public boolean hasTipusTerreny(String terreny){
		Rodals[]devolver=new Rodals[rodal.length];
		int nEl=0;
		int i=0;
		for( i=0;rodal[i]!=null;i++) {
			if(rodal[i].getTerreny().equalsIgnoreCase(terreny)) {
				return true;
			}
		}
		return false;	
	}
	@Override
	public String toString() {
		String devolver=new String();
		for(int i=0;i<rodal.length&&rodal[i]!=null;i++) {
			
				devolver=devolver + "\t\tany= "+any+", "+rodal[i]+"";
		}
		devolver="Plantacions [ "+nomPlantacio+"] \n"+ devolver+"\n";
		//return "Plantacions ["+nomPlantacio+ ", any=" + any + ", rodal=" + Arrays.toString(rodal)  + "]";
		return devolver;
	}

	
	
	
}
