//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{


	}

	public TicTacToe(String game)
	{
		int gamesize = game.length();
		mat = new char[3][3];
		int h = 0;
		for (int i = 0;i < 3;i++)
		{
			for (int j = 0;j < 3;j++)
			{
				mat[i][j] = game.charAt(h);
				h++;
			}
		}
	}

	public String getWinner()
	{
		// Diagonal
		if (mat[0][0] == mat[1][1] && mat[0][0] == mat[2][2] && mat[1][1] == mat[2][2])
		{
			return Character.toString(mat[0][0]) + " wins diagonally!";
		}
		if (mat[0][2] == mat[1][1] && mat[0][2] == mat[2][0] && mat[1][1] == mat[2][0])
		{
			return Character.toString(mat[0][2]) + " wins diagonally!";
		}
		// Horizontal
		for (int i = 0;i < mat.length;i++)
		{
			if (mat[i][0] == mat[i][1] && mat[i][0] == mat[i][2] && mat[i][1] == mat[i][2])
			{
				return Character.toString(mat[i][0]) + " wins horizontally!";
			}
		}
		// Vertical
		for (int j = 0;j < mat.length;j++)
		{
			if (mat[0][j] == mat[1][j] && mat[0][j] == mat[2][j] && mat[1][j] == mat[2][j])
			{
				return Character.toString(mat[0][j]) + " wins vertically!";
			}
		}
		return "Tie game!";
	}

	public String toString()
	{
		String output="";
		for (int i = 0;i < mat.length;i++)
		{
			for (int j = 0;j < mat.length;j++)
			{
				output = output + mat[i][j] + " ";
			}
			output = output + "\n";
		}
		output = output + getWinner();
		return output+"\n\n";
	}
}