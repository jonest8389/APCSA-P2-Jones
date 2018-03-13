//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Class
{
	private String name;
	private Student[] studentList;
	
	public Class()
	{
		name="";
		studentList=new Student[0];
	}
	
	public Class(String name, int stuCount)
	{
		this.name = name;
		this.studentList = new Student[stuCount];
	}
	
	public void addStudent(int stuNum, Student s)
	{
		studentList[stuNum] = s;
	}
	
	public String getClassName()
	{
	   return name;	
	}
	
	public double getClassAverage()
	{
		double classAverage=0.0;
		double scount = 0.0;
		double stotal = 0.0;
		for (int i = 0; i < studentList.length;i++)
		{
			scount++;
			stotal = stotal + studentList[i].getAverage();
		}
		classAverage = stotal / scount;
		return classAverage;
	}
	
	public double getStudentAverage(int stuNum)
	{
		return studentList[stuNum].getAverage();
	}

	public double getStudentAverage(String stuName)
	{
		Student s = studentList[0];
		for (int i = 0;i < studentList.length;i++)
		{
			if (studentList[i].getName().equals(stuName))
			{
				s = studentList[i];
			}
		}
		return s.getAverage();
	}
	
	public String getStudentName(int stuNum)
	{
		return studentList[stuNum].getName();
	}

	public String getStudentWithHighestAverage()
	{
		double high = Double.MIN_VALUE;
		Student hName = studentList[0];
		for (int i = 0;i < studentList.length;i++)
		{
			if (studentList[i].getAverage() > high)
			{
				high = studentList[i].getAverage();
				hName = studentList[i];
			}
		}
		return hName.getName();
	}

	public String getStudentWithLowestAverage()
	{
		double low = Double.MAX_VALUE;
		Student hName = studentList[0];
		for (int i = 0;i < studentList.length;i++)
		{
			if (studentList[i].getAverage() < low)
			{
				low = studentList[i].getAverage();
				hName = studentList[i];
			}
		}
		return hName.getName();
	}
	
	public String getFailureList(double failingGrade)
	{
		String lgl = "";
		Student lgstudent = studentList[0];
		for (int i = 0;i < studentList.length;i++)
		{
			if (studentList[i].getAverage() <= failingGrade)
			{
				lgl = lgl + studentList[i].getName() + ", ";
			}
		}
		return lgstudent.getName();
	}
	public void classSort()
	{
		Arrays.sort(studentList);
	}
	
	public String toString()
	{
		String output=""+getClassName()+"\n";
		for (int i = 0; i < studentList.length;i++)
		{
			output = output + studentList[i] + " (" + studentList[i].getAverage() + ")\n";
		}
		return output;
	}  	
}