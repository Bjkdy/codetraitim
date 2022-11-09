import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class myFrame extends JFrame implements ActionListener
{
	JButton button;
	JButton button2;
	JButton button3;
	JLabel label;
	private Clip clip = null;
	private File file = new File("PinkVenom.wav");
	private AudioInputStream audioStream = null;
	boolean isRunning = false;
	
	myFrame(){
	//	ImageIcon icon = new ImageIcon("tim.png");

		jLabel();
		buttonPlay();
		buttonStop();
		buttonNext();
		buttonNext();
		this.setFont(new Font("MV Times New Roman",Font.BOLD,20));	
		this.setTitle("CODE BỊP");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(label);
		this.add(button);
		this.add(button2);
		this.add(button3);
		this.setLayout(null);
		this.setSize(2000, 1000);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(!isRunning)
		{
		try {
			audioStream = AudioSystem.getAudioInputStream(file);
		} catch (UnsupportedAudioFileException | IOException e1) {
			e1.printStackTrace();
		}
			try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
		 try {
			clip.open(audioStream);
		} catch (LineUnavailableException | IOException e1) {
			e1.printStackTrace();
		}
		}
		if(e.getSource()==button)
		{
			System.out.println("Nhac dang hat");
			if(!clip.isActive())
			clip.start();
			isRunning=true;
		}
		if(e.getSource()==button2)
		{
			System.out.println("Nhac dung");
			clip.stop();
		}
		if (e.getSource()==button3) {
			isRunning=false;
			 clip.setMicrosecondPosition(0);	
				isRunning=true;
		}
	}
	public void buttonPlay ()
	{
		button = new JButton();
		button.setBounds(550, 500, 75,50);
		button.addActionListener(this);
		button.setText("Play");
		button.setFocusable(false);
		//button.setIcon(icon);
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setFont(new Font("MV Times New Roman",Font.BOLD,20));
		button.setIconTextGap(25);
		button.setForeground(Color.RED);

	}
	public void buttonStop()
	{
		button2 = new JButton();
		button2.setBounds(450, 500,80,50);
		button2.addActionListener(this);
		button2.setText("Stop");
		button2.setFocusable(false);
		button2.setVerticalTextPosition(SwingConstants.BOTTOM);
		button2.setHorizontalTextPosition(SwingConstants.LEFT);
		button2.setIconTextGap(25);
		button2.setForeground(Color.RED);
		button2.setFont(new Font("MV Times New Roman",Font.BOLD,20));
	}

	public void buttonNext()
	{
		button3 = new JButton();
		button3.setBounds(645,500,90,50);
		button3.setText("Next");
		button3.addActionListener(this);
		button3.setFocusable(false);
		button3.setVerticalTextPosition(SwingConstants.BOTTOM);
		button3.setHorizontalTextPosition(SwingConstants.LEFT);
		button3.setIconTextGap(25);
		button3.setForeground(Color.RED);
		button3.setFont(new Font("MV Times New Roman",Font.BOLD,20));

	}
	public void jLabel()
	{
	//	ImageIcon icon2 = new ImageIcon("tim.png");
		ImageIcon icon1 = new ImageIcon("venom.png");
		label = new JLabel();
		label.setBackground(Color.black);
		label.setIcon(icon1);
		label.setText("FAN BOY");
		label.setFont(new Font("MV Times New Roman",Font.BOLD,50));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setIconTextGap(26);
		label.setForeground(new Color(255,192,203));
		label.setBounds(150, -250, 1000, 1000);
		label.setVisible(true);
	}
	
}
