package EntSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.applet.*;
public class AddSta extends JFrame implements ActionListener{ 
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	Container content = this.getContentPane();
	JTextField number = new JTextField(15);
	JTextField name = new JTextField(15);
	JTextField sex = new JTextField(15);
	JTextField age = new JTextField(15);
	JLabel lnumber = new JLabel("����");
	JLabel lname = new JLabel("����");
	JLabel lsex = new JLabel("�Ա�");
	JLabel lage = new JLabel("����");
	JButton OK = new JButton("ȷ��");
	JButton NOT = new JButton("ȡ��");
	public AddSta(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("����Ա��");
			jp1.add(lnumber);
			jp1.add(number);
			jp1.add(lname);
			jp1.add(name);
			jp2.add(lsex);
			jp2.add(sex);
			jp2.add(lage);
			jp2.add(age);
			jp3.add(OK);
			jp3.add(NOT);
			content.add(jp1,BorderLayout.NORTH);
			content.add(jp2,BorderLayout.CENTER);
			content.add(jp3,BorderLayout.SOUTH);
			OK.addActionListener(this);
			NOT.addActionListener(this);
			lnumber.setVisible(true);
			lname.setVisible(true);
			lsex.setVisible(true);
			lage.setVisible(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==OK)
		{
			String[] v = new String[5];
			InfoStaBase isb = new InfoStaBase();
			v = isb.InfoSearNum(number.getText());
			if(v==null){
				isb.addStaInf(number.getText(),name.getText(),sex.getText(),age.getText());
				this.dispose();
				AddSta as = new AddSta();
				JOptionPane.showMessageDialog(null, "���ӳɹ�","�ɹ�",JOptionPane.INFORMATION_MESSAGE);
				as.pack();
				as.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "�˹����Ѵ���","����",JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				AddSta as = new AddSta();
				as.pack();
				as.setVisible(true);
			}
		}
		if(obj==NOT)
		{
			this.dispose();
		}
	}
}

