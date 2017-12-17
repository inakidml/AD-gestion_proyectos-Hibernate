package modelo.utils;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
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
		// Conseguimos un sessionfactory
		sesion = HibernateUtil.getSessionFactory();

	}

	// Consulta genérica
	public static Iterator consultaHQL(String consulta) {
		session = sesion.openSession();
		String hql = consulta;
		Query q = session.createQuery(hql);
		Iterator result = q.iterate();
		return result;
	}

	// Gets//////////////////////////////////////////////
	public static List<Proveedores> getProveedores() {
		session = sesion.openSession();
		String hql = "from Proveedores";
		Query q = session.createQuery(hql);
		List<Proveedores> ps = q.getResultList();
		return ps;
	}

	public static List<Proveedores> getProveedoresWhere(String condicion, String valor) {
		session = sesion.openSession();
		String hql = "from Proveedores where " + condicion + " LIKE " + "'%" + valor + "%'";
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

	public static List<Piezas> getPiezasWhere(String condicion, String valor) {
		session = sesion.openSession();
		String hql = "from Piezas where " + condicion + " LIKE " + "'%" + valor + "%'";
		Query q = session.createQuery(hql);
		List<Piezas> ps = q.getResultList();
		return ps;
	}

	public static List<Piezas> getPiezasWhere(String condicion, float valor) {
		session = sesion.openSession();
		String hql = "from Piezas where " + condicion + " = " + valor;
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

	public static List<Proyectos> getProyectosWhere(String condicion, String valor) {
		session = sesion.openSession();
		String hql = "from Proyectos where " + condicion + " LIKE " + "'%" + valor + "%'";
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

	public static List<Gestion> getGestionesWhere(String condicion, String valor) {
		session = sesion.openSession();
		String hql = "from Gestion where " + condicion + " LIKE " + "'%" + valor + "%'";
		Query q = session.createQuery(hql);
		List<Gestion> ps = q.getResultList();
		return ps;
	}

	public static List<Gestion> getGestionesWhereID(String codPiezas, String codProyecto, String codProveedor) {
		session = sesion.openSession();
		String hql = "from Gestion where CODPIEZAS = " + codPiezas + "AND CODPROYECTO = " + codProyecto
				+ "AND CODPROVEEDOR = " + codProveedor;
		Query q = session.createQuery(hql);
		List<Gestion> ps = q.getResultList();
		return ps;
	}

	// Inserts///////////////////////////////////////////////////
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

	// Updates//////////////////////////////////////////////////////////////
	public static void updateProveedor(Proveedores p) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.update(p);
		ts.commit();
		session.close();
	}

	public static void updatePieza(Piezas p) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.update(p);
		ts.commit();
		session.close();
	}

	public static void updateProyecto(Proyectos p) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.update(p);
		ts.commit();
		session.close();
	}

	public static void updateGestion(Gestion g) {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.update(g);
		ts.commit();
		session.close();
	}

	// Borrar/////////////////////////////////////////////////////////////////////////
	public static void borrarProveedor(Proveedores p) throws HibernateException {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.delete(p);
		ts.commit();
		session.close();
	}

	public static void borrarProyecto(Proyectos p) throws HibernateException {
		session = sesion.openSession();
		ts = session.beginTransaction();
		session.delete(p);
		ts.commit();
		session.close();
	}

	public static void borrarPieza(Piezas p) throws HibernateException {
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