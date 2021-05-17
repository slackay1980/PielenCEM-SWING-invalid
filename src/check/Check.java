package check;

import entyties.User;
import org.hibernate.Session;

public class Check {

    public static void main(String[] args) throws Exception {
        Session session = util.HibernateUtil.getSessionFactory().openSession();
        User user = new User();
        user.setLogin("jg");
        user.setPassword("Fly");
        user.setName("Jocelyne");
        user.setSurname("Gondolf");
        user.setRole(User.Role.SELLER);
        session.save(user);
        session.close();
        util.HibernateUtil.sutDown();

    }
}
