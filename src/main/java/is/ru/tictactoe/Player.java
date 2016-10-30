package is.ru.tictactoe;

public class Player {
	
	public String name;
	private int wins = 0;
	private int gamesPlayed = 0;
	private boolean human = true;
	
	public Player(String n) {
		this.name = n;
	}
	
	public Player(Player p) {
	    this.name = p.name;
	    this.wins = p.wins;
	    this.gamesPlayed = p.gamesPlayed;
	    this.human = p.human;
	}
		
	public String getName(){
		return this.name;
	}
	
	public void setHuman(boolean human){
		this.human = human;
	}
	
	public boolean isHuman() {
		return this.human;
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
