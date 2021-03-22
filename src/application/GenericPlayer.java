package application;

public class GenericPlayer {
	private String name;	// holds player's name
	private String color;	// hold color of player
	private Pawns[] playerPawns = new Pawns[4];	// holds player's four pawns

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
		}
	}

}
