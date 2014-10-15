import java.util.ArrayList;

//BlackJackCard
public class BlackJackHand {
	
	private ArrayList<BlackJackCard> hand;
	
	public BlackJackHand() {
		hand = new ArrayList<BlackJackCard>();
	}
	
	public void clear() {
		hand.clear();
	}
	
	public void addCard(BlackJackCard cardName) {
		if(cardName == null)
			throw new NullPointerException("Can't add null card to hand.");
		hand.add(cardName);
	}
	
	public void removeCard(BlackJackCard cardName) {
		hand.remove(cardName);
	}
	
	public void removeCard(int cardPosition) {
		if(cardPosition < 0 || cardPosition >= hand.size())
			throw new IllegalArgumentException("Position does not exsist in hand: " + cardPosition);
		hand.remove(cardPosition);
	}
	
	public int getCardCount() {
		return hand.size();
	}
	
	public BlackJackCard getCard(int position) {
		if(position < 0 || position >= hand.size())
			throw new IllegalArgumentException("Position does not exist in hand: " 	
					+ position);
		return hand.get(position);
	}
	
	public void sortBySuit() {
		ArrayList<BlackJackCard> newHand = new ArrayList<BlackJackCard>();
		while(hand.size() > 0) {
			int pos = 0;
			BlackJackCard c = hand.get(0);
			for (int i = 1; i < hand.size(); i++) {
				BlackJackCard c1 = hand.get(i);
				if(c1.getSuit() < c.getSuit() || (
						c1.getSuit() == c.getSuit() && c1.getSuit() < c.getSuit())) {
					pos = i;
					c = c1;
				}
			}
			hand.remove(pos);
			newHand.add(c);
		}
		hand = newHand;
	}
	
	public void sortByValue() {
		ArrayList<BlackJackCard> newHand = new ArrayList<BlackJackCard>();
		while( hand.size() > 0 ) {
			int pos = 0;
			BlackJackCard c = hand.get(0);
			for (int i = 1; i < hand.size(); i++) {
				BlackJackCard c1 = hand.get(i);
				if ( c1.getValue() < c.getValue() ||
						(c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit())) {
					pos = i;
					c = c1;
				}
			}
			hand.remove(pos);
			newHand.add(c);
		}
		hand = newHand;
		
	}
}
