//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord
{
	private char[][] mat;

	public FancyWord()
	{

	}

   public FancyWord(String s)
	{
	   int matsize = s.length();
	   mat = new char[matsize][matsize];
	   if (matsize == 1)
	   {
		   mat[0][0] = s.charAt(0);
	   }
	   else
	   {
		   for (int i = 0;i < matsize;i++)
		   {
			   mat[0][i] = s.charAt(i);
			   mat[matsize - 1][i] = s.charAt(i);
		   }
		   for (int j = 0;j < matsize;j++)
		   {
			   mat[j][j] = s.charAt(j);
		   }
		   int l = 0;
		   for (int k = matsize - 1;k > -1;k--)
		   {
			   mat[l][k] = s.charAt(k);
			   l++;
		   }
	   }

	}

	public String toString()
	{
		String output="";
		for (int i = 0; i < mat.length;i++)
		{
			for (int j = 0;j < mat.length;j++)
			{
				output = output + mat[i][j];
			}
			output = output + "\n";
		}
		return output+"\n\n";
	}
}