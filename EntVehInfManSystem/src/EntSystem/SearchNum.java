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

public class SearchNum extends JFrame implements ActionListener{
	JPanel jp1 = new JPanel();
	JPanel jp2 = new JPanel();
	Container content = this.getContentPane();
	JTextField number = new JTextField(15);
	JLabel lnumber = new JLabel("工号");
	JButton OK = new JButton("确定");
	JButton NOT = new JButton("取消");
	public SearchNum(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		try
		{
			this.setTitle("工号查询员工");
			jp1.add(lnumber);
			jp1.add(number);
			jp2.add(OK);
			jp2.add(NOT);
			content.add(jp1,BorderLayout.NORTH);
			content.add(jp2,BorderLayout.SOUTH);
			OK.addActionListener(this);
			NOT.addActionListener(this);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e){
		Object obj = e.getSource();
		if(obj==OK)
		{
			InfoStaBase isb = new InfoStaBase();
			String s[] = isb.InfoSearNum(number.getText());
			if(s!=null)
			{
				SearchInfoStafPane sip = new SearchInfoStafPane(s[0], s[1], s[2], s[3]);
				sip.pack();
				sip.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(null, "查询失败","错误",JOptionPane.ERROR_MESSAGE);
		}
		else if(obj==NOT){
			this.dispose();
		}
	}
}
