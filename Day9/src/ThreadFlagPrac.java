import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

class RandomThread extends Thread {
	private Container contentPane;
	private boolean flag = false;
	
	public RandomThread(Container contentPane) {
		this.contentPane = contentPane;
	}
	
	public void finish() {
		flag = true;
	}
	
	@Override
	public void run() {
		while(true) {
			int x = ((int)(Math.random()*contentPane.getWidth()));
			int y = ((int)(Math.random()*contentPane.getHeight()));
			
			JLabel label = new JLabel("Java");
			label.setSize(80, 30);
			label.setLocation(x, y);
			contentPane.add(label); // 레이블을 contentPane에 추가
			contentPane.repaint(); //추가된 레이블 보이게 함
			
			try {
				Thread.sleep(300);
				if(flag == true) {
					contentPane.removeAll();
					label = new JLabel("finish");
					label.setSize(80, 30);
					label.setLocation(100, 100);
					
					label.setForeground(Color.RED);
					contentPane.add(label);
					contentPane.repaint();
					return;
				}
			} catch (Exception e) {
				return;
			}
		}
	}
}

public class ThreadFlagPrac extends JFrame{

	private RandomThread th;
	
	public ThreadFlagPrac() {
		setTitle("practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		c.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				th.finish();
			}
		});
		
		setSize(300, 200);
		setVisible(true);
		
		th = new RandomThread(c); // 스레드에 contentpane 전달
		th.start();
	}
	
	public static void main(String[] args) {
		new ThreadFlagPrac();

	}

}
