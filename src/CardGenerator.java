import java.util.*;

public class CardGenerator{

	static int[] symbol = {1,2,3,4};
	static int[] number = {1,2,3,4,5,6,7,8,9,10,11,12,13};

	public int genSymbol() {
		return (int)((Math.random()*10000)%4+1);
	}
	
	public int genNumber() {
		return (int)((Math.random()*10000)%13+1);
	}
	
	public Card genCard() {
		return new Card(genSymbol(),genNumber());
	}
}
