package Services;

import domain.Team;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import service.ActivityService;
import service.TeamService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static junit.framework.TestCase.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TeamTests {

    TeamService service = new TeamService();
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("compagendaPU");

    @BeforeClass
    public static void cleanUsersDB() {
        //DatabaseCleaner cleaner = new DatabaseCleaner(emf.createEntityManager());
        //cleaner.deleteUser("testUser");
    }

    @Test
    public void a_CreateTeam() {
        boolean created = service.createTeam("TSM", 2001);
        assertTrue(created);
    }

    @Test
    public void b_DeleteTeam() {

    }
}
