package is.ru.tictactoe.webui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Base64;

import spark.Request;
import spark.Response;
import spark.Redirect;
import spark.route.RouteOverview;
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
                    return "<html><body>What's your name?: <form action=\"/entry\" method=\"POST\"><input type=\"text\" name=\"name\"/><input type=\"submit\" value=\"go\"/></form></body></html>";
                }
                
                Engine game;
                String serializedGame = request.cookie("game");
                if(serializedGame == null) {
                    System.out.println("Creating a new game");
                    game = new Engine();
                } else {
                    System.out.println("Deserializing a game");
                    game = deserialize(serializedGame);
                }

                switch(game.winner()) {
                case PLAYER_1:
                    // Assume that player 1 is human
                    return "<html><body><h1>CONGRATULATIONS!  YOU WON!!!!!!!111</h1></body></html>";
                case PLAYER_2:
                    return "<html><body><h1>You lost :( - Soon, the machines will take over</h1></body></html>";
                case STALE_MATE:
                    return "<html><body><h1>Stalemate!  Phew; maybe there's hope</h1></body></html>";
                case GAME_IN_PROGRESS:
                    break;
                }

                // TODO: Render board
                
                // Game must be in progress.  Prompt for a move and update the game state.
                response.cookie("game", serialize(game));
                
                return "woah";
            });

        post("/entry", (request, response) -> {
                String name = request.queryParams("name");
                if (name != null) {
                    request.session().attribute(SESSION_NAME, name);
                }
                response.redirect("/");
                return null;
            });

        post("/", (request, response) -> {
                return "Hello post";
            });
    }

    /* deserialize - Deserialize the base64-encoded, serialiszed engine 
     * from serializedGame 
     */
    private static Engine deserialize(String serializedGame) throws IOException, ClassNotFoundException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(serializedGame.getBytes());
        InputStream decodedInputStream = Base64.getDecoder().wrap(inputStream);
        ObjectInputStream oos = new ObjectInputStream(decodedInputStream);

        return (Engine)oos.readObject();
    }

    /* serialize - Serialize game; base64-encode as string 
     */
    private static String serialize(Engine game) throws IOException {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream objectStream = new ObjectOutputStream(bos)) {
            objectStream.writeObject(game);
            
            return Base64.getEncoder().encodeToString(bos.toByteArray());
        }
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
