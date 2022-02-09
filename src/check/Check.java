package check;

import dao.CustomerDAO;
import dao.CustomerStationDAO;
import dao.ProducentDAO;
import entyties.*;
import org.hibernate.Session;
import dao.RelationDAO;

public class Check {

    public static void main(String[] args) throws Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();

        Forwarder forwarder = new Forwarder();
        forwarder.setForwarderName("Krug");
        forwarder.setForwarderStreet("Ul. Lenina 34");
        forwarder.setForwarderLandPostCode("D-36757");
        forwarder.setForwarderCity("Hanover");


        Producent producent = new ProducentDAO().getProducentById(1);
        producent =

        CustomerStation cs =  csDAaaO.getStationById(3);

        ProducentStationsDAO psDAO = new ProducentStationsDAO();
        ProducentStation ps = psDAO.getStationById(1);

        RelationDAO relationDAO = new RelationDAO();

        boolean ifExist = relationDAO.ifRelationExist(cs,ps);

        System.out.println("Relation exist = " + ifExist);
    }
}
