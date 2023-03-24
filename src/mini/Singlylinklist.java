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
import javax.swing.SwingConstants;

public class Singlylinklist extends JFrame {

	private JPanel contentPane;
	private JTextField element1;
	private JTextField element2;
	private JTextField display;
	private node first;

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
	class node
	{
		int data;
		node link;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Singlylinklist frame = new Singlylinklist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		speech_Button_Action("welcome to singly linked list data structure");
	}

	/**
	 * Create the frame.
	 */
	public Singlylinklist() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 855, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SINGLY LINKED LIST DATA STRUCTURE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(99, 0, 626, 38);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 31));
		contentPane.add(lblNewLabel);
		
		JLabel lblEnterTheElement = new JLabel("ENTER THE ELEMENT:");
		lblEnterTheElement.setForeground(new Color(255, 255, 255));
		lblEnterTheElement.setBounds(99, 142, 215, 25);
		lblEnterTheElement.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblEnterTheElement);
		
		JLabel lblEnterTheElement_1 = new JLabel("ENTER THE ELEMENT:");
		lblEnterTheElement_1.setForeground(new Color(255, 255, 255));
		lblEnterTheElement_1.setBounds(99, 203, 223, 20);
		lblEnterTheElement_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblEnterTheElement_1);
		
		element1 = new JTextField();
		element1.setBounds(389, 149, 96, 19);
		contentPane.add(element1);
		element1.setColumns(10);
		
		element2 = new JTextField();
		element2.setBounds(389, 208, 96, 19);
		element2.setColumns(10);
		contentPane.add(element2);
		
		JButton btnNewButton = new JButton("INSERT FRONT");
		btnNewButton.setBounds(542, 142, 196, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insertion front
				
				int elem=Integer.valueOf(element1.getText());
				node newnode=new node();
				newnode.data=elem;
				newnode.link=null;
				String msg="ELEMENT INSERT AT FRONT "+elem;
				JOptionPane.showMessageDialog(contentPane, msg);
				element1.setText("");
				if(first==null)
				{
					first=newnode;
				}
				else
				{
					newnode.link=first;
					first=newnode;
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		JButton btnInsertRear = new JButton("INSERT REAR");
		btnInsertRear.setBounds(542, 203, 196, 33);
		btnInsertRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//insertion at rear
				node temp;
				int elem=Integer.valueOf(element2.getText());
				node newnode=new node();
				newnode.data=elem;
				newnode.link=null;
				String msg="ELEMENT INSERT AT FRONT "+elem;
				JOptionPane.showMessageDialog(contentPane, msg);
				element2.setText("");
				if(first==null)
				{
					first=newnode;
				}
				else
				{
					temp=first;
					while(temp.link!=null)
					{
						temp=temp.link;
					}
					temp.link=newnode;
				}
			}
		});
		btnInsertRear.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnInsertRear);
		
		JButton btnDeleteFront = new JButton("DELETE FRONT");
		btnDeleteFront.setBounds(335, 266, 207, 33);
		btnDeleteFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//deletion front
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane, "deletion not possible");
				}
				else if(first.link==null)
				{
					String msg="ELEMENT DELETED IS FRONT "+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=null;
				}
				else
				{
					String msg="ELEMENT DELETED IS FRONT "+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=first.link;
				}
			}
		});
		btnDeleteFront.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnDeleteFront);
		
		JButton btnDeleteRear = new JButton("DELETE REAR");
		btnDeleteRear.setBounds(335, 336, 181, 33);
		btnDeleteRear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//deletion rear
				node temp;
				display.setText("");
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane, "deletion not possible");
				}
				else if(first.link==null)
				{
					String msg="ELEMENT DELETED IS FRONT "+first.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					first=null;
				}
				
				else
				{
					temp=first;
					while(temp.link.link!=null)
					{
						temp=temp.link;
					}
					String msg="ELEMENT DELETED IS FRONT "+temp.link.data;
					JOptionPane.showMessageDialog(contentPane, msg);
					temp.link=null;
				}
			}
		});
		btnDeleteRear.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnDeleteRear);
		
		JButton btnDisplay = new JButton("DISPLAY");
		btnDisplay.setBounds(133, 417, 137, 33);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispaly method
				node temp;
				String msg="";
				if(first==null)
				{
					JOptionPane.showMessageDialog(contentPane, "display not possible");
				}
				else if(first.link==null)
				{
				   display.setText(first.data+" ");
					
				}
				else
				{
					temp=first;
					while(temp!=null)
					{
						msg=msg+" "+temp.data;
						temp=temp.link;
					}
					display.setText(msg);
				}
				
			}
		});
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnDisplay);
		
		display = new JTextField();
		display.setBounds(369, 417, 173, 24);
		display.setColumns(10);
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
		btnNewButton_1.setBounds(675, 417, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\images (5).jpeg"));
		lblNewLabel_1.setBounds(0, 0, 849, 477);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\91917\\Downloads\\images (4).jpeg"));
		lblNewLabel_2.setBounds(0, 0, 831, 459);
		contentPane.add(lblNewLabel_2);
	}
}
