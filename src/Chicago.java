
public class Chicago {
	
	static Hand player = new Hand();
	static Deck deck = new Deck();
	static int changes = 0;
	
	public static void makeGame() {
			play();
	}
	
	public static void play() {
		deck.shuffle();
		dealHand();
		player.sortBySuit();
		showHand();
		
		while(changes < 3) {
			System.out.println("You may replace your cards " + (3 - changes) + " more time(s).");
			dropCards();
			dealHand();
			showHand();
		}
		assassment.assassment(player);
	}
	
	public static void dropCards() {
		while (true) {
			System.out.println("Would you like to drop a card?");
			char answer = TextIO.getlnChar();
			answer = Character.toLowerCase(answer);
			if(answer == 'y') {
				System.out.println("Specify the position of the card you want to drop.");
				int plats = TextIO.getlnChar();
				player.removeCard(player.getCard(plats-49));
				showHand();
			} else if (answer == 'n') {
				changes++;
				break;
			} else if (answer == 'a') {
				player.clear();
			} else {
				System.out.println("Would you like to drop a card?");
			}
		}
	}
	
	public static void showHand() {
		for (int i = 0; i < player.getCardCount(); i++) {
			System.out.println(i+1 + ": " + player.getCard(i));
		}
	}
	
	public static void dealHand() {
		for(int i = player.getCardCount(); i < 5; i++) {
			player.addCard(deck.dealCard());
		}
	}
}
