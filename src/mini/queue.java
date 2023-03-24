package mini;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class queue extends JFrame {

	private JPanel contentPane;
	private JTextField size1;
	private JTextField element;
	private JTextField display;
	private int q[];
	private int size;
	private int front=0;
	private int rear=-1;
	private String msgt="";


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
					queue frame = new queue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("welcome to queue data structure");
	}

	/**
	 * Create the frame.
	 */
	public queue() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 722, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUEUE DATA STRUCTURE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel.setBounds(137, 10, 402, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER THE SIZE OF QUEUE");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(30, 101, 270, 25);
		contentPane.add(lblNewLabel_1);
		
		size1 = new JTextField();
		size1.setBounds(395, 107, 96, 21);
		contentPane.add(size1);
		size1.setColumns(10);
		
		JButton btnNewButton = new JButton("CREATE QUEUE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// creation of array
				size=Integer.valueOf(size1.getText());
				q=new int[size];
				String msg="QUEUE OF SIZE "+size+" CREATED";
				JOptionPane.showMessageDialog(contentPane, msg);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBounds(230, 157, 151, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("ENTER THE ELEMENT:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1_1.setBounds(30, 214, 213, 23);
		contentPane.add(lblNewLabel_1_1);
		
		element = new JTextField();
		element.setColumns(10);
		element.setBounds(395, 217, 96, 25);
		contentPane.add(element);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//queue insertion code
				if(rear==size-1)
				{
					JOptionPane.showMessageDialog(contentPane, "INSERTION NOT POSSIBLE");
					element.setText("");
				}
				else
				{
	
					int elem=Integer.valueOf(element.getText());
					++rear;
					q[rear]=elem;
					String msg="ELEMENT SUCESSFUL IS "+elem+"stored";
					JOptionPane.showMessageDialog(contentPane, msg);
					element.setText("");
				}
			}
			
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsert.setBackground(new Color(192, 192, 192));
		btnInsert.setBounds(213, 273, 126, 27);
		contentPane.add(btnInsert);
		
		JButton btnDeleteElement = new JButton("DELETE ELEMENT");
		btnDeleteElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText("");
				//deletion code
				if(rear==-1||front>rear)
				{
					JOptionPane.showMessageDialog(contentPane, "deletion not possible");
				}
				else
				{
					String msg="ELEMENT DELETE "+q[front]+"SUCESSFULL";
					JOptionPane.showMessageDialog(contentPane, msg);
					++front;
				}
			}
		});
		btnDeleteElement.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteElement.setBackground(new Color(192, 192, 192));
		btnDeleteElement.setBounds(202, 334, 162, 27);
		contentPane.add(btnDeleteElement);
		
		display = new JTextField();
		display.setColumns(10);
		display.setBounds(338, 402, 174, 25);
		contentPane.add(display);
		
		JButton btnNewButton_1 = new JButton("DISPLAY ELEMENT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DISPLAY METHOD
				display.setText("");
				if(rear==-1||front>rear)
				{
					JOptionPane.showMessageDialog(contentPane, "DISPLAY NOT POSSIBLE");
				}
				else
				{
				for(int i=front;i<=rear;i++)
				{
					 msgt=msgt+" "+q[i];
				}
				}
				display.setText(msgt);
				msgt="";
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(30, 399, 213, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				home h=new home();
				h.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(588, 402, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\download (3).jpeg"));
		lblNewLabel_2.setBounds(0, 0, 712, 427);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\download (3).jpeg"));
		lblNewLabel_3.setBounds(0, 0, 708, 439);
		contentPane.add(lblNewLabel_3);
	}
}
