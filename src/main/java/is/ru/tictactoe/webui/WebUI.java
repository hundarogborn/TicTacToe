package is.ru.tictactoe.webui;

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

                Map<String, Object> templateParams = new HashMap<>();
                switch(game.winner()) {
                case PLAYER_1:
                    // Assume that player 1 is human
                    templateParams.put("message", "CONGRATULATIONS!  YOU WON!");
                    return new ModelAndView(templateParams, "game_results.ftl");
                case PLAYER_2:
                    templateParams.put("message", "YOU LOST! :-(");
                    return new ModelAndView(templateParams, "game_results.ftl");
                case STALE_MATE:
                    templateParams.put("message", "Close - but no cigar; this was a tie");
                    return new ModelAndView(templateParams, "game_results.ftl");
                case GAME_IN_PROGRESS:
                    break;
                }

                // Populate the board template
                templateParams.put("board", game.getBoard());
                return new ModelAndView(templateParams, "board.ftl");
                
            }, new FreeMarkerEngine());

        // Handle post; a player played a cell
        post("/", (request, response) -> {
                Engine game = request.session().attribute("game");
                if(game == null) {
                    // Player is posting without a game session.
                    // Have him sign up.
                    response.redirect("/");
                    return null;
                }

                // Find the cell played
                if(request.queryParams().size() != 1) {
                    // Illegal request
                    halt(400, "Illegal request");
                }

                // Decode the cell number into (y, x) coordinates
                int cellNum = Integer.parseInt(request.queryParams().iterator().next());
                int y = cellNum / game.getBoard().boardSize();
                int x = cellNum % game.getBoard().boardSize();

                // Make the move
                game.makeMove(x, y, 1);
                
                response.redirect("/");
                return null;
            });
        
        
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
