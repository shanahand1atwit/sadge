package application;

public class StartTile extends Tiles{

	private String color;
	public StartTile(int tn, String clr) {
		super(tn, 4);
		color = clr;
	}
	public String getColor()
	{
		return color;
	}
}
