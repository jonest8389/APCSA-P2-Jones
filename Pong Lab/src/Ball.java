//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block
{
	private int xSpeed;
	private int ySpeed;
	private boolean drawOverride = true;
	private boolean collided = false;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	
	public Ball(int x, int y)
	{
		super(x,y);
	}
	public Ball(int x, int y, int w, int h)
	{
		super(x,y,w,h);
	}
	public Ball(int x, int y, int w, int h, Color c)
	{
		super(x,y,w,h,c);
	}
	public Ball(int x, int y, int w, int h, Color c, int xs, int ys)
	{
		super(x,y,w,h,c); setXSpeed(xs); setYSpeed(ys);
	}

	public void setXSpeed(int xs)
	{
		xSpeed = xs;
	}
	public void setYSpeed(int ys)
	{
		ySpeed = ys;
	}
	public int getXSpeed()
	{
		return xSpeed;
	}
	public int getYSpeed()
	{
		return ySpeed;
	}
	public void setDrawOverride(boolean s)
	{
		drawOverride = s;
	}

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	  if (drawOverride == true)
	  {
		  draw(window,Color.WHITE);
	      setX(getX()+xSpeed);
	      setY(getY()+ySpeed);
			//setY
	      draw(window);
	  }
		//draw the ball at its new location
   }
   
	public boolean equals(Ball obj)
	{
		if (getXSpeed() == obj.getXSpeed() && getYSpeed() == obj.getYSpeed())
		{
			if (super.equals(obj))
			{
				return true;
			}
		}

		return false;
	}   

   //add the get methods

   //add a toString() method
	public String toString()
	{
		return "XSpeed: " + xSpeed + " YSpeed: " + ySpeed + " " + super.toString();
	}
}