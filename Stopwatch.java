import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Icon;

/**
 * Models a stopwatch with two dials. The inner dial keep track of the minutes
 * pass while the outer dial tracks the seconds.
 */
public class Stopwatch implements Icon {
	
	// Class instance variables
	private StopWatchDial outer;	// Outer dial modeling seconds
	private StopWatchDial inner;	// Inner dial modeling minutes
	private int width;	// Diameter of the stopwatch

	/**
	 * Constructs a new stopwatch at the given coordinates and width
	 * 
	 * @param x
	 * 		X position of stopwatch
	 * @param y
	 * 		Y position of stopwatch
	 * @param width
	 * 		Diameter of the stopwatch
	 */
	public Stopwatch(int x, int y, int width) {
		this.width = width;
		outer = new StopWatchDial(x, y, width);
		inner = new StopWatchDial(x + width/4, y / 2 + 50, width / 2);
	}

	/**
	 * Updates the outer dial hand and inner after one revolution
	 */
	public void update() {
		outer.tick();
		if (outer.getDegree() % 360 == 0) {
			inner.tick();
		}
	}
	
	/**
	 * Resets the stopwatch to 0
	 */
	public void reset() {
		outer.reset();
		inner.reset();
	}

	@Override
	public int getIconHeight() {
		return width;
	}

	@Override
	public int getIconWidth() {
		return width;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		outer.paintComponent(g2);
		inner.paintComponent(g2);
	}
}
