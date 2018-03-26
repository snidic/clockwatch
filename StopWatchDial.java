import java.awt.*;

/**
 * Models a dial on the stopwatch. Each dial only has a 
 * clockface and a hand representing the current time passed.
 * 
 */
public class StopWatchDial {
	private ClockFace face;
	private ClockHand hand;
	
	/**
	 * Constructs a new stopwatch dial with the given position and diameter
	 * 
	 * @param x 
	 * 		Horizontal position for the dial to be drawn
	 * @param y 
	 * 		Vertical position for the dial to be drawn
	 * @param width 
	 * 		Diameter of the dial
	 */
	public StopWatchDial (int x, int y, int width) {
		face = new ClockFace(x, y, width, 5);
		hand = new ClockHand(x + width / 2, y + width / 2, (int) (width / 2.15), 2, Color.RED);
	}
	
	/**
	 * Moves the hand of the dial forward one tick (6 degrees)
	 */
	public void tick () {
		hand.rotate(MyClock.TICK_DEGREE);
	}
	
	/**
	 * Resets the stopwatch to its initial position
	 */
	public void reset() {
		hand.setAngle(0);
	}
	
	/**
	 * Get's the current angle of the dial hand.
	 * 
	 * @return 
	 * 		A double representing the degrees the hand is pointing towards
	 */
	public double getDegree() {
		return hand.getAngle();
	}
	
	/**
	 * Draws the dial
	 * 
	 * @param g 
	 * 		Graphics module in which drawing happens
	 */
	public void paintComponent (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		face.paintComponent(g2);
		hand.draw(g2);
	}
	
}
