package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Proveedores;
import modelo.utils.InterfaceHibernate;

import java.awt.Color;
import javax.swing.JLabel;
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

public class VProveedores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VProveedores frame = new VProveedores();
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
	public VProveedores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 609, 51);
		contentPane.add(panel);
		
		JLabel lblProveedores = new JLabel("Proveedores");
		lblProveedores.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel.add(lblProveedores);
		
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
		textField.setBounds(10, 48, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(106, 48, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(202, 48, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(10, 36, 46, 14);
		panel_1.add(lblCdigo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(106, 36, 46, 14);
		panel_1.add(lblNombre);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(202, 36, 46, 14);
		panel_1.add(lblDireccin);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(510, 47, 89, 23);
		panel_1.add(btnBuscar);
		
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
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBounds(510, 47, 89, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setBounds(10, 31, 46, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(120, 31, 46, 14);
		panel_2.add(lblNombre_1);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(247, 31, 46, 14);
		panel_2.add(lblApellidos);
		
		JLabel lblDireccin_1 = new JLabel("Direcci\u00F3n");
		lblDireccin_1.setBounds(374, 31, 46, 14);
		panel_2.add(lblDireccin_1);
		
		JButton btnBorrar = new JButton("Borrar");
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
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(10, 48, 100, 20);
		panel_3.add(textField_7);
		
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
		
		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.setBounds(510, 47, 89, 23);
		panel_3.add(btnAadir);
		
		JLabel label_1 = new JLabel("C\u00F3digo");
		label_1.setBounds(10, 31, 46, 14);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setBounds(120, 31, 46, 14);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("Apellidos");
		label_3.setBounds(247, 31, 46, 14);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("Direcci\u00F3n");
		label_4.setBounds(374, 31, 46, 14);
		panel_3.add(label_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 163, 609, 200);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		////////////////////////////////////////Aqui empieza todo
		rellenarJTable();
	}

	private void rellenarJTable() {
	        MouseListener tableMouseListener;
	        tableMouseListener = new MouseAdapter() {

	            @Override
	            public void mouseClicked(MouseEvent e) {
	                int row = table.rowAtPoint(e.getPoint());//get mouse-selected row
	                int col = table.columnAtPoint(e.getPoint());//get mouse-selected col
	               
	                String codigo = (String) tableModel.getValueAt(row, 0);
//	                List<Proveedores> ps = InterfaceHibernate.getProveedores();
//                for (Proveedores p : ps) {
//	                    if (tipo.equals(tipoIncidencia.getTipo())) {
//	                        idElegido = tipoIncidencia.getId();
//	                    }
//	                }
//	                tI.setId(idElegido);
//	                tI = tiposIncidencias.get(tiposIncidencias.indexOf(tI)); //conseguimos el objeto
//	                Incidencia inc;
//	                inc = new Incidencia(tI, j, (String) tableModel.getValueAt(row, 1));
//	                inc = listaIncidencias.get(listaIncidencias.indexOf(inc));
//	                jTextField2.setText("" + inc.getTipoIncidencia().getTipo());
//	                jTextField3.setText(inc.getFecha());
//	                jTextField4.setText(inc.getTipoIncidencia().getSancion());
//
//	                incBorrar = inc;
	            }
	        };



	        Object[][] data = {};
	        InterfaceHibernate iH = new InterfaceHibernate();
            List<Proveedores> ps = iH.getProveedores();
	        if (ps != null) {
	            data = new Object[ps.size()][4];
	            for (int i = 0; i < ps.size(); i++) {
	                data[i][0] = ps.get(i).getCodigo();
	                data[i][1] = ps.get(i).getNombre();
	                data[i][2] = ps.get(i).getApellidos();
	                data[i][3] = ps.get(i).getDireccion();
	            }
	        }
	        String[] colName = {"Código", "Nombre", "Apellido", "Dirección"};

	        table = new javax.swing.JTable();

	        table.setModel(new javax.swing.table.DefaultTableModel(data, colName) {

	            /**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
	            public boolean isCellEditable(int row, int column) {
	                //all cells false
	                return false;
	            }
	        });
	        table.addMouseListener(tableMouseListener);
	        tableModel = (DefaultTableModel) table.getModel();

	        scrollPane.setViewportView(table);

	        table = new JTable(data, colName);
	        scrollPane = new JScrollPane(table);

	    }
	
	
}
