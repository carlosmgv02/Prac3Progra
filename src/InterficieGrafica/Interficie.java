package InterficieGrafica;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interficie extends JFrame {
//Funciona? 
	public Interficie() {
		//Establir tamany de pantalla
		this.setSize(500,500);
		
		//Li donem un nom a la finestra
		setTitle("Prac 3");
		
	
		
		//Fem que la finestra aparegui a un lloc determinat
		//setLocation(100,200);
		
		//Establim un tamany i una posicio de la finestra, (x, y,ampadax, llargaday)
		//setBounds(100, 200, 500, 500);
		
		//Posem la fienstra al centre de la pantalla
		setLocationRelativeTo(null);
		
		iniciarComponents();
		
		//Quan tanquis la finestra finalitza TOT el programa
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniciarComponents() {
		JPanel panel = new JPanel();
		
		//Afegir el panel que acabem de crear
		this.getContentPane().add(panel);
		
		//Desactivem el diseny per a poder posar la etiqueta on vulguem
		panel.setLayout(null);
		
		//Crear una etiqueta de text
		JLabel etiqueta = new JLabel();
		
		//Establim el text de la etiqueta
		etiqueta.setText("Hola");
		
		//Modificar la posicio de la etiqueta i el tamany (x, y,ampadax, llargaday)
		etiqueta.setBounds(100, 100, 50, 30);
		
		//Agregar la etiqueta
		panel.add(etiqueta);
	}
}
 