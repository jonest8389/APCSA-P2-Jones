import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		List<Card> selL = new ArrayList<Card>();
		for (int i = 0; i < selectedCards.size();i++)
		{
			selL.add(cardAt(i));
		}
		int selVal = 0;
		for (int j = 0;j < selL.size();j++)
		{
			selVal = selVal + selL.get(j).pointValue();
		}
		if (selVal == 11)
		{
			return true;
		}
		int selF_K = 0;
		int selF_J = 0;
		int selF_Q = 0;
		for (int k = 0;k < selL.size();k++)
		{
			if (selL.get(k).rank().equals("King"))
			{
				selF_K = 1;
			}
			if (selL.get(k).rank().equals("King") && selF_K > 0)
			{
				selF_K = 2;
			}
			if (selL.get(k).rank().equals("Jack"))
			{
				selF_J = 1;
			}
			if (selL.get(k).rank().equals("Jack") && selF_J > 0)
			{
				selF_J = 2;
			}
			if (selL.get(k).rank().equals("Queen"))
			{
				selF_Q = 1;
			}
			if (selL.get(k).rank().equals("Queen") && selF_Q > 0)
			{
				selF_Q = 2;
			}	
		}
		if (selF_K == 1 && selF_J == 1 && selF_Q == 1)
		{
			return true;
		}
		return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		for (int i = 0;i < size();i++)
		{
			for (int j = 0; j < size();j++)
			{
				if (i != j)
				{
					List<Integer> apL = new ArrayList<Integer>();
					apL.add(i); apL.add(j);
					if (isLegal(apL) == true)
					{
						return true;
					}
				}
			}
		}
		for (int k = 0;k < size();k++)
		{
			for (int l = 0;l < size();l++)
			{
				for (int m = 0;m < size();m++)
				{
					if (k != l && k != m && l != m)
					{
						List<Integer> apL = new ArrayList<Integer>();
						apL.add(k); apL.add(l); apL.add(m);
						if (isLegal(apL) == true)
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		int selVal = 0;
		for (int i = 0; i < selectedCards.size();i++)
		{
			selVal = selVal + cardAt(selectedCards.get(i)).pointValue();
		}
		if (selVal == 11)
		{
			return true;
		}
		return false;
		
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		List<Card> selL = new ArrayList<Card>();
		for (int i = 0; i < selectedCards.size();i++)
		{
			selL.add(cardAt(i));
		}
		int selF_K = 0;
		int selF_J = 0;
		int selF_Q = 0;
		for (int k = 0;k < selL.size();k++)
		{
			if (selL.get(k).rank().equals("King"))
			{
				selF_K = 1;
			}
			if (selL.get(k).rank().equals("King") && selF_K > 0)
			{
				selF_K = 2;
			}
			if (selL.get(k).rank().equals("Jack"))
			{
				selF_J = 1;
			}
			if (selL.get(k).rank().equals("Jack") && selF_J > 0)
			{
				selF_J = 2;
			}
			if (selL.get(k).rank().equals("Queen"))
			{
				selF_Q = 1;
			}
			if (selL.get(k).rank().equals("Queen") && selF_Q > 0)
			{
				selF_Q = 2;
			}	
		}
		if (selF_K == 1 && selF_J == 1 && selF_Q == 1)
		{
			return true;
		}
		return false;
	}
}
