//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -
import java.lang.Math;
import java.util.Scanner;

public class Circle
{
	private double radius;
	private double area;

	public void setRadius(double rad)
	{
		radius = rad;
	}

	public void calculateArea( )
	{
		area = (radius * radius) * Math.PI;
	}

	public void print( )
	{
		System.out.printf("The area of a radius " + radius + " is " + "%.4f   \n\n\n",area);
	}
}