package chicken;

import shot.BlackShot;
import shot.BlueShot;
import shot.RedShot;
import shot.YellowShot;

public interface Visitor {

	void visit(YellowShot yellowShot);
	void visit(RedShot redShot);
	void visit(BlackShot blackShot);
	void visit(BlueShot blueeShot);

}
