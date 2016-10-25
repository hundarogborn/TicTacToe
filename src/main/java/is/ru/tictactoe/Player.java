package is.ru.tictactoe;

public class Player {
	
	private String name;
	private int wins = 0;
	private int losses = 0;
	private int draws = 0;
	
	public Player(){}
	
	public Player(String n) {
		this.name = n;
	}
	
	public String getName(){
		return Player.name;
	}
	
	public bool setName(String name){
		Player.name = name;
		return true;
	}
	
	public Player(String n) {
		this.name = n;
	}
}
