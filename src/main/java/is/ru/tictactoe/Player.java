package is.ru.tictactoe;

public class Player {
	
	public String name;
	private int wins = 0;
	private int gamesPlayed = 0;
	private boolean type = false;
	
	public Player(){}
	
	public Player(String n) {
		this.name = n;
	}	
		
	public String getName(){
		return this.name;
	}
	
	public boolean setName(String name){
		this.name = name;
		return true;
	}
	
	public boolean setHuman(){
		this.type = true;
		return this.type;
	}
	
	public int addWin(){
		return (++this.wins);
	}
	
	public int addGamesPlayed(){
		return (++this.gamesPlayed);
	}
	
	public int getWins(){
		return (this.wins);
	}
	
	public int getGamesPlayed(){
		return (this.gamesPlayed);
	}
}
