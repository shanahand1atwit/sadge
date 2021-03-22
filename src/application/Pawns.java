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
		if (color.equals("Red"))
		{
			location = 60;
		}
		else if (color.equals("Blue"))
		{
			location = 61;
		}
		else if (color.equals("Green"))
		{
			location = 62;
		}
		else
		{
			location = 63;
		}
	}
}
