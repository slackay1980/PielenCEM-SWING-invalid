package ui;

import entyties.User;
import org.hibernate.Session;

public class Check {

    public static void main(String[] args) throws Exception {
        Session session = util.HibernateUtil.getSessionFactory().openSession();
        User user = new User();
        user.setName("Petro");
        user.setRole(User.Role.DISPO);

        session.save(user);
        session.close();
        util.HibernateUtil.sutDown();

    }
}
