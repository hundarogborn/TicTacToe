package is.ru.tictactoe.webui;

import spark.Request;
import spark.Response;
import spark.Redirect;
import spark.route.RouteOverview;
import static spark.Spark.*;


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
            String name = request.session().attribute(SESSION_NAME);
            if (name == null) {
                return "<html><body>What's your name?: <form action=\"/entry\" method=\"POST\"><input type=\"text\" name=\"name\"/><input type=\"submit\" value=\"go\"/></form></body></html>";
            } else {
                return String.format("<html><body>Hello, %s!</body></html>", name);
            }
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
