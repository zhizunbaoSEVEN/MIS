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

public class RePane extends JFrame implements ActionListener{
	//��������
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	Container content = this.getContentPane();
	JTextField number = new JTextField(15);
	JTextField name = new JTextField(15);
	JTextField plnumber = new JTextField(15);
	JTextField recarday = new JTextField(15);
	JLabel lnumber = new JLabel("����");
	JLabel lname = new JLabel("����");
	JLabel lplnumber = new JLabel("���ƺ�");
	JLabel lrecarday = new JLabel("��������");
	JButton OK = new JButton("ȷ��");
	JButton NOT = new JButton("ȡ��");
	public RePane(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("����");
			jp1.add(lnumber);
			jp1.add(number);
			jp1.add(lname);
			jp1.add(name);
			jp2.add(lplnumber);
			jp2.add(plnumber);
			jp2.add(lrecarday);
			jp2.add(recarday);
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
				if(s[2].equals("��")&&s1[4].equals("��")){
					AddReInf ari = new AddReInf(number.getText(),name.getText(),plnumber.getText(),recarday.getText());
					JOptionPane.showMessageDialog(null, "�ɹ�","�ɹ�",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(s1[4].equals("��"))
				{
					JOptionPane.showMessageDialog(null, "ʧ��","���Ƚ賵",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ʧ��","���鹤�źͳ��ƺ�",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(obj==NOT){
			this.dispose();
		}
	}
}
