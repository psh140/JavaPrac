import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorChangePrac extends JFrame {

	private JLabel colorLabel;
	private JSlider[] slider = new JSlider[3];

	public ColorChangePrac() {
		setTitle("Color Select");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		colorLabel = new JLabel("	SLIDER EXAMPLE	");

		for (int i = 0; i < slider.length; i++) {
			slider[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			slider[i].setPaintLabels(true);
			slider[i].setPaintTicks(true);
			slider[i].setPaintTrack(true);
			slider[i].setMajorTickSpacing(50);
			slider[i].setMinorTickSpacing(10);

			slider[i].addChangeListener(new MyChangeListener());
			c.add(slider[i]);
		}

		slider[0].setForeground(Color.RED);
		slider[1].setForeground(Color.GREEN);
		slider[2].setForeground(Color.BLUE);

		int r = slider[0].getValue();
		int g = slider[1].getValue();
		int b = slider[2].getValue();

		colorLabel.setOpaque(true); // 불투명도
		colorLabel.setBackground(new Color(r, g, b));

		c.add(colorLabel);
		setSize(300, 230);
		setVisible(true);
	}

	class MyChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			int r = slider[0].getValue();
			int g = slider[1].getValue();
			int b = slider[2].getValue();
			colorLabel.setBackground(new Color(r, g, b));
		}

	}

	public static void main(String[] args) {
		new ColorChangePrac();

	}

}
