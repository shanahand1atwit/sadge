package application;

public class Board {
	public Tiles[] boardArray = new Tiles[88];	// array holds all tiles on board
												// 0-59 Tiles around board
												// 60-79 Safety Zones
												// 80-83 Start
												// 84-87 Home
	
	public Board()
	{
		int colorCount = 0;
		for (int x = 0; x < boardArray.length; x++)
		{	
			if ((x==0) || (x>=5 && x<9) || (x>= 14 && x < 16) || (x>= 20 && x < 24)||
					(x>=29 && x<31) || (x>=35 && x<39) || (x>= 44 && x< 46) ||
					(x>= 50 && x < 54) || (x==59) || (x>= 60 && x <=64) || (x>= 65 && x <=69)
					|| (x>= 70 && x <=74) || (x>= 75 && x <=79))
			{
				boardArray[x] = new Tiles(x, 0);
				//System.out.println(boardArray[x].getTileNumber());
			}
			else if ((x>= 1 && x <= 4) || (x>= 9 && x <= 13) || (x>= 16 && x <= 19) ||
					(x>= 24 && x <= 28) || (x>= 31 && x <= 34) || (x>= 39 && x <= 43) ||
					(x>= 46 && x <= 49) || (x>= 54 && x <= 58))
			{
				if (colorCount >= 0 && colorCount <= 8)
				{
					boardArray[x] = new SlideTile(x, "GREEN");
					//System.out.println(boardArray[x].getTileNumber() + " " + (((SlideTile) boardArray[x]).getColor()));
				}
				else if (colorCount >= 9 && colorCount <= 17)
				{
					boardArray[x] = new SlideTile(x, "RED");
					//System.out.println(boardArray[x].getTileNumber() + " " + ((SlideTile) boardArray[x]).getColor());
				}
				else if (colorCount >= 18 && colorCount <= 26)
				{
					boardArray[x] = new SlideTile(x, "BLUE");
					//System.out.println(boardArray[x].getTileNumber() + " " + ((SlideTile) boardArray[x]).getColor());
				}
				else if (colorCount >= 27 && colorCount <= 35)
				{
					boardArray[x] = new SlideTile(x, "YELLOW");
					//System.out.println(boardArray[x].getTileNumber() + " " + ((SlideTile) boardArray[x]).getColor());
				}
				
				if (colorCount != 35)
				{
					colorCount++;
				}
				else
				{
					colorCount=0;
				}
			}
			else if ((x==80) || (x==81) || (x==82) || (x==83))
			{
				if (colorCount == 0)
				{
					boardArray[x] = new HomeTile(x, "GREEN");
					//System.out.println(boardArray[x].getTileNumber() + " " + ((HomeTile) boardArray[x]).getColor());
				}
				else if (colorCount == 1)
				{
					boardArray[x] = new HomeTile(x, "RED");
					//System.out.println(boardArray[x].getTileNumber() + " " + ((HomeTile) boardArray[x]).getColor());
				}
				else if (colorCount == 2)
				{
					boardArray[x] = new HomeTile(x, "BLUE");
					//System.out.println(boardArray[x].getTileNumber() + " " + ((HomeTile) boardArray[x]).getColor());
				}
				else if (colorCount == 3)
				{
					boardArray[x] = new HomeTile(x, "YELLOW");
					//System.out.println(boardArray[x].getTileNumber() + " " + ((HomeTile) boardArray[x]).getColor());
				}
				if (colorCount != 3)
				{
					colorCount++;
				}
				else
				{
					colorCount=0;
				}
			}
			else if ((x==84) || (x==85) || (x==86) || (x==87))
			{
				if (colorCount == 0)
				{
					boardArray[x] = new StartTile(x, "GREEN");
					//System.out.println(boardArray[x].getTileNumber() + " " + ((StartTile) boardArray[x]).getColor());
				}
				else if (colorCount == 1)
				{
					boardArray[x] = new StartTile(x, "RED");
					//System.out.println(boardArray[x].getTileNumber() + " " + ((StartTile) boardArray[x]).getColor());
				}
				else if (colorCount == 2)
				{
					boardArray[x] = new StartTile(x, "BLUE");
					//System.out.println(boardArray[x].getTileNumber() + " " + ((StartTile) boardArray[x]).getColor());
				}
				else if (colorCount == 3)
				{
					boardArray[x] = new StartTile(x, "YELLOW");
					//System.out.println(boardArray[x].getTileNumber() + " " + ((StartTile) boardArray[x]).getColor());
				}
				if (colorCount != 3)
				{
					colorCount++;
				}
				else
				{
					colorCount=0;
				}
			}
		}
	}
}
