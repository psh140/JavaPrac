import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerThread extends Thread {
	private JLabel timerLabel;
	
	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() {
		int i = 0;
		while(true) {
			timerLabel.setText(Integer.toString(i));
			i++;
			try {
				Thread.sleep(1000);
				
			} catch (Exception e) {
				return;
			}
		}
	}
}

public class ThreadPrac extends JFrame{

	public ThreadPrac() {
		setTitle("title");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		TimerThread th = new TimerThread(timerLabel);
		
		setSize(300, 170);
		setVisible(true);
		
		th.start();
	}
	
	public static void main(String[] args) {

		new ThreadPrac();
	}

}
