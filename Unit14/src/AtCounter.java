//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class AtCounter
{
   private char[][] atMat;
   private int atCount;

	public AtCounter()
	{
		
	}
	
	public AtCounter(int row, int column)
	{
		atCount=0;
		atMat = new char[][]{{'@','-','@','-','-','@','-','@','@','@'},
									{'@','@','@','-','@','@','-','@','-','@'},
									{'-','-','-','-','-','-','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','-','@'},
									{'-','@','-','@','-','@','-','@','-','@'},
									{'@','@','@','@','@','@','-','@','@','@'},
									{'-','@','-','@','-','@','-','-','-','@'},
									{'-','@','@','@','-','@','-','-','-','-'},
									{'-','@','-','@','-','@','-','@','@','@'},
									{'-','@','@','@','@','@','-','@','@','@'}};
		setAtCount(row,column);
	}
	public void setAtCount(int row, int column)
	{
		atCount = countAts(row,column);
	}
	
	public int countAts(int r, int c)
	{
		int localCount = 0;
		if (atMat[r][c] == '@')
		{
			localCount++;
		}
		int ri; int ci;
		
		// Up
		ri = r - 1;
		while (ri >= 0)
		{
			if (atMat[ri][c] == '@')
			{
				localCount++;
			}
			ri--;
		}
		// Down
		ri = r + 1;
		while (ri < 10)
		{
			if (atMat[ri][c] == '@')
			{
				localCount++;
			}
			ri++;
		}
		// Left
		ci = c - 1;
		while (ci >= 0)
		{
			if (atMat[r][ci] == '@')
			{
				localCount++;
			}
			ci--;
		}
		// Right
		ci = c + 1;
		while (ci < 10)
		{
			if (atMat[r][ci] == '@')
			{
				localCount++;
			}
			ci++;
		}
		return localCount;
	}

	public int getAtCount()
	{
		return atCount;
	}

	public String toString()
	{
		String output="";
		output+=getAtCount()+" @s connected.";
		return output;
	}
}