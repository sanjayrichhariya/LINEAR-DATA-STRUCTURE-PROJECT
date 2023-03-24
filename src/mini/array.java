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

public class array extends JFrame {

	private JPanel contentPane;
	private JTextField length;
	private JTextField element;
	private JTextField position;
	private JTextField position1;
	private JTextField display;
	private int arr[];
	int lenn=0;
	int pos1=0;

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
					array frame = new array();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("welcome to arrays data structure");
	}

	/**
	 * Create the frame.
	 */
	public array() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 861, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ARRAY DATA STRUCTURE");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(303, 10, 391, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterArrayElement = new JLabel("ENTER ARRAY LENGTH :");
		lblEnterArrayElement.setForeground(new Color(255, 255, 255));
		lblEnterArrayElement.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterArrayElement.setBackground(new Color(255, 255, 255));
		lblEnterArrayElement.setBounds(273, 94, 240, 25);
		contentPane.add(lblEnterArrayElement);
		
		length = new JTextField();
		length.setBounds(615, 99, 96, 23);
		contentPane.add(length);
		length.setColumns(10);
		
		JButton createlength = new JButton("CREATE ARRAY");
		createlength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for creating array
				//String len=length.getText();
				//int l=Integer.valueOf(len);
				int len=Integer.valueOf(length.getText());
				lenn=len;
				arr=new int [len];
				String message="Array of length"+len+"created";
				JOptionPane.showMessageDialog(contentPane, message);
			
			}
		});
		createlength.setFont(new Font("Tahoma", Font.PLAIN, 20));
		createlength.setForeground(new Color(128, 0, 0));
		createlength.setBounds(442, 145, 196, 33);
		contentPane.add(createlength);
		
		JLabel lblEnterArrayInteger = new JLabel("ENTER ARRAY INTEGER ELEMENT :");
		lblEnterArrayInteger.setForeground(new Color(255, 255, 255));
		lblEnterArrayInteger.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterArrayInteger.setBackground(new Color(255, 255, 255));
		lblEnterArrayInteger.setBounds(197, 204, 347, 25);
		contentPane.add(lblEnterArrayInteger);
		
		element = new JTextField();
		element.setBounds(652, 208, 59, 26);
		contentPane.add(element);
		element.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTER THE POSITION");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBounds(197, 257, 281, 33);
		contentPane.add(btnNewButton);
		
		position = new JTextField();
		position.setColumns(10);
		position.setBounds(579, 261, 59, 33);
		contentPane.add(position);
		
		JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// code for insertion
				int elem=Integer.valueOf(element.getText());
				int pos=Integer.valueOf(position.getText());
				if(pos>=lenn) {
					String message="Length Exceed";
					JOptionPane.showMessageDialog(contentPane, message);
					element.setText("");
					position.setText("");
					return;
				}
				arr[pos]=elem;
				String message="ELEMENT"+elem+"INSERTED @ POSITION"+pos;
				JOptionPane.showMessageDialog(contentPane, message);
				element.setText("");
				position.setText("");
						
				
			}
		});
		btnInsert.setForeground(new Color(128, 0, 0));
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInsert.setBounds(719, 261, 131, 25);
		contentPane.add(btnInsert);
		
		JButton btnDe = new JButton("ENTER THE POSITION");
		btnDe.setForeground(new Color(128, 0, 0));
		btnDe.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDe.setBounds(197, 329, 281, 33);
		contentPane.add(btnDe);
		
		position1 = new JTextField();
		position1.setColumns(10);
		position1.setBounds(579, 334, 59, 32);
		contentPane.add(position1);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//code for deletion
				int pos=Integer.valueOf(position1.getText());
				if(pos<0||pos>=lenn)
				{
					String mes="ARRAY IS EMPTY";
					JOptionPane.showMessageDialog(contentPane, mes);
					position1.setText("");
					return;
				}
				arr[pos]=0;
				position1.setText("");
				String message="ELEMENT DELETED @ THE POSITION "+pos;
				JOptionPane.showMessageDialog(contentPane, message);
			}
		});
		btnDelete.setForeground(new Color(128, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(719, 333, 131, 25);
		contentPane.add(btnDelete);
		
		JButton btnDisplayArray = new JButton("DISPLAY ARRAY");
		btnDisplayArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display the content
				String msg="";
				for (int i=0;i<=arr.length-1;i++)
				{
					msg=msg+" "+arr[i];
				}
				display.setText(msg);
			}
		});
		btnDisplayArray.setForeground(new Color(128, 0, 0));
		btnDisplayArray.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDisplayArray.setBounds(60, 432, 219, 33);
		contentPane.add(btnDisplayArray);
		
		display = new JTextField();
		display.setColumns(10);
		display.setBounds(368, 441, 206, 23);
		contentPane.add(display);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				home h=new home();
				h.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(755, 440, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\images (1).jpeg"));
		lblNewLabel_1.setBounds(0, 0, 850, 465);
		contentPane.add(lblNewLabel_1);
	}
}
