package application;

public class GenericPlayer {
	private String name;
	private String color;
	private Pawns[] playerPawns = new Pawns[4];

	public GenericPlayer(String nm, String clr)
	{
		name = nm;
		color = clr;
		for (int x =0; x<playerPawns.length; x++)
		{
			playerPawns[x] = new Pawns(color);
		}
	}

}
