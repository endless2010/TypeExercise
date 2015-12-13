import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;

public class TimerDemo implements ActionListener {
	Timer timer;
	JLabel label;
	int hours = 0, minutes = 0, seconds = -1;
	Words words;

	public TimerDemo() {
		timer = new Timer(1000, this);
	}

	public void actionPerformed(ActionEvent e) {

		seconds++;
		if (seconds == 60) {
			minutes++;
			seconds -= 60;
			if (minutes == 60) {
				hours++;
				minutes -= 60;

			}
		}
		if (seconds < 0) {
			words.timeField.setText("0");
		} else {
			words.timeField.setText(" ");
		}
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

}