import java.awt.Stroke;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**class that creates follower bees
 * extends the Bee class 
 * @author depew
 *
 */
public class Follower extends Bee {
	private Bee follower;
	private BeeWindow window;
	private QueenBee queen;
	private Point2D queenLocation;
	private Point2D followerLocation;
	private double p;
	private double speed;
	private Point2D startDirection;
	private Point2D direction;
	private Point2D targetDirection;
	private Point2D dir1;
	private Point2D dir2;
	
	/** takes window and queen as parameter so that the follower will show 
	 * up in window and sets a specific bee as their queen
	 * @param window
	 * @param queen
	 */
	
	public Follower(BeeWindow window, QueenBee queen) {
		super(window);
		this.queen = queen;
	}
	/**overrides the update method in Bee so that the followers will follow their queen
	 * finds queen location  normalizes it to a vector then changes that vector by a random
	 * value p 
	 * changes speed to slow down as followers get closer
	 */
	
	@Override 
	public void update(){
		queenLocation = queen.getLocation();
		followerLocation = this.getLocation();
		p = Math.random()*.3;
		speed = Math.min(p*(followerLocation.distance(queenLocation)),15);
		startDirection = this.getDirection();
		targetDirection = queenLocation.subtract(followerLocation).normalize();
		dir1 = targetDirection.multiply(p);
		dir2 = startDirection.multiply(1.0-p);
		direction =dir1.add(dir2);
		direction = direction.normalize();
		setDirection(direction);
		setSpeed(speed);
		move();
		
	
	}
		
	}

