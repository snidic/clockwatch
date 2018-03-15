import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

/**
 * This program implements an animation that moves a car shape.
 * 
 * Clicking on clock or stopwatch should switch the display to the correct
 * component. Only one of them should be visible at any time (either clock or
 * stopwatch).
 * 
 * Please submit all java files and a runnable jar of your program
 * 
 * A README file with all the team members names and StudentIDs. Any additional
 * communication to me or the grade
 */
public class ClockTester {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		// ClockFace icon = new ClockFace(0, 0, CLOCK_RADIUS);
		MyClock myClock = new MyClock(0, 0, CLOCK_RADIUS, new Date());
		JLabel icon = new JLabel(myClock);

		Stopwatch stop = new Stopwatch(0, 0, CLOCK_RADIUS);
		// JLabel icon2 = new JLabel(stop);
		// icon2.setEnabled(false);

		frame.setLayout(new BorderLayout());
		frame.add(icon, BorderLayout.CENTER);
		// frame.add(icon2, BorderLayout.CENTER);
		frame.getContentPane().setBackground(Color.YELLOW);

		JPanel topNav = new JPanel(new FlowLayout());

		// TODO: Buttons should show correct active frame
		JButton clock = new JButton("clock");
		clock.addActionListener((event) -> {
			icon.setEnabled(true);
			// icon2.setEnabled(false);
			frame.getContentPane().setBackground(Color.YELLOW);
		});

		JButton stopwatch = new JButton("stopwatch");
		stopwatch.addActionListener((event) -> {
			icon.disable();
			icon.setEnabled(false);
			// icon2.setEnabled(true);
			frame.getContentPane().setBackground(Color.CYAN);
		});

		topNav.add(clock);
		topNav.add(stopwatch);
		frame.add(topNav, BorderLayout.NORTH);
		// icon2.repaint();
		icon.repaint();

		// TODO: listeners
		ActionListener clockListener = (event) -> {
			myClock.update();
			icon.repaint();
		};
		Timer clockTimer = new Timer(1000, clockListener);

		ActionListener stopwatchListener = (event) -> {
			// icon2.repaint();
		};
		Timer stopwatchTimer = new Timer(1000, stopwatchListener);

		clockTimer.start();
		stopwatchTimer.start();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

	private static final int CLOCK_RADIUS = 500;
}
