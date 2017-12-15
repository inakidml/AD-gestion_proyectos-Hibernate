package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Gestion;
import modelo.GestionId;
import modelo.Piezas;
import modelo.Proveedores;
import modelo.Proyectos;
import modelo.utils.InterfaceHibernate;

public class VGestiones extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane_1;
	private DefaultTableModel tableModel;
	private List<Gestion> gs;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

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
		setBounds(100, 100, 645, 733);
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

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCantidad.setBounds(20, 209, 101, 14);
		panel_1.add(lblCantidad);

		JLabel lblProyecto = new JLabel("Proyecto");
		lblProyecto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProyecto.setBounds(20, 93, 101, 14);
		panel_1.add(lblProyecto);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Proyectos> proys = InterfaceHibernate.getProyectosWhere("CODIGO",
						comboBox_2.getSelectedItem().toString());
				textField_3.setText(proys.get(0).getNombre());
				textField_4.setText(proys.get(0).getCiudad());
			}
		});
		comboBox_2.setBounds(21, 118, 177, 22);
		panel_1.add(comboBox_2);

		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(208, 62, 191, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(207, 119, 191, 20);
		panel_1.add(textField_3);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Proveedores> ps = InterfaceHibernate.getProveedoresWhere("CODIGO",
						comboBox.getSelectedItem().toString());
				textField_1.setText(ps.get(0).getNombre());
				textField_2.setText(ps.get(0).getDireccion());
			}
		});
		comboBox.setBounds(21, 61, 177, 22);
		panel_1.add(comboBox);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(20, 234, 51, 18);
		panel_1.add(spinner);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(81, 236, 417, 14);
		panel_1.add(lblNewLabel_2);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Piezas> ps = InterfaceHibernate.getPiezasWhere("CODIGO", comboBox_1.getSelectedItem().toString());
				textField.setText(ps.get(0).getNombre());
				textField_5.setText(ps.get(0).getDescripcion());
			}
		});

		comboBox_1.setBounds(21, 176, 177, 22);
		panel_1.add(comboBox_1);

		JButton btnNewButton = new JButton("A\u00F1adir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Proveedores> provs = InterfaceHibernate.getProveedoresWhere("CODIGO",
						comboBox.getSelectedItem().toString());
				Proveedores prov = provs.get(0);
				List<Piezas> piezas = InterfaceHibernate.getPiezasWhere("CODIGO",
						comboBox_1.getSelectedItem().toString());
				Piezas piz = piezas.get(0);
				List<Proyectos> proys = InterfaceHibernate.getProyectosWhere("CODIGO",
						comboBox_2.getSelectedItem().toString());
				Proyectos proy = proys.get(0);
				float cantidad = Float.parseFloat(spinner.getValue().toString());

				List<Gestion> gs = InterfaceHibernate.getGestionesWhereID(piz.getCodigo(), proy.getCodigo(),
						prov.getCodigo());
				if (gs.size() == 0) {
					lblNewLabel_2.setText("");
					GestionId gId = new GestionId(piz.getCodigo(), proy.getCodigo(), prov.getCodigo());
					Gestion g = new Gestion(gId, prov, piz, proy, cantidad);
					InterfaceHibernate.insertGestion(g);
					refrescarJTable();
				} else {
					lblNewLabel_2.setForeground(Color.RED);
					lblNewLabel_2.setText("Esa getión ya existe");
				}

			}
		});
		btnNewButton.setBounds(508, 232, 91, 23);
		panel_1.add(btnNewButton);

		JLabel label = new JLabel("Piezas");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(20, 151, 101, 14);
		panel_1.add(label);

		textField = new JTextField();
		textField.setText((String) null);
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(208, 177, 191, 20);
		panel_1.add(textField);

		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(412, 62, 187, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(412, 119, 187, 20);
		panel_1.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(412, 177, 187, 20);
		panel_1.add(textField_5);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 355, 609, 211);
		contentPane.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		//////////////////////////////////////// Aqui empieza todo
		//////////////////////////////////////// ////////////////////////////////////////
		
		rellenarJTable();

		rellenarJComboBox(comboBox, InterfaceHibernate.getProveedores());
		rellenarJComboBox(comboBox_2, InterfaceHibernate.getProyectos());
		rellenarJComboBox(comboBox_1, InterfaceHibernate.getPiezas());

		List<Proveedores> provs = InterfaceHibernate.getProveedoresWhere("CODIGO",
				comboBox.getSelectedItem().toString());
		textField_1.setText(provs.get(0).getNombre());
		textField_2.setText(provs.get(0).getDireccion());

		List<Proyectos> proys = InterfaceHibernate.getProyectosWhere("CODIGO", comboBox_2.getSelectedItem().toString());
		textField_3.setText(proys.get(0).getNombre());
		textField_4.setText(proys.get(0).getCiudad());

		List<Piezas> piz = InterfaceHibernate.getPiezasWhere("CODIGO", comboBox_1.getSelectedItem().toString());
		textField.setText(piz.get(0).getNombre());
		textField_5.setText(piz.get(0).getDescripcion());
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(208, 37, 101, 14);
		panel_1.add(lblNombre);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDireccin.setBounds(412, 37, 101, 14);
		panel_1.add(lblDireccin);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre_1.setBounds(208, 94, 101, 14);
		panel_1.add(lblNombre_1);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCiudad.setBounds(412, 94, 101, 14);
		panel_1.add(lblCiudad);
		
		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre_2.setBounds(208, 152, 101, 14);
		panel_1.add(lblNombre_2);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescripcin.setBounds(412, 152, 101, 14);
		panel_1.add(lblDescripcin);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(10, 577, 609, 102);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField_6 = new JTextField();
		textField_6.setText((String) null);
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(10, 28, 191, 20);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setText((String) null);
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(211, 28, 191, 20);
		panel_2.add(textField_7);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(508, 27, 91, 23);
		panel_2.add(btnBorrar);
		
		JLabel lblProveedor = new JLabel("Proyecto");
		lblProveedor.setBounds(10, 11, 71, 14);
		panel_2.add(lblProveedor);
		
		JLabel lblProyecto_1 = new JLabel("Proveedor");
		lblProyecto_1.setBounds(211, 11, 71, 14);
		panel_2.add(lblProyecto_1);
		
		JLabel lblPiezas_1 = new JLabel("Piezas");
		lblPiezas_1.setBounds(10, 56, 71, 14);
		panel_2.add(lblPiezas_1);
		
		textField_8 = new JTextField();
		textField_8.setText((String) null);
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		textField_8.setBounds(10, 70, 191, 20);
		panel_2.add(textField_8);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_1.setBounds(211, 71, 51, 18);
		panel_2.add(spinner_1);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(508, 69, 91, 23);
		panel_2.add(btnModificar);

	}

	private void rellenarJTable() {
		MouseListener tableMouseListener;

		Object[][] data = {};

		gs = InterfaceHibernate.getGestiones();
		if (gs != null) {
			data = new Object[gs.size()][4];
			for (int i = 0; i < gs.size(); i++) {
				data[i][0] = gs.get(i).getProyectos().getCodigo();
				data[i][1] = gs.get(i).getProveedores().getCodigo();
				data[i][2] = gs.get(i).getPiezas().getCodigo();
				data[i][3] = gs.get(i).getCantidad();
			}
		}
		String[] colName = { "Proyecto", "Proveedor", "Pieza", "Cantidad" };
		tableMouseListener = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				int row = table_1.rowAtPoint(e.getPoint());// get mouse-selected row
//				int col = table_1.columnAtPoint(e.getPoint());// get mouse-selected col
//
//				String codigo = (String) tableModel.getValueAt(row, 0);
//				Piezas pElegido = null;
//				for (Gestion g : gs) {
//					if (codigo.equals(g.getCodigo())) {
//						pElegido = g;
//					}
//				}

				// textField_3.setText(pElegido.getCodigo());
				// textField_3.setEnabled(false);
				// textField_4.setText(pElegido.getNombre());
				// textField_5.setText("" + pElegido.getPrecio());
				// textField_6.setText(pElegido.getDescripcion());
				//
				// btnNewButton.setEnabled(true);
				// btnBorrar.setEnabled(true);

				// incBorrar = inc;
			}
		};

		table_1 = new javax.swing.JTable();

		table_1.setModel(new javax.swing.table.DefaultTableModel(data, colName) {

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

		table_1.addMouseListener(tableMouseListener);
		tableModel = (DefaultTableModel) table_1.getModel();

		scrollPane_1.setViewportView(table_1);

		table_1 = new JTable(data, colName);
		scrollPane_1 = new JScrollPane(table_1);

	}

	public void refrescarJTable() {
		tableModel.setRowCount(0);
		Object[] data = {};

		gs = InterfaceHibernate.getGestiones();
		if (gs != null) {
			data = new Object[4];
			for (int i = 0; i < gs.size(); i++) {
				data[0] = gs.get(i).getProyectos().getCodigo();
				data[1] = gs.get(i).getProveedores().getCodigo();
				data[2] = gs.get(i).getPiezas().getCodigo();
				data[3] = gs.get(i).getCantidad();
				tableModel.addRow(data);
			}
		}
		table_1.setModel(tableModel);
		tableModel.fireTableDataChanged();

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
