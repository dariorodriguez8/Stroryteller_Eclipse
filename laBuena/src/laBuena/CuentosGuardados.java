package laBuena;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
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
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;

public class CuentosGuardados extends JPanel {
	private JTextField txtBuscar;
	private int numeroCuentos;
	private String nombre[];
	private princ vp;
	JPanel panelCuentos;
	JPanel panel_final;

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
		if (vp.chckbxEnglish_1.isSelected()) {
			txtBuscar.setText("Search...");
		} else {
			txtBuscar.setText("Buscar...");
		}
		//interaccion del campo de texto buscar
		txtBuscar.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				txtBuscar.setFont(new Font("Tahoma", Font.ITALIC, 11));
				if (vp.chckbxEnglish_1.isSelected()) {
					txtBuscar.setText("Search...");
				} else {
					txtBuscar.setText("Buscar...");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtBuscar.setText("");
				txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
		});
		txtBuscar.setColumns(10);

		JLabel label = new JLabel("");
		label.setBackground(new Color(27,94,32));
		panelSuperior.add(label);

		JButton btnInicio;
		if (vp.chckbxEnglish_1.isSelected()) {
			btnInicio = new JButton("Index");
		} else {
			btnInicio = new JButton("Inicio");
		}
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
		panelCuentos.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panelCuentos.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));


		panel_final = new JPanel();

		panel_final.setLayout(new GridLayout(0, 3, 0, 0));
		nombre = new String[numeroCuentos];

		CreaIconos(); 

		JScrollPane scrollPane = new JScrollPane(panel_final);
		scrollPane.setViewportView(panel_final);

		panel.add(scrollPane);
	}

	// metodo que rellena una lista con los cuentos que se tengan en local
	public void CreaIconos() {

		File d = new File("C:\\Cuentos\\");
		String[] NumCuentos = d.list();
		if (d.exists()) {
			for (int i = 0; i < NumCuentos.length; i++) {
	            int b=i;
				String img = d +"\\"+NumCuentos[i] + "\\icono.jpg";
				JButton btnCuento = new JButton(new ImageIcon(img));
				btnCuento.setMargin(new Insets(1, 1, 1, 1));
				panel_final.add(btnCuento);
				
	            btnCuento.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    Cuento cucu = new Cuento(NumCuentos[b]);
	                    cucu.setVisible();
	                }
	            });
				panel_final.add(btnCuento);
				panel_final.updateUI();

			}
		}
	}
}
