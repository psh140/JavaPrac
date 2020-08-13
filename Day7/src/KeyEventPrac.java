import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyEventPrac extends JFrame {

	private final int FLYING_UNIT = 10;
	private JLabel la = new JLabel("Hugh");
//	private JLabel[] keyMessage;

	public KeyEventPrac() {
		setTitle("Key Event Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(null);

		c.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();

				switch (keyCode) {
				case KeyEvent.VK_UP:
					la.setLocation(la.getX(), la.getY() - FLYING_UNIT);
					break;
				case KeyEvent.VK_DOWN:
					la.setLocation(la.getX(), la.getY() + FLYING_UNIT);
					break;
				case KeyEvent.VK_LEFT:
					la.setLocation(la.getX() - FLYING_UNIT, getY());
					break;
				case KeyEvent.VK_RIGHT:
					la.setLocation(la.getX() + FLYING_UNIT, getY());
					break;
				}
			}
		});
		la.setLocation(50, 50);
		la.setSize(100, 20);
		c.add(la);

//		c.addKeyListener(new KeyAdapter() {
//
//			@Override
//			public void keyTyped(KeyEvent e) {
//				System.out.println("KeyTyped");
//			}
//
//			@Override
//			public void keyReleased(KeyEvent e) {
//				System.out.println("KeyReleased");
//			}
//
//			@Override
//			public void keyPressed(KeyEvent e) {
//				int keyCode = e.getKeyCode();
//				char keyChar = e.getKeyChar();
//				keyMessage[0].setText(Integer.toString(keyCode)); //Key Code
//				keyMessage[1].setText(Character.toString(keyChar)); //Key Character
//				keyMessage[2].setText(KeyEvent.getKeyText(keyCode)); //Key Name
//				
//				System.out.println("KeyPressed");
//				
//			}
//			
//		});

//		keyMessage = new JLabel[3];
//		keyMessage[0] = new JLabel(" getKeyCode()  ");
//		keyMessage[1] = new JLabel(" getKeyChar()  ");
//		keyMessage[2] = new JLabel(" getKeyText()  ");
//		
//		for(int i = 0; i < keyMessage.length; i++) {
//			c.add(keyMessage[i]);
//			keyMessage[i].setBackground(Color.cyan);
//		}

		setSize(300, 150);
		setVisible(true);

		c.setFocusable(true);
		c.requestFocus();

		c.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Component com = (Component) e.getSource();
				com.setFocusable(true);
				com.requestFocus();
			}

		});
	}

	public static void main(String[] args) {

		new KeyEventPrac();

	}

}
