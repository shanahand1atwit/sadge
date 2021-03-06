package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck
{
	private ArrayList<Integer> cards;
			
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
		int c = cards.get(0);
		//System.out.println(c);
		cards.remove(0);
		//System.out.println(cards);
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
		
		//System.out.println(cards);
		Collections.shuffle(cards);
		//System.out.println(cards);
	}

}
