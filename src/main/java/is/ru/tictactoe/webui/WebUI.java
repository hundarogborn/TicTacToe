package is.ru.tictactoe.webui;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import spark.ModelAndView;
import spark.Redirect;
import spark.Request;
import spark.Response;
import spark.route.RouteOverview;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;

import is.ru.tictactoe.Game;
import is.ru.tictactoe.Player;
import is.ru.tictactoe.IllegalMoveException;

public class WebUI {

    public WebUI(int port) {
        port(port);
        // Serve static files from web directory
        staticFileLocation("/static");
        setupRoutes();

        // Debug option to see routes at /debug/routeoverview/
        RouteOverview.enableRouteOverview();
    }

    private void setupRoutes() {
        get("/", WebUI::rootGetHandler, new FreeMarkerEngine());
        post("/", WebUI::moveSubmissionHandler);
        get("/new", WebUI::newGameHandler);
        get("/reset", WebUI::resetGameHandler);
        post("/entry", WebUI::entryPostHandler);
        exception(Exception.class, WebUI::exceptionHandler);
    }

    public static Object entryPostHandler(Request request, Response response) {
        String type = request.queryParams("type");
        if (type != null) {
            request.session().attribute("type", type);
            Player player1 = new Player(request.queryParams("player1"));
            Player player2 = new Player(request.queryParams("player2"));
            if (type.equals("pvc")) {
                player2.setHuman(false);
            }
            request.session().attribute("player1", player1);
            request.session().attribute("player2", player2);
        }
        response.redirect("/");
        return null;
    }

    public static ModelAndView rootGetHandler(Request request, Response response) {
        // First; see if a user has entered his name
        String type = request.session().attribute("type");
        if (type == null) {
            return new ModelAndView(null, "name_form.ftl");
        }

        Game game = request.session().attribute("game");
        if (game == null) {
            game = new Game();
            request.session().attribute("game", game);
        }
        
        Player player1 = request.session().attribute("player1");
        Player player2 = request.session().attribute("player2");
        
        String score = "";
        Map<String, Object> templateParams = new HashMap<>();
        switch (game.winner()) {
        case PLAYER_1:
            // Assume that player 1 is human
            player1.addWin();
            score = getScore(game, player1, player2);
            templateParams.put("score", score);
            templateParams.put("message", "CONGRATULATIONS! " + player1.getName() + " YOU WON!");
            return new ModelAndView(templateParams, "game_results.ftl");
        case PLAYER_2:
            player2.addWin();
            score = getScore(game, player1, player2);
            templateParams.put("score", score);
            if (player2.isHuman()) {
                templateParams.put("message", "CONGRATULATIONS! " + player2.getName() + " YOU WON!");
                return new ModelAndView(templateParams, "game_results.ftl");
            } else {
                templateParams.put("message", "SORRY " + player1.getName() + " YOU LOST!");
                return new ModelAndView(templateParams, "game_results.ftl");
            }
        case STALE_MATE:
            score = getScore(game, player1, player2);
            templateParams.put("score", score);
            templateParams.put("message", "Close - but no cigar; this was a tie");
            return new ModelAndView(templateParams, "game_results.ftl");
        case GAME_IN_PROGRESS:
            break;
        }

        // Populate the board template
        templateParams.put("board", game.getBoard());

        // Push player name to template
        // If computer turn - make random move
        String playerName = "";
        if (game.getMoves() % 2 == 0) {
            playerName = player1.getName();
        } else {
            if (!player2.isHuman()) {
                Random ran = new Random();
                // Endless loop - will break out on successful move
                do {
                    int cellNum = ran.nextInt(10);
                    int y = cellNum / game.getBoard().boardSize();
                    int x = cellNum % game.getBoard().boardSize();
                    try {
                        game.makeMove(x, y, 2);
                        response.redirect("/");
                        return null;
                    } catch (IllegalMoveException e) {
                        // do nothing - try again
                    }
                } while (true);
            } else {
                playerName = player2.getName();
            }
        }

        templateParams.put("playerName", playerName);
        return new ModelAndView(templateParams, "board.ftl");
    }

    public static Object moveSubmissionHandler(Request request, Response response) {
        // Handle post; a player played a cell
        Game game = request.session().attribute("game");
        if (game == null) {
            // Player is posting without a game session.
            // Have him sign up.
            response.redirect("/");
            return null;
        }

        // Find the cell played
        if (request.queryParams().size() != 1) {
            halt(400, "Illegal request");
        }

        // Decode the cell number into (y, x) coordinates
        int cellNum = Integer.parseInt(request.queryParams().iterator().next());
        int y = cellNum / game.getBoard().boardSize();
        int x = cellNum % game.getBoard().boardSize();

        // Make the move
        try {
            if (game.getMoves() % 2 == 0) {
                game.makeMove(x, y, 1);
            } else {
                game.makeMove(x, y, 2);
            }
        } catch (IllegalMoveException e) {
            halt(400, "Out of bounds move");
        }

        response.redirect("/");
        return null;
    }

    public static Object resetGameHandler(Request request, Response response) {
        request.session().removeAttribute("game");
        response.redirect("/");

        return null;
    }
    
    
    public static Object newGameHandler(Request request, Response response) {
        request.session().removeAttribute("game");
        request.session().removeAttribute("type");
        request.session().removeAttribute("player1");
        request.session().removeAttribute("player2");
        response.redirect("/");
     
        return null;
    }

    public static void exceptionHandler(Exception e, Request request, Response response) {
        response.body(e.getMessage());
    }
    
    public static String getScore(Game game, Player player1, Player player2) {
        String score = "Game score:<br>";
        score += "Total games played: " + player1.addGamesPlayed() + "<br>";
        score += player1.getName() + " has won " + player1.getWins() + " times!<br>";
        score += player2.getName() + " has won " + player2.getWins() + " times!<br>";
        return score;
    }
}
