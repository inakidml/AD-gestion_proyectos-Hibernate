package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VPrincipal extends JFrame {

	private JPanel contentPane;
	VProveedores vProveedores;
	VPiezas vPiezas;
	VProyectos vProyectos;
	VAyuda vAyuda;
	VGestiones vGestiones;
	VEstadisticas vEstadisticas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPrincipal frame = new VPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VPrincipal() {
		setTitle("Principal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 191);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSalir = new JMenu("Salir");
		menuBar.add(mnSalir);

		// Salir
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnSalir.add(mntmSalir);

		JMenu mnEstadsticas = new JMenu("Estadísticas");
		menuBar.add(mnEstadsticas);

		// ventana estadísticas
		JMenuItem mntmProveedores = new JMenuItem("Gráficos");
		mnEstadsticas.add(mntmProveedores);
		mntmProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (vEstadisticas == null) {
					vEstadisticas = new VEstadisticas();
					vEstadisticas.setVisible(true);
				} else {
					vEstadisticas.refrescarGraficos();
					vEstadisticas.setVisible(true);
				}
			}

		});

		// Ventana ayuda
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vAyuda == null) {
					vAyuda = new VAyuda();
					vAyuda.setVisible(true);
				} else {
					vAyuda.setVisible(true);
				}
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 598, 50);
		contentPane.add(panel);

		JLabel lblGestinDeRoyectos = new JLabel("Gesti\u00F3n de proyectos");
		lblGestinDeRoyectos.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblGestinDeRoyectos);
		
		// Ventana proyectos
		JButton btnNewButton = new JButton("Proyectos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vProyectos == null) {
					vProyectos = new VProyectos();
					vProyectos.setVisible(true);
				} else {
					vProyectos.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 71, 142, 50);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Piezas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vPiezas == null) {
					vPiezas = new VPiezas();
					vPiezas.setVisible(true);
				} else {
					vPiezas.setVisible(true);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(162, 71, 142, 50);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Proveedores");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (vProveedores == null) {
					vProveedores = new VProveedores();
					vProveedores.setVisible(true);
				} else {
					vProveedores.setVisible(true);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(314, 71, 142, 50);
		contentPane.add(btnNewButton_2);

		JButton btnGestiones = new JButton("Gestiones");
		btnGestiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (vGestiones == null) {
					vGestiones = new VGestiones();
					vGestiones.setVisible(true);
				} else {
					vGestiones.setVisible(true);
				}
			}
		});
		btnGestiones.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGestiones.setBounds(466, 71, 142, 50);
		contentPane.add(btnGestiones);
	}
}
