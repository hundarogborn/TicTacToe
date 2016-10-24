package is.ru.tictactoe;

public class Player {
	
	private String name;
	private int wins = 0;
	private int losses = 0;
	private int draws = 0;
	
	public Player(String n) {
		this.name = n;
	}
}
