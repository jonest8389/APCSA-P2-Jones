//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Monsters {
	// use an ArrayList for extra credit!!!
	// private ArrayList<Monster> myMonsters;

	private ArrayList<Monster> myMonsters;

	public Monsters() {
		setMonsters(0);
	}

	public Monsters(int size) {
		setMonsters(size);

	}

	public void setMonsters(int size) {
		// size the array
		ArrayList<Monster> myMonsters = new ArrayList<Monster>(size);
		this.myMonsters = myMonsters;
	}

	public void add(int spot, Monster m) {
		// put m in the Monster array at [spot]
		if (spot < myMonsters.size())
			myMonsters.set(spot, m);
	}

	public Monster get(int spot) {
		return myMonsters.get(spot);
	}

	public Monster getLargest() {
		// Arrays.sort() might be handy
		Collections.sort(myMonsters);
		return myMonsters.get(myMonsters.size() - 1);
	}

	public Monster getSmallest() {
		// Arrays.sort() might be handy
		Collections.sort(myMonsters);
		return myMonsters.get(0);
	}

	@Override
	public String toString() {
		return "" + myMonsters;
	}
}