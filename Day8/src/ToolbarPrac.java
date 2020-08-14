import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ToolbarPrac extends JFrame{
	private Container contentPane;
	
	public ToolbarPrac() {
		setTitle("toolbar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar();
		setSize(400, 200);
		setVisible(true);
	}
	
	private void createToolBar() {
		JToolBar toolBar = new JToolBar("toolbar menu");
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		toolBar.add(new JButton("New"));
		toolBar.add(new JButton("cherry"));
		toolBar.addSeparator();
		toolBar.add(new JButton("orange"));
		toolBar.add(new JLabel("search"));
		toolBar.add(new JTextField("text field"));
		
		JComboBox<String> combo = new JComboBox<String>();
		combo.addItem("a");
		combo.addItem("ab");
		combo.addItem("abc");
		combo.addItem("abcd");
		toolBar.add(combo);
		
		contentPane.add(toolBar, BorderLayout.NORTH);
		
	}
	
	public static void main(String[] args) {
		new ToolbarPrac();

	}

}
