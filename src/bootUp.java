
public class bootUp {

	public static void main(String[] args) {
		while(true) {
			System.out.println("V�lj det spel du vill spela");
			System.out.println("Ange nummer p� spelet och tryck p� [Enter].");
			System.out.println("1. Chicago");
			System.out.println("2. Black Jack");
			System.out.println("9. Credits");
			int val = TextIO.getlnInt();
			
			switch (val) {
			case 1: Chicago.makeGame();
				break;
			case 2: BlackJack.makeGame();
				break;
			case 9: credits.makeCredits();
				break;
			default: System.out.println("F�L!");
			}
		}
	}
}
