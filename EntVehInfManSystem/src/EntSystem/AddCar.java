package EntSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.applet.*;
public class AddCar extends JFrame implements ActionListener{ 
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	JPanel jp4 = new JPanel();
	Container content = this.getContentPane();
	JTextField plnumber = new JTextField(15);
	JTextField type = new JTextField(15);
	JTextField bebo = new JTextField(15);
	JLabel lplnumber = new JLabel("���ƺ�");
	JLabel ltype = new JLabel("Ʒ��");
	JLabel lbebo = new JLabel("�Ƿ��ѱ���");
	JButton OK = new JButton("ȷ��");
	JButton NOT = new JButton("ȡ��");
	public AddCar(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("���ӳ���");
			jp1.add(lplnumber);
			jp1.add(plnumber);
			jp2.add(ltype);
			jp2.add(type);
			jp2.add(lbebo);
			jp2.add(bebo);
			jp4.add(OK);
			jp4.add(NOT);
			content.add(jp1,BorderLayout.NORTH);
			content.add(jp2);
			content.add(jp4,BorderLayout.SOUTH);
			OK.addActionListener(this);
			NOT.addActionListener(this);
			lplnumber.setVisible(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==OK)
		{
			String[] v = new String[5];
			InfoCarBase isb = new InfoCarBase();
			v = isb.InfoSearPlnum(plnumber.getText());
			if(v==null){
				isb.addCarInf(plnumber.getText(),type.getText(),bebo.getText());
				this.dispose();
				AddCar ac = new AddCar();
				JOptionPane.showMessageDialog(null, "���ӳɹ�","�ɹ�",JOptionPane.INFORMATION_MESSAGE);
				ac.pack();
				ac.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "�˳��ƺ��Ѵ���","����",JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				AddCar ac = new AddCar();
				ac.pack();
				ac.setVisible(true);
			}
		}
		if(obj==NOT)
		{
			this.dispose();
		}
	}
}
