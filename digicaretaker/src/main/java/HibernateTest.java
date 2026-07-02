import com.digicaretaker.DAO.UserDAO;
import com.digicaretaker.daoimpl.UserDAOImpl;
import com.digicaretaker.entity.Users;

public class HibernateTest {

    public static void main(String[] args) {

        UserDAO dao = new UserDAOImpl();

        Users user = dao.getUserByEmail("your-email@gmail.com");

        if (user != null) {
            System.out.println(user.getFirstName());
        } else {
            System.out.println("User not found");
        }
    }
}
