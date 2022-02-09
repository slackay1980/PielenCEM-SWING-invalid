package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entyties.Producent;
import org.hibernate.query.Query;

public class ProducentDAO {

	public ProducentDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveProducent(Producent producent) throws HibernateException, Exception {
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=session.beginTransaction();
		session.save(producent);
		transaction.commit();
		session.close();
	}
	
	public List<Producent> getProducentAccordToString(String searchString) throws HibernateException, Exception {
		
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		String querry = "FROM Producent as p WHERE p.producentName LIKE : searchString";
		
		@SuppressWarnings("deprecation")
		List<Producent> producentsLikeString = (List<Producent>) session.createQuery(querry, Producent.class).setString("searchString",searchString).list();

		return producentsLikeString;
	}

	public Producent getProducentById(int id ) throws HibernateException, Exception {

		Session session = util.HibernateUtil.getSessionFactory().openSession();
		Producent producent =  (Producent) session.get(Producent.class, id);

		return producent;
	}
}
