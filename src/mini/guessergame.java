package mini;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;

public class guessergame extends JFrame {

	private JPanel contentPane;
	private JTextField guesser;
	private JTextField player1;
	private JTextField player2;
	private JTextField player3;
	private JTextField DISPLAY;
	private Random random=new Random();

	/**
	 * Launch the application.
	 */
	private static  void speech_Button_Action(String text)
    {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice("kevin16");
        voice.allocate();
        voice.speak(text);
    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guessergame frame = new guessergame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("welcome to guesser game");
	}

	/**
	 * Create the frame.
	 */
	public guessergame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO GUESSER GAME");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(121, 10, 455, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("START GAME");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// start game code
				int number=random.nextInt(10);
				int num1=random.nextInt(10);
				int num2=random.nextInt(10);
				int num3=random.nextInt(10);
				
				String s1=String.valueOf(number);
				guesser.setText(s1);
				
				String s2=String.valueOf(num1);
				player1.setText(s2);
				
				String s3=String.valueOf(num2);
				player2.setText(s3);
				
				String s4=String.valueOf(num3);
				player3.setText(s4);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(300, 86, 152, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("GUESSER GUESS THE NUMBER :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(85, 154, 227, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PLAYER 1  GUESS THE NUMBER :");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(85, 195, 234, 17);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PLAYER 2  GUESS THE NUMBER :");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(85, 237, 234, 17);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("PLAYER 3  GUESS THE NUMBER :");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(85, 280, 234, 17);
		contentPane.add(lblNewLabel_1_3);
		
		guesser = new JTextField();
		guesser.setBounds(406, 155, 96, 19);
		contentPane.add(guesser);
		guesser.setColumns(10);
		
		player1 = new JTextField();
		player1.setColumns(10);
		player1.setBounds(406, 196, 96, 19);
		contentPane.add(player1);
		
		player2 = new JTextField();
		player2.setColumns(10);
		player2.setBounds(406, 238, 96, 19);
		contentPane.add(player2);
		
		player3 = new JTextField();
		player3.setColumns(10);
		player3.setBounds(406, 281, 96, 19);
		contentPane.add(player3);
		
		JButton btnNewButton_1 = new JButton("UMPIRE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(guesser.getText())==Integer.valueOf(player1.getText()))
				{
					DISPLAY.setText("player one win the game");
					
				}
				else if(Integer.valueOf(guesser.getText())==Integer.valueOf(player2.getText()))
				{
					DISPLAY.setText("player two win the game");
				}
				else if(Integer.valueOf(guesser.getText())==Integer.valueOf(player3.getText()))
				{
					DISPLAY.setText("player three win the game");
				}
				else
				{
					DISPLAY.setText("game lost");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(317, 335, 116, 29);
		contentPane.add(btnNewButton_1);
		
		DISPLAY = new JTextField();
		DISPLAY.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DISPLAY.setColumns(10);
		DISPLAY.setBounds(220, 373, 282, 29);
		contentPane.add(DISPLAY);
		
		JButton btnEndGame = new JButton("END GAME");
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//end code game
				System.exit(0);
			}
		});
		btnEndGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEndGame.setBounds(319, 412, 133, 27);
		contentPane.add(btnEndGame);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\anime-anime-girls-original-characters-short-hair-wallpaper-preview.jpg"));
		lblNewLabel_2.setBounds(0, 0, 727, 449);
		contentPane.add(lblNewLabel_2);
	}
}

