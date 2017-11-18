package modelo.utils;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static final SessionFactory sessionFactory = buildSessionFactory();

private static SessionFactory buildSessionFactory(){
	try {
		return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
public static SessionFactory getSessionFactory(){
	return sessionFactory;
}
}
