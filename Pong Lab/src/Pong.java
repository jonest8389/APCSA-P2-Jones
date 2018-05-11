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
import java.util.ArrayList;
import java.util.Random;

public class Pong extends Canvas implements KeyListener, Runnable, Collidable
{
	private Ball ball;
	private Paddle Paddle;
	private boolean[] keys;
	private BufferedImage back;
	private int Level;
	private Block Cover;
	private Block ballCover;
	private boolean AllGone;
	private ArrayList<Block> TileList;
	private int tilesleft;
	private Block TileCover;
	private int delay;


	public Pong()
	{
		//set up all variables related to the game
		ball = new Ball(400,200,10,10,Color.DARK_GRAY,3,3);
		Paddle = new Paddle(500,200,5,40,40,Color.GREEN);

		keys = new boolean[5];
		
		Level = 1;
		Cover = new Block(10,460,200,30,Color.WHITE);
		ballCover = new Block(0,0,15,15,Color.WHITE);
		TileCover = new Block(0,0,50,50,Color.WHITE);
		
		
		TileList = new ArrayList<Block>();
		tilesleft = 0;
		generateTiles();
		
		delay = 0;
		
		AllGone = false;
		
		tilesleft = TileList.size();
		
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

		
		for (Block tile : TileList)
		{
			tile.draw(graphToBack);
		}
		ball.moveAndDraw(graphToBack);
		Paddle.draw(graphToBack);

		graphToBack.setColor(Color.BLACK);
		graphToBack.drawString("Level " + Level, 10, 480);
		
		//see if ball hits left wall or right wall
		if ((didCollideLeft(ball) || didCollideRight(ball) || didCollideTop(ball) || didCollideBottom(ball)) && AllGone)
		{
			Level++;
			ballCover.setX(ball.getX()); ballCover.setY(ball.getY());
			ballCover.draw(graphToBack);
			Cover.draw(graphToBack);
			ball.setDrawOverride(false);
			ball.setColor(Color.WHITE);
			graphToBack.drawString("Level " + Level, 10, 480);
			ball.setX(400); ball.setY(200);
			ball.setColor(Color.DARK_GRAY);
			ball.setDrawOverride(true);
			AllGone = false;
			generateTiles();
		}
		else if ((didCollideLeft(ball) || didCollideRight(ball) || didCollideTop(ball) || didCollideBottom(ball)) && !AllGone)
		{
			if (didCollideLeft(ball) || didCollideRight(ball) && !(didCollideTop(ball) || didCollideBottom(ball)))
			{
				ball.setXSpeed(-(ball.getXSpeed()));
			}
			else if (!(didCollideLeft(ball) || didCollideRight(ball)) && didCollideTop(ball) || didCollideBottom(ball))
			{
				ball.setYSpeed(-(ball.getYSpeed()));
			}
		}
		//see if the ball hits the right paddle
		
		if (ball.getY() >= Paddle.getY() && ball.getY() < (Paddle.getY() + Paddle.getHeight()) && 
				ball.getX() >= Paddle.getX() && ball.getX() < (Paddle.getX() + Paddle.getWidth()))
		{
			Random d = new Random();
			int n = d.nextInt(2);
			if (n == 1)
			{
				ball.setXSpeed(-(ball.getXSpeed()));
			}
			else if (n == 2)
			{
				ball.setYSpeed(-(ball.getYSpeed()));
			}
			else
			{
				ball.setXSpeed(-(ball.getXSpeed()));
				ball.setYSpeed(-(ball.getYSpeed()));
			}
			
		}
		
		for (Block tile : TileList)
		{
			if ((ball.getX() >= tile.getX() && ball.getX() < tile.getX() + tile.getWidth()) && (ball.getY() >= tile.getY() && ball.getY() < tile.getY() + tile.getHeight()))
			{
				Random d = new Random();
				int n = d.nextInt(2);
				if (n == 1)
				{
					if (!(tile.getDead()))
					{
						tilesleft--;
						TileCover.setX(tile.getX()); TileCover.setY(tile.getY());
						TileCover.draw(graphToBack);
						tile.setX(-100); tile.setY(-100);
						ball.setXSpeed(-(ball.getXSpeed()));
						tile.setDead(true);
					}
				}
				else if (n == 2)
				{
					if (!(tile.getDead()))
					{
						tilesleft--;
						TileCover.setX(tile.getX()); TileCover.setY(tile.getY());
						TileCover.draw(graphToBack);
						tile.setX(-100); tile.setY(-100);
						ball.setYSpeed(-(ball.getYSpeed()));
						tile.setDead(true);
					}
				}
				else
				{
					if (!(tile.getDead()))
					{
						tilesleft--;
						TileCover.setX(tile.getX()); TileCover.setY(tile.getY());
						TileCover.draw(graphToBack);
						tile.setX(-100); tile.setY(-100);
						ball.setYSpeed(-(ball.getYSpeed()));
						ball.setXSpeed(-(ball.getXSpeed()));
						tile.setDead(true);
					}
				}
			}
		}
		
		
		//see if the paddles need to be moved
		if (keys[0] == true && Paddle.getY() > 0)
		{
			Paddle.moveUpAndDraw(graphToBack);
		}
		if (keys[1] == true && Paddle.getY() < 560)
		{
			Paddle.moveDownAndDraw(graphToBack);
		}
		if (keys[2] == true && Paddle.getX() > 0)
		{
			Paddle.moveLeftAndDraw(graphToBack);
		}
		if (keys[3] == true && Paddle.getX() < 800)
		{
			Paddle.moveRightAndDraw(graphToBack);
		}
		
		delay++;
		
		if (keys[4] && delay >= 50)
		{
			int endstop = 0;
			delay = 0;
			Random d = new Random();
			int n = d.nextInt(TileList.size() - 1);
			while (TileList.get(n).getDead() && endstop < 300)
			{
				n = d.nextInt(TileList.size() - 1);
				endstop++;
			}
			if (!(TileList.get(n).getDead()))
			{
				System.out.println(n);
				TileCover.setX(TileList.get(n).getX()); TileCover.setY(TileList.get(n).getY());
				TileCover.draw(graphToBack);
				TileList.get(n).setX(-100); TileList.get(n).setY(-100);
				TileList.get(n).setDead(true);
				tilesleft--;	
			}
		}
		
	if (tilesleft == 0)
	{
		tilesleft++;
		AllGone = true;
	}

		
		twoDGraph.drawImage(back, null, 0, 0);
	}
   
   public void generateTiles()
   {
	   TileList = new ArrayList<Block>();
	   
	// Top Row
	boolean tilefound = false;
	int tl_x = 0;
	int tl_y = 0;
	while (tl_x < 850)
	{
		TileList.add(new Block(tl_x,0,50,50,Color.RED));
		tl_x += 50;
	}
	tl_x = 0;
	while (tl_x < 850)
	{
		TileList.add(new Block(tl_x,50,50,50,Color.RED));
		tl_x += 50;
	}
	
	// Bottom Row
	tl_x = 0;
	while (tl_x < 850)
	{
		TileList.add(new Block(tl_x,550,50,50,Color.RED));
		tl_x += 50;
	}
	tl_x = 0;
	while (tl_x < 850)
	{
		TileList.add(new Block(tl_x,500,50,50,Color.RED));
		tl_x += 50;
	}

	// Left Row
	while (tl_y < 600)
	{
		for (Block tile : TileList)
		{
			if (tl_y >= tile.getY() && tl_y < tile.getY() + tile.getHeight() && tile.getX() == 0)
			{
				tilefound = true;
			}
		}
		if (tilefound)
		{
			tl_y += 50;
		}
		else
		{
			TileList.add(new Block(0,tl_y,50,50,Color.RED));
			tl_y += 50;
		}
		tilefound = false;
	}
	tl_y = 0;
	tilefound = false;
	while (tl_y < 600)
	{
		for (Block tile : TileList)
		{
			if (tl_y >= tile.getY() && tl_y < tile.getY() + tile.getHeight() && tile.getX() == 50)
			{
				tilefound = true;
			}
		}
		if (tilefound)
		{
			tl_y += 50;
		}
		else
		{
			TileList.add(new Block(50,tl_y,50,50,Color.RED));
			tl_y += 50;
		}
		tilefound = false;
	}
	tl_y = 0;
	tilefound = false;
	
	
	// Right Row
	while (tl_y < 600)
	{
		for (Block tile : TileList)
		{
			if (tl_y >= tile.getY() && tl_y < tile.getY() + tile.getHeight() && tile.getX() == 750)
			{
				tilefound = true;
			}
		}
		if (tilefound)
		{
			tl_y += 50;
		}
		else
		{
			TileList.add(new Block(750,tl_y,50,50,Color.RED));
			tl_y += 50;
		}
		tilefound = false;
	}
	tl_y = 0;
	tilefound = false;
	while (tl_y < 600)
	{
		for (Block tile : TileList)
		{
			if (tl_y >= tile.getY() && tl_y < tile.getY() + tile.getHeight() && tile.getX() == 700)
			{
				tilefound = true;
			}
		}
		if (tilefound)
		{
			tl_y += 50;
		}
		else
		{
			TileList.add(new Block(700,tl_y,50,50,Color.RED));
			tl_y += 50;
		}
		tilefound = false;
	}
	tl_y = 0;
	tilefound = false;
	
	tilesleft = TileList.size();
   }

   	public boolean didCollideLeft(Object obj)
   	{
   		if(!(ball.getX()>=10 && ball.getX()<=800))
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
		if(!(ball.getX()>=10 && ball.getX()<=800))
		{
			if (ball.getX() > 800)
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
			if (ball.getY() >= 560)
			{
				return true;
			}
		}
	   return false;
   }
   
	public void keyPressed(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_UP : keys[0]=true; break;
			case KeyEvent.VK_DOWN : keys[1]=true; break;
			case KeyEvent.VK_LEFT : keys[2]=true; break;
			case KeyEvent.VK_RIGHT : keys[3]=true; break;
			case KeyEvent.VK_Q : keys[4]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_UP : keys[0]=false; break;
			case KeyEvent.VK_DOWN : keys[1]=false; break;
			case KeyEvent.VK_LEFT : keys[2]=false; break;
			case KeyEvent.VK_RIGHT : keys[3]=false; break;
			case KeyEvent.VK_Q : keys[4]=false; break;
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