package application;

public class HomeTile extends Tiles{

	private String color;
	public HomeTile(int tn, String clr) {
		super(tn, 0);
		color = clr;
	}

	public String getColor()
	{
		return color;
	}
}
