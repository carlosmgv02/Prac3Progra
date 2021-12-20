package Dades;

public class Plantacions {
	private int anyPlantacio;
	private String tipusRodal ;
	private String tipusTerreny;
	private float superficie;

	public Plantacions(String rodal, String terreny, float superf, int anyPlantacio) {
		this.anyPlantacio = anyPlantacio;
		this.tipusTerreny = terreny;
		this.superficie = superf;
		this.tipusRodal = rodal;
	}
	public Plantacions() {
		anyPlantacio = 0;
		tipusRodal = new String();
		tipusTerreny = new String();
		superficie = 0f;
	}
	
	public int getAnyPlantacio() {
		return anyPlantacio;
	}
	
	public void setAnyPlantacio(int anyPlantacio) {
		this.anyPlantacio = anyPlantacio;
	}
	
	public String getTipusRodal() {
		return tipusRodal;
	}
	public void setTipusRodal(String tipusRodal) {
		this.tipusRodal = tipusRodal;
	}
	
	public String getTipusTerreny() {
		return tipusTerreny;
	}
	
	public void setTipusTerreny(String tipusTerreny) {
		this.tipusTerreny = tipusTerreny;
	}
	
	public float getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}

	@Override
	public String toString() {
		return "Plantacions [anyPlantacio=" + anyPlantacio + ", tipusRodal=" + tipusRodal + ", tipusTerreny="
				+ tipusTerreny + ", superficie=" + superficie + "]";
	}
	
}
