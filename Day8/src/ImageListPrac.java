import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageListPrac extends JFrame{

	private String[] fruits = {
			"apple", "banana", "kiwi", "mango"
	};
	
	private ImageIcon[] images = {
		new ImageIcon("images/cherry.jpg"),
		new ImageIcon("images/cherry.png"),
		new ImageIcon("images/selectedCherry.jpg"),
		new ImageIcon("images/selectedCherryIcon.jpg")
	};
	
	private JLabel imgLabel;
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);
	
	public ImageListPrac() {
		setTitle("Image Select");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(strCombo);
		
		for (int i = 0; i < images.length; i++) {
			Image originImg = images[i].getImage();
			Image changeImg = originImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			images[i] = new ImageIcon(changeImg);
		}
		imgLabel = new JLabel(images[0]);
		
		c.add(imgLabel);
		
		strCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				
				int index = cb.getSelectedIndex();
				
				imgLabel.setIcon(images[index]);
				
			}
		});
		
		setSize(300, 250);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ImageListPrac();

	}

}
