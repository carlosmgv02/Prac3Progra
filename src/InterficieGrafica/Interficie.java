package InterficieGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;

public class Interficie extends JFrame {
//Funciona? 
	JPanel panel = new JPanel();
	JLabel info = new JLabel();
	JTextArea entradaTeclat = new JTextArea();
	JTextArea entradaAccio = new JTextArea();
	private int opcio = 0;
	public Interficie() {
		
		//Establir tamany de pantalla
		this.setSize(500,500);
		//Li donem un nom a la finestra
		setTitle("Prac 3");
		
		//Posem la fienstra al centre de la pantalla
		setLocationRelativeTo(null);
		
		JLabel fondo = new JLabel(new ImageIcon("fondo.jpg"));
		fondo.setBounds(0, 0, 500, 500);
		
		panel.add(fondo);
		
		iniciarComponents();
		
		//Afegir el panel que acabem de crear
		this.getContentPane().add(panel);
		
		//Desactivem el diseny per a poder posar les coses on vulguem
		panel.setLayout(null);
		//Quan tanquis la finestra finalitza TOT el programa
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void iniciarComponents() {

		
		colocarPanels();
		colocarBotons();
	}
	
	private void colocarPanels() {
		JLabel etiqueta = new JLabel();
		JPanel fondo = new JPanel();
		
		//Espai per a posar la etiqueta que mostrará info
		info.setBounds(0, 0, 500, 20);
		info.setBackground(Color.black);
		info.setOpaque(true);
		info.setText("Practica 3 feta per Carlos, Genís i Joan");
		panel.add(info);
		
		/////////////////////////////////////////////////
		entradaTeclat.setBounds(0, 350, 300, 100);
		entradaTeclat.setText("Borra aquest text i escri uaqui el que es demani");
		entradaTeclat.setEditable(true);
		panel.add(entradaTeclat);
		/////////////////////////////////////////////////
		entradaAccio.setBounds(0, 30, 300, 50);
		entradaAccio.setText("Introdueix el nombre corresponent a la funcio");
		entradaAccio.setEditable(true);
		panel.add(entradaAccio);
	}
	
	
	private void colocarBotons() {
		
		
		//Crear boto per a sortir
		JButton botoExit = new JButton();
		botoExit.setBounds (400,20, 90, 40);
		botoExit.setText("Exit");
		botoExit.setEnabled(true);
		panel.add(botoExit);
		
		ActionListener oyentdeDeExit = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		};
		botoExit.addActionListener(oyentdeDeExit);
		
		//Crear boto per a mostrar que fa cada cosa
		JButton botoInfo = new JButton();
		botoInfo.setBounds (310,20, 90, 40);
		botoInfo.setText("Info");
		botoInfo.setEnabled(true);
		panel.add(botoInfo);
		
		ActionListener oyentdeDeInfo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(null, "1. Carregar les dades dels fitxers.\n"
						+ "2. Llistar les dades de tots els tipus de terreny.\n"
						+ "3. Llistar les dades de totes les plantacions.\n"
						+ "4. Llistar les dades de les plantacions que tenen algun rodal d’un tipus de terreny.\n"
						+ "5. Donada una plantació, mostrar quantes unitats de cada espècie s’hi ha plantat.\n"
						+ "6. Llistar les dades de totes les espècies.\n"
						+ "7. Donada una espècie i una edat, mostrar la quantitat de CO2 que permet absorbir.\n"
						+ "8. Afegir una nova espècie de planta.\n"
						+ "9. Esborrar les dades d’una plantació.\n"
						+ "10. Modificar l’any de plantació d’una plantació.\n"
						+ "11. Modificar les dades d’un rodal d’una plantació.\n"
						+ "12. Modificar l’any en què ens trobem. \n"
						+ "13. Mostrar la quantitat de CO2 que permet absorbir cada rodal d’una plantació en l’any actual.\n"
						+ "14. Mostrar la quantitat de CO2 que permet absorbir el conjunt d’unitats plantades d’una espècie.\n"
						+ "15. Sortir. Permetre sortir guardant la informació de les classes als fitxers o no.\n"
						);
			}
		};
		botoInfo.addActionListener(oyentdeDeInfo);
		
		
		//Boto per a posar una opció
		

		JButton botoAccio = new JButton();
		botoAccio.setBounds (0,100, 90, 40);
		botoAccio.setText("Establir acció");
		botoAccio.setEnabled(true);
		panel.add(botoAccio);
		ActionListener oyentdeDeAccio = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(esNumero(entradaAccio.getText())) {
					if(Double.parseDouble(entradaAccio.getText()) <1 ||Double.parseDouble(entradaAccio.getText()) >15) {
						JOptionPane.showMessageDialog(null, "Has de posar un nombre indicat a les opcions, si no saps quines sons, fes click al boto");
					}else {
						opcio = (int) Double.parseDouble(entradaAccio.getText());
						JOptionPane.showMessageDialog(null, "Accio "+ opcio);
						
					}
				}else {
					JOptionPane.showMessageDialog(null, "Has de posar un nombre");
				}
				
			}
		};
		botoAccio.addActionListener(oyentdeDeAccio);
	}
	
	public int getOpcio() {
		System.out.println(opcio);
		return opcio;
		
	}
	
	public static boolean esNumero(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
} 
 