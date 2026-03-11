import org.junit.*;
import org.junit.Assert;
import game.*;

public class TestFeature1 {
    private GameCharacter character;

    @Before
    public void setUp() {
        character = new GameCharacter();
    }

    /**
     * Tests levelUp method.
     * - Ensures that leveling up increases level and stats.
     */
    @Test
    public void testLevelUp() {
        int initialLevel = character.getLevel();
        int initialHealth = character.getHealth();
        int initialAttackPower = character.getAttackPower();

        character.levelUp();

        Assert.assertEquals("Level should increase by 1.", initialLevel + 1, character.getLevel());
        Assert.assertTrue("Health should increase after leveling up.", character.getHealth() >= initialHealth);
        Assert.assertTrue("Attack power should increase after leveling up.", character.getAttackPower() > initialAttackPower);
    }

    /**
     * Tests isAlive method.
     * - Ensures the method correctly identifies if the character is alive.
     */
    @Test
    public void testIsAlive() {
        Assert.assertTrue("Character should be alive initially.", character.isAlive());

        character.takeDamage(9999); // Assume this is enough to deplete health

        Assert.assertFalse("Character should be dead after taking fatal damage.", character.isAlive());
    }
}
