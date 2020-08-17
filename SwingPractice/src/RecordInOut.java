
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

class PrintDialog extends JDialog{
	
	private String[] subject = {"�̸�", "����", "����", "����", "����", "���"};
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
	private JButton closeBtn 	= new JButton("�ݱ�");
	
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
	private PrintAlert alertDialog 	= new PrintAlert(RecordInOut.this, "���â", true);
	
	private JLabel[] labels			= new JLabel[4];
	private JTextField[] dataInput	= new JTextField[4];
	
	private JButton okBtn			= new JButton("Ȯ��");
	private JButton cancelBtn		= new JButton("���");
	private JButton printBtn		= new JButton("���");
	
	private ArrayList<String[]> info = new ArrayList<String[]>();
	
	public RecordInOut() {
		
		setTitle("���� �Է±�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�����̳�
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		//���ھ��Է� �г�
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new GridLayout(4,2));
		
		labels[0] = new JLabel("�̸�");
		labels[1] = new JLabel("����");
		labels[2] = new JLabel("����");
		labels[3] = new JLabel("����");
		
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
						alertDialog.setLabelText("������ �Է��� �ּ���.");
						alertDialog.setVisible(true);
						break;
					}
					else
					{
						if(i != 0) {
							int tmpVal = Integer.parseInt(dataInput[i].getText());
							
							if(tmpVal > 100) {
								alertDialog.setLabelText("100 ������ ���ڸ� �Է��ϼ���.");
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
				dialog = new PrintDialog(info, "���� ���̺�");
				dialog.setVisible(true);
			}
		});
		
		//�ϴ� ��ư �г�
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
		//�����̳ʿ� �� �г� �� ��� �߰�
		c.add(scorePanel);
		c.add(buttonPanel);
		
		setSize(400,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RecordInOut();
	}

}
