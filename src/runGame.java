import java.util.Scanner;

public class runGame {
	
	static int userNum;
	static int[] users = new int[4];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int s;
		
		while(true) {
			System.out.println("Input number of user(1~4):");
			s= scan.nextInt();
			
			if(0<s&&s<5) {
				userNum = s;
				break;
			}else {
				System.out.println("Out of range!!");
			}
		}
		System.out.println("Choose your symbol");
		System.out.println("Spade = 1");
		System.out.println("Diamond = 2");
		System.out.println("Heart = 3");
		System.out.println("Club = 4");
		Boolean flag = true;
		for(int i =1;i<userNum+1;i++) {
			System.out.println("Choose user"+i+"'s symbol:");
			s= scan.nextInt();
			
			if(0<s&&s<5) {
				for(int j = 1;j<i+1;j++) {
					if(users[j]==s) {
						System.out.println("Symbol has already selected!!");
						flag = false;
						i--;
						break;
					}
				}
				if(flag) {
					users[i] = s;
				}
			}else {
				System.out.println("Invalid input!!");
			}
		}
	}

}
