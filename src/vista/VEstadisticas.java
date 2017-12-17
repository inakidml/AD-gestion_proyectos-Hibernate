package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import modelo.utils.InterfaceHibernate;
import javax.swing.JTabbedPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 444, 272);
		contentPane.add(tabbedPane);
		rellenarGraficos();

	}

	private void rellenarGraficos() {
		String hql = "select sum(cantidad) as cantidad, proveedores.nombre as nombreProv from Gestion group by proveedores";
		tabbedPane.addTab("Venta de piezas", null, createDemoPanel("Piezas suministradas", hql), null);
		hql = "select count(proveedores), proyectos.nombre from Gestion group by proyectos";
		tabbedPane.addTab("Proveedores", null, createDemoPanel("Proveedores en proyectos", hql), null);
		hql = "select sum(cantidad), piezas.nombre from Gestion group by piezas";
		tabbedPane.addTab("Piezas", null, createDemoPanel("Cantidad de piezas", hql), null);
	}

	public void refrescarGraficos() {
		tabbedPane.removeAll();
		String hql = "select sum(cantidad) as cantidad, proveedores.nombre as nombreProv from Gestion group by proveedores";
		tabbedPane.addTab("Venta de piezas", null, createDemoPanel("Piezas suministradas", hql), null);
		hql = "select count(proveedores), proyectos.nombre from Gestion group by proyectos";
		tabbedPane.addTab("Proveedores", null, createDemoPanel("Proveedores en proyectos", hql), null);

		hql = "select sum(cantidad), piezas.nombre from Gestion group by piezas";
		tabbedPane.addTab("Piezas", null, createDemoPanel("Cantidad de piezas", hql), null);

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
