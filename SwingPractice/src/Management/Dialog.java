//package Management;
//
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.util.ArrayList;
//import java.util.Vector;
//
//import javax.swing.JDialog;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//public class Dialog extends JDialog {
//	private JTable table;
//	private Frame frame;
//	
//	JScrollPane listScroll;
//	JPanel panel;
//	
//	ArrayList<String> userColumn = new ArrayList<String>();
//	DefaultTableModel model;
//	ArrayList<Object> Row;
//	String[] columnName = {"학생 이름", "국어", "영어", "수학", "총점", "평균"};
//	Object[][] data = {};
////	ArrayList<Object> data = new ArrayList<Object>();
//
//	public Dialog(JFrame frame, String title, Vector<Object[]> inputList) {
//		setTitle(title);
//		setLayout(new FlowLayout());
//		setSize(800, 600);
//		
//		model = new DefaultTableModel(data, columnName);
//		table = new JTable(model);
//		
//		panel = new JPanel();
//		panel.setLayout(new BorderLayout());
//		
//		listScroll = new JScrollPane(table);
//		panel.add(listScroll, BorderLayout.CENTER);
//		
//		add(panel);
//		
////		table = new JTable(header, contents);
//		
//	}
//	
//	
//}
