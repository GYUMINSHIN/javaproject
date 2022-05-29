
public class Board{
	GUI gui;
	User[] users;
	Horse[] horses;
	CardGenerator cg;
	int userNum;
	
	Board(User[] users, int userNum) {
		this.gui = new GUI(users, userNum);
		this.users = users;
		this.userNum = userNum;
		horses = new Horse[4];
		cg = new CardGenerator();
		
		for (int i = 0; i < 4; i++)
		{
			horses[i] = new Horse(i);
		}
	}
	
	public boolean isFinish() {
		for (int i = 0; i < userNum; i++) {
			if (horses[i].getPosition() >= 7) {
				int score = (int) Math.pow(2, horses[i].getBonus());
				System.out.println(users[i].name + " gets " + score + " points!");
				users[i].addScore(score);
				for (int j = 1; j < userNum; j++) {
//					System.out.println(i + " " + j + " " + userNum);
					runGame.p[j].sendToString("w#" + i + "#" + users[i].score);
				}
				return true;
			}
		}
		return false;
	}
	
	public void moveHorse() throws InterruptedException {
		Card card = cg.genCard();
		gui.showCard(card);
		int curPosition = horses[card.symbol].getPosition();
		for (int i = 1; i < userNum; i++) {
			runGame.p[i].sendToString("c#" + card.toString());
		}
		Thread.sleep(50);
		
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
		
		gui.updateScreen(card.symbol, curPosition, horses[card.symbol].getPosition());
		for (int i = 1; i < userNum; i++) {
			runGame.p[i].sendToString("h#" + card.symbol + "#" + curPosition + "#" + horses[card.symbol].getPosition());
		}
	}
	
	public void reset() {
		for (int i = 0; i < 4; i++) {
			horses[i].setPosition(0);
			horses[i].bonus = 1;
		}
		
		gui.reset();
	}
}
