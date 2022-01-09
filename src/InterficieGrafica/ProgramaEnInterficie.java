package InterficieGrafica;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Aplicació.*;
import Exceptions.OutOfRangeException;

public class ProgramaEnInterficie {
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException, OutOfRangeException {
		CFitx.leerPlantaciones();
		
		Interficie Finestra = new Interficie();
		Finestra.setanyActual(llegirAny());
		
		//Fa falta la funcio per a detectar lo interval
		int color = 0;
		if (color < 50) {
			color = 1;
		}else if(color <150) {
			color = 2;
		}else if(color <250) {
			color = 3;
		}else if(color <400) {
			color = 4;
		}else if(color >400) {
			color = 5;
		}
		
		switch(color) {
			case 1:
					Finestra.setColorPedres("black");
				break;
			case 2:
				Finestra.setColorPedres("magenta");
				break;
			case 3:
				Finestra.setColorPedres("red");
				break;
			case 4:	
				Finestra.setColorPedres("blue");
				break;
			case 5:	
				Finestra.setColorPedres("green");
				break;
		}
		
		Finestra.setVisible(true);
	}
	private static int llegirAny()  throws FileNotFoundException {

		System.out.println("Introdueix l'any actual");
		int num = teclado.nextInt();
		return num;
	}
}