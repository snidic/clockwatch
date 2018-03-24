import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * A StopWatchDial 
 *
 */
public class StopWatchDial extends JPanel {
	private ClockFace face;
	private ClockHand hand;

	public StopWatchDial(int x, int y, int width, int scale) {
		face = new ClockFace(x, y, width, scale);
		hand = new ClockHand(x + width / 2, y + width / 2, width / 2, 2, Color.BLACK);
	}

	/**
	 * Rotates the Clockhand by ClockHand.Tick_Degree
	 */
	public void update() {
		hand.rotate(ClockHand.TICK_DEGREE);
	}

	/**
	 * Returns if Clockhand is at "0" degrees
	 * 
	 * @return true if Clockhand is at 0, false otherwise
	 */
	public boolean handAtZero() {
		return hand.handAtZero();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		face.paintComponent(g);
		hand.draw(g2);
	}

}
