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
 * A stop watch
 *
 */
public class Stopwatch implements Icon {
	private StopWatchDial outer;
	private StopWatchDial inner;
	private int width;

	public Stopwatch(int x, int y, int width) {
		this.width = width;
		outer = new StopWatchDial(x, y, width, 5);
		inner = new StopWatchDial(x + width / 4, y + width / 4, width / 2, 5);
	}

	/**
	 * Updates the outer dial hand and inner after one revolution
	 */
	public void update() {
		outer.update();
		if (outer.handAtZero()) {
			inner.update();
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
		outer.paintComponent(g);
		inner.paintComponent(g);
	}
}
