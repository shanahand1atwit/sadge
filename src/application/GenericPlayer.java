package application;

public class GenericPlayer {
	private String name;	// holds player's name
	private String color;	// hold color of player
	public Pawns[] playerPawns = new Pawns[4];	// holds player's four pawns

	/**
	 * Initializes GenericPlayer
	 * 
	 */
	public GenericPlayer(String nm, String clr)
	{
		name = nm;
		color = clr;
		
		// for loop creates 4 pawns for player
		for (int x =0; x<playerPawns.length; x++)
		{
			playerPawns[x] = new Pawns(color);
			playerPawns[x].setStart();
		}
	}
	
	public int getPawnSize()
	{
		return playerPawns.length;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public boolean isStart(int i)
	{
		if (playerPawns[i].isStart())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hasInfront(int i,int r)
	{
		for (Pawns z : playerPawns)
		{
			if(playerPawns[i].getLocation() != z.getLocation() && 
			   playerPawns[i].getLocation()+r == z.getLocation())
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean hasStart()
	// checks if any pieces are on start
	// return true if a piece is
	{
		for (Pawns p : playerPawns)
		{
			if (p.isStart())
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean hasBeginning()
	{
		for (Pawns p : playerPawns)
		{
			if (p.isBeginning())
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean hasBoard()
	// checks if any pieces are on board
	// returns false if none on board
	{
		int totalUnaccounted = 0;
		for (Pawns p : playerPawns)
		{
			if (p.isStart() || p.isHome())
			{
				totalUnaccounted++;
			}
		}
		
		if (totalUnaccounted == playerPawns.length)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
