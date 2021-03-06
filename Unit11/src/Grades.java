//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades
{
	private double[] grades;
	
	public Grades()
	{
		setGrades("");
	}
	
	public Grades(String gradeList)
	{
		setGrades(gradeList);		
	}
	
	public double[] getGrades()
	{
		return grades;
	}
	public void setGrades(String gradeList)
	{
		String[] gNListT = new String[50];
		int gNLsize = 0;
		for (int i = 0;i < gradeList.length();i++)
		{
			gNListT[i] = Character.toString(gradeList.charAt(i));
			gNLsize++;
		}
		String[] gNList = new String[gNLsize];
		int iter1 = 0;
		for (int j = 0;j < gradeList.length();j++)
		{
			if (!(gNListT[j].equals(null)))
			{
				gNList[iter1] = gNListT[j];
				iter1++;
			}
		}
		int iter2 = 0;
		String appS = "";
		double[] dgL = new double[10];
		for (int k = 0;k < gNList.length;k++)
		{
			if (k == 0)
			{
				dgL[iter2] = (double)Integer.parseInt(gNList[iter2]);
				iter2++;
			}
			else if (k > 3)
			{
				
				double appD;
				if (gNList[k].equals(" "))
				{				
					appD = Double.parseDouble(appS);
					dgL[iter2] = appD;
					iter2++;
					appS = "";
				}
				else
				{
					if (k == gNList.length - 1)
					{
						appS = gNList[(k - 1)] + gNList[k];
						appD = Double.parseDouble(appS);
						dgL[iter2] = appD;
						iter2++;
						appS = "";
					}
					else
					{
						appS = appS + gNList[k];
					}
				}
			}
		}
		double[] dgLT = new double[(int)dgL[0] + 1];
		for (int m = 0; m < dgL.length;m++)
		{
			if (dgL[m] != 0.0)
			{
				dgLT[m] = dgL[m];
			}
		}
		double[] grades = new double[(int)dgLT[0]];
		this.grades = grades;
		for (int l = 1;l < dgLT.length;l++)
		{
			setGrade(l,dgLT[l]);
		}

	}
	
	public void setGrade(int spot, double grade)
	{

		// Assuming "spot" is a number position and not 
		// an array-oriented reference
		spot = spot - 1;
		grades[spot] = grade;

	}
	
	public double getSum()
	{
		double sum=0.0;
		for (int i = 0;i < grades.length;i++)
		{
			sum = sum + grades[i];
		}
		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;	
		for (int i = 0;i < grades.length;i++)
		{
			if (grades[i] < low)
			{
				low = grades[i];
			}
		}
		return low;
	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;
		for (int i = 0;i < grades.length;i++)
		{
			if (grades[i] > high)
			{
				high = grades[i];
			}
		}
		return high;
	}
	
	public int getNumGrades()
	{
		return grades.length;
	}
	
	public String toString()
	{
		String output="";
		out.println("");
		for (int i = 0; i < grades.length; i++)
		{
			if (grades[i] < 60.0)
			{
				output = output + grades[i] + "\nF\n";
			}
			else if (grades[i] < 70.0)
			{
				output = output + grades[i] + "\nD\n";
			}
			else if (grades[i] < 80.0)
			{
				output = output + grades[i] + "\nC\n";
			}
			else if (grades[i] < 90.0)
			{
				output = output + grades[i] + "\nB\n";
			}
			else
			{
				output = output + grades[i] + "\nA\n";
			}
		}
		return output;
	}	
}