package service;

import dao.ActivityDao;
import dao.ITeamDao;
import dao.TeamDao;
import domain.Team;
import domain.TeamOwner;
import domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TeamService {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("compagendaPU");
    private ITeamDao dao;
    private UserService userService;

    public boolean createTeam(String name, long userId) {
        List<User> members = new ArrayList();
        userService = new UserService();
        User owner = userService.getUser(userId);

        members.add(owner);
        Team team = new Team(name);
        team.setTeamMembers(members);

        EntityManager em = emf.createEntityManager();
        dao = new TeamDao(em);
        return dao.createTeam(team);
    }

    public boolean deleteTeam(Team team) {
        EntityManager em = emf.createEntityManager();
        dao = new TeamDao(em);
        return dao.deleteTeam(team);
    }
}
