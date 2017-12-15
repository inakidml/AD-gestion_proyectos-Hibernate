package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Piezas;
import modelo.Proyectos;
import modelo.utils.InterfaceHibernate;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.Scrollable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;

public class VProyectos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private List<Proyectos> ps;
	
	private JButton btnNewButton;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VProyectos frame = new VProyectos();
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
	public VProyectos() {
		setTitle("Proyectos");
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

		JLabel lblProyectos = new JLabel("Proyectos");
		lblProyectos.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblProyectos);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 73, 609, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscar.setBounds(10, 11, 86, 14);
		panel_1.add(lblBuscar);

		textField = new JTextField();
		textField.setBounds(127, 48, 204, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JLabel lblCdigo = new JLabel("Campo");
		lblCdigo.setBounds(10, 32, 46, 14);
		panel_1.add(lblCdigo);

		JButton btnBuscar = new JButton("Todos");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refrescarJTable();
			}
		});
		btnBuscar.setBounds(510, 11, 89, 23);
		panel_1.add(btnBuscar);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "C\u00F3digo", "Nombre", "Ciudad" }));
		comboBox.setBounds(10, 47, 107, 22);
		panel_1.add(comboBox);

		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String busc = (String) comboBox.getSelectedItem();
				List<Proyectos> busqueda;
				switch (busc) {
				case "Código":
					busqueda = InterfaceHibernate.getProyectosWhere("CODIGO", textField.getText());
					rellenarJTableBusqueda(busqueda);
					break;
				case "Nombre":
					busqueda = InterfaceHibernate.getProyectosWhere("NOMBRE", textField.getText());
					rellenarJTableBusqueda(busqueda);
					break;
				case "Apellido":
					busqueda = InterfaceHibernate.getProyectosWhere("APELLIDOS", textField.getText());
					rellenarJTableBusqueda(busqueda);
					break;
				default:
					break;
				}
			}
		});
		button.setBounds(510, 47, 89, 23);
		panel_1.add(button);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 374, 609, 79);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblModificar = new JLabel("Modificar:");
		lblModificar.setBounds(10, 11, 94, 20);
		lblModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(lblModificar);

		textField_3 = new JTextField();
		textField_3.setBounds(10, 48, 100, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(120, 48, 117, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(247, 48, 117, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);

		btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Proyectos p = new Proyectos(textField_3.getText(), textField_4.getText(), textField_5.getText());
				modificarProyecto(p);

				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				refrescarJTable();
			}
		});
		btnNewButton.setBounds(510, 47, 89, 23);
		panel_2.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(10, 31, 46, 14);
		panel_2.add(lblNewLabel);

		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(120, 31, 46, 14);
		panel_2.add(lblNombre_1);

		JLabel lblApellidos = new JLabel("Ciudad");
		lblApellidos.setBounds(247, 31, 46, 14);
		panel_2.add(lblApellidos);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Proyectos p = new Proyectos(textField_3.getText(), textField_4.getText(), textField_5.getText());
				try {
					borrarProyecto(p);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Este proyecto existe en una gestión, por favor, borra primero esa gestión");
					e.printStackTrace();
				}

				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				refrescarJTable();
			}
		});
		btnBorrar.setBounds(510, 12, 89, 23);
		panel_2.add(btnBorrar);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 464, 609, 79);
		contentPane.add(panel_3);

		JLabel lblAadir = new JLabel("A\u00F1adir:");
		lblAadir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAadir.setBounds(10, 11, 94, 20);
		panel_3.add(lblAadir);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(120, 48, 117, 20);
		panel_3.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(247, 48, 117, 20);
		panel_3.add(textField_9);

		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Proyectos p = new Proyectos(textField_7.getText(), textField_8.getText(), textField_9.getText());
				anadirProyecto(p);
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				refrescarJTable();
			}
		});

		JLabel lblErrorAnadir = new JLabel("");
		lblErrorAnadir.setBounds(72, 16, 354, 14);
		panel_3.add(lblErrorAnadir);
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textField_7.getText().length() == 6) { // si es de 6 dígitos
					textField_7.setText(textField_7.getText().toUpperCase());// Convertimos a mayúsculas
					List<Proyectos> lista = InterfaceHibernate.getProyectosWhere("CODIGO", textField_7.getText());
					if (lista.size() > 0) {
						lblErrorAnadir.setText("El código ya existe");
					} else {
						btnAadir.setEnabled(true);
						lblErrorAnadir.setText("");
					}

				} else {
					textField_7.setText(textField_7.getText().toUpperCase());// Convertimos a mayúsculas
					btnAadir.setEnabled(false);
					lblErrorAnadir.setForeground(Color.RED);
					lblErrorAnadir.setText("Número de caracteres erroneo.(Debe ser 6)");
				}
			}
		});

		
		textField_7.setColumns(10);
		textField_7.setBounds(10, 48, 100, 20);
		panel_3.add(textField_7);
		
		
		btnAadir.setBounds(510, 47, 89, 23);
		panel_3.add(btnAadir);

		JLabel label_1 = new JLabel("C\u00F3digo");
		label_1.setBounds(10, 31, 46, 14);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("Nombre");
		label_2.setBounds(120, 31, 46, 14);
		panel_3.add(label_2);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(247, 31, 46, 14);
		panel_3.add(lblCiudad);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 163, 609, 200);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		//////////////////////////////////////// Aqui empieza todo
		//////////////////////////////////////// ////////////////////////////////////////
		//////////////////////////////////////// ////////////////////////////////////////
		rellenarJTable();
		btnAadir.setEnabled(false);
		
		btnNewButton.setEnabled(false);
		btnBorrar.setEnabled(false);
	}

	private void rellenarJTable() {
		MouseListener tableMouseListener;

		Object[][] data = {};
		ps = InterfaceHibernate.getProyectos();
		if (ps != null) {
			data = new Object[ps.size()][3];
			for (int i = 0; i < ps.size(); i++) {
				data[i][0] = ps.get(i).getCodigo();
				data[i][1] = ps.get(i).getNombre();
				data[i][2] = ps.get(i).getCiudad();
			}
		}
		String[] colName = { "Código", "Nombre", "Ciudad" };
		tableMouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());// get mouse-selected row
				int col = table.columnAtPoint(e.getPoint());// get mouse-selected col

				String codigo = (String) tableModel.getValueAt(row, 0);
				Proyectos pElegido = null;
				for (Proyectos p : ps) {
					if (codigo.equals(p.getCodigo())) {
						pElegido = p;
					}
				}
				textField_3.setText(pElegido.getCodigo());
				textField_3.setEnabled(false);
				textField_4.setText(pElegido.getNombre());
				textField_5.setText(pElegido.getCiudad());
				
				btnNewButton.setEnabled(true);
				btnBorrar.setEnabled(true);

			}
		};

		table = new javax.swing.JTable();

		table.setModel(new javax.swing.table.DefaultTableModel(data, colName) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		});

		table.addMouseListener(tableMouseListener);
		tableModel = (DefaultTableModel) table.getModel();

		scrollPane.setViewportView(table);

		table = new JTable(data, colName);
		scrollPane = new JScrollPane(table);

	}

	public void refrescarJTable() {
		tableModel.setRowCount(0);
		Object[] data = {};
		ps = InterfaceHibernate.getProyectos();
		if (ps != null) {
			data = new Object[3];
			for (int i = 0; i < ps.size(); i++) {
				data[0] = ps.get(i).getCodigo();
				data[1] = ps.get(i).getNombre();
				data[2] = ps.get(i).getCiudad();
				tableModel.addRow(data);
			}
		}
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
		
		btnNewButton.setEnabled(false);
		btnBorrar.setEnabled(false);
	}

	public void rellenarJTableBusqueda(List<Proyectos> psBusq) {
		tableModel.setRowCount(0);
		Object[] data = {};
		if (psBusq != null) {
			data = new Object[3];
			for (int i = 0; i < psBusq.size(); i++) {
				data[0] = psBusq.get(i).getCodigo();
				data[1] = psBusq.get(i).getNombre();
				data[2] = psBusq.get(i).getCiudad();
				tableModel.addRow(data);
			}
		}
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}

	private void anadirProyecto(Proyectos p) {
		InterfaceHibernate.insertProyecto(p);
	}

	private void borrarProyecto(Proyectos p) {
		InterfaceHibernate.borrarProyecto(p);
	}

	private void modificarProyecto(Proyectos p) {
		InterfaceHibernate.updateProyecto(p);
	}
}
