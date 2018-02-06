//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Lab02f
{
	public static void main( String[] args )
   {
		//add test cases
	
		
		int x1 = 1; int y1 = 9; int x2 = 14; int y2 = 2;
		
		Line test = new Line(x1,y1,x2,y2);
		test.calculateSlope();
		test.print();
		
		x1 = 1; y1 = 7; x2 = 18; y2 = 3;
		test.setCoordinates(x1,y1,x2,y2);
		test.calculateSlope();
		test.print();
		
		x1 = 6; y1 = 4; x2 = 2; y2 = 2;
		test.setCoordinates(x1,y1,x2,y2);
		test.calculateSlope();
		test.print();
		
		x1 = 4; y1 = 4; x2 = 5; y2 = 3;
		test.setCoordinates(x1,y1,x2,y2);
		test.calculateSlope();
		test.print();
		
		x1 = 1; y1 = 1; x2 = 2; y2 = 9;
		test.setCoordinates(x1,y1,x2,y2);
		test.calculateSlope();
		test.print();
	}
}