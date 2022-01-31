package InterficieGrafica;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Aplicacio.*;
import Dades.LlistaGeneric;
import Dades.Plantacions;
import Exceptions.OutOfRangeException;
/**
 * Programa principal interfaz gráfica
 * @author grup 13
 *
 */
public class ProgramaEnInterficie {
	private static Scanner teclado = new Scanner(System.in);
	/**
	 * Progrma interfaz gráfica
	 * @param args arguments
	 * @throws FileNotFoundException exceptions
	 * @throws OutOfRangeException exceptions
	 */
	public static void main(String[] args) throws FileNotFoundException, OutOfRangeException {
		
		LlistaGeneric<Plantacions> llistaPlantacions = CFitx.leerPlantaciones();
		Interficie Finestra = new Interficie(llistaPlantacions);
		Finestra.setVisible(true);
		
	}
	
}