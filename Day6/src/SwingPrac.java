import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingPrac extends JFrame{
	
	public SwingPrac() {
		setTitle("JFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setBackground(Color.orange);
		c.setLayout(new GridLayout(4, 2, 5, 5));
		
		
		c.add(new JLabel("이름"));
		c.add(new JTextField());
		c.add(new JLabel("학번"));
		c.add(new JTextField());		
		c.add(new JLabel("학과"));
		c.add(new JTextField());		
		c.add(new JLabel("과목"));
		c.add(new JTextField());
//		c.add(new JButton("OK"), BorderLayout.CENTER);
//		c.add(new JButton("Cancel"), BorderLayout.NORTH);
//		c.add(new JButton("Ignore"), BorderLayout.SOUTH);
//		c.add(new JButton("Ignore"), BorderLayout.EAST);
//		c.add(new JButton("Ignore"), BorderLayout.WEST);
//		
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new SwingPrac();
	}

}
