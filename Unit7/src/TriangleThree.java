//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class TriangleThree
{
   private int size;
   private String letter;

	public TriangleThree()
	{
		toString();
	}

	public TriangleThree(int count, String let)
	{
		setTriangle(let,count);
	}

	public void setTriangle( String let, int sz )
	{
		size = sz;
		letter = let;
	}

	public String getLetter()
	{
		return letter;
	}

	public String toString()
	{
		String pyramid = "";
		for (int i = 0;i < (size + 1);i++)
		{
			for (int j = 0;j < i;j++)
			{
				pyramid = pyramid + letter;
			}
			pyramid = pyramid + "\n";
		}
		return getLetter() + "\n" + pyramid + "\n";
	}
}