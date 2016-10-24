package is.ru.tictactoe;

public class Player {
	
	private string name;
	private int wins = 0;
	private int losses = 0;
	private int draws = 0;
	
	public Player(string n) {
		this.name = n;
	}