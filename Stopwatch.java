import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

import javax.swing.Icon;
import javax.swing.JPanel;

/**
 * You will need to implement a Stopwatch class that has two dials - one for
 * outer and one for inner dials (see figure below. The sample does not show the
 * hand but yours should) You may adjust the center of the two dials so that it
 * is offset as shown in figure below.
 * 
 * The Stopwatch should also use the timer and actually counts seconds. For
 * every revolution of the outer dial, the inner dial advances by one tick.
 *
 */
public class Stopwatch implements Icon {
	private StopWatchDial outer;
	private StopWatchDial inner;
	private int x;
	private int y;
	private int width;

	public Stopwatch(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
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
		// TODO Auto-generated method stub

	}
}
