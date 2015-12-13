import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ColorDemo implements ActionListener {
	Words words = new Words();
	Digits digits;
	private JRadioButton jrbBlack, jrbBlue, jrbCyan, jrbDarkGray, jrbGray,
			jrbGreen, jrbLightGray, jrbMagenta, jrbOrange, jrbPink, jrbRed,
			jrbWhite, jrbYellow, jrbOther;

	JFrame frame;
	private JTextArea jtaShowColor;

	public ColorDemo() {
		frame = new JFrame();
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new GridLayout(2, 1));
		JPanel jpRadioButtons = new JPanel();
		jpRadioButtons.setLayout(new GridLayout(3, 5));
		jtaShowColor = new JTextArea();
		jrbOther = new JRadioButton("其他");
		jrbBlack = new JRadioButton("black");
		jrbBlue = new JRadioButton("blue");
		jrbCyan = new JRadioButton("cyan");
		jrbDarkGray = new JRadioButton("darkGray");
		jrbGray = new JRadioButton("gray");
		jrbGreen = new JRadioButton("green");
		jrbLightGray = new JRadioButton("lightGray");
		jrbMagenta = new JRadioButton("magenta");
		jrbOrange = new JRadioButton("orange");
		jrbPink = new JRadioButton("pink");
		jrbRed = new JRadioButton("red");
		jrbWhite = new JRadioButton("white");
		jrbYellow = new JRadioButton("yellow");
		jrbGreen.setSelected(true);

		jrbBlack.addActionListener(this);
		jrbBlue.addActionListener(this);
		jrbCyan.addActionListener(this);
		jrbDarkGray.addActionListener(this);
		jrbGray.addActionListener(this);
		jrbGreen.addActionListener(this);
		jrbLightGray.addActionListener(this);
		jrbMagenta.addActionListener(this);
		jrbOrange.addActionListener(this);
		jrbPink.addActionListener(this);
		jrbRed.addActionListener(this);
		jrbWhite.addActionListener(this);
		jrbYellow.addActionListener(this);
		jrbOther.addActionListener(this);

		jpRadioButtons.add(jrbBlack);
		jpRadioButtons.add(jrbBlue);
		jpRadioButtons.add(jrbCyan);
		jpRadioButtons.add(jrbDarkGray);
		jpRadioButtons.add(jrbGray);
		jpRadioButtons.add(jrbGreen);
		jpRadioButtons.add(jrbLightGray);
		jpRadioButtons.add(jrbMagenta);
		jpRadioButtons.add(jrbOrange);
		jpRadioButtons.add(jrbPink);
		jpRadioButtons.add(jrbRed);
		jpRadioButtons.add(jrbWhite);
		jpRadioButtons.add(jrbYellow);
		jpRadioButtons.add(jrbOther);

		ButtonGroup group = new ButtonGroup();
		group.add(jrbBlack);
		group.add(jrbBlue);
		group.add(jrbCyan);
		group.add(jrbDarkGray);
		group.add(jrbGray);
		group.add(jrbGreen);
		group.add(jrbLightGray);
		group.add(jrbMagenta);
		group.add(jrbOrange);
		group.add(jrbPink);
		group.add(jrbRed);
		group.add(jrbWhite);
		group.add(jrbYellow);
		group.add(jrbOther);

		contentPane.add(jpRadioButtons);
		frame.setVisible(true);
		frame.pack();
		frame.setTitle("Color Demo");
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		int x = (screenWidth - frame.getWidth()) / 2;
		int y = (screenHeight - frame.getHeight()) / 2;
		frame.setLocation(x, y);
		jtaShowColor.setBackground(Color.green);
	}

	public static void main(String[] args) {
		new ColorDemo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jrbBlack) {
			jtaShowColor.setBackground(Color.black);
		} else if (e.getSource() == jrbBlue) {
			jtaShowColor.setBackground(Color.blue);
		} else if (e.getSource() == jrbCyan) {
			jtaShowColor.setBackground(Color.cyan);
		} else if (e.getSource() == jrbDarkGray) {
			jtaShowColor.setBackground(Color.darkGray);
		} else if (e.getSource() == jrbGray) {
			jtaShowColor.setBackground(Color.gray);
		} else if (e.getSource() == jrbGreen) {
			jtaShowColor.setBackground(Color.green);
		} else if (e.getSource() == jrbLightGray) {
			jtaShowColor.setBackground(Color.lightGray);
		} else if (e.getSource() == jrbMagenta) {
			jtaShowColor.setBackground(Color.magenta);
		} else if (e.getSource() == jrbOrange) {
			jtaShowColor.setBackground(Color.orange);
		} else if (e.getSource() == jrbPink) {
			jtaShowColor.setBackground(Color.pink);
		} else if (e.getSource() == jrbRed) {
			jtaShowColor.setBackground(Color.red);
		} else if (e.getSource() == jrbWhite) {
			jtaShowColor.setBackground(Color.white);
		} else if (e.getSource() == jrbYellow) {
			jtaShowColor.setBackground(Color.yellow);
		} else if (e.getSource() == jrbOther) {
			Color color = JColorChooser.showDialog(frame, "请选择颜色", Color.green);
			jtaShowColor.setBackground(color);
		}
	}
}