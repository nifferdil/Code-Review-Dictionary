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
    goTo("http://localhost:4567/words/new");
    fill("#word").with("trumpet");
    submit(".btn");
    assertThat(pageSource()).contains("Success!");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("trumpet");
    submit(".btn");
    click("a", withText("View all words"));
    assertThat(pageSource()).contains("trumpet");
  }

  @Test
  public void definitionIsAddedAndDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("trumpet");
    submit(".btn");
    goTo("http://localhost:4567/words/1/definitions/new");
    fill("#definition").with("musical instrument");
    submit(".btn");
    assertThat(pageSource()).contains("musical instrument");
  }

  @Test
  public void multipleWordsAreDisplayedTest() {
    goTo("http://localhost:4567/words/new");
    fill("#word").with("trumpet");
    submit(".btn");
    goTo("http://localhost:4567/words/new");
    fill("#word").with("guitar");
    submit(".btn");
    click("a", withText("View all words"));
    assertThat(pageSource()).contains("trumpet");
    assertThat(pageSource()).contains("guitar");
  }
}
