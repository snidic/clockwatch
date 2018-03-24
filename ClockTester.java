import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

/**
 * Tester that launches an application that contains a clock and a stop watch
 *
 */
public class ClockTester {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		// Creating Clock
		MyClock myClock = new MyClock(0, 0, CLOCK_RADIUS, new Date());
		JLabel icon = new JLabel(myClock);

		// Creating Stopwatch
		Stopwatch stop = new Stopwatch(0, 0, CLOCK_RADIUS);
		JLabel icon2 = new JLabel(stop);

		// Default to Clock
		frame.setLayout(new BorderLayout());
		frame.add(icon, BorderLayout.CENTER);
		frame.getContentPane().setBackground(Color.YELLOW);
		JPanel topNav = new JPanel(new FlowLayout());

		// clock button action
		JButton clock = new JButton("clock");
		clock.addActionListener((event) -> {
			swapLabel(frame, icon2, icon, Color.YELLOW);
		});

		// stopwatch button action
		JButton stopwatch = new JButton("stopwatch");
		stopwatch.addActionListener((event) -> {
			swapLabel(frame, icon, icon2, Color.CYAN);
		});

		// Adding the buttons
		topNav.add(clock);
		topNav.add(stopwatch);
		frame.add(topNav, BorderLayout.NORTH);

		// Timer for updating the clocks
		ActionListener clockListener = (event) -> {
			myClock.update();
			stop.update();
			frame.repaint();
		};
		Timer clockTimer = new Timer(999, clockListener);
		clockTimer.start();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

	/**
	 * Deactivates the original label and adds the new label for a frame
	 * 
	 * @param frame
	 *            to be acted on
	 * @param orig
	 *            label to be removed
	 * @param change
	 *            label to be added
	 * @param c
	 *            color of the background of frame
	 */
	private static void swapLabel(JFrame frame, JLabel orig, JLabel change, Color c) {
		frame.remove(orig);
		frame.add(change, BorderLayout.CENTER);
		frame.getContentPane().setBackground(c);
		frame.revalidate();
		frame.repaint();
	}

	private static final int CLOCK_RADIUS = 500;
}
