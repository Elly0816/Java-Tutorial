public class Player {
    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.health = 0;
            System.out.println("The player has been knocked out of the game! ");
        }
    }

    public void restoreHealth(int extraHealth) {
        if (this.health + extraHealth > 100) {
            System.out.println("Player restored to full health!");
            this.health = 100;
        } else {
            this.health += extraHealth;
        }
    }

    public int healthRemaining() {
        return this.health;
    }
}
