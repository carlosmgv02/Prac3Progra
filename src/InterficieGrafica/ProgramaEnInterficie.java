package InterficieGrafica;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Aplicació.*;
import Dades.LlistaGeneric;
import Dades.Plantacions;
import Exceptions.OutOfRangeException;

public class ProgramaEnInterficie {
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException, OutOfRangeException {
		CFitx.leerPlantaciones();
		LlistaGeneric<Plantacions> llistaPlantacions = CFitx.leerPlantaciones();
		
		Interficie Finestra = new Interficie();
		//Finestra.setanyActual(llegirAny());0
		int any = llegirAny();
		//System.out.println("tamare"+ );
		//Fa falta la funcio per a detectar lo interval
		
		int color = (int)CFitx.rodalAbsor(llistaPlantacions, "Finca les pedres", any);
		if (color < 400000) {
			color = 1;
			Finestra.setColorPedres("black");
		}else if(color <1000000) {
			color = 2;
			Finestra.setColorPedres("magenta");
		}else if(color <1005000) {
			color = 3;
			Finestra.setColorPedres("red");
		}else if(color <1050000) {
			color = 4;
			Finestra.setColorPedres("blue");
		}else if(color >1050000) {
			color = 5;
			Finestra.setColorPedres("green");
		}

		color = (int)CFitx.rodalAbsor(llistaPlantacions, "Els trossos", any);
		if (color < 400000) {
			Finestra.setColorTrossos("black");
		}else if(color <1000000) {
			Finestra.setColorTrossos("magenta");
		}else if(color <1005000) {
			Finestra.setColorTrossos("red");
		}else if(color <1050000) {
			Finestra.setColorTrossos("blue");
		}else if(color >1050000) {
			Finestra.setColorTrossos("green");
		}

		Finestra.setVisible(true);
		System.out.println("S");
	}
	private static int llegirAny()  throws FileNotFoundException {

		System.out.println("Introdueix l'any actual");
		int num = teclado.nextInt();
		return num;
	}
}