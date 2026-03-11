package game;

//This is an example (faulty) class to be used for Week02Lab Exercises 1 and 2
public class GameCharacter {
    private int health;
    private int experience;
    private int level;
    private int attackPower;

    // Constants
    private static final int MAX_HEALTH = 100;
    private static final int EXP_THRESHOLD = 100;

    public GameCharacter() {
        this.health = MAX_HEALTH;
        this.experience = 0;
        this.level = 1;
        this.attackPower = 10;
    }

    /**
     * Increases health by the given amount.
     * Ensures health does not exceed MAX_HEALTH.
     * If the amount is negative or zero, it prints an error message.
     *
     * @param amount the amount of health to restore
     * 
     * dev1 to fix
     */
    public void heal(int amount) {
        if (amount <= 0) {
            System.out.println("Healing amount must be positive.");
            return;
        }
        health += amount;
        if (health > MAX_HEALTH) {
            health = MAX_HEALTH;
        }
        System.out.println("Healed " + amount + " HP. Current health: " + health);
    }

    /**
     * Reduces the character's health by a given damage value.
     * Ensures health does not drop below zero.
     * If damage is negative or zero, it prints an error message.
     *
     * @param damage the amount of damage to take
     * 
     * dev2 to fix
     */
    public void takeDamage(int damage) {
        if (damage <= 0) {
            System.out.println("Damage must be positive.");
            return;
        }
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println("Took " + damage + " damage. Current health: " + health);
    }

    /**
     * Resets the character's stats to the initial values.
     * Health is set to MAX_HEALTH, level to 1, experience to 0, and attack power to 10.
     * 
     * dev3 to fix
     */
    public void reset() {
        experience = 0;
        level = 1;
        health = MAX_HEALTH;
        attackPower = 10;
        System.out.println("Character reset. Health: " + health + ", Level: " + level);
    }

    /**
     * Increases the character's experience points.
     * If the experience reaches the EXP_THRESHOLD, the character levels up.
     * If points are negative or zero, an error message is printed.
     *
     * @param points the amount of experience gained
     */
    public void gainExperience(int points) {
        if (points <= 0) {
            System.out.println("Experience points must be positive.");
            return;
        }
        experience += points;
        System.out.println("Gained " + points + " EXP. Total EXP: " + experience);

        while (experience >= EXP_THRESHOLD) {
            levelUp();
        }
    }

    //Following two methods: to be completed by dev1, and refactored by dev3 (only after dev1 has pushed their changes to main)
    /**
     * Increases the character's level, resets the health to MAX_HEALTH and boosts attack power by 5.
     * Deducts EXP_THRESHOLD from experience each time a level-up occurs.
     *     
     */
    public void levelUp() {
        level += 1;
        attackPower += 5;
        health = MAX_HEALTH;
        experience -= EXP_THRESHOLD;
        System.out.println("Leveled up! New Level: " + level + ", Attack Power: " + attackPower);
    }

    /**
     * Checks if the character is still alive.
     *
     * @return true if health is greater than 0, otherwise false     
     */
    public boolean isAlive() {
    	return health > 0;
    }
    
    //Following two methods: to be completed by dev2, and refactored by dev3 (only after dev2 has pushed their changes to main)
    /**
     * Attacks another game character.
     * Reduces the enemy's health by the attack power.
     * If the enemy is already dead or null, it prints an error message.
     *
     * @param enemy the target character to attack
     * 
     */
    public void attack(GameCharacter enemy) {
        if (enemy == null || !enemy.isAlive()) {
            System.out.println("Enemy is already dead");
        }
        else {
            enemy.takeDamage(attackPower);
        }
    }

    /**
     * Uses a special ability.
     * If health is below 20, restores 20 health points.
     * Otherwise, increases attack power by 10 for temporary boost.
     */
    public void useSpecialAbility() {
        if (health < 20) {
            this.heal(20);
        } else {
            attackPower += 10;
        }
    }

    /**
     * Displays the character's stats including health, level, experience, and attack power.
     */
    public void displayStats() {
        System.out.println("Character Stats - Health: " + health + ", Level: " + level +
                ", Experience: " + experience + ", Attack Power: " + attackPower);
    }

    /**
     * Getter methods 
     * 
     */
    
    public int getHealth() {
    	return health;
    }

	public int getLevel() {
		return level;
	}

	public int getExperience() {	
		return experience;
	}

	public int getAttackPower() {		
		return attackPower;
	}
}
