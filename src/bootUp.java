
public class bootUp {

	public static void main(String[] args) {
		System.out.println("V�lj det spel du vill spela");
		System.out.println("Ange nummer p� spelet och tryck p� [Enter].");
		System.out.println("1. HighLow");
		System.out.println("2. Black Jack");
		int val = TextIO.getlnInt();
		
		switch (val) {
		case 1: HighLow.makeGame();
			break;
		case 2: BlackJack.makeGame();
			break;
		default: System.out.println("F�L!");
		}
	}

}
