
public class Horse {
	int symbol;
	int position;
	int bonus;
	
	Horse(int symbol) {
		this.symbol = symbol;
		this.position = 0;
		this.bonus = 0;
	}
	
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
