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
	private String colorPedres = "black";
	private String colorTrossos = "black";
	private int anyActual = 0;
	
	JPanel panel = new JPanel();
	JLabel info = new JLabel();
	JTextArea entradaAny = new JTextArea();
	
	
	JLabel negre = new JLabel();
	JLabel lila = new JLabel();
	JLabel roig = new JLabel();
	JLabel blau = new JLabel();
	JLabel verd = new JLabel();
	
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
		
		panel.add(entradaAny);
		/////////////////////////////////////////////////
		negre.setBackground(Color.black);
		negre.setBounds(0, 400, 10, 10);
		negre.setOpaque(true);
		panel.add(negre);
		lila.setBackground(Color.magenta);
		lila.setBounds(10, 400, 10, 10);
		lila.setOpaque(true);
		panel.add(lila);
		roig.setBounds(20, 400, 10, 10);
		roig.setBackground(Color.red);
		roig.setOpaque(true);
		panel.add(roig);
		blau.setBackground(Color.blue);
		blau.setBounds(30, 400, 10, 10);
		blau.setOpaque(true);
		panel.add(blau);
		verd.setBackground(Color.green);
		verd.setBounds(40, 400, 10, 10);
		verd.setOpaque(true);
		panel.add(verd);

		/////////////////////////////////////////////////
		entradaAny.setBounds(0, 30, 300, 50);
		
		entradaAny.setEditable(false);
		
		JLabel llegenda = new JLabel();
		llegenda.setBounds(0, 420, 300, 50);
		llegenda.setText("Negre->50, Lila->150, Blau->250, Verd->400");
		panel.add(llegenda);
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
		JButton botopedres = new JButton();
		botopedres.setBounds (0,100, 400, 40);
		botopedres.setText("Finca les pedres, 2018, 4 rodals, 6381 arbres, 340 arbustives");
		botopedres.setEnabled(true);
		panel.add(botopedres);
		
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
		botopedres.addActionListener(oyentdeDeInfo);
		
		
		//Boto per a posar una opció
		

		JButton botoTros = new JButton();
		botoTros.setBounds (0,140, 400, 40);
		botoTros.setText("Finca els trossos, 2015, 7 rodals, 5 arbres, 0 arbustives");
		botoTros.setEnabled(true);
		panel.add(botoTros);
		ActionListener oyentdeDeAccio = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if(esNumero(entradaAny.getText())) {
					if(Double.parseDouble(entradaAny.getText()) <1 ||Double.parseDouble(entradaAny.getText()) >15) {
						JOptionPane.showMessageDialog(null, "Has de posar un nombre indicat a les opcions, si no saps quines sons, fes click al boto");
					}else {
						opcio = (int) Double.parseDouble(entradaAny.getText());
						JOptionPane.showMessageDialog(null, "Accio "+ opcio);
						
					}
				}else {
					JOptionPane.showMessageDialog(null, "Has de posar un nombre");
				}
				
			}
		};
		botoTros.addActionListener(oyentdeDeAccio);
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

	public void setColorPedres(String colorPedres) {
		this.colorPedres = colorPedres;
	}

	public void setColorTrossos(String colorTrossos) {
		this.colorTrossos = colorTrossos;
	}
	public String getColorPedres() {
		return colorPedres;
	}

	public String getColorTrossos() {
		return colorTrossos;
	}
	
	public void setanyActual(int anyActual) {
		this.anyActual = anyActual;
		entradaAny.setText("Ara estas a l'any "+anyActual);
	}
	
} 