
public class User {
	public int score;
	public int symbol;
	
	public User(int score, int symbol) {
		this.score = score;
		this.symbol = symbol;
	}
	
	public void addScore(int value) {
		this.score += value;
	}
}
