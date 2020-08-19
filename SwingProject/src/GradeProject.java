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

/* 만들지 않은 것 : 점수 0~100 사이만 입력받게 하기, 커서 이동
 * outer class로 만들었을 때 DefaultTableModel 변수의 위치?
 * 20/08/18
*/
public class GradeProject extends JFrame {
	
	private final String[] COLUMN_NAMES = { "이름", "국어", "영어", "수학", "총점", "평균" };
	
	/* Frame 변수 */
//	버튼 패널과 데이터 입력 패널 나눔
	private JPanel inputPanel;
	private JPanel btnPanel;

//	label과 textfield 배열로 관리
	private JLabel[] labels = new JLabel[4];
	private JTextField[] textFields = new JTextField[4];

//	각 버튼 초기화
	private JButton inputBtn = new JButton("확인");
	private JButton printBtn = new JButton("출력");
	private JButton cancelBtn = new JButton("취소");

	/* Dialog 변수 */
//	테이블 다이얼로그 초기화
	private GradeTable dialog;

	private JTable table;
	private JScrollPane listScroll;

	private DefaultTableModel model; //outer class로 만들었을때 해결  필요

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

		// 데이터 입력 버튼
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

//				System.out.println("이름 : " + name + " 국어 : " + 
//				kor + " 영어 : " + eng + " 수학 : " + mat + " 총점 : " 
//						+ total + " 평균 : " + ave);
//				
//				for (int i = 0; i < dataList.length; i++) {
//					System.out.println(dataList[i]);
//				}

					for (int i = 0; i < textFields.length; i++) {
						textFields[i].setText("");
					}
					System.out.println("입력 성공");
					
				} catch (Exception error) {
					JOptionPane.showMessageDialog(null, "정확히 입력해주세요.", 
							"Alert", JOptionPane.ERROR_MESSAGE);
					for (int i = 0; i < textFields.length; i++) {
						textFields[i].setText("");
					}
				}
			}
		});

		// 출력버튼
		printBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);

			}
		});

		// 종료 버튼
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		btnPanel.add(inputBtn);
		btnPanel.add(printBtn);
		btnPanel.add(cancelBtn);

//		각 패널 배치
		c.add(inputPanel, "Center");
		c.add(btnPanel, "South");

		setSize(400, 300);
		setVisible(true);
		setResizable(false);
	}

	// 다이얼로그
	class GradeTable extends JDialog {

		public GradeTable(JFrame frame, String title) {
			super(frame, title);
			setLayout(new FlowLayout());

			model = new DefaultTableModel(COLUMN_NAMES, 0);
			table = new JTable(model);
			listScroll = new JScrollPane(table);
			add(listScroll);
			// 테이블의 사이즈에 맞춤
			pack();
		}
	}

	public static void main(String[] args) {

		new GradeProject();
	}

}
