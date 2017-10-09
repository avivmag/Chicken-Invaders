package shot;

import chicken.Visitor;

public class BlueShot extends Shot{

	public BlueShot() {
		super("blue");
	}

	@Override
	public void shooting(Visitor v)
	{
		v.visit(this);
	}

}
