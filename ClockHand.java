import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * You will need to implement a ClockHand class that does something like the
 * following. This will be used to draw the hands - minute, second, hour etc.
 * Make ClockHand a MoveableShape and use the Timer code from Chapter 4 to move
 * it. You will need to calculate the angle to move. ClockFace can give you an
 * idea. Use the Stroke interface to change the style of the hands.
 *
 */
public class ClockHand implements MoveableShape {
	private BasicStroke line;
	private int x, y;
	private int length;
	private double ang; // degrees N - 0, E - 90, S - 180, W - 360
	private Color c;

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

	// @Override
	// public void translate(int dx, int dy) {
	// x += dx;
	// y += dy;
	// }

	public void setAngle(double angle) {
		this.ang = angle;
	}

	public void rotate(double angle) {
		this.ang += angle;
		// Preventing overflow
		if (this.ang > 360)
			this.ang -= 360;
		if (this.ang < 0)
			this.ang += 360;
	}

	public double getAngle() {
		return ang;
	}

}
