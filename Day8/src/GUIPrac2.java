import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIPrac2 extends JFrame {
	private JTextField tf = new JTextField(20);
	private JTextArea ta = new JTextArea(7, 20);
	private JTextField tf1 = new JTextField(10);
	private Vector<String> v = new Vector<String>();
	private JList<String> nameList = new JList<String>(v);
	
	public GUIPrac2() {
		setTitle("Text Field");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("Put Text and Press Enter"));
		c.add(tf); 
		c.add(new JScrollPane(ta));
		c.add(new JLabel("put name and Enter"));
		c.add(tf1);
		
		v.add("Kim");
		v.add("Park");
		nameList.setVisibleRowCount(5);
		nameList.setFixedCellWidth(100);
		c.add(new JScrollPane(nameList));
		
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append(tf.getText() + "\n");
				
				tf.setText("");
			}
		});
		
		
		tf1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				v.add(tf1.getText());
				tf1.setText("");
				nameList.setListData(v);
			}
		});
		
		setSize(1000, 1000);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUIPrac2();
	}

}
