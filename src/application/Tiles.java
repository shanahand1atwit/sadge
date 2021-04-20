package application;

public class Tiles 
{
	private int tileNumber;
	private int pawnCount;
	
	public Tiles(int tn, int pwnCnt)
	{
		tileNumber = tn;
		pawnCount = pwnCnt;
	}
	
	/**
	 * Checks if tile has two
	 * pieces on it
	 * 
	 * @param none
	 * @return true if there's two pieces, false if not
	 */
	public boolean hasTwo()
	{
		if (pawnCount==2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Adds pawn to pawn count
	 * 
	 * @param none
	 * @return none
	 */
	public void addPawn()
	{
		pawnCount++;
	}
	
	/**
	 * Removes pawn from pawn count
	 * 
	 * @param none
	 * @return none
	 */
	public void removePawn()
	{
		pawnCount--;
	}
	
	/**
	 * Gets number of tile
	 * 
	 * @param none
	 * @return int of tile number
	 */
	public int getTileNumber()
	{
		return tileNumber;
	}

}
