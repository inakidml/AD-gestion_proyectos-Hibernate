package modelo.utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import modelo.Gestion;
import modelo.Piezas;
import modelo.Proveedores;
import modelo.Proyectos;

/**
 *
 * @author 9fdam02
 */
public class InterfaceHibernate {

	private static SessionFactory sesion;
	private static Session session;
	private static Transaction ts;

	public InterfaceHibernate() {

		sesion = HibernateUtil.getSessionFactory();

	}

	public static List<Proveedores> getProveedores() {
		session = sesion.openSession();
		String hql = "from Proveedores";
		Query q = session.createQuery(hql);
		List<Proveedores> ps = q.getResultList();
		return ps;
	}

	public static List<Piezas> getPiezas() {
		session = sesion.openSession();
		String hql = "from Piezas";
		Query q = session.createQuery(hql);
		List<Piezas> ps = q.getResultList();
		return ps;
	}

	public static List<Proyectos> getProyectos() {
		session = sesion.openSession();
		String hql = "from Proyectos";
		Query q = session.createQuery(hql);
		List<Proyectos> ps = q.getResultList();
		return ps;
	}

	public static List<Gestion> getGestiones() {
		session = sesion.openSession();
		String hql = "from Gestion";
		Query q = session.createQuery(hql);
		List<Gestion> gs = q.getResultList();
		return gs;
	}

	public static void insertPieza(Piezas p) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.save(p);
		ts.commit();
		session.close();
	}

	public static void insertGestion(Gestion g) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.save(g);
		ts.commit();
		session.close();
	}

	public static void insertProveedor(Proveedores p) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.save(p);
		ts.commit();
		session.close();
	}

	public static void insertProyecto(Proyectos p) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.save(p);
		ts.commit();
		session.close();
	}
	
	public static void updateProveedor(Proveedores p) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.update(p);
		ts.commit();
		session.close();
	}
	
	

	public static void borrarProveedor(Proveedores p) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.delete(p);
		ts.commit();
		session.close();
	}

	public static void borrarProyecto(Proyectos p) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.delete(p);
		ts.commit();
		session.close();
	}

	public static void borrarPieza(Piezas p) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.delete(p);
		ts.commit();
		session.close();
	}

	public static void borrarGestion(Gestion g) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.delete(g);
		ts.commit();
		session.close();
	}
}