package check;

import dao.CustomerDAO;
import dao.CustomerStationDAO;
import dao.ProducentStationsDAO;
import entyties.CustomerStation;
import entyties.ProducentStation;
import entyties.User;
import org.hibernate.Session;
import dao.RelationDAO;

public class Check {

    public static void main(String[] args) throws Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();

        CustomerStationDAO csDAO =  new CustomerStationDAO();
        CustomerStation cs =  csDAO.getStationById(3);

        ProducentStationsDAO psDAO = new ProducentStationsDAO();
        ProducentStation ps = psDAO.getStationById(1);

        RelationDAO relationDAO = new RelationDAO();

        boolean ifExist = relationDAO.ifRelationExist(cs,ps);

        System.out.println("Relation exist = " + ifExist);
    }
}
