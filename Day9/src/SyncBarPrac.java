import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyLabel extends JLabel {
	private int barSize = 0;
	private int maxBarSize;
	
	public MyLabel (int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.magenta);
		int width = (int) (((double)(this.getWidth()))/maxBarSize*barSize);
		if(width == 0) {
			return;
		}
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized public void fill() {
		if(barSize == maxBarSize) {
			try {
				wait(); //bar�� �ִ��̸� consumerThread�� ���� �ٰ� �پ�鶧 ���� ���
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++;
		repaint(); //bar�� ũ�Ⱑ ���� �� �ٽ� �׸���
		notify(); // ��ٸ��� consumerThread �����
	}
	synchronized public void consume() {
		if(barSize == maxBarSize) {
			try {
				wait(); //bar�� 0�̸� ���� ũ�Ⱑ 0���� Ŀ�� �� ���� ���
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize--;
		repaint(); //bar�� ũ�Ⱑ ���� �� �ٽ� �׸���
		notify(); // ��ٸ��� consumerThread �����
	}
	
	
	
}

class ConsumerThread extends Thread {
	private MyLabel bar;
	public ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				sleep(200);
				bar.consume();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	
	}
}

public class SyncBarPrac extends JFrame{

	private MyLabel bar = new MyLabel(100); //bar�� ũ�⸦ 100���� ����
	
	public SyncBarPrac(String title) {
		//p.728
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
