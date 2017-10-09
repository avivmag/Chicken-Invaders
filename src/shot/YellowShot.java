package shot;

import chicken.Visitor;

public class YellowShot extends Shot{

	public YellowShot() {
		super("yellow");
	}

	public void shooting(Visitor v)
	{
		v.visit(this);
	}

}
