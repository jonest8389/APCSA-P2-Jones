//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   public Paddle()
   {
	   super(10,10);
      speed =5;
   }

   public Paddle(int x, int y)
   {
	   super(x,y);
   }
   public Paddle(int x, int y, int s)
   {
	   super(x,y); setSpeed(s);
   }
   public Paddle(int x, int y, int s, int w, int h)
   {
	   super(x,y,w,h); setSpeed(s);
   }
   public Paddle(int x, int y, int s, int w, int h, Color c)
   {
	   super(x,y,w,h,c); setSpeed(s);
   }
   //add the other Paddle constructors
   public void setSpeed(int s)
   {
	   speed = s;
   }
   
   public void moveUpAndDraw(Graphics window)
   {
	   draw(window,Color.white);
	   setY(getY() - getSpeed());
	   draw(window);

   }

   public void moveDownAndDraw(Graphics window)
   {
	   draw(window,Color.white);
	   setY(getY() + getSpeed());
	   draw(window);

   }
   //add get methods
   public int getSpeed()
   {
	   return speed;
   }
   
   //add a toString() method
   public String toString()
   {
	   return "Speed: " + speed + " " + super.toString();
   }
}