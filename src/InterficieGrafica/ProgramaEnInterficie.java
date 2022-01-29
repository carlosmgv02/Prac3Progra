package InterficieGrafica;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Aplicació.*;
import Dades.LlistaGeneric;
import Dades.Plantacions;
import Exceptions.OutOfRangeException;

public class ProgramaEnInterficie {
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException, OutOfRangeException {
		
		LlistaGeneric<Plantacions> llistaPlantacions = CFitx.leerPlantaciones();
		
		Interficie Finestra = new Interficie(llistaPlantacions);
		Finestra.setVisible(true);
		
	}
	
}