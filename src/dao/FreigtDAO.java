package dao;

import entyties.Forwarder;
import entyties.Freight;
import entyties.Relation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class FreigtDAO {

    public  FreigtDAO() {

    }

    public void saveNewFreigt(Freight freigt) throws HibernateException, Exception {
        Session session = util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(freigt);
        transaction.commit();
        session.close();
    }

    public List<Freight> getFreigt(Relation relation, Forwarder forwarder) throws HibernateException, Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();


        String querry = "FROM Freigt as fr WHERE fr.relation  = :relation_id AND fr.forwarder = :forwarder_id";

        //  String hql = "FROM Employee E WHERE E.id = :employee_id";
        Query query = session.createQuery(querry);
        query.setParameter("relation_id",relation.getId());
        query.setParameter("forwarder_id",forwarder.getId());


        @SuppressWarnings("deprecation")
        List<Freight> freights = (List<Freight>) query.list();

        return freights;
    }



}
