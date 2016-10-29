package is.ru.tictactoe;

import is.ru.tictactoe.webui.WebUI;

public class Main {
    public static void main(String[] args) {
//        WebUI webui = new WebUI(1234);
	Cli cli = new Cli();
	cli.startGame();
    }
}
