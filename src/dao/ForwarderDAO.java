package dao;

import entyties.Forwarder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ForwarderDAO {

    public void saveForwarder(Forwarder forwarder) throws HibernateException, Exception {
    Session session = util.HibernateUtil.getSessionFactory().openSession();
    Transaction transaction=session.beginTransaction();
		session.save(forwarder);
		session.flush();
		transaction.commit();
		session.close();
}

    public List<Forwarder> getForwarderByString(String searchString) throws HibernateException, Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();

        String querry = "FROM Forwarder as f WHERE f.forwarderName LIKE : searchString";

        @SuppressWarnings("deprecation")
        List<Forwarder> forwardersLikeString = (List<Forwarder>) session.createQuery(querry, Forwarder.class).setString("searchString",searchString).list();

        return forwardersLikeString;
    }

}
