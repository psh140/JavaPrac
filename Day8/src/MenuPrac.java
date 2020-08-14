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
		
		JMenuBar mb = new JMenuBar(); //메뉴 바
		JMenuItem itemLoad; //속성들
		JMenuItem itemHide;
		JMenuItem itemReShow;
		JMenuItem itemExit;
		
		JMenu screenMenu = new JMenu("SCREEN"); //메뉴 바에 들어가는 타이틀
		
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
		
		mb.add(screenMenu); //메뉴 바에 하위 속성 add
		setJMenuBar(mb); //메뉴바 프레임에 붙이기
		
	}
	
	class MenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); //선택한 아이템의 문자열 리턴
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
