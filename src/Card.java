
public class Card {
	
	public final static int SPADES = 0;
	public final static int HEARTS = 1;
	public final static int DIAMONDS = 2;
	public final static int CLUBS = 3;
	public final static int JOKER = 4;
	
	public final static int ACE = 1;
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;
	
	private final int suit;
	private final int value;
	
	public Card() {
		suit = JOKER;
		value = 1;
	}
	
	public Card(int theValue, int theSuit) {
		if (theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS && theSuit != CLUBS && theSuit != JOKER)
			throw new IllegalArgumentException("Illegal playingcard suit.");
		if (theSuit != JACK && (theValue < 1 || theValue > 13))
			throw new IllegalArgumentException("Illegal playing card value.");
		value = theValue;
		suit = theSuit;
	}
}
