import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickeringLabel extends JLabel implements Runnable {
	private long delay;
	
	public FlickeringLabel(String text, long delay) {
		super(text);
		this.delay = delay;
		setOpaque(true); //¹è°æ»ö º¯°æ
		
		Thread th = new Thread(this);
		th.start();
		
	}
	@Override
	public void run() {
		int i = 0;
		while(true) {
			if( i == 0 ) {
				setBackground(Color.YELLOW);
				i = 1;
			} else {
				setBackground(Color.GREEN);
				i = 0;
			}
//			if( i == 0) {
//				i = 1;
//			} else {
//				i = 0;
//			}
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				return;
			}
		}
		
	}
	
}

public class ThreadPrac2 extends JFrame {
	
	public ThreadPrac2() {
		setTitle("practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());
		
		FlickeringLabel fLabel = new FlickeringLabel("±ôºý", 500);
		
		JLabel label = new JLabel("¾È±ôºý");
		
		FlickeringLabel flaLabel2 = new FlickeringLabel("¶Ç±ôºý", 300);
		
		c.add(fLabel);
		c.add(label);
		c.add(flaLabel2);
		
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ThreadPrac2();

	}

}
