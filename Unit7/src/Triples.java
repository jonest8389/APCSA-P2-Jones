//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		setNum(num);
	}

	public void setNum(int num)
	{
		number = num;
	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = 0;
		int returnmax = 0;
		for (max = 0;max < (number + 1);max++)
		{
			if (max != 0)
			{
				if (a % max == 0)
				{
					if (b % max == 0)
					{
						if (c % max == 0)
						{
							returnmax = max;
						}
					}
				}
			}
		}
		if (returnmax > 1)
		{
			return returnmax;
		}
		return 1;
	}

	public String toString()
	{
		String output="";
		int A = 0; int B = 0; int C = 0;
		for (A = 1;A < (number + 1);A++)
		{
			for (B = 1;B < (number + 1);B++)
			{
				for (C = 1;C < (number + 1);C++)
				{
					if ((Math.pow(A, 2) + Math.pow(B, 2)) == Math.pow(C, 2))
					{
						if (A % 2 != 0)
						{
							if (B % 2 == 0)
							{
								if (C % 2 != 0)
								{
									if (greatestCommonFactor(A,B,C) <= 1)
									{
										output = output + A + " " + B +
												" " + C + "\n";
									}
								}
							}
						}
						if (A % 2 == 0)
						{
							if (B % 2 != 0)
							{
								if (C % 2 != 0)
								{
									if (greatestCommonFactor(A,B,C) <= 1)
									{
										output = output + A + " " + B +
												" " + C + "\n";
									}
								}
							}
						}
					}
				}
			}
		}
		


		return output+"\n";
	}
}