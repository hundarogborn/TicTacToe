package is.ru.tictactoe.webui;

import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.port;
import spark.Redirect;

public class WebUI {
    public WebUI(int port) {
        port(getHerokuAssignedPort());
        setupRoutes();
    }

    private void setupRoutes() {
        get("/", WebUI::redirectToGoogle);
        
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
