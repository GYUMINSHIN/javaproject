import java.util.*;

public class CardGenerator{
	public int genSymbol() {
		return (int)((Math.random() * 10000) % 4);
	}
	
	public int genNumber() {
		return (int)((Math.random() * 10000) % 13 + 1);
	}
	
	public Card genCard() {
		return new Card(genSymbol(), genNumber());
	}
}
