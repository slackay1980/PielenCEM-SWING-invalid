package dao;

import entyties.Customer;
import entyties.CustomerStation;
import entyties.ProducentStation;
import entyties.Relation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class RelationDAO {


    public void saveRelation(Relation relation) throws HibernateException, Exception {
        Session session = util.HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        session.save(relation);
        session.flush();
        transaction.commit();
        session.close();
    }

    public boolean ifRelationExist(CustomerStation customerStation, ProducentStation producentStation) throws HibernateException, Exception {

        boolean relationExist;

        Session session = util.HibernateUtil.getSessionFactory().openSession();

        String querryStr = "FROM Relation as rel WHERE rel.customerStation =  :customerStation AND  rel.producentStation = :producentStation";

        Query query = session.createQuery(querryStr, Relation.class);

        query.setParameter("customerStation", customerStation);
        query.setParameter("producentStation", producentStation);

        List<Relation> relations = query.list();


        if (relations.size() == 0) {
            relationExist = false;
        }
        else {
            System.out.println(relations.get(0).getRelationName());
            relationExist = true;
        }

        return relationExist;

    }
}
