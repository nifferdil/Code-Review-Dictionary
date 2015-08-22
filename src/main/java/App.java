import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
    	String layout = "templates/layout.vtl";

      get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("words", Word.all());
        model.put("template", "templates/home.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      // get("/words", (request, response) -> {
      //   HashMap<String, Object> model = new HashMap<String, Object>();
      //   model.put("words", Word.all());
      //   model.put("template", "templates/words.vtl");
      //   return new ModelAndView(model, layout);
      // }, new VelocityTemplateEngine());

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
        model.put("word", myWord);
        model.put("template", "templates/success.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/words/:id", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        Definition definition = Definition.find(Integer.parseInt(request.params(":id")));
        //Word word = Word.find(Integer.parseInt(request.params(":id")));
        model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
        model.put("template", "templates/definition.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/words/:id/definition/new", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
        model.put("template", "templates/word-definitions-form.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());


      post("/definitions", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        Word newWord = Word.find(Integer.parseInt(request.queryParams("definitionId")));
        String definition = request.queryParams("definition");
        Definition newDefinition = new Definition(definition);
        newWord.addDefinition(newDefinition);
        model.put("definition", definition);
        model.put("word", newWord);
        model.put("template", "templates/success.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
    }
}
