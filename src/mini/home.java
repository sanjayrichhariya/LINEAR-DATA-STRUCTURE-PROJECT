package mini;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class home extends JFrame {

	private JPanel contentPane;

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
					home frame = new home();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		speech_Button_Action("welcome to data structure");
	}

	/**
	 * Create the frame.
	 */
	public home() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 409);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton array = new JButton("ARRAY");
		array.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//array	a=new array();
			//a.setVisible(true);
				new array().setVisible(true);
				//music code
			}
		});
		array.setBackground(new Color(255, 255, 255));
		array.setFont(new Font("Tahoma", Font.BOLD, 18));
		array.setBounds(285, 103, 103, 37);
		contentPane.add(array);
		
		JButton stack = new JButton("STACK");
		stack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new stack().setVisible(true);
			}
		});
		stack.setFont(new Font("Tahoma", Font.BOLD, 18));
		stack.setBackground(new Color(255, 255, 255));
		stack.setBounds(35, 169, 99, 37);
		contentPane.add(stack);
		
		JButton queue = new JButton("QUEUE");
		queue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new queue().setVisible(true);
			}
		});
		queue.setFont(new Font("Tahoma", Font.BOLD, 17));
		queue.setBackground(new Color(255, 255, 255));
		queue.setBounds(538, 169, 105, 37);
		contentPane.add(queue);
		
		JButton circularqueue = new JButton("CIRCULAR QUEUE");
		circularqueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new circularqueue().setVisible(true);
			}
		});
		circularqueue.setFont(new Font("Tahoma", Font.BOLD, 18));
		circularqueue.setBackground(new Color(255, 255, 255));
		circularqueue.setBounds(445, 324, 217, 37);
		contentPane.add(circularqueue);
		
		JButton singlylinklist = new JButton("SINGLY LINKED LIST");
		singlylinklist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Singlylinklist().setVisible(true);
			}
		});
		singlylinklist.setFont(new Font("Tahoma", Font.BOLD, 18));
		singlylinklist.setBackground(new Color(255, 255, 255));
		singlylinklist.setBounds(0, 324, 247, 37);
		contentPane.add(singlylinklist);
		
		JButton doublylinklist = new JButton("DOUBLY  LINKED LIST");
		doublylinklist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new doublylinklist().setVisible(true);
			}
		});
		doublylinklist.setFont(new Font("Tahoma", Font.BOLD, 18));
		doublylinklist.setBackground(new Color(255, 255, 255));
		doublylinklist.setBounds(170, 225, 341, 37);
		contentPane.add(doublylinklist);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\download (2).jpeg"));
		lblNewLabel_1.setBounds(0, 0, 691, 380);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\download (2).jpeg"));
		lblNewLabel.setBounds(0, 0, 691, 380);
		contentPane.add(lblNewLabel);
		
	}
}
