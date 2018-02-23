//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.lang.System;
import java.lang.Math;
import java.util.Scanner;

public class Grades
{
	private double[] gradelist = new double[1];
	
	
	public Grades(double[] gl)
	{
		setGrades(gl);
	}
	public void setGrades(double[] gl)
	{
		gradelist = gl;
	}

	private double getSum()
	{
		double sum=0.0;
		for (int i = 0;i < gradelist.length;i++)
		{
			sum = sum + gradelist[i];
		}
		return sum;
	}

	public double getAverage(double sum)
	{
		double average=0.0; double listtotal = 0.0;
		for (int i = 0;i < gradelist.length;i++)
		{
			listtotal++;
		}
		average = sum / listtotal;
		return average;
	}
	public String toString()
	{
		String output = "";
		for (int i = 0;i < gradelist.length;i++)
		{
			output = output + "grade " + i + "::  "
		+ gradelist[i] + "\n";
		}
		output = output + "\naverage = " + getAverage(getSum())
		+ "\n";
		
		return output + "\n";
	}
}