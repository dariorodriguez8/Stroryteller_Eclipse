package laBuena;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.ImageIcon;

public class LectorCuentos extends JPanel {

	public LectorCuentos() {
		setLayout(null);
		
		JPanel pagina = new JPanel();
		pagina.setBounds(0, 0, 768, 460);
		add(pagina);
		
		JPanel decisiones = new JPanel();
		decisiones.setBounds(0, 0, 768, 70);
		add(decisiones);
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
		
		JPanel menu_siguiente = new JPanel();
		menu_siguiente.setBounds(0, 460, 768, 140);
		add(menu_siguiente);
		menu_siguiente.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnSiguiente = new JButton("Pasar pagina");
		btnSiguiente.setIcon(new ImageIcon("C:\\Users\\1dam\\Downloads\\Caperucita roja\\1\\1.jpg"));
		btnSiguiente.setFont(new Font("Arial Black", Font.BOLD, 15));
		menu_siguiente.add(btnSiguiente);
		

	}
}
