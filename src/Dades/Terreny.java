package Dades;

import Exceptions.OutOfRangeException;
import java.io.Serializable;
/**
 * Classe terreny
 * @author grup 13
 *
 * @param <E> classe que utilitza elements genèrics
 */
public class Terreny<E> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomTerreny ;
	private LlistaGeneric<Integer>unitats;
	private float superf=0;
	private LlistaGeneric<E>nomPlanta;
	private int nElems;
	public Terreny (String nomTerreny,  E nomPlanta,int unitats) throws OutOfRangeException{
		this.nomTerreny=nomTerreny;
		/*this.nomPlanta=new String[5];
		/this.nomPlanta[0]=nomPlanta;*/
		this.unitats=new LlistaGeneric<Integer>(10);
		this.nomPlanta=new LlistaGeneric<E>(10);
		this.nomPlanta.afegir(nomPlanta);
		this.unitats.afegir(unitats);
		nElems=1;
		

	}
	 /**
	 * Afegim una planta al terreny
	 */
	public void afegirPlanta(E nom,int unitats) throws OutOfRangeException {
		this.nomPlanta.afegir(nom);
		this.unitats.afegir(unitats);
		nElems++;
	}
	/**
	 * Getter
	 * @param i índice de la posición
	 * @return elemento posición i
	 */
	public int getUnits(int i) {
		return unitats.consultatIessim(i);
	}
	/**
	 * Getter
	 * @return String con las unidades que hay
	 */
	public String getUnitats(){
		String text=new String();
		for(int i=0;unitats.consultatIessim(i)!=null;i++) {
			text=text+"La planta "+getiNom(i)+" té "+unitats.consultatIessim(i)+" unitats\n";
		}
		return text;
	}
	/**
	 * Getter
	 * @return nElems
	 */
	public int getNelems() {
		return nElems;
	}
	/**
	 * Setter
	 * @param sup superfície nueva
	 */
	public void setSup(float sup) {
		superf=sup;
	}
	/**
	 * Getter
	 * @param i índice posición
	 * @return nombre de la posición i
	 */
	public String getiNom(int i) {
		String text=null;
			
			if(nomPlanta.consultatIessim(i).getClass().getSimpleName().equalsIgnoreCase("Arboria")) {
				Arboria arb=(Arboria)nomPlanta.consultatIessim(i);
				text=arb.getNomCient();
			}
			else if(nomPlanta.consultatIessim(i).getClass().getSimpleName().equalsIgnoreCase("Arbustiva")){
				Arbustiva arbus=(Arbustiva)nomPlanta.consultatIessim(i);
				text=arbus.getNomCient();
			}
		return text;
			
		
	}
	/**
	 * Setter
	 * @param nom nombre a establecer
	 * @param i índice donde se quiere establecer
	 */
	public void setiNom(String nom, int i) {
		if(i<nomPlanta.length()&&!nom.isEmpty()) {
			if(nomPlanta.consultatIessim(i).getClass().getSimpleName().equalsIgnoreCase("Arboria")) {
				Arboria arb=(Arboria)nomPlanta.consultatIessim(i);
				arb.setNomCient(nom);
			}
			else if(nomPlanta.consultatIessim(i).getClass().getSimpleName().equalsIgnoreCase("Arbustiva")) {
				Arbustiva arbus=(Arbustiva)nomPlanta.consultatIessim(i);
				arbus.setNomCient(nom);
			}
		}			
			
	}
	/**
	 * Getter
	 * @param i índice de la planta que se quiere devolver
	 * @return planta de la posición i
	 */
	public Planta getPlanta(int i) {
		try {
		return (Planta)nomPlanta.consultatIessim(i);
		}catch(ClassCastException E){
			return null;
		}
	}
	/**
	 * Getter
	 * @return nombre del terreno actual
	 */
	public String getNomTerreny() {
		return nomTerreny;
	}

	@Override
	public String toString() {
		String devolver =new String();
		for(int i=0;i<unitats.length()&&unitats.consultatIessim(i)!=null;i++) {
			devolver=devolver+"\t\tNom planta = "+nomPlanta.consultatIessim(i)+", unitats = "+unitats.consultatIessim(i)+"\n";
		}
		//return "Terreny =" + nomTerreny + "\n\tunitats=" + unitats + "\tnomPlanta=" + nomPlanta ;
		if(superf!=0)
			return "Terreny = " + nomTerreny +", Superfície= "+superf+"]\n"+ devolver +"";
		else
			return "Terreny = " + nomTerreny +"\n"+ devolver +"";
	}
	
	
	
	
}
