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

public class doublylinklist extends JFrame {

	private JPanel contentPane;
	private JTextField element1;
	private JTextField element2;
	private JTextField display1;
	private JTextField display2;
	private node first;
	class node
	{
		node prelink;
		int data;
		node nextlink;
	}
	private static  void speech_Button_Action(String text)
    {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice("kevin16");
        voice.allocate();
        voice.speak(text);
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doublylinklist frame = new doublylinklist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("welcome to doubly linked list data structure");
		
	}

	/**
	 * Create the frame.
	 */
	public doublylinklist() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 832, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER THE ELEMENT:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(29, 181, 185, 21);
		contentPane.add(lblNewLabel_1);
		
		element1 = new JTextField();
		element1.setBounds(275, 185, 96, 19);
		contentPane.add(element1);
		element1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("ENTER THE ELEMENT:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(29, 232, 185, 21);
		contentPane.add(lblNewLabel_1_1);
		
		element2 = new JTextField();
		element2.setColumns(10);
		element2.setBounds(275, 236, 96, 19);
		contentPane.add(element2);
		
		JButton btnNewButton = new JButton("INSERT FRONT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insertion front
				int elem=Integer.valueOf(element1.getText());
				node newnode=new node();
				newnode.prelink=null;
				newnode.nextlink=null;
				newnode.data=elem;
				if(first==null)
				{
					first=newnode;
					String msg="ELEMENT INSERTED"+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					element1.setText("");
				}
				else
				{
					newnode.nextlink=first;
					first.prelink=newnode;
					first=newnode;
					String msg="ELEMENT INSERTED"+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					element1.setText("");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(485, 180, 152, 25);
		contentPane.add(btnNewButton);
		
		JButton btnInsertRear = new JButton("INSERT REAR");
		btnInsertRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insertion rear
				node temp;
				int elem=Integer.valueOf(element2.getText());
				node newnode=new node();
				newnode.prelink=null;
				newnode.data=elem;
				newnode.nextlink=null;
				if(first==null)
				{
					first=newnode;
					String msg="ELEMENT INSERTED"+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					element2.setText("");
				}
				else
				{
					temp=first;
					while(temp.nextlink!=null)
					{
						temp=temp.nextlink;
					}
					temp.nextlink=newnode;
					newnode.prelink=temp;
					String msg="ELEMENT INSERTED"+newnode.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					
				}
			}
		});
		btnInsertRear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsertRear.setBounds(485, 236, 141, 25);
		contentPane.add(btnInsertRear);
		
		JButton btnDeleteFront = new JButton("DELETE FRONT");
		btnDeleteFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//deletion front
				display1.setText("");
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane, "deletion not possible");
				}
				else if(first.nextlink==null)
				{
					String msg="ELEMENT DELETED"+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=null;
				}
				else
				{
					String msg="ELEMENT DELETED"+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=first.nextlink;
					first.prelink=null;
				}
				display1.setText("");
				display2.setText("");
			}
		});
		btnDeleteFront.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteFront.setBounds(122, 288, 165, 25);
		contentPane.add(btnDeleteFront);
		
		JButton btnDeleteRear = new JButton("DELETE REAR");
		btnDeleteRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DELETION REAR
				node temp;
				display2.setText("");
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane, "deletion not possible");
				}
				else if(first.nextlink==null)
				{
					String msg="ELEMENT DELETED"+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=null;
				}
				else
				{
					temp=first;
					while(temp.nextlink.nextlink!=null)
					{
						temp=temp.nextlink;
					}
					String msg="ELEMENT DELETED"+temp.nextlink.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					temp.nextlink=null;
				}
				display1.setText("");
				display2.setText("");
			}
		});
		btnDeleteRear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDeleteRear.setBounds(415, 288, 141, 25);
		contentPane.add(btnDeleteRear);
		
		JButton btnDisplayForward = new JButton("DISPLAY FORWARD");
		btnDisplayForward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//display forward
				node temp;
				String msg="";
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane, "dnot possible");
				}
				else if(first.nextlink==null)
				{
				    msg=String.valueOf(first.data);
					display1.setText(msg);
				
				}
				else
				{
					temp=first;
					while(temp!=null)
					{
						msg=msg+" "+temp.data;
						temp=temp.nextlink;
					}
					display1.setText(msg);
					msg="";
				}
			}
		});
		btnDisplayForward.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDisplayForward.setBounds(110, 345, 191, 25);
		contentPane.add(btnDisplayForward);
		
		JButton btnDisplayReverse = new JButton("DISPLAY REVERSE");
		btnDisplayReverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//display reverse
				node temp;
				String msg="";
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane, "dnot possible");
				}
				else if(first.nextlink==null)
				{
					msg=String.valueOf(first.data);
					display1.setText(msg);
					display1.setText("");
				
				}
				else
				{
					temp=first;
					while(temp.nextlink!=null)
					{
						temp=temp.nextlink;
					}
					while(temp!=null)
					{
						msg=msg+" "+temp.data;
						temp=temp.prelink;
					}
					display2.setText(msg);
					msg="";
				}
			}
		});
		btnDisplayReverse.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDisplayReverse.setBounds(110, 392, 191, 25);
		contentPane.add(btnDisplayReverse);
		
		display1 = new JTextField();
		display1.setColumns(10);
		display1.setBounds(426, 347, 170, 25);
		contentPane.add(display1);
		
		display2 = new JTextField();
		display2.setColumns(10);
		display2.setBounds(426, 394, 170, 25);
		contentPane.add(display2);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				home h=new home();
				h.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(727, 412, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\download (4).jpeg"));
		lblNewLabel_2.setBounds(0, 0, 822, 443);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\download (4).jpeg"));
		lblNewLabel.setBounds(0, 0, 818, 437);
		contentPane.add(lblNewLabel);
	}
}
