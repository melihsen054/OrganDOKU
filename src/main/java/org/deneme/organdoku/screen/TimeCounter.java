package org.deneme.organdoku.screen;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

// This is the time counter class for informing the player about time
public class TimeCounter extends JPanel implements ActionListener {
	public Timer clock;
	private int secs = 0;
	private int mins = 0;
	private int hrs = 0;
	private JLabel display;
	

	public static double timePoint = 0; // this pulls the time as seconds for
										// calculations
	private DecimalFormat dFormat = new DecimalFormat("00");

	public TimeCounter(){
		setLayout(new GridLayout(2, 1));
		setSize(200, 200);
		setLocation(600, 0);
		display = new JLabel();
		display.setFont(new Font("Verdana", Font.BOLD, 20));
		display.setForeground(Color.RED);
		add(display);
	
		clock = new Timer(10, this);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == clock) {
			secs++;
		}

		if (secs == 60) {
			mins++;
			secs = 0;
		}

		if (mins == 60) {
			hrs++;
			mins = 0;
			secs = 0;
		}

		if (hrs == 24) {
			hrs = 0;
			mins = 0;
			secs = 0;
		}
		
		
		display.setText(dFormat.format(hrs) + ":" + dFormat.format(mins) + "." + dFormat.format(secs));

		timePoint = hrs * 3600 + mins * 60 + secs;
	}

	protected JLabel getDisplay() {
		return display;
	}

	protected static double getTimePoint() {
		return timePoint;
	}
	
}