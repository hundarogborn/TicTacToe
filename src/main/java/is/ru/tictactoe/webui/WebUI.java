package is.ru.tictactoe.webui;

import spark.Request;
import spark.Response;
import static spark.Spark.get;
import static spark.Spark.port;
import spark.Redirect;

public class WebUI {
    public WebUI(int port) {
        port(port);
        setupRoutes();
    }

    private void setupRoutes() {
        get("/", WebUI::redirectToGoogle);
        
    }
    
    public static String redirectToGoogle(Request req, Response res) {
        res.redirect("https://www.google.is/#q=tic+tac+toe");
        return "";
    }
}
