package laBuena;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Modelo.Conexion;

public class CuentosGuardados extends JPanel {
	private JTextField txtBuscar;
	private int numeroCuentos;
	private String nombre[];
	private princ vp;
	JPanel panelCuentos ;

	
	public CuentosGuardados(princ vp) {
		setBackground(new Color(46, 204, 113));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panelSuperior = new JPanel();
		GridBagConstraints gbc_panelSuperior = new GridBagConstraints();
		gbc_panelSuperior.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelSuperior.anchor = GridBagConstraints.NORTH;
		gbc_panelSuperior.insets = new Insets(0, 0, 5, 0);
		gbc_panelSuperior.gridx = 0;
		gbc_panelSuperior.gridy = 0;
		add(panelSuperior, gbc_panelSuperior);
		panelSuperior.setLayout(new GridLayout(1, 0, 0, 0));
		panelSuperior.setBackground(new Color(46, 204, 113));
		
		txtBuscar = new JTextField();
		
		txtBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		txtBuscar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelSuperior.add(txtBuscar);
		txtBuscar.setText("Buscar...");
		txtBuscar.addFocusListener(new FocusListener() {			
			@Override
			public void focusLost(FocusEvent e) {
				txtBuscar.setText("Buscar...");
			}			
			@Override
			public void focusGained(FocusEvent e) {
				txtBuscar.setText("");
			}
		});
		txtBuscar.setColumns(10);

		JLabel label = new JLabel("");
		label.setBackground(new Color(46, 204, 113));
		panelSuperior.add(label);

		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				vp.getM().Principal.setVisible(true);
			}
		});
		panelSuperior.add(btnInicio);

		panelCuentos = new JPanel();
		panelCuentos.setBackground(new Color(46, 204, 113));
		GridBagConstraints gbc_panelCuentos = new GridBagConstraints();
		gbc_panelCuentos.insets = new Insets(0, 0, 5, 0);
		gbc_panelCuentos.fill = GridBagConstraints.BOTH;
		gbc_panelCuentos.gridx = 0;
		gbc_panelCuentos.gridy = 1;
		add(panelCuentos, gbc_panelCuentos);

		JScrollPane scrollPane = new JScrollPane();
		panelCuentos.add(scrollPane);

		nombre = new String[numeroCuentos];
		
		CreaIconos(vp); //metodo que rellena una lista con los cuentos que se tengan
		
	}

	public void CreaIconos(princ vp) {
		
		File d = new File("Cuentos");
		String[] NumCuentos = d.list();
		if(d.exists()) { 
		for (int i = 0; i < NumCuentos.length; i++) {
			String img = d.getAbsolutePath()+"\\"+NumCuentos[i]+"\\Icono.png";
			
			JButton btnCuento = new JButton(new ImageIcon(img));
			btnCuento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Meteme en el cuento. porfa. anda. venga...");
					//vp.getCuentos().setVisible(false);
					
				}
			});
			panelCuentos.add(btnCuento);
		}
		}
	}

}
