
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * 
 * @author depew
 *
 */
public class BeeWindow extends DrawingPane {
	private Follower[] followers = new Follower[40];
	private Follower[] followers1 = new Follower[40];
	private QueenBee queen = new QueenBee(this);
	private QueenBee queen1 = new QueenBee(this);
	
	/**
	 * Creates a window. The window has a specific background color, and 
	 * calls update at a specific interval (in milliseconds) specified
	 * via the parameters to the super class constructor called in 
	 * super(...).
	 */
	public BeeWindow() {
		super(50, Color.BLACK);
	}

	/**
	 * This method is called when the window has appeared, and is finished
	 * initializing.
	 */
	@Override
	public void start() {
		for (int i = 0; i < followers.length; i++) {
			followers[i] = new Follower(this, queen);
		}
		for (int i = 0; i < followers1.length; i++){
			followers1[i] = new Follower(this,queen1);
		}
	}

	
	

	/**
	 * This method is called at regular intervals, according to the time
	 * interval set in the constructor.
	 */
	@Override
	public void update() {
		queen.update();
		queen.setColor(Color.GREY);
		queen1.update();
		queen1.setColor(Color.MEDIUMAQUAMARINE);
		
		for (Follower follower : followers) {
			follower.update();
		}
		for (int i = 0; i < followers1.length; i++){
			followers1[i].update();
			followers1[i].setColor(Color.CORAL);
		}
	
		
		

	}

	/**
	 * Launch the window. When the window is ready, start() will be called. After
	 * start() is finished, update() will start to be called at regular intervals.
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}


}


