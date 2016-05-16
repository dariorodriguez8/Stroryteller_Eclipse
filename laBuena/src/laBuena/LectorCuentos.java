package laBuena;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;

public class LectorCuentos extends JPanel {
	JPanel decisiones;
	JPanel menu_siguiente;
	JPanel fin;
	int numeroPagina=1;
	int subPagina=1;
	char historiaParalela = 'A';
	public LectorCuentos(String ruta,String idPag) {
		setLayout(null);
		
		JPanel pagina = new JPanel();
		pagina.setBounds(0, 0, 768, 460);
		add(pagina);
		JLabel hoja = new JLabel(new ImageIcon(ruta));
		hoja.setBounds(0, 0, 768, 460);
		pagina.add(hoja);
		
		
		decisiones = new JPanel();
		decisiones.setBounds(0, 460, 768, 140);
		add(decisiones);
		decisiones.setVisible(false);
		decisiones.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnA = new JButton("A");
		btnA.setFont(new Font("Arial Black", Font.BOLD, 15));
		decisiones.add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.setFont(new Font("Arial Black", Font.BOLD, 15));
		decisiones.add(btnB);
		
		menu_siguiente = new JPanel();
		menu_siguiente.setBounds(0, 460, 768, 140);
		add(menu_siguiente);
		menu_siguiente.setVisible(false);
		menu_siguiente.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		JButton btnSiguiente = new JButton("Pasar pagina");
		btnSiguiente.setFont(new Font("Arial Black", Font.BOLD, 15));
		menu_siguiente.add(btnSiguiente);
		
		fin = new JPanel();
		fin.setBounds(0, 460, 768, 140);
		add(fin);
		
		JButton btnFin = new JButton("Fin");
		fin.add(btnFin);
	
	
	}
	public void setVisibleDecision(){
		menu_siguiente.setVisible(false);decisiones.setVisible(true);fin.setVisible(false);
	}
	public void setVisibleMenu(){
		menu_siguiente.setVisible(true);
		decisiones.setVisible(false);
		fin.setVisible(false);
	}
	public void setVisibleFin(){menu_siguiente.setVisible(false);decisiones.setVisible(false);fin.setVisible(true);}

public void gestionaCuento(){
	File d = new File(".\\Cuentos");
	String[] NumCuentos = d.list();
	if(d.exists()) { 
	for (int i = 0; i < NumCuentos.length-1; i++) {
		File f = new File(".\\Cuentos\\"+NumCuentos[i]);
		String[] subCuentos = f.list();
		for(int h = 0; h < subCuentos.length; h++ ){
			int historia =Character.getNumericValue(subCuentos[h].charAt(0));
			char letra =subCuentos[h].charAt(3);
			
			if(numeroPagina==historia){				
				if(letra==historiaParalela){
					char tipo=subCuentos[h].charAt(5);
					if(tipo=='D'){
						if(subPagina==subCuentos.length){
							subPagina=0;
							setVisibleDecision();
							//File fil = File(".\\Cuentos\\"+NumCuentos[i]+"\\"+subPagina+".jpg");
						}
						else{
							
						}
						
					}
					if(tipo=='F'){
						if(subPagina==subCuentos.length){
							
						}
						else{
							
						}
						
					}
					
					
				}
				}
				
				
			}
		numeroPagina++;
		String img = d.getAbsolutePath()+"\\"+NumCuentos[i]+"\\icono.jpg";

		JButton btnCuento = new JButton(new ImageIcon(img));
		
		//btnCuento.setLabel(NumCuentos[i]);
		
		btnCuento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Meteme en el cuento. porfa. anda. venga...");
				//vp.getCuentos().setVisible(false);
			}
		});
	

	
}
}
}}