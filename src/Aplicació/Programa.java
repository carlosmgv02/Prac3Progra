package Aplicació;

import java.util.*;

public class Programa {
	private static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			mostrarMenu();
			
	}
	
	public static void mostrarMenu() {
		
		System.out.println("Benvingut al programa, escolleix la opció que vols executar");
		System.out.println("1- Carregar les dades dels fitxers");
		System.out.println("2- Llistar les dades de totes les plantacions");
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
		System.out.println("13- Mostrar la quantitat de CO2 que permet absorbir cada rodal d’una plantació en l’any actual.");
		System.out.println("14- Mostrar la quantitat de CO2 que permet absorbir el conjunt d'unitats plantades d'una"
				+ " espècie eb l'any actual.");
		System.out.println("15- Sortir del programa");	
		switch(getMenuOption()) {
		case 1:
			//leerFichero();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10: 
			break;
		case 11:
			break;
		case 12:
			break;
		case 13:
			break;
		case 14:
			break;
		case 15:
			break;
		}
		
	}
	public static int getMenuOption() {
		int num=teclado.nextInt();
		return num;
	}
	
}
