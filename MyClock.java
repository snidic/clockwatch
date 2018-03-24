import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.JPanel;

/**
 * You will need to implement a MyClock class that aggregates both ClockFace and
 * 3 instances of ClockHand (one each for minute, hour and second. Make sure you
 * use appropriate color and thickness for the three hands). Think about what
 * you can save in ClockHand to achieve this.
 * 
 * The clock should actually show the time. You can get the time from Date and
 * use that to position the hands. Setup a timer for 1 second but don't count
 * seconds yourself.
 *
 */
public class MyClock implements Icon {
	private ClockFace face;
	private ClockHand hr;
	private ClockHand min;
	private ClockHand sec;
	private int width;

	/**
	 * Constructs a MyClock
	 * 
	 * @param x
	 *            Bounding rectangle left
	 * @param y
	 *            Bounding rectangle top
	 * @param width
	 *            Size of the rectangle
	 * @param d
	 *            Current Date
	 */
	public MyClock(int x, int y, int width, Date d) {
		face = new ClockFace(x, y, width);
		hr = new ClockHand(width / 2, width / 2, width / 4, 5, Color.BLACK);
		min = new ClockHand(width / 2, width / 2, width / 3, 5, Color.BLACK);
		sec = new ClockHand(width / 2, width / 2, width / 2, 2, Color.RED);

		// Setting the hands to the correct positions
		hr.rotate(((d.getHours() % 24) / 12.0 * 360) + d.getMinutes() * ClockHand.TICK_DEGREE / 12.0);
		min.rotate((d.getMinutes() / 60.0 * 360));
		sec.rotate((d.getSeconds() / 60.0 * 360));
		this.width = width;
	}

	/**
	 * Rotates the second hand. If it is a new minute, also rotate the minute
	 * and hour hands
	 */
	public void update() {
		sec.rotate(ClockHand.TICK_DEGREE);
		if (sec.handAtZero()) {
			min.rotate(ClockHand.TICK_DEGREE);
			hr.rotate(ClockHand.TICK_DEGREE / 12.0);
		}
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
		face.paintComponent(g);
		hr.draw(g2);
		min.draw(g2);
		sec.draw(g2);
	}
}
