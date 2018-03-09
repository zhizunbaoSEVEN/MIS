package EntSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class EditSta extends JFrame implements ActionListener{
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
	JButton j1 = new JButton("���Ų�ѯ");
	JButton j2 = new JButton("�޸�");
	JButton NOT = new JButton("ȡ��");
	public EditSta(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("�޸�Ա����Ϣ");
			number.setText("���ѯ����");
			jp1.add(lnumber);
			jp1.add(number);
			jp1.add(lname);
			jp1.add(name);
			jp2.add(lsex);
			jp2.add(sex);
			jp2.add(lage);
			jp2.add(age);
			jp3.add(j1);
			jp3.add(j2);
			jp3.add(NOT);
			content.add(jp1,BorderLayout.NORTH);
			content.add(jp2,BorderLayout.CENTER);
			content.add(jp3,BorderLayout.SOUTH);
			j1.addActionListener(this);
			j2.addActionListener(this);
			NOT.addActionListener(this);
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==j2){
			InfoStaBase isb2 = new InfoStaBase();
			int a = isb2.InfoSearNum1(number.getText());
			isb2.editStaInf(a,number.getText(), name.getText(), sex.getText(), age.getText());
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�","�ɹ�",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(obj==j1){
			InfoStaBase isb3 = new InfoStaBase();
			String[] s = isb3.InfoSearNum(number.getText());
			if(s==null){
				JOptionPane.showMessageDialog(null, "��¼������");
				number.setText("���ѯ����");
				name.setText("");
				sex.setText("");
				age.setText("");
			}
			else{
				number.setText(s[0]);
				name.setText(s[1]);
				sex.setText(s[2]);
				age.setText(s[3]);
			}
		}
		else if(obj==NOT){
			this.dispose();
		}
	}
}
