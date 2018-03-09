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
import javax.swing.JTextField;

public class BoPane extends JFrame implements ActionListener{
	//借车界面
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	Container content = this.getContentPane();
	JTextField number = new JTextField(15);
	JTextField name = new JTextField(15);
	JTextField plnumber = new JTextField(15);
	JTextField bocarday = new JTextField(15);
	JLabel lnumber = new JLabel("工号");
	JLabel lname = new JLabel("姓名");
	JLabel lplnumber = new JLabel("车牌号");
	JLabel lbocarday = new JLabel("借车日期");
	JButton OK = new JButton("确定");
	JButton NOT = new JButton("取消");
	public BoPane(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("借车");
			jp1.add(lnumber);
			jp1.add(number);
			jp1.add(lname);
			jp1.add(name);
			jp2.add(lplnumber);
			jp2.add(plnumber);
			jp2.add(lbocarday);
			jp2.add(bocarday);
			jp3.add(OK);
			jp3.add(NOT);
			content.add(jp1,BorderLayout.NORTH);
			content.add(jp2,BorderLayout.CENTER);
			content.add(jp3,BorderLayout.SOUTH);
			OK.addActionListener(this);
			NOT.addActionListener(this);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==OK){
			InfoCarBase icb = new InfoCarBase();
			String[] s = icb.InfoSearPlnum(plnumber.getText());
			InfoStaBase isb = new InfoStaBase();
			String[] s1 = isb.InfoSearNum(number.getText());
			if(s!=null&&s1!=null){
				if(!s[2].equals("是")&&!s1[4].equals("是")){
					AddBoInf abi = new AddBoInf(number.getText(),name.getText(),plnumber.getText(),bocarday.getText());
					JOptionPane.showMessageDialog(null, "添加成功","成功",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(s[2].equals("是")&&!s1[4].equals("是"))
				{
					JOptionPane.showMessageDialog(null, "添加失败","车已被借",JOptionPane.ERROR_MESSAGE);
				}
				else if(s1[4].equals("是")&&!s[2].equals("是"))
				{
					JOptionPane.showMessageDialog(null, "添加失败","请先还车",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "添加失败","请检查工号和车牌号",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(obj==NOT){
			this.dispose();
		}
	}
}
