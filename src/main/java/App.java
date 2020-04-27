import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import util.Render;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFiles.location("/public");
        Map<String, Object> model = new HashMap<>();
        /*Exception Handling*/
        /*404*/
        notFound((request, response) -> {
            return Render.render(model, "404.hbs");
        });

        /*500*/
        internalServerError((request, response) -> {
            return Render.render(model, "500.hbs");
        });

        /*home route*/
        get("/", (request, response) -> {
            model.put("squads", Squad.getSquadInstance());
            model.put("heroes", Hero.getHeroInstance());
            return Render.render(model, "index.hbs");
        });

        /*squad path groups*/
        path("/squad", () -> {
            /*squad members*/
            get("/members/:id", (request, response) -> {
                Squad squadMembers = Squad.findById(Integer.parseInt(request.params("id")));
                model.put("squadMembers", squadMembers);
                return Render.render(model, "squad.hbs");
            });
            /*squad form*/
            post("/form", (request, response) -> {
                String squadName = request.queryParams("squadName");
                int maxSize = Integer.parseInt(request.queryParams("maxSize"));
                String motive = request.queryParams("motive");
                Squad newSquad = new Squad(squadName, maxSize, motive);
                response.redirect("/");
                return null;
            });
        });

        /*heroes path groups*/
        path("/heroes", () -> {
            /*heroes form*/
            post("/form", (request, response) -> {
                String heroName = request.queryParams("heroName");
                int heroAge = Integer.parseInt(request.queryParams("heroAge"));
                String specialAbility = request.queryParams("specialAbility");
                String weakness = request.queryParams("weakness");
                int squad = Integer.parseInt(request.queryParams("squad"));
                Hero newHero = new Hero(heroName, heroAge, specialAbility, weakness, squad);
                Squad newMember = Squad.findById(squad);
                newMember.addHero(newHero);
                response.redirect("/");
                return null;
            });
        });
    }
}