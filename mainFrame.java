import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class mainFrame implements ActionListener {
	JFrame frame;
	JButton words;
	JButton digits;
	JButton records;
	JButton help;
	JTextArea textArea;
	JPanel panel;
	JPanel buttonPanel;
	JLabel label;

	public mainFrame() {

		frame = new JFrame();
		label = new JLabel("用户:endless");
		words = new JButton("英文练习");
		digits = new JButton("数字练习");
		records = new JButton("历史记录");
		help = new JButton("帮助");
		words.setForeground(Color.black);
		digits.setForeground(Color.black);
		records.setForeground(Color.black);
		help.setForeground(Color.black);
		words.addActionListener(this);
		digits.addActionListener(this);

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));
		buttonPanel.add(words);
		buttonPanel.add(digits);
		buttonPanel.add(records);
		buttonPanel.add(help);
		textArea = new JTextArea(200, 200);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setForeground(Color.blue);
		textArea.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 30));

		contentPane.add(buttonPanel, BorderLayout.WEST);
		contentPane.add(textArea, BorderLayout.CENTER);
		contentPane.add(label, BorderLayout.SOUTH);

		words.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				words.setForeground(Color.blue);
				digits.setForeground(Color.black);
				records.setForeground(Color.black);
				help.setForeground(Color.black);
				int y = e.getY();
				textArea.setText("英文打字是针对初学者掌握键盘所设计的练习模块，它能够有效的提高练习者的打字速度");

			}
		});
		digits.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				words.setForeground(Color.black);
				digits.setForeground(Color.blue);
				records.setForeground(Color.black);
				help.setForeground(Color.black);
				int y = e.getY();
				textArea.setText("数字打字是为了让用户熟悉小键盘而设计，他能够有效的提高用户使用小键盘的熟练程度");
			}
		});
		records.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				words.setForeground(Color.black);
				digits.setForeground(Color.black);
				records.setForeground(Color.blue);
				help.setForeground(Color.black);
				int y = e.getY();
				textArea.setText("用户打字记录");
			}
		});
		help.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				words.setForeground(Color.black);
				digits.setForeground(Color.black);
				records.setForeground(Color.black);
				help.setForeground(Color.blue);
				int y = e.getY();
				textArea.setText("帮助");
			}
		});

		frame.setSize(700, 350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle("打字练习程序");
	}

	public void mouseDragged(MouseEvent e) {

	}

	public static void main(String[] args) {
		new mainFrame();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == words) {
			new Words();
		}
		if (e.getSource() == digits) {
			new Digits();
		}
	}
}