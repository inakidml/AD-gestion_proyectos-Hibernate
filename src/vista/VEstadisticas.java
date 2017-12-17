package vista;

import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import modelo.utils.InterfaceHibernate;

//https://www.tutorialspoint.com/jfreechart/jfreechart_pie_chart.htm

public class VEstadisticas extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VEstadisticas frame = new VEstadisticas();
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
	public VEstadisticas() {
		setTitle("Estadísticas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 587, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 587, 427);
		contentPane.add(tabbedPane);
		rellenarGraficos();

	}

	private void rellenarGraficos() {

		String hql = "select sum(cantidad) as cantidad, proveedores.nombre as nombreProv from Gestion group by proveedores";
		tabbedPane.addTab("Venta de piezas", null, createDemoPanel("Piezas suministradas", hql), null);

		hql = "select count(proveedores), proyectos.nombre from Gestion group by proyectos";
		tabbedPane.addTab("Proveedores", null, createDemoPanel("Proveedores en proyectos", hql), null);
		
		hql = "select count(proyectos), proveedores.nombre from Gestion group by proveedores";
		tabbedPane.addTab("Proyectos", null, createDemoPanel("Nº proyectos proveedor", hql), null);

		hql = "select sum(cantidad), piezas.nombre from Gestion group by piezas";
		tabbedPane.addTab("Top Piezas", null, createDemoPanel("Número de piezas", hql), null);

		hql = "select count(piezas), proyectos.nombre from Gestion group by proyectos";
		tabbedPane.addTab("Cantidad Piezas", null, createDemoPanel("Cantidad piezas diferentes proyectos", hql), null);
		
		hql = "select count(piezas), proveedores.nombre from Gestion group by proveedores";
		tabbedPane.addTab("Tipo piezas", null, createDemoPanel("Tipo piezas suministradas proveedor", hql), null);
		
	}

	public void refrescarGraficos() {
		tabbedPane.removeAll();
		rellenarGraficos();
	}

	private static PieDataset createDataset(String hql) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		Iterator result = InterfaceHibernate.consultaHQL(hql);
		while (result.hasNext()) {
			Object[] par = (Object[]) result.next();
			dataset.setValue(new String("" + par[1] + ", " + par[0]), Float.parseFloat(par[0].toString()));
		}
		return dataset;
	}

	private static JFreeChart createChart(PieDataset dataset, String titulo) {
		JFreeChart chart = ChartFactory.createPieChart(titulo, // chart title
				dataset, // data
				true, // include legend
				true, false);

		return chart;
	}

	public static JPanel createDemoPanel(String titulo, String hql) {
		JFreeChart chart = createChart(createDataset(hql), titulo);
		return new ChartPanel(chart);
	}
}
