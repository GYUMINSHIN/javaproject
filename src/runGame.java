import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class runGame {
	
	static Board game;
	static int userNum;
	static User[] users;
	public static Thread[] p; 
	
	public void Game() throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		int s;
		
		while(true) {
			System.out.println("Input number of user(1~4):");
			s = scan.nextInt();
			
			if(0 < s && s < 5) {
				userNum = s;
				break;
			}else {
				System.out.println("Out of range!!");
			}
		}
		
		users = new User[userNum];
		System.out.println("Choose your symbol");
		System.out.println("Spade = 0");
		System.out.println("Diamond = 1");
		System.out.println("Heart = 2");
		System.out.println("Club = 3");
		Boolean flag = true;
		for(int i = 0; i < userNum; i++) {
			System.out.println("Choose user " + (i + 1) + "'s symbol:");
			s = scan.nextInt();
			
			if(0 <= s && s < 4) {
				for(int j = 0; j < i; j++) {
					if(users[j].symbol == s) {
						System.out.println("Symbol has already selected!!");
						flag = false;
						i--;
						break;
					}
				}
				if(flag) {
					users[i] = new User(0, s);
				}
			}else {
				System.out.println("Invalid input!!");
				i--;
			}
		}
		
		game = new Board(users, userNum);
		
		while (!game.isFinish())
		{
//			game.printBoard();
			game.moveHorse();
		}
		scan.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		int s;
		
		while(true) {
			System.out.println("Input number of user(1~4):");
			s = scan.nextInt();
			
			if(0 < s && s < 5) {
				userNum = s;
				break;
			}else {
				System.out.println("Out of range!!");
			}
		}
		
		users = new User[userNum];
		p = new Thread[userNum];
		System.out.println("Choose your symbol");
		System.out.println("Spade = 0");
		System.out.println("Diamond = 1");
		System.out.println("Heart = 2");
		System.out.println("Club = 3");
		Boolean flag = true;
		
		try {
			ServerSocket server = new ServerSocket(8040);
			System.out.println("서버시작");
			for(int i = 0 ; i<userNum ; i++) {
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
	}

}
