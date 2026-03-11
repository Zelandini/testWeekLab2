import org.junit.*;
import org.junit.Assert;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import game.*;

public class TestFeature3 {
    private GameCharacter character;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        character = new GameCharacter();
        System.setOut(new PrintStream(outputStream)); // Redirect System.out for testing
    }

    /**
     * Tests displayStats method.
     * - Ensures that stats are printed correctly.
     */
    @Test
    public void testDisplayStats() {
        character.displayStats();
        String output = outputStream.toString().trim();

        Assert.assertTrue("Output should include Level.", output.contains("Level"));
        Assert.assertTrue("Output should include Health.", output.contains("Health"));
        Assert.assertTrue("Output should include Attack Power.", output.contains("Attack Power"));
    }
}
