//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Monster implements Comparable
{
	private int myWeight;
	private int myHeight;
	private int myAge;

	//write a default Constructor
	public Monster()
	{
		
	}
	//write an initialization constructor with an int parameter ht
	public Monster(int ht)
	{
		setHeight(ht);
	}
	//write an initialization constructor with int parameters ht and wt
	public Monster(int ht,int wt)
	{
		setHeight(ht);
		setWeight(wt);
	}
	//write an initialization constructor with int parameters ht, wt, and age
	public Monster(int ht,int wt,int age)
	{
		setHeight(ht);
		setWeight(wt);
		setAge(age);
	}
	//modifiers - write set methods for height, weight, and age
	public void setHeight(int ht)
	{
		myHeight = ht;
	}
	public void setWeight(int wt)
	{
		myWeight = wt;
	}
	public void setAge(int age)
	{
		myAge = age;
	}
	//accessors - write get methods for height, weight, and age
	public int getHeight()
	{
		return myHeight;
	}
	public int getWeight()
	{
		return myWeight;
	}
	public int getAge()
	{
		return myAge;
	}
	//creates a new copy of this Object
	public Object clone()
	{
	   return new Monster(myWeight,myHeight,myAge);
	}

	public boolean equals( Object obj )
	{
		if (getWeight() == ((Monster)obj).getWeight())
		{
			if (getHeight() == ((Monster)obj).getHeight())
			{
				if (getAge() == ((Monster)obj).getAge())
				{
					return true;
				}
			}
		}
		return false;
	}

	public int compareTo( Object obj )
	{
		Monster rhs = (Monster)obj;
		double cAverage = 0.0;
		
		Comparable x = getWeight();
		Comparable y = rhs.getWeight();
		cAverage = cAverage + (double)x.compareTo(y);
		
		x = getHeight();
		y = rhs.getHeight();
		cAverage = cAverage + (double)x.compareTo(y);
		
		x = getAge();
		y = rhs.getAge();
		cAverage = cAverage + (double)x.compareTo(y);
		
		cAverage = cAverage / 3.0;
		if (cAverage >= 0.0)
		{
			return 1;
		}
		return -1;
	}

	//write a toString() method
	public String toString()
	{
		return "" + getWeight() + ", " + getHeight() + ", " + getAge();
	}
}