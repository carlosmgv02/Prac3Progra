package InterficieGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interficie extends JFrame {
//Funciona? 
	
	JPanel panel = new JPanel();
	JLabel etiqueta = new JLabel();
	JPanel fondo = new JPanel();
	public Interficie() {
		
		//Establir tamany de pantalla
		this.setSize(500,500);
		//Li donem un nom a la finestra
		setTitle("Prac 3");
		
		//FONDO
		
		
		//Fem que la finestra aparegui a un lloc determinat
		//setLocation(100,200);
		
		//Establim un tamany i una posicio de la finestra, (x, y,ampadax, llargaday)
		//setBounds(100, 200, 500, 500);
		
		//Posem la fienstra al centre de la pantalla
		setLocationRelativeTo(null);
		
		JLabel fondo = new JLabel(new ImageIcon("fondo.jpg"));
		fondo.setBounds(0, 0, 500, 500);
		panel.add(fondo);
		
		iniciarComponents();
		
		//Quan tanquis la finestra finalitza TOT el programa
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniciarComponents() {
		colocarPanels();
		colocarBotons();
	}
	
	private void colocarPanels() {
		
		//Afegir el panel que acabem de crear
		this.getContentPane().add(panel);
		
		//Desactivem el diseny per a poder posar la etiqueta on vulguem
		panel.setLayout(null);
		
		//Crear una etiqueta de text
		//JLabel etiqueta = new JLabel();
		
		//Establim el text de la etiqueta
		etiqueta.setText("Hola");
		
		//Modificar la posicio de la etiqueta i el tamany (x, y,ampadax, llargaday)
		etiqueta.setBounds(100, 100, 50, 30);
		
		//Agregar la etiqueta
		panel.add(etiqueta);
	}
	
	
	private void colocarBotons() {
		//Creem un boto 
		JButton boto1 = new JButton();
		
		
		//Li donem posici oi tamany (x, y,ampadax, llargaday)
		boto1.setBounds (100, 130, 100, 40);
		
		//Posem un text al boto
		boto1.setText("click");
		
		//Activar o desactivar el boto
		boto1.setEnabled(true);
		
		//Afegim el boto
		panel.add(boto1);
		
		ActionListener oyendeDeAccion = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				etiqueta.setText("jkashdfkjadfs");
				etiqueta.setOpaque(true);
				etiqueta.setForeground(Color.yellow);
			}
		};
		
		boto1.addActionListener(oyendeDeAccion);
	}
} 
 