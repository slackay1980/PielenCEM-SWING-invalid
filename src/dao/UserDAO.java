package dao;


import java.util.List;

import entyties.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import entyties.User;

public class UserDAO {

	public UserDAO() {
		
		
		// TODO Auto-generated constructor stub
	}
	
	public List<User> getAllUsers() throws HibernateException, Exception {
		
		Session session = util.HibernateUtil.getSessionFactory().openSession();

		List<User> users = session.createQuery("from User", User.class).getResultList();

				
		return users;
	}

	public List<User> getAllSeller() throws HibernateException, Exception {

		Session session = util.HibernateUtil.getSessionFactory().openSession();
		//language = SQL
		String querry = "FROM User as u WHERE u.role='SELLER'";

		@SuppressWarnings("deprecation")
		List<User> users  = (List<User>) session.createQuery(querry, User.class).list();

		return users;
	}

}
