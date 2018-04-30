//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class StarFighterSuperShot extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public StarFighterSuperShot()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		SuperShot theGame = new SuperShot();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		StarFighterSuperShot run = new StarFighterSuperShot();
		System.out.println("SUPER SHOT");
	}
}