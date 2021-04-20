package application;

public class GameStorage {
	
	private static int playerCount;
	private static Players[] playerArray = new Players[playerCount];
	
	public Players[] getPlayerArray()
	{
		return playerArray;
	}
	
	public void setPlayerCount(int x)
	{
		playerCount = x;
	}
	
	public void setPlayerArray(Players[] p)
	{
		playerArray = p;
	}
	
}
