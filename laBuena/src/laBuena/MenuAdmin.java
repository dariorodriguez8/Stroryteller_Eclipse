package laBuena;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Conexion;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;
	private ResultSet rs;


	public MenuAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 204, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		RellenaUsuarios();
	}

	//metodo que rellena la pantalla con los usarios de la base de datso junto a un boton que permite borrarlos
	public void RellenaUsuarios() {
		rs = Conexion.GetInstancia().ConsultaTodosUsuarios();
		try {
			while (rs.next()) {
				JLabel user = new JLabel(rs.getString("NombreUs"));
				JButton Borrar = new JButton("Borrar " + rs.getString("NombreUs"));
				Borrar.setMargin(new Insets(1,1,1,1));
				contentPane.add(user);
				contentPane.add(Borrar);

				Borrar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String nombre="";
						for (int i = 6; i < Borrar.getText().length(); i++) {
							nombre+=Borrar.getText().charAt(i);
						}
						System.out.println("Intento borrar al usuario " + nombre);
					}
				});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}