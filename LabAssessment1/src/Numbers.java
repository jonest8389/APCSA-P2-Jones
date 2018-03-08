public class Numbers
{
	public static boolean isGoofy(int num)
	{
		String gS = Integer.toString(num);
		int gSum = 0;
		for (int i = 0;i < gS.length();i++)
		{
			int ca = (int)gS.charAt(i);
			ca = ca - 48;
			if (ca != 0)
			{
				if (num % ca == 0)
				{
					gSum = gSum + ca;
				}
			}
		}
		if (gSum % 2 != 0)
		{
			return true;
		}
		return false;
	}
	public static int[] getSomeGoofyNumbers(int count)
	{
		int[] returncount = new int[(count + 1)];
		int countsat = 0;
		int iter = 0;
		int listiter = 0;
		while (countsat < count)
		{
			iter++;
			if (isGoofy(iter) == true)
			{
				returncount[listiter] = iter;
				listiter++;
				countsat++;
			}
		}
		String returner = "";
		for (int i = 0;i < returncount.length;i++)
		{
			if (returncount[i] != 0)
			{
				returner = returner + returncount[i] + " ";
			}
		}
		System.out.println(returner);
		return returncount;
	}
}