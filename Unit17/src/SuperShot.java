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

public class SuperShot extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
	private Alien alien1;
	private Alien alien2;
	private Alien alien3;
	private Alien alien4;
	private Alien alien5;
	private Alien alien6;
	private Alien alien7;
	private Alien alien8;
	private Alien alien9;
	private Alien alien10;
	private Alien alien11;
	private Alien alien12;
	private Alien alien13;
	private Alien alien14;
	private Alien alien15;
	private Alien alien16;
	private Ammo ammoTest;

	private AlienHorde horde;
	private Bullets shots;
	
	private boolean SUPER_SHOT;
	private int ssdelay;
	private int ssdone;

	private boolean[] keys;
	private BufferedImage back;

	public SuperShot()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables
		ship = new Ship(350,500,40,40,1);
		alien1 = new Alien(70,100);
		alien2 = new Alien(140,100);
		alien3 = new Alien(210,100);
		alien4 = new Alien(280,100);
		alien5 = new Alien(350,100);
		alien6 = new Alien(420,100);
		alien7 = new Alien(490,100);
		alien8 = new Alien(560,100);
		alien9 = new Alien(70,200);
		alien10 = new Alien(140,200);
		alien11 = new Alien(210,200);
		alien12 = new Alien(280,200);
		alien13 = new Alien(350,200);
		alien14 = new Alien(420,200);
		alien15 = new Alien(490,200);
		alien16 = new Alien(560,200);
		ammoTest = new Ammo(-100,-100,2);
		
		//int horderowsize = 8;
		//horde = new AlienHorde(horderowsize);
		//for (int i = 0;i < (horderowsize * 2);i++)
		//{
		//	int aax = (i + 1) * 70;
		//	int aay = 100;
		//	if (i >= horderowsize)
		//	{
		//		aay = 300;
		//		aax -= 560;
		//	}
		//	horde.add(new Alien(aax,aay,0));
		//}
		
		horde = new AlienHorde(8);
		horde.add(alien1);
		horde.add(alien2);
		horde.add(alien3);
		horde.add(alien4);
		horde.add(alien5);
		horde.add(alien6);
		horde.add(alien7);
		horde.add(alien8);
		horde.add(alien9);
		horde.add(alien10);
		horde.add(alien11);
		horde.add(alien12);
		horde.add(alien13);
		horde.add(alien14);
		horde.add(alien15);
		horde.add(alien16);	
		
		shots = new Bullets();
		
		SUPER_SHOT = false;
		ssdelay = 300;
		ssdelay = 16;
		

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
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

		graphToBack.setColor(Color.CYAN);
		graphToBack.drawString("StarFighter ", 125, 150 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);

		ship.draw(graphToBack);
			
		horde.drawEmAll(graphToBack);	
		
		for (Alien[] row : horde.getList())
		{
			for (Alien val : row)
			{
				if (val.getX() < 0 && val.getDownStart() == 0)
				{
					val.setRowDirection(1, val.getY());
				}
				if (val.getX() > 750 && val.getDownStart() == 0)
				{
					val.setRowDirection(2, val.getY());
				}
			}
		}
		
		ssdone = 16;
		for (Alien[] row : horde.getList())
		{
			for (Alien al : row)
			{
				if (al.getDead() == 1)
				{
					ssdone--;
				}
			}
		}
		if (ssdone == 0)
		{
			SUPER_SHOT = true;
		}
		
		if (SUPER_SHOT)
		{
			graphToBack.setColor(Color.RED);
			if (ssdelay >= 0)
			{
				graphToBack.drawString("SUPER", 300, 400);	
			}
			else if (ssdelay < -300)
			{
				ssdelay = 300;
			}
			else if (ssdelay < 0)
			{
				graphToBack.drawString("SHOT", 300, 400);
			}
			ssdelay--;
		}
		
		boolean pressedL = false;
		boolean pressedR = false;
		boolean pressedU = false;
		boolean pressedD = false;

		if(keys[0] == true && ship.getX() > 0 && !(pressedL) && !(pressedU) && !(pressedD))
		{
			pressedR = true;
			ship.move("RIGHT");
			horde.moveEmAll();
			shots.moveEmAll();
		}
		if(keys[1] == true && ship.getX() < 750 && !(pressedR) && !(pressedU) && !(pressedD))
		{
			pressedL = true;
			ship.move("LEFT");
			horde.moveEmAll();
			shots.moveEmAll();
		}
		if(keys[2] == true && ship.getY() > 0 && !(pressedL) && !(pressedU) && !(pressedR))
		{
			pressedD = true;
			ship.move("DOWN");
			horde.moveEmAll();
			shots.moveEmAll();
		}
		if(keys[3] == true && ship.getY() < 520 && !(pressedL) && !(pressedR) && !(pressedD))
		{
			pressedU = true;
			ship.move("UP");
			horde.moveEmAll();
			shots.moveEmAll();
		}
		//add code to move Ship, Alien, etc.
		
		if (!(keys[0]))
		{
			pressedR = false;
		}
		if (!(keys[1]))
		{
			pressedL = false;
		}
		if (!(keys[2]))
		{
			pressedD = false;
		}
		if (!(keys[3]))
		{
			pressedU = false;
		}
				
		
		if (keys[4])
		{
			shots.add(new Ammo(ship.getX() + 16,ship.getY(),2));
			horde.moveEmAll();
			shots.moveEmAll();
		}
		shots.cleanEmUp();

		shots.drawEmAll(graphToBack);
		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship
		for (int i = 0;i < shots.getList().size();i++)
		{
			for (Alien[] row : horde.getList())
			{
				for (Alien val : row)
				{
					if (shots.getList().get(i).getX() >= val.getX() &&
						shots.getList().get(i).getX() <= val.getX() + val.getWidth()
						 && shots.getList().get(i).getY() >= val.getY() && 
						 shots.getList().get(i).getY() <= val.getY() + val.getHeight())
					{
						shots.getList().get(i).setX(-100); shots.getList().get(i).setY(-100);
						val.setX(-100); val.setY(-100);
						val.setDead(1);
						shots.getList().get(i).setKilled(val);
					}
				}
			}
		}
		

		twoDGraph.drawImage(back, null, 0, 0);
		back = null;
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
        }
      }catch(Exception e)
      {
      }
  	}
}

