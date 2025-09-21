package dev.ele;

public class FootballTeam<S> extends SportsTeam<FootballPlayer, S> {
    public FootballTeam(String teamName) {
        super(teamName);
    }

    public FootballTeam(String teamName, S affiliation) {
        super(teamName, affiliation);
    }

    // @Override
    // public void listTeamMembers() {
    // System.out.printf("=========%s Roster=========%n", getTeamName());
    // // System.out.println(teamMembers);
    // for (Player p : getTeamMembers()) {
    // System.out.printf("Name: %s, Position: %s%n", p.name(), p.position());
    // }
    // }
}