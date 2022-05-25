import java.net.SocketAddress;

public class User {
	public String name;
	public int score;
	public int symbol;
	public SocketAddress adress;
	
	public User(int score, int symbol) {
		this.score = score;
		this.symbol = symbol;
	}
		
	public void addScore(int value) {
		this.score += value;
	}
}
