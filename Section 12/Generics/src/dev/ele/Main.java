package dev.ele;

public class Main {
    public static void main(String[] args) {
        BaseballTeam<Affiliation> phillies = new BaseballTeam<>("Philadelphia Phillies",
                new Affiliation("City", "Philadelphia", "US"));
        BaseballTeam<Affiliation> astros = new BaseballTeam<>("Houston Astros");
        scoreResult(phillies, 23, astros, 12);
        // scoreResult(phillies, 12, astros, 12);
        // scoreResult(phillies, 12, astros, 23);
        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();
        printAffiliation(phillies);

        FootballTeam<Affiliation> barca = new FootballTeam<>("F.C. Barcelona");
        FootballTeam<Affiliation> manCity = new FootballTeam<>("Manchester City");
        scoreResult(barca, 3, manCity, 1);
        // scoreResult(barca, 3, phillies, 1);
        FootballPlayer pedri = new FootballPlayer("Pedri Gonzalez Lopez", "Center Midfielder");
        FootballPlayer yamal = new FootballPlayer("Lamine Yamal", "Right Winger");
        FootballPlayer haaland = new FootballPlayer("Erling Haaland", "Striker");
        FootballPlayer cherki = new FootballPlayer("Rayan Cherki", "Center Midfielder");
        barca.addTeamMember(pedri);
        barca.addTeamMember(yamal);
        // barca.addTeamMember(harper);
        manCity.addTeamMember(haaland);
        manCity.addTeamMember(cherki);
        barca.listTeamMembers();
        manCity.listTeamMembers();
        barca.addAffiliation(new Affiliation("City", "Barcelona", "ES"));
        manCity.addAffiliation(new Affiliation("City", "Manchester", "ENG"));
        printAffiliation(barca);
        printAffiliation(manCity);

        SportsTeam<VolleyballPlayer, String> womenDutch = new VolleyballTeam<>("Netherlands women NT");
        SportsTeam<VolleyballPlayer, String> womenIrish = new VolleyballTeam<>("Ireland women NT");

        womenDutch.addAffiliation("Amsterdam, City in NTL");
        printAffiliation(womenDutch);

        VolleyballPlayer jenny = new VolleyballPlayer("Jenny Ire", "Opposite");
        VolleyballPlayer martha = new VolleyballPlayer("Martha Vey", "Setter");
        VolleyballPlayer joules = new VolleyballPlayer("Joules", "Opposite");
        VolleyballPlayer jacqueline = new VolleyballPlayer("Jacqueline", "Setter");
        womenDutch.addTeamMember(joules);
        womenDutch.addTeamMember(jacqueline);
        womenIrish.addTeamMember(jenny);
        womenIrish.addTeamMember(martha);
        womenDutch.listTeamMembers();
        womenIrish.listTeamMembers();

    }

    public static <T extends Player, S> void scoreResult(SportsTeam<T, S> team1, int team1_score,
            SportsTeam<T, S> team2, int team2_score) {
        String message1 = team1.setScore(team1_score, team2_score);
        team2.setScore(team2_score, team1_score);
        System.out.printf("%s %d - %d %s%n%s %s %s%n", team1, team1_score, team2_score,
                team2, team1, message1, team2);
    }

    public static <T extends Player, S> void printAffiliation(SportsTeam<T, S> team) {
        System.out.println("AFFILIATION: " + team.getAffiliation());
    }
}