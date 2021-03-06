//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Distance
{
	private int xOne,yOne,xTwo,yTwo;
	private double distance, xpow, ypow;

	public Distance()
	{

		Scanner x1s = new Scanner(System.in);
		System.out.println("Enter X1: ");
		xOne = x1s.nextInt();
		Scanner y1s = new Scanner(System.in);
		System.out.println("Enter Y1: ");
		yOne = y1s.nextInt();
		Scanner x2s = new Scanner(System.in);
		System.out.println("Enter X2: ");
		xTwo = x2s.nextInt();
		Scanner y2s = new Scanner(System.in);
		System.out.println("Enter Y2: ");
		yTwo = y2s.nextInt();

	}

	public Distance(int x1, int y1, int x2, int y2)
	{

		setCoordinates(xOne,yOne,xTwo,yTwo);

	}

	public void setCoordinates(int x1, int y1, int x2, int y2)
	{

		xOne = x1;
		yOne = y1;
		xTwo = x2;
		yTwo = y2;

	}

	public void calcDistance()
	{
		xpow = xTwo - xOne;
		ypow = yTwo - yOne;
		distance = Math.sqrt((Math.pow(xpow, 2.0) + Math.pow(ypow, 2.0)));

	}

	public void print( )
	{

		System.out.printf("The distance is %.3f \n\n", distance);

	}
}