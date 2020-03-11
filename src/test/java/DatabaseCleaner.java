import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DatabaseCleaner {
    private final EntityManager em;
    public DatabaseCleaner(EntityManager em) {
        this.em = em;
    }

    public void clean(String table) {
        em.getTransaction().begin();
        try {
            em.createQuery("DELETE from " + table).executeUpdate();
            em.getTransaction().commit();
        }
        catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }
}
