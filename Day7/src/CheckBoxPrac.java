//import javax.swing.JCheckBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import java.awt.*;
//import java.awt.event.*;
//
//public class CheckBoxPrac extends JFrame{
//
//	private JCheckBox[] fruits = new JCheckBox[3];
//	private String[] names = {"apple", "pear", "cherry"	};
//	
//	private JLabel sumLabel;
//	
//	public CheckBoxPrac() {
//		setTitle("Check Box Practice");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Container c = getContentPane();
//		c.setLayout(new FlowLayout());
//		
//		c.add(new JLabel("apple is 100won, pear is 500won, cherry is 20000won"));
//		
//		MyItemListener listener = new MyItemListener();
//		
//	}
//	
//	class MyItemListener implements ItemListener {
//		private int sum = 0;
//
//		@Override
//		public void itemStateChanged(ItemEvent e) {
//			if(e.getStateChange() == ItemEvent.SELECTED) {
//				sum += 100;
//			} else if ()
//			
//		}
//		
//	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//	
//	
//
//}
