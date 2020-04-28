import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        ProcessBuilder process = new ProcessBuilder();
        Integer port;

        // This tells our app that if Heroku sets a port for us, we need to use that port.
        // Otherwise, if they do not, continue using port 4567.

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 8080;
        }

        port(port);
        staticFileLocation("/public");

        get("/",(request, response) -> {
            Map<String, ArrayList<Hero>> model = new HashMap<>();
            ArrayList heroes =  Hero.getHeroes();
            model.put("heroes", heroes);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/success", (request, response) -> {
            Map<String, ArrayList<Hero>> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String specialPower = request.queryParams("powers");
            String weakness = request.queryParams("weakness");
            String squad = request.queryParams("squad");
            Hero heroes = new Hero(name,age,specialPower,weakness,squad);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int id = Integer.parseInt(request.params(":id"));
            ArrayList heroes = Hero.getHeroes();
            model.put("heroes",heroes);
            Hero heroFound = Hero.findById(id);
            model.put("heroFound",heroFound);
            return new ModelAndView(model, "add_to_squad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/squad-created", (request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String name = request.queryParams("name");
            String motive = request.queryParams("motive");
            int maxSize = Integer.parseInt(request.queryParams("size"));
            Squad squad = new Squad(name, motive, maxSize);
            return new ModelAndView(model, "squad-success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList squads = Squad.getSquads();
            ArrayList heroes = Hero.getHeroes();
            int size = heroes.size();
            model.put("squads", squads);
            model.put("heroes", heroes);
            model.put("size",size);
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());


    }
}
