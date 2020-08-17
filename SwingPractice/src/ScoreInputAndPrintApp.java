import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

//----------------------------------------------------------------------------//
//----------------------- 성적을 저장하는 클래스 ------------------------//
class Score {
	private String studentName;
	private int korean;
	private int english;
	private int math;
	
	public Score(String studentName, int korean, int english, int math) {
		this.studentName = studentName;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	
	public int getTotal() {
		return korean + english + math;
	}
	
	public float getAverage() {
		return (float) getTotal() / ((float) 3);
	}
	
	@Override
	public String toString() {
		return "이름 : " + studentName + 
				" | 국어 : " + korean + 
				" | 영어 : " + english +
				" | 수학 : " + math +
				" | 총점 : " + getTotal() +
				" | 평균 : " + getAverage();
	}
	
	public Object[] toArray() {
		Object[] objects = { studentName, korean, english, math, 
							 getTotal(), getAverage() };
		return objects;
	}
}

//-------------------------------------------------------------------------//
//----------------------- 프로그램 정의 부분 --------------------------//
public class ScoreInputAndPrintApp extends JFrame {
	private JLabel[] labels = new JLabel[4];
	private JTextField[] textFields = new JTextField[4];
	private JButton confirmButton;
	
	private ScoreTableDialog dialog;
	private JTable table;
	private DefaultTableModel model;
	
	private String[] items = { "이름", "국어", "영어", "수학" };
	private int currentIndex;
	
	private LinkedList<Score> scoreList = new LinkedList<>();
	
	public ScoreInputAndPrintApp() {
		setTitle("성적 입출력 시스템 by 박하영");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new CenterPanel(), BorderLayout.CENTER); // 입력 부분
		c.add(new SouthPanel(), BorderLayout.SOUTH); // 버튼 부분
		
		dialog = new ScoreTableDialog(this, "성적"); // 테이블을 출력하는 다이얼로그
		
		setSize(300, 200);
		setVisible(true);
	}
	
	// 입력받는 패널
	class CenterPanel extends JPanel {	
		public CenterPanel() {
			setLayout(new GridLayout(4, 2));
			
			for (int i = 0; i < labels.length; i++) {
				labels[i] = new JLabel(items[i]);
				labels[i].setHorizontalAlignment(SwingConstants.CENTER);
				textFields[i] = new JTextField();
				textFields[i].addActionListener(new TextFieldActionListener());
				textFields[i].addFocusListener(new TextFieldFocusListener());
				add(labels[i]);
				add(textFields[i]);
			}
			
			currentIndex = 0;
		}
	}
	
	// 버튼이 위치한 패널
	class SouthPanel extends JPanel {
		public SouthPanel() {
			setLayout(new FlowLayout());
			confirmButton = new JButton("확인");
			JButton printButton = new JButton("출력");
			JButton cancelButton = new JButton("취소");
			add(confirmButton);	
			add(printButton);
			add(cancelButton);
			
			confirmButton.addKeyListener(new ConfirmButtonKeyListener()); // 확인버튼 키 리스너
			confirmButton.addActionListener(new ConfirmButtonActionListener()); // 확인버튼 액션 리스너
			printButton.addActionListener(new PrintButtonListener()); // 출력버튼
			cancelButton.addActionListener(new ActionListener() { // 취소버튼
				@Override
				public void actionPerformed(ActionEvent e) {
					int ret = JOptionPane.showConfirmDialog(
							null, 
							"종료하시겠습니까?", 
							"프로그램 종료", 
							JOptionPane.YES_NO_OPTION);
					if (ret == JOptionPane.OK_OPTION) {
						System.exit(0);
					}
				}
			});
		}
	}
	
	// 텍스트필드 액션 리스너 클래스
	class TextFieldActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (currentIndex < 3) { // 마지막 텍스트필드를 제외하고는
				textFields[++currentIndex].requestFocus(); // 포커스를 다음 텍스트필드로 옮긴다.
			} else { // 마지막 텍스트필드에서는
				confirmButton.requestFocus(); // 확인 버튼으로 포커스를 옮긴다.
			}
		}
	}
	
	// 텍스트필드 포커스 리스너 클래스
	// 마우스를 이용하여 임의로 포커스를 주었을 경우 처리하게 함
	//
	// 엔터를 이용하여 차례대로 포커스를 옮기지 않았을 경우
	// currentIndex에 해당하는 텍스트필드와 일치하지 않을 수 있으므로
	// 그 텍스트필드와 일치하는 것을 찾아 그 인덱스를
	// currentIndex에 저장한다.
	class TextFieldFocusListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			JTextField tf = (JTextField) e.getSource();
			if (tf != textFields[currentIndex]) {
				for (int i = 0; i < textFields.length; i++) {
					if (i == currentIndex) { // 위에서 검사했으므로 패스
						continue;
					}
					if (tf == textFields[i]) {
						currentIndex = i;
						break;
					}
				}
			}
		}
		@Override
		public void focusLost(FocusEvent e) {}
		
	}
	
	// 확인 버튼 키 리스너
	class ConfirmButtonKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER) { // 버튼에 포커스가 있는 상태에서 엔터를 누르면
				confirmButton.doClick(); // 버튼을 클릭시킨다.
			}
		}
	}
	
	// 확인 버튼 액션 리스너
	class ConfirmButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// 값이 입력되지 않은 필드가 있다면 경고창을 띄운다.
			for (int i = 0; i < textFields.length; i++) {
				if (textFields[i].getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(
							null, 
							"\'" + items[i] + "\' 값이 입력되지 않았습니다." , 
							"경고", 
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			
			// 텍스트필드 값을 가져와 Score 인스턴스를 만든 후
			// 링크드리스트와 테이블에 데이터를 추가한다.
			try {
				String studentName = textFields[0].getText();
				int korean = Integer.valueOf(textFields[1].getText());
				int english = Integer.valueOf(textFields[2].getText());
				int math = Integer.valueOf(textFields[3].getText());
				Score score = new Score(
						studentName, korean, english, math);
				scoreList.add(score);
				model.addRow(score.toArray());
				System.out.println(score.toString());
				
				// 모든 텍스트필드 빈칸으로 바꾸기
				for (int i = 0; i < textFields.length; i++) {
					textFields[i].setText("");
				}
				
				// 포커스를 첫번째 텍스트필드로 옮긴다.
				textFields[0].requestFocus();
			} catch (NumberFormatException e1) { // 점수 입력란에 숫자가 아닌 값이 입력되었을 경우
				JOptionPane.showMessageDialog(
						null, 
						"점수에 숫자가 아닌 값이 입력되었습니다.\n 다시 입력해 주세요." , 
						"경고",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	// 출력 버튼 액션 리스너
	class PrintButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
		}
	}
	
	// 테이블이 출력되는 다이얼로그 클래스
	class ScoreTableDialog extends JDialog {
		public ScoreTableDialog(JFrame frame, String title) {
			super(frame, title);
			
			// 테이블 column 생성
			String[] header = new String[6];
			for (int i = 0; i < items.length; i++) {
				header[i] = items[i];
			}
			header[4] = "총점";
			header[5] = "평균";
			
			// header를 column으로 하는 테이블 생성
			model = new DefaultTableModel(header, 0);
			JTable table = new JTable(model);
			
			// 테이블 값 가운데 정렬
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			table.setDefaultRenderer(Object.class, centerRenderer);
			
			// 다이얼로그에 부착
			JScrollPane scrollPane = new JScrollPane(table);
			add(scrollPane);
			pack();
			
			setSize(500,500);
		}
	}
	
	public static void main(String[] args) {
		new ScoreInputAndPrintApp();
	}
}