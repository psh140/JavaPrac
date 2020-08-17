
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

class PrintDialog extends JDialog{
	
	private String[] subject = {"이름", "국어", "영어", "수학", "총점", "평균"};
	private String[][] scoreArr;
	
	private JTable table;
	
	public PrintDialog(ArrayList<String[]> score, String title) {

		setTitle(title);
		Container pd = getContentPane();
		pd.setLayout(new FlowLayout());
		
		scoreArr = new String[score.size()][6];
		
		for(int i=0; i<score.size(); i++)
		{
			int sum 		= 0;
			double aver 	= 0;
			
			scoreArr[i] = score.get(i);
			
			sum += Integer.parseInt(scoreArr[i][1]);
			sum += Integer.parseInt(scoreArr[i][2]);
			sum += Integer.parseInt(scoreArr[i][3]);
			
			aver = sum / 3.0;
			
			scoreArr[i][4] = Integer.toString(sum);
			scoreArr[i][5] = Double.toString(aver);
		}

		table = new JTable(scoreArr, subject);
		JScrollPane tableScp = new JScrollPane(table);
		
		pd.add(tableScp);
		
		setSize(500,200);
	}

}

class PrintAlert extends JDialog{
	
	private JLabel jText 		= new JLabel();
	private JButton closeBtn 	= new JButton("닫기");
	
	public PrintAlert(JFrame frame, String title, boolean modal) {
	
		super(frame, title, modal);
		
		Container pa = getContentPane();
		pa.setLayout(new FlowLayout());
		
		closeBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		
		pa.add(jText);
		pa.add(closeBtn);
		
		setSize(300,150);
	}
	
	public void setLabelText(String text)
	{
		this.jText.setText(text);
	}

}

public class RecordInOut extends JFrame{
	
	private PrintDialog dialog;
	private PrintAlert alertDialog 	= new PrintAlert(RecordInOut.this, "경고창", true);
	
	private JLabel[] labels			= new JLabel[4];
	private JTextField[] dataInput	= new JTextField[4];
	
	private JButton okBtn			= new JButton("확인");
	private JButton cancelBtn		= new JButton("취소");
	private JButton printBtn		= new JButton("출력");
	
	private ArrayList<String[]> info = new ArrayList<String[]>();
	
	public RecordInOut() {
		
		setTitle("성적 입력기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//컨테이너
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		//스코어입력 패널
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new GridLayout(4,2));
		
		labels[0] = new JLabel("이름");
		labels[1] = new JLabel("국어");
		labels[2] = new JLabel("영어");
		labels[3] = new JLabel("수학");
		
		for(int i=0; i<labels.length; i++)
		{
			dataInput[i] = new JTextField("",12);
			scorePanel.add(labels[i]);
			scorePanel.add(dataInput[i]);
		}
		
		
		okBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				boolean dataCheck		= false;
				String[] scoreArr		= new String[6];
				
				for(int i=0; i<4; i++) {
					
					if(dataInput[i].getText().equals("")) {
						alertDialog.setLabelText("정보를 입력해 주세요.");
						alertDialog.setVisible(true);
						break;
					}
					else
					{
						if(i != 0) {
							int tmpVal = Integer.parseInt(dataInput[i].getText());
							
							if(tmpVal > 100) {
								alertDialog.setLabelText("100 이하의 숫자를 입력하세요.");
								alertDialog.setVisible(true);
								break;
							}
							else {
								dataCheck 	= true;
							}
						}
					}
				}
				
				if(dataCheck == true) {
					for(int i=0; i<4; i++) {
						scoreArr[i] = dataInput[i].getText();
						dataInput[i].setText("");
					}
					info.add(scoreArr);
				}
			}
		});
		
		printBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dialog = new PrintDialog(info, "점수 테이블");
				dialog.setVisible(true);
			}
		});
		
		//하단 버튼 패널
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(okBtn);
		buttonPanel.add(printBtn);
		buttonPanel.add(cancelBtn);
		
		cancelBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//컨테이너에 각 패널 및 요소 추가
		c.add(scorePanel);
		c.add(buttonPanel);
		
		setSize(400,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RecordInOut();
	}

}
