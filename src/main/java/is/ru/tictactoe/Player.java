package is.ru.tictactoe;

public class Player {
	
	private String name;
	private int wins = 0;
	private int losses = 0;
	private int draws = 0;
	
	public Player(){}
	
	
	public String getName(){
		return this.name;
	}
	
	public boolean setName(String name){
		this.name = name;
		return true;
	}
	
	public Player(String n) {
		this.name = n;
	}
}
