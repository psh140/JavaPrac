import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicPrac extends JFrame{

	private MyPanel panel = new MyPanel();
	
	public GraphicPrac() {
		setTitle("Color, Font Practice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(350, 1000);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawString("I love you!", 30, 30);
			g.setColor(new Color(255, 0, 0));
			g.setFont(new Font("Arial", Font.ITALIC, 30));
			g.drawString("How much?", 30, 60);
			g.setColor(new Color(0x00ff00ff));
			for (int i = 0; i <= 5; i++) {
				g.setFont(new Font("Jokerman", Font.ITALIC, i * 10));
				g.drawString("THIS MUCH !", 30, 60 + i * 60);
			}
			
			g.setColor(Color.RED);
			g.fillRect(10, 400, 50, 50);
			g.setColor(Color.BLUE);
			g.fillOval(10, 460, 50, 50);
			g.setColor(Color.GREEN);
			g.fillRoundRect(10, 520, 50, 50, 20, 20);
			g.setColor(Color.MAGENTA);
			g.fillArc(10, 580, 50, 50, 0, 270);
			g.setColor(Color.ORANGE);
			int[] x = {30, 10, 30, 60};
			int[] y = {250,275, 300,275};
			g.fillPolygon(x, y, 4);
		}
	}
	
	public static void main(String[] args) {
		new GraphicPrac();

	}

}
