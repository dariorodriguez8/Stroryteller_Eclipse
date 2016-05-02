package laBuena;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Modelo.Conexion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class CuentosGuardados extends JPanel {
	private JTextField txtBuscar;
	private int numeroCuentos;
	private String nombre[];
	private princ vp;
	JPanel panelCuentos ;

	
	public CuentosGuardados(princ vp) {
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

		txtBuscar = new JTextField();
		txtBuscar.setHorizontalAlignment(SwingConstants.LEFT);
		txtBuscar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		panelSuperior.add(txtBuscar);
		txtBuscar.setText("Buscar...");
		txtBuscar.setColumns(10);

		JLabel label = new JLabel("");
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
		GridBagConstraints gbc_panelCuentos = new GridBagConstraints();
		gbc_panelCuentos.insets = new Insets(0, 0, 5, 0);
		gbc_panelCuentos.fill = GridBagConstraints.BOTH;
		gbc_panelCuentos.gridx = 0;
		gbc_panelCuentos.gridy = 1;
		add(panelCuentos, gbc_panelCuentos);

		JScrollPane scrollPane = new JScrollPane();
		panelCuentos.add(scrollPane);

		numeroCuentos = Conexion.GetInstancia().ConsultaNumCuentos();
		nombre = new String[numeroCuentos];
		
		CreaIconos(vp);
		
	}

	public void CreaIconos(princ vp) {
		for (int i = 0; i < numeroCuentos; i++) {
			nombre[i] = Conexion.GetInstancia().ConsultaNombreCuentos(i);
			JLabel ilblCuento = new JLabel(nombre[i]);
			ilblCuento.setIcon(new ImageIcon(
					CuentosGuardados.class.getResource("/javax/swing/plaf/metal/icons/ocean/question.png")));
			panelCuentos.add(ilblCuento);

		}
	}

}
