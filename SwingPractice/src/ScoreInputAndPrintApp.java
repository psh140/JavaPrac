import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

//----------------------------------------------------------------------------//
//----------------------- ������ �����ϴ� Ŭ���� ------------------------//
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
		return "�̸� : " + studentName + 
				" | ���� : " + korean + 
				" | ���� : " + english +
				" | ���� : " + math +
				" | ���� : " + getTotal() +
				" | ��� : " + getAverage();
	}
	
	public Object[] toArray() {
		Object[] objects = { studentName, korean, english, math, 
							 getTotal(), getAverage() };
		return objects;
	}
}

//-------------------------------------------------------------------------//
//----------------------- ���α׷� ���� �κ� --------------------------//
public class ScoreInputAndPrintApp extends JFrame {
	private JLabel[] labels = new JLabel[4];
	private JTextField[] textFields = new JTextField[4];
	private JButton confirmButton;
	
	private ScoreTableDialog dialog;
	private JTable table;
	private DefaultTableModel model;
	
	private String[] items = { "�̸�", "����", "����", "����" };
	private int currentIndex;
	
	private LinkedList<Score> scoreList = new LinkedList<>();
	
	public ScoreInputAndPrintApp() {
		setTitle("���� ����� �ý��� by ���Ͽ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new CenterPanel(), BorderLayout.CENTER); // �Է� �κ�
		c.add(new SouthPanel(), BorderLayout.SOUTH); // ��ư �κ�
		
		dialog = new ScoreTableDialog(this, "����"); // ���̺��� ����ϴ� ���̾�α�
		
		setSize(300, 200);
		setVisible(true);
	}
	
	// �Է¹޴� �г�
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
	
	// ��ư�� ��ġ�� �г�
	class SouthPanel extends JPanel {
		public SouthPanel() {
			setLayout(new FlowLayout());
			confirmButton = new JButton("Ȯ��");
			JButton printButton = new JButton("���");
			JButton cancelButton = new JButton("���");
			add(confirmButton);	
			add(printButton);
			add(cancelButton);
			
			confirmButton.addKeyListener(new ConfirmButtonKeyListener()); // Ȯ�ι�ư Ű ������
			confirmButton.addActionListener(new ConfirmButtonActionListener()); // Ȯ�ι�ư �׼� ������
			printButton.addActionListener(new PrintButtonListener()); // ��¹�ư
			cancelButton.addActionListener(new ActionListener() { // ��ҹ�ư
				@Override
				public void actionPerformed(ActionEvent e) {
					int ret = JOptionPane.showConfirmDialog(
							null, 
							"�����Ͻðڽ��ϱ�?", 
							"���α׷� ����", 
							JOptionPane.YES_NO_OPTION);
					if (ret == JOptionPane.OK_OPTION) {
						System.exit(0);
					}
				}
			});
		}
	}
	
	// �ؽ�Ʈ�ʵ� �׼� ������ Ŭ����
	class TextFieldActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (currentIndex < 3) { // ������ �ؽ�Ʈ�ʵ带 �����ϰ��
				textFields[++currentIndex].requestFocus(); // ��Ŀ���� ���� �ؽ�Ʈ�ʵ�� �ű��.
			} else { // ������ �ؽ�Ʈ�ʵ忡����
				confirmButton.requestFocus(); // Ȯ�� ��ư���� ��Ŀ���� �ű��.
			}
		}
	}
	
	// �ؽ�Ʈ�ʵ� ��Ŀ�� ������ Ŭ����
	// ���콺�� �̿��Ͽ� ���Ƿ� ��Ŀ���� �־��� ��� ó���ϰ� ��
	//
	// ���͸� �̿��Ͽ� ���ʴ�� ��Ŀ���� �ű��� �ʾ��� ���
	// currentIndex�� �ش��ϴ� �ؽ�Ʈ�ʵ�� ��ġ���� ���� �� �����Ƿ�
	// �� �ؽ�Ʈ�ʵ�� ��ġ�ϴ� ���� ã�� �� �ε�����
	// currentIndex�� �����Ѵ�.
	class TextFieldFocusListener implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			JTextField tf = (JTextField) e.getSource();
			if (tf != textFields[currentIndex]) {
				for (int i = 0; i < textFields.length; i++) {
					if (i == currentIndex) { // ������ �˻������Ƿ� �н�
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
	
	// Ȯ�� ��ư Ű ������
	class ConfirmButtonKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER) { // ��ư�� ��Ŀ���� �ִ� ���¿��� ���͸� ������
				confirmButton.doClick(); // ��ư�� Ŭ����Ų��.
			}
		}
	}
	
	// Ȯ�� ��ư �׼� ������
	class ConfirmButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// ���� �Էµ��� ���� �ʵ尡 �ִٸ� ���â�� ����.
			for (int i = 0; i < textFields.length; i++) {
				if (textFields[i].getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(
							null, 
							"\'" + items[i] + "\' ���� �Էµ��� �ʾҽ��ϴ�." , 
							"���", 
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			
			// �ؽ�Ʈ�ʵ� ���� ������ Score �ν��Ͻ��� ���� ��
			// ��ũ�帮��Ʈ�� ���̺� �����͸� �߰��Ѵ�.
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
				
				// ��� �ؽ�Ʈ�ʵ� ��ĭ���� �ٲٱ�
				for (int i = 0; i < textFields.length; i++) {
					textFields[i].setText("");
				}
				
				// ��Ŀ���� ù��° �ؽ�Ʈ�ʵ�� �ű��.
				textFields[0].requestFocus();
			} catch (NumberFormatException e1) { // ���� �Է¶��� ���ڰ� �ƴ� ���� �ԷµǾ��� ���
				JOptionPane.showMessageDialog(
						null, 
						"������ ���ڰ� �ƴ� ���� �ԷµǾ����ϴ�.\n �ٽ� �Է��� �ּ���." , 
						"���",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	// ��� ��ư �׼� ������
	class PrintButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.setVisible(true);
		}
	}
	
	// ���̺��� ��µǴ� ���̾�α� Ŭ����
	class ScoreTableDialog extends JDialog {
		public ScoreTableDialog(JFrame frame, String title) {
			super(frame, title);
			
			// ���̺� column ����
			String[] header = new String[6];
			for (int i = 0; i < items.length; i++) {
				header[i] = items[i];
			}
			header[4] = "����";
			header[5] = "���";
			
			// header�� column���� �ϴ� ���̺� ����
			model = new DefaultTableModel(header, 0);
			JTable table = new JTable(model);
			
			// ���̺� �� ��� ����
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			table.setDefaultRenderer(Object.class, centerRenderer);
			
			// ���̾�α׿� ����
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