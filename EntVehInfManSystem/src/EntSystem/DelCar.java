package EntSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class DelCar extends JFrame implements ActionListener{
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	Container content = this.getContentPane();
	JTextField plnumber = new JTextField(15);
	JTextField type = new JTextField(15);
	JLabel lplnumber = new JLabel("���ƺ�");
	JLabel ltype = new JLabel("Ʒ��");
	JButton j1 = new JButton("���ƺŲ�ѯ");
	JButton j2 = new JButton("ɾ��");
	JButton NOT = new JButton("ȡ��");
	public DelCar(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("ɾ������");
			plnumber.setText("���ѯ���ƺ�");
			jp1.add(lplnumber);
			jp1.add(plnumber);
			jp1.add(ltype);
			jp1.add(type);
			jp2.add(j1);
			jp2.add(j2);
			jp2.add(NOT);
			content.add(jp1,BorderLayout.NORTH);
			content.add(jp2,BorderLayout.SOUTH);
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
			SureDel isb2 = new SureDel(plnumber.getText(),2);
			isb2.pack();
			isb2.setVisible(true);
		}
		else if(obj==j1){
			InfoCarBase isb3 = new InfoCarBase();
			String[] s = isb3.InfoSearPlnum(plnumber.getText());
			if(s==null){
				JOptionPane.showMessageDialog(null, "��¼������");
				plnumber.setText("���ѯ���ƺ�");
				type.setText("");
			}
			else{
				plnumber.setText(s[0]);
				type.setText(s[1]);
			}
		}
		else if(obj==NOT){
			this.dispose();
		}
	}
}
