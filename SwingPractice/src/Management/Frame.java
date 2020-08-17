package Management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Frame extends JFrame {
//	private JTextField name = new JTextField();
//	private JTextField korea = new JTextField();
//	private JTextField english = new JTextField();
//	private JTextField math = new JTextField();
	private JButton checkBtn = new JButton("Ȯ��");
	private JButton printBtn = new JButton("���");
	private JButton cancelBtn = new JButton("���");
	
	private JLabel[] label;
	private JTextField[] textField;
	private ArrayList<Object> listArr;

	private Dialog dialog;
//	private Data data;
	
	private Vector<Object[]> input = new Vector<Object[]>();

	label[0] = new JLabel("�̸�");
	label[1] = new JLabel("����");
	label[2] = new JLabel("����");
	label[3] = new JLabel("����");
	
	public Frame() {

		super("Grade Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
//		JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		c.setLayout(new BorderLayout());

		JPanel panel1 = new JPanel(new GridLayout(4, 2, 5, 5));
		JPanel panel2 = new JPanel(new FlowLayout());
		
		//�Է�â
		


		for(int i = 0; i < label.length; i++) {
			panel1.add(label[i]);
			panel2.add(textField[i]);
			
		}

		// ��ưâ
		panel2.add(checkBtn);
		panel2.add(printBtn);
		panel2.add(cancelBtn);

		//������ ���Թ�ư
		checkBtn.addActionListener(new ActionListener() {
			Object[] putData = new Object[6];
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < putData.length; i++) {
					putData[i] = textField[i].getText();
					textField[i].setText("");
				}
				
//				String nameIn = name.getText();
//				int korIn = Integer.valueOf(korea.getText());
//				int engIn = Integer.valueOf(english.getText());
//				int mathIn = Integer.valueOf(math.getText());
//				int total = korIn + engIn + mathIn;
//				double ave = total / 3;
				
				input.add(putData);
			}
		});
		
		//��¹�ư
		printBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog = new Dialog("Result", input);
				dialog.setVisible(true);
				
			}
		});
		
		//���� ��ư
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});

		//�г� ������ ��ġ
//		jsp.setTopComponent(panel1);
//		jsp.setBottomComponent(panel2);
//		jsp.setDividerLocation(210);
//		c.add("Center", jsp);
		
		c.add(panel1, "Center");
		c.add(panel2, "South");

		setSize(400, 300);
		setVisible(true);
		setResizable(false);
	}
}

class Dialog extends JDialog {
	private JTable table;
	private Frame frame;
	
	JScrollPane listScroll;
	JPanel panel;
	
	ArrayList<String> userColumn = new ArrayList<String>();
	DefaultTableModel model;
	ArrayList<Object> Row;
	String[] columnName = {"�л� �̸�", "����", "����", "����", "����", "���"};
	Object[][] data = {};
//	ArrayList<Object> data = new ArrayList<Object>();

	public Dialog(String title, Vector<Object[]> inputList) {
		setTitle(title);
		setLayout(new FlowLayout());
		setSize(800, 600);
		
		model = new DefaultTableModel(data, columnName);
		table = new JTable(model);
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		listScroll = new JScrollPane(table);
		panel.add(listScroll, BorderLayout.CENTER);
		
		add(panel);
		
//		table = new JTable(header, contents);
		
	}
}
