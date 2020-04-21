import dao.UserDao;
import domain.User;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import service.UserService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTests {
    UserService service = new UserService();
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("compagendaPU");

    @BeforeClass
    public static void cleanUsersDB() {
        DatabaseCleaner cleaner = new DatabaseCleaner(emf.createEntityManager());
        cleaner.clean("User");
    }

//    @Test
//    public void a_addUsers() {
//        User one = new User("RoyTeneij", "royteneij@Hotmail.nl");
//        User two = new User("Mythic Rimic", "rimic@fncs.com");
//        User three = new User("SodjokFNBR", "sodjok@lexa.nl");
//
//        boolean added;
//        try {
//            service.addUser(one);
//            service.addUser(two);
//            service.addUser(three);
//            added = true;
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//            added = false;
//        }
//
//        assertTrue(added);
//    }
//
//    @Test
//    public void b_getUsers() {
//        List<User> expected = new ArrayList<User>();
//        expected.add(new User("RoyTeneij", "royteneij@Hotmail.nl"));
//        expected.add(new User("Mythic Rimic", "rimic@fncs.com"));
//        expected.add(new User("SodjokFNBR", "sodjok@lexa.nl"));
//        List<User> users = service.getUsers();
//        for(int i = 0; i < expected.size(); i++) {
//            assertEquals(expected.get(i).getUsername(), users.get(i).getUsername());
//            assertEquals(expected.get(i).getEmail(), users.get(i).getEmail());
//        }
//    }
}
