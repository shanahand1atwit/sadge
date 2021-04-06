package application;

public class Pawns {
	private int location;	// holds location of pawn on board
	private String color;	// holds color of pawn
	private boolean inStart=true;	// tells if pawn is at start
	private boolean inHome=false;	// tells if pawn is at home
	
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
}
