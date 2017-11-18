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

    public static List<Proveedores> getProveedores(){
    	session = sesion.openSession();
    	String hql = "from proveedores";
    	
    	 Query q = session.createQuery(hql);
    	 List<Proveedores> ps = q.getResultList();

    	return ps;
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
    public static void cargarProyectoById(int id){
    	
    	
    }
}