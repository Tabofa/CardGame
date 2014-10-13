import java.util.ArrayList;


public class Hand {
	
	private ArrayList<Card> hand;
	
	public Hand() {
		hand = new ArrayList<Card>();
	}
	
	public void clear() {
		hand.clear();
	}
	
	public void addCard(Card cardName) {
		if(cardName == null)
			throw new NullPointerException("Can't add null card to hand.");
		hand.add(cardName);
	}
	
	public void removeCard(Card cardName) {
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
	
	public Card getCard(int position) {
		if(position < 0 || position >= hand.size())
			throw new IllegalArgumentException("Position does not exist in hand: " 	
					+ position);
		return hand.get(position);
	}
	
	public void sortBySuit() {
		ArrayList<Card> newHand = new ArrayList<Card>();
		while(hand.size() > 0) {
			int pos = 0;
			Card c = hand.get(0);
			for (int i = 1; i < hand.size(); i++) {
				Card c1 = hand.get(i);
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
		ArrayList<Card> newHand = new ArrayList<Card>();
		while( hand.size() > 0 ) {
			int pos = 0;
			Card c = hand.get(0);
			for (int i = 1; i < hand.size(); i++) {
				Card c1 = hand.get(i);
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
