import java.time.LocalDateTime;
import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

	@ClassRule
	public static ServerRule server = new ServerRule();

	@Rule
	public ClearRule clearRule = new ClearRule();

	// @Test
	// public void volume_determinesTheVolumeOfTheCube_27000() {
  //   Rectangle testRectangle = new Rectangle(30, 30);
  //   Cube testCube = new Cube(testRectangle);
  //   assertEquals(27000, testCube.volume());
  // }

}
