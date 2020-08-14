import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class ModalLog extends JDialog {
	private JTextField tf = new JTextField(10);
	private JButton okButton = new JButton("OK");

	public ModalLog(JFrame frame, String title) {
		super(frame, title, true); // true is modal type
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		setSize(200, 100);

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
	}

	public String getInput() {
		if (tf.getText().length() == 0) {
			return null;
		} else
			return tf.getText();
	}
}

public class DialogPrac extends JFrame {
	private ModalLog dialog;

	public DialogPrac() {
		super("Dialog Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("Show");

		dialog = new ModalLog(this, "test");

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);

				String text = dialog.getInput();

				if (text == null) {
					return;
				}
				JButton btn = (JButton) e.getSource();
				btn.setText(text);
			}
		});
		getContentPane().add(btn);
		setSize(250, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DialogPrac();

	}

}
