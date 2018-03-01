/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		
		Card test1 = new Card("Queen","Clubs",10);
		System.out.println(test1);
		Card test2 = new Card("5","Spades",5);
		System.out.println(test2);
		Card test3 = new Card("Jack","Hearts",10);
		System.out.println(test3);
		
	}
}
