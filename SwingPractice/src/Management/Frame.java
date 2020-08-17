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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Frame extends JFrame {
	private JTextField name = new JTextField(20);
	private JTextField korea = new JTextField();
	private JTextField english = new JTextField();
	private JTextField math = new JTextField();
	private JButton checkBtn = new JButton("Ȯ��");
	private JButton printBtn = new JButton("���");
	private JButton cancelBtn = new JButton("���");

	private Vector<String> nameList;
	private Vector<Object> koreaList;
	private Vector<Object> englishList;
	private Vector<Object> mathList;

	private Dialog dialog;
//	private Data data;

	public Frame() {

		super("Grade Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JSplitPane jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		c.setLayout(new BorderLayout());

		JPanel panel1 = new JPanel(new GridLayout(4, 2, 5, 5));
		JPanel panel2 = new JPanel(new FlowLayout());

		dialog = new Dialog(this, "Result");

		// �Է�â
		panel1.add(new JLabel("�̸�"));
		panel1.add(name);
		panel1.add(new JLabel("����"));
		panel1.add(korea);
		panel1.add(new JLabel("����"));
		panel1.add(english);
		panel1.add(new JLabel("����"));
		panel1.add(math);

		// ��ưâ
		panel2.add(checkBtn);
		panel2.add(printBtn);
		panel2.add(cancelBtn);

		//������ ���Թ�ư
		checkBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nameList = new Vector<String>();
				koreaList = new Vector<Object>();
				englishList = new Vector<Object>();
				mathList = new Vector<Object>();
				
				nameList.add(name.getText());
				koreaList.add(korea.getText());
				englishList.add(english.getText());
				mathList.add(math.getText());
				
			}
		});
		
		//��¹�ư
		printBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
		jsp.setTopComponent(panel1);
		jsp.setBottomComponent(panel2);
		jsp.setDividerLocation(210);
		c.add("Center", jsp);

		setSize(400, 300);
		setVisible(true);
		setResizable(false);
	}
}
