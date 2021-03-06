package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.annotations.Parent;

import modelo.Piezas;
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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VPiezas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private List<Piezas> ps;

	private JButton btnNewButton;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VPiezas frame = new VPiezas();
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

	// Constructor
	public VPiezas() {
		setTitle("Piezas");
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

		JLabel lblPiezas = new JLabel("Piezas");
		lblPiezas.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblPiezas);

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
		lblCdigo.setBounds(10, 32, 72, 14);
		panel_1.add(lblCdigo);

		JLabel labelError = new JLabel("");
		labelError.setBounds(67, 11, 369, 14);
		panel_1.add(labelError);

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

		textField_6 = new JTextField();
		textField_6.setBounds(374, 48, 117, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(10, 31, 65, 14);
		panel_2.add(lblNewLabel);

		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(120, 31, 73, 14);
		panel_2.add(lblNombre_1);

		JLabel lblApellidos = new JLabel("Precio");
		lblApellidos.setBounds(247, 31, 46, 14);
		panel_2.add(lblApellidos);

		JLabel lblDireccin_1 = new JLabel("Descripci\u00F3n");
		lblDireccin_1.setBounds(374, 31, 83, 14);
		panel_2.add(lblDireccin_1);

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

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(374, 48, 117, 20);
		panel_3.add(textField_10);

		JLabel label_1 = new JLabel("C\u00F3digo");
		label_1.setBounds(10, 31, 74, 14);
		panel_3.add(label_1);

		JLabel label_2 = new JLabel("Nombre");
		label_2.setBounds(120, 31, 82, 14);
		panel_3.add(label_2);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(247, 31, 46, 14);
		panel_3.add(lblPrecio);

		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(374, 31, 106, 14);
		panel_3.add(lblDescripcin);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 163, 609, 200);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Cod", "Nombre" }));
		comboBox.setBounds(10, 47, 107, 22);
		panel_1.add(comboBox);

		// Botones y listeners
		JButton btnBuscar = new JButton("Todos");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelError.setText("");
				refrescarJTable();
			}
		});
		btnBuscar.setBounds(510, 11, 89, 23);
		panel_1.add(btnBuscar);

		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				labelError.setText("");// Borramos errores

				// que queremos buscar
				String busc = (String) comboBox.getSelectedItem();
				List<Piezas> busqueda;
				switch (busc) {
				// Buscamos y rellenamos la tabla
				case "Cod":
					busqueda = InterfaceHibernate.getPiezasWhere("CODIGO", textField.getText());
					rellenarJTableBusqueda(busqueda);
					break;
				case "Nombre":
					busqueda = InterfaceHibernate.getPiezasWhere("NOMBRE", textField.getText());
					rellenarJTableBusqueda(busqueda);
					break;

				case "Precio":
					try {
						float precio = Float.parseFloat(textField.getText());
						busqueda = InterfaceHibernate.getPiezasWhere("PRECIO", precio);
						rellenarJTableBusqueda(busqueda);
					} catch (NumberFormatException e) {
						labelError.setForeground(Color.RED);
						labelError.setText("No es un n�mero v�lido, intentelo de nuevo");
					}
					break;

				default:
					break;
				}
			}
		});
		button.setBounds(510, 47, 89, 23);
		panel_1.add(button);
		// Botón Modificar
		btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Piezas p = new Piezas(textField_3.getText(), textField_4.getText(),
						Float.parseFloat(textField_5.getText()), textField_6.getText());
				modificarPieza(p);
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				refrescarJTable();
			}
		});
		btnNewButton.setBounds(499, 47, 100, 23);
		panel_2.add(btnNewButton);
		// Botón borrar
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Piezas p = new Piezas(textField_3.getText(), textField_4.getText(),
						Float.parseFloat(textField_5.getText()), textField_6.getText());

				borrarPieza(p);

				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				refrescarJTable();
			}
		});
		btnBorrar.setBounds(499, 12, 100, 23);
		panel_2.add(btnBorrar);

		JLabel lblErrorAnadir = new JLabel("");
		lblErrorAnadir.setBounds(72, 16, 354, 14);
		panel_3.add(lblErrorAnadir);

		// Botón añadir
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_9.getText() != "") {// si el campo está vacío mysql casca
					try {
						Piezas p = new Piezas(textField_7.getText(), textField_8.getText(),
								Float.parseFloat(textField_9.getText()), textField_10.getText());
						anadirPieza(p);
						textField_7.setText("");
						textField_8.setText("");
						textField_9.setText("");
						textField_10.setText("");
						refrescarJTable();
					} catch (NumberFormatException e) // si el precio no es correcto
					{
						lblErrorAnadir.setText("EL precio no es válido");
					}
				} else {
					lblErrorAnadir.setText("EL precio no es válido");
				}
			}
		});
		btnAadir.setBounds(503, 47, 96, 23);
		panel_3.add(btnAadir);

		// Textfield para código con validación del campo
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (textField_7.getText().length() == 6) { // si es de 6 d�gitos
					textField_7.setText(textField_7.getText().toUpperCase());// Convertimos a may�sculas
					List<Piezas> lista = InterfaceHibernate.getPiezasWhere("CODIGO", textField_7.getText());
					if (lista.size() > 0) {
						lblErrorAnadir.setText("El c�digo ya existe");
					} else {
						btnAadir.setEnabled(true);
						lblErrorAnadir.setText("");
					}

				} else {
					textField_7.setText(textField_7.getText().toUpperCase());// Convertimos a may�sculas
					btnAadir.setEnabled(false);
					lblErrorAnadir.setForeground(Color.RED);
					lblErrorAnadir.setText("N�mero de caracteres erroneo.(Debe ser 6)");
				}
			}
		});

		textField_7.setColumns(10);
		textField_7.setBounds(10, 48, 100, 20);
		panel_3.add(textField_7);

		//////////////////////////////////////// Aqui empieza todo
		//////////////////////////////////////// ////////////////////////////////////////
		rellenarJTable();
		// anulamos botónes hasta que tengamos datos
		btnAadir.setEnabled(false);
		btnNewButton.setEnabled(false);
		btnBorrar.setEnabled(false);

	}// Fin constructor

	private void rellenarJTable() {
		MouseListener tableMouseListener;
		ps = InterfaceHibernate.getPiezas();
		// Datos de la tabla
		Object[][] data = {};
		if (ps != null) {
			data = new Object[ps.size()][4];
			for (int i = 0; i < ps.size(); i++) {
				data[i][0] = ps.get(i).getCodigo();
				data[i][1] = ps.get(i).getNombre();
				data[i][2] = ps.get(i).getPrecio();
				data[i][3] = ps.get(i).getDescripcion();
			}
		}
		// Títulos
		String[] colName = { "C�digo", "Nombre", "Precio", "Descripci�n" };
		// Listener
		tableMouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());// get mouse-selected row
				int col = table.columnAtPoint(e.getPoint());// get mouse-selected col

				String codigo = (String) tableModel.getValueAt(row, 0);
				Piezas pElegido = null;
				for (Piezas p : ps) {
					if (codigo.equals(p.getCodigo())) {
						pElegido = p;
					}
				}

				textField_3.setText(pElegido.getCodigo());
				textField_3.setEnabled(false);
				textField_4.setText(pElegido.getNombre());
				textField_5.setText("" + pElegido.getPrecio());
				textField_6.setText(pElegido.getDescripcion());

				btnNewButton.setEnabled(true);
				btnBorrar.setEnabled(true);
				if (e.getClickCount() > 1) {
					JOptionPane.showMessageDialog(null,
							"Pieza con código: " + pElegido.getCodigo() + "\n" + "Nombre: " + pElegido.getNombre()
									+ "\n" + "Precio: " + pElegido.getPrecio() + "\n" + "Descripción: "
									+ pElegido.getDescripcion() + ".");
					// incBorrar = inc;
				}
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

	// refrescar la tabla
	public void refrescarJTable() {
		tableModel.setRowCount(0);
		Object[] data = {};

		ps = InterfaceHibernate.getPiezas();
		if (ps != null) {
			data = new Object[4];
			for (int i = 0; i < ps.size(); i++) {
				data[0] = ps.get(i).getCodigo();
				data[1] = ps.get(i).getNombre();
				data[2] = ps.get(i).getPrecio();
				data[3] = ps.get(i).getDescripcion();
				tableModel.addRow(data);// añadimos de fila en fila
			}
		}
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
		btnNewButton.setEnabled(false);
		btnBorrar.setEnabled(false);
	}

	// Rellenamos con un criterio de busqueda
	public void rellenarJTableBusqueda(List<Piezas> psBusq) {
		tableModel.setRowCount(0);
		Object[] data = {};
		if (psBusq != null) {
			data = new Object[4];
			for (int i = 0; i < psBusq.size(); i++) {
				data[0] = psBusq.get(i).getCodigo();
				data[1] = psBusq.get(i).getNombre();
				data[2] = psBusq.get(i).getPrecio();
				data[3] = psBusq.get(i).getDescripcion();
				tableModel.addRow(data);
			}
		}
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}

	// Metodos hibernate
	private void anadirPieza(Piezas p) {
		InterfaceHibernate.insertPieza(p);
	}

	private void borrarPieza(Piezas p) {
		try {
			InterfaceHibernate.borrarPieza(p);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Esta pieza existe en una gesti�n, por favor, borra primero esa gesti�n");
		}
	}

	private void modificarPieza(Piezas p) {
		InterfaceHibernate.updatePieza(p);
	}
}
