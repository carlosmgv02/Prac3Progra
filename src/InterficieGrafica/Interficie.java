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
	private String colorPedres = "magenta";
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
		llegenda.setText("Negre->40K, Lila->1M, Blau->1M5k, Verd->Mes de 1M5K");
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
				if(colorPedres.equalsIgnoreCase("black")) {
					botopedres.setBackground(Color.black);
				}else if(colorPedres.equalsIgnoreCase("magenta")) {
					botopedres.setBackground(Color.magenta);
				}else if(colorPedres.equalsIgnoreCase("red")) {
					botopedres.setBackground(Color.red);
				}else if(colorPedres.equalsIgnoreCase("blue")) {
					botopedres.setBackground(Color.blue);
				}else if(colorPedres.equalsIgnoreCase("green")) {
					botopedres.setBackground(Color.green);
				}
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
				if(colorTrossos.equalsIgnoreCase("black")) {
					botoTros.setBackground(Color.black);
				}else if(colorTrossos.equalsIgnoreCase("magenta")) {
					botoTros.setBackground(Color.magenta);
				}else if(colorTrossos.equalsIgnoreCase("red")) {
					botoTros.setBackground(Color.red);
				}else if(colorTrossos.equalsIgnoreCase("blue")) {
					botoTros.setBackground(Color.blue);
				}else if(colorTrossos.equalsIgnoreCase("green")) {
					botoTros.setBackground(Color.green);
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

	
	public void setanyActual(int anyActual) {
		this.anyActual = anyActual;
		entradaAny.setText("Ara estas a l'any "+anyActual);
		panel.add(entradaAny);
	}
	
} 