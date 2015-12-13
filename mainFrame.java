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
		label = new JLabel("�û�:endless");
		words = new JButton("Ӣ����ϰ");
		digits = new JButton("������ϰ");
		records = new JButton("��ʷ��¼");
		help = new JButton("����");
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
				textArea.setText("Ӣ�Ĵ�������Գ�ѧ�����ռ�������Ƶ���ϰģ�飬���ܹ���Ч�������ϰ�ߵĴ����ٶ�");

			}
		});
		digits.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				words.setForeground(Color.black);
				digits.setForeground(Color.blue);
				records.setForeground(Color.black);
				help.setForeground(Color.black);
				int y = e.getY();
				textArea.setText("���ִ�����Ϊ�����û���ϤС���̶���ƣ����ܹ���Ч������û�ʹ��С���̵������̶�");
			}
		});
		records.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				words.setForeground(Color.black);
				digits.setForeground(Color.black);
				records.setForeground(Color.blue);
				help.setForeground(Color.black);
				int y = e.getY();
				textArea.setText("�û����ּ�¼");
			}
		});
		help.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				words.setForeground(Color.black);
				digits.setForeground(Color.black);
				records.setForeground(Color.black);
				help.setForeground(Color.blue);
				int y = e.getY();
				textArea.setText("����");
			}
		});

		frame.setSize(700, 350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		frame.setTitle("������ϰ����");
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