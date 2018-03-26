import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 * Models a clockhand that rotates around a dial/ clock face
 *
 */
public class ClockHand implements MoveableShape {
	private BasicStroke line;
	private int x, y;
	private int length;
	private double ang; // degrees N - 0, E - 90, S - 180, W - 270
	private Color c;

	/**
	 * Constructs a ClockHand with the given parameters
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

	/**
	 * Sets the angle of the clock hand to the passed in value
	 * 
	 * @param angle
	 * 		A double representing the angle to set
	 */
	public void setAngle(double angle) {
		this.ang = angle;
	}

	/**
	 * Rotates the clock hand a given amount
	 * 
	 * @param angle
	 * 		The angle in degrees to rotate the clock hand by
	 */
	public void rotate(double angle) {
		this.ang += angle;
		// Preventing overflow
		if (this.ang > 360)
			this.ang -= 360;
		if (this.ang < 0)
			this.ang += 360;
	}

	/**
	 * Gets the clock hand's current angle
	 * 
	 * @return
	 * 		A double representing the current angle of the hand
	 */
	public double getAngle() {
		return ang;
	}

}
