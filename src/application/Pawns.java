package application;

public class Pawns {
	private int location;	// holds location of pawn on board
	private String color;	// holds color of pawn
	
	/**
	 * Initializes pawns
	 * 
	 */
	public Pawns(String clr)
	{
		color = clr;
		setStart();
	}
	
	/**
	 * Sets pawn's location to its
	 * respective color's start
	 * 
	 */
	public void setStart()
	{
		if (color.equals("Green"))
		{
			location = 80;
		}
		else if (color.equals("Red"))
		{
			location = 81;
		}
		else if (color.equals("Blue"))
		{
			location = 82;
		}
		else
		{
			location = 83;
		}
	}
	
	public void setBeginning()
	{
		if (color.equals("Green"))
		{
			location = 4;
		}
		else if (color.equals("Red"))
		{
			location = 19;
		}
		else if (color.equals("Blue"))
		{
			location = 34;
		}
		else
		{
			location = 49;
		}	
	}
	
	public boolean isBeginning()
	{
		if(color.equals("Green") && location == 4)
		{
			return true;
		}
		else if(color.equals("Red") && location == 19)
		{
			return true;
		}
		else if(color.equals("Blue") && location == 34)
		{
			return true;
		}
		else if(color.equals("Yellow") && location == 49)
		{
			return true;
		}
		return false;
	}
	
	public boolean isStart()
	{
		if (location == 80 || location == 81 || location == 82 || location == 83)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isHome()
	{
		if (location == 84 || location == 85 || location == 86 || location == 87)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getLocation()
	{
		return location;
	}
	
	public void goFoward(int i)
	{
		if (location+i > 59) 
		{
			location = (location+i)-60;
		}
		else
		{
			location+=i;
		}
	}
}
