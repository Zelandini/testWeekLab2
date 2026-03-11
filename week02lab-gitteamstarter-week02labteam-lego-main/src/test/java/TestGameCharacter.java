import org.junit.*;
import org.junit.Assert;
import game.*;

/**
 * Test class for GameCharacter class
 * 
 * @author [YourName]
 * @version [Current Date]
 *
 */

public class TestGameCharacter {
    private GameCharacter character;

    @Before
    public void setUp() {
        character = new GameCharacter(); // Create a fresh instance before each test
    }

    /**
     * Tests the heal method.
     * - Heals character by a positive amount.
     * - Ensures health does not exceed MAX_HEALTH.
     */
    @Test
    public void testHeal() {
        character.takeDamage(50); // Reduce health to 50
        character.heal(30); // Heal by 30
        Assert.assertEquals(80, character.getHealth());

        character.heal(50); // Heal beyond max limit
        Assert.assertEquals(100, character.getHealth());
    }

    /**
     * Tests the takeDamage method.
     * - Reduces health correctly.
     * - Ensures health does not drop below zero.
     */
    @Test
    public void testTakeDamage() {
        character.takeDamage(40);
        Assert.assertEquals(60, character.getHealth());

        character.takeDamage(70); // Exceeds remaining health
        Assert.assertEquals(0, character.getHealth());
    }

    /**
     * Tests the reset method.
     * - Ensures health, level, experience, and attackPower are reset.
     */
    @Test
    public void testReset() {
        character.takeDamage(50);
        character.gainExperience(150);
        character.reset();
        
        Assert.assertEquals(100, character.getHealth());
        Assert.assertEquals(1, character.getLevel());
        Assert.assertEquals(0, character.getExperience());
        Assert.assertEquals(10, character.getAttackPower());
    }

    /**
     * Tests the gainExperience method.
     * - Increases experience correctly.
     * - Levels up when threshold is exceeded.
     */
    @Test
    public void testGainExperience() {
        character.gainExperience(50);
        Assert.assertEquals(50, character.getExperience());

        character.gainExperience(60); // Exceeds threshold (100), should level up
        Assert.assertEquals(10, character.getExperience());
        Assert.assertEquals(2, character.getLevel());
        Assert.assertEquals(15, character.getAttackPower());
    }
}
