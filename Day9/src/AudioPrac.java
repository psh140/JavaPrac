import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AudioPrac extends JFrame {

	private Clip clip;
	private String song = "audio/애국가1절.wav";
	private JLabel label = new JLabel(song);

	public AudioPrac() {
		setTitle("애국가연주");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.YELLOW);
		c.add(label);
		setSize(300, 150);
		setVisible(true);
		loadAudio(song);
	}

	private void loadAudio(String pathName) {

		try {
			File auidoFile = new File(pathName);
			final AudioInputStream audioStream = AudioSystem.getAudioInputStream(auidoFile);
			
			clip = AudioSystem.getClip(); //비어있는 clip
			
			clip.addLineListener(new LineListener() {
				
				@Override
				public void update(LineEvent event) {
					if(event.getType() == LineEvent.Type.STOP) {
						try {
							getContentPane().setBackground(Color.ORANGE);
							label.setText(song + "연주 끝!");
							audioStream.close();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				}
			});
			
			clip.open(audioStream);
			clip.start();
			
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new AudioPrac();

	}

}
