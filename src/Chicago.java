
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
		System.out.println("| Spelet Chicago går ut på att byta till sig en så bra     |");
		System.out.println("| poker-hand som möjligt. Du har totalt 3 byten, under     |");
		System.out.println("| varje byte kan du välja att droppa ett eller flera kort. |");
		System.out.println("| Du kan även välja att droppa alla eller inga kort.       |");
		System.out.println("| För att droppa kort, ange bara j för Yes när du blir     |");
		System.out.println("| tillfrågad om du vill droppa kort. Ange sedan kortets    |");
		System.out.println("| position i handen (1-5) och tryck på [Enter]. När du är  |");
		System.out.println("| nöjd med de kort du har slängt väljer du n för Nej för   |");
		System.out.println("| att få de kort som saknas.                               |");
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
			System.out.println("Vill du slänga kort?");
			char answer = TextIO.getlnChar();
			answer = Character.toLowerCase(answer);
			if(answer == 'j' || answer == 'J') {
				System.out.println("");
				System.out.println("Ange positionen för det kort du vill slänga.");
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
