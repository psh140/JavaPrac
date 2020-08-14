import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPrac extends JFrame {
	private JLabel imgLabel = new JLabel();

	public MenuPrac() {
		setTitle("Menu Bar Practice");
		createMenu();
		getContentPane().add(imgLabel, BorderLayout.CENTER);
		setSize(250, 220);
		setVisible(true);

	}

	private void createMenu() {
		
		JMenuBar mb = new JMenuBar(); //�޴� ��
		JMenuItem itemLoad; //�Ӽ���
		JMenuItem itemHide;
		JMenuItem itemReShow;
		JMenuItem itemExit;
		
		JMenu screenMenu = new JMenu("SCREEN"); //�޴� �ٿ� ���� Ÿ��Ʋ
		
		MenuActionListener listener = new MenuActionListener();
		
		itemLoad = new JMenuItem("Load");
		itemHide = new JMenuItem("Hide");
		itemReShow = new JMenuItem("ReShow");
		itemExit = new JMenuItem("Exit");
		
		itemLoad.addActionListener(listener);
		itemHide.addActionListener(listener);
		itemReShow.addActionListener(listener);
		itemExit.addActionListener(listener);
		
		screenMenu.add(itemLoad);
		screenMenu.add(itemHide);
		screenMenu.add(itemReShow);
		screenMenu.add(itemExit);
		
		mb.add(screenMenu); //�޴� �ٿ� ���� �Ӽ� add
		setJMenuBar(mb); //�޴��� �����ӿ� ���̱�
		
	}
	
	class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); //������ �������� ���ڿ� ����
			switch (cmd) {
			case "Load":
				if (imgLabel.getIcon() != null) {
					return;
				}
				imgLabel.setIcon(new ImageIcon("images/cherry.jpg"));
				break;
			case "Hide":
				imgLabel.setVisible(false);
				break;
			case "ReShow":
				imgLabel.setVisible(true);
				break;
			case "Exit":
				System.exit(0);
				break;
			
			}
			
		}
		
	}

	public static void main(String[] args) {
		new MenuPrac();

	}

}
