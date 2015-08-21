import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
    	staticFileLocation("/public");
    	String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("words", request.session().attribute("words"));
        model.put("template", "templates/home.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/words", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("words", Word.all());
        model.put("template", "templates/words.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      //where user fills out a form that posts out our words route below
      get("words/new", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/word-form.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/words", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        String word = (request.queryParams("word"));
        Word myWord = new Word(word);
        //ArrayList<Word> words = request.session().attribute("words");
        //   if (words == null) {
        //     words = new ArrayList<Word>();
        //     request.session().attribute("words", words);
        // }
        //words.add(myWord);
        model.put("template", "templates/success.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/words/:id", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();

        Word word = Word.find(Integer.parseInt(request.params(":id")));
        model.put("word", word);
        model.put("template", "templates/word.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());





    }
}
