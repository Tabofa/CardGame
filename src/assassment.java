
public class assassment {
	
	public static void assassment(Hand hand) {
		while (true) {
			if(royalFlush(hand)) {
				System.out.println("Royal Straight Flush!!");
				break;
			}
//			if(royalStraight(hand)) {
//				System.out.println("Royal Straight!");
//				break;
//			}
			if(straightFlush(hand)) {
				System.out.println("Stright Flush!");
				break;
			}
			if(fourOfaKind(hand)) {
				System.out.println("Wow! Four of a kind!");
				break;
			}
			if(fullHouse(hand)) {
				System.out.println("Full house!");
				break;
			}
			if(flush(hand)) {
				System.out.println("Flush!");
				break;
			}
			if(straight(hand)) {
				System.out.println("Straight!");
				break;
			}
			if(threeOfaKind(hand)) {
				System.out.println("Three of a kind!");
				break;
			}
			if(twoPairs(hand)) {
				System.out.println("Two Pairs!");
				break;
			}
			if(onePair(hand)) {
				System.out.println("One pair!");
				break;
			}
			System.out.println("Too bad, better luck next time!");
		}
		
	}
	
	// Royal Flush contains 10-14 in the same suit
	public static boolean royalFlush(Hand hand) {
		if(flush(hand) && 
				(
				(hand.getCard(1).getValue() == hand.getCard(1).getValue()+1) &&
				(hand.getCard(1).getValue() == hand.getCard(1).getValue()+2) &&
				(hand.getCard(1).getValue() == hand.getCard(1).getValue()+3) &&
				(hand.getCard(0).getValueAsString() == "Ace")
				)
				)
		{
			return true;
		} else {
			return false;
		}
	}
	
	// Royal Flush contains 10-14 in the same suit 
	public static boolean royalStraight(Hand hand) {
		if(
				(hand.getCard(1).getValue() == hand.getCard(1).getValue()+1) &&
				(hand.getCard(1).getValue() == hand.getCard(1).getValue()+2) &&
				(hand.getCard(1).getValue() == hand.getCard(1).getValue()+3) &&
				(hand.getCard(0).getValueAsString() == "Ace")
				)
		{
			return true;
		} else {
			return false;
		}
	}
	
	// Straight flush have all five cards in sequence and the same suit
	public static boolean straightFlush(Hand hand) {
		if(flush(hand) && straight(hand)) {
			return true;
		} else {
			return false;
		}
	}
	
	// four cards that have the same value
	public static boolean fourOfaKind(Hand hand) {
		hand.sortByValue();
		if	((
				(hand.getCard(0).getValue() == hand.getCard(1).getValue()) &&
				(hand.getCard(0).getValue() == hand.getCard(2).getValue()) &&
				(hand.getCard(0).getValue() == hand.getCard(3).getValue())
			) 
			|| 
			(
				(hand.getCard(4).getValue() == hand.getCard(1).getValue()) &&
				(hand.getCard(4).getValue() == hand.getCard(2).getValue()) &&
				(hand.getCard(4).getValue() == hand.getCard(3).getValue())
			))					
				{
			return true;
				} else {
					return false;
				}
	}
	
	// three cards that has the same value + two cards with the same value
	public static boolean fullHouse(Hand hand) {
		hand.sortByValue();
		if(
				((hand.getCard(0).getValue() == hand.getCard(1).getValue()) &&
				(hand.getCard(0).getValue() == hand.getCard(2).getValue())) &&
				(hand.getCard(3).getValue() == hand.getCard(4).getValue()
				)
			||
				(
				((hand.getCard(4).getValue() == hand.getCard(3).getValue()) &&
				(hand.getCard(4).getValue() == hand.getCard(2).getValue())) &&
				(hand.getCard(0).getValue() == hand.getCard(1).getValue())	
				)
			) {
			return true;
		} else {
			return false;
		}
	}
	
	// call cards follow the same suit
	public static boolean flush(Hand hand) {
		if(
				(hand.getCard(0).getSuit() == hand.getCard(1).getSuit()) &&
				(hand.getCard(0).getSuit() == hand.getCard(2).getSuit()) &&
				(hand.getCard(0).getSuit() == hand.getCard(3).getSuit()) &&
				(hand.getCard(0).getSuit() == hand.getCard(4).getSuit())
				) {
			return true;
		} else {
			return false;
		}
	}
	
	// All cards are in sequence
	public static boolean straight(Hand hand) {
		hand.sortByValue();
		if(
				(hand.getCard(0).getValue() == hand.getCard(1).getValue()-1) &&
				(hand.getCard(0).getValue() == hand.getCard(2).getValue()-2) &&
				(hand.getCard(0).getValue() == hand.getCard(3).getValue()-3) &&
				(hand.getCard(0).getValue() == hand.getCard(4).getValue()-4)
				) {
			return true;
		} else {
			return false;
		}
	}
	
	// three of the cards have the same value
	public static boolean threeOfaKind(Hand hand) {
		hand.sortByValue();
		if(
				(hand.getCard(0).getValue() == hand.getCard(1).getValue()) && 
				(hand.getCard(0).getValue() == hand.getCard(2).getValue()) ||
				
				(hand.getCard(1).getValue() == hand.getCard(2).getValue()) && 
				(hand.getCard(1).getValue() == hand.getCard(3).getValue()) ||
				
				(hand.getCard(2).getValue() == hand.getCard(3).getValue()) && 
				(hand.getCard(2).getValue() == hand.getCard(4).getValue())
				) {
			return true;
		} else {
			return false;
		}
	}
	
	// two cards with the same value + two other cards with the same value
	public static boolean twoPairs(Hand hand) {
		hand.sortByValue();
		if(
				(hand.getCard(0).getValue() == hand.getCard(1).getValue()) &&
				((hand.getCard(2).getValue() == hand.getCard(3).getValue()) 
			) || (	
				(hand.getCard(0).getValue() == hand.getCard(1).getValue()) &&
				((hand.getCard(3).getValue() == hand.getCard(4).getValue()) 
				)
			) || (
				(hand.getCard(4).getValue() == hand.getCard(2).getValue()) &&
				((hand.getCard(3).getValue() == hand.getCard(4).getValue()) 	
				)
			)) {
			return true;
		} else {
			return false;
		}
	}
	
	// one set of cards with the same value
	public static boolean onePair(Hand hand) {
		hand.sortByValue();
		if(
				(hand.getCard(0).getValue() == hand.getCard(1).getValue()) ||
				(hand.getCard(1).getValue() == hand.getCard(2).getValue()) ||
				(hand.getCard(2).getValue() == hand.getCard(3).getValue()) ||
				(hand.getCard(3).getValue() == hand.getCard(4).getValue())
				)
		{
			return true;
		} else {
			return false;
		}
	}

}
