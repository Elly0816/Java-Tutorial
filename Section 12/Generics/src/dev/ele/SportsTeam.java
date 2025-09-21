package dev.ele;

import java.util.ArrayList;
import java.util.List;

public abstract class SportsTeam<T extends Player, S> {

    private String teamName;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;
    private S affiliation;

    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }

    public SportsTeam(String teamName, S affiliation) {
        this(teamName);
        this.affiliation = affiliation;
    }

    public void addTeamMember(T player) {
        if (!teamMembers.contains(player)) {
            teamMembers.add(player);
        }
    }

    public String getTeamName() {
        return this.teamName;
    }

    public List<T> getTeamMembers() {
        return this.teamMembers;
    }

    public int getTotalWins() {
        return this.totalWins;
    }

    public void setTotalWins() {
        this.totalWins++;
    }

    public int getTotalTies() {
        return this.totalTies;
    }

    public void setTotalTies() {
        this.totalTies++;
    }

    public int getTotalLosses() {
        return this.totalLosses;
    }

    public void setTotalLosses() {
        this.totalLosses++;
    }

    public S getAffiliation() {
        return this.affiliation;
    }

    public void addAffiliation(S affiliation) {
        this.affiliation = affiliation;
    }

    public void listTeamMembers() {
        System.out.printf("=========%s Roster=========%n", getTeamName());
        // System.out.println(teamMembers);
        for (Player p : getTeamMembers()) {
            System.out.printf("Name: %s, Position: %s%n", p.name(), p.position());
        }
    };

    public int ranking() {
        // return (totalLosses * 0) + (totalTies) + (totalWins * 3);
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int ourScore, int theirScore) {
        String message = "lost to";
        if (theirScore < ourScore) {
            totalWins++;
            message = "beat";
        } else if (theirScore > ourScore) {
            totalLosses++;
        } else {
            totalTies++;
            message = "tied";
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}