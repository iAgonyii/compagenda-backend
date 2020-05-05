package dao;

import domain.Activity;
import domain.Team;

import javax.persistence.EntityManager;

public class TeamDao implements ITeamDao {
    private final EntityManager em;

    public TeamDao(EntityManager em) {
        this.em = em;
    }

    public boolean createTeam(Team team) {
        em.getTransaction().begin();
        try {
            em.persist(team);
            em.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
        finally {
            em.close();
        }
    }

    public boolean deleteTeam(Team team) {
        em.getTransaction().begin();
        try {
            em.remove(team);
            em.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
        finally {
            em.close();
        }
    }

}
