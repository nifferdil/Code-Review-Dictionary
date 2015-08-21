import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

  //public ClearRule clearRule = new ClearRule();

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void newWord_instantiatesCorrectly_true() {
    Word testWord = new Word("trumpet");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void Word_getsUserInputtedWord_trumpet() {
    Word testWord = new Word("trumpet");
    assertEquals("trumpet", testWord.getWord());
  }
}
