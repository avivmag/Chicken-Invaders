package shot;

import chicken.Visitor;

public class RedShot extends Shot{

	public RedShot() {
		super("red");
	}

	@Override
	public void shooting(Visitor v) 
	{
		v.visit(this);	
	}

}
