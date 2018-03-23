//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;
   private int[][] markedmaze;
   private boolean exitfound = false;

	public Maze()
	{
		exitfound = false;
	}

	public Maze(int size, String line)
	{
		maze = new int[size][size];
		int iter = 0;
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size;j++)
			{
				maze[i][j] = Integer.parseInt(Character.toString(line.charAt(iter)));
				iter = iter + 2;
			}
		}
		for (int k = 0;k < size;k++)
		{
			for (int l = 0; l < size;l++)
			{
				out.print(maze[k][l] + " ");
			}
			out.println();
		}
		markedmaze = maze;
	}

	public void hasExitPath(int r, int c)
	{
		if ((r == maze.length - 1 && maze[r][c] == 1))
		{
			exitfound = true;
		}
		if (markedmaze[r][c] == 1)
		{
			markedmaze[r][c] = 2;
			// Up
			if (r != 0)
			{
				if (markedmaze[r - 1][c] == 1)
				{
					hasExitPath(r - 1,c);
				}
			}
			// Down
			if (r != maze.length - 1)
			{
				if (markedmaze[r + 1][c] == 1)
				{
					hasExitPath(r + 1,c);
				}
			}
			// Left
			if (c != 0)
			{
				if (markedmaze[r][c - 1] == 1)
				{
					hasExitPath(r,c - 1);
				}
			}
			// Right
			if (c != maze.length - 1)
			{
				if (markedmaze[r][c + 1] == 1)
				{
					hasExitPath(r,c + 1);
				}
			}
		}
	}

	public String toString()
	{
		String output="";
		hasExitPath(0,0);
		if (exitfound == true)
		{
			output = "exit found";
		}
		else
		{
			output = "exit not found";
		}
		out.println("\n");
		for (int k = 0;k < markedmaze.length;k++)
		{
			for (int l = 0; l < markedmaze.length;l++)
			{
				out.print(markedmaze[k][l] + " ");
			}
			out.println();
		}
		
		
		
		return output + "\n";
	}
}