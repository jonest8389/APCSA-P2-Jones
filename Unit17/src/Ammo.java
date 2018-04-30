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

public class Ammo extends MovingThing
{
	private int speed;
	private int outofbounds = 0;
	private Alien killed;

	public Ammo()
	{
		this(0,0,10); this.setHeight(5); this.setWidth(5);
	}

	public Ammo(int x, int y)
	{
		this(x,y,10);  this.setHeight(5); this.setWidth(5);
	}

	public Ammo(int x, int y, int s)
	{
		this.setX(x); this.setY(y); setSpeed(s);  
		this.setHeight(5); this.setWidth(5);
	}

	public void setSpeed(int s)
	{
	   speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
		window.setColor(Color.YELLOW);
		window.drawRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		window.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		window.setColor(Color.BLACK);
	}
	
	
	public void move(String direction)
	{
		if (direction.equals("LEFT"))
			{
				setX(this.getX() + speed);
			}
			if (direction.equals("RIGHT"))
			{
				setX(this.getX() - speed);
			}
			if (direction.equals("UP"))
			{
				setY(this.getY() + speed);
			}
			if (direction.equals("DOWN"))
			{
				setY(this.getY() - speed);
			}
	}
	
	public void setOOB(int o)
	{
		outofbounds = o;
	}
	public int getOOB()
	{
		return outofbounds;
	}
	
	public void setKilled(Alien al)
	{
		killed = al;
	}
	public Alien getKilled()
	{
		return killed;
	}

	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
