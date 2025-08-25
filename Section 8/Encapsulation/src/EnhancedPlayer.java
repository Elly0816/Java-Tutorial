public class EnhancedPlayer {

    private String fullName;
    private int healthPercentage;
    private String weapon;

    public EnhancedPlayer(String fullName) {
        this(fullName, 100, "Sword");
    }

    public EnhancedPlayer(String fullName, int health, String weapon) {
        this.fullName = fullName;
        this.healthPercentage = health;
        if (health > 100) {
            this.healthPercentage = 100;
        }
        if (health <= 0) {
            this.healthPercentage = 1;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.healthPercentage -= damage;
        if (this.healthPercentage <= 0) {
            this.healthPercentage = 0;
            System.out.println("The player has been knocked out of the game! ");
        }
    }

    public void restoreHealth(int extraHealth) {
        if (this.healthPercentage + extraHealth > 100) {
            System.out.println("Player restored to full health!");
            this.healthPercentage = 100;
        } else {
            this.healthPercentage += extraHealth;
        }
    }

    public int healthRemaining() {
        return this.healthPercentage;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getWeapon() {
        return this.weapon;
    }
}