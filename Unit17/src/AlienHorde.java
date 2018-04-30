//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienHorde
{
	private Alien[][] aliens;
	private int hsize;

	public AlienHorde(int size)
	{
		// Size will refer to row length
		aliens = new Alien[2][size];
		hsize = size;
	}

	public void add(Alien al)
	{
		int rownum = 0;
		int colnum = 0;
		addloop:
		for (Alien[] row : aliens)
		{
			for (Alien aladd : row)
			{
				if (aladd == null)
				{
					al.setRowDirection(1, 0);
					if (rownum == 1)
					{
						al.setRowDirection(2, 0);
					}
					aliens[rownum][colnum] = al;
					break addloop;
				}
				else
				{
					colnum++;
				}
			}
			colnum = 0;
			rownum++;
		}
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien[] row : aliens)
		{
			for (Alien val : row)
			{
				val.draw(window);
			}
		}
	}

	public void moveEmAll()
	{
		for (Alien[] row : aliens)
		{
			for (Alien al : row)
			{
				if (al.getDownStart() != 0)
				{
					if (al.getY() >= (al.getDownStart() + 50))
					{
						if (al.getRowDirection() == 1)
						{
							al.move("LEFT");
							al.setRowDirection(2, 0);
						}
						else if (al.getRowDirection() == 2)
						{
							al.move("RIGHT");
							al.setRowDirection(1, 0);
						}
					}
					else
					{
						al.move("UP");
					}
				}
				else if (al.getRowDirection() == 1)
				{
					al.move("RIGHT");
				}
				else if (al.getRowDirection() == 2)
				{
					al.move("LEFT");
				}
			}
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
		for (int i = 0;i < shots.size();i++)
		{
			if (shots.get(i).getKilled() != null)
			{
				for (Alien[] row : aliens)
				{
					for (Alien val : row)
					{
						if (val == shots.get(i).getKilled())
						{
							val.setDead(1);
						}
					}
				}
			}
		}
	}
	
	public Alien[][] getList()
	{
		return aliens;
	}

	public String toString()
	{
		String output = "";
		for (Alien[] row : aliens)
		{
			for (Alien val : row)
			{
				output = output + val.toString() + " ";
			}
		}
		return output;
	}
}
