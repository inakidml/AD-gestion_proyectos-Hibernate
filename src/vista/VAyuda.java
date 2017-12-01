package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VAyuda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAyuda frame = new VAyuda();
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
	public VAyuda() {
		setResizable(false);
		setTitle("Ayuda");
		setBounds(100, 100, 450, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Proyecto creado por:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 424, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblIakiDiaz = new JLabel("I\u00F1aki Diaz");
		lblIakiDiaz.setHorizontalAlignment(SwingConstants.CENTER);
		lblIakiDiaz.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblIakiDiaz.setBounds(10, 82, 424, 60);
		contentPane.add(lblIakiDiaz);
		
		JLabel lblHttpsgithubcominakidmladgestionproyectoshibernate = new JLabel("https://github.com/inakidml/AD-gestion_proyectos-Hibernate");
		lblHttpsgithubcominakidmladgestionproyectoshibernate.setHorizontalAlignment(SwingConstants.CENTER);
		lblHttpsgithubcominakidmladgestionproyectoshibernate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHttpsgithubcominakidmladgestionproyectoshibernate.setBounds(10, 153, 424, 42);
		contentPane.add(lblHttpsgithubcominakidmladgestionproyectoshibernate);
	}

}
