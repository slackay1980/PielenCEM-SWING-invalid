package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import entyties.OrderCiment;


public class OrderCimentDAO {

	public OrderCimentDAO() {

	}
	
	public List<OrderCiment> getAllOrdersCiment() throws HibernateException, Exception {
		
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		List<OrderCiment> orderCiment = session.createQuery("from OrderCiment as oc order by oc.Id asc ", OrderCiment.class).getResultList();

		return orderCiment;
	}
	
	public void saveOrderCiment(OrderCiment orderCiment) throws HibernateException, Exception {
		
		Session session = util.HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(orderCiment);
		session.getTransaction().commit();
		session.close();
	}

}
