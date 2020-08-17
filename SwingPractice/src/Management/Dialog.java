package Management;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Dialog extends JDialog {
	private JTable table;
//	String[] header = {
//			"학생 이름",
//			"국어",
//			"영어",
//			"수학"
//	};
//	
//	Object[][] contents = {
//			{"hugh",
//			34,
//			43,
//			24}
//	};
	JScrollPane listScroll;
	JPanel panel;
	
	Vector<String> userColumn = new Vector<String>();
	DefaultTableModel model;
	Vector<Object> Row;

	
	public Dialog(JFrame frame, String title) {
		super(frame, title, true);
		setLayout(new FlowLayout());
		setSize(800, 600);
		
		userColumn.addElement("학생 이름");
		userColumn.addElement("국어");
		userColumn.addElement("영어");
		userColumn.addElement("수학");
		userColumn.addElement("총점");
		userColumn.addElement("평균");
		
		model = new DefaultTableModel(userColumn, 0);
		table = new JTable(model);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		listScroll = new JScrollPane(table);
		panel.add(listScroll, BorderLayout.CENTER);
		
		add(panel);
		
//		table = new JTable(header, contents);
		
	}
	
	
}
