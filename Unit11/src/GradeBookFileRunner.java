//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.io.File;

public class GradeBookFileRunner
{
   public static void main( String args[] ) throws Exception
   {
		out.println("Welcome to the Class Stats program!");
		
		Scanner file = new Scanner(new File("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit11\\src\\gradebook.dat"));
		String cName = file.nextLine();
		int cSize = Integer.parseInt(file.nextLine());
		Class test = new Class(cName,cSize);
		
		int iter = 0;
		while (file.hasNextLine())
		{
			String sName = file.nextLine();
			String sGrades = file.nextLine();
			test.addStudent(iter,new Student(sName,sGrades));
			iter++;
		}
		out.println(test);











	}		
}