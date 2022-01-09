package Aplicació;
import Dades.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Dades.Absorció;
import Dades.Arboria;
import Dades.LlistaGeneric;
import Dades.Plantacions;
import Dades.Rodals;
import Dades.Terreny;
import Exceptions.OutOfRangeException;

public class CFitx {
	private static Scanner teclado;
	
	public static LlistaGeneric<Plantacions> leerPlantaciones() throws FileNotFoundException, OutOfRangeException {
		LlistaGeneric<Terreny>terreno=leerTerreno();
		int nLines = 12;
		LlistaGeneric<Plantacions> plantacions = new LlistaGeneric<Plantacions>(2);
		teclado = new Scanner(new File("src/Plantacions.csv"));
		
		String text=teclado.nextLine();
		String[] split = null;
		Terreny terreny=null;
		int i = 0;
		boolean first = false;
		Plantacions plant = null;
		for (i = 0; i < nLines; i++) {
			split = teclado.nextLine().split(";");
			if(split[3].equalsIgnoreCase("CalcariSolana")) {
				terreny=terreno.consultatIessim(0);}
			else {
				if(split[3].equalsIgnoreCase("CalcariObaga"))
					terreny=terreno.consultatIessim(1);
				else
					terreny=new Terreny(split[3],"",0);
			}
			if (!split[0].equalsIgnoreCase(" ")) {

				plant = new Plantacions(split[0], Integer.parseInt(split[1]),
						new Rodals(terreny, Float.parseFloat(split[4])));
				first = true;
			}
			if (!first) {
				plant.setTipusRodal(new Rodals(terreny, Float.parseFloat(split[4])));
			}
			first = false;
			if (i == 4 || i == 11) {
				plantacions.afegir(plant);
			}

		}
		return plantacions;
	}
	public static LlistaGeneric<Terreny> leerTerreno()
			throws FileNotFoundException, NumberFormatException, OutOfRangeException {
		int nLines = 10;
		LlistaGeneric<Terreny> terreno = new LlistaGeneric<Terreny>(2);
		teclado = new Scanner(new File("src/Terreny.csv"));
		teclado.nextLine();
		String[] split = null;

		/*
		 * split=teclado.nextLine().split(";"); String nom=split[0];
		 */
		Terreny ter = null;

		boolean first = false;
		int i = 0;
		for (i = 0; i < nLines; i++) {
			split = teclado.nextLine().split(";");
			if (!split[0].equalsIgnoreCase("/")) {
				ter = new Terreny(split[0], split[1], Integer.parseInt(split[2]));
				first = true;
			}
			if (!first) {
				ter.afegirPlanta(split[1], Integer.parseInt(split[2]));
			}
			first = false;
			if (i == 4 || i == 9) {
				terreno.afegir(ter);
				;
			}
		}
		return terreno;
	}
	public static LlistaGeneric<Arboria>leerArboles() throws FileNotFoundException, OutOfRangeException{
		LlistaGeneric<Arboria>arbres=new LlistaGeneric<Arboria>(7);
		Arboria arbol=null;
		teclado=new Scanner(new File("src/Arbres.csv"));
		teclado.nextLine();
		String[]split=null;
		while(teclado.hasNextLine()) {
			split=teclado.nextLine().split(";");
			if(split[5].isBlank()) {
				split[5]=null;
				split[6]="0";
			}
			arbol=new Arboria(split[0],1,new Absorció(split[1],Float.parseFloat(split[2]),
					split[3],Float.parseFloat(split[4]),split[5],Float.parseFloat(split[6])));
			arbres.afegir(arbol);
		}
		return arbres;
	}
	public static LlistaGeneric<Arbustiva>leerArbustos() throws FileNotFoundException, OutOfRangeException{
		LlistaGeneric<Arbustiva>arbustos=new LlistaGeneric<Arbustiva>(4);
		Arbustiva arbusto=null;
		teclado=new Scanner(new File("src/Arbustos.csv"));
		teclado.nextLine();
		String []split=null;
		while(teclado.hasNextLine()) {
			split=teclado.nextLine().split(";");
			arbusto=new Arbustiva(split[0],2,Float.parseFloat(split[1]));
			arbustos.afegir(arbusto);
		}
		return arbustos;
	}

}
