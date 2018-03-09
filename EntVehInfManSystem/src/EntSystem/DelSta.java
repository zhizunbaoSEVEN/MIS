package EntSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class DelSta extends JFrame implements ActionListener{
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	Container content = this.getContentPane();
	JTextField number = new JTextField(15);
	JTextField name = new JTextField(15);
	JTextField sex = new JTextField(15);
	JTextField age = new JTextField(15);
	JLabel lnumber = new JLabel("工号");
	JLabel lname = new JLabel("姓名");
	JLabel lsex = new JLabel("性别");
	JLabel lage = new JLabel("年龄");
	JButton j1 = new JButton("工号查询");
	JButton j2 = new JButton("删除");
	JButton NOT = new JButton("取消");
	public DelSta(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("删除员工");
			number.setText("请查询工号");
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
			SureDel isb1 = new SureDel(number.getText(),1);
			isb1.pack();
			isb1.setVisible(true);
		}
		else if(obj==j1){
			InfoStaBase isb3 = new InfoStaBase();
			String[] s = isb3.InfoSearNum(number.getText());
			if(s==null){
				JOptionPane.showMessageDialog(null, "记录不存在");
				number.setText("请查询工号");
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
