import org.example.infrastructure.HibernateUtil;
import org.example.model.Country;
import org.example.model.University;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class test {
    public static void main(String[] args) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            University mit = new University();
            mit.setName("MIT");

            Country kyrgyzstan = new Country();
            kyrgyzstan.setName("Kyrgyzstan");

            Country germany = new Country();
            germany.setName("Germany");


            User user1 = new User();
            user1.setName("Azumi");
            user1.setAge(18);
            user1.setEmail("Azumi@gmail.com");
            user1.setUsername("Zuzu");

            User user2 = new User();
            user2.setName("Mustafa");
            user2.setAge(21);
            user2.setEmail("Mustafa@gmail.com");
            user2.setUsername("Musa");

            user1.setUniversity(mit);
            user2.setUniversity(mit);
            user1.setCountry(kyrgyzstan);
            user2.setCountry(germany);

            mit.getUsers().add(user1);
            mit.getUsers().add(user2);

            kyrgyzstan.getUser().add(user1);
            germany.getUser().add(user2);

            session.persist(kyrgyzstan);
            session.persist(germany);
            session.persist(mit);
            session.persist(user1);
            session.persist(user2);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            System.out.println("Ошибка при сохранении пользователя");
        }
    }
}
