package dev.ele;

public class VolleyballTeam<S> extends SportsTeam<VolleyballPlayer, S> {

    public VolleyballTeam(String teamName) {
        super(teamName);
    }

    public VolleyballTeam(String teamName, S affiliation) {
        super(teamName, affiliation);
    }
}