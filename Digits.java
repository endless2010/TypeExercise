import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Digits {

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

	public Digits() {
		frame = new JFrame();
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

		showArea = new JTextArea(200, 100);
		typeArea = new JTextArea(200, 100);
		showArea.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 25));
		typeArea.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 25));
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

		int i;
		for (int j = 0; j < 200; j++) {
			i = (int) (Math.random() * 10);

			content += i;
			if (j % 10 == 0 && j != 0)
				content += " ";
		}
		showArea.setText(content);
		contentPane.setLayout(new BorderLayout());
		contentPane.add(headPanel, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.CENTER);
		frame.setSize(820, 600);
		frame.setVisible(true);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("英文打字练习");
	}

	public static void main(String[] args) {
		new Digits();
	}

}