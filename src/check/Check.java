package check;

import dao.*;
import entyties.*;
import org.hibernate.Session;
import org.hibernate.persister.walking.internal.StandardAnyTypeDefinition;

public class Check {

    public static void main(String[] args) throws Exception {

        Session session = util.HibernateUtil.getSessionFactory().openSession();

        Forwarder forwarder = new Forwarder();
        forwarder.setForwarderName("Krug");
        forwarder.setForwarderStreet("Ul. Lenina 34");
        forwarder.setForwarderLandPostCode("D-36757");
        forwarder.setForwarderCity("Hanover");


        Producent producent = new ProducentDAO().getProducentById(1);
        ProducentStation producentStation = producent.getProducentStations().get(1);

        Customer customer = new CustomerDAO().getCustomerById(1);
        CustomerStation customerStation = customer.getCustomerStations().get(0);


        Relation relation = new Relation();
        RelationDAO relationDAO = new RelationDAO();

        boolean ifExist = relationDAO.ifRelationExist(customerStation,producentStation);
        if (ifExist) {
            relation = relationDAO.getRelationByPsCs(producentStation,customerStation);
        }

        System.out.println("Ladestelle = " + producentStation.getStationName() + ", "+producentStation.getStationCity());
        System.out.println("Entladestelle = " + customerStation.getStationName() + ", "+customerStation.getStationCity());
        System.out.println("Relation exist = " + ifExist);


        Forwarder forwarder1 = new ForwarderDAO().getForwarderById(1);

        Freight freight = new Freight();


        freight.setForwarder(forwarder1);
        freight.setRelation(relation);
        freight.setFreigtPerTo(1250);


        new FreigtDAO().saveNewFreigt(freight);



    }
}
