package Services;

import domain.User;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import service.UserService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
//        DatabaseCleaner cleaner = new DatabaseCleaner(emf.createEntityManager());
//        cleaner.clean("User");
        UserService service = new UserService();
        User user = service.getUser(2001);
        user.setEmail("to@bedone.com");
        service.editUser(user);
    }

    @Test
    public void a_getUsers() {
        boolean done;
        try {
            List<User> users = service.getUsers();
            done = true;
        }
        catch(Exception e) {
            done = false;
        }
        assertTrue(done);
    }

    @Test
    public void b_getSpecificUser() {
        String expectedName = "royteneij";
        User user = service.getUser(2001);

        assertEquals(expectedName, user.getUsername());
    }

    @Test
    public void c_editUserDetails() {
        String expectedEmail = "roy@roy.com";
        User user = service.getUser(2001);
        user.setEmail("roy@roy.com");

        service.editUser(user);
        User edited = service.getUser(2001);

        assertEquals(expectedEmail, edited.getEmail());
    }

    @Test
    public void d_getIdForName() {
        long expectedId = 2001;
        long actual = service.getIdForName("royteneij");

        assertEquals(expectedId, actual);
    }

    @Test
    public void e_getIdforNameNotExist() {
        assertEquals(0, service.getIdForName("soakdoksaokasdkodskos"));
    }


}
