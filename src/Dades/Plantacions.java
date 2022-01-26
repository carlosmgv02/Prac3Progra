package Dades;

import java.util.Arrays;
import java.io.Serializable;

public class Plantacions implements Serializable {
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
	public void deleteAll() {
		any=0;
		rodal=null;
		nomPlantacio=null;
		nElems=0;
	}
	public String getNomPlantacio() {
		return nomPlantacio;
	}
	public int getNelems() {
		return nElems;
	}
	
	
	public int getAnyPlantacio() {
		return any;
	}
	
	public void setAnyPlantacio(int anyPlantacio) {
		this.any = anyPlantacio;
	}
	/*
	plants.consultatIessim(0).getTipusTerreny(1)
	plants.consultatIessim(0).getTipusRodal(1).getTerreny()
	*/
	public Rodals getTipusRodal(int i) {
		return rodal[i];
	}
	public void setTipusRodal(Rodals tipusRodal) {
		
		this.rodal[nElems] = tipusRodal;
		nElems++;
	}
	
	public Terreny getTipusTerreny(int i) {
		return rodal[i].getTerreny();
	}
	
	public void setTipusTerreny(Terreny tipusTerreny,int i) {
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
			if(rodal[i].getTerreny().getNomTerreny().equalsIgnoreCase(terreny)) {
				return true;
			}
		}
		return false;	
	}
	@Override
	public String toString() {
		String devolver=new String();
		for(int i=0;i<rodal.length&&rodal[i]!=null;i++) {
			
				devolver=devolver + "\t\tany= "+any+", "+"Rodal "+i+rodal[i]+"";
		}
		devolver="Plantacions [ "+nomPlantacio+"] \n"+ devolver+"\n";
		//return "Plantacions ["+nomPlantacio+ ", any=" + any + ", rodal=" + Arrays.toString(rodal)  + "]";
		return devolver;
	}

	
	
	
}
