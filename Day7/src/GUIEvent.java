import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUIEvent extends JFrame{
	JButton btn;
	JLabel la;
	
	public GUIEvent() {
		setTitle("Action Event Listener Prac");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		btn = new JButton("Action");
		c.add(btn);
		la = new JLabel("Hello");
		la.setSize(50, 20);
		la.setLocation(30, 30);
		c.add(la);
		c.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				la.setLocation(x, y);
				
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				if(b.getText().equals("Action")) {
					b.setText("액션");
				} else {
					b.setText("Action");
				}
				
				//익명클래스의 멤버나 JFrame의 멤버 호출 가능.
				setTitle(b.getText());
			}
		});
		
		
		setSize(350, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GUIEvent();

	}
}
//
//class MyActionListener implements ActionListener {
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		JButton b = (JButton) e.getSource();
//		if(b.getText().equals("Action")) {
//			b.setText("액션");
//		} else {
//			b.setText("Action");
//		}
//	}
//	
//}
