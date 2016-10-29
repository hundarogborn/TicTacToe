package is.ru.tictactoe.webui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Redirect;
import spark.Request;
import spark.Response;
import spark.route.RouteOverview;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;

import is.ru.tictactoe.Engine;

public class WebUI {

    private static final String SESSION_NAME = "username";
    
    public WebUI(int port) {
        port(getHerokuAssignedPort());
    
        // Serve static files from web directory
        staticFileLocation("/static");
        setupRoutes();
    
        // Debug option to see routes at  /debug/routeoverview/
        RouteOverview.enableRouteOverview();
    }

    private void setupRoutes() {

        // Example on session state
        get("/", (request, response) -> {
                // First; see if a user has entered his name
                String name = request.session().attribute(SESSION_NAME);
                if(name == null) {
                    return new ModelAndView(null, "name_form.ftl");
                }

                Engine game = request.session().attribute("game");
                if(game == null) {
                    game = new Engine();
                    request.session().attribute("game", game);
                }

                switch(game.winner()) {
                case PLAYER_1:
                    // Assume that player 1 is human
                    return new ModelAndView(null, "you_won.ftl");
                case PLAYER_2:
                    return new ModelAndView(null, "tie.ftl");
                case STALE_MATE:
                    return new ModelAndView(null, "stalemate.ftl");
                case GAME_IN_PROGRESS:
                    break;
                }

                // Populate the board template
                Map<String, Object> templateParams = new HashMap<>();
                templateParams.put("board", game.getBoard());
                return new ModelAndView(templateParams, "board.ftl");
                
            }, new FreeMarkerEngine());

        post("/entry", (request, response) -> {
                String name = request.queryParams("name");
                if (name != null) {
                    request.session().attribute(SESSION_NAME, name);
                }
                response.redirect("/");
                return null;
            });

        exception(Exception.class, (e, req, res) -> {
                res.body(e.getMessage());
            });
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    
    public static String redirectToGoogle(Request req, Response res) {
        res.redirect("https://www.google.is/#q=tic+tac+toe");
        return "";
    }
}
