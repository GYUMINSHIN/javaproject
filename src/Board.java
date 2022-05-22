
public class Board extends GUI{
	User[] users;
	Horse[] horses;
	CardGenerator cg;
	int userNum;
	
	Board(User[] users, int userNum) throws InterruptedException {
		this.users = users;
		this.userNum = userNum;
		horses = new Horse[userNum];
		cg = new CardGenerator();
		
		for (int i = 0; i < userNum; i++)
		{
			horses[i] = new Horse(i);
		}
	}
	
	boolean isFinish() {
		for (int i = 0; i < userNum; i++) {
			if (horses[i].getPosition() >= 7) {
				return true;
			}
		}
		return false;
	}
	
	void moveHorse() throws InterruptedException {
		Card card = cg.genCard();
		int curPosition = horses[card.symbol].getPosition();
		
		switch(card.number) {
		case 2:
		case 4:
		case 6:
		case 8:
		case 10:
			horses[card.symbol].setPosition(curPosition + 1);
			break;
		case 3:
		case 5:
		case 7:
		case 9:
			horses[card.symbol].setPosition(curPosition - 1);
			break;
		case 11:
			horses[card.symbol].setPosition(curPosition + 2);
			break;
		case 12:
			horses[card.symbol].setPosition(curPosition - 2);
			break;
		case 13:
			horses[card.symbol].setPosition(curPosition + 3);
			break;
		case 1:
			horses[card.symbol].addBonus();
			break;
		}
		
		if (horses[card.symbol].getPosition() < 0) {
			horses[card.symbol].setPosition(0);
		}
		else if (horses[card.symbol].getPosition() > 7) {
			horses[card.symbol].setPosition(7);
		}
		updateScreen(card.symbol, horses[card.symbol].getPosition());
	}
}
