package Services;

import domain.User;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import rest.AuthRest;
import service.AuthService;
import service.UserService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthTests {
    AuthService service = new AuthService();
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("compagendaPU");

    @BeforeClass
    public static void cleanUsersDB() {
        DatabaseCleaner cleaner = new DatabaseCleaner(emf.createEntityManager());
        cleaner.deleteUser("testUser");
    }

    @Test
    public void a_RegisterNewUser() {
        User user = new User("testUser", "testUser@test.com", "secret");
        boolean success = service.register(user);

        assertTrue(success);
    }

    @Test
    public void b_RegisterAlreadyExists() {
        User user = new User("royteneij", "test@test.com", "secrettest");
        boolean success = service.register(user);

        assertFalse(success);
    }

    @Test
    public void c_LoginSuccess() {
        boolean success = service.login("testUser", "secret");
        assertTrue(success);
    }

    @Test
    public void d_LoginIncorrectPass() {
        boolean success = service.login("testUser", "wrongSecret");
        assertFalse(success);
    }

    @Test
    public void e_LoginNotFound() {
        boolean success = service.login("mnlkpo", "secret");
        assertFalse(success);
    }

}
