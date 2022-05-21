
public class Board extends CardGenerator{
	User[] users;
	Horse[] horses;
	int numOfUsers;
	
	Board(int numOfUsers) {
		this.numOfUsers = numOfUsers;
		horses = new Horse[numOfUsers];
		users = new User[numOfUsers];
	}
	
	boolean isFinish() {
		for (int i = 0; i < numOfUsers; i++) {
			if (horses[i].getPosition() >= 7) {
				return true;
			}
		}
		return false;
	}
	
	void moveHorse(int symbol, int number) {
		int curPosition = horses[symbol].getPosition();
		
		switch(number) {
		case 2:
		case 4:
		case 6:
		case 8:
		case 10:
			horses[symbol].setPosition(curPosition + 1);
			break;
		case 3:
		case 5:
		case 7:
		case 9:
			horses[symbol].setPosition(curPosition - 1);
			break;
		case 11:
			horses[symbol].setPosition(curPosition + 2);
			break;
		case 12:
			horses[symbol].setPosition(curPosition - 2);
			break;
		case 13:
			horses[symbol].setPosition(curPosition + 3);
			break;
		case 1:
			horses[symbol].addBonus();
			break;
		}
	}
	
	void printBoard() {
		
	}
}
