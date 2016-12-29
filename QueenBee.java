import javafx.geometry.Point2D;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

/** class that creates the queen bee for the follower bees to follow 
 * extends bee so that it can inherit its methods
 * 
 * @author depew
 *
 */
public class QueenBee extends Bee{
	private BeeWindow window;
	private Bee queen;
	private double xTarget;
	private double yTarget;
	private Point2D target;
	private Point2D direction;
	private Point2D direction1;
	
	/**method that takes the BeeWindow as a parameter for the queen to appear in.
	 * sets the target direction to random numbers within the window
	 * 
	 * @param window
	 */

	public QueenBee(BeeWindow window) {
		super(window);
		this.window = window;
		xTarget = Math.random()*window.xWindowSize();
		yTarget = Math.random()*window.yWindowSize();
		target = new Point2D(xTarget,yTarget);
		direction = target.subtract(this.getLocation()).normalize();
		setDirection(direction);

	

	}
	
	/** overrides the update method created in the Bee class
	 * if the queen bee gets within 60 pixels of its current target than 
	 * the target will be changed and therefore the direction
	 * called every 50 milliseconds so that the target continues to change
	 */
	@Override
	public void update(){
		if ((this.getLocation().distance(target))< 100){
			xTarget = Math.random()*window.xWindowSize();
			yTarget = Math.random()*window.yWindowSize();
			target = new Point2D(xTarget,yTarget);
			direction1 = target.subtract(this.getLocation()).normalize();
			setDirection(direction1);
			
		}
		else{
			direction = target.subtract(this.getLocation()).normalize();
			setDirection(direction);
		}
	
		setSpeed(15.0);
		move();
	}
}

	