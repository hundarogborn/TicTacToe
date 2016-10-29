package is.ru.tictactoe;

import is.ru.tictactoe.webui.WebUI;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            printUsage();
            return;
        }

        if(args[0].equals("web")) {
            int port = 4567;
            if(getEnvValue("PORT") != null) {
                port = Integer.parseInt(getEnvValue("PORT"));
            }
            
            WebUI webui = new WebUI(port);
        } else if(args[0].equals("cli")) {
            Cli cli = new Cli();
            cli.startGame();
        } else {
            printUsage();
            return;
        }
    }

    /* getEnvValue - Return the environment value associated with key;
     * null otherwise
     */
    private static String getEnvValue(String key) {
        ProcessBuilder pb = new ProcessBuilder();
        return pb.environment().get(key);
    }

    private static void printUsage() {
        System.err.printf("Invalid usage.  Expected TicTacToe-all.jar <web / cli>\n");
        System.err.printf("To start TicTacToe as a CLI app: TicTacToe-all.jar cli\n");
        System.err.printf("To start TicTacToe as a web server: TicTacToe-all.jar web\n");
        System.err.printf("When running the application as a web server, you can assign the PORT env variable to set the listener port\n");
    }
}
