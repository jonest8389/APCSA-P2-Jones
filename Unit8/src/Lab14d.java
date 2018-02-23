//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Lab14d
{
	public static void main( String args[] )
	{
		double[] testlist1 = {100.0,90.0,85.0,72.5,95.6};
		Grades test = new Grades(testlist1);
		System.out.println(test);
		
		double[] testlist2 = {50.0,100.0,80.0};
		test.setGrades(testlist2);
		System.out.println(test);
		
		double[] testlist3 = {93.4,-90.0,90.0};
		test.setGrades(testlist3);
		System.out.println(test);
		
		double[] testlist4 = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0};
		test.setGrades(testlist4);
		System.out.println(test);
		
	}
}