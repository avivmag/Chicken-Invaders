package shot;

import chicken.Visitor;

public class BlackShot extends Shot{

	public BlackShot() {
		super("black");
	}

	@Override
	public void shooting(Visitor v)
	{
		v.visit(this);
	}

}
