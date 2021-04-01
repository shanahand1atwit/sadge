package application;

import java.util.ArrayList;
import java.util.Random;


public class Deck
{
	private Random rand = new Random();
	public ArrayList<Integer> cards;
			
	public Deck()	{
		cards = new ArrayList<Integer>(45);
		populateDeck();
	}
	
	public int deckSize()
	{
		return cards.size();
	}
	
	public int draw()
	{
		int random = rand.nextInt(cards.size());
		int c = cards.get(random);
		cards.remove(random);
		return c;
	}
	
	public void shuffle()
	{
		populateDeck();
	}
	
	private void populateDeck()	{
		cards.clear();
		
		int currentNum = 0;
		
		for (int x = 0; x<45; x++)
		{
			if (currentNum==6 || currentNum == 9)
			{
				currentNum++;
			}
			
			if (x==8)
			{
				cards.add(1);
			}
			else
			{
				cards.add(currentNum);
			}
			
			if ((x+1)%4 == 0 && x <9)
			{
				currentNum++;
			}
			else if (x%4 == 0 && x>8)
			{
				currentNum++;
			}	
		}
	}

}
