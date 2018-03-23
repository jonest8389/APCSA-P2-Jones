//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab21i
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("C:\\Users\\jonest8389\\Desktop\\APCSA-P2-Jones\\Unit14\\src\\lab21i.dat"));
		int maze1size = Integer.parseInt(file.nextLine());
		String maze1line = file.nextLine();
		Maze maze1 = new Maze(maze1size,maze1line);
		out.println(maze1);
		
		int maze2size = Integer.parseInt(file.nextLine());
		String maze2line = file.nextLine();
		Maze maze2 = new Maze(maze2size,maze2line);
		out.println(maze2);
		
		int maze3size = Integer.parseInt(file.nextLine());
		String maze3line = file.nextLine();
		Maze maze3 = new Maze(maze3size,maze3line);
		out.println(maze3);
		
		int maze4size = Integer.parseInt(file.nextLine());
		String maze4line = file.nextLine();
		Maze maze4 = new Maze(maze4size,maze4line);
		out.println(maze4);
		
		int maze5size = Integer.parseInt(file.nextLine());
		String maze5line = file.nextLine();
		Maze maze5 = new Maze(maze5size,maze5line);
		out.println(maze5);
		
		int maze6size = Integer.parseInt(file.nextLine());
		String maze6line = file.nextLine();
		Maze maze6 = new Maze(maze6size,maze6line);
		out.println(maze6);
	}
}