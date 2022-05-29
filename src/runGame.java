import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class runGame {
	
	static Board game;
	static int userNum;
	static User[] users;
	public static PersonalServer[] p; 

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		int s;
		
		while(true) {
			System.out.print("Input number of user(1~4):");
			s = scan.nextInt();
			
			if(0 < s && s < 5) {
				userNum = s;
				break;
			}else {
				System.out.println("Out of range!!");
			}
		}
		
		users = new User[userNum];
		p = new PersonalServer[userNum];

		System.out.print("Choose your Nickname:");
		scan.nextLine();
		String n = scan.nextLine();
		users[0] = new User(n, 0);
		
		try {
			ServerSocket server = new ServerSocket(8040);
			System.out.println("Invite User");
			for(int i = 1 ; i<userNum ; i++) {
				if(server.isClosed()) {
					break;
				}
				Socket socket = server.accept();
				p[i] = new PersonalServer(socket);
				p[i].start();
				System.out.println("서버 접속");
			}
			server.close();
		}catch(IOException e) {
            System.out.println("[server] network error "  + e.toString()); 
        }
		
		int num = 0;
		System.out.println("How many game do you want to play?");
		num = scan.nextInt();
		
		System.out.println("Spade = 0");
		System.out.println("Diamond = 1");
		System.out.println("Heart = 2");
		System.out.println("Club = 3");
		
		for(int i = 1;i<userNum;i++) {
			users[i] = p[i].user;
		}
		System.out.println( users[0].name+" = "+ 0);
		for(int i = 1;i<userNum;i++) {
			p[i].sendToString("s#" + users[i].name + " = " + i);
			p[i].sendToString("n#" + userNum);
		}
		
		for (int i = 0; i < userNum; i++) {
			for (int j = 1; j < userNum; j++) {
				p[j].sendToString("u#" + Integer.toString(i) + "#" + users[i].name);
//				System.out.println("Sent Player #" + i + " to " + p[j].user.name);
			}
		}
		
		game = new Board(users, userNum);
		for (int i = 0; i < num; i++) {
			while (!game.isFinish())
			{
//				game.printBoard();
				game.moveHorse();
			}
			
			game.reset();
		}
		
		for(int i = 1;i<userNum;i++) {
			p[i].sendToString("e");
		}
		
		int winner = 0;
		int winnerNum = 0;
		for (int i = 0; i < userNum; i++) {
			if (users[i].score > users[winner].score) {
				winner = i;
				winnerNum = 1;
			}
			else if (users[i].score == users[winner].score) {
				winnerNum++;
			}
		}
		
		if (winnerNum > 1) {
			System.out.println("Draw!");
		} else {
			System.out.println(users[winner].name + " wins!");
		}
		
		scan.close();
	}

}
