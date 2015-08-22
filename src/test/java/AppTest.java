import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Submit word"));
    fill("#word").with("trumpet");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved.");
  }

  @Test
  public void wordDefinitionsFormIsDisplayed() {
    goTo("http://localhost:4567/categories/new");
    fill("#name").with("Shopping");
    submit(".btn");
    click("a", withText("View categories"));
    click("a", withText("Shopping"));
    click("a", withText("Add a new task"));
    assertThat(pageSource()).contains("Add a Task to Shopping");
  }

@Test
public void definitionsIsAddedAndDisplayed() {
    goTo("http://localhost:4567/categories/new");
    fill("#name").with("Banking");
    submit(".btn");
    click("a", withText("View categories"));
    click("a", withText("Banking"));
    click("a", withText("Add a new task"));
    fill("#description").with("Deposit paycheck");
    submit(".btn");
    assertThat(pageSource()).contains("Deposit paycheck");
}

// @Test
//   public void wordIsDisplayedTest() {
//     goTo("http://localhost:4567/words/new");
//     fill("#word").with("trumpet");
//     submit(".btn");
//     click("a", withText("View all words"));
//     assertThat(pageSource()).contains("trumpet");
//   }
//
// @Test
//   public void multipleWordsAreDisplayedTest() {
//     goTo("http://localhost:4567/words/new");
//     fill("#word").with("trumpet");
//     submit(".btn");
//     goTo("http://localhost:4567/words/new");
//     fill("#word").with("guitar");
//     submit(".btn");
//     click("a", withText("View all words"));
//     assertThat(pageSource()).contains("trumpet");
//     assertThat(pageSource()).contains("guitar");
//   }
//
// @Test
//   public void wordShowPageDisplaysWord() {
//     goTo("http://localhost:4567/words/new");
//     fill("#word").with("guitar");
//     submit(".btn");
//     click("a", withText("View all words"));
//     click("a", withText("guitar"));
//     assertThat(pageSource()).contains("guitar");
//   }
//
//   @Test
//   public void wordNotFoundMessageShown() {
//     goTo("http://localhost:4567/words/999");
//     assertThat(pageSource()).contains("Word not found");
//   }
  // @Test
  //  public void word_instantiatesWithInputtedWord() {
  //    Word myWord = new Word("trumpet");
  //    assertEquals("trumpet", myWord.getWord());
  //  }

  // @Test
  // public void wordIsCreatedTest() {
  //   goTo("http://localhost:4567/");
  //   fill("#word").with("trumpet");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("trumpet");
  // }
  //
  // @Test
  // public void wordIsDisplayedTest() {
  //   goTo("http://localhost:4567/");
  //   fill("#word").with("trumpet");
  //   submit(".btn");
  //   click("a", withText("Return to home page"));
  //   assertThat(pageSource()).contains("trumpet");
  // }

  // @Test
  // public void multipleWordsAreDisplayedTest() {
  //   goTo("http://localhost:4567/");
  //   fill("#word").with("trumpet");
  //   submit(".btn");
  //   click("a", withText("Return to home page"));
  //   fill("#description").with("guitar");
  //   submit(".btn");
  //   click("a", withText("Return to home page"));
  //   assertThat(pageSource()).contains("trumpet");
  //   assertThat(pageSource()).contains("guitar");
  // }






}
