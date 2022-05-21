
public class Horse {
	private int symbol;
	private int position;
	private int bonus = 0;
	
	int getSymbol() {
		return symbol;
	}
	
	int getPosition() {
		return position;
	}
	
	int getBonus() {
		return bonus;
	}
	
	void setSymbol(int symbol) {
		this.symbol = symbol;
	}
	
	void setPosition(int position) {
		this.position = position;
	}
	
	void addBonus() {
		bonus++;
	}
}
