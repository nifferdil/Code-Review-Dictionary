import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

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

  @Test
    public void getId_returnsWordId() {
    Word testWord = new Word("trumpet");
    assertTrue(Word.all().size() == testWord.getId());
  }

    @Test
    public void getDefinitions_ReturnsEmptyArrayListCorrectly() {
      Word testWord = new Word("trumpet");
      assertTrue(testWord.getDefinitions() instanceof ArrayList);
    }

    @Test
    public void all_returnsAllInstancesOfDefinitions_true() {
      Word word1 = new Word("trumpet");
      Word word2 = new Word("guitar");
      assertTrue(Word.all().contains(word1));
      assertTrue(Word.all().contains(word2));
    }

    @Test
    public void clear_removesAllWordInstancesFromCache() {
      Word testWord = new Word("trumpet");
      Word.clear();
      assertEquals(Word.all().size(), 0);
    }

    @Test
    public void find_returnsWordWithSameId() {
      Word testWord = new Word("trumpet");
      assertEquals(Word.find(testWord.getId()), testWord);
    }

    @Test
    public void addDefinition_addsDefToList() {
      Word testWord = new Word("trumpet");
      Definition testDef = new Definition("an instrument");
      testWord.addDefinition(testDef);
      assertTrue(testWord.getDefinitions().contains(testDef));
    }
}
