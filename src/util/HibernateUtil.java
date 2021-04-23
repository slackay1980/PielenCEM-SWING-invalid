package util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory factory;
//to disallow creating objects by other classes.

	private HibernateUtil() {
	}
//maling the Hibernate SessionFactory object as singleton

	public static synchronized SessionFactory getSessionFactory() {

		if (factory == null) {
			Configuration config = new Configuration().addAnnotatedClass(entyties.Customer.class);
			config.addAnnotatedClass(entyties.CustomerStation.class);
			config.addAnnotatedClass(entyties.OrderCiment.class);
			config.addAnnotatedClass(entyties.Producent.class);
			config.addAnnotatedClass(entyties.ProducentStation.class);
			config.addAnnotatedClass(entyties.Product.class);
			config.addAnnotatedClass(entyties.User.class);
			config.addAnnotatedClass(entyties.Forwarder.class);
			factory = config.configure("/resources/hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}

	public static void sutDown() throws Exception {
		getSessionFactory().close();
	}
}