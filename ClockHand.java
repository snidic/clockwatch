import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * A Clock hand
 *
 */
public class ClockHand implements MoveableShape {
	private BasicStroke line;
	private int x, y;
	private int length;
	private double ang; // degrees N - 0, E - 90, S - 180, W - 270
	private Color c;
	public static final double TICK_DEGREE = 6;

	/**
	 * Constructs a ClockHand
	 * 
	 * @param x
	 *            Origin x
	 * @param y
	 *            Origin y
	 * @param length
	 *            length of the hand
	 * @param width
	 *            thickness of the hand
	 * @param c
	 *            color of the hand
	 */
	public ClockHand(int x, int y, int length, int width, Color c) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.ang = 0;
		this.line = new BasicStroke(width);
		this.c = c;
	}

	@Override
	public void draw(Graphics2D g2) {
		// Calculate the hand's end point
		double rad = Math.toRadians(ang);
		int cx = (int) (length * Math.sin(rad)) + x;
		int cy = (int) -(length * Math.cos(rad)) + y;
		Line2D.Double hand = new Line2D.Double(x, y, cx, cy);

		g2.setStroke(line);
		g2.setColor(c);
		g2.draw(hand);
	}

	/**
	 * Rotates angle by the specified amount clockwise
	 * 
	 * @param angle
	 *            degrees to be rotated
	 */
	public void rotate(double angle) {
		this.ang += angle;
		// Preventing overflow of ang
		if (this.ang > 360 || this.ang < 0)
			this.ang %= 360;
	}

	public boolean handAtZero() {
		return ang % 360 == 0;
	}

}
