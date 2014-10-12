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
	
//	public Card getCard() {
//
//	}
	
	public void sortBySuit() {
		
	}
	
	public void sortByValue() {
		
	}
}
