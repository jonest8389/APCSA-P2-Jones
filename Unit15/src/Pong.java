//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable, Collidable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int leftPoints;
	private int rightPoints;
	private Block lpCover;
	private Block rpCover;
	private Block ballCover;


	public Pong()
	{
		//set up all variables related to the game
		ball = new Ball(400,200,10,10,Color.DARK_GRAY,2,2);
		leftPaddle = new Paddle(10,200,5,20,100,Color.BLUE);
		rightPaddle = new Paddle(750,200,5,20,100,Color.GREEN);

		keys = new boolean[4];
		
		leftPoints = 0; rightPoints = 0;
		lpCover = new Block(10,460,200,30,Color.WHITE);
		rpCover = new Block(700,460,200,30,Color.WHITE);
		ballCover = new Block(0,0,15,15,Color.WHITE);
    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		
		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		graphToBack.setColor(Color.BLACK);
		
		graphToBack.drawString("Left Score: " + leftPoints, 10, 480);
		graphToBack.drawString("Right Score: " + rightPoints, 700, 480);

		//see if ball hits left wall or right wall
		if (didCollideLeft(ball) == true)
		{
			ballCover.setX(ball.getX()); ballCover.setY(ball.getY());
			ballCover.draw(graphToBack);
			rpCover.draw(graphToBack);
			ball.setDrawOverride(false);
			ball.setColor(Color.WHITE);
			graphToBack.drawString("Left Score: " + leftPoints, 10, 480);
			ball.setX(400); ball.setY(200);
			ball.setColor(Color.DARK_GRAY);
			ball.setDrawOverride(true);
			rightPoints++;
		}
		if (didCollideRight(ball) == true)
		{
			ballCover.setX(ball.getX()); ballCover.setY(ball.getY());
			ballCover.draw(graphToBack);
			lpCover.draw(graphToBack);
			ball.setDrawOverride(false);
			ball.setColor(Color.WHITE);
			graphToBack.drawString("Right Score: " + rightPoints, 700, 480);
			ball.setX(400); ball.setY(200);
			ball.setColor(Color.DARK_GRAY);
			ball.setDrawOverride(true);
			leftPoints++;
		}
		
		//see if the ball hits the top or bottom wall 
		if (didCollideTop(ball) || didCollideBottom(ball))
		{
			ball.setYSpeed(-(ball.getYSpeed()));
		}

		//see if the ball hits the left paddle
		int lpRangeY = leftPaddle.getY() + leftPaddle.getHeight();
		int lpRangeX = leftPaddle.getX() + leftPaddle.getWidth();
		if (ball.getY() <= lpRangeY && ball.getY() >= leftPaddle.getY() && 
				ball.getX() <= lpRangeX && ball.getX() >= leftPaddle.getX())
		{
			if (ball.getX() <= lpRangeX && ball.getX() >= leftPaddle.getX())
			{
				ball.setXSpeed(-(ball.getXSpeed()));
			}
		}		
		//see if the ball hits the right paddle
		int rpRangeY = rightPaddle.getY() + rightPaddle.getHeight();
		int rpRangeX = rightPaddle.getX() + rightPaddle.getWidth();
		if (ball.getY() <= rpRangeX && ball.getY() >= rightPaddle.getY() && 
				ball.getX() <= rpRangeX && ball.getX() >= rightPaddle.getX())
		{
			if (ball.getX() <= rpRangeX && ball.getX() >= rightPaddle.getX())
			{
				ball.setXSpeed(-(ball.getXSpeed()));
			}
		}
		
		//see if the paddles need to be moved
		if (keys[0] == true && leftPaddle.getY() > 0)
		{
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[1] == true && leftPaddle.getY() < 460)
		{
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if (keys[2] == true && rightPaddle.getY() > 0)
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[3] == true && rightPaddle.getY() < 460)
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}

		
		twoDGraph.drawImage(back, null, 0, 0);
	}

   	public boolean didCollideLeft(Object obj)
   	{
   		if(!(ball.getX()>=10 && ball.getX()<=780))
		{
			if (ball.getX() < 10)
			{
				return true;
			}
		}
   		return false;
   	}
   public boolean didCollideRight(Object obj)
   {
		if(!(ball.getX()>=10 && ball.getX()<=780))
		{
			if (ball.getX() > 780)
			{
				return true;
			}
		}
		return false;
   }
   public boolean didCollideTop(Object obj)
   {
	   if (!(ball.getY()>=0 && ball.getY()<=540))
		{
			if (ball.getY() <= 0)
			{
				return true;
			}
		}
	   return false;
   }
   public boolean didCollideBottom(Object obj)
   {
	   if (!(ball.getY()>=0 && ball.getY()<=540))
		{
			if (ball.getY() >= 540)
			{
				return true;
			}
		}
	   return false;
   }
   
	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}