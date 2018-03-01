/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] deck1ranks = {"Queen","Jack","Four","One"};
		String[] deck1suits = {"Hearts","Clubs","Spades","Diamonds"};
		int[] deck1values = {10,10,4,1};
		
		Deck deck1 = new Deck(deck1ranks,deck1suits,deck1values);
		System.out.println(deck1);
	}
}
