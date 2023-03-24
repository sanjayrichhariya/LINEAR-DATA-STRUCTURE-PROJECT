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
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class stack extends JFrame {

	private JPanel contentPane;
	private JTextField size;
	private JTextField element;
	private JTextField display;
	private int s[];
	private int size1;
	private int top=-1;

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
					stack frame = new stack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("welcome to stack data structure");
	}

	/**
	 * Create the frame.
	 */
	public stack() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 862, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STACK DATA STRUCTURE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel.setBackground(new Color(255, 0, 128));
		lblNewLabel.setBounds(225, 0, 397, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterTheStack = new JLabel("ENTER THE STACK SIZE :");
		lblEnterTheStack.setForeground(new Color(255, 255, 255));
		lblEnterTheStack.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterTheStack.setBackground(new Color(255, 0, 128));
		lblEnterTheStack.setBounds(178, 107, 247, 25);
		contentPane.add(lblEnterTheStack);
		
		JButton btnNewButton = new JButton("CREATE STACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// stack creation code
				size1=Integer.valueOf(size.getText());
				s=new int[size1];
				String msg="stack of size"+size1+"created";
				JOptionPane.showMessageDialog(contentPane, msg);
			
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setBounds(457, 172, 149, 45);
		contentPane.add(btnNewButton);
		
		size = new JTextField();
		size.setBounds(478, 99, 128, 45);
		contentPane.add(size);
		size.setColumns(10);
		
		JLabel lblEnterTheElement = new JLabel("ENTER THE ELEMENT:");
		lblEnterTheElement.setForeground(new Color(255, 255, 255));
		lblEnterTheElement.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterTheElement.setBackground(new Color(255, 0, 128));
		lblEnterTheElement.setBounds(65, 242, 215, 25);
		contentPane.add(lblEnterTheElement);
		
		element = new JTextField();
		element.setColumns(10);
		element.setBounds(347, 242, 96, 28);
		contentPane.add(element);
		
		JButton btnPop = new JButton("PUSH");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(top==size1-1)
				{
				
					JOptionPane.showMessageDialog(contentPane, "push not possible");	
					element.setText("");
				}
				else
				{
					int elem=Integer.valueOf(element.getText());
					++top;
					s[top]=elem;
					JOptionPane.showMessageDialog(contentPane, "push successfull");	
					element.setText("");
				}
			}
		});
		btnPop.setForeground(Color.BLACK);
		btnPop.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPop.setBackground(Color.YELLOW);
		btnPop.setBounds(478, 242, 128, 38);
		contentPane.add(btnPop);
		
		JButton btnPop_1 = new JButton("POP");
		btnPop_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(top==-1)
				{
					JOptionPane.showMessageDialog(contentPane, "pop not possible");	
				}
				else
				{
					String msg="element deleted is"+s[top];
					JOptionPane.showMessageDialog(contentPane, msg);
					--top;
				}
				
			}
		});
		btnPop_1.setForeground(Color.BLACK);
		btnPop_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPop_1.setBackground(Color.YELLOW);
		btnPop_1.setBounds(515, 317, 119, 38);
		contentPane.add(btnPop_1);
		
		JButton btnPop_1_1 = new JButton("DISPLAY");
		btnPop_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msgt="";
				if(top==-1)
				{
					JOptionPane.showMessageDialog(contentPane, "display not possible");
				}
				else
				{
				for(int i=0;i<=top;i++)
				{
					 msgt=msgt+" "+s[i];
				}
				}
				display.setText(msgt);
			}
		});
		btnPop_1_1.setForeground(Color.BLACK);
		btnPop_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPop_1_1.setBackground(Color.YELLOW);
		btnPop_1_1.setBounds(126, 393, 103, 27);
		contentPane.add(btnPop_1_1);
		
		display = new JTextField();
		display.setColumns(10);
		display.setBounds(421, 382, 234, 38);
		contentPane.add(display);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				home h=new home();
				h.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(729, 398, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\download (1) (1).jpeg"));
		lblNewLabel_1.setBounds(0, 0, 848, 439);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\download (1) (1).jpeg"));
		lblNewLabel_2.setBounds(0, 0, 848, 439);
		contentPane.add(lblNewLabel_2);
	}
}
