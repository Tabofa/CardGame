
public class Chicago {
	
	static Hand player = new Hand();
	static Deck deck = new Deck();
	static int changes = 0;
	
	public static void makeGame() {
		regler();
		play();
	}
	
	private static void regler() {
		System.out.println("");
		System.out.println("+----------------------------------------------------------+");
		System.out.println("| Spelet Chicago g�r ut p� att byta till sig en s� bra     |");
		System.out.println("| poker-hand som m�jligt. Du har totalt 3 byten, under     |");
		System.out.println("| varje byte kan du v�lja att droppa ett eller flera kort. |");
		System.out.println("| Du kan �ven v�lja att droppa alla eller inga kort.       |");
		System.out.println("| F�r att droppa kort, ange bara j f�r Yes n�r du blir     |");
		System.out.println("| tillfr�gad om du vill droppa kort. Ange sedan kortets    |");
		System.out.println("| position i handen (1-5) och tryck p� [Enter]. N�r du �r  |");
		System.out.println("| n�jd med de kort du har sl�ngt v�ljer du n f�r Nej f�r   |");
		System.out.println("| att f� de kort som saknas.                               |");
		System.out.println("+----------------------------------------------------------+");
		System.out.println("");
	}

	public static void play() {
		deck.shuffle();
		dealHand();
		player.sortBySuit();
		showHand();
		
		while(changes < 3) {
			System.out.println("Du har " + (3 - changes) + " byte(n) kvar.");
			dropCards();
			dealHand();
			showHand();
		}
		ChicagoAssassment.assassment(player);
	}
	
	public static void dropCards() {
		while (true) {
			System.out.println("Vill du sl�nga kort?");
			char answer = TextIO.getlnChar();
			answer = Character.toLowerCase(answer);
			if(answer == 'j' || answer == 'J') {
				System.out.println("");
				System.out.println("Ange positionen f�r det kort du vill sl�nga.");
				int plats = TextIO.getlnChar();
				player.removeCard(player.getCard(plats-49));
				showHand();
			} else if (answer == 'n' || answer == 'N') {
				changes++;
				break;
			} else if (answer == 'a' || answer == 'A') {
				player.clear();
				changes++;
				break;
			} 
		}
	}
	
	public static void showHand() {
		System.out.println("");
		for (int i = 0; i < player.getCardCount(); i++) {
			System.out.println(i+1 + ": " + player.getCard(i));
		}
		System.out.println("");
	}
	
	public static void dealHand() {
		for(int i = player.getCardCount(); i < 5; i++) {
			player.addCard(deck.dealCard());
		}
	}
}
