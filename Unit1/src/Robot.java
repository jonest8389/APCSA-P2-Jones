//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
   public Robot()    //constructor method - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);   	
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      window.setColor(Color.BLUE);

      window.drawString("Robot LAB ", 35, 35 );

      //call head method
      
      window.setColor(Color.GRAY);
      window.drawRect(250, 150, 250, 350);
      window.fillRect(250, 150, 250, 350);
      window.setColor(Color.BLACK);
      window.drawRect(249, 149, 251, 351);
      window.drawRect(342, 134, 65, 15);
      window.setColor(Color.LIGHT_GRAY);
      window.fillRect(343, 135, 64, 14);
      window.setColor(Color.BLACK);
      window.drawRect(366, 64, 16, 70);
      window.setColor(Color.GRAY);
      window.fillRect(367, 65, 15, 69);
      window.setColor(Color.BLACK);
      window.drawOval(355, 25, 39, 39);
      window.setColor(Color.LIGHT_GRAY);
      window.fillOval(356, 26, 38, 38);
      
      window.setColor(Color.BLACK);
      window.drawRect(260, 250, 230, 80);
      window.setColor(Color.LIGHT_GRAY);
      window.fillRect(261, 251, 229, 79);
      window.setColor(Color.BLACK);
      window.fillRect(265, 255, 220, 70);
      window.setColor(Color.WHITE);
      window.fillRect(310, 258, 65, 64);
      window.fillRect(377, 258, 65, 64);
      window.setColor(Color.BLACK);
      window.fillRect(332, 280, 20, 20);
      window.fillRect(399, 280, 20, 20);
      
      window.drawRect(270, 380, 210, 90);
      window.setColor(Color.WHITE);
      window.fillRect(271, 381, 209, 89);
      window.setColor(Color.BLACK);
      window.drawLine(299, 380, 299, 470);
      window.drawLine(300, 380, 300, 470);
      window.drawLine(301, 380, 301, 470);
      
      window.drawLine(348, 380, 348, 470);
      window.drawLine(349, 380, 349, 470);
      window.drawLine(350, 380, 350, 470);
      
      window.drawLine(397, 380, 397, 470);
      window.drawLine(398, 380, 398, 470);
      window.drawLine(399, 380, 399, 470);
      
      window.drawLine(446, 380, 446, 470);
      window.drawLine(447, 380, 447, 470);
      window.drawLine(448, 380, 448, 470);
      
      window.drawLine(270, 400, 480, 400);
      window.drawLine(270, 401, 480, 401);
      window.drawLine(270, 402, 480, 402);
      
      window.drawLine(270, 450, 480, 450);
      window.drawLine(270, 449, 480, 449);
      window.drawLine(270, 448, 480, 448);
      
      //call other methods
      
   }

   public void head( Graphics window )
   {
      window.setColor(Color.YELLOW);

      window.fillOval(300, 100, 200, 100);


		//add more code here
				
   }

   public void upperBody( Graphics window )
   {

		//add more code here
   }

   public void lowerBody( Graphics window )
   {

		//add more code here

   }
}