package application;

public class SlideTile extends Tiles{
	
	private boolean isStart = false;
	private int length;
	private String color;
	
	public SlideTile(int tn, String cl) {
		super(tn, 0);
		color = cl;
		if (tn == 1 || tn == 16 || tn == 31 || tn == 46)
		{
			isStart = true;
			length = 4;
		}
		else if (tn == 9 || tn == 24 || tn == 39 || tn == 54)
		{
			isStart = true;
			length = 5;
		}
	}
	
	public String getColor()
	{
		return color;
	}

}
