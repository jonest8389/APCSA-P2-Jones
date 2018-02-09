//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.lang.Math;

public class Prime
{
	private int number;

	public Prime()
	{


	}

	public Prime(int num)
	{
		setPrime(num);

	}

	public void setPrime(int num)
	{
		number = num;

	}

	public boolean isPrime()
	{
		int divisiblenums = 0;
		for (int i = 1;i < (number + 1);i++)
		{
			if (number % i == 0)
			{
				divisiblenums++;
			}
		}
		if (divisiblenums > 2)
		{
			return false;
		}
		return true;
	}

	public String toString()
	{
		String isprime = "";
		if (isPrime() == true)
		{
			isprime = " is prime.\n";
		}
		else if (isPrime() == false)
		{
			isprime = " is not prime.\n";
		}
		String output = number + isprime;
		return output;
	}
}