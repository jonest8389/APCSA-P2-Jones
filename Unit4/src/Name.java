//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Name
{
	private String name;
	private int spaceindex;

	public Name()
	{

	}

	public Name(String s)
	{

		setName(s);

	}

   public void setName(String s)
   {
	   name = s;
	   spaceindex = s.indexOf(" ");
   }

	public String getFirst()
	{
		return name.substring(0, spaceindex);
	}

	public String getLast()
	{
		return name.substring((spaceindex + 1), name.length());
	}

 	public String toString()
 	{
 		return getFirst() + " " + getLast() + "\n";
	}
}