package Dades;

public class Plantacions {
	private int any;
	private Rodals[]rodal;
	private String nomPlantacio;

	public Plantacions(Rodals rodals,int any,String nom) {
		this.any=any;
		this.nomPlantacio=nom;
		this.rodal=new Rodals[10];
		this.rodal[0]=rodals;
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
	public void setTipusRodal(Rodals tipusRodal, int i) {
		this.rodal[i] = tipusRodal;
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

	
	
	
}
