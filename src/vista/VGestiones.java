package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Piezas;
import modelo.Proveedores;
import modelo.Proyectos;
import modelo.utils.InterfaceHibernate;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class VGestiones extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private List<Piezas> ps;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VGestiones frame = new VGestiones();
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
	public VGestiones() {
		setTitle("Gesti\u00F3n");
		setResizable(false);
		setBounds(100, 100, 645, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 609, 51);
		contentPane.add(panel);

		JLabel lblPiezas = new JLabel("Gesti\u00F3n");
		lblPiezas.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblPiezas);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 73, 609, 271);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("A\u00F1adir suministro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 111, 14);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Proveedor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 36, 101, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblPiezas_1 = new JLabel("Piezas");
		lblPiezas_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPiezas_1.setBounds(20, 94, 101, 14);
		panel_1.add(lblPiezas_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Piezas> piezas = InterfaceHibernate.getPiezasWhere("CODIGO",
						comboBox_1.getSelectedItem().toString());
				textField_2.setText(piezas.get(0).getNombre());
			}
		});
		comboBox_1.setBounds(21, 119, 177, 22);
		panel_1.add(comboBox_1);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidad.setBounds(20, 209, 101, 14);
		panel_1.add(lblCantidad);

		JLabel lblProyecto = new JLabel("Proyecto");
		lblProyecto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProyecto.setBounds(21, 152, 101, 14);
		panel_1.add(lblProyecto);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Proyectos> proys = InterfaceHibernate.getProyectosWhere("CODIGO",
						comboBox_2.getSelectedItem().toString());
				textField_3.setText(proys.get(0).getNombre());
			}
		});
		comboBox_2.setBounds(22, 177, 177, 22);
		panel_1.add(comboBox_2);

		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.setBounds(508, 232, 91, 23);
		panel_1.add(btnNewButton);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(208, 62, 191, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(208, 120, 191, 20);
		panel_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(208, 178, 191, 20);
		panel_1.add(textField_3);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Proveedores> ps = InterfaceHibernate.getProveedoresWhere("CODIGO",
						comboBox.getSelectedItem().toString());
				textField_1.setText(ps.get(0).getNombre());
			}
		});
		comboBox.setBounds(21, 61, 177, 22);
		panel_1.add(comboBox);

		//////////////////////////////////////// Aqui empieza todo
		//////////////////////////////////////// ////////////////////////////////////////

		rellenarJComboBox(comboBox, InterfaceHibernate.getProveedores());
		rellenarJComboBox(comboBox_1, InterfaceHibernate.getPiezas());
		rellenarJComboBox(comboBox_2, InterfaceHibernate.getProyectos());

		List<Proveedores> provs = InterfaceHibernate.getProveedoresWhere("CODIGO",
				comboBox.getSelectedItem().toString());
		textField_1.setText(provs.get(0).getNombre());

		List<Piezas> piezas = InterfaceHibernate.getPiezasWhere("CODIGO", comboBox_1.getSelectedItem().toString());
		textField_2.setText(piezas.get(0).getNombre());

		List<Proyectos> proys = InterfaceHibernate.getProyectosWhere("CODIGO", comboBox_2.getSelectedItem().toString());
		textField_3.setText(proys.get(0).getNombre());
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(20, 234, 51, 18);
		panel_1.add(spinner);

	}

	private <E> void rellenarJComboBox(JComboBox<String> box, List<E> lista) {
		DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();// Rellenar JComboBox
		String clase = lista.get(0).getClass().getName().toString();
		switch (clase) {
		case "modelo.Proveedores":
			for (E e : lista) {
				Proveedores p = (Proveedores) e;
				modelo.addElement(p.getCodigo());
			}
			break;
		case "modelo.Piezas":
			for (E e : lista) {
				Piezas p = (Piezas) e;
				modelo.addElement(p.getCodigo());
			}
			break;
		case "modelo.Proyectos":
			for (E e : lista) {
				Proyectos p = (Proyectos) e;
				modelo.addElement(p.getCodigo());
			}
			break;
		default:
			break;
		}
		box.setModel(modelo);
	}
}
