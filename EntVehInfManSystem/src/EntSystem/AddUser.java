package EntSystem;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AddUser extends JFrame implements ActionListener{

	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	Container content = this.getContentPane();
	JButton b = new JButton("ȷ��");
	JButton b1 = new JButton("ȡ��");
	JTextField userName = new JTextField(20);
	JPasswordField password = new JPasswordField(20);
	JLabel J1 = new JLabel("�û���");
	JLabel J2 = new JLabel(" ����   ");
	public AddUser(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		setTitle("ע��");
		jp1.add(J1);
		jp1.add(userName);
		jp2.add(J2);
		jp2.add(password);
		jp3.add(b);
		jp3.add(b1);
		content.add(jp1,BorderLayout.NORTH);
		content.add(jp2,BorderLayout.CENTER);
		content.add(jp3,BorderLayout.SOUTH);
		b.addActionListener(this);
		b1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==b){
			String[] v = new String[5];
			InfoUserBase isb = new InfoUserBase();
			v = isb.InfoSearNum(userName.getText());
			if(v==null){
				String password1 = new String(password.getPassword());
				isb.addUserInf(userName.getText(),password1);
				this.dispose();
				AddUser as = new AddUser();
				JOptionPane.showMessageDialog(null, "ע��ɹ�","�ɹ�",JOptionPane.INFORMATION_MESSAGE);
				as.pack();
				as.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "���û��Ѵ���","����",JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				AddUser as = new AddUser();
				as.pack();
				as.setVisible(true);
			}
		}
		else{
			this.dispose();
		}
	}
	
}
