
public class Horse {
	int symbol;
	int position;
	int bonus;
	
	Horse(int symbol) {
		this.symbol = symbol;
		this.position = 0;
		this.bonus = 1;
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
		
		if (position < 0) {
			this.position = 0;
		}
		else if (position > 7) {
			this.position = 7;
		}
	}
	
	void addBonus() {
		bonus++;
	}
}
