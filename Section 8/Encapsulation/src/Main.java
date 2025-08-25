public class Main {
    public static void main(String[] args) {

        // Player player = new Player();
        // player.name = "Tim";
        // player.health = 20;
        // player.weapon = "Sword";
        // int damage = 10;
        // player.loseHealth(damage);
        // System.out.println("Remaining Health = " + player.healthRemaining());

        // player.loseHealth(11);
        // System.out.println("Remaining Health = " + player.healthRemaining());

        EnhancedPlayer player = new EnhancedPlayer("Tim", 85, "Spear");
        System.out.println("Remaining Health = " + player.healthRemaining());
        int damage = 35;
        player.loseHealth(damage);
        // System.out.println("Remaining Health = " + player.healthRemaining());
        System.out.printf("Player %s's weapon is a %s, and they have %d health remaining!%n", player.getFullName(),
                player.getWeapon(), player.healthRemaining());

        EnhancedPlayer player2 = new EnhancedPlayer("Sam");
        player2.loseHealth(damage);
        System.out.printf("Player %s's weapon is a %s, and they have %d health remaining!%n", player2.getFullName(),
                player2.getWeapon(), player2.healthRemaining());

    }
}