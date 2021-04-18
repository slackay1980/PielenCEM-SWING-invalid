package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entyties.ProducentStation;

public class ProducentStationsDAO {

	public ProducentStationsDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveNewStation(ProducentStation producentStation) throws HibernateException, Exception {
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(producentStation);
		transaction.commit();
		session.close();
	}
	
	
	@SuppressWarnings("deprecation")
	
		public List<ProducentStation> getProducentStationAccordToString(String searchString) throws HibernateException, Exception {
		

		Session session = util.HibernateUtil.getSessionFactory().openSession();
		String querry = "FROM ProducentStation as cs WHERE cs.stationName LIKE : searchString";
		
		List<ProducentStation> producenttationsLikeString = (List<ProducentStation>) session.createQuery(querry, ProducentStation.class).setString("searchString",searchString).list();
		
		return producenttationsLikeString;
	}
	

}
