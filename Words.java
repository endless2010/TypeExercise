import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Words implements ItemListener, ActionListener, ChangeListener {
	JComboBox comboBox;
	JLabel time, progress, accuracy, speed;
	JTextField timeField;
	JTextField accuracyField;
	JTextField speedField;
	JLabel title;
	JTextArea showArea;
	JTextArea typeArea;
	JProgressBar progressBar;
	JFrame frame;
	String content = "";
	int Finish = 0;
	int count = 0;
	int index = -1;
	int flag = 0;
	Timer timer;
	int minutes = 0;
	int seconds = -1;
	int hours = 0;
	int countAcc = 0;
	int FinalSeconds = 0;
	int FinalMinutes = 0;
	int FinalTime = 0;
	int useId = 0;
	int level = 0;
	int countKeyTyped = 0;
	String levelString = "";

	public Words() {

		frame = new JFrame();
		timer = new Timer(1000, this);
		Container contentPane = frame.getContentPane();
		time = new JLabel("时间");
		progress = new JLabel("     进度");
		accuracy = new JLabel("     正确率");
		speed = new JLabel("     速度");
		title = new JLabel("     英文文章练习");
		timeField = new JTextField(10);
		accuracyField = new JTextField(10);
		speedField = new JTextField(10);

		progressBar = new JProgressBar();
		progressBar.setOrientation(JProgressBar.HORIZONTAL);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setValue(0);
		progressBar.setForeground(Color.blue);
		progressBar.setBackground(Color.green);
		progressBar.setStringPainted(true);
		progressBar.addChangeListener(this);
		String[] s = { "1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt",
				"7.txt", "8.txt", "9.txt,", "10.txt" };
		comboBox = new JComboBox(s);
		comboBox.setBorder(BorderFactory.createTitledBorder("选择文章"));
		comboBox.setSelectedItem("2.txt");
		comboBox.addItemListener(this);
		JPanel headPanel = new JPanel();
		headPanel.setLayout(new FlowLayout());

		headPanel.add(time);
		headPanel.add(timeField);
		headPanel.add(speed);
		headPanel.add(speedField);
		headPanel.add(accuracy);
		headPanel.add(accuracyField);
		headPanel.add(progress);
		headPanel.add(progressBar);
		headPanel.add(comboBox);

		showArea = new JTextArea(200, 100);
		typeArea = new JTextArea(200, 100);
		showArea.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 20));
		typeArea.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 20));
		showArea.setLineWrap(true);
		showArea.setEditable(false);
		typeArea.setLineWrap(true);

		showArea.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.black, 1), "",
				TitledBorder.CENTER, TitledBorder.TOP));
		typeArea.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createLineBorder(Color.black, 1), "Type here",
				TitledBorder.LEFT, TitledBorder.TOP));
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(showArea);
		panel.add(typeArea);

		typeArea.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				count++;
				if (Finish != 1) {
					char temp = e.getKeyChar();
					if (('a' - 1 < temp && temp < 'z' + 1)
							|| ('A' - 1 < temp && temp < 'Z' + 1)
							|| temp == KeyEvent.VK_SPACE
							|| temp == KeyEvent.VK_PERIOD
							|| temp == KeyEvent.VK_COMMA || temp == '1'
							|| temp == '2' || temp == '3' || temp == '4'
							|| temp == '5' || temp == '6' || temp == '7'
							|| temp == '8' || temp == '9' || temp == '['
							|| temp == ']' || temp == '-' || temp == '='
							|| temp == '<' || temp == '>' || temp == '/'
							|| temp == '?') {
						index++;

					} else if (temp == KeyEvent.VK_BACK_SPACE) {

						if (!(index < 0))
							index--;
						else
							index = 0;
					} else {
					}
					if (!(index < 0) && index < content.length()) {
						if (temp == content.charAt(index)) {
							countAcc++;
						}
					}
					if (index == (content.length())) {
						Finish = 1;
					}
					if (!(index < 0) && index < content.length()) {
						if (!(temp == content.charAt(index))
								&& temp != KeyEvent.VK_BACK_SPACE) {
							Toolkit toolkit = Toolkit.getDefaultToolkit();
							;
							toolkit.beep();
						}
					}
				} else {
					if (countKeyTyped > 220) {
						level = 4;
					} else if (countKeyTyped > 180) {
						level = 3;
					} else if (countKeyTyped > 150) {
						level = 2;
					} else {
						level = 1;
					}
					switch (level) {
					case 4:
						levelString = "打字专家";
						break;
					case 3:
						levelString = "打字高手";
						break;
					case 2:
						levelString = "普通水平";
						break;
					case 1:
						levelString = "打字新手";
						break;
					}
					progressBar.setValue(100);
					timer.stop();
					FinalSeconds = seconds;
					FinalMinutes = minutes;
					String message = "是否保存记录?";
					String title = "完成！";
					int optionType = JOptionPane.YES_NO_CANCEL_OPTION;
					int messageType = JOptionPane.QUESTION_MESSAGE;
					String[] values = { "Yes", "No", "Cancel" };
					int result;
					String s = "";
					result = JOptionPane.showOptionDialog(frame, message,
							title, optionType, messageType, null, values,
							values[0]);
					if (result == JOptionPane.YES_OPTION) {
						s = "save";
					}
					if (result == JOptionPane.NO_OPTION) {
						s = "You Choose No";
					}
					if (result == JOptionPane.CANCEL_OPTION) {
						s = "You Choose Cancel";
					}
					if (result == JOptionPane.CLOSED_OPTION) {
						s = "You Closed The OptionDialog";
					}
					JOptionPane.showMessageDialog(null, "用时:" + FinalMinutes
							+ ":" + FinalSeconds + '\n' + levelString);
				}
			}
		});

		speedField.setText("0 k/min");
		accuracyField.setText("100%");
		timeField.setText("00:00:00");
		contentPane.setLayout(new BorderLayout());
		contentPane.add(headPanel, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);

		frame.setSize(820, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle("英文打字练习");

	}

	public static void main(String[] args) {
		new Words();
	}

	public void itemStateChanged(ItemEvent e) {
		flag = 1;
		Finish = 0;
		minutes = 0;
		seconds = -1;
		hours = 0;
		index = 0;
		count = 0;
		index = -1;
		countAcc = 0;
		FinalSeconds = 0;
		FinalMinutes = 0;
		FinalTime = 0;
		level = 0;
		countKeyTyped = 0;
		levelString = "";
		progressBar.setValue(0);
		typeArea.setText("");
		timer.start();
		accuracyField.setText("100%");
		speedField.setText("0 k/min");
		content = "";
		String temp;
		try {

			temp = (String) e.getItem();

			BufferedReader input = new BufferedReader(new FileReader("files/"+temp));

			String line;
			while ((line = input.readLine()) != null) {
				content += line;
			}
			showArea.setText(content);
			input.close();
		} catch (Exception exp) {
		}

	}

	public void actionPerformed(ActionEvent e) {
		String s = "";
		seconds++;
		if (seconds == 60) {
			minutes++;
			seconds -= 60;
			if (minutes == 60) {
				hours++;
				minutes -= 60;
				if (hours == 24) {
					timer.stop();
				}
			}
		}
		// }
		String hoursString, minutesString, secondsString;
		if (seconds < 10) {
			secondsString = "0" + Integer.toString(seconds);
		} else {
			secondsString = Integer.toString(seconds);
		}
		if (minutes < 10) {
			minutesString = "0" + Integer.toString(minutes);
		} else {
			minutesString = Integer.toString(minutes);
		}
		if (hours < 10) {
			hoursString = "0" + Integer.toString(hours);
		} else {
			hoursString = Integer.toString(hours);
		}
		s = hoursString + ":" + minutesString + ":" + secondsString;
		if (seconds < 0) {
			timeField.setText("0");
		} else {
			timeField.setText(s);
		}
		int totalTime = seconds + minutes * 60;
		int acc;
		int spe;
		if (!(index < 0)) {
			acc = (countAcc * 100 / count);
			spe = (count * 60 / totalTime);
		} else {
			acc = 0;
			spe = 0;
		}
		countKeyTyped = spe;
		String accuracyString = acc + " %";
		accuracyField.setText(accuracyString);

		if (index > 0 || index == 0) {
			speedField.setText(spe + " k/min");
			progressBar.setValue(index);
		} else {
			speedField.setText("0 k/min");
			accuracyField.setText("100%");
		}
	}

	public void stateChanged(ChangeEvent e) {
		progressBar.setValue((int) (index * 100) / content.length());
	}
}
