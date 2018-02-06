//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Quadratic
{
	private int a, b, c;
	private double rootOne;
	private double rootTwo;

	public Quadratic()
	{
		Scanner ina = new Scanner(System.in);
		System.out.println("Enter a: ");
		a = ina.nextInt();
		Scanner inb = new Scanner(System.in);
		System.out.println("Enter b: ");
		b = inb.nextInt();
		Scanner inc = new Scanner(System.in);
		System.out.println("Enter c: ");
		c = inc.nextInt();

	}

	public Quadratic(int quadA, int quadB, int quadC)
	{	
		setEquation(a,b,c);
	}

	public void setEquation(int quadA, int quadB, int quadC)
	{
		a = quadA;
		b = quadB;
		c = quadC;
 	}

	public void calcRoots( )
	{
		rootOne = (-b + (Math.sqrt((b * b) - 4.0 * a * c)))/(2.0 * a);
		rootTwo = (-b - (Math.sqrt((b * b) - 4.0 * a * c)))/(2.0 * a);

	}

	public void print( )
	{
		System.out.printf("The first root is == %.2f \n\n", rootOne);
		System.out.printf("The second root is == %.2f \n\n", rootTwo);
	}
}