import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/* ������ ���� �� : ���� 0~100 ���̸� �Է¹ް� �ϱ�, Ŀ�� �̵�
 * outer class�� ������� �� DefaultTableModel ������ ��ġ?
 * 20/08/18
*/
public class GradeProject extends JFrame {
	
	private final String[] COLUMN_NAMES = { "�̸�", "����", "����", "����", "����", "���" };
	
	/* Frame ���� */
//	��ư �гΰ� ������ �Է� �г� ����
	private JPanel inputPanel;
	private JPanel btnPanel;

//	label�� textfield �迭�� ����
	private JLabel[] labels = new JLabel[4];
	private JTextField[] textFields = new JTextField[4];

//	�� ��ư �ʱ�ȭ
	private JButton inputBtn = new JButton("Ȯ��");
	private JButton printBtn = new JButton("���");
	private JButton cancelBtn = new JButton("���");

	/* Dialog ���� */
//	���̺� ���̾�α� �ʱ�ȭ
	private GradeTable dialog;

	private JTable table;
	private JScrollPane listScroll;

	private DefaultTableModel model; //outer class�� ��������� �ذ�  �ʿ�

	// Frame
	public GradeProject() {
		setTitle("title");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		dialog = new GradeTable(this, "dialog");

		inputPanel = new JPanel(new GridLayout(4, 2));
		btnPanel = new JPanel(new FlowLayout());

		labels[0] = new JLabel(COLUMN_NAMES[0]);
		labels[1] = new JLabel(COLUMN_NAMES[1]);
		labels[2] = new JLabel(COLUMN_NAMES[2]);
		labels[3] = new JLabel(COLUMN_NAMES[3]);

		for (int i = 0; i < labels.length; i++) {
			inputPanel.add(labels[i]);
			textFields[i] = new JTextField();
			inputPanel.add(textFields[i]);
		}

		// ������ �Է� ��ư
		inputBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textFields[0].getText();
					int kor = Integer.valueOf(textFields[1].getText());
					int eng = Integer.valueOf(textFields[2].getText());
					int mat = Integer.valueOf(textFields[3].getText());
					int sub = kor + eng + mat;
					double ave = (double) sub / 3;

					Object[] dataList = { name, kor, eng, mat, sub, ave };

					model.addRow(dataList);

//				System.out.println("�̸� : " + name + " ���� : " + 
//				kor + " ���� : " + eng + " ���� : " + mat + " ���� : " 
//						+ total + " ��� : " + ave);
//				
//				for (int i = 0; i < dataList.length; i++) {
//					System.out.println(dataList[i]);
//				}

					for (int i = 0; i < textFields.length; i++) {
						textFields[i].setText("");
					}
					System.out.println("�Է� ����");
					
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "��Ȯ�� �Է����ּ���.", 
							"Alert", JOptionPane.ERROR_MESSAGE);
					for (int i = 0; i < textFields.length; i++) {
						textFields[i].setText("");
					}
				}
			}
		});

		// ��¹�ư
		printBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);

			}
		});

		// ���� ��ư
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		btnPanel.add(inputBtn);
		btnPanel.add(printBtn);
		btnPanel.add(cancelBtn);

//		�� �г� ��ġ
		c.add(inputPanel, "Center");
		c.add(btnPanel, "South");

		setSize(400, 300);
		setVisible(true);
		setResizable(false);
	}

	// ���̾�α�
	class GradeTable extends JDialog {

		public GradeTable(JFrame frame, String title) {
			super(frame, title);
			setLayout(new FlowLayout());

			model = new DefaultTableModel(COLUMN_NAMES, 0);
			table = new JTable(model);
			listScroll = new JScrollPane(table);
			add(listScroll);
			// ���̺��� ����� ����
			pack();
		}
	}

	public static void main(String[] args) {

		new GradeProject();
	}

}
