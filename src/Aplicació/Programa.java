package Aplicació;

import java.io.*;
import java.util.*;

import Dades.*;
import Exceptions.OutOfRangeException;

import java.util.*;

public class Programa {
	private static Scanner teclado;
	public static int operation=0;
	public static <E> void main(String[] args) throws OutOfRangeException, FileNotFoundException {
		mostrarMenu();


	}
	
	

	

	public static void mostrarMenu() throws FileNotFoundException, OutOfRangeException {
		teclado=new Scanner(System.in);
		System.out.println("Introdueix l'any actual");
		int any=teclado.nextInt();
		if(any<2000 || any>2100) {
			System.out.println("L'any introduït no és vàlid i els càlculs no seran correctes. Reinicia el programa.");
		}
		LlistaGeneric<Plantacions> llistaPlantacions = CFitx.leerPlantaciones();
		
		LlistaGeneric<Terreny> llistaTerreno = CFitx.leerTerreno();
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
			System.out.println("14- Mostrar la quantitat de CO2 que permet absorbir el conjunt d'unitats plantades d'una"
					+ " espècie en l'any actual.");
			System.out.println("15- Sortir del programa");
			
			
			
			boolean found=false;

			switch (getMenuOption()) {
			case 1:
				
				System.out.println("Les dades s'han carregat correctament.");
				
				break;
			case 2:
				
				/*System.out.println(llistaPlantacions.consultatIessim(0));
				System.out.println(llistaPlantacions.consultatIessim(1));*/
				System.out.println(llistaTerreno);

				break;
			case 3:
				
				System.out.println(llistaPlantacions);

				break;
			case 4:
				teclado=new Scanner(System.in);
				System.out.println("Introdueixi el nom del terreny ->");
				String terreny = new String();
						terreny=teclado.nextLine();
				for (int i = 0; llistaPlantacions.consultatIessim(i) != null; i++) {

					if (llistaPlantacions.consultatIessim(i).hasTipusTerreny(terreny)) {
						System.out.println(llistaPlantacions.consultatIessim(i));
					} else
						System.out.println("No s'ha trobat cap rodal en aquest terreny.");
				}
				break;
			case 5:
				//LlistaGeneric<Plantacions>llistaPLantacions=leerPlantaciones();
				System.out.println("\t1-Finca Les Pedres\n\t2-Els trossos");
				teclado=new Scanner(System.in);
				int num=teclado.nextInt();
				num-=1;


				for(int j=0;j<llistaPlantacions.consultatIessim(num).getNelems();j++)
					System.out.println("Terreny: "+llistaPlantacions.consultatIessim(num).getTipusTerreny(j).getNomTerreny()+
							", plantació "+(num+1)+", rodal "+(j)+", superfície: "+llistaPlantacions.consultatIessim(num).getSuperficie(j)+": \n"
							+llistaPlantacions.consultatIessim(num).getTipusRodal(j).getTerreny().getUnitats());

				break;
			case 6:
				
				System.out.println(llistaPlantacions);
				
				break;
			case 7:
				boolean printed=false;
				
				System.out.println("Introdueixi la especie de la planta a consultar  ->");
				String especie = new String();
				teclado.nextLine();
						especie=teclado.nextLine();
				System.out.println("Introdueixi la edat de la planta a consultar ->");
				int edat = teclado.nextInt();
				System.out.println(CFitx.absort(llistaPlantacions, especie, edat));
				
				
				break;
			case 8:
				boolean valid=true;
				teclado.nextLine();
				int plantac=0,tipus=0;
				System.out.println("Introdueixi el nom de la plantacio on vol afegir  ->");
				String plantaciotriada = new String();
				plantaciotriada = teclado.nextLine();
				switch(plantaciotriada) {
				case "Els trossos":
					plantac=1;
					valid=true;
					break;
				case "Finca les pedres":
					plantac=0;
					valid=true;
					break;
				default:
					System.out.println("La plantació seleccionada no és correcta");
					break;
				}
				if(valid) {
				System.out.println("Introdueixi el nom de la planta que vol afegir  ->");
				String novaplanta = new String();
				novaplanta = teclado.nextLine();
				System.out.println("Introdueix el tipus:\t1-Arbòria\t2-Arbustiva");
				int typePlant;
				typePlant=teclado.nextInt();
				switch(typePlant) {
				case 1:
					Arboria arb=new Arboria(novaplanta);
					llistaPlantacions.consultatIessim(plantac).getTipusTerreny(0).afegirPlanta(arb, typePlant);
					break;
				case 2:
					Arbustiva arbo=new Arbustiva(novaplanta);
					llistaPlantacions.consultatIessim(plantac).getTipusTerreny(0).afegirPlanta(arbo, 2002);
					break;
				default:
					System.out.println("Tipus de planta incorrecte");
					break;
					}
				}
				

				break;
			case 9:
				
				System.out.println("Introdueixi el nom de la plantació a la que vol eliminar les dades ->");
				teclado = new Scanner(System.in);
				String name = teclado.nextLine();
				for (int i = 0; llistaPlantacions.consultatIessim(i) != null&&!found; i++) {
					if (llistaPlantacions.consultatIessim(i).getNomPlantacio().equalsIgnoreCase(name)) {
						//llistaPlantacions.consultatIessim(i).deleteAll();
						if(i==0) {
							llistaPlantacions.setIessim(0, llistaPlantacions.consultatIessim(1));
						}
						else
							llistaPlantacions.resetI(1);
							//llistaPlantacions.setIessim(1, null);
						found=true;}
					
				}
				if(!found)
						System.out.println("No s'ha trobat la plantació.");
				break;
			case 10:
				
				teclado = new Scanner(System.in);
				System.out.println("Introdueixi el nom de la plantació a la que vol modificar l'any ->");
				String nom = teclado.nextLine();
				System.out.println("Introdueixi el nou any ->");
				
				int nouAny = teclado.nextInt();
			
				for (int i = 0; llistaPlantacions.consultatIessim(i) != null&&!found; i++) {
					if (llistaPlantacions.consultatIessim(i).getNomPlantacio().equalsIgnoreCase(nom)) {
						llistaPlantacions.consultatIessim(i).setAnyPlantacio(nouAny);found=true;}
					
				}
				if(!found)
					System.out.println("No s'ha trobat la plantació.");
				break;
			case 11:
				teclado.nextLine();
				System.out.println("Introdueixi el nom de la plantació a la que vol modificar el rodal ->");
				String nomPlantacio = teclado.nextLine();
				System.out.println("Introdueix l'índex del rodal que vol eliminar");
				int j=teclado.nextInt();
				System.out.println("Introdueixi la superfície que vol que tingui el seu rodal ->");
				float superficie = teclado.nextFloat();
				System.out.println("Introdueixi el tipus de terreny que vol que tingui el seu rodal ->");
				teclado.nextLine();
				String tipusTerreny = teclado.nextLine();
				System.out.println("Introdueix un nom de planta per a assignar al terreny");
				String planta=teclado.nextLine();
				System.out.println("Introdueix la quantitat de plantes que vol afegir al terreny");
				int units=teclado.nextInt();
				
				for (int i = 0; llistaPlantacions.consultatIessim(i) != null; i++) {
					if (llistaPlantacions.consultatIessim(i).getNomPlantacio().equalsIgnoreCase(nomPlantacio)) {
						llistaPlantacions.consultatIessim(i).setSuperficie(j, superficie);
						llistaPlantacions.consultatIessim(i).getTipusRodal(j).setTerreny(new Terreny(tipusTerreny,planta,units));
					}
					else
						System.out.println("No s'ha trobat la plantació.");
				}
				break;
			case 12:
				System.out.println("Introudeixi el nou any ->");
				teclado = new Scanner(System.in);
				any = teclado.nextInt();
				System.out.println(any);
				break;
			case 13:
				teclado=new Scanner(System.in);
				System.out.println("Introdueix el nom de la plantació a consultar");
				String finca=teclado.nextLine();
				CFitx.rodalAbsor(llistaPlantacions, finca, any);
				break;
			case 14:
				teclado.nextLine();
				System.out.println("Introdueix el nom de la espècie");
				String espècie=teclado.nextLine();
				System.out.println("Absorció total de la espècie l'any "+any+": "+CFitx.absorEspecie(llistaPlantacions, espècie, any));
				
				break;
			case 15:
				leave = true;
				//System.exit(1);
				System.out.println("\n\t\t\t\tPROGRAMA FINALITZAT");
				break;
			}
		} while (!leave);

	}
	public static void mas(int n) {
		++n;
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
}
