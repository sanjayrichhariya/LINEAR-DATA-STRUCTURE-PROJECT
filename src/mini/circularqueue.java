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

public class circularqueue extends JFrame {

	private JPanel contentPane;
	private JTextField size1;
	private JTextField element;
	private JTextField display;
	private int cq[];
	private int size;
	private int rear=-1;
	private int front=0;
	private int count=0;
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
					circularqueue frame = new circularqueue();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("welcome to circular queue data structure");

	}

	/**
	 * Create the frame.
	 */
	public circularqueue() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 814, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CIRCULAR QUEUE DATA STRUCTURE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(122, 71, 558, 37);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterTheSize = new JLabel("ENTER THE SIZE:");
		lblEnterTheSize.setForeground(new Color(255, 255, 255));
		lblEnterTheSize.setBounds(174, 130, 170, 25);
		lblEnterTheSize.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblEnterTheSize);
		
		size1 = new JTextField();
		size1.setBounds(452, 137, 96, 19);
		contentPane.add(size1);
		size1.setColumns(10);
		
		JButton btnNewButton = new JButton("CREATE CIRCULAR QUEUE");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(296, 192, 295, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//creating circular queue
				size=Integer.valueOf(size1.getText());
				cq=new int[size];
				String msg="CIRCULAR QUEUE IS SIZE "+size+"CREATED";
				JOptionPane.showMessageDialog(contentPane, msg);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(192, 192, 192));
		contentPane.add(btnNewButton);
		
		JLabel lblEnterTheElement = new JLabel("ENTER THE ELEMENT:");
		lblEnterTheElement.setForeground(new Color(255, 255, 255));
		lblEnterTheElement.setBounds(146, 253, 215, 25);
		lblEnterTheElement.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblEnterTheElement);
		
		element = new JTextField();
		element.setBounds(452, 253, 96, 19);
		element.setColumns(10);
		contentPane.add(element);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.setBounds(344, 305, 123, 25);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insertion the circular queue
			
				if(count==size)
				{
					JOptionPane.showMessageDialog(contentPane, "insertion not possible");
					element.setText("");
					
				}
				else
				{
					int elem=Integer.valueOf(element.getText());
					rear=(rear+1)%size;
					cq[rear]=elem;
					count++;
					String msg="ELEMENT INSERT"+elem+"sucessfull";
					JOptionPane.showMessageDialog(contentPane, msg);
					element.setText("");
				}
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnInsert.setBackground(new Color(192, 192, 192));
		contentPane.add(btnInsert);
		
		JButton delete = new JButton("DELETE");
		delete.setBounds(344, 364, 123, 25);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//deletion process in circular queue
				display.setText("");
				if(count==0)
				{
					JOptionPane.showMessageDialog(contentPane, "deletion not posssible");
				}
				else
				{
					String msg="ELEMENT DELETE IS "+cq[front];
					JOptionPane.showMessageDialog(contentPane, msg);
					front=(front+1)%size;
					count--;
				}
			}
		});
		delete.setFont(new Font("Tahoma", Font.BOLD, 20));
		delete.setBackground(new Color(192, 192, 192));
		contentPane.add(delete);
		
		JButton Display = new JButton("DISPLAY");
		Display.setBounds(122, 413, 123, 25);
		Display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//display the element
				int f1=front;
				if(count==0)
				{
				JOptionPane.showMessageDialog(contentPane, "display not possible");
				}
				else
				{
					for(int i=1;i<=count;i++)
					{
						msgt=msgt+" "+cq[f1];
						f1=(f1+1)%size;
					}
				}
				display.setText(msgt);
				msgt="";
			}
		});
		Display.setFont(new Font("Tahoma", Font.BOLD, 20));
		Display.setBackground(new Color(192, 192, 192));
		contentPane.add(Display);
		
		display = new JTextField();
		display.setFont(new Font("Tahoma", Font.PLAIN, 15));
		display.setBounds(344, 415, 136, 25);
		display.setColumns(10);
		contentPane.add(display);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(0, 574, 144, 46);
		lblNewLabel_1.setIcon(null);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				home h=new home();
				h.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(685, 433, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\images (3).jpeg"));
		lblNewLabel_2.setBounds(0, 0, 800, 464);
		contentPane.add(lblNewLabel_2);
	}
}
