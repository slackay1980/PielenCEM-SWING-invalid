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

    public List<Relation> getRelationByString(String searchString) throws HibernateException, Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();

        String querry = "FROM Relation as r WHERE r.relationName LIKE : searchString";

        @SuppressWarnings("deprecation")
        List<Relation> relationsLikeString = (List<Relation>) session.createQuery(querry, Relation.class).setString("searchString",searchString).list();

        return relationsLikeString;
    }

    public boolean ifRelationExist(CustomerStation customerStation, ProducentStation producentStation) throws HibernateException, Exception {

        boolean relationExist;

        Session session = util.HibernateUtil.getSessionFactory().openSession();

        String querryStr = "FROM Relation as rel WHERE rel.customerStation =  :customerStation AND  rel.producentStation = :producentStation";

        Query query = session.createQuery(querryStr, Relation.class);

        query.setParameter("customerStation", customerStation);
        query.setParameter("producentStation", producentStation);

        List<Relation> relations;

        relations = (List<Relation>) query.list();


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
