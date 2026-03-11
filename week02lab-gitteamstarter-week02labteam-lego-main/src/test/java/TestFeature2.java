import org.junit.*;
import org.junit.Assert;
import game.*;

public class TestFeature2 {
    private GameCharacter character;
    private GameCharacter enemy;

    @Before
    public void setUp() {
        character = new GameCharacter();
        enemy = new GameCharacter();
    }

    /**
     * Tests attack method.
     * - Ensures that attacking reduces enemy's health.
     */
    @Test
    public void testAttack() {
        int initialEnemyHealth = enemy.getHealth();
        character.attack(enemy);

        Assert.assertTrue("Enemy health should decrease after being attacked.", enemy.getHealth() < initialEnemyHealth);
    }

    /**
     * Tests useSpecialAbility method.
     * - Ensures that the ability has an effect (e.g., increases attack power).
     */
    @Test
    public void testUseSpecialAbility() {
        int initialAttackPower = character.getAttackPower();
        character.useSpecialAbility();

        Assert.assertTrue("Attack power should increase after using special ability.", character.getAttackPower() > initialAttackPower);
    }
}
