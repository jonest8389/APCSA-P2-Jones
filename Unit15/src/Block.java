//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y)
	{
		setX(x); setY(y);
	}
	public Block(int x,int y,int w,int h)
	{
		setX(x); setY(y); width = w; height = h;
	}
	public Block(int x,int y,int w,int h,Color c)
	{
		setX(x); setY(y); width = w; height = h; setColor(c);
	}
	public void setX(int x)
	{
		xPos = x;
	}
	public void setY(int y)
	{
		yPos = y;
	}
	public void setHeight(int h)
	{
		height = h;
	}
	public void setWidth(int w)
	{
		width = w;
	}
	public void setPos(int x,int y)
	{
		setX(x); setY(y);
	}
	public int getX()
	{
		return xPos;
	}
	public int getY()
	{
		return yPos;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public Color getColor()
	{
		return color;
	}

   public void setColor(Color col)
   {
	   color = col;
   }

   public void draw(Graphics window)
   {
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Block obj)
	{
		if (this.getX() == obj.getX() && this.getY() == obj.getY() &&
				this.getHeight() == obj.getHeight() && this.getWidth()
				 == obj.getWidth())
		{
			return true;
		}
		return false;
	}   
	public String toString()
	{
		String output = "X: " + getX() + " Y: " + getY() + " Height: "
				+ getHeight() + " Width: " + getWidth();	
		return output;
	}
}