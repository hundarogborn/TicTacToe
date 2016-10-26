package is.ru.tictactoe.webui;

import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.port;
import spark.Redirect;
import spark.route.RouteOverview;

// lazy import
import static spark.Spark.*;


public class WebUI {
    public WebUI(int port) {
        port(getHerokuAssignedPort());
	
	// Serve static files from web directory
	staticFileLocation("/static");
        setupRoutes();
	
	// Debug option to see routes at  /debug/routeoverview/
	RouteOverview.enableRouteOverview();
    }

    private void setupRoutes() {
        get("/", (request, response) -> {
		return "Hello player";
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
