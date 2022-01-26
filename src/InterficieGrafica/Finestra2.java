package InterficieGrafica;
import Dades.*;
import Aplicació.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.AncestorListener;
public class Finestra2 extends JFrame{
	//Cfitx fitx
	JPanel panel=new JPanel();
	JLabel info=new JLabel();
	JTextArea text=new JTextArea();
	public Finestra2() {
		this.setSize(400,400);
		setTitle("Finestra d'informació");
		this.setLocation(400, 400);
		
	}
	public void addText(String text) {
		this.text.append(text+"\n");
	}
}
