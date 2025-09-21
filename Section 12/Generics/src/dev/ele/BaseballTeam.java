package dev.ele;

public class BaseballTeam<S> extends SportsTeam<BaseballPlayer, S> {

    public BaseballTeam(String teamName) {
        super(teamName);
    }

    public BaseballTeam(String teamName, S affiliation) {
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

    // @Override
    // public String toString() {
    // return getTeamName() + " (Ranked " + ranking() + ")";
    // }
}