//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapePanel extends JPanel
{
	public ShapePanel()
	{
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	/*
	 *All of your test code should be placed in paint.
	 */
	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("CREATE YOUR OWN SHAPE!",40,40);


		//instantiate a Shape
		//tell your shape to draw
		  window.setColor(Color.BLACK);
		  window.drawOval(249, 149, 301, 301);
		  window.drawOval(250, 150, 301, 301);
		  
	      window.setColor(Color.YELLOW);
	      window.drawOval(250, 150, 300, 300);
	      window.fillOval(250, 150, 300, 300);
	      
	      window.setColor(Color.BLACK);
	      window.drawOval(300, 230, 50, 50);
	      window.fillOval(300, 230, 50, 50);
	      window.drawOval(440, 230, 50, 50);
	      window.fillOval(440, 230, 50, 50);
	      
	      window.drawLine(280, 225, 350, 230);
	      window.drawLine(280, 224, 350, 230);
	      window.drawLine(280, 223, 350, 230);
	      window.drawLine(438, 210, 490, 205);
	      window.drawLine(438, 210, 490, 206);
	      window.drawLine(438, 210, 490, 207);
	      
	      window.drawLine(340, 380, 400, 380);
	      window.drawLine(340, 381, 400, 381);
	      
	      window.drawString("(X) Doubt", 500, 460);
		//instantiate a Shape
		//tell your shape to draw

		//instantiate a Shape
		//tell your shape to draw
	}
}