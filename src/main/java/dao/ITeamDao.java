package dao;

import domain.Team;

public interface ITeamDao {
    boolean createTeam(Team team);
    boolean deleteTeam(Team team);
}
