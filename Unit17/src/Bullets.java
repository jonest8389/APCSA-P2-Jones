//© A+ Computer Science  -  www.apluscompsci.com
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
import java.util.List;

public class Bullets
{
	private List<Ammo> ammo;
	private int delay = 0;

	public Bullets()
	{
		ammo = new ArrayList<Ammo>(1000);
	}

	public void add(Ammo al)
	{
		if (delay == 0)
		{
			ammo.add(al);
			delay = 80;
		}
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
		if (delay > 0)
		{
			delay--;
		}
		for (int i = 0;i < ammo.size();i++)
		{
			ammo.get(i).draw(window);
		}
	}

	public void moveEmAll()
	{
		for (int i = 0;i < ammo.size();i++)
		{
			if (ammo.get(i).getOOB() == 0)
			{
				ammo.get(i).move("DOWN");	
			}
		}
	}

	public void cleanEmUp()
	{
		for (int i = 0;i < ammo.size();i++)
		{
			if (ammo.get(i).getY() < -20)
			{
				ammo.get(i).setOOB(1);
			}
		}
	}

	public List<Ammo> getList()
	{
		return ammo;
	}

	public String toString()
	{
		return "";
	}
}
