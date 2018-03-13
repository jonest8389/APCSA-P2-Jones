//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Student
{
	private String myName;
	private Grades myGrades;
	
	public Student()
	{
		setName("");
		setGrades("");
	}
	
	public Student(String name, String gradeList)
	{
		setName(name);
		setGrades(gradeList);
	}
	
	public void setName(String name)
	{
		myName = name;
	}	
	
	public void setGrades(String gradeList)
	{
		myGrades = new Grades(gradeList);
	}
	
	public void setGrade(int spot, double grade)
	{
		myGrades.setGrade(spot, grade);
	}

	public String getName()
	{
		return myName;
	}
	
	public int getNumGrades()
	{
		return 0;
	}

	public double getSum()
	{
		return myGrades.getSum();
	}
	
	public double getAverage()
	{
		double acount = 0.0;
		double atotal = 0.0;
		for (int i = 0; i < myGrades.getGrades().length;i++)
		{
			atotal = atotal + (myGrades.getGrades())[i];
			acount++;
		}
		return (atotal / acount);
	}

	public double getAverageMinusLow()
	{
		return (getAverage() - myGrades.getLowGrade());
	}
	
	public double getHighGrade()
	{
		return myGrades.getHighGrade();		
	}
	
	public double getLowGrade()
	{
		return myGrades.getLowGrade();	
	}
	
	public boolean equals(Student os)
	{
		if (getAverage() == os.getAverage())
		{
			return true;
		}		
		return false;
	}
	
	public boolean compareTo(Student os)
	{
		if (getAverage() > os.getAverage())
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		String gR = "";
		for (int i = 0;i < myGrades.getGrades().length;i++)
		{
			gR = gR + (myGrades.getGrades())[i] + " ";
		}
		return myName + " = " + gR + "\n";
	}	
}