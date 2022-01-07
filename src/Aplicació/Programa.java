package Aplicació;

import java.io.*;
import java.util.*;

import Dades.*;
import Exceptions.OutOfRangeException;

import java.util.*;

public class Programa {
	private static Scanner teclado;

	public static <E> void main(String[] args) throws OutOfRangeException, FileNotFoundException {
		// TODO Auto-generated method stub

		//LlistaGeneric<Plantacions>plant=leerPlantaciones();



		//plants.consultatIessim(0).getTipusRodal(0).getTerreny()
		/*System.out.println("Introdueixi l'any en que es troba.");
		teclado = new Scanner(System.in);
		int anyActual = teclado.nextInt();*/
		mostrarMenu();

		/*
		 * teclado=new Scanner(new File("src/Terreny.csv")); LlistaGeneric
		 * <Terreny>prova=leerTerreno(); leerPlantaciones();
		 * 
		 * System.out.println(leerPlantaciones()); //System.out.println(prova); Planta
		 * one=new Planta("1",1); LlistaGeneric <Plantacions> plantacio;
		 */








	}
	

	public static LlistaGeneric<Plantacions> leerPlantaciones() throws FileNotFoundException, OutOfRangeException {
		LlistaGeneric<Terreny>terreno=leerTerreno();
		int nLines = 12;
		LlistaGeneric<Plantacions> plantacions = new LlistaGeneric<Plantacions>(2);
		teclado = new Scanner(new File("src/Plantacions.csv"));
		teclado.nextLine();
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

	public static void mostrarMenu() throws FileNotFoundException, OutOfRangeException {

		boolean leave = false;
		do {
			System.out.println("Benvingut al programa, escolleix la opció que vols executar");
			System.out.println("1- Carregar les dades dels fitxers");
			System.out.println("2- Llistar les dades de tots els tipus de terrenys");
			System.out.println("3- Llistar les dades de totes les plantacions");
			System.out.println("4- Llistar les dades de les plantacions que tenen algun rodal d'un tipus de terreny");
			System.out.println("5- Donada una plantació, mostrar quantes unitats de cada espècie s'ha plantat");
			System.out.println("6- Llistar les dades de totes les espècies");
			System.out.println("7- Donada una espècie i una edat, mostrar la quantitat de C02 que permet absorbir");
			System.out.println("8- Afegir una nova espècie de planta");
			System.out.println("9- Esborrar les dades d'una plantació");
			System.out.println("10- Modificar l'any de plantació d'una plantació");
			System.out.println("11- Modificar les dades d'un rodal d'una plantació");
			System.out.println("12- Modificar l'any en què ens trobem (valor que hem introduït a l'inici però que volem"
					+ " modificar per als càlculs següents");
			System.out.println(
					"13- Mostrar la quantitat de CO2 que permet absorbir cada rodal d’una plantació en l’any actual.");
			System.out
			.println("14- Mostrar la quantitat de CO2 que permet absorbir el conjunt d'unitats plantades d'una"
					+ " espècie eb l'any actual.");
			System.out.println("15- Sortir del programa");
			LlistaGeneric<Plantacions> llistaPlantacions = leerPlantaciones();
			LlistaGeneric<Terreny> llistaTerreno = leerTerreno();

			switch (getMenuOption()) {
			case 1:
				
				break;
			case 2:
				
				System.out.println(llistaTerreno);

				break;
			case 3:
				
				for (int i = 0; llistaPlantacions.consultatIessim(i) != null; i++) {

					if (llistaPlantacions.consultatIessim(i).hasTipusTerreny("CalcariSolana")) {
						System.out.println("La finca " + i + " si que el conté");
					} else
						System.out.println("La finca " + i + " no el conté");
				}

				break;
			case 4:
				break;
			case 5:
				//LlistaGeneric<Plantacions>llistaPLantacions=leerPlantaciones();
				teclado=new Scanner(System.in);
				int num=teclado.nextInt();


				for(int j=0;j<llistaPlantacions.consultatIessim(num).getNelems();j++)
					System.out.println("Terreny: "+llistaPlantacions.consultatIessim(num).getTipusTerreny(j).getNomTerreny()+
							", plantació "+(num+1)+", rodal "+(j)+": \n"
							+llistaPlantacions.consultatIessim(num).getTipusRodal(j).getTerreny().getUnitats());

				break;
			case 6:
				System.out.println(llistaPlantacions);
				break;
			case 7:
				break;
			case 8:
				break;
			case 9:
				System.out.println("Introdueixi el nom de la plantació a la que vol eliminar les dades ->");
				teclado = new Scanner(System.in);
				String name = teclado.nextLine();
				for (int i = 0; llistaPlantacions.consultatIessim(i) != null; i++) {
					if (llistaPlantacions.consultatIessim(i).getNomPlantacio().equalsIgnoreCase(name))
						eliminar(i);
					else
						System.out.println("No s'ha trobat la plantació.");
				break;
			case 10:
				System.out.println("Introdueixi el nom de la plantació a la que vol modificar l'any ->");
				teclado = new Scanner(System.in);
				String nom = teclado.nextLine();
				System.out.println("Introdueixi el nou any ->");
				teclado = new Scanner(System.in);
				int nouAny = teclado.nextInt();
				llistaPlantacions = leerPlantaciones();
				for (int i = 0; llistaPlantacions.consultatIessim(i) != null; i++) {
					if (llistaPlantacions.consultatIessim(i).getNomPlantacio().equalsIgnoreCase(nom))
						llistaPlantacions.consultatIessim(i).setAnyPlantacio(nouAny);
					else
						System.out.println("No s'ha trobat la plantació.");
				}
				break;
			case 11:
				System.out.println("Introdueixi el nom de la plantació a la que vol modificar el rodal ->");
				teclado = new Scanner(System.in);
				String nomPlantacio = teclado.nextLine();
				System.out.println("Introdueixi la superfície que vol que tingui el seu rodal ->");
				teclado = new Scanner(System.in);
				float superficie = teclado.nextFloat();
				llistaPlantacions = leerPlantaciones();
				System.out.println("Introdueixi el tipus de terreny que vol que tingui el seu rodal ->");
				teclado = new Scanner(System.in);
				String tipusTerreny = teclado.next();
				llistaPlantacions = leerPlantaciones();
				for (int i = 0; llistaPlantacions.consultatIessim(i) != null; i++) {
					if (llistaPlantacions.consultatIessim(i).getNomPlantacio().equalsIgnoreCase(nomPlantacio))
						llistaPlantacions.consultatIessim(i).setSuperficie(i, superficie);
						llistaPlantacions.consultatIessim(i).getTipusRodal(i).setTerreny(null);
					else
						System.out.println("No s'ha trobat la plantació.");
				}
				break;
			case 12:
				System.out.println("Introudeixi el nou any ->");
				teclado = new Scanner(System.in);
				int nouany = teclado.nextInt();
				System.out.println(nouany);
				break;
			case 13:
				break;
			case 14:
				break;
			case 15:
				leave = true;
				break;
			}
		} while (!leave);

	}

	public static int getMenuOption() {
		int num = 0;
		teclado = new Scanner(System.in);
		do {
			num = teclado.nextInt();
			if (num < 1 || num > 15) {
				System.out.println("El número introduït ha de ser >1 i <15, torna a provar");
			}
		} while (num < 1 || num > 15);

		return num;
	}

	public static <E> void imprimir(E valors) {
		System.out.println(valors);
	}

}
