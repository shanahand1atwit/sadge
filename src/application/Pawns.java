package application;

public class Pawns {
	private int location;
	private String color;
	private boolean inHome=false;
	
	public Pawns(String clr)
	{
		color = clr;
		setHome();
	}
	
	public void setHome()
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
