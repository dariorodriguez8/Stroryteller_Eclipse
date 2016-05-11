package laBuena;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.ImageIcon;

public class LectorCuentos extends JPanel {
	JPanel decisiones;
	JPanel menu_siguiente;
	
	public LectorCuentos(String ruta,String idPag) {
		setLayout(null);
		
		JPanel pagina = new JPanel();
		pagina.setBounds(0, 0, 768, 460);
		add(pagina);
		JLabel hoja = new JLabel(new ImageIcon(ruta));
		hoja.setBounds(0, 0, 768, 460);
		pagina.add(hoja);
		
		
		decisiones = new JPanel();
		decisiones.setBounds(0, 0, 768, 70);
		add(decisiones);
		decisiones.setVisible(false);
		decisiones.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnA = new JButton("A");
		btnA.setFont(new Font("Arial Black", Font.BOLD, 15));
		decisiones.add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.setFont(new Font("Arial Black", Font.BOLD, 15));
		decisiones.add(btnB);
		
		JButton btnC = new JButton("C");
		btnC.setFont(new Font("Arial Black", Font.BOLD, 15));
		decisiones.add(btnC);
		
		menu_siguiente = new JPanel();
		menu_siguiente.setBounds(0, 460, 768, 140);
		add(menu_siguiente);
		menu_siguiente.setVisible(false);
		menu_siguiente.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JButton btnSiguiente = new JButton("Pasar pagina");
		btnSiguiente.setFont(new Font("Arial Black", Font.BOLD, 15));
		menu_siguiente.add(btnSiguiente);
	

	}
	public void setVisbleDecision(){menu_siguiente.setVisible(false);decisiones.setVisible(true);}
	public void setVisbleMenu(){menu_siguiente.setVisible(true);decisiones.setVisible(false);}
}
