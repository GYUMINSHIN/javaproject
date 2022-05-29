
public class User {
	public String name;
	public int score;
	public int symbol;
	
	public User(String name, int score) {
		this.name = name;
		this.score = score;
	}
		
	public void addScore(int value) {
		this.score += value;
	}
}
