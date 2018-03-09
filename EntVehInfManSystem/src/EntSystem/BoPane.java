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
	//�賵����
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	Container content = this.getContentPane();
	JTextField number = new JTextField(15);
	JTextField name = new JTextField(15);
	JTextField plnumber = new JTextField(15);
	JTextField bocarday = new JTextField(15);
	JLabel lnumber = new JLabel("����");
	JLabel lname = new JLabel("����");
	JLabel lplnumber = new JLabel("���ƺ�");
	JLabel lbocarday = new JLabel("�賵����");
	JButton OK = new JButton("ȷ��");
	JButton NOT = new JButton("ȡ��");
	public BoPane(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("�賵");
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
				if(!s[2].equals("��")&&!s1[4].equals("��")){
					AddBoInf abi = new AddBoInf(number.getText(),name.getText(),plnumber.getText(),bocarday.getText());
					JOptionPane.showMessageDialog(null, "��ӳɹ�","�ɹ�",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(s[2].equals("��")&&!s1[4].equals("��"))
				{
					JOptionPane.showMessageDialog(null, "���ʧ��","���ѱ���",JOptionPane.ERROR_MESSAGE);
				}
				else if(s1[4].equals("��")&&!s[2].equals("��"))
				{
					JOptionPane.showMessageDialog(null, "���ʧ��","���Ȼ���",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "���ʧ��","���鹤�źͳ��ƺ�",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(obj==NOT){
			this.dispose();
		}
	}
}
