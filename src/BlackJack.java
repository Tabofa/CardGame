
public class BlackJack {
	
    int gamesPlayed = 0;     // Number of games user has played.
    int sumOfScores = 0;     // The sum of all the scores from 
                             //      all the games played.
    double averageScore;     // Average score, computed by dividing
                             //      sumOfScores by gamesPlayed.
    boolean playAgain;       // Record user's response when user is 
                             //   asked whether he wants to play 
                             //   another game.
    
    public static void makeGame() {
    	System.out.println("This is the Blackjack game, still under construction.");
    	
    	Deck deck = new Deck();
    	deck.shuffle();
    	Hand player = new Hand();
    	Hand dealer = new Hand();
    	
    	int playerScore = 0;
    	int dealerScore = 0;
    	
    		player.addCard(deck.dealCard()); 
        	dealer.addCard(deck.dealCard()); 
        	player.addCard(deck.dealCard()); 
        	dealer.addCard(deck.dealCard()); 
        	
        	for (int i = 0; i > player.getCardCount(); i++) {
    			System.out.println(player.getCard(i-1) + ". Value: " + player.getCard(i-1).getValue());
    			playerScore += player.getCard(i-1).getValue();
        	}
        	
        	if(playerScore == 21) {
        		System.out.println("OMG, OMG, OMG! JIMMIE! Black jacked!");
        	}
        	System.out.println("Score: " + playerScore);
        	
//        	for (int i = player.getCardCount(); i > 0; i--) {
//    			System.out.println(dealer.getCard(i-1));
//    			dealerScore =+ dealer.getCard(i-1).getValue();
//        	}
    		



    	
    	
    	
//    	System.out.println("You have " + player.getCardCount() + " cards.");
    	
    }

}
