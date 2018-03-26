import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Date;

import javax.swing.Icon;

/**
 * Models a clock with a face and hands for hours, minutes, and seconds.
 * The clock is initialized to the system time.
 *
 */
public class MyClock implements Icon {
	private ClockFace face;
	private ClockHand hr;
	private ClockHand min;
	private ClockHand sec;
	private int width;
	public static final double TICK_DEGREE = 6;

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
	@SuppressWarnings("deprecation")
	public MyClock(int x, int y, int width, Date d) {
		face = new ClockFace(x, y, width);
		hr = new ClockHand(width / 2, width / 2, width / 4, 6, Color.BLACK);
		min = new ClockHand(width / 2, width / 2, (int) (width / 2.4), 5, Color.BLACK);
		sec = new ClockHand(width / 2, width / 2, (int) (width / 2.15), 2, Color.RED);

		// Setting the hands to the correct positions
		hr.setAngle(((d.getHours() % 24) / 12.0 * 360) + d.getMinutes() * TICK_DEGREE / 12.0);
		min.setAngle((d.getMinutes() / 60.0 * 360));
		sec.setAngle((d.getSeconds() / 60.0 * 360));
		this.width = width;
	}

	/**
	 * Rotates the second hand. If it is a new minute, also rotate the minute
	 * and hour hands
	 */
	public void update() {
		sec.rotate(TICK_DEGREE);
		if (sec.getAngle() % 360 == 0) {
			min.rotate(TICK_DEGREE);
			hr.rotate(TICK_DEGREE / 12.0);
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
