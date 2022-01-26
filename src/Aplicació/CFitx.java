package Aplicació;

import Dades.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		LlistaGeneric<Terreny> terreno = leerTerreno();
		int nLines = 12;
		LlistaGeneric<Plantacions> plantacions = new LlistaGeneric<Plantacions>(2);
		teclado = new Scanner(new File("src/Plantacions.csv"));

		String text = teclado.nextLine();
		String[] split = null;
		Terreny terreny = null;
		int i = 0;
		boolean first = false;
		Plantacions plant = null;
		for (i = 0; i < nLines; i++) {
			split = teclado.nextLine().split(";");
			if (split[3].equalsIgnoreCase("CalcariSolana")) {
				terreny = terreno.consultatIessim(0);
			} else {
				if (split[3].equalsIgnoreCase("CalcariObaga"))
					terreny = terreno.consultatIessim(1);
				else
					terreny = new Terreny(split[3], "", 0);
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
		LlistaGeneric<Arbustiva> arbusto = leerArbustos();
		LlistaGeneric<Arboria> arbol = leerArboles();

		teclado = new Scanner(new File("src/Terreny.csv"));
		teclado.nextLine();
		String[] split = null;

		/*
		 * split=teclado.nextLine().split(";"); String nom=split[0];
		 */
		Terreny<Planta> ter = null;
	
		

		boolean first = false;
		int i = 0;
		int arb = 0, arbus = 0;
		/*
		 * split[0]=Nom terreny split[1]=Nom planta split[2]=Unitats plantades
		 */
		for (i = 0; i < nLines; i++) {
			split = teclado.nextLine().split(";"); // separamos string
			arb = containsArbol(arbol, split[1]);
			arbus = containsArbust(arbusto, split[1]);
			if (!split[0].equalsIgnoreCase("/")) {

				if (arb != -1) {
					ter = new Terreny(split[0], arbol.consultatIessim(arb), Integer.parseInt(split[2]));
				} else {
					if (arbus != -1) {

						ter = new Terreny(split[0], arbusto.consultatIessim(arbus), Integer.parseInt(split[2]));
					} else {
						
						ter = new Terreny(split[0], new Arboria(), Integer.parseInt(split[2]));
					}
				}

				first = true;
			}
			if (!first) {
				if (arb != -1)
					ter.afegirPlanta(arbol.consultatIessim(arb), Integer.parseInt(split[2]));
				else {
					if (arbus != -1)
						ter.afegirPlanta(arbusto.consultatIessim(arbus), Integer.parseInt(split[2]));
					else
						ter.afegirPlanta(new Arboria(), arbus);
				}
			}
			first = false;
			if (i == 4 || i == 9) {
				terreno.afegir(ter);
				;
			}
		}
		return terreno;
	}

	public static LlistaGeneric<Arboria> leerArboles() throws FileNotFoundException, OutOfRangeException {
		LlistaGeneric<Arboria> arbres = new LlistaGeneric<Arboria>(7);
		Arboria arbol = null;
		teclado = new Scanner(new File("src/Arbres.csv"));
		teclado.nextLine();
		String[] split = null;
		while (teclado.hasNextLine()) {
			split = teclado.nextLine().split(";");
			if (split[5].isBlank()) {
				split[5] = null;
				split[6] = "0";
			}
			arbol = new Arboria(split[0], 1, split[1], Float.parseFloat(split[2]), split[3], Float.parseFloat(split[4]),
					split[5], Float.parseFloat(split[6]));
			arbres.afegir(arbol);

		}
		return arbres;
	}

	public static LlistaGeneric<Arbustiva> leerArbustos() throws FileNotFoundException, OutOfRangeException {
		LlistaGeneric<Arbustiva> arbustos = new LlistaGeneric<Arbustiva>(4);
		Arbustiva arbusto = null;
		teclado = new Scanner(new File("src/Arbustos.csv"));
		teclado.nextLine();
		String[] split = null;
		while (teclado.hasNextLine()) {
			split = teclado.nextLine().split(";");
			arbusto = new Arbustiva(split[0], 2, Float.parseFloat(split[1]));
			arbustos.afegir(arbusto);
		}
		return arbustos;
	}

	public static int containsArbol(LlistaGeneric<Arboria> texto, String text) {

		for (int i = 0; i < texto.length(); i++) {
			if (texto.consultatIessim(i).getNomCient().equalsIgnoreCase(text))
				return i;
		}
		return -1;
	}

	public static int containsArbust(LlistaGeneric<Arbustiva> arbust, String text) {
		for (int i = 0; i < arbust.length(); i++) {
			if (arbust.consultatIessim(i).getNomCient().equalsIgnoreCase(text))
				return i;
		}
		return -1;
	}

	public static float absort(LlistaGeneric<Plantacions> llistaPlantacions, String especie, int edat) {
		boolean printed = false;
		// float
		// uno=llistaPlantacions.consultatIessim(0).getTipusTerreny(0).getPlanta(3).getAbs(edat);
		try {
			for (int i = 0; printed == false; i++) {
				for (int j = 0; j < llistaPlantacions.consultatIessim(i).getNelems() && !printed; j++) {
					for (int k = 0; k < llistaPlantacions.consultatIessim(i).getTipusTerreny(j).getNelems()
							&& !printed; k++) {
						if (llistaPlantacions.consultatIessim(i).getTipusTerreny(j).getPlanta(k).getNomCient()
								.equalsIgnoreCase(especie)) {
							// System.out.println(llistaPlantacions.consultatIessim(i).getTipusTerreny(j).getPlanta(k).getAbs(edat));
							return llistaPlantacions.consultatIessim(i).getTipusTerreny(j).getPlanta(k).getAbsor(edat);

						}
					}
				}
			}
		} catch (ClassCastException E) {
			System.out.println("No s'ha trobat l'element buscat");
		}
		return 0;
	}

	public static float rodalAbsor(LlistaGeneric<Plantacions> llistaPlantacions, String plant, int any) {
		float total = 0;
		float total1 = 0;
		float absortion;
		for (int i = 0; i < llistaPlantacions.nElems(); i++) {
			if (llistaPlantacions.consultatIessim(i).getNomPlantacio().equalsIgnoreCase(plant))
				if (any > llistaPlantacions.consultatIessim(i).getAnyPlantacio()) {
					System.out.println("Plantació " + llistaPlantacions.consultatIessim(i).getNomPlantacio() + ": ");
					for (int j = 0; j < llistaPlantacions.consultatIessim(i).getNelems(); j++) {

						System.out.println("RODAL " + j + ":");
						for (int k = 0; k < llistaPlantacions.consultatIessim(i).getTipusTerreny(j).getNelems(); k++) {
							int age = any - llistaPlantacions.consultatIessim(i).getAnyPlantacio();
							if (age < 0) {
								age = 0;
							}
							try {
							 absortion = llistaPlantacions.consultatIessim(i).getTipusTerreny(j).getPlanta(k)
									.getAbsor(age);
							}catch(NullPointerException e) {absortion=0;}
							// System.out.println(llistaPlantacions.consultatIessim(i).getTipusTerreny(j).getPlanta(k).getNomCient());
							int units = llistaPlantacions.consultatIessim(i).getTipusTerreny(j).getUnits(k);
							total = total + units * absortion;
							/*
							 * total=total+llistaPlantacions.consultatIessim(i).getTipusTerreny(j).getUnits(
							 * k)*llistaPlantacions.consultatIessim(i)
							 * .getTipusTerreny(j).getPlanta(k).getAbs(any-llistaPlantacions.consultatIessim
							 * (i) .getAnyPlantacio());
							 */
						}
						System.out.println("Absorció total del rodal: " + total);
						total1 += total;
						total = 0;

					}
				} else
					System.out.println("L'any introduit és anterior a la la plantació "
							+ llistaPlantacions.consultatIessim(i).getNomPlantacio());
		}
		return total1;
	}

	public static<E> void escribirFicheroSerializado(LlistaGeneric fitxer){

		FileOutputStream fichero = null;
		ObjectOutputStream salida = null;
		
		Arbustiva arb=new Arbustiva("Name",2,3);
		try {
			// Aquí creo el fichero
			fichero = new FileOutputStream("src/terreny.dat");
			salida = new ObjectOutputStream(fichero);
			
				salida.writeObject(fitxer.consultatIessim(0));

		} catch (FileNotFoundException e) {
			System.out.println("1" + e.getMessage());
		} catch (IOException e) {
			System.out.println("2" + e.getMessage());
		} finally {
			try {
				if (fichero != null) {
					fichero.close();
				}
				if (salida != null) {
					salida.close();
				}
			} catch (IOException e) {
				System.out.println("3" + e.getMessage());
			}
		}
	}
	public static void leerSerializado() {
		ObjectInputStream inputFile=null;
		Object llista=new LlistaGeneric<>(2);
		try {
			try {
			inputFile=new ObjectInputStream(new FileInputStream("src/terreny.dat"));
			}catch(FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			llista= inputFile.readObject();
			System.out.println(llista);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassCastException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
